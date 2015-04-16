package com.wg.common.util.lang;


/**
 * 数组操作工具类
 * 
 * @author JUNLONG CHAN
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 * 
 */
public class ArrayUtil {

	/**
	 * 拼接数组为字符串
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static String join(String[] array) {
		StringBuilder sb = new StringBuilder();

		for (String e : array) {
			sb.append(",");
			sb.append(e);
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	/**
	 * 拼接数组为字符串
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static String join(int[] array) {
		StringBuilder sb = new StringBuilder();

		for (int e : array) {
			sb.append(",");
			sb.append(e);
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	/**
	 * 拼接数组为字符串
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static String join(long[] array) {
		StringBuilder sb = new StringBuilder();

		for (long e : array) {
			sb.append(",");
			sb.append(e);
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	/**
	 * 拼接数组为字符串
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static String join(double[] array) {
		StringBuilder sb = new StringBuilder();

		for (double e : array) {
			sb.append(",");
			sb.append(e);
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}

	/**
	 * 拼接数组为字符串
	 * 
	 * @param array
	 *            数组
	 * @return
	 */
	public static String join(Object[] array) {
		StringBuilder sb = new StringBuilder();

		for (Object e : array) {
			sb.append(",");
			sb.append(e);
		}
		if (sb.length() > 0) {
			sb.deleteCharAt(0);
		}

		return sb.toString();
	}
}
