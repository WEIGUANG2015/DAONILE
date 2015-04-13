package com.wg.daonile.model.user;

/**
 * 登录请求回调接口
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate
 * @version 1.0
 *
 */
public interface ILoginRequestCallback {
	/**
	 * 登录失败
	 * @param errMsg
	 */
	void onLoginFail(String errMsg);
	
	/**
	 * 登录成功
	 */
	void onLoginSuccess();
}
