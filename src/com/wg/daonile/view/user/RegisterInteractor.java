package com.wg.daonile.view.user;

import android.text.TextUtils;

/**
 * 网站跟app注册的交互类
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class RegisterInteractor implements IRegisterInterator {

	@Override
	public void onUserRegisterListener(final String userKey, final String password, final IRegisterRequestCallback callback) {
		new android.os.Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if (callback != null) {
					if (TextUtils.isEmpty(userKey)) {
						callback.onRegisterFail("注册失败");
					} else {
						callback.onRegisterSuccess();
					}
				}
			}
		}, 2000);
	}

}