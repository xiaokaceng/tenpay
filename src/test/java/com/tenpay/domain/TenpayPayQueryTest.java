package com.tenpay.domain;

import org.junit.Test;

import com.tenpay.NetworkCommunicationException;
import com.tenpay.PropertyNullPointerException;
import com.tenpay.SignException;

public class TenpayPayQueryTest extends TenpayAbstractTest {

	@Test(expected = SignException.class)
	public void testSignException() throws Exception {
		TenpayPayQuery payQuery = new TenpayPayQuery(PARTNER, "11", PAY_QUERY_URL, "aa");
		payQuery.execute();
	}
	
	@Test(expected = NetworkCommunicationException.class)
	public void testNetworkCommunicationException() throws Exception {
		TenpayPayQuery payQuery = new TenpayPayQuery(PARTNER, KEY, "www.baidu.com", "aa");
		payQuery.execute();
	}
	
	@Test(expected = PropertyNullPointerException.class)
	public void testPropertyNullPointerException() throws Exception {
		TenpayPayQuery payQuery = new TenpayPayQuery(null, KEY, PAY_QUERY_URL, "aa");
		payQuery.execute();
	}
	
	@Test
	public void test() throws Exception {
		TenpayPayQuery payQuery = new TenpayPayQuery(PARTNER, KEY, PAY_QUERY_URL, "NT201310100000000013");
		System.out.println(payQuery.execute().getContent());
	}
	
}
