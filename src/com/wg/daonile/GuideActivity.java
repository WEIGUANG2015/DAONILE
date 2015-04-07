package com.wg.daonile;

import java.util.ArrayList;
import java.util.List;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;

import com.wg.daonile.eventbus.event.EfinishSelf;
import com.wg.daonile.view.base.BaseActivity;

import de.greenrobot.event.EventBus;

/**
 * app引导界面
 * 
 * @author WEIGUANG
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class GuideActivity extends BaseActivity implements IGuideView, View.OnClickListener {

	private Context mContext;
	private IGuidePresenter mIGuidePresenter;
	private EventBus mEventBus;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_guide);
		mContext = this;
		mEventBus = EventBus.getDefault();
		mEventBus.register(this);
		mIGuidePresenter = new GuidePresenter(this);
		super.onCreate(savedInstanceState);
	}

	private ViewPager mViewPager;
	private GuidePagerAdapter mAdapter;
	private List<View> mGuideViews;
	private Button mLoginButton;
	private Button mRegisterButton;

	/**
	 * 初始化界面控件
	 */
	@SuppressLint("InflateParams")
	@Override
	public void initWidgets() {
		mViewPager = (ViewPager) findViewById(R.id.vp_guide);
		mGuideViews = new ArrayList<>();
		for (int i = 0; i < mGuideViewCount; i++) {
			View itemView = LayoutInflater.from(mContext).inflate(R.layout.item_guide, null);
			ImageView imageView = (ImageView) itemView.findViewById(R.id.iv_guide);
			ViewStub viewStub = (ViewStub) itemView.findViewById(R.id.vs_login_register);
			switch (i) {
			case 0:
				imageView.setImageResource(R.drawable.a);
				break;

			case 1:
				imageView.setImageResource(R.drawable.b);
				break;

			case 2:
				imageView.setImageResource(R.drawable.c);
				viewStub.inflate();
				mLoginButton = (Button) itemView.findViewById(R.id.bt_login);
				mLoginButton.setOnClickListener(this);
				mRegisterButton = (Button) itemView.findViewById(R.id.bt_register);
				mRegisterButton.setOnClickListener(this);
				break;

			default:
				break;
			}
			mGuideViews.add(itemView);
		}

		mAdapter = new GuidePagerAdapter();
		mViewPager.setAdapter(mAdapter);
	}

	// 引导页的页数
	private final int mGuideViewCount = 3;

	class GuidePagerAdapter extends PagerAdapter {

		@Override
		public int getCount() {
			return mGuideViewCount;
		}

		@Override
		public void destroyItem(ViewGroup container, int position, Object object) {
			container.removeView(mGuideViews.get(position));
		}

		@Override
		public Object instantiateItem(ViewGroup container, int position) {
			View itemView = mGuideViews.get(position);
			container.addView(itemView, 0);
			return itemView;
		}

		@Override
		public boolean isViewFromObject(View arg0, Object arg1) {
			boolean result = arg0 == arg1;
			return result;
		}

	}

	@Override
	public void onClick(View v) {
		switch (v.getId()) {
		case R.id.bt_login: // 登录按钮
			mIGuidePresenter.onLoginClick();
			break;

		case R.id.bt_register: // 注册按钮
			mIGuidePresenter.onRegisterClick();
			break;

		default:
			break;
		}
	}

	/**
	 * {@link EventBus}事件接收
	 * 
	 * @param efinishSelf
	 */
	public void onEventMainThread(EfinishSelf efinishSelf) {
		this.finish();
	}

	@Override
	protected void onDestroy() {
		if (mEventBus != null) {
			mEventBus.unregister(this);
		}
		super.onDestroy();
	}

	@Override
	public void showProgressDialog() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void goToActivity(Class<?> cls) {
		if (cls != null) {
			Intent intent = new Intent(mContext, cls);
			startActivity(intent);
		}
	}

}
