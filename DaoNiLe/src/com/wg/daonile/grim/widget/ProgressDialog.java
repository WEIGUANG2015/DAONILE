package com.wg.daonile.grim.widget;

import com.wg.daonile.R;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;

/**
 * 进度条对话框
 * 
 * @author ke.wei.quan
 * @date 2015年4月7日
 *
 */
public class ProgressDialog extends Dialog {

	public ProgressDialog(Context context) {
		this(context, R.string.loading);
	}

	public ProgressDialog(Context context, String tips) {
		this(context, R.style.ProgressDialog);
	}

	public ProgressDialog(Context context, int tipsResId) {
		this(context, tipsResId, R.style.ProgressDialog);
	}

	public ProgressDialog(Context context, int tipsResId, int theme) {
		super(context, theme);
		this.setContentView(R.layout.widget_progress_dialog);
		// 设置居中
		this.getWindow().getAttributes().gravity = Gravity.CENTER;
		// 设置弹出对话框背景不变暗
		this.getWindow().getAttributes().dimAmount = 0.0f;
		// 设置不可点击取消
		this.setCancelable(false); 
	}

}
