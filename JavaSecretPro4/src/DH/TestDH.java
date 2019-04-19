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
	
	/*使用JDK实现DH非对称加密算法*/
	public static void jdkDH() throws Exception{
		/*初始化发送方的密钥*/
		KeyPairGenerator senderKeyPairGenerator = KeyPairGenerator.getInstance("DH");
		senderKeyPairGenerator.initialize(512);
		KeyPair senderKeyPair = senderKeyPairGenerator.generateKeyPair();
		byte[] senderPublicKeyEnc = senderKeyPair.getPublic().getEncoded();		//发送方公钥，发送给接收方（网络，文件。。。）
		
		/*初始化接收方的密钥*/
		KeyFactory receiverkeyFactory = KeyFactory.getInstance("DH");
		X509EncodedKeySpec x509EncodedKeySpec = new X509EncodedKeySpec(senderPublicKeyEnc);
		PublicKey receiverPublicKey = receiverkeyFactory.generatePublic(x509EncodedKeySpec);
		DHParameterSpec dhParameterSpec = ((DHPublicKey)receiverPublicKey).getParams();
		KeyPairGenerator receiverKeyPairGenerator = KeyPairGenerator.getInstance("DH");
		receiverKeyPairGenerator.initialize(dhParameterSpec);
		KeyPair receiverKeyPair = receiverKeyPairGenerator.generateKeyPair();
		PrivateKey receiverPrivateKey = receiverKeyPair.getPrivate();
		byte[] receiverPublicKeyEnc = receiverKeyPair.getPublic().getEncoded();
		
		/*密钥构建*/
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
		
		/*生成发送方的本地密钥*/
		SecretKey senderDesKey = senderKeyAgreement.generateSecret("DES");
		if(Objects.equals(receiverDesKey, senderDesKey)){
			System.out.println("双方密钥相同！");
		}
		
		/*加密*/
		Cipher cipher = Cipher.getInstance("DES");
		cipher.init(Cipher.ENCRYPT_MODE, senderDesKey);
		byte[] result = cipher.doFinal(src.getBytes());
		System.out.println("jdk-dh-encrypt:" + Base64.encodeBase64String(result));
		
		/*解密*/
		cipher.init(Cipher.DECRYPT_MODE, receiverDesKey);
		result = cipher.doFinal(result);
		System.out.println("jdk-dh-decode:" + new String(result));
	}
} 
	






































