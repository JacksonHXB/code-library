package DH;

import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.X509EncodedKeySpec;
import java.util.Objects;

import javax.crypto.Cipher;
import javax.crypto.KeyAgreement;
import javax.crypto.SecretKey;
import javax.crypto.interfaces.DHPublicKey;
import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;


public class TestDH {
	
	private static String src = "Jackson is a good man!";
	
	public static void main(String[] args) throws Exception {
		jdkDH();
	}
	
	/*ʹ��JDKʵ��DH�ǶԳƼ����㷨*/
	public static void jdkDH() throws Exception{
		/*��ʼ�����ͷ�����Կ*/
		KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");
		senderKeyPairGenerator.initialize(512);
		KeyPair senderKeyPair = senderKeyPairGenerator.generateKeyPair();
		byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();		//���ͷ���Կ�����͸����շ������磬�ļ���������
		
		/*��ʼ�����շ�����Կ*/
		KeyFactory receiverkeyFactory = KeyFactory.getInstance("DH");
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
		PublicKey receiverPublicKey = receiverkeyFactory.generatePublic(x509EncodedKeySpec);
		DHParameterSpec dhParameterSpec = ((DHPublicKey)receiverPublicKey).getParams();
		KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
		receiverKeyPairGenerator.initialize(dhParameterSpec);
		KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair();
		PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
		byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();
		
		/*��Կ����*/
		KeyAgreement receiverkeyAgreement = KeyAgreement.getInstance("DH");
		receiverkeyAgreement.init(receiverPrivateKey);
		receiverkeyAgreement.doPhase(receiverPublicKey, true);
		SecretKey receiverDesKey = receiverkeyAgreement.generateSecret("DES");
		
		KeyFactory senderKeyFactory = KeyFactory.getInstance("DH");
		x509EncodedKeySpec = new X509EncodedKeySpec(receiverPublicKeyEnc);
		PublicKey senderPublic = senderKeyFactory.generatePublic(x509EncodedKeySpec);
		KeyAgreement senderKeyAgreement = KeyAgreement.getInstance("DH");
		senderKeyAgreement.init(senderKeyPair.getPrivate());
		senderKeyAgreement.doPhase(senderPublic, true);
		
		/*���ɷ��ͷ��ı�����Կ*/
		SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");
		if(Objects.equals(receiverDesKey, senderDesKey)){
			System.out.println("˫����Կ��ͬ��");
		}
		
		/*����*/
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
		byte[] result = cipher.doFinal(src.getBytes());
		System.out.println("jdk-dh-encrypt:" + Base64.encodeBase64String(result));
		
		/*����*/
		cipher.init(Cipher.DECRYPT_MODE, receiverDesKey);
		result = cipher.doFinal(result);
		System.out.println("jdk-dh-decode:" + new String(result));
	}
} 
	






































