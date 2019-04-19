package ElGamal;

import java.security.AlgorithmParameterGenerator;
import java.security.AlgorithmParameters;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.Security;

import javax.crypto.spec.DHParameterSpec;

import org.apache.commons.codec.binary.Base64;
import org.bouncycastle.jce.provider.BouncyCastleProvider;

@SuppressWarnings("all")
public class TestElGamal {
	
	private static String src = "Jackson is a good man!";
	
	public static void main(String[] args) throws Exception {
		bcElGamal();
	}
	
	/*使用bc实现ElGamal非对称加密算法*/
	public static void bcElGamal() throws Exception{
		//公钥加密私钥解密
		Security.addProvider(new BouncyCastleProvider());
		
		/*1，初始化密钥*/
		AlgorithmParameterGenerator algorithmParameterGenerator = AlgorithmParameterGenerator.getInstance("ElGamal");
		algorithmParameterGenerator.init(256);
		AlgorithmParameters algorithmParameters = algorithmParameterGenerator.generateParameters();
		DHParameterSpec dhParameterSpec = (DHParameterSpec)algorithmParameters.getParameterSpec(DHParameterSpec.class);
		KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("ElGamal");
		keyPairGenerator.initialize(dhParameterSpec, new SecureRandom());
		KeyPair keyPair = keyPairGenerator.generateKeyPair();
		PublicKey elGamalPublicKey = keyPair.getPublic();
		PrivateKey elGamaPrivateKey = keyPair.getPrivate();
		System.out.println("Public Key:" + Base64.encodeBase64String(elGamalPublicKey.getEncoded()));
		System.out.println("Private Key:" + Base64.encodeBase64String(elGamaPrivateKey.getEncoded()));
		
	}
} 
	






































