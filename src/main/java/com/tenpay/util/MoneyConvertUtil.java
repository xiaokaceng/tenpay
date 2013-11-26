package com.tenpay.util;

import java.text.DecimalFormat;

public class MoneyConvertUtil {

	/**
	 * 分转化为元，四舍五入保留两位小数
	 * 
	 * @param point
	 */
	public static double convertPointToUnit(String point) {
		double point2 = Double.parseDouble(pointToTwoDecimal(point));
		DecimalFormat df = new DecimalFormat("##.00");
		return Double.parseDouble(df.format(point2));
	}

	/**
	 * 元转化为分
	 * @param unit
	 * @return
	 */
	public static String convertUnitToPoint(String unit) {
		double tt = Double.valueOf(unit);
		double total = Double.valueOf(unit) * Double.valueOf("100.00");
		String monery = String.valueOf(total);
		return monery.substring(0, monery.indexOf("."));
	}

	/**
	 * 分转换为两位小数
	 * 
	 * @param point
	 * @return
	 */
	public static String pointToTwoDecimal(String point) {
		if (point.length() < 3) {
			String repair = "";
			for (int i = 0, count = 3 - point.length(); i < count; i++) {
				repair += "0";
			}
			point = repair + point;
		}
		return point.substring(0, point.length() - 2) + "." + point.substring(point.length() - 2);
	}
	
	public static void main(String[] args) {
		System.out.println(MoneyConvertUtil.convertUnitToPoint("4.15"));
	}

}
