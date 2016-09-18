/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
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


public class My_Choice2 {

	public byte[] code = null;
	public BerInteger myint = null;

	public BerBoolean myboolean = null;

	public My_Choice2() {
	}

	public My_Choice2(byte[] code) {
		this.code = code;
	}

	public My_Choice2(BerInteger myint, BerBoolean myboolean) {
		this.myint = myint;
		this.myboolean = myboolean;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (myboolean != null) {
			codeLength += myboolean.encode(os, true);
			return codeLength;

		}
		
		if (myint != null) {
			codeLength += myint.encode(os, true);
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
		if (berIdentifier.equals(BerInteger.identifier)) {
			myint = new BerInteger();
			codeLength += myint.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerBoolean.identifier)) {
			myboolean = new BerBoolean();
			codeLength += myboolean.decode(is, false);
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
		if ( myint!= null) {
			return "CHOICE{myint: " + myint + "}";
		}

		if ( myboolean!= null) {
			return "CHOICE{myboolean: " + myboolean + "}";
		}

		return "unknown";
	}

}

