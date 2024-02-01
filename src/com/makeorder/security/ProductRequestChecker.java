package com.makeorder.security;

import com.makeorder.vo.OrderRequest;

public class ProductRequestChecker {

	public boolean verifyOrderRequest(OrderRequest orderRequest) {
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

		// Verify that the credit card's expiration date and numeric data are not empty
		// or null.

		boolean verifyOrder = true;

		// Verify that the item name is not empty or null.

		if (orderRequest.getItem() == null || orderRequest.getItem().isEmpty()) {
			System.out.println("Item cannot be blank");
			verifyOrder = false;
		}

		// Verify that there are no negative prices.

		if (orderRequest.getPrice() < 0) {
			System.out.println("Product price can not be negative.");
			verifyOrder = false;
		}

		// Verify whether the amount is positive.

		if (orderRequest.getQuantity() <= 0) {
			System.out.println("Quantity should not be negative or equal to 0");
			verifyOrder = false;
		}

		// Whether the order request is genuine or not, please report

		return verifyOrder;
	}
}

// The verifyOrderRequest function of the ProductRequestChecker class receives
// an OrderRequest object as input and returns a boolean result indicating the
// validity of the order request. The following tests are run by the method:

// determines if the OrderRequest object's item field is not null or empty. If
// it is, verifyOrder is set to false and an error notice is printed.
// Ensures that the OrderRequest object's price field is not negative. If it is,
// verifyOrder is set to false and an error notice is printed.
// determines if the OrderRequest object's quantity field is positive. If not,
// verifyOrder is set to false and an error notice is shown.
// returns the boolean value for verifyOrder.
