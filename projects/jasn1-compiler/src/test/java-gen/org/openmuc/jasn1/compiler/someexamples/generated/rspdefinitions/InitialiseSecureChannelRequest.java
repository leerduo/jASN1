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

public class InitialiseSecureChannelRequest {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 35);
	protected BerIdentifier id;

	public byte[] code = null;
	public RemoteOpId remoteOpId = null;

	public TransactionId transactionId = null;

	public ControlRefTemplate controlRefTemplate = null;

	public BerOctetString smdpOtpk = null;

	public BerOctetString smdpSign = null;

	public InitialiseSecureChannelRequest() {
		id = identifier;
	}

	public InitialiseSecureChannelRequest(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public InitialiseSecureChannelRequest(RemoteOpId remoteOpId, TransactionId transactionId, ControlRefTemplate controlRefTemplate, BerOctetString smdpOtpk, BerOctetString smdpSign) {
		id = identifier;
		this.remoteOpId = remoteOpId;
		this.transactionId = transactionId;
		this.controlRefTemplate = controlRefTemplate;
		this.smdpOtpk = smdpOtpk;
		this.smdpSign = smdpSign;
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
			codeLength += smdpSign.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 55
			os.write(0x37);
			os.write(0x5f);
			codeLength += 2;
			
			codeLength += smdpOtpk.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 73
			os.write(0x49);
			os.write(0x5f);
			codeLength += 2;
			
			codeLength += controlRefTemplate.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
			os.write(0xa6);
			codeLength += 1;
			
			codeLength += transactionId.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			os.write(0x80);
			codeLength += 1;
			
			codeLength += remoteOpId.encode(os, true);
			
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

		if (totalLength == -1) {
			subCodeLength += berIdentifier.decode(is);

			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(RemoteOpId.identifier)) {
				remoteOpId = new RemoteOpId();
				subCodeLength += remoteOpId.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				transactionId = new TransactionId();
				subCodeLength += transactionId.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
				controlRefTemplate = new ControlRefTemplate();
				subCodeLength += controlRefTemplate.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 73)) {
				smdpOtpk = new BerOctetString();
				subCodeLength += smdpOtpk.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 55)) {
				smdpSign = new BerOctetString();
				subCodeLength += smdpSign.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			int nextByte = is.read();
			if (berIdentifier.tagNumber != 0 || berIdentifier.identifierClass != 0 || berIdentifier.primitive != 0
			|| nextByte != 0) {
				if (nextByte == -1) {
					throw new EOFException("Unexpected end of input stream.");
				}
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			codeLength += subCodeLength + 1;
			return codeLength;
		}

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(RemoteOpId.identifier)) {
			remoteOpId = new RemoteOpId();
			subCodeLength += remoteOpId.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			transactionId = new TransactionId();
			subCodeLength += transactionId.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
			controlRefTemplate = new ControlRefTemplate();
			subCodeLength += controlRefTemplate.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 73)) {
			smdpOtpk = new BerOctetString();
			subCodeLength += smdpOtpk.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 55)) {
			smdpSign = new BerOctetString();
			subCodeLength += smdpSign.decode(is, false);
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
		sb.append("remoteOpId: ").append(remoteOpId);
		
		sb.append(", ");
		sb.append("transactionId: ").append(transactionId);
		
		sb.append(", ");
		sb.append("controlRefTemplate: ").append(controlRefTemplate);
		
		sb.append(", ");
		sb.append("smdpOtpk: ").append(smdpOtpk);
		
		sb.append(", ");
		sb.append("smdpSign: ").append(smdpSign);
		
		sb.append("}");
		return sb.toString();
	}

}

