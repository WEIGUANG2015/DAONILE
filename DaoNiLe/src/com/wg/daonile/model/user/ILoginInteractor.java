package com.wg.daonile.model.user;

/**
 * 网站跟app登录的交互接口
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
 *
 */
public interface ILoginInteractor {
	// 请求服务器进行用户登录
	void onUserLoginListener(String userKey, String password, ILoginRequestCallback callback);
}

