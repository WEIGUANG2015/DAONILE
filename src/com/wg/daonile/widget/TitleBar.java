package com.wg.daonile.widget;

import com.wg.daonile.R;
import com.wg.daonile.constant.AppConstant;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

/**
 * 类说明
 * 
 * @author WEIGUANG
 * @date 2015年4月1日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class TitleBar extends LinearLayout implements View.OnClickListener {

	public TitleBar(Context context) {
		this(context, null);
	}

	public TitleBar(Context context, AttributeSet attrs) {
		super(context, attrs);
		View child = LayoutInflater.from(context).inflate(R.layout.widget_title_bar, null);
		LayoutParams params = new LayoutParams(LayoutParams.MATCH_PARENT, (int) (50 * AppConstant.DENSITY));
		addView(child, params);
		init();
	}

	/**
	 * 初始化
	 */
	private void init() {
		initWidget();
	}

	private DrawableTextView mLefTextView;
	private DrawableTextView mCenterTextView;
	private DrawableTextView mRightTextView;

	/**
	 * 初始化界面控件
	 */
	private void initWidget() {
		mLefTextView = (DrawableTextView) findViewById(R.id.tv_title_bar_left);
		mLefTextView.setOnClickListener(this);
		mCenterTextView = (DrawableTextView) findViewById(R.id.tv_title_bar_center);
		mCenterTextView.setOnClickListener(this);
		mRightTextView = (DrawableTextView) findViewById(R.id.tv_title_bar_right);
		mRightTextView.setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		if (mTitleBarClickListener != null) {
			switch (v.getId()) {
			case R.id.tv_title_bar_left: // 左边点击
				mTitleBarClickListener.onLeftClickListener();
				break;

			case R.id.tv_title_bar_center: // 中间点击
				mTitleBarClickListener.onCenterClickListener();
				break;

			case R.id.tv_title_bar_right: // 右边点击
				mTitleBarClickListener.onRightClickListener();
				break;

			default:
				break;
			}
		}
	}

	/**
	 * 设置左边布局图片
	 * 
	 * @param text
	 */
	public void setLeftTextDrawable(int left) {
		mLefTextView.setCompoundDrawablesWithIntrinsicBounds(left, 0, 0, 0);
	}

	/**
	 * 设置左边布局文字
	 * 
	 * @param text
	 */
	public void setLeftText(int resId) {
		mLefTextView.setText(resId);
	}

	/**
	 * 设置左边布局文字
	 * 
	 * @param text
	 */
	public void setLeftText(CharSequence text) {
		mLefTextView.setText(text);
	}

	/**
	 * 设置中间布局左边的图片
	 * 
	 * @param text
	 */
	public void setCenterTextLeftDrawable(int left) {
		mCenterTextView.setCompoundDrawablesWithIntrinsicBounds(left, 0, 0, 0);
	}

	/**
	 * 设置中间布局右边的图片
	 * 
	 * @param text
	 */
	public void setCenterTextRightDrawable(int right) {
		mCenterTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, right, 0);
	}

	/**
	 * 设置中间布局文字
	 * 
	 * @param text
	 */
	public void setCenterText(int resId) {
		mCenterTextView.setText(resId);
	}

	/**
	 * 设置中间布局文字
	 * 
	 * @param text
	 */
	public void setCenterText(CharSequence text) {
		mCenterTextView.setText(text);
	}

	/**
	 * 设置右边布局右边的图片
	 * 
	 * @param text
	 */
	public void setRightTextRightDrawable(int right) {
		mRightTextView.setCompoundDrawablesWithIntrinsicBounds(0, 0, right, 0);
	}

	/**
	 * 设置右边布局文字
	 * 
	 * @param text
	 */
	public void setRightText(int resId) {
		mRightTextView.setText(resId);
	}

	/**
	 * 设置中右边布局文字
	 * 
	 * @param text
	 */
	public void setRightText(CharSequence text) {
		mRightTextView.setText(text);
	}

	public interface TitleBarClickListener {
		void onLeftClickListener();

		void onCenterClickListener();

		void onRightClickListener();
	}

	private TitleBarClickListener mTitleBarClickListener;

	public void setOnTitleBarClickListener(TitleBarClickListener titleBarClickListener) {
		mTitleBarClickListener = titleBarClickListener;
	}

}
