package com.tenpay.domain;

import java.io.UnsupportedEncodingException;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import com.tenpay.PropertyNullPointerException;
import com.tenpay.RequestHandler;

/**
 * 财付通抽象父类，提供各接口公共参数和方法
 * 
 * @author luomin
 * 
 */
public abstract class TenpayAbstract {

	private String partner;
	
	private String key;
	
	private String gateUrl;
	
	private RequestHandler reqHandler = new RequestHandler(null, null);
	
	protected TenpayAbstract(String partner, String key, String gateUrl) {
		this.partner = partner;
		this.key = key;
		this.gateUrl = gateUrl;
		verify(partner, key, gateUrl);
	}
	
	protected TenpayAbstract() {
	}

	protected void init() {
		reqHandler.init();
		reqHandler.setKey(key);
		reqHandler.setGateUrl(gateUrl);
		setReqHandlerParameters();
	}

	private void setReqHandlerParameters() {
		reqHandler.setParameter("partner", partner);
		Map<String, String> parameters = addReqHandlerParameters();
		if (parameters.size() > 0) {
			Iterator<Entry<String, String>> iterable = parameters.entrySet().iterator();
			while (iterable.hasNext()) {
				Entry<String, String> entry = iterable.next();
				reqHandler.setParameter(entry.getKey(), entry.getValue());
			}
		}
	}

	public abstract Map<String, String> addReqHandlerParameters();
	
	public String getRequestURL() throws UnsupportedEncodingException {
		return getReqHandler().getRequestURL();
	}
	
	public String getDebugInfo() {
		return getReqHandler().getDebugInfo();
	}

	public void setReqHandler(RequestHandler reqHandler) {
		this.reqHandler = reqHandler;
	}

	public RequestHandler getReqHandler() {
		return reqHandler;
	}

	public String getKey() {
		return key;
	}
	
	protected void verify(Object... properties) {
		for (Object each : properties) {
			if (each == null) {
				throw new PropertyNullPointerException();
			}
		}
	}

	public String getPartner() {
		return partner;
	}

	public void setPartner(String partner) {
		this.partner = partner;
	}

	public String getGateUrl() {
		return gateUrl;
	}

	public void setGateUrl(String gateUrl) {
		this.gateUrl = gateUrl;
	}

	public void setKey(String key) {
		this.key = key;
	}
	
}
