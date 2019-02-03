package com.ziyun.cloud.constant;

/**
 * @author Zhang.Peng
 * @date 2018年12月10日上午11:15:20
 */
public interface ErrorMessage {

	/**
	 * common
	 */
	String COMMON_PAGE_ERROR = "分页参数值错误!";

	/**
	 * product
	 */
	String PRODUCT_CATEGORY_CATEGORY_ID_ERROR = "分类Id值错误!";
	String PRODUCT_CATEGORY_CATEGORY_ID_LESS = "分类Id值缺失!";
	String PRODUCT_CATEGORY_SHOP_ID_ERROR = "卖家Id值错误!";
	String PRODUCT_CATEGORY_SHOP_ID_LESS = "分类Id值缺失!";
	String PRODUCT_CATEGORY_INFO_LEVEL_ERROR = "这个分类id[{}], categoryInfo[{}] 信息的 categoryLevel:{} 有错误";
	String PRODUCT_CATEGORY_PARENTLEVEL_ERROR = "这个分类id[{}] 不是一级分类 categoryLevel[{}],但是未找到父类id[{}]的categoryLevel:{} 有错误";
	String PRODUCT_CATEGORY_ID_LEVEL_ERROR = "这个分类id[{}]的categoryLevel:{} 有错误";
	String PRODUCT_PRODUCT_SKU_LESS = "##未找到商品编码对应的skuId，spuId：{}";
	String PRODUCT_PRODUCT_SPU_ID_LESS = "spuId值缺失!";
	String PRODUCT_PRODUCT_SPU_ID_ERROR = "spu值错误!";
	String PRODUCT_PRODUCT_SKU_ID_LESS = "skuId值缺失!";
	String PRODUCT_PRODUCT_SKU_ID_ERROR = "sku值错误!";
	String PRODUCT_PRODUCT_AREA_ID_LESS = "区域id值缺失!";
	String PRODUCT_PRODUCT_AREA_ID_ERROR = "区域id值错误!";
	String PRODUCT_PRODUCT_QUANTITY_LESS = "商品数量值缺失!";
	String PRODUCT_PRODUCT_QUANTITY_ERROR = "商品数量值错误!";

	// shop
	String PRODUCT_SHOP_SHOP_ID_ERROR = "商户Id值错误!";
	String PRODUCT_SHOP_SHOP_ID_LESS = "商户Id值缺失!";
	String PRODUCT_SHOP_SHOP_MOBILE_LESS = "商户联系人手机号值缺失!";

	// freight
	String PRODUCT_FREIGHT_AREA_ID_LESS = "区域id值缺失!";
	String PRODUCT_FREIGHT_AREA_ID_ERROR = "区域id值错误!";
	String PRODUCT_FREIGHT_FREIGHTITEM_LESS = "运费计算参数缺失!";
	String PRODUCT_FREIGHT_TOTAL_QUANTITY_LESS = "购买总数量缺失!";
	String PRODUCT_FREIGHT_TOTAL_WEIGHT_LESS = "购物车记录总重量缺失!";

	/**
	 * cart
	 */
	String PRODUCT_CART_QUANTITY_ERROR = "购物车商品数量错误!";
	String PRODUCT_CART_SKU_ID_LESS = "商品skuId缺失!";
	String PRODUCT_CART_SKU_ID_ERROR = "商品skuId错误!";
	String PRODUCT_CART_CART_ID_LESS = "购物车id缺失!";
	String PRODUCT_CART_CART_ID_ERROR = "购物车id错误!";

	/**
	 * trade
	 */
	String TRADE_ADDRESS_ID_LESS = "地址Id缺失!";
	String TRADE_ADDRESS_ID_ERROR = "地址Id错误!";

	/**
	 * order
	 */
	String TRADE_ORDER_CREATETYPE_LESS = "订单生成类型缺失!";
	String TRADE_ORDER_AREAID_LESS = "区域id值缺失!";
	String TRADE_ORDER_SAVE_EVENT = "处理保存订单事件[{}],{} = null";
	String TRADE_ORDER_SAVE_EVENT_OPREATE_CART_NUM = "处理保存订单事件[{}],userId =[{}],处理购物车记录 [{}] 条";
	String TRADE_ORDER_COUNT_ERROR = "处理保存订单事件[{}],立即购买 小于0";

	String TRADE_ORDER_OPERATION_ABNORMAL = "处理保存订单事件[{}],当前操作非正常操作";

	String TRADE_ORDER_COMMENT_EVENT = "评价订单事件[{}],{} = null";

	/**
	 * credit
	 */
	String TRADE_CREDIT_ORDER_LESS = "订单id缺失";
	String TRADE_CREDIT_ORDER_ERROR = "订单id错误";
	String TRADE_CREDIT_REPAYMENT_DATE_LESS = "还款时间不能为空";

	/**
	 * ucenter
	 */
	String UCENTER_WALLET_SCORE_EXCHANGE_COUPON = "积分兑换优惠券";
	String UCENTER_WALLET_NEW_PASSWORD_LESS = "预存款密码值缺失!";

	String UCENTER_VERIFYCODE_LESS = "验证码值缺失!";

	String UCENTER_LOGIN_LOGIN_LOGIN_TYPE_LESS = "登录类型缺失!";
	String UCENTER_LOGIN_LOGIN_SUB_LOGIN_TYPE_LESS = "登录子类型缺失!";

	String UCENTER_LOGIN_LOGIN_TEXT_LESS = "验证码值缺失!";
	String UCENTER_LOGIN_NEW_PASSWORD_LESS = "登入密码值缺失!";
	String UCENTER_LOGIN_MOBILE_LESS = "手机号缺失!";
	String UCENTER_LOGIN_OPENID_LESS = "用户openId缺失!";
	String UCENTER_LOGIN_SEND_SCORE_BY_REGISTER = "注册送积分";
	String UCENTER_LOGIN_OLD_PASSWORD_LESS = "登入新密码值缺失!";

	String UCENTER_MESSAGE_MESSAGE_TYPE_LESS = "消息类型缺失!";
	String UCENTER_MESSAGE_MESSAGE_TYPE_ERROR = "消息类型错误!";
	String UCENTER_MESSAGE_MESSAGE_ID_LESS = "消息id缺失!";
	String UCENTER_MESSAGE_MESSAGE_ID_ERROR = "消息id错误!";
	/**
	 * evaluate
	 */

	// String SELLER_EVALUATE_TIME_SCORE_LESS = "缺少商户及时性评分";
	//
	// String SELLER_EVALUATE_TIME_SCORE_ERROR = "商户及时性评分有误";
	//
	// String SELLER_EVALUATE_SERVICE_SCORE_LESS = "缺少商户服务满意度评分";
	//
	// String SELLER_EVALUATE_SERVICE_SCORE_ERROR = "商户服务满意度评分有误";
	//
	// String SELLER_EVALUATE_QUALITY_SCORE_LESS = "缺少商户商品质量评分";
	//
	// String SELLER_EVALUATE_QUALITY_SCORE_ERROR = "商户商品质量评分有误";

	String SELLER_EVALUATE_SCORE_LESS = "缺少商户评分";

	String SELLER_EVALUATE_SCORE_ERROR = "商户评分有误";

	String SELLER_ID_EVALUATE_LESS = "缺少商户id";

	String ORDER_ID_EVALUATE_LESS = "缺少订单id";

	String ORDER_ITEM_ID_EVALUATE_LESS = "缺少订单item id";

	String GOODS_EVALUATE_CORE_LESS = "缺少商品评分";

	String GOODS_EVALUATE_SCORE_ERROR = "商品评分有误";

	String GOODS_EVALUATE_DETAIL_LESS = "缺少商品评价详情";

	String GOODS_ID_EVALUATE_LESS = "缺少商品Id";

	String EVALUATE_ID_LESS = "缺少评价id";

	String UPDATE_TYPE_LESS = "缺少更改类型";

}
