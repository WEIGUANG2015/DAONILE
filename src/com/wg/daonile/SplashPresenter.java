package com.wg.daonile;

/**
 * 类说明
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
 * @lastModifyDate 
 * @version 1.0
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

