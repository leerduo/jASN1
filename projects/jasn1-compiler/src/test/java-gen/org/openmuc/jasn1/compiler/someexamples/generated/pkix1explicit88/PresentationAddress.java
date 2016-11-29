/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88;

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
import org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions.*;

public class PresentationAddress {

	public static class NAddresses {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 17);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<BerOctetString> seqOf = null;

		public NAddresses() {
			id = identifier;
			seqOf = new ArrayList<BerOctetString>();
		}

		public NAddresses(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public NAddresses(List<BerOctetString> seqOf) {
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

					BerOctetString element = new BerOctetString();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				BerOctetString element = new BerOctetString();
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

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerOctetString pSelector = null;

	public BerOctetString sSelector = null;

	public BerOctetString tSelector = null;

	public NAddresses nAddresses = null;

	public PresentationAddress() {
		id = identifier;
	}

	public PresentationAddress(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PresentationAddress(BerOctetString pSelector, BerOctetString sSelector, BerOctetString tSelector, NAddresses nAddresses) {
		id = identifier;
		this.pSelector = pSelector;
		this.sSelector = sSelector;
		this.tSelector = tSelector;
		this.nAddresses = nAddresses;
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

			sublength = nAddresses.encode(os, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(os, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			os.write(0xa3);
			codeLength += 1;
			
			if (tSelector != null) {
				sublength = tSelector.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
				os.write(0xa2);
				codeLength += 1;
			}
			
			if (sSelector != null) {
				sublength = sSelector.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
				os.write(0xa1);
				codeLength += 1;
			}
			
			if (pSelector != null) {
				sublength = pSelector.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
				os.write(0xa0);
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
				codeLength += length.decode(is);
				pSelector = new BerOctetString();
				subCodeLength += pSelector.decode(is, true);
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
				codeLength += length.decode(is);
				sSelector = new BerOctetString();
				subCodeLength += sSelector.decode(is, true);
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
				codeLength += length.decode(is);
				tSelector = new BerOctetString();
				subCodeLength += tSelector.decode(is, true);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
				codeLength += length.decode(is);
				nAddresses = new NAddresses();
				subCodeLength += nAddresses.decode(is, true);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			subCodeLength += length.decode(is);
			pSelector = new BerOctetString();
			subCodeLength += pSelector.decode(is, true);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			subCodeLength += length.decode(is);
			sSelector = new BerOctetString();
			subCodeLength += sSelector.decode(is, true);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			subCodeLength += length.decode(is);
			tSelector = new BerOctetString();
			subCodeLength += tSelector.decode(is, true);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			subCodeLength += length.decode(is);
			nAddresses = new NAddresses();
			subCodeLength += nAddresses.decode(is, true);
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
		if (pSelector != null) {
			sb.append("pSelector: ").append(pSelector);
			firstSelectedElement = false;
		}
		
		if (sSelector != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("sSelector: ").append(sSelector);
			firstSelectedElement = false;
		}
		
		if (tSelector != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("tSelector: ").append(tSelector);
			firstSelectedElement = false;
		}
		
		if (!firstSelectedElement) {
			sb.append(", ");
		}
		sb.append("nAddresses: ").append(nAddresses);
		
		sb.append("}");
		return sb.toString();
	}

}

