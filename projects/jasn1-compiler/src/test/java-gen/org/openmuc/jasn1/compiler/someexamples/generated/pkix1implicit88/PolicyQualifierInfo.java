/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.pkix1implicit88;

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

import org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions.*;
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88.*;

public class PolicyQualifierInfo {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public PolicyQualifierId policyQualifierId = null;

	public BerAny qualifier = null;

	public PolicyQualifierInfo() {
		id = identifier;
	}

	public PolicyQualifierInfo(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PolicyQualifierInfo(PolicyQualifierId policyQualifierId, BerAny qualifier) {
		id = identifier;
		this.policyQualifierId = policyQualifierId;
		this.qualifier = qualifier;
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
			codeLength += qualifier.encode(os);
			
			codeLength += policyQualifierId.encode(os, true);
			
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
		if (berIdentifier.equals(PolicyQualifierId.identifier)) {
			policyQualifierId = new PolicyQualifierId();
			subCodeLength += policyQualifierId.decode(is, false);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		qualifier = new BerAny();
		subCodeLength += qualifier.decode(is, totalLength - subCodeLength);
		return codeLength;
		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("policyQualifierId: ").append(policyQualifierId);
		
		sb.append(", ");
		sb.append("qualifier: ").append(qualifier);
		
		sb.append("}");
		return sb.toString();
	}

}

