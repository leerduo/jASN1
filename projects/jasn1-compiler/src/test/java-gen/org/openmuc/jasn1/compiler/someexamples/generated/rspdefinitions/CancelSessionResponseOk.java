/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
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

public class CancelSessionResponseOk {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public EuiccCancelSessionSigned euiccCancelSessionSigned = null;

	public BerOctetString euiccCancelSessionSignature = null;

	public CancelSessionResponseOk() {
		id = identifier;
	}

	public CancelSessionResponseOk(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public CancelSessionResponseOk(EuiccCancelSessionSigned euiccCancelSessionSigned, BerOctetString euiccCancelSessionSignature) {
		id = identifier;
		this.euiccCancelSessionSigned = euiccCancelSessionSigned;
		this.euiccCancelSessionSignature = euiccCancelSessionSignature;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {

		int codeLength;

		if (code != null) {
			codeLength = code.length;
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
		}
		else {
			codeLength = 0;
			codeLength += euiccCancelSessionSignature.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 55
			os.write(0x37);
			os.write(0x5f);
			codeLength += 2;
			
			codeLength += euiccCancelSessionSigned.encode(os, true);
			
			codeLength += BerLength.encodeLength(os, codeLength);
		}

		if (explicit) {
			codeLength += id.encode(os);
		}

		return codeLength;

	}

	public int decode(InputStream is, boolean explicit) throws IOException {
		int codeLength = 0;
		int subCodeLength = 0;
		BerIdentifier berIdentifier = new BerIdentifier();

		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		int totalLength = length.val;
		codeLength += totalLength;

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(EuiccCancelSessionSigned.identifier)) {
			euiccCancelSessionSigned = new EuiccCancelSessionSigned();
			subCodeLength += euiccCancelSessionSigned.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 55)) {
			euiccCancelSessionSignature = new BerOctetString();
			subCodeLength += euiccCancelSessionSignature.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + totalLength + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("euiccCancelSessionSigned: ").append(euiccCancelSessionSigned);
		
		sb.append(", ");
		sb.append("euiccCancelSessionSignature: ").append(euiccCancelSessionSignature);
		
		sb.append("}");
		return sb.toString();
	}

}

