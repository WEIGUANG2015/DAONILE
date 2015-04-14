package com.wg.daonile.base;

/**
 * 接口的基类
 * 
 * @author WEIGUANG
 * @date 2015年4月7日
 *
 */
public interface IBaseListener {
	
	/**
	 * 结束自身
	 */
	void finish();
	
	/**
	 * 土司提示
	 * @param tips
	 */
	void showToast(String tips);
	
	/**
	 * 显示进度对话框
	 */
	void showProgressDialog();
	
	/**
	 * 显示进度对话框
	 */
	void dissmissProgressDialog();
	
	/**
	 * 跳转页面
	 * 
	 * @param cls
	 */
	void goToActivity(Class<?> cls);
}

