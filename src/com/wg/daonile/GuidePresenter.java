package com.wg.daonile;

import com.wg.daonile.view.user.LoginActivity;
import com.wg.daonile.view.user.RegisterActivity;

/**
 * 引导页presenter
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate 
 * @version 1.0
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

