/**
 * This class file was automatically generated by jASN1 v1.6.0 (http://www.openmuc.org)
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

import org.openmuc.jasn1.compiler.someexamples.generated.teletexdomaindefinedattributes.*;
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1implicit88.*;
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88.*;

public class ProfileInstallationResultData {

	public static class FinalResult {

		public byte[] code = null;
		public SuccessResult successResult = null;

		public ErrorResult errorResult = null;

		public FinalResult() {
		}

		public FinalResult(byte[] code) {
			this.code = code;
		}

		public FinalResult(SuccessResult successResult, ErrorResult errorResult) {
			this.successResult = successResult;
			this.errorResult = errorResult;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;

			}
			int codeLength = 0;
			if (errorResult != null) {
				codeLength += errorResult.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
				os.write(0xa1);
				codeLength += 1;
				return codeLength;

			}
			
			if (successResult != null) {
				codeLength += successResult.encode(os, false);
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
				successResult = new SuccessResult();
				codeLength += successResult.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
				errorResult = new ErrorResult();
				codeLength += errorResult.decode(is, false);
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
			if ( successResult!= null) {
				return "CHOICE{successResult: " + successResult + "}";
			}

			if ( errorResult!= null) {
				return "CHOICE{errorResult: " + errorResult + "}";
			}

			return "unknown";
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 39);
	protected BerIdentifier id;

	public byte[] code = null;
	public TransactionId transactionId = null;

	public NotificationMetadata notificationMetadata = null;

	public BerObjectIdentifier smdpOid = null;

	public FinalResult finalResult = null;

	public ProfileInstallationResultData() {
		id = identifier;
	}

	public ProfileInstallationResultData(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ProfileInstallationResultData(TransactionId transactionId, NotificationMetadata notificationMetadata, BerObjectIdentifier smdpOid, FinalResult finalResult) {
		id = identifier;
		this.transactionId = transactionId;
		this.notificationMetadata = notificationMetadata;
		this.smdpOid = smdpOid;
		this.finalResult = finalResult;
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
			int sublength;

			sublength = finalResult.encode(os, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(os, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
			os.write(0xa2);
			codeLength += 1;
			
			if (smdpOid != null) {
				codeLength += smdpOid.encode(os, true);
			}
			
			codeLength += notificationMetadata.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 47
			os.write(0x2f);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += transactionId.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			os.write(0x80);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 47)) {
				notificationMetadata = new NotificationMetadata();
				subCodeLength += notificationMetadata.decode(is, false);
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
			if (berIdentifier.equals(BerObjectIdentifier.identifier)) {
				smdpOid = new BerObjectIdentifier();
				subCodeLength += smdpOid.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
				subCodeLength += length.decode(is);
				finalResult = new FinalResult();
				int choiceDecodeLength = finalResult.decode(is, null);
				if (choiceDecodeLength != 0) {
					subCodeLength += choiceDecodeLength;
					subCodeLength += berIdentifier.decode(is);
				}
				else {
					finalResult = null;
				}

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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			transactionId = new TransactionId();
			subCodeLength += transactionId.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 47)) {
			notificationMetadata = new NotificationMetadata();
			subCodeLength += notificationMetadata.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerObjectIdentifier.identifier)) {
			smdpOid = new BerObjectIdentifier();
			subCodeLength += smdpOid.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			subCodeLength += length.decode(is);
			finalResult = new FinalResult();
			subCodeLength += finalResult.decode(is, null);
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
		sb.append("transactionId: ").append(transactionId);
		
		sb.append(", ");
		sb.append("notificationMetadata: ").append(notificationMetadata);
		
		if (smdpOid != null) {
			sb.append(", ");
			sb.append("smdpOid: ").append(smdpOid);
		}
		
		sb.append(", ");
		sb.append("finalResult: ").append(finalResult);
		
		sb.append("}");
		return sb.toString();
	}

}

