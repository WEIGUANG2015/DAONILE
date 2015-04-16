package com.wg.daonile.model.user.impl;

import com.wg.common.util.lang.StringUtils;
import com.wg.daonile.model.user.ILoginInteractor;
import com.wg.daonile.model.user.ILoginRequestCallback;

/**
 * 网站跟app登录的交互类
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
 *
 */
public class LoginInteractor implements ILoginInteractor {

	@Override
	public void onUserLoginListener(final String userKey, final String password, final ILoginRequestCallback callback) {
		new android.os.Handler().postDelayed(new Runnable() {
			@Override
			public void run() {
				if (callback != null) {
					if (StringUtils.isBlank(userKey)) {
						callback.onLoginFail("用户名不能为空");
					} else if (StringUtils.isBlank(password)) {
						callback.onLoginFail("密码不能为空");
					} else {
						callback.onLoginSuccess();
					}
				}
			}
		}, 2000);
	}

}
