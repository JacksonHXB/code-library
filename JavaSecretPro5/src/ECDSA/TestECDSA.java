package ECDSA;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.ECPrivateKey;
import java.security.interfaces.ECPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;

import org.apache.commons.codec.binary.Hex;


public class TestECDSA {
	
	private static String src = "Jackson is a good man!";
	
	public static void main(String[] args) throws Exception {
		jdkECDSA();
	}
	
	/*ʹ��JDKʵ��ECDSA����ǩ��*/
	public static void jdkECDSA() throws Exception{
		/*1. ��ʼ����Կ*/
		KeyPairGenerator keyPairGenerastor = KeyPairGenerator.getInstance("EC");
		keyPairGenerastor.initialize(256);
		KeyPair keyPair = keyPairGenerastor.generateKeyPair();
		ECPublicKey ecPublicKey = (ECPublicKey)keyPair.getPublic();
		ECPrivateKey ecPrivateKey = (ECPrivateKey)keyPair.getPrivate();
		
		/*2. ִ��ǩ��*/
		PKCS8EncodedKeySpec pkcs8EncodedKeySpec = new PKCS8EncodedKeySpec(ecPrivateKey.getEncoded());
		KeyFactory keyFactory = KeyFactory.getInstance("EC");
		PrivateKey privateKey = keyFactory.generatePrivate(pkcs8EncodedKeySpec);
		Signature signature = Signature.getInstance("SHA1withECDSA");
		signature.initSign(privateKey);
		signature.update(src.getBytes());
		byte[] result = signature.sign();
		System.out.println("jdk-dsa-sign:" + Hex.encodeHexString(result));
		
		/*��֤ǩ��*/
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(ecPublicKey.getEncoded());
		keyFactory = KeyFactory.getInstance("EC");
		PublicKey publicKey = keyFactory.generatePublic(x509EncodedKeySpec);
		signature = Signature.getInstance("SHA1withECDSA");
		signature.initVerify(publicKey);
		signature.update(src.getBytes());
		boolean bool = signature.verify(result);
		System.out.println("��֤�����" + bool);
	}
} 
	






































