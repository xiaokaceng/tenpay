package com.tenpay.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 财付通退款查询接口
 * 
 * @author luomin
 * 
 */
public class TenpayRefundQuery extends TenpayHttpAbstract {

	private String outTradeNo;

	private String transactionId;

	private String outRefundNo;
	
	private String refundId;
	
	public TenpayRefundQuery(String partner, String key, String gateUrl, String outRefundNo) {
		super(partner, key, gateUrl);
		this.outRefundNo = outRefundNo;
		verify(outRefundNo);
		init();
	}

	public TenpayRefundQuery(String partner, String key, String gateUrl, String outTradeNo, String transactionId, String outRefundNo, String refundId) {
		this(partner, key, gateUrl, outRefundNo);
		this.transactionId = transactionId;
		this.outTradeNo = outTradeNo;
		this.refundId = refundId;
		init();
	}

	@Override
	public Map<String, String> addReqHandlerParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("out_trade_no", outTradeNo);
		parameters.put("transaction_id", transactionId);
		parameters.put("out_refund_no", outRefundNo);
		parameters.put("refund_id", refundId);
		return parameters;
	}

}
