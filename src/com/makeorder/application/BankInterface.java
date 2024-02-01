package com.makeorder.application;

// import the Java.util package's Scanner class.

import java.util.Scanner;

// Create the public class "BankInterface"

public class BankInterface {

	// Create the enterAuthCode public method, which should return an integer.

	public int enterAuthCode() {

		// To ask the user to provide a 3-digit authentication code, print a message.

		System.out.println("credit card validated! , Now Enter 3-digit auth code:");

		// In order to read input from the console, create a Scanner object.

		Scanner scanner = new Scanner(System.in);

		// Assign the integer input you read from the console to the variable authcode.

		int authcode = scanner.nextInt();

		// Give back the entered quantity as an integer.

		return authcode;

	}

	// Create the authorizePayment public method, which accepts an array of bytes
	// and an integer as parameters and returns a boolean value.

	public boolean authorizePayment(byte[] encryptedCreditCardNumber, int authcode) {

		// Verify that the permission code you entered is between 000 and 999.

		if (authcode >= 000 && authcode <= 999) {
			// Return true if the provided authorisation code is inside the range.

			return true;
		} else {
			// Return false if the provided authorisation code is out of range.

			return false;
		}

	}

}

// This Java code defines the "BankInterface" class, which has two methods for
// authorizing credit card payments. The first method, "enterAuthCode", asks the
// user to insert a 3-digit authorization code, reads the input from the console
// using a Scanner object, and returns the inputted value as an integer.

// Two parameters are required for the second method, "authorizePayment": an
// array of bytes containing an encrypted credit card number and an integer
// denoting the user-entered authorisation code. The method determines if the
// entered permission code falls within the range of 000 to 999 and returns true
// if it does or false otherwise.
