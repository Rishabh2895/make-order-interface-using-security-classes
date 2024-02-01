package com.makeorder.security;

import com.makeorder.vo.OrderRequest;

public class CreditCardChecker {

    // This process checks the order request's payment card details.

    public boolean verifyCreditCard(OrderRequest orderRequest) {
        // Verify that the credit card's expiration date and numeric data are not empty
        // or null.

        boolean ccCheck = true;
        if (orderRequest.getCreditCardNumber() == null || orderRequest.getCreditCardNumber().isEmpty()
                || orderRequest.getExpDate() == null || orderRequest.getExpDate().isEmpty()) {
            return false;
        }

        // Verify the legitimacy of the payment card.

        boolean isCreditCardValid = validateCreditCard(orderRequest, ccCheck);
        if (!isCreditCardValid) {
            return false;
        }

        // Every check was successful, and the payment card data is accurate.

        return true;
    }

    // This procedure verifies the credit card number format, CVV, and card type.

    private boolean validateCreditCard(OrderRequest or, boolean ccCheck) {

        // Verify the validity of the credit card number as an integer.

        if (or.getCreditCardNumber() != null || !or.getCreditCardNumber().isEmpty()) {
            try {
                int intValue = Integer.parseInt(or.getCreditCardNumber());
            } catch (NumberFormatException e) {
                System.out.println("Card details should be an integer.");
                ccCheck = false;
            }
        } else {
            System.out.println("Card should contain some value.");
        }

        // Verify the CVV to ensure it is an integer.

        if (or.getSecuritycode() != null || !or.getSecuritycode().isEmpty()) {
            try {
                int intValue = Integer.parseInt(or.getSecuritycode());
            } catch (NumberFormatException e) {
                System.out.println("CVV code should only contain numeric digits.");
                ccCheck = false;
            }
        } else {
            System.out.println("CVV should not be empty.");
        }

        // Verify that the card type is not empty or null.

        if (or.getCardType() == null || or.getCardType().isEmpty()) {
            System.out.println("Card type should not be empty.");
            ccCheck = false;
        }

        // If the credit card is invalid, return false.

        return ccCheck;
    }
}

// This Java class establishes a CreditCardChecker with the following two
// methods:

// VerifyCreditCard(OrderRequest orderRequest) returns a boolean result
// indicating whether or not the credit card information in the order request is
// legitimate. It accepts an OrderRequest object as input. The procedure
// initially verifies that the credit card's number and expiration date are not
// empty or null. The method returns false if they are. If not, it runs a
// another method called validateCreditCard to run more checks on the credit
// card data. The function returns true if every check is successful.

// OrderRequest or, boolean ccCheck, validateCreditCard A boolean value and an
// OrderRequest object are required arguments for this private helper function,
// which returns a boolean value indicating whether or not the credit card
// information in the order request is legitimate. The method verifies the
// credit card data three times: first, to see if the credit card number is an
// integer; second, to see if the CVV is an integer; and third, to see if the
// card type is not null or empty. The procedure sets the ccCheck boolean to
// false if any of these tests are unsuccessful. The ccCheck value is returned
// by the method.
