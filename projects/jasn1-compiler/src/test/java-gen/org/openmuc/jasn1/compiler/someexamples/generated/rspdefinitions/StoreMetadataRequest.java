/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
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

public class StoreMetadataRequest {

	public static class NotificationConfigurationInfo {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<NotificationConfigurationInformation> seqOf = null;

		public NotificationConfigurationInfo() {
			id = identifier;
			seqOf = new ArrayList<NotificationConfigurationInformation>();
		}

		public NotificationConfigurationInfo(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public NotificationConfigurationInfo(List<NotificationConfigurationInformation> seqOf) {
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

					NotificationConfigurationInformation element = new NotificationConfigurationInformation();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				NotificationConfigurationInformation element = new NotificationConfigurationInformation();
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
				Iterator<NotificationConfigurationInformation> it = seqOf.iterator();
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

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 37);
	protected BerIdentifier id;

	public byte[] code = null;
	public Iccid iccid = null;

	public BerUTF8String serviceProviderName = null;

	public BerUTF8String profileName = null;

	public IconType iconType = null;

	public BerOctetString icon = null;

	public ProfileClass profileClass = null;

	public NotificationConfigurationInfo notificationConfigurationInfo = null;

	public OperatorID profileOwner = null;

	public PprIds profilePolicyRules = null;

	public StoreMetadataRequest() {
		id = identifier;
	}

	public StoreMetadataRequest(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public StoreMetadataRequest(Iccid iccid, BerUTF8String serviceProviderName, BerUTF8String profileName, IconType iconType, BerOctetString icon, ProfileClass profileClass, NotificationConfigurationInfo notificationConfigurationInfo, OperatorID profileOwner, PprIds profilePolicyRules) {
		id = identifier;
		this.iccid = iccid;
		this.serviceProviderName = serviceProviderName;
		this.profileName = profileName;
		this.iconType = iconType;
		this.icon = icon;
		this.profileClass = profileClass;
		this.notificationConfigurationInfo = notificationConfigurationInfo;
		this.profileOwner = profileOwner;
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
			
			if (profileOwner != null) {
				codeLength += profileOwner.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 23
				os.write(0xb7);
				codeLength += 1;
			}
			
			if (notificationConfigurationInfo != null) {
				codeLength += notificationConfigurationInfo.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 22
				os.write(0xb6);
				codeLength += 1;
			}
			
			if (profileClass != null) {
				codeLength += profileClass.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 21
				os.write(0x95);
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
			
			codeLength += profileName.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 18
			os.write(0x92);
			codeLength += 1;
			
			codeLength += serviceProviderName.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 17
			os.write(0x91);
			codeLength += 1;
			
			codeLength += iccid.encode(os, true);
			
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
			if (berIdentifier.equals(Iccid.identifier)) {
				iccid = new Iccid();
				subCodeLength += iccid.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 17)) {
				serviceProviderName = new BerUTF8String();
				subCodeLength += serviceProviderName.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 18)) {
				profileName = new BerUTF8String();
				subCodeLength += profileName.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 19)) {
				iconType = new IconType();
				subCodeLength += iconType.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 20)) {
				icon = new BerOctetString();
				subCodeLength += icon.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 21)) {
				profileClass = new ProfileClass();
				subCodeLength += profileClass.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 22)) {
				notificationConfigurationInfo = new NotificationConfigurationInfo();
				subCodeLength += notificationConfigurationInfo.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 23)) {
				profileOwner = new OperatorID();
				subCodeLength += profileOwner.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 25)) {
				profilePolicyRules = new PprIds();
				subCodeLength += profilePolicyRules.decode(is, false);
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
		if (berIdentifier.equals(Iccid.identifier)) {
			iccid = new Iccid();
			subCodeLength += iccid.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 17)) {
			serviceProviderName = new BerUTF8String();
			subCodeLength += serviceProviderName.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 18)) {
			profileName = new BerUTF8String();
			subCodeLength += profileName.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
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
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 21)) {
			profileClass = new ProfileClass();
			subCodeLength += profileClass.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 22)) {
			notificationConfigurationInfo = new NotificationConfigurationInfo();
			subCodeLength += notificationConfigurationInfo.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 23)) {
			profileOwner = new OperatorID();
			subCodeLength += profileOwner.decode(is, false);
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
		sb.append("iccid: ").append(iccid);
		
		sb.append(", ");
		sb.append("serviceProviderName: ").append(serviceProviderName);
		
		sb.append(", ");
		sb.append("profileName: ").append(profileName);
		
		if (iconType != null) {
			sb.append(", ");
			sb.append("iconType: ").append(iconType);
		}
		
		if (icon != null) {
			sb.append(", ");
			sb.append("icon: ").append(icon);
		}
		
		if (profileClass != null) {
			sb.append(", ");
			sb.append("profileClass: ").append(profileClass);
		}
		
		if (notificationConfigurationInfo != null) {
			sb.append(", ");
			sb.append("notificationConfigurationInfo: ").append(notificationConfigurationInfo);
		}
		
		if (profileOwner != null) {
			sb.append(", ");
			sb.append("profileOwner: ").append(profileOwner);
		}
		
		if (profilePolicyRules != null) {
			sb.append(", ");
			sb.append("profilePolicyRules: ").append(profilePolicyRules);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

