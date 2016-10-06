/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

import asgn1Election.CandidateIndex;
import asgn1Election.Vote;
import asgn1Election.VoteList;

/**
 * @author Jesse Stanger
 *
 */
public class VoteListTests {

	private Vote voteList;

	/**
	 * Test method for {@link asgn1Election.VoteList#VoteList(int)}
	 */
	@Before
	public void setUp() {
		voteList = new VoteList(5);
		voteList.addPref(1);
		voteList.addPref(5);
		voteList.addPref(4);
		voteList.addPref(2);
		voteList.addPref(3);
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#VoteList(int)}
	 */
	@Test
	public void testVoteList() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#addPref(int)}
	 */
	@Test
	public void testAddPref() {
		assertFalse(voteList.addPref(6));
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#copyVote()}
	 */
	@Test
	public void testCopyVote() {
		Vote copy = voteList.copyVote();
		assertEquals("1 5 4 2 3 ", copy.toString());
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#getPreference(int)}
	 */
	@Test
	public void testGetPreference() {
		CandidateIndex cand = voteList.getPreference(5);
		assertEquals("2", cand.toString());
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#getPreference(int)}
	 */
	@Test
	public void testGetPreferenceNegative() {
		CandidateIndex cand = voteList.getPreference(-1);
		assertEquals(0, cand.compareTo(new CandidateIndex(0)));
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#getPreference(int)}
	 */
	@Test
	public void testGetPreferenceOOB() {
		CandidateIndex cand = voteList.getPreference(6);
		assertEquals(0, cand.compareTo(new CandidateIndex(0)));
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#invertVote()}
	 */
	@Test
	public void testInvertVote() {
		Vote inverted = voteList.invertVote();
		assertEquals("1 4 5 3 2 ", inverted.toString());
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#iterator()}
	 */
	@Test
	public void testIterator() {
		assertNotNull(voteList.iterator());
	}

	/**
	 * Test method for {@link asgn1Election.VoteList#toString()}
	 */
	@Test
	public void testToString() {
		assertTrue(true);
	}

}
