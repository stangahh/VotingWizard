/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Tests;


import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.FileNotFoundException;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import asgn1Election.ElectionException;
import asgn1Election.VoteCollection;
import asgn1Election.VoteList;
import asgn1Util.NumbersException;

/**
 * @author Jesse Stanger
 *
 */
public class PrefElectionTests {

	private ExtendedElection elec;
	private VoteList list;

	@Before
	public void setup() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		elec = new ExtendedElection("MorgulVale");
		
		list = new VoteList(5);
		
		elec.loadDefs();
		elec.loadVotes();
	}

	@Test
	public void testLoadVotesMorgulValeThirtyVotes() {
		VoteCollection vc = (VoteCollection) elec.getVoteCollection();
		assertTrue((vc.getFormalCount() == 30) && (vc.getInformalCount() == 0));
	}

	/**
	 * Test method for {@link asgn1Election.PrefElection#findWinner()}
	 */
	@Test
	public void testFindWinner() {
		fail("Not Yet Implemented");
//		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormal() {
		list.addPref(1);
		list.addPref(2);
		list.addPref(3);
		list.addPref(4);
		list.addPref(5);
		assertTrue(elec.isFormal(list));
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalOutOfOrder() {
		list.addPref(1);
		list.addPref(5);
		list.addPref(4);
		list.addPref(2);
		list.addPref(3);
		assertTrue(elec.isFormal(list));
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalZero() {
		list.addPref(0);
		assertFalse(elec.isFormal(list));
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalNegative() {
		list.addPref(-1);
		assertFalse(elec.isFormal(list));
	}
	
	/**
	 * Test method for {@link asgn1Election.PrefElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalOOB() {
		list.addPref(1);
		list.addPref(2);
		list.addPref(3);
		list.addPref(4);
		list.addPref(6);
		
		assertFalse(elec.isFormal(list));
	}

	/**
	 * Test method for {@link asgn1Election.PrefElection#clearWinner(int)}
	 */
	@Test
	public void testClearWinner() {
		assertTrue(true);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.PrefElection#PrefElection(java.lang.String)}
	 */
	@Test
	public void testPrefElection() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.PrefElection#toString()}
	 */
	@Test
	public void testToString() {
		assertTrue(true);
	}

}
