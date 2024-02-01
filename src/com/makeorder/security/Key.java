package com.makeorder.security;

import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

public class Key {

	private SecretKey secretKey;

	public void generateKey() throws Exception {
		// Give the AES encryption algorithm's details and key size.

		KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		keyGen.init(128); // 128-bit key length

		// Produce a random key.

		secretKey = keyGen.generateKey();
		// secretKey = null;
		System.out.println("Key generated: " + secretKey);
	}

	public SecretKey getSecretKey() {
		try {
			generateKey();
		} catch (Exception e) {
			System.out.println("Exception when generating encryption key");
		}
		return secretKey; // return the secret key that was produced.

	}
}

// With the help of the AES algorithm, this Java class creates a secret key that
// can be used for both encryption and decryption. The KeyGenerator class from
// the Java Cryptography Architecture is used by the generateKey() method to
// create a random 128-bit key. If an exception occurs during key generation,
// the getSecretKey() function returns null instead of the secret key that was
// produced.

// Because the generateKey() function is called within the getSecretKey()
// method, a new key will be produced each time getSecretKey() is invoked. Given
// that creating keys may be computationally costly, this might not always be
// desired. The key might be generated once, kept in a safe place, and then
// retrieved as needed. This would be a preferable strategy.
