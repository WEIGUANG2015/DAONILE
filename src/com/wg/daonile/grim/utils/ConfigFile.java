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
	 * 是否打印日志
	 * 
	 * @return
	 */
	public static boolean isDebug() {
		return Boolean.valueOf(prop.get("is_debug").toString()).booleanValue();
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
