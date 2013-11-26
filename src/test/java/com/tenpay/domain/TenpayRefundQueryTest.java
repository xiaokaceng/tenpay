package com.tenpay.domain;

import org.junit.Test;

public class TenpayRefundQueryTest extends TenpayAbstractTest {

	@Test
	public void test() throws Exception {
		
		TenpayRefundQuery refundQuery = new TenpayRefundQuery(PARTNER, KEY, REFUND_QUERY_URL, "1900000109201310100370906423");
		System.out.println(refundQuery.execute().getContent());
		
	}

}
