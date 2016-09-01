package cheryl.ordering.comprise;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Random;

import sun.misc.BASE64Encoder;

public class Token {
	private Token(){};
	private static final Token instance = new Token();
	public static Token getInstance(){
		return instance;
	}
	public String generateToken() throws NoSuchAlgorithmException{
		String token = System.currentTimeMillis() + new Random().nextInt() + "";
		//为保证token长度一致，需要提取数据摘要形式
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] md5 = md.digest(token.getBytes());
		//return new String(md5); 返回乱码，因为md5为任意二进制字节数组，String构建时需要查码表，任意二进制字节数组可能在码表中没有对应的值
		//base64编码解决上面问题
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(md5);		
	}

}
