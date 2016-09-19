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


public class ServicesList {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerNull contactless = null;

	public BerNull usim = null;

	public BerNull isim = null;

	public BerNull csim = null;

	public BerNull milenage = null;

	public BerNull tuak128 = null;

	public BerNull cave = null;

	public BerNull gba_usim = null;

	public BerNull gba_isim = null;

	public BerNull mbms = null;

	public BerNull eap = null;

	public BerNull javacard = null;

	public BerNull multos = null;

	public BerNull multiple_usim = null;

	public BerNull multiple_isim = null;

	public BerNull multiple_csim = null;

	public BerNull tuak256 = null;

	public ServicesList() {
		id = identifier;
	}

	public ServicesList(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ServicesList(BerNull contactless, BerNull usim, BerNull isim, BerNull csim, BerNull milenage, BerNull tuak128, BerNull cave, BerNull gba_usim, BerNull gba_isim, BerNull mbms, BerNull eap, BerNull javacard, BerNull multos, BerNull multiple_usim, BerNull multiple_isim, BerNull multiple_csim, BerNull tuak256) {
		id = identifier;
		this.contactless = contactless;
		this.usim = usim;
		this.isim = isim;
		this.csim = csim;
		this.milenage = milenage;
		this.tuak128 = tuak128;
		this.cave = cave;
		this.gba_usim = gba_usim;
		this.gba_isim = gba_isim;
		this.mbms = mbms;
		this.eap = eap;
		this.javacard = javacard;
		this.multos = multos;
		this.multiple_usim = multiple_usim;
		this.multiple_isim = multiple_isim;
		this.multiple_csim = multiple_csim;
		this.tuak256 = tuak256;
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
			if (tuak256 != null) {
				codeLength += tuak256.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 16}
				os.write(0x90);
				codeLength += 1;
			}
			
			if (multiple_csim != null) {
				codeLength += multiple_csim.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 15}
				os.write(0x8f);
				codeLength += 1;
			}
			
			if (multiple_isim != null) {
				codeLength += multiple_isim.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 14}
				os.write(0x8e);
				codeLength += 1;
			}
			
			if (multiple_usim != null) {
				codeLength += multiple_usim.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 13}
				os.write(0x8d);
				codeLength += 1;
			}
			
			if (multos != null) {
				codeLength += multos.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 12}
				os.write(0x8c);
				codeLength += 1;
			}
			
			if (javacard != null) {
				codeLength += javacard.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 11}
				os.write(0x8b);
				codeLength += 1;
			}
			
			if (eap != null) {
				codeLength += eap.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 10}
				os.write(0x8a);
				codeLength += 1;
			}
			
			if (mbms != null) {
				codeLength += mbms.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 9}
				os.write(0x89);
				codeLength += 1;
			}
			
			if (gba_isim != null) {
				codeLength += gba_isim.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 8}
				os.write(0x88);
				codeLength += 1;
			}
			
			if (gba_usim != null) {
				codeLength += gba_usim.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 7}
				os.write(0x87);
				codeLength += 1;
			}
			
			if (cave != null) {
				codeLength += cave.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 6}
				os.write(0x86);
				codeLength += 1;
			}
			
			if (tuak128 != null) {
				codeLength += tuak128.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 5}
				os.write(0x85);
				codeLength += 1;
			}
			
			if (milenage != null) {
				codeLength += milenage.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 4}
				os.write(0x84);
				codeLength += 1;
			}
			
			if (csim != null) {
				codeLength += csim.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 3}
				os.write(0x83);
				codeLength += 1;
			}
			
			if (isim != null) {
				codeLength += isim.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 2}
				os.write(0x82);
				codeLength += 1;
			}
			
			if (usim != null) {
				codeLength += usim.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 1}
				os.write(0x81);
				codeLength += 1;
			}
			
			if (contactless != null) {
				codeLength += contactless.encode(os, false);
				// write tag {CONTEXT_CLASS, PRIMITIVE, 0}
				os.write(0x80);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				contactless = new BerNull();
				contactless.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0);
				subCodeLength += contactless.decode(is, false);
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
				usim = new BerNull();
				usim.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1);
				subCodeLength += usim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
				isim = new BerNull();
				isim.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2);
				subCodeLength += isim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
				csim = new BerNull();
				csim.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3);
				subCodeLength += csim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
				milenage = new BerNull();
				milenage.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4);
				subCodeLength += milenage.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5)) {
				tuak128 = new BerNull();
				tuak128.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5);
				subCodeLength += tuak128.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6)) {
				cave = new BerNull();
				cave.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6);
				subCodeLength += cave.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7)) {
				gba_usim = new BerNull();
				gba_usim.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7);
				subCodeLength += gba_usim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 8)) {
				gba_isim = new BerNull();
				gba_isim.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 8);
				subCodeLength += gba_isim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 9)) {
				mbms = new BerNull();
				mbms.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 9);
				subCodeLength += mbms.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 10)) {
				eap = new BerNull();
				eap.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 10);
				subCodeLength += eap.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 11)) {
				javacard = new BerNull();
				javacard.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 11);
				subCodeLength += javacard.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 12)) {
				multos = new BerNull();
				multos.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 12);
				subCodeLength += multos.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 13)) {
				multiple_usim = new BerNull();
				multiple_usim.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 13);
				subCodeLength += multiple_usim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 14)) {
				multiple_isim = new BerNull();
				multiple_isim.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 14);
				subCodeLength += multiple_isim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 15)) {
				multiple_csim = new BerNull();
				multiple_csim.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 15);
				subCodeLength += multiple_csim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 16)) {
				tuak256 = new BerNull();
				tuak256.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 16);
				subCodeLength += tuak256.decode(is, false);
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

		if (length.val == 0) {
			return codeLength;
		}
		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			contactless = new BerNull();
			subCodeLength += contactless.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			usim = new BerNull();
			subCodeLength += usim.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			isim = new BerNull();
			subCodeLength += isim.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			csim = new BerNull();
			subCodeLength += csim.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
			milenage = new BerNull();
			subCodeLength += milenage.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5)) {
			tuak128 = new BerNull();
			subCodeLength += tuak128.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6)) {
			cave = new BerNull();
			subCodeLength += cave.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7)) {
			gba_usim = new BerNull();
			subCodeLength += gba_usim.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 8)) {
			gba_isim = new BerNull();
			subCodeLength += gba_isim.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 9)) {
			mbms = new BerNull();
			subCodeLength += mbms.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 10)) {
			eap = new BerNull();
			subCodeLength += eap.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 11)) {
			javacard = new BerNull();
			subCodeLength += javacard.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 12)) {
			multos = new BerNull();
			subCodeLength += multos.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 13)) {
			multiple_usim = new BerNull();
			subCodeLength += multiple_usim.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 14)) {
			multiple_isim = new BerNull();
			subCodeLength += multiple_isim.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 15)) {
			multiple_csim = new BerNull();
			subCodeLength += multiple_csim.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 16)) {
			tuak256 = new BerNull();
			subCodeLength += tuak256.decode(is, false);
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
		boolean firstSelectedElement = true;
		if (contactless != null) {
			sb.append("contactless: ").append(contactless);
			firstSelectedElement = false;
		}
		
		if (usim != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("usim: ").append(usim);
			firstSelectedElement = false;
		}
		
		if (isim != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("isim: ").append(isim);
			firstSelectedElement = false;
		}
		
		if (csim != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("csim: ").append(csim);
			firstSelectedElement = false;
		}
		
		if (milenage != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("milenage: ").append(milenage);
			firstSelectedElement = false;
		}
		
		if (tuak128 != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("tuak128: ").append(tuak128);
			firstSelectedElement = false;
		}
		
		if (cave != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("cave: ").append(cave);
			firstSelectedElement = false;
		}
		
		if (gba_usim != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("gba_usim: ").append(gba_usim);
			firstSelectedElement = false;
		}
		
		if (gba_isim != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("gba_isim: ").append(gba_isim);
			firstSelectedElement = false;
		}
		
		if (mbms != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("mbms: ").append(mbms);
			firstSelectedElement = false;
		}
		
		if (eap != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("eap: ").append(eap);
			firstSelectedElement = false;
		}
		
		if (javacard != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("javacard: ").append(javacard);
			firstSelectedElement = false;
		}
		
		if (multos != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("multos: ").append(multos);
			firstSelectedElement = false;
		}
		
		if (multiple_usim != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("multiple_usim: ").append(multiple_usim);
			firstSelectedElement = false;
		}
		
		if (multiple_isim != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("multiple_isim: ").append(multiple_isim);
			firstSelectedElement = false;
		}
		
		if (multiple_csim != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("multiple_csim: ").append(multiple_csim);
			firstSelectedElement = false;
		}
		
		if (tuak256 != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("tuak256: ").append(tuak256);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}
