package com.tenpay;

/**
 * 签名失败或业务错误异常
 * 
 * @author luomin
 * 
 */
public class SignException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public SignException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SignException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public SignException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public SignException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
