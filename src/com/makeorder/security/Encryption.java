package com.makeorder.security;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class Encryption {

    public byte[] encrypt(byte[] input) throws Exception {
        // A new Key class instance should be created.

        Key key = new Key();
        // Obtain the secret key
        SecretKey secretKey = key.getSecretKey();

        // For AES encryption, make a new instance of the Cipher class.

        Cipher cipher = Cipher.getInstance("AES");

        // Verify to make sure the secret key is not null.

        if (secretKey != null) {
            // Set up the cipher in encrypted mode using the secret key.

            cipher.init(Cipher.ENCRYPT_MODE, secretKey);
            // encrypt the data supplied, then output the result

            return cipher.doFinal(input);
        } else {
            // Please produce an error notice and terminate the application if the secret
            // key is null.

            System.out.println("Key is not available. Please try again.");
            System.exit(0);
            return null; // Despite being unreachable, this line was included to please the compiler.

        }
    }

}

// Check if the customer name and product are not null or empty
// if (orderRequest.getCustomerName() == null ||
// orderRequest.getCustomerName().isEmpty()
// we are working pn the cipher of he text
// // We can more checks based on product specification and quantity.
//
// // All checks passed, order request is valid
// return true;
// }

// This Java class specifies the Encryption class, which consists of the
// following method:

// The method encrypt(byte[] input) accepts a byte array as input, which
// represents the data to be encrypted. To obtain a secret key using the
// getSecretKey() function, the method first generates an instance of the Key
// class. It then builds a Cipher class instance for AES encryption. The
// function encrypts the input data using the doFinal() method of the Cipher
// object and initializes the Cipher object with the secret key in encrypt mode
// if the secret key is not null. A byte array containing the encrypted data is
// returned. The method produces an error message and ends the program if the
// secret key is null.
