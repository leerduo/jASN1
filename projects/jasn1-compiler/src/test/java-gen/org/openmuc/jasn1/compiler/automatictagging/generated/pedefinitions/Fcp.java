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


public class Fcp {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerOctetString fileDescriptor = null;

	public BerOctetString fileID = null;

	public ApplicationIdentifier dfName = null;

	public BerOctetString lcsi = null;

	public BerOctetString securityAttributesReferenced = null;

	public BerOctetString efFileSize = null;

	public BerOctetString pinStatusTemplateDO = null;

	public BerOctetString shortEFID = null;

	public ProprietaryInfo proprietaryEFInfo = null;

	public BerOctetString linkPath = null;

	public Fcp() {
		id = identifier;
	}

	public Fcp(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public Fcp(BerOctetString fileDescriptor, BerOctetString fileID, ApplicationIdentifier dfName, BerOctetString lcsi, BerOctetString securityAttributesReferenced, BerOctetString efFileSize, BerOctetString pinStatusTemplateDO, BerOctetString shortEFID, ProprietaryInfo proprietaryEFInfo, BerOctetString linkPath) {
		id = identifier;
		this.fileDescriptor = fileDescriptor;
		this.fileID = fileID;
		this.dfName = dfName;
		this.lcsi = lcsi;
		this.securityAttributesReferenced = securityAttributesReferenced;
		this.efFileSize = efFileSize;
		this.pinStatusTemplateDO = pinStatusTemplateDO;
		this.shortEFID = shortEFID;
		this.proprietaryEFInfo = proprietaryEFInfo;
		this.linkPath = linkPath;
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
			if (linkPath != null) {
				codeLength += linkPath.encode(os, false);
				// write tag: PRIVATE_CLASS, PRIMITIVE, 7
				os.write(0xc7);
				codeLength += 1;
			}
			
			if (proprietaryEFInfo != null) {
				codeLength += proprietaryEFInfo.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
				os.write(0xa5);
				codeLength += 1;
			}
			
			if (shortEFID != null) {
				codeLength += shortEFID.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 8
				os.write(0x88);
				codeLength += 1;
			}
			
			if (pinStatusTemplateDO != null) {
				codeLength += pinStatusTemplateDO.encode(os, false);
				// write tag: PRIVATE_CLASS, PRIMITIVE, 6
				os.write(0xc6);
				codeLength += 1;
			}
			
			if (efFileSize != null) {
				codeLength += efFileSize.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
				os.write(0x80);
				codeLength += 1;
			}
			
			if (securityAttributesReferenced != null) {
				codeLength += securityAttributesReferenced.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 11
				os.write(0x8b);
				codeLength += 1;
			}
			
			if (lcsi != null) {
				codeLength += lcsi.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 10
				os.write(0x8a);
				codeLength += 1;
			}
			
			if (dfName != null) {
				codeLength += dfName.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 4
				os.write(0x84);
				codeLength += 1;
			}
			
			if (fileID != null) {
				codeLength += fileID.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				os.write(0x83);
				codeLength += 1;
			}
			
			if (fileDescriptor != null) {
				codeLength += fileDescriptor.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				os.write(0x82);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
				fileDescriptor = new BerOctetString();
				subCodeLength += fileDescriptor.decode(is, false);
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
				fileID = new BerOctetString();
				subCodeLength += fileID.decode(is, false);
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
				dfName = new ApplicationIdentifier();
				subCodeLength += dfName.decode(is, false);
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
				lcsi = new BerOctetString();
				subCodeLength += lcsi.decode(is, false);
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
				securityAttributesReferenced = new BerOctetString();
				subCodeLength += securityAttributesReferenced.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				efFileSize = new BerOctetString();
				subCodeLength += efFileSize.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.PRIMITIVE, 6)) {
				pinStatusTemplateDO = new BerOctetString();
				subCodeLength += pinStatusTemplateDO.decode(is, false);
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
				shortEFID = new BerOctetString();
				subCodeLength += shortEFID.decode(is, false);
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
				proprietaryEFInfo = new ProprietaryInfo();
				subCodeLength += proprietaryEFInfo.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.PRIMITIVE, 7)) {
				linkPath = new BerOctetString();
				subCodeLength += linkPath.decode(is, false);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			fileDescriptor = new BerOctetString();
			subCodeLength += fileDescriptor.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			fileID = new BerOctetString();
			subCodeLength += fileID.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
			dfName = new ApplicationIdentifier();
			subCodeLength += dfName.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 10)) {
			lcsi = new BerOctetString();
			subCodeLength += lcsi.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 11)) {
			securityAttributesReferenced = new BerOctetString();
			subCodeLength += securityAttributesReferenced.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			efFileSize = new BerOctetString();
			subCodeLength += efFileSize.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.PRIMITIVE, 6)) {
			pinStatusTemplateDO = new BerOctetString();
			subCodeLength += pinStatusTemplateDO.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 8)) {
			shortEFID = new BerOctetString();
			subCodeLength += shortEFID.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			proprietaryEFInfo = new ProprietaryInfo();
			subCodeLength += proprietaryEFInfo.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.PRIMITIVE, 7)) {
			linkPath = new BerOctetString();
			subCodeLength += linkPath.decode(is, false);
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
		if (fileDescriptor != null) {
			sb.append("fileDescriptor: ").append(fileDescriptor);
			firstSelectedElement = false;
		}
		
		if (fileID != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("fileID: ").append(fileID);
			firstSelectedElement = false;
		}
		
		if (dfName != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("dfName: ").append(dfName);
			firstSelectedElement = false;
		}
		
		if (lcsi != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("lcsi: ").append(lcsi);
			firstSelectedElement = false;
		}
		
		if (securityAttributesReferenced != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("securityAttributesReferenced: ").append(securityAttributesReferenced);
			firstSelectedElement = false;
		}
		
		if (efFileSize != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("efFileSize: ").append(efFileSize);
			firstSelectedElement = false;
		}
		
		if (pinStatusTemplateDO != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("pinStatusTemplateDO: ").append(pinStatusTemplateDO);
			firstSelectedElement = false;
		}
		
		if (shortEFID != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("shortEFID: ").append(shortEFID);
			firstSelectedElement = false;
		}
		
		if (proprietaryEFInfo != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("proprietaryEFInfo: ").append(proprietaryEFInfo);
			firstSelectedElement = false;
		}
		
		if (linkPath != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("linkPath: ").append(linkPath);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}
