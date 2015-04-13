package com.wg.daonile.presenter.user.impl;

import com.wg.daonile.activity.MainFragmentActivity;
import com.wg.daonile.eventbus.event.EfinishSelf;
import com.wg.daonile.model.user.IRegisterRequestCallback;
import com.wg.daonile.model.user.impl.RegisterInteractor;
import com.wg.daonile.presenter.user.IRegisterPresenter;
import com.wg.daonile.view.user.IRegisterView;

/**
 * 注册presenter
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class RegisterPresenter implements IRegisterPresenter, IRegisterRequestCallback {
	private IRegisterView mRegisterView;
	private RegisterInteractor mRegisterInteractor;

	public RegisterPresenter(IRegisterView registerView) {
		mRegisterView = registerView;
		mRegisterInteractor = new RegisterInteractor();
	}

	@Override
	public void onRegisterClickListener(String userKey, String password) {
		mRegisterView.showProgressDialog();
		mRegisterInteractor.onUserRegisterListener(userKey, password, this); 
	}

	@Override
	public void onRegisterFail(String tips) {
		mRegisterView.dissmissProgressDialog();
		mRegisterView.showToast(tips); 
	}

	@Override
	public void onRegisterSuccess() {
		mRegisterView.dissmissProgressDialog();
		mRegisterView.publishFinishGuideViewEvent(new EfinishSelf());
		mRegisterView.goToActivity(MainFragmentActivity.class); 
		mRegisterView.finish();
	}

	@Override
	public void onGoBackClickListener() {
		mRegisterView.onGoBackClickListener();
	}
}
