package com.wg.daonile.grim.utils;

import com.wg.daonile.grim.constant.AppConstant;

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
		if (ConfigFile.isDebug()) {
			Log.v(AppConstant.LOG_TAG, logString);
		}
	}

	public static void d(String logString) {
		if (ConfigFile.isDebug()) {
			Log.d(AppConstant.LOG_TAG, logString);
		}
	}

	public static void i(String logString) {
		if (ConfigFile.isDebug()) {
			Log.i(AppConstant.LOG_TAG, logString);
		}
	}

	public static void w(String logString) {
		if (ConfigFile.isDebug()) {
			Log.w(AppConstant.LOG_TAG, logString);
		}
	}

	public static void e(String logString) {
		if (ConfigFile.isDebug()) {
			Log.e(AppConstant.LOG_TAG, logString);
		}
	}
}
