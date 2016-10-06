/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Election;


import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 
 * <p>
 * Implementing class for the {@link asgn1Election.Vote} interface.
 * <code>Vote</code> should be implemented as some sort of <code>List</code>,
 * with <code>ArrayList<Integer></code> the default choice.
 * </p>
 * 
 * @author James Hogan, Jesse Stanger
 * @version 1.0
 */
public class VoteList implements Vote {
	/** Holds the information that comprises a single vote */
	private List<Integer> vote;

	/** Number of candidates in the election */
	private int numCandidates;

	/**
	 * <p>
	 * Simple Constructor for the <code>VoteList</code> class.
	 * <code>numCandidates</code> is known to be in range through check on
	 * <code>VoteCollection</code>.
	 * @param numCandidates <code>int</code> number of candidates competing for this seat.
	 */
	public VoteList(int numCandidates) {
		vote = new ArrayList<Integer>();
		this.numCandidates = numCandidates;
	}

	/**
	 * (non-Javadoc)
	 * @see asgn1Election.Vote#addPref(asgn1Election.CandidateIndex)
	 */
	@Override
	public boolean addPref(int index) {
		if (this.vote.size() == this.numCandidates) {
			return false;
		} else {
			this.vote.add(index);
			return true;
		}

	}

	/**
	 * (non-Javadoc)
	 * @see asgn1Election.Vote#copyVote()
	 */
	@Override
	public Vote copyVote() {
		Vote copiedVote = new VoteList(numCandidates);

		for (int i = 0; i < this.numCandidates; i++) {
			int value = vote.get(i);
			copiedVote.addPref(value);
		}

		return copiedVote;
	}

	/**
	 * (non-Javadoc)
	 * @see asgn1Election.Vote#getPreference(int)
	 */
	@Override
	public CandidateIndex getPreference(int cand) {
		// returns the preference of the parsed candidate
		// +1 to turn it into non-zero-based numbering
		CandidateIndex preference = new CandidateIndex(vote.indexOf(cand) + 1);

		return preference;
	}

	/**
	 * (non-Javadoc)
	 * @see asgn1Election.Vote#invertVote()
	 */
	@Override
	public Vote invertVote() {
		Vote invertedVote = new VoteList(numCandidates);

		for (int i = 1; i <= this.numCandidates; i++) {
			int add = vote.indexOf(i) + 1;
			invertedVote.addPref(add);
		}
		
		return invertedVote;
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Iterable#iterator()
	 */
	@Override
	public Iterator<Integer> iterator() {
		return this.vote.listIterator();
	}

	/**
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String str = "";
		for (Integer index : this.vote) {
			str += index.intValue() + " ";
		}
		
		return str;
	}
	
}