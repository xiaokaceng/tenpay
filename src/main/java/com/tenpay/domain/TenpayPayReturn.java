package com.tenpay.domain;

import java.util.HashMap;
import java.util.Map;

import com.tenpay.client.ClientResponseHandler;
import com.tenpay.util.MoneyConvertUtil;

/**
 * 财付通支付返回对象
 * 
 * @author luomin
 * 
 */
public class TenpayPayReturn {

	private static final String TRADE_SUCCESS_CODE = "0";
	
	private ClientResponseHandler clientResponseHandler = new ClientResponseHandler();
	
	private Map<String, String> parameters;
	
	public TenpayPayReturn(String key, Map<String, String> parameters) {
		clientResponseHandler.setKey(key);
		this.parameters = parameters;
		setParameters(parameters);
	}

	private void setParameters(Map<String, String> parameters) {
		if (parameters != null && parameters.size() > 0) {
			for (String each : parameters.keySet()) {
				clientResponseHandler.setParameter(each, parameters.get(each));
			}
		}
	}
	
	public boolean isSign() {
		return clientResponseHandler.isTenpaySign();
	}
	
	public Map<String, String> convertAdapterParams() {
		Map<String, String> params = new HashMap<String, String>();
		params.put("is_success", getTradeState());
		params.put("order_id", parameters.get("transaction_id"));
		params.put("order_no", parameters.get("out_trade_no"));
		params.put("pay_amount", String.valueOf(MoneyConvertUtil.convertPointToUnit(parameters.get("total_fee"))));
		return params;
	}

	private String getTradeState() {
		String tradeState = parameters.get("trade_state");
		if (TRADE_SUCCESS_CODE.equals(tradeState)) {
			return "T";
		}
		return "P";
	}
}
