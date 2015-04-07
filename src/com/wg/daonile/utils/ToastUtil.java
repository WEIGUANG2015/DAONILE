package com.wg.daonile.utils;

import com.wg.daonile.DaoNiLeApp;

import android.widget.Toast;

/**
 * Toast工具类
 * 
 * @author WEIGUANG
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class ToastUtil {

	public static void show(String text) {
		Toast.makeText(DaoNiLeApp.getAppInstance(), text, Toast.LENGTH_SHORT).show();
	}

	public static void show(int text) {
		Toast.makeText(DaoNiLeApp.getAppInstance(), text, Toast.LENGTH_SHORT).show();
	}

	public static void show(CharSequence text) {
		Toast.makeText(DaoNiLeApp.getAppInstance(), text, Toast.LENGTH_SHORT).show();
	}
}
