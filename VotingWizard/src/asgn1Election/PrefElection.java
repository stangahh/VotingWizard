/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Election;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;

import asgn1Util.Strings;

/**
 * 
 * Subclass of <code>Election</code>, specialised to preferential, but not
 * optional preferential voting.
 * 
 * @author James Hogan, Jesse Stanger
 * @version 1.0
 */
public class PrefElection extends Election {

	/**
	 * Simple Constructor for <code>PrefElection</code>, takes name and also
	 * sets the election type internally.
	 * @param name <code>String</code> containing the Election name
	 */
	public PrefElection(String name) {
		super(name);
		this.type = Election.PrefVoting;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Election#findWinner()
	 */
	@Override
	public String findWinner() {
		CandidateIndex redistribute = selectLowestCandidate();
		vc.countPrefVotes(cds, redistribute);

		int votesToWin = (vc.getFormalCount() / 2) + 1;
		Candidate tempWinner = clearWinner(votesToWin);

		if (tempWinner == null) {
			int hiCount = 0;

			for (Candidate cand : cds.values()) {
				if (cand.getVoteCount() >= hiCount) {
					hiCount = cand.getVoteCount();
					tempWinner = cand;
				} else if (cand.getVoteCount() == hiCount) {
					// tie case
				}
			}

			tempWinner = winner;
			return reportCountStatus();

		} else {
			tempWinner = winner;
			return tempWinner.toString();
		}
	}

	/*
	 * (non-Javadoc)
	 * @see asgn1Election.Election#isFormal(asgn1Election.Vote)
	 */
	@Override
	public boolean isFormal(Vote v) {
		boolean formal = false;
		List<Integer> arr = new ArrayList<Integer>();

		for (int i = 1; i <= this.numCandidates; i++) {
			arr.add(i);
		}

		for (Integer index : v) {
			if (index <= 0 || index > numCandidates) {
				return false;
			} else {
				if (!arr.contains(index)) {
					formal = false;
				} else {
					arr.remove(index);
				}
			}
		}
		
		if (arr.size() == 0) {
			formal = true;
		}
		
		return formal;

	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = this.name + " - Preferential Voting";
		return str;
	}

	// Protected and Private/helper methods below///

	/*
	 * (non-Javadoc)
	 * @see asgn1Election.Election#clearWinner(int)
	 */
	@Override
	protected Candidate clearWinner(int winVotes) {
		for (Candidate cand : cds.values()) {
			if (cand.getVoteCount() > winVotes) {
				return cand;
			}
		}
		
		return null;
	}

	/**
	 * Helper method to create a preference distribution message for display
	 * @param c <code>Candidate</code> to be eliminated
	 * @return <code>String</code> containing preference distribution message
	 */
	private String prefDistMessage(Candidate c) {
		String str = "\nPreferences required: distributing " + c.getName() + ": " + c.getVoteCount() + " votes";
		return str;
	}

	/**
	 * Helper method to create a string reporting the count progress
	 * @return <code>String</code> containing count status
	 */
	private String reportCountStatus() {
		String str = "\nPreferential election: " + this.name + "\n\n" + candidateVoteSummary() + "\n";
		String inf = "Informal";
		String voteStr = "" + this.vc.getInformalCount();
		int length = ElectionManager.DisplayFieldWidth - inf.length() - voteStr.length();
		str += inf + Strings.createPadding(' ', length) + voteStr + "\n\n";

		String cast = "Votes Cast";
		voteStr = "" + this.numVotes;
		length = ElectionManager.DisplayFieldWidth - cast.length() - voteStr.length();
		str += cast + Strings.createPadding(' ', length) + voteStr + "\n\n";
		return str;
	}

	/**
	 * Helper method to select candidate with fewest votes
	 * @return <code>CandidateIndex</code> of candidate with fewest votes
	 */
	private CandidateIndex selectLowestCandidate() {
		int vc = numVotes;
		CandidateIndex tempCand = null;

		for (Entry<CandidateIndex, Candidate> entry : cds.entrySet()) {
			if (entry.getValue().getVoteCount() < vc) {
				vc = entry.getValue().getVoteCount();
				tempCand = entry.getKey();
			}
		}

		return tempCand;
	}

}