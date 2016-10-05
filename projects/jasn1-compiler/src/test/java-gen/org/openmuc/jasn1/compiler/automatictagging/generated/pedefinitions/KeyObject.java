/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.automatictagging.generated.pedefinitions;

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


public class KeyObject {

	public static class KeyCompontents {

		public static class SEQUENCE {

			public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
			protected BerIdentifier id;

			public byte[] code = null;
			public BerOctetString keyType = null;

			public BerOctetString keyData = null;

			public UInt8 macLength = null;

			public SEQUENCE() {
				id = identifier;
			}

			public SEQUENCE(byte[] code) {
				id = identifier;
				this.code = code;
			}

			public SEQUENCE(BerOctetString keyType, BerOctetString keyData, UInt8 macLength) {
				id = identifier;
				this.keyType = keyType;
				this.keyData = keyData;
				this.macLength = macLength;
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
					if (macLength != null) {
						codeLength += macLength.encode(os, false);
						// write tag: CONTEXT_CLASS, PRIMITIVE, 7
						os.write(0x87);
						codeLength += 1;
					}
					
					codeLength += keyData.encode(os, false);
					// write tag: CONTEXT_CLASS, PRIMITIVE, 6
					os.write(0x86);
					codeLength += 1;
					
					codeLength += keyType.encode(os, false);
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

				subCodeLength += berIdentifier.decode(is);
				if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
					keyType = new BerOctetString();
					subCodeLength += keyType.decode(is, false);
					subCodeLength += berIdentifier.decode(is);
				}
				else {
					throw new IOException("Identifier does not match the mandatory sequence element identifer.");
				}
				
				if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6)) {
					keyData = new BerOctetString();
					subCodeLength += keyData.decode(is, false);
					if (subCodeLength == totalLength) {
						return codeLength;
					}
					subCodeLength += berIdentifier.decode(is);
				}
				else {
					throw new IOException("Identifier does not match the mandatory sequence element identifer.");
				}
				
				if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7)) {
					macLength = new UInt8();
					subCodeLength += macLength.decode(is, false);
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
				sb.append("keyType: ").append(keyType);
				
				sb.append(", ");
				sb.append("keyData: ").append(keyData);
				
				if (macLength != null) {
					sb.append(", ");
					sb.append("macLength: ").append(macLength);
				}
				
				sb.append("}");
				return sb.toString();
			}

		}

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<SEQUENCE> seqOf = null;

		public KeyCompontents() {
			id = identifier;
			seqOf = new ArrayList<SEQUENCE>();
		}

		public KeyCompontents(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public KeyCompontents(List<SEQUENCE> seqOf) {
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
					codeLength += seqOf.get(i).encode(os, true);
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

			while (subCodeLength < totalLength) {
				SEQUENCE element = new SEQUENCE();
				subCodeLength += element.decode(is, true);
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
				Iterator<SEQUENCE> it = seqOf.iterator();
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

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerOctetString keyUsageQualifier = null;

	public BerOctetString keyAccess = null;

	public BerOctetString keyIdentifier = null;

	public BerOctetString keyVersionNumber = null;

	public BerOctetString keyCounterValue = null;

	public KeyCompontents keyCompontents = null;

	public KeyObject() {
		id = identifier;
	}

	public KeyObject(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public KeyObject(BerOctetString keyUsageQualifier, BerOctetString keyAccess, BerOctetString keyIdentifier, BerOctetString keyVersionNumber, BerOctetString keyCounterValue, KeyCompontents keyCompontents) {
		id = identifier;
		this.keyUsageQualifier = keyUsageQualifier;
		this.keyAccess = keyAccess;
		this.keyIdentifier = keyIdentifier;
		this.keyVersionNumber = keyVersionNumber;
		this.keyCounterValue = keyCounterValue;
		this.keyCompontents = keyCompontents;
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
			codeLength += keyCompontents.encode(os, true);
			
			if (keyCounterValue != null) {
				codeLength += keyCounterValue.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 5
				os.write(0x85);
				codeLength += 1;
			}
			
			codeLength += keyVersionNumber.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			os.write(0x83);
			codeLength += 1;
			
			codeLength += keyIdentifier.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			os.write(0x82);
			codeLength += 1;
			
			if (keyAccess != null) {
				codeLength += keyAccess.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 22
				os.write(0x96);
				codeLength += 1;
			}
			
			codeLength += keyUsageQualifier.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 21
			os.write(0x95);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 21)) {
			keyUsageQualifier = new BerOctetString();
			subCodeLength += keyUsageQualifier.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 22)) {
			keyAccess = new BerOctetString();
			subCodeLength += keyAccess.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			keyIdentifier = new BerOctetString();
			subCodeLength += keyIdentifier.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			keyVersionNumber = new BerOctetString();
			subCodeLength += keyVersionNumber.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5)) {
			keyCounterValue = new BerOctetString();
			subCodeLength += keyCounterValue.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(KeyCompontents.identifier)) {
			keyCompontents = new KeyCompontents();
			subCodeLength += keyCompontents.decode(is, false);
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
		sb.append("keyUsageQualifier: ").append(keyUsageQualifier);
		
		if (keyAccess != null) {
			sb.append(", ");
			sb.append("keyAccess: ").append(keyAccess);
		}
		
		sb.append(", ");
		sb.append("keyIdentifier: ").append(keyIdentifier);
		
		sb.append(", ");
		sb.append("keyVersionNumber: ").append(keyVersionNumber);
		
		if (keyCounterValue != null) {
			sb.append(", ");
			sb.append("keyCounterValue: ").append(keyCounterValue);
		}
		
		sb.append(", ");
		sb.append("keyCompontents: ").append(keyCompontents);
		
		sb.append("}");
		return sb.toString();
	}

}

