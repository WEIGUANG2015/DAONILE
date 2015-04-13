package com.wg.daonile.presenter.user;

/**
 * 用户登录Presenter接口
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate
 * @version 1.0
 *
 */
public interface ILoginPresenter {
	/**
	 * 点击返回按钮
	 */
	void onGoBackClickListener();

	/**
	 * 点击登录
	 * 
	 * @param userKey
	 * @param password
	 */
	void onLoginClickListener(String userKey, String password);
}
