package com.wg.daonile.model.user;

/**
 * 网站跟app注册的交互接口
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
 *
 */
public interface IRegisterInteractor {
	// 请求服务器进行用户注册
	void onUserRegisterListener(String userKey, String password, IRegisterRequestCallback callback);
}

