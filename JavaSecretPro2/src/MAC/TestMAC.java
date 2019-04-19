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
	
	/*jdkʵ��MAC*/
	public static void jdkHmacMD5() throws Exception {
		KeyGenerator keyGenerator = KeyGenerator.getInstance("HmacMD5");
		SecretKey secretKey = keyGenerator.generateKey();//������Կ
		//byte[] key = secretKey.getEncoded();//�����Կ
		
		//Ҳ��������д��ʹ�ý��һ��
		byte[] key = Hex.decodeHex(new char[] {'a','a','a','a','a','a','a','a','a','a'});
		
		/*��ԭ��Կ*/
		SecretKey restoreSecretKey = new SecretKeySpec(key, "HmacMD5");//��ԭ��Կ
		Mac mac = Mac.getInstance(restoreSecretKey.getAlgorithm());//ʵ����MAC
		
		/*��ʼ��MAC*/
		mac.init(restoreSecretKey);
		byte[] hmacMD5Bytes = mac.doFinal(src.getBytes());//ִ��ժҪ
		System.out.println("JDK-HmacMD5:" + Hex.encodeHexString(hmacMD5Bytes));
	}
	
	/*BCʵ��MAC*/
	public static void bcHmacMD5() {
		HMac hmac = new HMac(new MD5Digest());
		hmac.init(new KeyParameter(org.bouncycastle.util.encoders.Hex.decode("aaaaaaaaaa")));
		hmac.update(src.getBytes(), 0, src.getBytes().length);
		byte[] hmacMD5Bytes = new byte[hmac.getMacSize()];
		hmac.doFinal(hmacMD5Bytes, 0);
		System.out.println("bc-hmacMD5:" + org.bouncycastle.util.encoders.Hex.toHexString(hmacMD5Bytes));
	}
}













































