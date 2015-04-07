package com.wg.daonile;

import com.wg.daonile.view.base.BaseActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.widget.ImageView;

/**
 * app启动页
 * 
 * @author WEIGUANG
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class SplashActivity extends BaseActivity implements ISplashView {

	private Context mContext;
	private ISplashPresenter mISplashPresenter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		setContentView(R.layout.activity_main);
		mContext = this;
		mISplashPresenter = new SplashPresenter(this);
		super.onCreate(savedInstanceState);
		displayViewAnimation();
	}

	private ImageView mSplashImageView; // 启动页

	/**
	 * 初始化界面控件
	 */
	@Override
	public void initWidgets() {
		mSplashImageView = (ImageView) findViewById(R.id.iv_splash);
	}

	// 动画延续时间，默认3s
	private long mDuration = 3000;
	// 渐变动画
	private AlphaAnimation mAlphaAnimation;

	/**
	 * 启动界面动画
	 */
	private void displayViewAnimation() {
		/**
		 * 初始化界面动画
		 */
		mAlphaAnimation = new AlphaAnimation(0.3f, 1.0f);
		mAlphaAnimation.setDuration(mDuration);
		// 设置动画
		mSplashImageView.setAnimation(mAlphaAnimation);
		mAlphaAnimation.setAnimationListener(new AnimationListener() {

			@Override
			public void onAnimationStart(Animation animation) {
			}

			@Override
			public void onAnimationRepeat(Animation animation) {
			}

			@Override
			public void onAnimationEnd(Animation animation) {
				mISplashPresenter.onSplashDisplayFinishListener();
			}
		});
	}

	@Override
	protected void onDestroy() {
		if (mAlphaAnimation != null) {
			mAlphaAnimation.cancel();
		}
		mSplashImageView.clearAnimation();
		super.onDestroy();
	}

	@Override
	public void goToActivity(Class<?> cls) {
		if (cls != null) {
			Intent intent = new Intent(mContext, cls);
			startActivity(intent);
		}
	}

	@Override
	public void releaseUIResource() {
		// TODO Auto-generated method stub
		
	}

}
