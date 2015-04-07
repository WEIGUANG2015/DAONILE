package com.wg.daonile.constant;

import com.wg.daonile.DaoNiLeApp;

/**
 * App相关的一些常量
 * 
 * @author WEIGUANG
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 *
 */
public class AppConstant {
	/**
	 * 屏幕相关
	 */
	public static final float DENSITY = DaoNiLeApp.getAppInstance().getResources().getDisplayMetrics().density;
	public static final float SCALESITY = DaoNiLeApp.getAppInstance().getResources().getDisplayMetrics().scaledDensity;
	public static final int WIDTHPX = DaoNiLeApp.getAppInstance().getResources().getDisplayMetrics().widthPixels;
	public static final int HEIGHTPX = DaoNiLeApp.getAppInstance().getResources().getDisplayMetrics().heightPixels;
	/** 是否是debug环境 */
	public static final boolean IS_DEBUG = true;
	/** 是否是打开全局的异常收集器 */
	public static final boolean IS_CRASHHANDLER_OPEN = false;
	/** 日志打印tag */
	public static final String LOG_TAG = "DaoNiLeAppLogTag";
	/** 是否是第一次进入app */
	public static final boolean isFirstTimeEnterApp = true;

}
