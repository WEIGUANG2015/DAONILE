package com.wg.daonile.view.user;

import com.wg.daonile.MainFragmentActivity;
import com.wg.daonile.eventbus.event.EfinishSelf;

/**
 * 登录presenter
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class LoginPresenter implements ILoginPresenter, ILoginRequestCallback {
	private ILoginView mLoginView;
	private LoginInteractor mLoginInteractor;

	public LoginPresenter(ILoginView loginView) {
		mLoginView = loginView;
		mLoginInteractor = new LoginInteractor();
	}

	@Override
	public void onLoginClickListener(String userKey, String password) {
		mLoginView.showProgressDialog();
		mLoginInteractor.onUserLoginListener(userKey, password, this);
	}

	@Override
	public void onLoginFail(String tips) {
		mLoginView.dissmissProgressDialog();
		mLoginView.showToast(tips);
	}

	@Override
	public void onLoginSuccess() {
		mLoginView.dissmissProgressDialog();
		mLoginView.publishFinishGuideViewEvent(new EfinishSelf());
		mLoginView.goToActivity(MainFragmentActivity.class);
		mLoginView.finish();
	}

	@Override
	public void onGoBackClickListener() {
		mLoginView.onGoBackClickListener();
	}
}
