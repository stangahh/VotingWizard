/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

import asgn1Election.Candidate;
import asgn1Election.ElectionException;

/**
 * @author Jesse Stanger
 */
public class CandidateTests {

	private final int INT_MAX = 2147483647;

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 */
	@Test
	public void testCandidate() {
		assertTrue(true);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionNullName() throws ElectionException {
		Candidate nullName = new Candidate(null, "Party", "LP", 0);

	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionNullParty() throws ElectionException {
		Candidate nullParty = new Candidate("Lame", null, "LP", 0);

	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionNullAbbrev() throws ElectionException {
		Candidate nullAbbrev = new Candidate("Lame", "Party", null, 0);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionEmptyName() throws ElectionException {
		Candidate emptyName = new Candidate("", "Party", "LP", 0);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionEmptyPart() throws ElectionException {
		Candidate emptyParty = new Candidate("Lame", "", "LP", 0);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionEmptyAbbrev() throws ElectionException {
		Candidate emptyAbbrev = new Candidate("Lame", "Party", "", 0);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateElectionExceptionVoteCountLessThanZero() throws ElectionException {
		Candidate votesLessThanZero = new Candidate("Lame", "Party", "LP", -1);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test
	public void testCandidateVoteCountZero() throws ElectionException {
		Candidate votesZero = new Candidate("Lame", "Party", "LP", 0);
		assert (votesZero.getVoteCount() == 0);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.Candidate#Candidate(java.lang.String, java.lang.String, java.lang.String, int)}
	 * @throws ElectionException
	 */
	@Test(expected = ElectionException.class)
	public void testCandidateMaxIntVoteCount() throws ElectionException {
		Candidate maxVote = new Candidate("Lame", "Party", "LP", INT_MAX);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#candidateListing()}
	 */
	@Test
	public void testCandidateListingDontTest() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#copy()}
	 * @throws ElectionException
	 */
	@Test
	public void testCopy() throws ElectionException {
		Candidate orig = new Candidate("Lame", "Party", "PTY", 0);
		Candidate copy = orig.copy();

		assertEquals(orig.getName(), copy.getName());
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#getName()}
	 */
	@Test
	public void testGetNameDontTest() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#getParty()}
	 */
	@Test
	public void testGetPartyDontTest() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#getVoteCount()}
	 */
	@Test
	public void testGetVoteCountDontTest() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#getVoteCountString()}
	 */
	@Test
	public void testGetVoteCountStringDontTest() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#incrementVoteCount()}
	 * @throws ElectionException
	 */
	@Test
	public void testIncrementVoteCount() throws ElectionException {
		Candidate incVote = new Candidate("Lame", "Party", "LP", 0);
		incVote.incrementVoteCount();
		assert (incVote.getVoteCount() == 1);
	}

	/**
	 * Test method for {@link asgn1Election.Candidate#toString()}
	 */
	@Test
	public void testToStringDontTest() {
		assertTrue(true);
	}

}
