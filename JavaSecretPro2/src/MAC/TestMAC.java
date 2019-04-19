package MAC;


import javax.crypto.KeyGenerator;
import javax.crypto.Mac;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Hex;
import org.bouncycastle.crypto.digests.MD5Digest;
import org.bouncycastle.crypto.macs.HMac;
import org.bouncycastle.crypto.params.KeyParameter;

@SuppressWarnings("all")
public class TestMAC {
	
	private static String src = "Jackson is a good man!";
	
	public static void main(String[] args) throws Exception {
		jdkHmacMD5();
		bcHmacMD5();
	}
	
	/*jdk实现MAC*/
	public static void jdkHmacMD5() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();//产生密钥
		//byte[] key = secretKey.getEncoded();//获得密钥
		
		//也可以这样写，使得结果一样
		byte[] key = Hex.decodeHex(new char[] {'a','a','a','a','a','a','a','a','a','a'});
		
		/*还原密钥*/
		SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");//还原密钥
		Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());//实例化MAC
		
		/*初始化MAC*/
		mac.init(restoreSecretKey);
		byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());//执行摘要
		System.out.println("JDK-HmacMD5:" + Hex.encodeHexString(hmacMD5Bytes));
	}
	
	/*BC实现MAC*/
	public static void bcHmacMD5() {
		HMac hmac = new HMac(new MD5Digest());
		hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
		hmac.update(src.getBytes(), 0, src.getBytes().length);
		byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];
		hmac.doFinal(hmacMD5Bytes, 0);
		System.out.println("bc-hmacMD5:" + org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
	}
}













































