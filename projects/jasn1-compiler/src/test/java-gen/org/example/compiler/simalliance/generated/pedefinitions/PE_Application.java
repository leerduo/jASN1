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


public class PE_Application {

	public static class SubSeqOf_instanceList {

		public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<ApplicationInstance> seqOf = null;

		public SubSeqOf_instanceList() {
			id = identifier;
			seqOf = new ArrayList<ApplicationInstance>();
		}

		public SubSeqOf_instanceList(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public SubSeqOf_instanceList(List<ApplicationInstance> seqOf) {
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
				}

				if (explicit) {
					codeLength += BerLength.encodeLength(os, codeLength);

				}

			}

			if (explicit) {
				codeLength += id.encode(os);
			}

			return codeLength;
		}

		public int decode(InputStream is, boolean explicit) throws IOException {
			return decode(is, explicit, 0);
		}

		public int decode(InputStream is, boolean explicit, int size) throws IOException {
			int codeLength = 0;
			int subCodeLength = 0;
			if (explicit) {
				codeLength += id.decodeAndCheck(is);
			}

			BerLength length = new BerLength();
			length.val = size;
			if (explicit) {
				codeLength += length.decode(is);

			}

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

					ApplicationInstance element = new ApplicationInstance();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < length.val) {
				ApplicationInstance element = new ApplicationInstance();
				subCodeLength += element.decode(is, false, length.val);
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
				Iterator<ApplicationInstance> it = seqOf.iterator();
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

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0);
	protected BerIdentifier id;

	public byte[] code = null;
	public PEHeader app_Header = null;

	public ApplicationLoadPackage loadBlock = null;

	public SubSeqOf_instanceList instanceList = null;

	public PE_Application() {
		id = identifier;
	}

	public PE_Application(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PE_Application(PEHeader app_Header, ApplicationLoadPackage loadBlock, SubSeqOf_instanceList instanceList) {
		id = identifier;
		this.app_Header = app_Header;
		this.loadBlock = loadBlock;
		this.instanceList = instanceList;
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

			if (instanceList != null) {
				sublength = instanceList.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 2}
				os.write(0xa2);
				codeLength += 1;
			}
			
			if (loadBlock != null) {
				codeLength += loadBlock.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 1}
				os.write(0xa1);
				codeLength += 1;
			}
			
			codeLength += app_Header.encode(os, false);
			// write tag {CONTEXT_CLASS, CONSTRUCTED, 0}
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
				app_Header = new PEHeader();
				app_Header.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0);
				subCodeLength += app_Header.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
				loadBlock = new ApplicationLoadPackage();
				loadBlock.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1);
				subCodeLength += loadBlock.decode(is, false);
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
				subCodeLength += new BerLength().decode(is);
				instanceList = new SubSeqOf_instanceList();
				instanceList.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2);
				subCodeLength += instanceList.decode(is, true);
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
			app_Header = new PEHeader();
			subCodeLength += app_Header.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			loadBlock = new ApplicationLoadPackage();
			subCodeLength += loadBlock.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			subCodeLength += new BerLength().decode(is);
			instanceList = new SubSeqOf_instanceList();
			subCodeLength += instanceList.decode(is, true);
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
		sb.append("app_Header: ").append(app_Header);
		
		if (loadBlock != null) {
			sb.append(", ");
			sb.append("loadBlock: ").append(loadBlock);
		}
		
		if (instanceList != null) {
			sb.append(", ");
			sb.append("instanceList: ").append(instanceList);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

