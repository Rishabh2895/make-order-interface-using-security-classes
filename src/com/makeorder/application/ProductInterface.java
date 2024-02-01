package com.makeorder.application;

import java.util.Scanner;

import com.makeorder.vo.OrderRequest;

public class ProductInterface {

	public OrderRequest createOrderRequest() {

		Scanner scanner = new Scanner(System.in);
		// Enter the product:
		System.out.print("Enter the product: ");
		String item = scanner.nextLine();
		// Enter product quantity: "
		System.out.print("Enter product quantity: ");
		int quantity = scanner.nextInt();
		// Enter product price:
		System.out.print("Enter product price: ");
		int price = scanner.nextInt();
		// Enter last 4 digits of credit card:
		System.out.print("Enter last 4 digits of credit card: ");
		System.out.println('\n');
		System.out.print("**** **** **** ____ (format)");
		System.out.println('\n');

		String cardNo = scanner.next();
		// "Enter credit card expiry date(MM/YYYY): "
		System.out.print("Enter credit card expiry date(MM/YYYY): ");
		String date = scanner.next();
		// "Enter Card Type: "
		System.out.print("Enter Card Type(Like: visa): ");
		String cardType = scanner.next();

		System.out.println('\n');
		System.out.print("**** **** **** ****");
		System.out.println('\n');
		System.out.print("* * *");
		System.out.println('\n');
		// "for reference"
		System.out.print("for reference");
		System.out.println('\n');
		System.out.print("Enter 3-digit cvv(at the back of your card): ");
		System.out.println('\n');
		String securityCode = scanner.next();

		// Use the customer name and product in the order request
		OrderRequest orderRequest = new OrderRequest();
		orderRequest.setItem(item);
		orderRequest.setQuantity(quantity);
		orderRequest.setPrice(price);
		orderRequest.setCreditCardNumber(cardNo);
		orderRequest.setExpDate(date);
		orderRequest.setCardType(cardType);
		orderRequest.setSecuritycode(securityCode);

		return orderRequest;
	}

	public void displayOrderConfirmation() {
		// Display an order confirmation message to the user
	}

}

// In order to create an OrderRequest object, the user can provide information
// using the class ProductInterface defined by this code.

// The user is prompted for information by the createOrderRequest() method,
// which constructs an OrderRequest object using the provided data, including
// the product name, quantity, price, and credit card details (card number,
// expiration date, card type, and security code).

// Currently empty, the displayOrderConfirmation() function appears to be
// designed to show the user an order confirmation message.
