package hu.ponte.hr.services;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.Signature;
import java.security.SignatureException;
import java.util.Base64;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
public class SignService {
	
	private static Signature sign;
	private static SecureRandom secureRandom;
	private static KeyPairGenerator keyPairGenerator;
	private static KeyPair keyPair;
	
	static {
		try {
			sign = Signature.getInstance("SHA256withRSA");
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		secureRandom = new SecureRandom();
		try {
			keyPairGenerator = KeyPairGenerator.getInstance("RSA");
			keyPair = keyPairGenerator.generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}
	
	public String signAndBase64EncodeFile(MultipartFile file)
			throws NoSuchAlgorithmException, InvalidKeyException, IOException, SignatureException {
		
		sign.initSign(keyPair.getPrivate(), secureRandom);
		byte[] bytes = file.getBytes();
		sign.update(bytes);
		byte[] signature = sign.sign();
		String encodedString = Base64.getEncoder().encodeToString(signature);
		return encodedString;
	}

}
