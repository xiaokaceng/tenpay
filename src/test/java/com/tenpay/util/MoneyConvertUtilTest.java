package com.tenpay.util;

import static org.junit.Assert.*;

import org.junit.Test;

public class MoneyConvertUtilTest {

	private static final String POINT = "12345";
	private static final String POINT2 = "23456";
	private static final String POINT3 = "1";
	private static final String POINT4 = "12";
	private static final String POINT5 = "123";
	
	private static final String UNIT = "123.45";
	private static final String UNIT2 = "345.678";
	private static final String UNIT3 = "0.01";
	
	@Test
	public void testToUnitAndTwoDecimal() {
		assertEquals((Double) 123.45, (Double) MoneyConvertUtil.convertPointToUnit(POINT));
	}

	@Test
	public void testToUnitAndTwoDecimal2() {
		assertEquals((Double) 234.56, (Double) MoneyConvertUtil.convertPointToUnit(POINT2));
	}
	
	@Test
	public void testToUnitAndTwoDecimal3() {
		assertEquals((Double) 0.01, (Double) MoneyConvertUtil.convertPointToUnit(POINT3));
	}
	
	@Test
	public void testToUnitAndTwoDecimal4() {
		assertEquals((Double) 0.12, (Double) MoneyConvertUtil.convertPointToUnit(POINT4));
	}
	
	@Test
	public void testToUnitAndTwoDecimal5() {
		assertEquals((Double) 1.23, (Double) MoneyConvertUtil.convertPointToUnit(POINT5));
	}
	
	@Test
	public void testConvertUnitToPoint() {
		assertEquals("12345", MoneyConvertUtil.convertUnitToPoint(UNIT));
	}
	
	@Test
	public void testConvertUnitToPoint2() {
		assertEquals("34567", MoneyConvertUtil.convertUnitToPoint(UNIT2));
		System.out.println(MoneyConvertUtil.convertUnitToPoint("4.85"));
	}
	
	@Test
	public void testConvertUnitToPoint3() {
		assertEquals("1", MoneyConvertUtil.convertUnitToPoint(UNIT3));
	}
	
	
}
