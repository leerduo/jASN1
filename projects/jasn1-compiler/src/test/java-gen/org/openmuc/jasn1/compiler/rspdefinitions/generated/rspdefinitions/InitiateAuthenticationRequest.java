/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions.generated.rspdefinitions;

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

import org.openmuc.jasn1.compiler.rspdefinitions.generated.teletexdomaindefinedattributes.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1implicit88.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1explicit88.*;

public class InitiateAuthenticationRequest {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 57);
	protected BerIdentifier id;

	public byte[] code = null;
	public Octet16 euiccChallenge = null;

	public BerUTF8String smdpAddress = null;

	public EUICCInfo1 euiccInfo1 = null;

	public InitiateAuthenticationRequest() {
		id = identifier;
	}

	public InitiateAuthenticationRequest(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public InitiateAuthenticationRequest(Octet16 euiccChallenge, BerUTF8String smdpAddress, EUICCInfo1 euiccInfo1) {
		id = identifier;
		this.euiccChallenge = euiccChallenge;
		this.smdpAddress = smdpAddress;
		this.euiccInfo1 = euiccInfo1;
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
			codeLength += euiccInfo1.encode(os, true);
			
			codeLength += smdpAddress.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			os.write(0x83);
			codeLength += 1;
			
			codeLength += euiccChallenge.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			euiccChallenge = new Octet16();
			subCodeLength += euiccChallenge.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			smdpAddress = new BerUTF8String();
			subCodeLength += smdpAddress.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(EUICCInfo1.identifier)) {
			euiccInfo1 = new EUICCInfo1();
			subCodeLength += euiccInfo1.decode(is, false);
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
		sb.append("euiccChallenge: ").append(euiccChallenge);
		
		sb.append(", ");
		sb.append("smdpAddress: ").append(smdpAddress);
		
		sb.append(", ");
		sb.append("euiccInfo1: ").append(euiccInfo1);
		
		sb.append("}");
		return sb.toString();
	}

}

