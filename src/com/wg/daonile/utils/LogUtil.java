package com.wg.daonile.utils;

import com.wg.daonile.constant.AppConstant;

import android.util.Log;

/**
 * 日志打印工具
 * 
 * @author WEIGUANG
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class LogUtil {

	public static void v(String logString) {
		if (AppConstant.IS_DEBUG) {
			Log.v(AppConstant.LOG_TAG, logString);
		}
	}

	public static void d(String logString) {
		if (AppConstant.IS_DEBUG) {
			Log.d(AppConstant.LOG_TAG, logString);
		}
	}

	public static void i(String logString) {
		if (AppConstant.IS_DEBUG) {
			Log.i(AppConstant.LOG_TAG, logString);
		}
	}

	public static void w(String logString) {
		if (AppConstant.IS_DEBUG) {
			Log.w(AppConstant.LOG_TAG, logString);
		}
	}

	public static void e(String logString) {
		if (AppConstant.IS_DEBUG) {
			Log.e(AppConstant.LOG_TAG, logString);
		}
	}
}
