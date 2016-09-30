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

public class ProfileInstallationResult {

	public static class FirstSequenceOf87 {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<BerOctetString> seqOf = null;

		public FirstSequenceOf87() {
			id = identifier;
			seqOf = new ArrayList<BerOctetString>();
		}

		public FirstSequenceOf87(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public FirstSequenceOf87(List<BerOctetString> seqOf) {
			id = identifier;
			this.seqOf = seqOf;
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
				for (int i = (seqOf.size() - 1); i >= 0; i--) {
					codeLength += seqOf.get(i).encode(os, false);
					// write tag: CONTEXT_CLASS, PRIMITIVE, 7
					os.write(0x87);
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

			if (length.val == -1) {
				while (true) {
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

					BerOctetString element = new BerOctetString();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				BerOctetString element = new BerOctetString();
				subCodeLength += berIdentifier.decode(is);
				subCodeLength += element.decode(is, false);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
			encode(os, false);
			code = os.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("SEQUENCE OF{");

			if (seqOf == null) {
				sb.append("null");
			}
			else {
				Iterator<BerOctetString> it = seqOf.iterator();
				if (it.hasNext()) {
					sb.append(it.next());
					while (it.hasNext()) {
						sb.append(", ").append(it.next());
					}
				}
			}

			sb.append("}");

			return sb.toString();
		}

	}

	public static class SequenceOf88 {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<BerOctetString> seqOf = null;

		public SequenceOf88() {
			id = identifier;
			seqOf = new ArrayList<BerOctetString>();
		}

		public SequenceOf88(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public SequenceOf88(List<BerOctetString> seqOf) {
			id = identifier;
			this.seqOf = seqOf;
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
				for (int i = (seqOf.size() - 1); i >= 0; i--) {
					codeLength += seqOf.get(i).encode(os, false);
					// write tag: CONTEXT_CLASS, PRIMITIVE, 8
					os.write(0x88);
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

			if (length.val == -1) {
				while (true) {
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

					BerOctetString element = new BerOctetString();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				BerOctetString element = new BerOctetString();
				subCodeLength += berIdentifier.decode(is);
				subCodeLength += element.decode(is, false);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
			encode(os, false);
			code = os.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("SEQUENCE OF{");

			if (seqOf == null) {
				sb.append("null");
			}
			else {
				Iterator<BerOctetString> it = seqOf.iterator();
				if (it.hasNext()) {
					sb.append(it.next());
					while (it.hasNext()) {
						sb.append(", ").append(it.next());
					}
				}
			}

			sb.append("}");

			return sb.toString();
		}

	}

	public static class SecondSequenceOf87 {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<BerOctetString> seqOf = null;

		public SecondSequenceOf87() {
			id = identifier;
			seqOf = new ArrayList<BerOctetString>();
		}

		public SecondSequenceOf87(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public SecondSequenceOf87(List<BerOctetString> seqOf) {
			id = identifier;
			this.seqOf = seqOf;
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
				for (int i = (seqOf.size() - 1); i >= 0; i--) {
					codeLength += seqOf.get(i).encode(os, false);
					// write tag: CONTEXT_CLASS, PRIMITIVE, 7
					os.write(0x87);
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

			if (length.val == -1) {
				while (true) {
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

					BerOctetString element = new BerOctetString();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				BerOctetString element = new BerOctetString();
				subCodeLength += berIdentifier.decode(is);
				subCodeLength += element.decode(is, false);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
			encode(os, false);
			code = os.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("SEQUENCE OF{");

			if (seqOf == null) {
				sb.append("null");
			}
			else {
				Iterator<BerOctetString> it = seqOf.iterator();
				if (it.hasNext()) {
					sb.append(it.next());
					while (it.hasNext()) {
						sb.append(", ").append(it.next());
					}
				}
			}

			sb.append("}");

			return sb.toString();
		}

	}

	public static class FinalResponse {

		public byte[] code = null;
		public BerOctetString error9F47 = null;

		public BerOctetString error9F48 = null;

		public BerOctetString bppOk = null;

		public BerOctetString bppError = null;

		public FinalResponse() {
		}

		public FinalResponse(byte[] code) {
			this.code = code;
		}

		public FinalResponse(BerOctetString error9F47, BerOctetString error9F48, BerOctetString bppOk, BerOctetString bppError) {
			this.error9F47 = error9F47;
			this.error9F48 = error9F48;
			this.bppOk = bppOk;
			this.bppError = bppError;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;

			}
			int codeLength = 0;
			if (bppError != null) {
				codeLength += bppError.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 70
				os.write(0x46);
				os.write(0x9f);
				codeLength += 2;
				return codeLength;

			}
			
			if (bppOk != null) {
				codeLength += bppOk.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 6
				os.write(0x86);
				codeLength += 1;
				return codeLength;

			}
			
			if (error9F48 != null) {
				codeLength += error9F48.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 72
				os.write(0x48);
				os.write(0x9f);
				codeLength += 2;
				return codeLength;

			}
			
			if (error9F47 != null) {
				codeLength += error9F47.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 71
				os.write(0x47);
				os.write(0x9f);
				codeLength += 2;
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 71)) {
				error9F47 = new BerOctetString();
				codeLength += error9F47.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 72)) {
				error9F48 = new BerOctetString();
				codeLength += error9F48.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6)) {
				bppOk = new BerOctetString();
				codeLength += bppOk.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 70)) {
				bppError = new BerOctetString();
				codeLength += bppError.decode(is, false);
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
			if ( error9F47!= null) {
				return "CHOICE{error9F47: " + error9F47 + "}";
			}

			if ( error9F48!= null) {
				return "CHOICE{error9F48: " + error9F48 + "}";
			}

			if ( bppOk!= null) {
				return "CHOICE{bppOk: " + bppOk + "}";
			}

			if ( bppError!= null) {
				return "CHOICE{bppError: " + bppError + "}";
			}

			return "unknown";
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 55);
	protected BerIdentifier id;

	public byte[] code = null;
	public InitialiseSecureChannelResponse initialiseSecureChannelResponse = null;

	public BerOctetString euiccSignISC = null;

	public FirstSequenceOf87 firstSequenceOf87 = null;

	public SequenceOf88 sequenceOf88 = null;

	public SecondSequenceOf87 secondSequenceOf87 = null;

	public FinalResponse finalResponse = null;

	public ProfileInstallationReceipt profileInstallationReceipt = null;

	public BerOctetString euiccSignPIR = null;

	public ProfileInstallationResult() {
		id = identifier;
	}

	public ProfileInstallationResult(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ProfileInstallationResult(InitialiseSecureChannelResponse initialiseSecureChannelResponse, BerOctetString euiccSignISC, FirstSequenceOf87 firstSequenceOf87, SequenceOf88 sequenceOf88, SecondSequenceOf87 secondSequenceOf87, FinalResponse finalResponse, ProfileInstallationReceipt profileInstallationReceipt, BerOctetString euiccSignPIR) {
		id = identifier;
		this.initialiseSecureChannelResponse = initialiseSecureChannelResponse;
		this.euiccSignISC = euiccSignISC;
		this.firstSequenceOf87 = firstSequenceOf87;
		this.sequenceOf88 = sequenceOf88;
		this.secondSequenceOf87 = secondSequenceOf87;
		this.finalResponse = finalResponse;
		this.profileInstallationReceipt = profileInstallationReceipt;
		this.euiccSignPIR = euiccSignPIR;
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
			codeLength += euiccSignPIR.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 55
			os.write(0x37);
			os.write(0x5f);
			codeLength += 2;
			
			codeLength += profileInstallationReceipt.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 39
			os.write(0x27);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += finalResponse.encode(os, true);
			
			if (secondSequenceOf87 != null) {
				codeLength += secondSequenceOf87.encode(os, true);
			}
			
			codeLength += sequenceOf88.encode(os, true);
			
			codeLength += firstSequenceOf87.encode(os, true);
			
			codeLength += euiccSignISC.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 55
			os.write(0x37);
			os.write(0x5f);
			codeLength += 2;
			
			codeLength += initialiseSecureChannelResponse.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 35
			os.write(0x23);
			os.write(0xbf);
			codeLength += 2;
			
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 35)) {
				initialiseSecureChannelResponse = new InitialiseSecureChannelResponse();
				subCodeLength += initialiseSecureChannelResponse.decode(is, false);
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
				euiccSignISC = new BerOctetString();
				subCodeLength += euiccSignISC.decode(is, false);
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
			if (berIdentifier.equals(FirstSequenceOf87.identifier)) {
				firstSequenceOf87 = new FirstSequenceOf87();
				subCodeLength += firstSequenceOf87.decode(is, false);
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
			if (berIdentifier.equals(SequenceOf88.identifier)) {
				sequenceOf88 = new SequenceOf88();
				subCodeLength += sequenceOf88.decode(is, false);
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
			if (berIdentifier.equals(SecondSequenceOf87.identifier)) {
				secondSequenceOf87 = new SecondSequenceOf87();
				subCodeLength += secondSequenceOf87.decode(is, false);
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
			finalResponse = new FinalResponse();
			int choiceDecodeLength = finalResponse.decode(is, berIdentifier);
			if (choiceDecodeLength != 0) {
				subCodeLength += choiceDecodeLength;
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				finalResponse = null;
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 39)) {
				profileInstallationReceipt = new ProfileInstallationReceipt();
				subCodeLength += profileInstallationReceipt.decode(is, false);
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
				euiccSignPIR = new BerOctetString();
				subCodeLength += euiccSignPIR.decode(is, false);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 35)) {
			initialiseSecureChannelResponse = new InitialiseSecureChannelResponse();
			subCodeLength += initialiseSecureChannelResponse.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 55)) {
			euiccSignISC = new BerOctetString();
			subCodeLength += euiccSignISC.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(FirstSequenceOf87.identifier)) {
			firstSequenceOf87 = new FirstSequenceOf87();
			subCodeLength += firstSequenceOf87.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(SequenceOf88.identifier)) {
			sequenceOf88 = new SequenceOf88();
			subCodeLength += sequenceOf88.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(SecondSequenceOf87.identifier)) {
			secondSequenceOf87 = new SecondSequenceOf87();
			subCodeLength += secondSequenceOf87.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		finalResponse = new FinalResponse();
		subCodeLength += finalResponse.decode(is, berIdentifier);
		subCodeLength += berIdentifier.decode(is);
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 39)) {
			profileInstallationReceipt = new ProfileInstallationReceipt();
			subCodeLength += profileInstallationReceipt.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 55)) {
			euiccSignPIR = new BerOctetString();
			subCodeLength += euiccSignPIR.decode(is, false);
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
		sb.append("initialiseSecureChannelResponse: ").append(initialiseSecureChannelResponse);
		
		sb.append(", ");
		sb.append("euiccSignISC: ").append(euiccSignISC);
		
		sb.append(", ");
		sb.append("firstSequenceOf87: ").append(firstSequenceOf87);
		
		sb.append(", ");
		sb.append("sequenceOf88: ").append(sequenceOf88);
		
		if (secondSequenceOf87 != null) {
			sb.append(", ");
			sb.append("secondSequenceOf87: ").append(secondSequenceOf87);
		}
		
		sb.append(", ");
		sb.append("finalResponse: ").append(finalResponse);
		
		sb.append(", ");
		sb.append("profileInstallationReceipt: ").append(profileInstallationReceipt);
		
		sb.append(", ");
		sb.append("euiccSignPIR: ").append(euiccSignPIR);
		
		sb.append("}");
		return sb.toString();
	}

}

