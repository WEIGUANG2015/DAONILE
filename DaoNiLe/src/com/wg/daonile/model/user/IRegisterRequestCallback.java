package com.wg.daonile.model.user;

/**
 * 用户注册回调接口
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
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
