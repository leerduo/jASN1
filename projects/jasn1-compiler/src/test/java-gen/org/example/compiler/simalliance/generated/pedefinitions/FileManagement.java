/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
 */

package org.example.compiler.simalliance.generated.pedefinitions;

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


public class FileManagement {

	public static class SubChoice {

		public byte[] code = null;
		public BerOctetString filePath = null;

		public Fcp createFCP = null;

		public UInt16 fillFileOffset = null;

		public BerOctetString fillFileContent = null;

		public SubChoice() {
		}

		public SubChoice(byte[] code) {
			this.code = code;
		}

		public SubChoice(BerOctetString filePath, Fcp createFCP, UInt16 fillFileOffset, BerOctetString fillFileContent) {
			this.filePath = filePath;
			this.createFCP = createFCP;
			this.fillFileOffset = fillFileOffset;
			this.fillFileContent = fillFileContent;
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

			if (fillFileContent != null) {
				sublength = fillFileContent.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 1}
				os.write(0xa1);
				codeLength += 1;
				return codeLength;

			}
			
			if (fillFileOffset != null) {
				codeLength += fillFileOffset.encode(os, true);
				return codeLength;

			}
			
			if (createFCP != null) {
				sublength = createFCP.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {APPLICATION_CLASS, CONSTRUCTED, 2}
				os.write(0x62);
				codeLength += 1;
				return codeLength;

			}
			
			if (filePath != null) {
				sublength = filePath.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 0}
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
				codeLength += new BerLength().decode(is);
				filePath = new BerOctetString();
				codeLength += filePath.decode(is, true);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
				codeLength += new BerLength().decode(is);
				createFCP = new Fcp();
				codeLength += createFCP.decode(is, true);
				return codeLength;
			}

			if (berIdentifier.equals(UInt16.identifier)) {
				fillFileOffset = new UInt16();
				codeLength += fillFileOffset.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
				codeLength += new BerLength().decode(is);
				fillFileContent = new BerOctetString();
				codeLength += fillFileContent.decode(is, true);
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
			if ( filePath!= null) {
				return "CHOICE{filePath: " + filePath + "}";
			}

			if ( createFCP!= null) {
				return "CHOICE{createFCP: " + createFCP + "}";
			}

			if ( fillFileOffset!= null) {
				return "CHOICE{fillFileOffset: " + fillFileOffset + "}";
			}

			if ( fillFileContent!= null) {
				return "CHOICE{fillFileContent: " + fillFileContent + "}";
			}

			return "unknown";
		}

	}

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0);
	protected BerIdentifier id;

	public byte[] code = null;
	public List<SubChoice> seqOf = null;

	public FileManagement() {
		id = identifier;
		seqOf = new ArrayList<SubChoice>();
	}

	public FileManagement(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public FileManagement(List<SubChoice> seqOf) {
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
		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		if (length.val == -1) {
			BerIdentifier berIdentifier = new BerIdentifier();
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

				SubChoice element = new SubChoice();
				subCodeLength += element.decode(is, berIdentifier);
				seqOf.add(element);
			}
		}
		while (subCodeLength < length.val) {
			SubChoice element = new SubChoice();
			subCodeLength += element.decode(is, null);
			seqOf.add(element);
		}
		if (subCodeLength != length.val) {
			throw new IOException("Decoded SequenceOf or SetOf has wrong length tag");

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
			Iterator<SubChoice> it = seqOf.iterator();
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
