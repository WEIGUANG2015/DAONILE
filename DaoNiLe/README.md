# DaoNiLe编码规范
1.命名习惯
	a.非public的、非static的字段名称以m开头。
	b.其它字段以小写字母开头。
	c.public static final字段（常量）全部字母大写并用下划线分隔。
	d.函数方法名必须看其名而知其意，不要使用一些无必要的缩写（变量跟常量也一样）
	e.接口命名：I+功能+模块（Interator、Presenter、View）/RequestCallBack（请求的回调）
	f.activity界面命名：功能+Activity
	g.Interactor命名：功能+Interactor
	h.Presenter命名：功能+Presenter
	i.EventBus的事件命名：E+功能

2.不要捕获顶级的Exception，异常捕获需分级，分开捕获每一种异常，在一条try语句后面跟随多个catch语句块

3.导入需要的包时候，不要使用import xx.*，一些无用的包记得删除

4.常量定义在头部，变量定义跟着方法头部

5.大括号不单独占用一行；它们紧接着上一行书写。

6.对那些临时性的、短期的、够棒但不完美的代码，请使用TODO注释。

7.自定义控件全部放在com.wg.daonile.widget，基类放在com.wg.daonile.base，工具类放在com.wg.daonile.utils，
  EventBus的事件放在com.wg.daonile.eventbus.event，实体放在com.wg.daonile.entity，app一些常量放在com.wg.daonile.constant
  


