package com.wg.daonile.grim.constant;

import com.wg.daonile.app.DaoNiLeApp;

/**
 * App相关的一些常量
 * 
 * @author ke.wei.quan
 * @date 2015年3月31日
 *
 */
public class AppConstant {
	//服务器请求地址
	public static final String HOST = "http://58.96.170.28:8888/app-platform";
	public static final String GET_PUBLICKEY = HOST + "/guest/login/getPublicKey.json";
	public static final String GUEST_LOGIN =  HOST + "/guest/login.json";
	public static final String LOGIN =  HOST + "/guest/login.json";
	public static final String DEVICE_LOGIN =  HOST + "/admin/app/device/user/login.json";
	public static final String DEVICE_REGISTER =  HOST + "/admin/app/device/user/register.json";
	/**
	 * 屏幕相关
	 */
	public static final float DENSITY = DaoNiLeApp.getAppInstance().getResources().getDisplayMetrics().density;
	public static final float SCALESITY = DaoNiLeApp.getAppInstance().getResources().getDisplayMetrics().scaledDensity;
	public static final int WIDTHPX = DaoNiLeApp.getAppInstance().getResources().getDisplayMetrics().widthPixels;
	public static final int HEIGHTPX = DaoNiLeApp.getAppInstance().getResources().getDisplayMetrics().heightPixels;
	/** 日志打印tag */
	public static final String LOG_TAG = "DaoNiLeAppLogTag";
	/** 是否是第一次进入app */
	public static final boolean isFirstTimeEnterApp = true;

}
