package com.makeorder.security;

import java.security.PrivateKey;
import java.security.Signature;

public class DigitalSignatureGenerator {

	// Private key used to generate digital signature
	private PrivateKey privateKey;

	// Constructor
	public DigitalSignatureGenerator(PrivateKey privateKey) {
		this.privateKey = privateKey;
	}
	// In this example, the digital signature is generated using the SHA-256 hash
	// function and the RSA public-key cryptosystem.
	// The specific hash function and cryptosystem used may vary depending on your
	// application's
	// requirements.

	// Generates digital signature for given data using SHA256withRSA algorithm
	public byte[] generate(byte[] data) throws Exception {
		Signature signature = Signature.getInstance("SHA256withRSA");
		signature.initSign(privateKey);
		signature.update(data);
		return signature.sign();
	}
}

// Check if the customer name and product are not null or empty
// if (orderRequest.getCustomerName() == null ||
// orderRequest.getCustomerName().isEmpty()
// || orderRequest.getProduct() == null || orderRequest.getProduct().isEmpty())
// {
// return false;
// }
//
// // We can more checks based on product specification and quantity.
//
// // All checks passed, order request is valid
// return true;
// }

// There are two methods in this Java class that define a
// DigitalSignatureGenerator:

// Constructor: Using this method, a DigitalSignatureGenerator instance may be
// created by handing it a PrivateKey object. To create a digital signature, the
// PrivateKey object is utilized.

// generate(byte[] data) produces a byte array that represents the digital
// signature of the input data and accepts a byte array as input. The
// SHA256withRSA technique is used in the method's initial creation of the
// Signature object. The private key supplied to the constructor is then used to
// initialize the Signature object. The method then calls the sign() method to
// create the digital signature after updating the Signature object with the
// provided data. After that, a byte array containing the produced digital
// signature is returned.
