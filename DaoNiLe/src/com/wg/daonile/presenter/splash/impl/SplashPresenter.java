package com.wg.daonile.presenter.splash.impl;

import com.wg.daonile.activity.GuideActivity;
import com.wg.daonile.presenter.splash.ISplashPresenter;
import com.wg.daonile.view.splash.ISplashView;

/**
 * 启动页presenter
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
 *
 */
public class SplashPresenter implements ISplashPresenter {
	
	private ISplashView mSplashView;
	
	public SplashPresenter(ISplashView splashView) {
		mSplashView = splashView;
	}

	@Override
	public void onSplashDisplayFinishListener() {
		if (mSplashView != null) {
			mSplashView.goToActivity(GuideActivity.class); 
			mSplashView.finish();
		}
	}

}

