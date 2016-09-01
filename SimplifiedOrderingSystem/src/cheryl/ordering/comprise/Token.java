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
		//Ϊ��֤token����һ�£���Ҫ��ȡ����ժҪ��ʽ
		MessageDigest md = MessageDigest.getInstance("md5");
		byte[] md5 = md.digest(token.getBytes());
		//return new String(md5); �������룬��Ϊmd5Ϊ����������ֽ����飬String����ʱ��Ҫ���������������ֽ���������������û�ж�Ӧ��ֵ
		//base64��������������
		BASE64Encoder encoder = new BASE64Encoder();
		return encoder.encode(md5);		
	}

}
