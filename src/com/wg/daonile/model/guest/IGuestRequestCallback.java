package com.wg.daonile.model.guest;

/**
 * 服务器结果回调
 * 
 * @author JUNLONG CHAN
 * @date 2015-4-15
 * @lastModifyDate
 * @version 1.0
 * 
 */
public interface IGuestRequestCallback {

	/**
	 * 获取公钥失败
	 * 
	 * @param msg
	 *            失败提示
	 */
	void getPublicKeyError(String msg);

	/**
	 * 获取公钥成功
	 * 
	 * @param key
	 *            成功返回的key
	 */
	void getPublicKeySuccess(String key);

	/**
	 * 登陆服务器失败
	 * 
	 * @param msg
	 */
	void loginServerError(String msg);

	/**
	 * 登陆服务器成功
	 * 
	 * @param msg
	 */
	void loginServerSuccess(String msg);
}
