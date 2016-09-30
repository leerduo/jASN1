/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions;

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
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88.*;

public class DeviceCapabilities {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public VersionType gsmSupportedRelease = null;

	public VersionType utranSupportedRelease = null;

	public VersionType cdma2000onexSupportedRelease = null;

	public VersionType cdma2000hrpdSupportedRelease = null;

	public VersionType cdma2000ehrpdSupportedRelease = null;

	public VersionType eutranSupportedRelease = null;

	public VersionType contactlessSupportedRelease = null;

	public VersionType rspCrlSupportedVersion = null;

	public VersionType rspRpmSupportedVersion = null;

	public DeviceCapabilities() {
		id = identifier;
	}

	public DeviceCapabilities(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public DeviceCapabilities(VersionType gsmSupportedRelease, VersionType utranSupportedRelease, VersionType cdma2000onexSupportedRelease, VersionType cdma2000hrpdSupportedRelease, VersionType cdma2000ehrpdSupportedRelease, VersionType eutranSupportedRelease, VersionType contactlessSupportedRelease, VersionType rspCrlSupportedVersion, VersionType rspRpmSupportedVersion) {
		id = identifier;
		this.gsmSupportedRelease = gsmSupportedRelease;
		this.utranSupportedRelease = utranSupportedRelease;
		this.cdma2000onexSupportedRelease = cdma2000onexSupportedRelease;
		this.cdma2000hrpdSupportedRelease = cdma2000hrpdSupportedRelease;
		this.cdma2000ehrpdSupportedRelease = cdma2000ehrpdSupportedRelease;
		this.eutranSupportedRelease = eutranSupportedRelease;
		this.contactlessSupportedRelease = contactlessSupportedRelease;
		this.rspCrlSupportedVersion = rspCrlSupportedVersion;
		this.rspRpmSupportedVersion = rspRpmSupportedVersion;
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
			if (rspRpmSupportedVersion != null) {
				codeLength += rspRpmSupportedVersion.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 8
				os.write(0x88);
				codeLength += 1;
			}
			
			if (rspCrlSupportedVersion != null) {
				codeLength += rspCrlSupportedVersion.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 7
				os.write(0x87);
				codeLength += 1;
			}
			
			if (contactlessSupportedRelease != null) {
				codeLength += contactlessSupportedRelease.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 6
				os.write(0x86);
				codeLength += 1;
			}
			
			if (eutranSupportedRelease != null) {
				codeLength += eutranSupportedRelease.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 5
				os.write(0x85);
				codeLength += 1;
			}
			
			if (cdma2000ehrpdSupportedRelease != null) {
				codeLength += cdma2000ehrpdSupportedRelease.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 4
				os.write(0x84);
				codeLength += 1;
			}
			
			if (cdma2000hrpdSupportedRelease != null) {
				codeLength += cdma2000hrpdSupportedRelease.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				os.write(0x83);
				codeLength += 1;
			}
			
			if (cdma2000onexSupportedRelease != null) {
				codeLength += cdma2000onexSupportedRelease.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				os.write(0x82);
				codeLength += 1;
			}
			
			if (utranSupportedRelease != null) {
				codeLength += utranSupportedRelease.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
			}
			
			if (gsmSupportedRelease != null) {
				codeLength += gsmSupportedRelease.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
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

		int totalLength = length.val;
		codeLength += totalLength;

		if (totalLength == 0) {
			return codeLength;
		}
		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			gsmSupportedRelease = new VersionType();
			subCodeLength += gsmSupportedRelease.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			utranSupportedRelease = new VersionType();
			subCodeLength += utranSupportedRelease.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			cdma2000onexSupportedRelease = new VersionType();
			subCodeLength += cdma2000onexSupportedRelease.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			cdma2000hrpdSupportedRelease = new VersionType();
			subCodeLength += cdma2000hrpdSupportedRelease.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
			cdma2000ehrpdSupportedRelease = new VersionType();
			subCodeLength += cdma2000ehrpdSupportedRelease.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 5)) {
			eutranSupportedRelease = new VersionType();
			subCodeLength += eutranSupportedRelease.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6)) {
			contactlessSupportedRelease = new VersionType();
			subCodeLength += contactlessSupportedRelease.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7)) {
			rspCrlSupportedVersion = new VersionType();
			subCodeLength += rspCrlSupportedVersion.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 8)) {
			rspRpmSupportedVersion = new VersionType();
			subCodeLength += rspRpmSupportedVersion.decode(is, false);
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
		if (gsmSupportedRelease != null) {
			sb.append("gsmSupportedRelease: ").append(gsmSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (utranSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("utranSupportedRelease: ").append(utranSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (cdma2000onexSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("cdma2000onexSupportedRelease: ").append(cdma2000onexSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (cdma2000hrpdSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("cdma2000hrpdSupportedRelease: ").append(cdma2000hrpdSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (cdma2000ehrpdSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("cdma2000ehrpdSupportedRelease: ").append(cdma2000ehrpdSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (eutranSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("eutranSupportedRelease: ").append(eutranSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (contactlessSupportedRelease != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("contactlessSupportedRelease: ").append(contactlessSupportedRelease);
			firstSelectedElement = false;
		}
		
		if (rspCrlSupportedVersion != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("rspCrlSupportedVersion: ").append(rspCrlSupportedVersion);
			firstSelectedElement = false;
		}
		
		if (rspRpmSupportedVersion != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("rspRpmSupportedVersion: ").append(rspRpmSupportedVersion);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}

