package com.wg.daonile.presenter.splash.impl;

import com.wg.daonile.activity.LoginActivity;
import com.wg.daonile.activity.RegisterActivity;
import com.wg.daonile.presenter.splash.IGuidePresenter;
import com.wg.daonile.view.splash.IGuideView;

/**
 * 引导页presenter
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
 *
 */
public class GuidePresenter implements IGuidePresenter {
	
	private IGuideView mGuideView;
	public GuidePresenter(IGuideView guideView) {
		mGuideView = guideView;
	}

	@Override
	public void onLoginClick() {
		if (mGuideView != null) {
			mGuideView.goToActivity(LoginActivity.class);
		}
	}

	@Override
	public void onRegisterClick() {
		if (mGuideView != null) {
			mGuideView.goToActivity(RegisterActivity.class); 
		}
	}

}

