package com.wg.daonile.presenter.guest.impl;

import com.wg.daonile.model.guest.IGuestInteractor;
import com.wg.daonile.model.guest.IGuestRequestCallback;
import com.wg.daonile.model.guest.impl.GuestInteractor;
import com.wg.daonile.presenter.guest.IGuestLoginPresenter;
import com.wg.daonile.view.guest.IGuestView;
import com.wg.daonile.view.user.ILoginView;

/**
 * 服务器相关操作
 * 
 * @author JUNLONG CHAN
 * @date 2015-4-15
 * @version 1.0
 * 
 */
public class GuestLoginPresenter implements IGuestLoginPresenter, IGuestRequestCallback {
	private IGuestView mIGuestView;
	private IGuestInteractor mIGuestInteractor;

	public GuestLoginPresenter(IGuestView guestView) {
		mIGuestView = guestView;
		mIGuestInteractor = new GuestInteractor();
	}

	@Override
	public void getPublicKeyListener() {
		mIGuestView.showProgressDialog();
		mIGuestInteractor.getPublicKeyListener(this);
	}

	@Override
	public void getPublicKeyError(String msg) {
		mIGuestView.dissmissProgressDialog();
		mIGuestView.showToast(msg);
	}

	@Override
	public void getPublicKeySuccess(String key) {
		mIGuestInteractor.onServerLoginListener(key, this);
	}

	@Override
	public void loginServerError(String msg) {
		mIGuestView.dissmissProgressDialog();
		mIGuestView.showToast(msg);
	}

	@Override
	public void loginServerSuccess(String msg) {
		mIGuestView.dissmissProgressDialog();
		mIGuestView.notifyUserLogin();
	}

}
