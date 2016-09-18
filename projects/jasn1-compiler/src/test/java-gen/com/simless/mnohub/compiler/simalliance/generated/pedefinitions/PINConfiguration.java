/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
 */

package com.simless.mnohub.compiler.simalliance.generated.pedefinitions;

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


public class PINConfiguration {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public PINKeyReferenceValue keyReference = null;

	public BerOctetString pinValue = null;

	public PUKKeyReferenceValue unblockingPINReference = null;

	public UInt8 pinAttributes = null;

	public UInt8 maxNumOfAttemps_retryNumLeft = null;

	public PINConfiguration() {
		id = identifier;
	}

	public PINConfiguration(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PINConfiguration(PINKeyReferenceValue keyReference, BerOctetString pinValue, PUKKeyReferenceValue unblockingPINReference, UInt8 pinAttributes, UInt8 maxNumOfAttemps_retryNumLeft) {
		id = identifier;
		this.keyReference = keyReference;
		this.pinValue = pinValue;
		this.unblockingPINReference = unblockingPINReference;
		this.pinAttributes = pinAttributes;
		this.maxNumOfAttemps_retryNumLeft = maxNumOfAttemps_retryNumLeft;
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
			if (maxNumOfAttemps_retryNumLeft != null) {
				codeLength += maxNumOfAttemps_retryNumLeft.encode(os, true);
			}
			
			if (pinAttributes != null) {
				codeLength += pinAttributes.encode(os, true);
			}
			
			if (unblockingPINReference != null) {
				codeLength += unblockingPINReference.encode(os, true);
			}
			
			codeLength += pinValue.encode(os, true);
			
			codeLength += keyReference.encode(os, true);
			
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

		codeLength += length.val;

		if (length.val == -1) {
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
			if (berIdentifier.equals(PINKeyReferenceValue.identifier)) {
				keyReference = new PINKeyReferenceValue();
				subCodeLength += keyReference.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				throw new IOException("Identifier does not match required sequence element identifer.");
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
			if (berIdentifier.equals(BerOctetString.identifier)) {
				pinValue = new BerOctetString();
				subCodeLength += pinValue.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				throw new IOException("Identifier does not match required sequence element identifer.");
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
			if (berIdentifier.equals(PUKKeyReferenceValue.identifier)) {
				unblockingPINReference = new PUKKeyReferenceValue();
				subCodeLength += unblockingPINReference.decode(is, false);
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
			if (berIdentifier.equals(UInt8.identifier)) {
				pinAttributes = new UInt8();
				subCodeLength += pinAttributes.decode(is, false);
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
			if (berIdentifier.equals(UInt8.identifier)) {
				maxNumOfAttemps_retryNumLeft = new UInt8();
				subCodeLength += maxNumOfAttemps_retryNumLeft.decode(is, false);
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
		if (berIdentifier.equals(PINKeyReferenceValue.identifier)) {
			keyReference = new PINKeyReferenceValue();
			subCodeLength += keyReference.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerOctetString.identifier)) {
			pinValue = new BerOctetString();
			subCodeLength += pinValue.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(PUKKeyReferenceValue.identifier)) {
			unblockingPINReference = new PUKKeyReferenceValue();
			subCodeLength += unblockingPINReference.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(UInt8.identifier)) {
			pinAttributes = new UInt8();
			subCodeLength += pinAttributes.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(UInt8.identifier)) {
			maxNumOfAttemps_retryNumLeft = new UInt8();
			subCodeLength += maxNumOfAttemps_retryNumLeft.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + length.val + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("keyReference: ").append(keyReference);
		
		sb.append(", ");
		sb.append("pinValue: ").append(pinValue);
		
		if (unblockingPINReference != null) {
			sb.append(", ");
			sb.append("unblockingPINReference: ").append(unblockingPINReference);
		}
		
		if (pinAttributes != null) {
			sb.append(", ");
			sb.append("pinAttributes: ").append(pinAttributes);
		}
		
		if (maxNumOfAttemps_retryNumLeft != null) {
			sb.append(", ");
			sb.append("maxNumOfAttemps_retryNumLeft: ").append(maxNumOfAttemps_retryNumLeft);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

