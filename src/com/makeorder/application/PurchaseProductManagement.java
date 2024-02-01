package com.makeorder.application;

import java.security.PublicKey;
import java.util.Base64;

import com.makeorder.security.Encryption;
import com.makeorder.vo.OrderRequest;

public class PurchaseProductManagement {

	public String processOrder(OrderRequest orderRequest, PublicKey publicKey) {

		String Areyousure = "";
		// Utilize the Encryption class to encrypt the credit card number.

		Encryption ultraencryption;
		try {
			ultraencryption = new Encryption();

			byte[] encryptedCreditCardNumber = ultraencryption.encrypt(orderRequest.getCreditCardNumber().getBytes());

			// Create a string out of the encrypted credit card number for display.

			String encryptedCreditCardValue = Base64.getEncoder().encodeToString(encryptedCreditCardNumber);

			// Show the user the encrypted credit card number.

			System.out.println("Card details after encryption: " + encryptedCreditCardValue);

			// Using the BankInterface class, display the encrypted credit card number and
			// ask for an authorisation code.

			BankInterface bankInterface = new BankInterface();
			int authcode = bankInterface.enterAuthCode();
			boolean isAuthorized = bankInterface.authorizePayment(encryptedCreditCardNumber, authcode);

			if (!isAuthorized) {
				System.out.println("Your Card is declined due to wrong input , Please enter all the details again.");
			} else {

				// } catch (Exception e) {
				// e.printStackTrace();
				// }

				// if (!checkSignature) {
				// return "User is not verified ,Please recreate order.";

				DeliveryOrder deliveryOrder = new DeliveryOrder();
				Areyousure = deliveryOrder.createOrder(orderRequest, publicKey);
			}

		} catch (Exception e) {

			e.printStackTrace();
		}

		return Areyousure;

	}

}

// Using the Encryption class to encrypt the credit card number in the order
// request and a public key object as input, the processOrder() function then
// transmits the encrypted credit card number to a bank interface for
// authorisation. The function creates a delivery order using the DeliveryOrder
// class and returns a string value if the authorisation is successful.