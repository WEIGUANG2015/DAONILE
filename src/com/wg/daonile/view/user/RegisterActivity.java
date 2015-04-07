package com.wg.daonile.view.user;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.wg.daonile.R;
import com.wg.daonile.eventbus.event.EfinishSelf;
import com.wg.daonile.view.base.BaseActivity;
import com.wg.daonile.widget.TitleBar;
import com.wg.daonile.widget.TitleBar.TitleBarClickListener;

import de.greenrobot.event.EventBus;

/**
 * 用户注册界面
 * 
 * @author WEIGUANG
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class RegisterActivity extends BaseActivity implements IRegisterView, OnClickListener, TitleBarClickListener {

	private Context mContext;
	private IRegisterPresenter mIRegisterPresenter;
	private EventBus mEventBus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_register);
		mContext = this;
		mEventBus = EventBus.getDefault();
		mIRegisterPresenter = new RegisterPresenter(this);
		super.onCreate(savedInstanceState);
	}

	private TitleBar mTitleBar;
	private EditText mUserKeyEditText;
	private EditText mPasswordEditText;
	private Button mRegisterButton;

	@Override
	public void initWidgets() {
		mTitleBar = (TitleBar) findViewById(R.id.tb_register);
		mTitleBar.setLeftText(R.string.go_back);
		mTitleBar.setLeftTextDrawable(R.drawable.ic_launcher);
		mTitleBar.setCenterText(R.string.user_register);
		mTitleBar.setOnTitleBarClickListener(this); 

		mUserKeyEditText = (EditText) findViewById(R.id.et_user_key);
		mPasswordEditText = (EditText) findViewById(R.id.et_user_password);

		mRegisterButton = (Button) findViewById(R.id.bt_register);
		mRegisterButton.setOnClickListener(this);
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
		case R.id.bt_register: // 点击注册
			String userKey = mUserKeyEditText.getText().toString();
			String password = mPasswordEditText.getText().toString();
			mIRegisterPresenter.onRegisterClickListener(userKey, password);
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
		mIRegisterPresenter.onGoBackClickListener();
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

}
