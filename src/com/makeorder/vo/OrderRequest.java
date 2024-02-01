package com.makeorder.vo;

import java.io.*;
import java.io.IOException;

public class OrderRequest {

	// Details of the order fields

	private String item;
	private int quantity;
	private int price;
	private String creditCardNumber;
	private String cardType;
	private String expDate;
	private String securitycode;
	private byte[] signature;

	// Fields' getter and setter methods

	public String getItem() {
		return item;
	}

	public void setItem(String item) {
		this.item = item;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getCreditCardNumber() {
		return creditCardNumber;
	}

	public void setCreditCardNumber(String creditCardNumber) {
		this.creditCardNumber = creditCardNumber;
	}

	public String getExpDate() {
		return expDate;
	}

	public void setExpDate(String expDate) {
		this.expDate = expDate;
	}

	public String getSecuritycode() {
		return securitycode;
	}

	public void setSecuritycode(String securitycode) {
		this.securitycode = securitycode;
	}

	public byte[] getSignature() {
		return signature;
	}

	public void setSignature(byte[] signature) {
		this.signature = signature;
	}

	public String getCardType() {
		return cardType;
	}

	public void setCardType(String cardType) {
		this.cardType = cardType;
	}

	// How to create a byte array from an OrderRequest object for encrypting

	public byte[] toByteArray() throws IOException {
		ByteArrayOutputStream baos = new ByteArrayOutputStream(); // new ByteArrayOutputStream object is created.

		DataOutputStream dos = new DataOutputStream(baos); // Bypasses the ByteArrayOutputStream object to create a new
															// DataOutputStream object.

		dos.writeUTF(item); // 'item' field is written to the DataOutputStream object.

		dos.writeInt(quantity); // 'quantity' field is written to the DataOutputStream object.

		dos.writeInt(price); // 'price' field is written to the DataOutputStream object.

		dos.writeUTF(creditCardNumber); // 'creditCardNumber' field is written to the DataOutputStream object.

		dos.writeUTF(expDate); // 'expDate' property is written to the DataOutputStream object.

		dos.writeUTF(securitycode); // 'securitycode' field is written to the DataOutputStream object.

		dos.writeUTF(cardType); // 'cardType' field is written to the DataOutputStream object.

		dos.flush(); // Ensures that all bytes are written to the ByteArrayOutputStream object by
						// flushing the DataOutputStream object.

		return baos.toByteArray(); // returns the ByteArrayOutputStream object's byte array representation.

	}
}

// An order request and all of its information are represented by the
// OrderRequest class. Items, quantities, prices, credit card numbers, card
// types, expiration dates, security codes, and signatures are all listed in the
// fields. Each field additionally contains getter and setter methods.

// The class additionally has a toByteArray method for encrypting OrderRequest
// objects by converting them to byte arrays. With the ByteArrayOutputStream
// object as an input, this function generates a DataOutputStream object and a
// ByteArrayOutputStream object. The DataOutputStream object is then flushed to
// make sure all the bytes are sent to the ByteArrayOutputStream object before
// the values of the fields of the OrderRequest object are written to it using
// its write methods. Finally, it returns the ByteArrayOutputStream object's
// byte array representation.
