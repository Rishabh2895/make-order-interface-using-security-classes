package com.makeorder.main;

// Bring in the required  classes

import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import com.makeorder.application.ProductInterface;
import com.makeorder.application.PurchaseProductManagement;
import com.makeorder.security.CreditCardChecker;
import com.makeorder.security.DigitalSignatureGenerator;
import com.makeorder.security.ProductRequestChecker;
import com.makeorder.vo.OrderRequest;

// specify class

public class MakeOrderRequest {

	// main method definition

	public static void main(String[] args) {

		// Create a ProductInterface instance and a purchase request.

		ProductInterface ci = new ProductInterface();
		OrderRequest or = ci.createOrderRequest();

		// Verify the order request's legitimacy and the credit card data.

		ProductRequestChecker oc = new ProductRequestChecker();
		CreditCardChecker cc = new CreditCardChecker();
		boolean isOrderValid = oc.verifyOrderRequest(or);
		boolean isCCValid = cc.verifyCreditCard(or);

		// Order signature Request

		// Create the OrderRequest's digital signature.

		KeyPairGenerator keyPairGen;
		try {
			keyPairGen = KeyPairGenerator.getInstance("RSA");
			keyPairGen.initialize(2048);
			KeyPair keyPair = keyPairGen.generateKeyPair();
			PrivateKey privateKey = keyPair.getPrivate();
			PublicKey publicKey = keyPair.getPublic();
			DigitalSignatureGenerator signatureGenerator = new DigitalSignatureGenerator(privateKey);
			byte[] signature = signatureGenerator.generate(or.toByteArray());

			// Add the OrderRequest's digital signature.

			or.setSignature(signature);

			// Ask the user to enter product information again if the order is invalid.

			if (!isOrderValid) {
				System.out.println("Please enter product details again:");
				main(args);
			}

			// Print a message confirming the credit card's validity if necessary.

			if (isCCValid) {
				System.out.println("Credit card is valid!");
			} else {
				// Ask the user to enter the product information again if the payment card is
				// invalid.

				System.out.println("Credit card details are invalid, Please enter product details again:");
				main(args);
			}

			// Process the order if the payment card and the order are both legitimate.

			if (isCCValid && isOrderValid) {
				PurchaseProductManagement pm = new PurchaseProductManagement();
				String confirmation = pm.processOrder(or, publicKey);
				System.out.println(confirmation);
			}

		} catch (Exception e) {
			// Print the stack trace if there is a mistake.

			e.printStackTrace();
		}
	}
}

// The main method, which serves as the program's entry point, is contained in
// the MakeOrderRequest class.

// The createOrderRequest() function of ProductInterface is used to generate an
// OrderRequest object at the beginning of the application.
// To check the accuracy of the OrderRequest and credit card information,
// respectively, the ProductRequestChecker and CreditCardChecker classes are
// utilized.

// The OrderRequest object receives a digital signature that is created by a
// DigitalSignatureGenerator object and is then appended to the object.

// The application alerts the user to enter the information again if the
// OrderRequest or payment card information is incorrect.
// The application creates an instance of PurchaseProductManagement and runs its
// processOrder function, handing in the OrderRequest object and the public key
// for confirming the digital signature, if the OrderRequest and credit card
// details are correct.
// The order is processed using PurchaseProductManagement's processOrder method,
// which also produces a user-visible confirmation message.
