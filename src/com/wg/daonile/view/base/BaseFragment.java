package com.wg.daonile.view.base;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;

/**
 * 所有的Fragment的基类
 * 
 * @author WEIGUANG
 * @date 2015年3月31日
 * @lastModifyDate 
 * @version 1.0
 *
 */
public abstract class BaseFragment extends Fragment {
	
	@Override
	public void onActivityCreated(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onActivityCreated(savedInstanceState);

	}

	@Override
	public void onAttach(Activity activity) {
		// TODO Auto-generated method stub
		super.onAttach(activity);

	}

	@Override
	public void onDestroyView() {
		// TODO Auto-generated method stub
		super.onDestroyView();

	}

	@Override
	public void onDestroy() {
		// TODO Auto-generated method stub
		super.onDestroy();

	}
}
