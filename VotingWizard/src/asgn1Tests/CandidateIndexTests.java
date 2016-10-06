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

import org.junit.Test;

import asgn1Election.CandidateIndex;

/**
 * @author Jesse Stanger
 *
 */
public class CandidateIndexTests {

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#inRange(int)}
	 */
	@Test
	public void testInRangeNegative() {
		assertFalse(CandidateIndex.inRange(-1));
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#inRange(int)}
	 */
	@Test
	public void testInRangeZero() {
		assertFalse(CandidateIndex.inRange(0));
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#inRange(int)}
	 */
	@Test
	public void testInRangeInRange() {
		assertTrue(CandidateIndex.inRange(1));
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#inRange(int)}
	 */
	@Test
	public void testInRangeOOB() {
		assertFalse(CandidateIndex.inRange(16));
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#CandidateIndex(int)}
	 */
	@Test
	public void testCandidateIndexDontTest() {
		assertTrue(true);
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#compareTo(asgn1Election.CandidateIndex)}
	 */
	@Test
	public void testCompareToLower() {
		CandidateIndex first = new CandidateIndex(1);
		CandidateIndex second = new CandidateIndex(2);
		assertTrue(first.compareTo(second) == -1);
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#compareTo(asgn1Election.CandidateIndex)}
	 */
	@Test
	public void testCompareToSame() {
		CandidateIndex second = new CandidateIndex(2);
		CandidateIndex secondDupe = new CandidateIndex(2);
		assertTrue(second.compareTo(secondDupe) == 0);
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#compareTo(asgn1Election.CandidateIndex)}
	 */
	@Test
	public void testCompareToHigher() {
		CandidateIndex first = new CandidateIndex(1);
		CandidateIndex second = new CandidateIndex(2);
		assertTrue(second.compareTo(first) == 1);
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#copy()}
	 */
	@Test
	public void testCopy() {
		CandidateIndex orig = new CandidateIndex(1);
		assertEquals("1", orig.copy().toString());
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#incrementIndex()}
	 */
	@Test
	public void testIncrementIndex() {
		CandidateIndex incIndex = new CandidateIndex(1);
		incIndex.incrementIndex();
		assertEquals("2", incIndex.toString());
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#setValue(int)}
	 */
	@Test
	public void testSetValueDontTest() {
		assertTrue(true);
	}

	/**
	 * Test method for 
	 * {@link asgn1Election.CandidateIndex#toString()}
	 */
	@Test
	public void testToStringDontTest() {
		assertTrue(true);
	}

}
