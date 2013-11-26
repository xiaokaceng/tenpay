package com.tenpay.domain;

import static org.junit.Assert.*;

import java.io.UnsupportedEncodingException;

import org.junit.Ignore;
import org.junit.Test;

public class TenpayPayTest extends TenpayAbstractTest {

	private static final String BODY = "≤‚ ‘";
	private static final String REQUEST_URL = "https://gw.tenpay.com/gateway/pay.htm?body=%B2%E2%CA%D4&fee_type=1&notify_url=http%3A%2F%2F127.0.0.1%3A8180%2Ftenpay_api_b2c%2FpayReturnUrl.jsp&out_trade_no=ssdh32425&partner=1900000109&return_url=http%3A%2F%2F127.0.0.1%3A8180%2Ftenpay_api_b2c%2FpayReturnUrl.jsp&sign=21a8d079ed3610df625856a8f69bb870&spbill_create_ip=10.12.14.35&total_fee=1000";
	private static final String RETURN_URL = "http://127.0.0.1:8180/tenpay_api_b2c/payReturnUrl.jsp";
	
	@Test
	@Ignore
	public void testGetRequestUrl() throws UnsupportedEncodingException {
		TenpayPay tenpayPay = new TenpayPay(PARTNER, KEY, BODY, "ssdh32425", 1000, "10.12.14.35", PAY_URL, RETURN_URL, RETURN_URL, null);
		System.out.println(tenpayPay.getRequestURL());
		assertEquals(REQUEST_URL, tenpayPay.getRequestURL());
	}

}
