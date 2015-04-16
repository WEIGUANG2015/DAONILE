package com.wg.daonile.model.guest;

/**
 * 获取访问服务器接口权限
 * 
 * @author JUNLONG CHAN
 * @date 2015-4-15
 * @version 1.0
 * 
 */
public interface IGuestInteractor {

	/**
	 * 请求服务器获取公钥
	 * 
	 * @param callback
	 *            回调
	 */
	void getPublicKeyListener(IGuestRequestCallback callback);

	/**
	 * 登陆服务器
	 * 
	 * @param callback
	 *            回调
	 */
	void onServerLoginListener(String key, IGuestRequestCallback callback);
}
