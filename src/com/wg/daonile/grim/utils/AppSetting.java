package com.wg.daonile.grim.utils;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.SharedPreferences.Editor;

import com.wg.daonile.app.DaoNiLeApp;

/**
 * 一些app的偏好设置，保存到SharedPreferences，单例模式
 * 
 * @author WEIGUANG
 * @date 2015年3月31日
 * @lastModifyDate
 * @version 1.0
 * 
 */
public class AppSetting {

	private final static String SHAREPREFERENCE_NAME = "DaoNiLeAppSettings";
	private static AppSetting sAppSetting;
	private static SharedPreferences sSharedPreferences;
	private static Editor sEditor;

	static {
		sSharedPreferences = DaoNiLeApp.getAppInstance().getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
	}

	AppSetting() {

	}

	public static AppSetting getInstance() {
		initPreferences();
		if (sAppSetting == null) {
			synchronized (AppSetting.class) {
				if (sAppSetting == null) {
					sAppSetting = new AppSetting();
				}
			}
		}
		return sAppSetting;
	}

	/**
	 * 初始化preference环境
	 */
	private static void initPreferences() {
		if (sSharedPreferences == null) {
			sSharedPreferences = DaoNiLeApp.getAppInstance().getSharedPreferences(SHAREPREFERENCE_NAME, Context.MODE_PRIVATE);
		}

		if (sEditor == null) {
			sEditor = sSharedPreferences.edit();
		}
	}

	/**
	 * 保存String类型的数据
	 * 
	 * @param key
	 * @param value
	 */
	public void saveStringPreferencesByKey(String key, String value) {
		sEditor.putString(key, value);
		sEditor.commit();
	}

	/**
	 * 保存int类型的数据
	 * 
	 * @param key
	 * @param value
	 */
	public void saveIntPreferencesByKey(String key, int value) {
		sEditor.putInt(key, value);
		sEditor.commit();
	}

	/**
	 * 保存boolean类型的数据
	 * 
	 * @param key
	 * @param value
	 */
	public void saveBooleanPreferencesByKey(String key, boolean value) {
		sEditor.putBoolean(key, value);
		sEditor.commit();
	}

	/**
	 * 读取String类型的数据
	 * 
	 * @param key
	 * @return
	 */
	public String getStringPreferencesByKey(String key) {
		return sSharedPreferences.getString(key, null);
	}

	/**
	 * 读取int类型的数据
	 * 
	 * @param key
	 * @return
	 */
	public int getIntPreferencesByKey(String key) {
		return sSharedPreferences.getInt(key, 0);
	}

	/**
	 * 读取boolean类型的数据
	 * 
	 * @param key
	 * @return
	 */
	public boolean getBooleanPreferencesByKey(String key) {
		return sSharedPreferences.getBoolean(key, false);
	}

	/**
	 * 保存float类型的数据
	 * 
	 * @param key
	 * @return
	 */
	public void saveFloatPreferencesByKey(String key, float value) {
		sEditor.putFloat(key, value);
		sEditor.commit();
	}

	/**
	 * 读取float类型的数据
	 * 
	 * @param key
	 * @return
	 */
	public float getFloatPreferencesByKey(String key) {
		return sSharedPreferences.getFloat(key, 0.0f);
	}

	/**
	 * 保存long类型的数据
	 * 
	 * @param key
	 * @param value
	 */
	public void saveLongPreferencesByKey(String key, long value) {
		sEditor.putLong(key, value);
		sEditor.commit();
	}

	/**
	 * 读取long类型的数据
	 * 
	 * @param key
	 * @param value
	 */
	public long getLongPreferencesByKey(String key) {
		return sSharedPreferences.getLong(key, 0);
	}

	/**
	 * 根据key删除某一项内容
	 * 
	 * @param key
	 */
	public void removePreferenceByKey(String key) {
		sEditor.remove(key);
		sEditor.commit();
	}

	/**
	 * 清空sharepreference
	 */
	public void clearAllPreference() {
		initPreferences();
		sEditor.clear();
		sEditor.commit();
	}

}
