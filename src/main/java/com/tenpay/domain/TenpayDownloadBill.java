package com.tenpay.domain;

import java.util.HashMap;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;

import com.tenpay.DownloadBillRequestHandler;

/**
 * 财付通对账单下载接口
 * 
 * @author luomin
 * 
 */
public class TenpayDownloadBill extends TenpayHttpAbstract {

	private static final String ORDER_PAY = "101";
	private static final String ORDER_REFUND = "102";
	
	private String spid;
	
	private String transTime;
	
	private String stamp = Long.toString(System.currentTimeMillis()/1000);
	
	private String mchtype;
	
	protected TenpayDownloadBill(String partner, String key, String gateUrl, String transTime, String mchtype) {
		super(partner, key, gateUrl);
		this.spid = partner;
		this.transTime = transTime;
		this.mchtype = transformOrderType(mchtype);
		verify(spid, transTime);
		init();
	}
	
	@Override
	public void init() {
		setMethod(HTTP_GET);
		setReqHandler(new DownloadBillRequestHandler(null, null));
		super.init();
	}

	private String transformOrderType(String mchtype) {
		if (StringUtils.isBlank(mchtype)) {
			return "0"; // 当日所有订单
		} else if (ORDER_PAY.equals(mchtype)) {
			return "1"; // 成功支付订单
		} else if (ORDER_REFUND.equals(mchtype)) {
			return "2"; // 退款订单
		}
		return "0"; // 当日所有订单
	}

	@Override
	public Map<String, String> addReqHandlerParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("spid", spid);
		parameters.put("trans_time", transTime);
		parameters.put("stamp", stamp);
		parameters.put("mchtype", mchtype);
		parameters.put("cft_signtype", "0");
		return parameters;
	}
	
	public String download() throws Exception {
		return getResContent();
	}

}
