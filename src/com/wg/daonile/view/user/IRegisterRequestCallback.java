package com.wg.daonile.view.user;

/**
 * 用户注册回调接口
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate
 * @version 1.0
 *
 */
public interface IRegisterRequestCallback {
	/**
	 * 注册失败
	 * @param errMsg
	 */
	void onRegisterFail(String errMsg);
	
	/**
	 * 注册成功
	 */
	void onRegisterSuccess();
}
