/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions.generated.rspdefinitions;

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

import org.openmuc.jasn1.compiler.rspdefinitions.generated.teletexdomaindefinedattributes.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1implicit88.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1explicit88.*;

public class UpdateMetadataRequest {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 42);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerUTF8String serviceProviderName = null;

	public BerUTF8String profileName = null;

	public IconType iconType = null;

	public BerOctetString icon = null;

	public PprIds profilePolicyRules = null;

	public UpdateMetadataRequest() {
		id = identifier;
	}

	public UpdateMetadataRequest(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public UpdateMetadataRequest(BerUTF8String serviceProviderName, BerUTF8String profileName, IconType iconType, BerOctetString icon, PprIds profilePolicyRules) {
		id = identifier;
		this.serviceProviderName = serviceProviderName;
		this.profileName = profileName;
		this.iconType = iconType;
		this.icon = icon;
		this.profilePolicyRules = profilePolicyRules;
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
			if (profilePolicyRules != null) {
				codeLength += profilePolicyRules.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 25
				os.write(0x99);
				codeLength += 1;
			}
			
			if (icon != null) {
				codeLength += icon.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 20
				os.write(0x94);
				codeLength += 1;
			}
			
			if (iconType != null) {
				codeLength += iconType.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 19
				os.write(0x93);
				codeLength += 1;
			}
			
			if (profileName != null) {
				codeLength += profileName.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 18
				os.write(0x92);
				codeLength += 1;
			}
			
			if (serviceProviderName != null) {
				codeLength += serviceProviderName.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 17
				os.write(0x91);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 17)) {
			serviceProviderName = new BerUTF8String();
			subCodeLength += serviceProviderName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 18)) {
			profileName = new BerUTF8String();
			subCodeLength += profileName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 19)) {
			iconType = new IconType();
			subCodeLength += iconType.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 20)) {
			icon = new BerOctetString();
			subCodeLength += icon.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 25)) {
			profilePolicyRules = new PprIds();
			subCodeLength += profilePolicyRules.decode(is, false);
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
		if (serviceProviderName != null) {
			sb.append("serviceProviderName: ").append(serviceProviderName);
			firstSelectedElement = false;
		}
		
		if (profileName != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("profileName: ").append(profileName);
			firstSelectedElement = false;
		}
		
		if (iconType != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("iconType: ").append(iconType);
			firstSelectedElement = false;
		}
		
		if (icon != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("icon: ").append(icon);
			firstSelectedElement = false;
		}
		
		if (profilePolicyRules != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("profilePolicyRules: ").append(profilePolicyRules);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}

