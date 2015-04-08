package com.wg.daonile.view.user;

/**
 * 网站跟app登录的交互接口
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate 
 * @version 1.0
 *
 */
public interface ILoginInteractor {
	// 请求服务器进行用户登录
	void onUserLoginListener(String userKey, String password, ILoginRequestCallback callback);
}

