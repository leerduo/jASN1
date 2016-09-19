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


public class Fcp {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0);
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
			int sublength;

			if (linkPath != null) {
				sublength = linkPath.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 7}
				os.write(0xe7);
				codeLength += 1;
			}
			
			if (proprietaryEFInfo != null) {
				sublength = proprietaryEFInfo.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 5}
				os.write(0xa5);
				codeLength += 1;
			}
			
			if (shortEFID != null) {
				sublength = shortEFID.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 8}
				os.write(0xa8);
				codeLength += 1;
			}
			
			if (pinStatusTemplateDO != null) {
				sublength = pinStatusTemplateDO.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 6}
				os.write(0xe6);
				codeLength += 1;
			}
			
			if (efFileSize != null) {
				sublength = efFileSize.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 0}
				os.write(0xa0);
				codeLength += 1;
			}
			
			if (securityAttributesReferenced != null) {
				sublength = securityAttributesReferenced.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 11}
				os.write(0xab);
				codeLength += 1;
			}
			
			if (lcsi != null) {
				sublength = lcsi.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 10}
				os.write(0xaa);
				codeLength += 1;
			}
			
			if (dfName != null) {
				sublength = dfName.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 4}
				os.write(0xa4);
				codeLength += 1;
			}
			
			if (fileID != null) {
				sublength = fileID.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 3}
				os.write(0xa3);
				codeLength += 1;
			}
			
			if (fileDescriptor != null) {
				sublength = fileDescriptor.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 2}
				os.write(0xa2);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
				subCodeLength += new BerLength().decode(is);
				fileDescriptor = new BerOctetString();
				fileDescriptor.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2);
				subCodeLength += fileDescriptor.decode(is, true);
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
				subCodeLength += new BerLength().decode(is);
				fileID = new BerOctetString();
				fileID.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3);
				subCodeLength += fileID.decode(is, true);
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
				subCodeLength += new BerLength().decode(is);
				dfName = new ApplicationIdentifier();
				dfName.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4);
				subCodeLength += dfName.decode(is, true);
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
				subCodeLength += new BerLength().decode(is);
				lcsi = new BerOctetString();
				lcsi.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10);
				subCodeLength += lcsi.decode(is, true);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11)) {
				subCodeLength += new BerLength().decode(is);
				securityAttributesReferenced = new BerOctetString();
				securityAttributesReferenced.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11);
				subCodeLength += securityAttributesReferenced.decode(is, true);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
				subCodeLength += new BerLength().decode(is);
				efFileSize = new BerOctetString();
				efFileSize.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0);
				subCodeLength += efFileSize.decode(is, true);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
				subCodeLength += new BerLength().decode(is);
				pinStatusTemplateDO = new BerOctetString();
				pinStatusTemplateDO.id = new BerIdentifier(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 6);
				subCodeLength += pinStatusTemplateDO.decode(is, true);
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
				subCodeLength += new BerLength().decode(is);
				shortEFID = new BerOctetString();
				shortEFID.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8);
				subCodeLength += shortEFID.decode(is, true);
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
				subCodeLength += new BerLength().decode(is);
				proprietaryEFInfo = new ProprietaryInfo();
				proprietaryEFInfo.id = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5);
				subCodeLength += proprietaryEFInfo.decode(is, true);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
				subCodeLength += new BerLength().decode(is);
				linkPath = new BerOctetString();
				linkPath.id = new BerIdentifier(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 7);
				subCodeLength += linkPath.decode(is, true);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			subCodeLength += new BerLength().decode(is);
			fileDescriptor = new BerOctetString();
			subCodeLength += fileDescriptor.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			subCodeLength += new BerLength().decode(is);
			fileID = new BerOctetString();
			subCodeLength += fileID.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
			subCodeLength += new BerLength().decode(is);
			dfName = new ApplicationIdentifier();
			subCodeLength += dfName.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			subCodeLength += new BerLength().decode(is);
			lcsi = new BerOctetString();
			subCodeLength += lcsi.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11)) {
			subCodeLength += new BerLength().decode(is);
			securityAttributesReferenced = new BerOctetString();
			subCodeLength += securityAttributesReferenced.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			subCodeLength += new BerLength().decode(is);
			efFileSize = new BerOctetString();
			subCodeLength += efFileSize.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
			subCodeLength += new BerLength().decode(is);
			pinStatusTemplateDO = new BerOctetString();
			subCodeLength += pinStatusTemplateDO.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
			subCodeLength += new BerLength().decode(is);
			shortEFID = new BerOctetString();
			subCodeLength += shortEFID.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			subCodeLength += new BerLength().decode(is);
			proprietaryEFInfo = new ProprietaryInfo();
			subCodeLength += proprietaryEFInfo.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
			subCodeLength += new BerLength().decode(is);
			linkPath = new BerOctetString();
			subCodeLength += linkPath.decode(is, true);
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
