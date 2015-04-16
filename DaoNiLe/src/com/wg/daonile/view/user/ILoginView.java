package com.wg.daonile.view.user;

import com.wg.daonile.base.IBaseListener;
import com.wg.daonile.eventbus.event.EfinishSelf;

/**
 * 用户登录界面接口
 * 
 * @author ke.wei.quan
 * @date 2015年3月31日
 *
 */
public interface ILoginView extends IBaseListener {

	/**
	 * 点击返回
	 */
	void onGoBackClickListener();

	/**
	 * 发布结束引导页页面的事件
	 * 
	 * @param efinishSelf
	 */
	void publishFinishGuideViewEvent(EfinishSelf efinishSelf);
}
