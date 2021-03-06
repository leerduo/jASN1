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


public class PEOPTISIM {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public PEHeader optisimHeader = null;

	public BerObjectIdentifier templateID = null;

	public File efPcscf = null;

	public File efSms = null;

	public File efSmsp = null;

	public File efSmss = null;

	public File efSmsr = null;

	public File efGbabp = null;

	public File efGbanl = null;

	public File efNafkca = null;

	public File efUicciari = null;

	public PEOPTISIM() {
		id = identifier;
	}

	public PEOPTISIM(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PEOPTISIM(PEHeader optisimHeader, BerObjectIdentifier templateID, File efPcscf, File efSms, File efSmsp, File efSmss, File efSmsr, File efGbabp, File efGbanl, File efNafkca, File efUicciari) {
		id = identifier;
		this.optisimHeader = optisimHeader;
		this.templateID = templateID;
		this.efPcscf = efPcscf;
		this.efSms = efSms;
		this.efSmsp = efSmsp;
		this.efSmss = efSmss;
		this.efSmsr = efSmsr;
		this.efGbabp = efGbabp;
		this.efGbanl = efGbanl;
		this.efNafkca = efNafkca;
		this.efUicciari = efUicciari;
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
			if (efUicciari != null) {
				codeLength += efUicciari.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 10
				os.write(0xaa);
				codeLength += 1;
			}
			
			if (efNafkca != null) {
				codeLength += efNafkca.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 9
				os.write(0xa9);
				codeLength += 1;
			}
			
			if (efGbanl != null) {
				codeLength += efGbanl.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 8
				os.write(0xa8);
				codeLength += 1;
			}
			
			if (efGbabp != null) {
				codeLength += efGbabp.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 7
				os.write(0xa7);
				codeLength += 1;
			}
			
			if (efSmsr != null) {
				codeLength += efSmsr.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
				os.write(0xa6);
				codeLength += 1;
			}
			
			if (efSmss != null) {
				codeLength += efSmss.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
				os.write(0xa5);
				codeLength += 1;
			}
			
			if (efSmsp != null) {
				codeLength += efSmsp.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
				os.write(0xa4);
				codeLength += 1;
			}
			
			if (efSms != null) {
				codeLength += efSms.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
				os.write(0xa3);
				codeLength += 1;
			}
			
			if (efPcscf != null) {
				codeLength += efPcscf.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
				os.write(0xa2);
				codeLength += 1;
			}
			
			codeLength += templateID.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			
			codeLength += optisimHeader.encode(os, false);
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
				optisimHeader = new PEHeader();
				subCodeLength += optisimHeader.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				templateID = new BerObjectIdentifier();
				subCodeLength += templateID.decode(is, false);
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
				efPcscf = new File();
				subCodeLength += efPcscf.decode(is, false);
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
				efSms = new File();
				subCodeLength += efSms.decode(is, false);
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
				efSmsp = new File();
				subCodeLength += efSmsp.decode(is, false);
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
				efSmss = new File();
				subCodeLength += efSmss.decode(is, false);
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
				efSmsr = new File();
				subCodeLength += efSmsr.decode(is, false);
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
				efGbabp = new File();
				subCodeLength += efGbabp.decode(is, false);
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
				efGbanl = new File();
				subCodeLength += efGbanl.decode(is, false);
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
				efNafkca = new File();
				subCodeLength += efNafkca.decode(is, false);
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
				efUicciari = new File();
				subCodeLength += efUicciari.decode(is, false);
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
			optisimHeader = new PEHeader();
			subCodeLength += optisimHeader.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			templateID = new BerObjectIdentifier();
			subCodeLength += templateID.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			efPcscf = new File();
			subCodeLength += efPcscf.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			efSms = new File();
			subCodeLength += efSms.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
			efSmsp = new File();
			subCodeLength += efSmsp.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			efSmss = new File();
			subCodeLength += efSmss.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
			efSmsr = new File();
			subCodeLength += efSmsr.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
			efGbabp = new File();
			subCodeLength += efGbabp.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
			efGbanl = new File();
			subCodeLength += efGbanl.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)) {
			efNafkca = new File();
			subCodeLength += efNafkca.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			efUicciari = new File();
			subCodeLength += efUicciari.decode(is, false);
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
		sb.append("optisimHeader: ").append(optisimHeader);
		
		sb.append(", ");
		sb.append("templateID: ").append(templateID);
		
		if (efPcscf != null) {
			sb.append(", ");
			sb.append("efPcscf: ").append(efPcscf);
		}
		
		if (efSms != null) {
			sb.append(", ");
			sb.append("efSms: ").append(efSms);
		}
		
		if (efSmsp != null) {
			sb.append(", ");
			sb.append("efSmsp: ").append(efSmsp);
		}
		
		if (efSmss != null) {
			sb.append(", ");
			sb.append("efSmss: ").append(efSmss);
		}
		
		if (efSmsr != null) {
			sb.append(", ");
			sb.append("efSmsr: ").append(efSmsr);
		}
		
		if (efGbabp != null) {
			sb.append(", ");
			sb.append("efGbabp: ").append(efGbabp);
		}
		
		if (efGbanl != null) {
			sb.append(", ");
			sb.append("efGbanl: ").append(efGbanl);
		}
		
		if (efNafkca != null) {
			sb.append(", ");
			sb.append("efNafkca: ").append(efNafkca);
		}
		
		if (efUicciari != null) {
			sb.append(", ");
			sb.append("efUicciari: ").append(efUicciari);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

