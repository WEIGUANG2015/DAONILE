package com.wg.daonile.grim.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.widget.TextView;

import com.wg.daonile.R;

/**
 * 自定义TextView，可控制Drawable大小 
 * 
 * @author ke.wei.quan
 * @date 2015年4月1日
 *
 */
public class DrawableTextView extends TextView {

	public DrawableTextView(Context context) {
		this(context, null);
	}

	public DrawableTextView(Context context, AttributeSet attrs) {
		this(context, attrs, 0);
	}

	public DrawableTextView(Context context, AttributeSet attrs, int defStyle) {
		super(context, attrs, defStyle);

		/**
		 * 取得自定义属性值
		 */
		TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.DrawableTextView);
		int drawableWidth = ta.getDimensionPixelSize(R.styleable.DrawableTextView_drawableWidth, -1);
		int drawableHeight = ta.getDimensionPixelSize(R.styleable.DrawableTextView_drawableHeight, -1);
		/**
		 * 取得TextView的Drawable(左上右下四个组成的数组值)
		 */
		Drawable[] drawables = getCompoundDrawablesRelative();
		Drawable textDrawable = initTextDrawable(drawables); 
		if (textDrawable == null) {
			drawables = getCompoundDrawables();
			textDrawable = initTextDrawable(drawables); 
		}
		/**
		 * 设置宽高
		 */
		if (textDrawable != null && drawableWidth != -1 && drawableHeight != -1) {
			textDrawable.setBounds(0, 0, drawableWidth, drawableHeight);
		}
		/**
		 * 设置给TextView
		 */
		setCompoundDrawables(drawables[0], drawables[1], drawables[2], drawables[3]);
		/**
		 * 回收ta
		 */
		ta.recycle();
	}

	/**
	 * 初始化TextDrawable
	 * @param drawables
	 * @return
	 */
	private Drawable initTextDrawable(Drawable[] drawables) {
		Drawable textDrawable = null;
		for (Drawable drawable : drawables) {
			if (drawable != null) {
				textDrawable = drawable;
			}
		}
		return textDrawable;
	}

}
