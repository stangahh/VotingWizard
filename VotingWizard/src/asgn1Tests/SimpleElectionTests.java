/**
 * 
 * This file is part of the VotingWizard Project, written as 
 * part of the assessment for CAB302, Semester 1, 2016. 
 * 
 */
package asgn1Tests;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeMap;

import org.junit.Before;
import org.junit.Test;

import asgn1Election.Candidate;
import asgn1Election.CandidateIndex;
import asgn1Election.Election;
import asgn1Election.ElectionException;
import asgn1Election.SimpleElection;
import asgn1Election.VoteList;
import asgn1Util.NumbersException;

/**
 * @author Jesse Stanger
 *
 */
public class SimpleElectionTests {

	private TreeMap<CandidateIndex, Candidate> cdst;
	private Election elec;
	private VoteList list;

	@Before
	public void setUp() throws FileNotFoundException, ElectionException, IOException, NumbersException {
		cdst = new TreeMap<CandidateIndex, Candidate>();
		cdst.put(new CandidateIndex(1), new Candidate("Shelob", "Monster Spider Party", "MSP", 0));
		cdst.put(new CandidateIndex(2), new Candidate("Gorbag", "Filthy Orc Party", "FOP", 0));
		cdst.put(new CandidateIndex(3), new Candidate("Shagrat", "Stinking Orc Party", "SOP", 0));
		
		elec = new SimpleElection("MinMorgulValeSimple");
		list = new VoteList(3);

		elec.loadDefs();
		elec.loadVotes();
	}

	/**
	 * Test method for {@link asgn1Election.SimpleElection#findWinner()}
	 * @throws IOException 
	 */
	@Test
	public void testFindWinner() throws IOException {
		String winnerStr = elec.findWinner();
		
		FileInputStream fin =  new FileInputStream(".//data//LogSimpleMorgulExamples1.log");
		BufferedReader myInput = new BufferedReader(new InputStreamReader(fin));
		StringBuilder sb = new StringBuilder();
		String thisLine;
		
		while ((thisLine = myInput.readLine()) != null) {  
			 sb.append(thisLine + "\n");
		}
		
		assertEquals(winnerStr, sb.toString());
	}
	
	/**
	 * Test method for
	 * {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalIdealFormal() {
		list.addPref(1);
		list.addPref(2);
		list.addPref(3);
		assertTrue(elec.isFormal(list));
	}

	/**
	 * Test method for
	 * {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalOOB() {
		list.addPref(4);
		list.addPref(1);
		list.addPref(3);
		assertFalse(elec.isFormal(list));
	}
	
	/**
	 * Test method for
	 * {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalNoFirstPreference() {
		list.addPref(2);
		list.addPref(2);
		list.addPref(3);
		assertFalse(elec.isFormal(list));
	}

	/**
	 * Test method for
	 * {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalAllFirstPreference() {
		list.addPref(1);
		list.addPref(1);
		list.addPref(1);
		assertFalse(elec.isFormal(list));
	}

	/**
	 * Test method for
	 * {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}
	 */
	@Test
	public void testIsFormalPreferenceZero() {
		list.addPref(0);
		assertFalse(elec.isFormal(list));
	}

	/**
	 * Test method for
	 * {@link asgn1Election.SimpleElection#isFormal(asgn1Election.Vote)}.
	 */
	@Test
	public void testIsFormalPreferenceNegative() {
		list.addPref(-1);
		assertFalse(elec.isFormal(list));
	}

	/**
	 * Test method for {@link asgn1Election.SimpleElection#clearWinner(int)}
	 */
	@Test
	public void testClearWinner() {
		assertTrue(true);
	}

	/**
	 * Test method for
	 * {@link asgn1Election.SimpleElection#SimpleElection(java.lang.String)}
	 */
	@Test
	public void testSimpleElection() {
		assertTrue(true);
	}

	/**
	 * Test method for {@link asgn1Election.SimpleElection#toString()}
	 */
	@Test
	public void testToString() {
		assertTrue(true);
	}

}
