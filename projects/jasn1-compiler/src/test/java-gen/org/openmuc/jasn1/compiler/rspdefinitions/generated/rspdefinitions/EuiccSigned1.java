/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
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

import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1implicit88.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1explicit88.*;

public class EuiccSigned1 {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public Octet16 serverChallenge = null;

	public OctetTo16 transactionId = null;

	public BerUTF8String serverAddress = null;

	public BerOctetString euiccOtpk = null;

	public EUICCInfo2 euiccInfo2 = null;

	public CtxParams1 ctxParams1 = null;

	public EuiccSigned1() {
		id = identifier;
	}

	public EuiccSigned1(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public EuiccSigned1(Octet16 serverChallenge, OctetTo16 transactionId, BerUTF8String serverAddress, BerOctetString euiccOtpk, EUICCInfo2 euiccInfo2, CtxParams1 ctxParams1) {
		id = identifier;
		this.serverChallenge = serverChallenge;
		this.transactionId = transactionId;
		this.serverAddress = serverAddress;
		this.euiccOtpk = euiccOtpk;
		this.euiccInfo2 = euiccInfo2;
		this.ctxParams1 = ctxParams1;
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
			codeLength += ctxParams1.encode(os, true);
			
			codeLength += euiccInfo2.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 34
			os.write(0x22);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += euiccOtpk.encode(os, true);
			
			codeLength += serverAddress.encode(os, true);
			
			codeLength += transactionId.encode(os, true);
			
			codeLength += serverChallenge.encode(os, true);
			
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
			if (berIdentifier.equals(Octet16.identifier)) {
				serverChallenge = new Octet16();
				subCodeLength += serverChallenge.decode(is, false);
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
			if (berIdentifier.equals(OctetTo16.identifier)) {
				transactionId = new OctetTo16();
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
			if (berIdentifier.equals(BerUTF8String.identifier)) {
				serverAddress = new BerUTF8String();
				subCodeLength += serverAddress.decode(is, false);
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
			if (berIdentifier.equals(BerOctetString.identifier)) {
				euiccOtpk = new BerOctetString();
				subCodeLength += euiccOtpk.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 34)) {
				euiccInfo2 = new EUICCInfo2();
				subCodeLength += euiccInfo2.decode(is, false);
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
			ctxParams1 = new CtxParams1();
			int choiceDecodeLength = ctxParams1.decode(is, berIdentifier);
			if (choiceDecodeLength != 0) {
				subCodeLength += choiceDecodeLength;
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				ctxParams1 = null;
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
		if (berIdentifier.equals(Octet16.identifier)) {
			serverChallenge = new Octet16();
			subCodeLength += serverChallenge.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(OctetTo16.identifier)) {
			transactionId = new OctetTo16();
			subCodeLength += transactionId.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerUTF8String.identifier)) {
			serverAddress = new BerUTF8String();
			subCodeLength += serverAddress.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerOctetString.identifier)) {
			euiccOtpk = new BerOctetString();
			subCodeLength += euiccOtpk.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 34)) {
			euiccInfo2 = new EUICCInfo2();
			subCodeLength += euiccInfo2.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		ctxParams1 = new CtxParams1();
		subCodeLength += ctxParams1.decode(is, berIdentifier);
		if (subCodeLength == totalLength) {
			return codeLength;
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
		sb.append("serverChallenge: ").append(serverChallenge);
		
		sb.append(", ");
		sb.append("transactionId: ").append(transactionId);
		
		sb.append(", ");
		sb.append("serverAddress: ").append(serverAddress);
		
		sb.append(", ");
		sb.append("euiccOtpk: ").append(euiccOtpk);
		
		sb.append(", ");
		sb.append("euiccInfo2: ").append(euiccInfo2);
		
		sb.append(", ");
		sb.append("ctxParams1: ").append(ctxParams1);
		
		sb.append("}");
		return sb.toString();
	}

}

