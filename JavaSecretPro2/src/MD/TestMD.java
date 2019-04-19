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
		//jdkʵ�ֲ���������Ҫ������תΪʮ������
		String encode = Hex.encodeHexString(md5Bytes);
		System.out.println("���ģ�" + encode);
	}
	
	/*md2*/
	public static void jdkMD2() throws Exception {
		MessageDigest md = MessageDigest.getInstance("MD2");
		byte[] md2Bytes = md.digest(src.getBytes());
		//jdkʵ�ֲ���������Ҫ������תΪʮ������
		String encode = Hex.encodeHexString(md2Bytes);
		System.out.println("���ģ�" + encode);
	}
	
	/*md4*/
	public static void bcMD4() {
		Digest digest = new MD4Digest();
		/*����һ��ʾ���飻��������ʾ��ʼλ�ã���������ʾ����*/
		digest.update(src.getBytes(), 0 , src.getBytes().length);
		byte[] md4Bytes = new byte[digest.getDigestSize()];
		//����һ��ʾ�������������ʾƫ����
		digest.doFinal(md4Bytes, 0);
		String encode = org.bouncycastle.util.encoders.Hex.toHexString(md4Bytes);
		System.out.println("���ģ�" + encode);
	}
	
	/*ʹ��BC��MD5��ʵ��*/
	public static void bcMD5() {
		Digest digest = new MD5Digest();
		digest.update(src.getBytes(), 0, src.getBytes().length);
		byte[] md5Bytes = new byte[digest.getDigestSize()];
		digest.doFinal(md5Bytes, 0);
		System.out.println("BC MD5:" + org.bouncycastle.util.encoders.Hex.toHexString(md5Bytes));
	}
	
	/*ʹ��CC�ṩMD5��ʵ��*/
	public static void ccMD5() {
		System.out.println("CC MD5:" + DigestUtils.md5Hex(src.getBytes()));
	}
	
	/*ʹ��CC�ṩMD2��ʵ��*/
	public static void ccMD2() {
		System.out.println("CC MD2:" + DigestUtils.md2Hex(src.getBytes()));
	}
}











































