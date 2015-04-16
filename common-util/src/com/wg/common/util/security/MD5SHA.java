package com.wg.common.util.security;

import java.security.MessageDigest;

/**
 * MD5,SHA 加密算法
 * 
 * @author JUNLONG CHAN
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class MD5SHA {
	// MD5加码。32位, SHA-1加密。40位
	private static String encryp(String type, String key) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance(type);
			char[] charArray = key.toCharArray();
			byte[] byteArray = new byte[charArray.length];
			for (int i = 0; i < charArray.length; i++){
				byteArray[i] = (byte) charArray[i];
			}
			byte[] md5Bytes = messageDigest.digest(byteArray);
			StringBuffer hexValue = new StringBuffer();
			for (int i = 0; i < md5Bytes.length; i++) {
				int val = ((int) md5Bytes[i]) & 0xff;
				if (val < 16){
					hexValue.append("0");
				}
				hexValue.append(Integer.toHexString(val));
			}
			return hexValue.toString();
		} catch (Exception e) {
			return "";
		}
	}

	// MD5加码。32位, SHA-1加密。40位
	public static String Md5Sha(String key) {
		return encryp("MD5", encryp("SHA-1", key));
	}
}
