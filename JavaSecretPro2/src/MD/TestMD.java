package MD;

import java.security.MessageDigest;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.MD4Digest;
import org.bouncycastle.crypto.digests.MD5Digest;

public class TestMD {
	
	private static String src = "Jackson is a good man!";
	
	public static void main(String[] args) throws Exception {
		jdkMD5();
		jdkMD2();
		bcMD4();
		bcMD5();
		ccMD5();
		ccMD2();
	}
	
	/*md5*/
	public static void jdkMD5() throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD5");
		byte[] md5Bytes = md.digest(src.getBytes());
		//jdk实现不完整，需要将数组转为十六进制
		String encode = Hex.encodeHexString(md5Bytes);
		System.out.println("密文：" + encode);
	}
	
	/*md2*/
	public static void jdkMD2() throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD2");
		byte[] md2Bytes = md.digest(src.getBytes());
		//jdk实现不完整，需要将数组转为十六进制
		String encode = Hex.encodeHexString(md2Bytes);
		System.out.println("密文：" + encode);
	}
	
	/*md4*/
	public static void bcMD4() {
		Digest digest = new MD4Digest();
		/*参数一表示数组；参数二表示起始位置，参数三表示长度*/
		digest.update(src.getBytes(), 0 , src.getBytes().length);
		byte[] md4Bytes = new byte[digest.getDigestSize()];
		//参数一表示输出；参数二表示偏移量
		digest.doFinal(md4Bytes, 0);
		String encode = org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes);
		System.out.println("密文：" + encode);
	}
	
	/*使用BC做MD5的实现*/
	public static void bcMD5() {
		Digest digest = new MD5Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md5Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		System.out.println("BC MD5:" + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
	}
	
	/*使用CC提供MD5的实现*/
	public static void ccMD5() {
		System.out.println("CC MD5:" + DigestUtils.md5Hex(src.getBytes()));
	}
	
	/*使用CC提供MD2的实现*/
	public static void ccMD2() {
		System.out.println("CC MD2:" + DigestUtils.md2Hex(src.getBytes()));
	}
}











































