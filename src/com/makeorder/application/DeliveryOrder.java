package com.makeorder.application;

// Add the necessary classes and packages.

import java.security.PublicKey;
import com.makeorder.security.DigitalSignatureVerifier;
import com.makeorder.vo.OrderRequest;

// Create a class named DeliveryOrder that is public.

public class DeliveryOrder {

	// Create a public method named createOrder that receives an argument of an
	// OrderRequest object and a return value of a string.

	public String createOrder(OrderRequest or, PublicKey publicKey) {

		// Using the supplied public key, create a DigitalSignatureVerifier object.

		DigitalSignatureVerifier verifier = new DigitalSignatureVerifier(publicKey);

		// Create a boolean variable and set it to true to store the outcome of the
		// digital signature verification.

		boolean checkSignature = false;

		try {
			// Utilize the verifySignature method of the DigitalSignatureVerifier object to
			// validate the OrderRequest object's digital signature.

			checkSignature = verifier.verifySignature(or.toByteArray(), or.getSignature());
		} catch (Exception e) {
			// Print the exception's stack trace.

			e.printStackTrace();
		}

		// String encryptedCreditCardValue =
		// Base64.getEncoder().encodeToString(encryptedCreditCardNumber);

		// // Display the encrypted credit card number to the user
		// System.out.println("Encrypted Credit Card Number: " +
		// encryptedCreditCardValue);

		// // Display the encrypted credit card number and prompt for an authorization
		// code
		// // using the BankInterface class

		// Return a message stating that the user is not verified and must recreate
		// their purchase if the digital signature is invalid.

		if (!checkSignature) {
			return "User not validated. Please re-create your purchase.";
		} else {
			// Return a message stating that the order has been successfully formed and
			// including a list of the order information if the digital signature is valid.

			return "Order is successfully created !!! |  Order summary: Product Name = " + or.getItem()
					+ "  No. of items: "
					+ or.getQuantity() + " Amount: $ " + or.getPrice();
		}
	}

	// // All checks passed, order request is valid
	// return true;
}

// A "PublicKey" object and an instance of the "OrderRequest" class are required
// parameters for the sole method "createOrder" in the "DeliveryOrder" class,
// which is defined in this Java code. The function returns a string.

// Using the supplied public key, the method first generates a
// "DigitalSignatureVerifier" object, and then uses the "verifySignature" method
// of the verifier object to try to validate the digital signature of the order
// request object. The method returns a message stating that the user is not
// verified and has to recreate their purchase if the digital signature is
// invalid. If not, the procedure produces a message containing a list of the
// order's information and a statement that the order was successfully formed.
