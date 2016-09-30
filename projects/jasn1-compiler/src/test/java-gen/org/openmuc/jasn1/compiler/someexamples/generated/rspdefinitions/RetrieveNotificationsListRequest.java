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

public class RetrieveNotificationsListRequest {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 43);
	protected BerIdentifier id;

	public byte[] code = null;
	public OctetTo16 seqNumber = null;

	public NotificationEvent profileManagementOperation = null;

	public RetrieveNotificationsListRequest() {
		id = identifier;
	}

	public RetrieveNotificationsListRequest(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public RetrieveNotificationsListRequest(OctetTo16 seqNumber, NotificationEvent profileManagementOperation) {
		id = identifier;
		this.seqNumber = seqNumber;
		this.profileManagementOperation = profileManagementOperation;
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
			if (profileManagementOperation != null) {
				codeLength += profileManagementOperation.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
			}
			
			if (seqNumber != null) {
				codeLength += seqNumber.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
				os.write(0x80);
				codeLength += 1;
			}
			
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

		if (totalLength == 0) {
			return codeLength;
		}
		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			seqNumber = new OctetTo16();
			subCodeLength += seqNumber.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			profileManagementOperation = new NotificationEvent();
			subCodeLength += profileManagementOperation.decode(is, false);
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
		boolean firstSelectedElement = true;
		if (seqNumber != null) {
			sb.append("seqNumber: ").append(seqNumber);
			firstSelectedElement = false;
		}
		
		if (profileManagementOperation != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("profileManagementOperation: ").append(profileManagementOperation);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}

