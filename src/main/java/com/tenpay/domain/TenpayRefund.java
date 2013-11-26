package com.tenpay.domain;

import java.util.HashMap;
import java.util.Map;

import com.tenpay.util.MD5Util;

/**
 * 财付通退款接口
 * 
 * @author luomin
 * 
 */
public class TenpayRefund extends TenpayHttpAbstract {

	private String outTradeNo;

	private String transactionId;

	private String outRefundNo;

	private Integer totalFee;

	private Integer refundFee;

	private String opUserId;

	private String opUserPassword;
	
	private String caPath;
	
	private String certPath;

	public TenpayRefund(String partner, String key, String gateUrl, String outTradeNo, String transactionId, String outRefundNo, Integer totalFee, Integer refundFee, String opUserId,
			String opUserPassword, String caPath, String certPath) {
		super(partner, key, gateUrl);
		System.out.println("====1");
		this.outTradeNo = outTradeNo;
		this.transactionId = transactionId;
		this.outRefundNo = outRefundNo;
		this.totalFee = totalFee;
		this.refundFee = refundFee;
		this.opUserId = opUserId;
		this.opUserPassword = opUserPassword;
		this.caPath = caPath;
		this.certPath = certPath;
		verify(outRefundNo, totalFee, refundFee, opUserId, opUserPassword, caPath, certPath);
		init();
	}
	
	@Override
	public void init() {
		setTimeOut(5);
		setCaInfo(caPath);
		setCertInfo(certPath, opUserId);
		super.init();
	}

	@Override
	public Map<String, String> addReqHandlerParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("service_version", "1.1");
		parameters.put("out_trade_no", outTradeNo);
		parameters.put("transaction_id", transactionId);
		parameters.put("out_refund_no", outRefundNo);
		parameters.put("total_fee", String.valueOf(totalFee));
		parameters.put("refund_fee", String.valueOf(refundFee));
		parameters.put("op_user_id", opUserId);
		parameters.put("op_user_passwd", MD5Util.MD5Encode(opUserPassword,"GBK"));
		return parameters;
	}

}
