package SHA;

import java.security.MessageDigest;
import java.security.Security;
import org.apache.commons.codec.binary.Hex;
import org.apache.commons.codec.digest.DigestUtils;
import org.bouncycastle.crypto.Digest;
import org.bouncycastle.crypto.digests.SHA1Digest;
import org.bouncycastle.crypto.digests.SHA224Digest;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

public class TestSHA {
	
	private static String src = "Jackson is a good man!";
	
	public static void main(String[] args) throws Exception {
		jdkSHA1();
		bcSHA1();
		bcSHA224();
		bcSHA224_2();
		ccSHA1();
	}
	
	/*jdk实现SHA1*/
	public static void jdkSHA1() throws Exception {
		MessageDigest md = MessageDigest.getInstance("SHA");
		md.update(src.getBytes());
		System.out.println("JDK-SHA1:" + Hex.encodeHexString(md.digest()));
	}
	
	
	/*bc实现SHA1*/
	public static void bcSHA1() {
		Digest digest = new SHA1Digest();
		digest.update(src.getBytes(), 0 ,src.getBytes().length);
		byte[] sha1Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha1Bytes, 0);
		System.out.println("BC-SHA1:" + org.bouncycastle.util.encoders.Hex.toHexString(sha1Bytes));
	}
	
	/*BC实现SAH224*/
	public static void bcSHA224() {
		Digest digest = new SHA224Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] sha224Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(sha224Bytes, 0);
		System.out.println("BC-SHA224:" + org.bouncycastle.util.encoders.Hex.toHexString(sha224Bytes));
	}
	
	/*使用第二种方式实现bcSHA224_2*/
	public static void bcSHA224_2() {
		Security.addProvider(new BouncyCastleProvider());
	}
	
	/*使用CC实现SHA1*/
	public static void ccSHA1() {
		System.out.println("CC-SHA1-1:" + DigestUtils.sha1Hex(src.getBytes()));
		System.out.println("cc-SHA1-2:" + DigestUtils.sha1Hex(src));
	}
}











































