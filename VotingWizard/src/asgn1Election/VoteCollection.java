/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Election;

import java.util.ArrayList;
import java.util.TreeMap;

/**
 * 
 * <p>Class to manage a collection of <code>Vote</code>s as specified by the 
 * {@link asgn1Election.Collection} interface. This implementation is based on  
 * a <code>ArrayList<E></code> data structure to enable convenient additions to the 
 * list.</p>
 * 
 * <p>The private methods {@link #getPrimaryKey(Vote) } and 
 * {@link #getPrefthKey(Vote, TreeMap, int)} are crucial to your success. Some guidance 
 * is given for these methods through comments in situ, but this is generous, and well 
 * beyond what would be provided in real practice.</p>
 * 
 * <p>As before, please note the name clash between <code>asgn1Election.Collection</code>
 * and <code>java.util.Collection</code>. 
 * 
 * @author hogan
 *
 */
public class VoteCollection implements Collection {
	/** Holds all the votes in this seat */
	private ArrayList<Vote> voteList;

	/** Number of candidates competing for this seat */
	private int numCandidates;

	/** Number of formal votes read during the election and stored in the collection */
	private int formalCount;

	/** Number of invalid votes received during the election */
	private int informalCount;

	/**
	 * Simple Constructor for the <code>VoteCollection</code> class.
	 * Most information added through mutator methods. 
	 * 
	 * @param numCandidates <code>int</code> number of candidates competing for 
	 * this seat
	 * @throws ElectionException if <code>NOT inRange(numCandidates)</code>
	 */
	public VoteCollection(int numCandidates) throws ElectionException {
		
	}
	
	/* 
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Collection#countPrefVotes(java.util.TreeMap, asgn1Election.CandidateIndex)
	 */
	@Override
	public void countPrefVotes(TreeMap<CandidateIndex, Candidate> cds,
			CandidateIndex elim) {
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Collection#countPrimaryVotes(java.util.TreeMap)
	 */
	@Override
	public void countPrimaryVotes(TreeMap<CandidateIndex, Candidate> cds) {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Collection#emptyTheVoteList()
	 */
	@Override
	public void emptyTheCollection() {
		
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Collection#getFormalCount()
	 */
	@Override
	public int getFormalCount() {
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Collection#getInformalCount()
	 */
	@Override
	public int getInformalCount() {
		
	}

	
	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Collection#includeFormalVote(asgn1Election.Vote)
	 */
	@Override
	public void includeFormalVote(Vote v) {
	
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see asgn1Election.Collection#updateInformalCount()
	 */
	@Override
	public void updateInformalCount() {
		
	}
	
	/**
	 * 
	 * <p>Important helper method to find the candidate in the current vote 
	 * corresponding to a given preference. Ideally we seek the candidate who is 
	 * preference <emphasis>pref</emphasis>, but often some of the higher preferences
	 * for a given vote may already have been eliminated. So this method finds not 
	 * the <emphasis>pref-th</emphasis> candidate, but the pref-th 
	 * <emphasis>active</emphasis> candidate</p>
	 * 
	 * <p>You must therefore find a way to deal with the candidate set, to work out 
	 * which ones are still active and which aren't. This method is quite specific 
	 * to the preferential election and so does not get used for the simple ballot.</p>
	 * 
	 * @param v <code>Vote</code> to be examined to find the pref-th active candidate
	 * @param cds <code>TreeMap</code> set of all active candidates
	 * @param pref <code>int</code> specifies the preference we are looking for
	 * @return <code>(key = prefth preference still active) OR null</code>
	 * 
	 */
	private CandidateIndex getPrefthKey(Vote v,TreeMap<CandidateIndex, Candidate> cds, int pref) {

	}

	/**
	 * <p>Important helper method to find the first choice candidate in the current 
	 * vote. This is always undertaken prior to distribution of preferences and so it 
	 * is not necessary to test whether the candidate remains in the set.</p>
	 * 
	 * @param v <code>Vote</code> from which first pref is to be obtained
	 * @return <code>CandidateIndex</code> of the first preference candidate
	 */
	private CandidateIndex getPrimaryKey(Vote v) {
        
    }
}