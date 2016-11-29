/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.some_example;

import java.io.IOException;
import java.io.EOFException;
import java.io.InputStream;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;
import java.io.UnsupportedEncodingException;
import org.openmuc.jasn1.ber.*;
import org.openmuc.jasn1.ber.types.*;
import org.openmuc.jasn1.ber.types.string.*;


public class UnTaggedChoice {

	public byte[] code = null;
	public BerInteger myInteger = null;

	public BerBoolean myBoolean = null;

	public UnTaggedChoice() {
	}

	public UnTaggedChoice(byte[] code) {
		this.code = code;
	}

	public UnTaggedChoice(BerInteger myInteger, BerBoolean myBoolean) {
		this.myInteger = myInteger;
		this.myBoolean = myBoolean;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (myBoolean != null) {
			codeLength += myBoolean.encode(os, true);
			return codeLength;

		}
		
		if (myInteger != null) {
			codeLength += myInteger.encode(os, true);
			return codeLength;

		}
		
		throw new IOException("Error encoding BerChoice: No item in choice was selected.");
	}

	public int decode(InputStream is, BerIdentifier berIdentifier) throws IOException {
		int codeLength = 0;
		BerIdentifier passedIdentifier = berIdentifier;

		if (berIdentifier == null) {
			berIdentifier = new BerIdentifier();
			codeLength += berIdentifier.decode(is);
		}

		BerLength length = new BerLength();
		if (berIdentifier.equals(BerInteger.identifier)) {
			myInteger = new BerInteger();
			codeLength += myInteger.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerBoolean.identifier)) {
			myBoolean = new BerBoolean();
			codeLength += myBoolean.decode(is, false);
			return codeLength;
		}

		if (passedIdentifier != null) {
			return 0;
		}
		throw new IOException("Error decoding BerChoice: Identifier matched to no item.");
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		if ( myInteger!= null) {
			return "CHOICE{myInteger: " + myInteger + "}";
		}

		if ( myBoolean!= null) {
			return "CHOICE{myBoolean: " + myBoolean + "}";
		}

		return "unknown";
	}

}
