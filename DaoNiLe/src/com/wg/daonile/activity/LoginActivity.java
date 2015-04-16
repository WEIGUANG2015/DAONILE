package com.wg.daonile.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.wg.common.util.cookie.PersistentCookieStore;
import com.wg.common.util.security.MD5SHA;
import com.wg.daonile.R;
import com.wg.daonile.app.DaoNiLeApp;
import com.wg.daonile.base.BaseActivity;
import com.wg.daonile.eventbus.event.EfinishSelf;
import com.wg.daonile.grim.widget.TitleBar;
import com.wg.daonile.grim.widget.TitleBar.TitleBarClickListener;
import com.wg.daonile.presenter.guest.IGuestLoginPresenter;
import com.wg.daonile.presenter.guest.impl.GuestLoginPresenter;
import com.wg.daonile.presenter.user.ILoginPresenter;
import com.wg.daonile.presenter.user.impl.LoginPresenter;
import com.wg.daonile.view.guest.IGuestView;
import com.wg.daonile.view.user.ILoginView;

import de.greenrobot.event.EventBus;

/**
 * 用户登录界面
 * 
 * @author ke.wei.quan
 * @date 2015年3月31日
 * 
 */
public class LoginActivity extends BaseActivity implements ILoginView, IGuestView, OnClickListener, TitleBarClickListener {

	private Context mContext;
	private ILoginPresenter mILoginPresenter;
	private IGuestLoginPresenter mIGuestLoginPresenter;
	private PersistentCookieStore persistentCookieStore;
	private EventBus mEventBus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_login);
		mContext = this;
		mEventBus = EventBus.getDefault();
		mILoginPresenter = new LoginPresenter(this);
		mIGuestLoginPresenter = new GuestLoginPresenter(this);
		persistentCookieStore = DaoNiLeApp.getPersistentCookie();
		super.onCreate(savedInstanceState);
	}

	private TitleBar mTitleBar;
	private EditText mUserKeyEditText;
	private EditText mPasswordEditText;
	private Button mLoginButton;

	@Override
	public void initWidgets() {
		mTitleBar = (TitleBar) findViewById(R.id.tb_login);
		mTitleBar.setLeftText(R.string.go_back);
		mTitleBar.setLeftTextDrawable(R.drawable.ic_launcher);
		mTitleBar.setCenterText(R.string.user_login);
		mTitleBar.setOnTitleBarClickListener(this);

		mUserKeyEditText = (EditText) findViewById(R.id.et_user_key);
		mPasswordEditText = (EditText) findViewById(R.id.et_user_password);

		mLoginButton = (Button) findViewById(R.id.bt_login);
		mLoginButton.setOnClickListener(this);
	}

	@Override
	public void goToActivity(Class<?> cls) {
		if (cls != null) {
			Intent intent = new Intent(mContext, cls);
			startActivity(intent);
		}
	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login: // 点击登录
			if (!(persistentCookieStore.getCookies().size() > 0)) {
				mIGuestLoginPresenter.getPublicKeyListener();
			} else {
				userLogin();
			}
			break;

		default:
			break;
		}
	}

	@Override
	public void onGoBackClickListener() {
		finish();
	}

	@Override
	public void onLeftClickListener() {
		mILoginPresenter.onGoBackClickListener();
	}

	@Override
	public void onCenterClickListener() {
	}

	@Override
	public void onRightClickListener() {
	}

	@Override
	public void publishFinishGuideViewEvent(EfinishSelf efinishSelf) {
		mEventBus.post(efinishSelf);
	}

	@Override
	public void releaseUIResource() {
		// TODO Auto-generated method stub

	}

	@Override
	protected void onDestroy() {
		if (mEventBus != null) {
			mEventBus.unregister(this);
		}
		super.onDestroy();
	}

	@Override
	public void notifyUserLogin() {
		userLogin();
	}

	/**
	 * 用户登陆
	 */
	public void userLogin() {
		String userName = mUserKeyEditText.getText().toString();
		String passWord = MD5SHA.Md5Sha(mPasswordEditText.getText().toString());
		mILoginPresenter.onLoginClickListener(userName, passWord);
	}
}
