package com.tenpay.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;


/**
 * 支付接口
 * 
 * @author luomin
 * 
 */
public class TenpayPay extends TenpayAbstract {

	private String body;
	
	private String returnUrl;
	
	private String notifyUrl;
	
	private String outTradeNo;
	
	private Integer totalFee;
	
	// 币种，默认值是1，暂只支持1
	private int feeType = 1;
	
	private String spbillCreateIp;
	
	private String bankType;
	
	public TenpayPay(String partner, String key, String body, String outTradeNo, Integer totalFee, String spbillCreateIp, String payUrl, String returnUrl, String notifyUrl, String bankType) {
		super(partner, key, payUrl);
		this.body = body;
		this.outTradeNo = outTradeNo;
		this.totalFee = totalFee;
		this.spbillCreateIp = spbillCreateIp;
		this.returnUrl = returnUrl;
		this.notifyUrl = notifyUrl;
		this.bankType = bankType;
		verify(body, outTradeNo, totalFee, spbillCreateIp, returnUrl, notifyUrl);
		init();
	}
	
	@Override
	public Map<String, String> addReqHandlerParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("body", body);
		parameters.put("return_url", returnUrl);
		parameters.put("notify_url", notifyUrl);
		parameters.put("out_trade_no", outTradeNo);
		parameters.put("total_fee", String.valueOf(totalFee));
		parameters.put("fee_type", String.valueOf(feeType));
		parameters.put("spbill_create_ip", spbillCreateIp);
		if (!StringUtils.isBlank(bankType)) {
			parameters.put("bank_type", bankType);
		}
		return parameters;
	}
	
}