package com.wg.daonile.grim.utils;

import java.io.InputStream;
import java.util.Properties;

import com.wg.daonile.app.DaoNiLeApp;

import android.content.res.AssetManager;

/**
 * 
 * 通用配置获取工具类
 * 
 * @author JUNLONG CHAN
 * @date 2015年4月14日
 * 
 */
public class ConfigFile {
	private static Properties prop = null;
	static {
		try {
			prop = new Properties();
			AssetManager am = DaoNiLeApp.getAppInstance().getAssets();
			InputStream is = am.open("config.properties");
			prop.load(is);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 是否打印Debug日志
	 * 
	 * @return
	 */
	public static boolean isOpenDebug() {
		return Boolean.valueOf(prop.get("is_debug").toString()).booleanValue();
	}

	/**
	 * 是否打印Verbose日志
	 * 
	 * @return
	 */
	public static boolean isOpenVerbose() {
		return Boolean.valueOf(prop.get("is_verbose").toString()).booleanValue();
	}

	/**
	 * 是否打印Info日志
	 * 
	 * @return
	 */
	public static boolean isOpenInfo() {
		return Boolean.valueOf(prop.get("is_info").toString()).booleanValue();
	}

	/**
	 * 是否打印Warn日志
	 * 
	 * @return
	 */
	public static boolean isOpenWarn() {
		return Boolean.valueOf(prop.get("is_warn").toString()).booleanValue();
	}

	/**
	 * 是否打印Error日志
	 * 
	 * @return
	 */
	public static boolean isOpenError() {
		return Boolean.valueOf(prop.get("is_error").toString()).booleanValue();
	}

	/**
	 * 是否打开全局异常收集器
	 * 
	 * @return
	 */
	public static boolean isCrashhandlerOpen() {
		return Boolean.valueOf(prop.get("is_crashhandler_open").toString()).booleanValue();
	}
}
