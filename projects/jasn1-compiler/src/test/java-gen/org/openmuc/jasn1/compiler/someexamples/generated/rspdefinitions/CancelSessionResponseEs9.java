/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions;

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

import org.openmuc.jasn1.compiler.someexamples.generated.pkix1implicit88.*;
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88.*;

public class CancelSessionResponseEs9 {

	public byte[] code = null;
	public CancelSessionOk cancelSessionOk = null;

	public BerInteger cancelSessionError = null;

	public CancelSessionResponseEs9() {
	}

	public CancelSessionResponseEs9(byte[] code) {
		this.code = code;
	}

	public CancelSessionResponseEs9(CancelSessionOk cancelSessionOk, BerInteger cancelSessionError) {
		this.cancelSessionOk = cancelSessionOk;
		this.cancelSessionError = cancelSessionError;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (cancelSessionError != null) {
			codeLength += cancelSessionError.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			return codeLength;

		}
		
		if (cancelSessionOk != null) {
			codeLength += cancelSessionOk.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			os.write(0xa0);
			codeLength += 1;
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			cancelSessionOk = new CancelSessionOk();
			codeLength += cancelSessionOk.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			cancelSessionError = new BerInteger();
			codeLength += cancelSessionError.decode(is, false);
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
		if ( cancelSessionOk!= null) {
			return "CHOICE{cancelSessionOk: " + cancelSessionOk + "}";
		}

		if ( cancelSessionError!= null) {
			return "CHOICE{cancelSessionError: " + cancelSessionError + "}";
		}

		return "unknown";
	}

}

