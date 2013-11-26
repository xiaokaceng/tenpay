package com.tenpay.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 订单查询接口
 * 
 * @author luomin
 * 
 */
public class TenpayPayQuery extends TenpayHttpAbstract {

	private String outTradeNo;
	
	// 财付通订单号
	private String transactionId;
	
	public TenpayPayQuery(String partner, String key, String gateUrl, String outTradeNo) {
		super(partner, key, gateUrl);
		this.outTradeNo = outTradeNo;
		init();
	}
	
	@Override
	public Map<String, String> addReqHandlerParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("out_trade_no", outTradeNo);
		parameters.put("transaction_id", transactionId);
		return parameters;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

}
