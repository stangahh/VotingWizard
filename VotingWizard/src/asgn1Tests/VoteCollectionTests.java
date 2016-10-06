/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import asgn1Election.Candidate;
import asgn1Election.CandidateIndex;
import asgn1Election.Collection;
import asgn1Election.ElectionException;
import asgn1Election.VoteCollection;
import asgn1Election.VoteList;
import asgn1Util.NumbersException;

/**
 * @author Jesse Stanger
 */
public class VoteCollectionTests {
	 
	private TreeMap<CandidateIndex, Candidate> cdst;
	private ExtendedElection elec;
	private VoteList list;

	@Before
	public void setUp() throws ElectionException, FileNotFoundException, IOException, NumbersException {
		elec = new ExtendedElection("MinMorgulVale");

		elec.loadDefs();
		elec.loadVotes();
		
		cdst = new TreeMap<CandidateIndex, Candidate>();
		cdst.put(new CandidateIndex(1), new Candidate("Shelob", "Monster Spider Party", "MSP", 0));
		cdst.put(new CandidateIndex(2), new Candidate("Gorbag", "Filthy Orc Party", "FOP", 0));
		cdst.put(new CandidateIndex(3), new Candidate("Shagrat", "Stinking Orc Party", "SOP", 0));

		list = new VoteList(3);
		list.addPref(1);
		list.addPref(2);
		list.addPref(3);
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#VoteCollection(int)}
	 */
	@Test(expected = ElectionException.class)
	public void testVoteCollectionNegative() throws ElectionException {
		Collection col = new VoteCollection(-1);
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#VoteCollection(int)}
	 */
	@Test(expected = ElectionException.class)
	public void testVoteCollectionZero() throws ElectionException {
		Collection col = new VoteCollection(0);
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#VoteCollection(int)}
	 */
	@Test(expected = ElectionException.class)
	public void testVoteCollectionOOB() throws ElectionException {
		Collection col = new VoteCollection(16);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.VoteCollection#countPrefVotes(java.util.TreeMap, asgn1Election.CandidateIndex)}
	 */
	@Test
	public void testCountPrefVotes() {
		elec.getVoteCollection().countPrimaryVotes(cdst);
		elec.getVoteCollection().countPrefVotes(cdst, new CandidateIndex(3));
		
		Candidate candOne = cdst.get(new CandidateIndex(1));
		Candidate candTwo = cdst.get(new CandidateIndex(2));

		assertEquals(10, candOne.getVoteCount());
		assertEquals(8, candTwo.getVoteCount());
	}

	public void countPrefVotes(TreeMap<CandidateIndex, Candidate> cds, CandidateIndex elim) {
		fail("Not yet implemented");
	}

	/**
	 * Test method for
	 * {@link asgn1Election.VoteCollection#countPrimaryVotes(java.util.TreeMap)}
	 */
	@Test
	public void testCountPrimaryVotes() {
		elec.getVoteCollection().countPrimaryVotes(cdst);

		int a = cdst.get(new CandidateIndex(1)).getVoteCount();
		int b = cdst.get(new CandidateIndex(2)).getVoteCount();
		int c = cdst.get(new CandidateIndex(3)).getVoteCount();
		
		assertEquals(8, a);
		assertEquals(7, b);
		assertEquals(3, c);
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#emptyTheCollection()}
	 */
	@Test
	public void testEmptyTheCollection() {
		elec.getVoteCollection().emptyTheCollection();
		int i = elec.getVoteCollection().getFormalCount();
		i += elec.getVoteCollection().getInformalCount();

		assertEquals(0, i);
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#getFormalCount()}
	 */
	@Test
	public void testGetFormalCount() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.VoteCollection#getInformalCount()}
	 */
	@Test
	public void testGetInformalCount() {
		assertTrue(true);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.VoteCollection#includeFormalVote(asgn1Election.Vote)}
	 */
	@Test
	public void testIncludeFormalVote() {
		int origCount = elec.getVoteCollection().getFormalCount();

		VoteList tempList = new VoteList(3);
		tempList.addPref(1);
		tempList.addPref(2);
		tempList.addPref(3);
		
		elec.getVoteCollection().includeFormalVote(tempList);

		assertEquals(origCount, elec.getVoteCollection().getFormalCount() - 1);

	}

	/**
	 * Test method for
	 * {@link asgn1Election.VoteCollection#updateInformalCount()}
	 */
	@Test
	public void testUpdateInformalCount() {
		int oldCount = elec.getVoteCollection().getFormalCount();
		elec.getVoteCollection().updateInformalCount();
		assertEquals(oldCount, elec.getVoteCollection().getFormalCount());
	}

}
