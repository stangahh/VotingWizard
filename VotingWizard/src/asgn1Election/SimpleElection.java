/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Election;


import asgn1Util.Strings;

/**
 * 
 * Subclass of <code>Election</code>, specialised to simple, first past the post
 * voting
 * 
 * @author James Hogan, Jesse Stanger
 * @version 1.0
 */
public class SimpleElection extends Election {

	/**
	 * Simple Constructor for <code>SimpleElection</code>, takes name and also
	 * sets the election type internally.
	 * @param name <code>String</code> containing the Election name
	 */
	public SimpleElection(String name) {
		super(name);
		this.type = Election.SimpleVoting;
	}

	/*
	 * (non-Javadoc)
	 * @see asgn1Election.Election#findWinner()
	 */
	@Override
	public String findWinner() {
		vc.countPrimaryVotes(cds);
		Candidate winner = clearWinner(0);
		
		String str = showResultHeader();
			str += "Counting primary votes; " + numCandidates + 
					" alternatives available\n";
			str += reportCountResult();
			str += reportWinner(winner);
			
		this.winner = winner;
		return str;
	}

	/*
	 * (non-Javadoc)
	 * @see asgn1Election.Election#isFormal(asgn1Election.Vote)
	 */
	@Override
	public boolean isFormal(Vote v) {
		boolean isFormal = false;
		boolean alreadyOne = false;
		
		for (int i : v) {
			if (i <= 0 || i > numCandidates) {
				return false;
			} else if (i == 1) {
				if (alreadyOne == false ) {
					alreadyOne = true;
					isFormal = true;
				} else {
					isFormal = false;
				}
			}
		}
		return isFormal;
	}

	/*
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = this.name + " - Simple Voting";
		return str;
	}

	// Protected and Private/helper methods below///

	/*
	 * (non-Javadoc)
	 * @see asgn1Election.Election#clearWinner(int)
	 */
	@Override
	protected Candidate clearWinner(int wVotes) {
		Candidate temp = cds.firstEntry().getValue();

		for (Candidate cand : cds.values()) {
			if (temp.getVoteCount() < cand.getVoteCount()) {
				temp = cand;
			}
		}

		return temp;
	}

	/**
	 * Helper method to create a string reporting the count result
	 * @return <code>String</code> containing summary of the count
	 */
	private String reportCountResult() {
		String str = "\nSimple election: " + this.name + "\n\n" + candidateVoteSummary() + "\n";
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
	
}