package com.xafdy.pwencode;

import com.xafdy.alg.MD5Util;
import com.xafdy.alg.OrEncode;

public class EncodeOperationAdapter implements EncodeOperation{
	private MD5Util md=new MD5Util();
	private OrEncode oe=new OrEncode();
	@Override
	public String encode1(String password) {
		
		return md.md5(password);
	}
	@Override
	public String encode2(String password) {
		return oe.orcode(password);
	}
	
}
