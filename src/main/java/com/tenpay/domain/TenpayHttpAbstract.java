package com.tenpay.domain;

import java.io.File;

import com.tenpay.NetworkCommunicationException;
import com.tenpay.SignException;
import com.tenpay.client.ClientResponseHandler;
import com.tenpay.client.TenpayHttpClient;

/**
 * 财付通HTTP抽象父类
 * 
 * @author luomin
 * 
 */
public abstract class TenpayHttpAbstract extends TenpayAbstract {

	public static final String HTTP_POST = "POST";
	public static final String HTTP_GET = "GET";
	public static final String SUCCESS_RETCODE = "0";
	
	private TenpayHttpClient httpClient = new TenpayHttpClient();
	
	private ClientResponseHandler resHandler = new ClientResponseHandler();
	
	protected TenpayHttpAbstract(String partner, String key, String gateUrl) {
		super(partner, key, gateUrl);
	}
	
	protected TenpayHttpAbstract() {
	}
	
	public void setTimeOut(int timeOut) {
		httpClient.setTimeOut(timeOut);
	}
	
	public void setMethod(String method) {
		httpClient.setMethod(method);
	}
	
	public void setCaInfo(String caPath) {
		httpClient.setCaInfo(new File(caPath));
	}
	
	public void setCertInfo(String certPath, String certPasswd) {
		httpClient.setCertInfo(new File(certPath), certPasswd);
	}
	
	public ClientResponseHandler execute() throws Exception {
		resHandler.setContent(getResContent());
		resHandler.setKey(getKey());
		if (resHandler.isTenpaySign()) {
    		return resHandler;
    	}
    	throw new SignException(getSignExceptionInfo());
    }
	
	public String getResContent() throws Exception {
		httpClient.setReqContent(getRequestURL());
		if (httpClient.call()) {
			return httpClient.getResContent();
		}
		throw new NetworkCommunicationException(getNetworkCommunicationExceptionInfo());
	}
	
	private String getNetworkCommunicationExceptionInfo() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("返回码：").append(httpClient.getResponseCode());
		buffer.append("错误信息：").append(httpClient.getErrInfo());
		return buffer.toString();
	}
	
	private String getSignExceptionInfo() {
		StringBuffer buffer = new StringBuffer();
		buffer.append("retcode:").append(resHandler.getParameter("retcode"));
		buffer.append(" retmsg:").append(resHandler.getParameter("retmsg"));
		return buffer.toString();
	}
	
}