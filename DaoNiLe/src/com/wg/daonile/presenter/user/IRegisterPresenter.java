package com.wg.daonile.presenter.user;

/**
 * 用户注册Presenter接口
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
 *
 */
public interface IRegisterPresenter {
	/**
	 * 点击返回按钮
	 */
	void onGoBackClickListener();

	/**
	 * 点击注册
	 * 
	 * @param userKey
	 * @param password
	 */
	void onRegisterClickListener(String userKey, String password);
}
