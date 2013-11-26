package com.tenpay.domain;

import java.util.HashMap;
import java.util.Map;

/**
 * 财付通通知接口
 * 
 * @author luomin
 * 
 */
public class TenpayNotify extends TenpayHttpAbstract {

	private String notifyId;
	
	public TenpayNotify(String partner, String key, String gateUrl, String notifyId) {
		super(partner, key, gateUrl);
		this.notifyId = notifyId;
		verify(notifyId);
		init();
	}

	@Override
	public Map<String, String> addReqHandlerParameters() {
		Map<String, String> parameters = new HashMap<String, String>();
		parameters.put("notify_id", notifyId);
		return parameters;
	}

}
