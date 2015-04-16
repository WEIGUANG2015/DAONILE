package com.wg.daonile.view.guest;

import com.wg.daonile.base.IBaseListener;

/**
 * 框架登陆接口
 * 
 * @author JUNLONG CHAN
 * @date 2015-4-16
 * @version 1.0
 * 
 */
public interface IGuestView extends IBaseListener {

	/**
	 * 框架登陆后执行用户登陆功能
	 */
	void notifyUserLogin();
}
