package com.makeorder.security;

import java.security.PublicKey;
import java.security.Signature;

public class DigitalSignatureVerifier {

    private PublicKey publicKey;

    // Initializable constructor for the public key

    public DigitalSignatureVerifier(PublicKey publicKey) {
        this.publicKey = publicKey;
    }

    // a process for utilizing the public key to validate data's digital signature

    public boolean verifySignature(byte[] data, byte[] signature) throws Exception {
        Signature sig = Signature.getInstance("SHA256withRSA");
        sig.initVerify(publicKey);
        sig.update(data);
        return sig.verify(signature);
    }
}

// There are two methods in this Java class that define a
// DigitalSignatureVerifier:

// Constructor: By giving a PublicKey object as input, this method creates an
// instance of the DigitalSignatureVerifier class. Using the PublicKey object,
// you may check a digital signature.

// verificationSignature(byte[] data, byte[] signature): The actual data and the
// data's digital signature are both inputted using two byte arrays in this
// manner. The SHA256withRSA technique is used in the method's initial creation
// of the Signature object. The public key supplied to the constructor is then
// used to initialize the Signature object. The function then calls the verify()
// method to confirm the digital signature after updating the Signature object
// with the provided data. If the digital signature is valid, the method returns
// true; otherwise, it returns false.
