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


public class PE_OPT_ISIM {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0);
	protected BerIdentifier id;

	public byte[] code = null;
	public PEHeader optisim_header = null;

	public BerObjectIdentifier templateID = null;

	public File ef_pcscf = null;

	public File ef_sms = null;

	public File ef_smsp = null;

	public File ef_smss = null;

	public File ef_smsr = null;

	public File ef_gbabp = null;

	public File ef_gbanl = null;

	public File ef_nafkca = null;

	public File ef_uicciari = null;

	public PE_OPT_ISIM() {
		id = identifier;
	}

	public PE_OPT_ISIM(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PE_OPT_ISIM(PEHeader optisim_header, BerObjectIdentifier templateID, File ef_pcscf, File ef_sms, File ef_smsp, File ef_smss, File ef_smsr, File ef_gbabp, File ef_gbanl, File ef_nafkca, File ef_uicciari) {
		id = identifier;
		this.optisim_header = optisim_header;
		this.templateID = templateID;
		this.ef_pcscf = ef_pcscf;
		this.ef_sms = ef_sms;
		this.ef_smsp = ef_smsp;
		this.ef_smss = ef_smss;
		this.ef_smsr = ef_smsr;
		this.ef_gbabp = ef_gbabp;
		this.ef_gbanl = ef_gbanl;
		this.ef_nafkca = ef_nafkca;
		this.ef_uicciari = ef_uicciari;
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
			if (ef_uicciari != null) {
				codeLength += ef_uicciari.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 10}
				os.write(0xaa);
				codeLength += 1;
			}
			
			if (ef_nafkca != null) {
				codeLength += ef_nafkca.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 9}
				os.write(0xa9);
				codeLength += 1;
			}
			
			if (ef_gbanl != null) {
				codeLength += ef_gbanl.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 8}
				os.write(0xa8);
				codeLength += 1;
			}
			
			if (ef_gbabp != null) {
				codeLength += ef_gbabp.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 7}
				os.write(0xa7);
				codeLength += 1;
			}
			
			if (ef_smsr != null) {
				codeLength += ef_smsr.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 6}
				os.write(0xa6);
				codeLength += 1;
			}
			
			if (ef_smss != null) {
				codeLength += ef_smss.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 5}
				os.write(0xa5);
				codeLength += 1;
			}
			
			if (ef_smsp != null) {
				codeLength += ef_smsp.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 4}
				os.write(0xa4);
				codeLength += 1;
			}
			
			if (ef_sms != null) {
				codeLength += ef_sms.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 3}
				os.write(0xa3);
				codeLength += 1;
			}
			
			if (ef_pcscf != null) {
				codeLength += ef_pcscf.encode(os, false);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 2}
				os.write(0xa2);
				codeLength += 1;
			}
			
			codeLength += templateID.encode(os, false);
			// write tag {CONTEXT_CLASS, PRIMITIVE, 1}
			os.write(0x81);
			codeLength += 1;
			
			codeLength += optisim_header.encode(os, false);
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
				optisim_header = new PEHeader();
				optisim_header.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0);
				subCodeLength += optisim_header.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				templateID = new BerObjectIdentifier();
				templateID.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1);
				subCodeLength += templateID.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
				ef_pcscf = new File();
				ef_pcscf.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2);
				subCodeLength += ef_pcscf.decode(is, false);
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
				ef_sms = new File();
				ef_sms.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3);
				subCodeLength += ef_sms.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
				ef_smsp = new File();
				ef_smsp.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4);
				subCodeLength += ef_smsp.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
				ef_smss = new File();
				ef_smss.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5);
				subCodeLength += ef_smss.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
				ef_smsr = new File();
				ef_smsr.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6);
				subCodeLength += ef_smsr.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
				ef_gbabp = new File();
				ef_gbabp.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 7);
				subCodeLength += ef_gbabp.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
				ef_gbanl = new File();
				ef_gbanl.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8);
				subCodeLength += ef_gbanl.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)) {
				ef_nafkca = new File();
				ef_nafkca.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9);
				subCodeLength += ef_nafkca.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
				ef_uicciari = new File();
				ef_uicciari.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10);
				subCodeLength += ef_uicciari.decode(is, false);
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
			optisim_header = new PEHeader();
			subCodeLength += optisim_header.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			templateID = new BerObjectIdentifier();
			subCodeLength += templateID.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			ef_pcscf = new File();
			subCodeLength += ef_pcscf.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			ef_sms = new File();
			subCodeLength += ef_sms.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
			ef_smsp = new File();
			subCodeLength += ef_smsp.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			ef_smss = new File();
			subCodeLength += ef_smss.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
			ef_smsr = new File();
			subCodeLength += ef_smsr.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
			ef_gbabp = new File();
			subCodeLength += ef_gbabp.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
			ef_gbanl = new File();
			subCodeLength += ef_gbanl.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)) {
			ef_nafkca = new File();
			subCodeLength += ef_nafkca.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			ef_uicciari = new File();
			subCodeLength += ef_uicciari.decode(is, false);
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
		sb.append("optisim_header: ").append(optisim_header);
		
		sb.append(", ");
		sb.append("templateID: ").append(templateID);
		
		if (ef_pcscf != null) {
			sb.append(", ");
			sb.append("ef_pcscf: ").append(ef_pcscf);
		}
		
		if (ef_sms != null) {
			sb.append(", ");
			sb.append("ef_sms: ").append(ef_sms);
		}
		
		if (ef_smsp != null) {
			sb.append(", ");
			sb.append("ef_smsp: ").append(ef_smsp);
		}
		
		if (ef_smss != null) {
			sb.append(", ");
			sb.append("ef_smss: ").append(ef_smss);
		}
		
		if (ef_smsr != null) {
			sb.append(", ");
			sb.append("ef_smsr: ").append(ef_smsr);
		}
		
		if (ef_gbabp != null) {
			sb.append(", ");
			sb.append("ef_gbabp: ").append(ef_gbabp);
		}
		
		if (ef_gbanl != null) {
			sb.append(", ");
			sb.append("ef_gbanl: ").append(ef_gbanl);
		}
		
		if (ef_nafkca != null) {
			sb.append(", ");
			sb.append("ef_nafkca: ").append(ef_nafkca);
		}
		
		if (ef_uicciari != null) {
			sb.append(", ");
			sb.append("ef_uicciari: ").append(ef_uicciari);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

