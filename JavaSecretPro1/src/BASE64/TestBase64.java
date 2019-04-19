package BASE64;


import org.apache.commons.codec.binary.Base64;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class TestBase64 {
	
	private static String src = "Jacskon is a good man!";

	public static void main(String[] args) throws Exception {
		jdkBase64();
		CCBase64();
		BCBase64();
	}
	
	/*Base64算法以JDK实现*/
	public static void jdkBase64() throws Exception {
		//加密
		BASE64Encoder encoder = new BASE64Encoder();
		String encode = encoder.encode(src.getBytes());
		System.out.println("密文：" + encode);
		
		//解密
		BASE64Decoder decoder = new BASE64Decoder();
		String decode = new String(decoder.decodeBuffer(encode));
		System.out.println("明文：" + decode);
	}
	
	
	/*Base64算法以Commons Codec实现*/
	public static void CCBase64() {
		byte[] encodeBytes = Base64.encodeBase64(src.getBytes());
		String encode = new String(encodeBytes);
		System.out.println("密文：" + encode);
		
		byte[] decodeBytes = Base64.decodeBase64(encodeBytes);
		String decode = new String(decodeBytes);
		System.out.println("明文：" + decode);
	}
	
	
	/*Base64算法以Bouncy Castle实现*/
	public static void BCBase64() {
		byte[] encodeBytes = org.bouncycastle.util.encoders.Base64.encode(src.getBytes());
		String encode = new String(encodeBytes);
		System.out.println("密文：" + encode);
		
		byte[] decodeBytes = org.bouncycastle.util.encoders.Base64.decode(encodeBytes);
		String decode = new String(decodeBytes);
		System.out.println("明文：" + decode);
	}
}











































