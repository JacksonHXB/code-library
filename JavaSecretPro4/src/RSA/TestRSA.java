package RSA;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Base64;

public class TestRSA {
	
	private static String src = "Jackson is a good man!";
	
	public static void main(String[] args) throws Exception {
		jdkRSA();
	}
	
	/*ʹ��JDKʵ��RSA�ǶԳƼ����㷨*/
	public static void jdkRSA() throws Exception{
		/*��ʼ����Կ*/
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
		keyPairGenerator.initialize(512);
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		RSAPublicKey rsaPublicKey = (RSAPublicKey)keyPair.getPublic();
		RSAPrivateKey rsaPrivateKey = (RSAPrivateKey)keyPair.getPrivate();
		System.out.println("Public Key:" + Base64.encodeBase64String(rsaPublicKey.getEncoded()));
		System.out.println("Private Key:" + Base64.encodeBase64String(rsaPrivateKey.getEncoded()));
		
		/*1��˽Կ����-��Կ���ܣ�����*/
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Cipher cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, privateKey);
		byte[] result = cipher.doFinal(src.getBytes());
		System.out.println("˽Կ����-��Կ����-����:" + Base64.encodeBase64String(result));
		
		/*1��˽Կ����-��Կ���ܣ�����*/
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, publicKey);
		result = cipher.doFinal(result);
		System.out.println("˽Կ����-��Կ����-���ܣ�" + new String(result));
		
		/*2����Կ����-˽Կ���ܣ�����*/
		x509EncodedKeySpec = new X509EncodedKeySpec(rsaPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.ENCRYPT_MODE, publicKey);
		result = cipher.doFinal(src.getBytes());
		System.out.println("��Կ����-˽Կ����-���ܣ�" + Base64.encodeBase64String(result));
		
		/*2����Կ����-˽Կ���ܣ�����*/
		pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(rsaPrivateKey.getEncoded());
		keyFactory = KeyFactory.getInstance("RSA");
		privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		cipher = Cipher.getInstance("RSA");
		cipher.init(Cipher.DECRYPT_MODE, privateKey);
		result = cipher.doFinal(result);
		System.out.println("��Կ����-˽Կ����-���ܣ�" + new String(result));
	}
} 
	






































