package com.tenpay.domain;

import org.junit.Test;

public class TenpayDownloadBillTest extends TenpayAbstractTest {

	@Test
	public void testDownloadBillAll() throws Exception {
		TenpayDownloadBill downloadBill = new TenpayDownloadBill(PARTNER, KEY, DOWNLOAD_BILL_URL, "2011-10-12", null);
		System.out.println(downloadBill.download());
	}
	
	@Test
	public void testDownloadBillByPay() throws Exception {
		TenpayDownloadBill downloadBill = new TenpayDownloadBill(PARTNER, KEY, DOWNLOAD_BILL_URL, "2011-10-12", "101");
		System.out.println(downloadBill.download());
	}
	
	@Test
	public void testDownloadBillByRefund() throws Exception {
		TenpayDownloadBill downloadBill = new TenpayDownloadBill(PARTNER, KEY, DOWNLOAD_BILL_URL, "2011-10-12", "102");
		System.out.println(downloadBill.download());
	}
}
