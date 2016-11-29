/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
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


public class PEPINCodes {

	public static class PinCodes {

		public byte[] code = null;
		public static class Pinconfig {

			public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
			protected BerIdentifier id;

			public byte[] code = null;
			public List<PINConfiguration> seqOf = null;

			public Pinconfig() {
				id = identifier;
				seqOf = new ArrayList<PINConfiguration>();
			}

			public Pinconfig(byte[] code) {
				id = identifier;
				this.code = code;
			}

			public Pinconfig(List<PINConfiguration> seqOf) {
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

						PINConfiguration element = new PINConfiguration();
						subCodeLength += element.decode(is, false);
						seqOf.add(element);
					}
				}
				while (subCodeLength < totalLength) {
					PINConfiguration element = new PINConfiguration();
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
					Iterator<PINConfiguration> it = seqOf.iterator();
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

		public Pinconfig pinconfig = null;

		public BerOctetString filePath = null;

		public PinCodes() {
		}

		public PinCodes(byte[] code) {
			this.code = code;
		}

		public PinCodes(Pinconfig pinconfig, BerOctetString filePath) {
			this.pinconfig = pinconfig;
			this.filePath = filePath;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;

			}
			int codeLength = 0;
			if (filePath != null) {
				codeLength += filePath.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
				return codeLength;

			}
			
			if (pinconfig != null) {
				codeLength += pinconfig.encode(os, false);
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
				pinconfig = new Pinconfig();
				codeLength += pinconfig.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				filePath = new BerOctetString();
				codeLength += filePath.decode(is, false);
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
			if ( pinconfig!= null) {
				return "CHOICE{pinconfig: " + pinconfig + "}";
			}

			if ( filePath!= null) {
				return "CHOICE{filePath: " + filePath + "}";
			}

			return "unknown";
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public PEHeader pinHeader = null;

	public PinCodes pinCodes = null;

	public PEPINCodes() {
		id = identifier;
	}

	public PEPINCodes(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PEPINCodes(PEHeader pinHeader, PinCodes pinCodes) {
		id = identifier;
		this.pinHeader = pinHeader;
		this.pinCodes = pinCodes;
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

			sublength = pinCodes.encode(os, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(os, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
			os.write(0xa1);
			codeLength += 1;
			
			codeLength += pinHeader.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			os.write(0xa0);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
				pinHeader = new PEHeader();
				subCodeLength += pinHeader.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
				subCodeLength += length.decode(is);
				pinCodes = new PinCodes();
				int choiceDecodeLength = pinCodes.decode(is, null);
				if (choiceDecodeLength != 0) {
					subCodeLength += choiceDecodeLength;
					subCodeLength += berIdentifier.decode(is);
				}
				else {
					pinCodes = null;
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			pinHeader = new PEHeader();
			subCodeLength += pinHeader.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			subCodeLength += length.decode(is);
			pinCodes = new PinCodes();
			subCodeLength += pinCodes.decode(is, null);
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
		sb.append("pinHeader: ").append(pinHeader);
		
		sb.append(", ");
		sb.append("pinCodes: ").append(pinCodes);
		
		sb.append("}");
		return sb.toString();
	}

}

