package com.tenpay.domain;

import org.junit.Assert;
import org.junit.Test;

public class TenpayRefundTest extends TenpayAbstractTest {

	private static final String REFUND_SUCCESS_CODE = "4";
	
	@Test
	public void test() throws Exception {
		TenpayRefund refund = new TenpayRefund(PARTNER, KEY, REFUND_URL, "NT201310100000000013", "1900000109201310100370906423", "1900000109201310100370906423", 2, 2, PARTNER, "111111", "/tenpay/cacert.pem", "/tenpay/1900000109.pfx");
		System.out.println(refund.execute().getContent());
		Assert.assertEquals(REFUND_SUCCESS_CODE, refund.execute().getParameter("refund_status"));
	}

}
