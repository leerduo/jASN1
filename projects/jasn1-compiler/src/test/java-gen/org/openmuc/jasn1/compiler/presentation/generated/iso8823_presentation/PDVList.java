/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.presentation.generated.iso8823_presentation;

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


public class PDVList {

	public static class PresentationDataValues {

		public byte[] code = null;
		public BerAnyNoDecode singleASN1Type = null;

		public BerOctetString octetAligned = null;

		public BerBitString arbitrary = null;

		public PresentationDataValues() {
		}

		public PresentationDataValues(byte[] code) {
			this.code = code;
		}

		public PresentationDataValues(BerAnyNoDecode singleASN1Type, BerOctetString octetAligned, BerBitString arbitrary) {
			this.singleASN1Type = singleASN1Type;
			this.octetAligned = octetAligned;
			this.arbitrary = arbitrary;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;

			}
			int codeLength = 0;
			int sublength;

			if (arbitrary != null) {
				codeLength += arbitrary.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				os.write(0x82);
				codeLength += 1;
				return codeLength;

			}
			
			if (octetAligned != null) {
				codeLength += octetAligned.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
				return codeLength;

			}
			
			if (singleASN1Type != null) {
				sublength = singleASN1Type.encode(os);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
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
				codeLength += length.decode(is);
				singleASN1Type = new BerAnyNoDecode();
				codeLength += singleASN1Type.decode(is, length.val);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				octetAligned = new BerOctetString();
				codeLength += octetAligned.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
				arbitrary = new BerBitString();
				codeLength += arbitrary.decode(is, false);
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
			if ( singleASN1Type!= null) {
				return "CHOICE{singleASN1Type: " + singleASN1Type + "}";
			}

			if ( octetAligned!= null) {
				return "CHOICE{octetAligned: " + octetAligned + "}";
			}

			if ( arbitrary!= null) {
				return "CHOICE{arbitrary: " + arbitrary + "}";
			}

			return "unknown";
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public TransferSyntaxName transferSyntaxName = null;

	public PresentationContextIdentifier presentationContextIdentifier = null;

	public PresentationDataValues presentationDataValues = null;

	public PDVList() {
		id = identifier;
	}

	public PDVList(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PDVList(TransferSyntaxName transferSyntaxName, PresentationContextIdentifier presentationContextIdentifier, PresentationDataValues presentationDataValues) {
		id = identifier;
		this.transferSyntaxName = transferSyntaxName;
		this.presentationContextIdentifier = presentationContextIdentifier;
		this.presentationDataValues = presentationDataValues;
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
			codeLength += presentationDataValues.encode(os, true);
			
			codeLength += presentationContextIdentifier.encode(os, true);
			
			if (transferSyntaxName != null) {
				codeLength += transferSyntaxName.encode(os, true);
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
			if (berIdentifier.equals(TransferSyntaxName.identifier)) {
				transferSyntaxName = new TransferSyntaxName();
				subCodeLength += transferSyntaxName.decode(is, false);
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
			if (berIdentifier.equals(PresentationContextIdentifier.identifier)) {
				presentationContextIdentifier = new PresentationContextIdentifier();
				subCodeLength += presentationContextIdentifier.decode(is, false);
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
			presentationDataValues = new PresentationDataValues();
			int choiceDecodeLength = presentationDataValues.decode(is, berIdentifier);
			if (choiceDecodeLength != 0) {
				subCodeLength += choiceDecodeLength;
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				presentationDataValues = null;
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
		if (berIdentifier.equals(TransferSyntaxName.identifier)) {
			transferSyntaxName = new TransferSyntaxName();
			subCodeLength += transferSyntaxName.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(PresentationContextIdentifier.identifier)) {
			presentationContextIdentifier = new PresentationContextIdentifier();
			subCodeLength += presentationContextIdentifier.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		presentationDataValues = new PresentationDataValues();
		subCodeLength += presentationDataValues.decode(is, berIdentifier);
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
		boolean firstSelectedElement = true;
		if (transferSyntaxName != null) {
			sb.append("transferSyntaxName: ").append(transferSyntaxName);
			firstSelectedElement = false;
		}
		
		if (!firstSelectedElement) {
			sb.append(", ");
		}
		sb.append("presentationContextIdentifier: ").append(presentationContextIdentifier);
		
		sb.append(", ");
		sb.append("presentationDataValues: ").append(presentationDataValues);
		
		sb.append("}");
		return sb.toString();
	}

}

