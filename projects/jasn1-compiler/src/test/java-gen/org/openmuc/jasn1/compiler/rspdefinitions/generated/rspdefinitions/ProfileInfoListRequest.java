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

public class ProfileInfoListRequest {

	public static class SearchCriteria {

		public byte[] code = null;
		public OctetTo16 isdpAid = null;

		public Iccid iccid = null;

		public ProfileClass profileClass = null;

		public SearchCriteria() {
		}

		public SearchCriteria(byte[] code) {
			this.code = code;
		}

		public SearchCriteria(OctetTo16 isdpAid, Iccid iccid, ProfileClass profileClass) {
			this.isdpAid = isdpAid;
			this.iccid = iccid;
			this.profileClass = profileClass;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;

			}
			int codeLength = 0;
			if (profileClass != null) {
				codeLength += profileClass.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 21
				os.write(0x95);
				codeLength += 1;
				return codeLength;

			}
			
			if (iccid != null) {
				codeLength += iccid.encode(os, true);
				return codeLength;

			}
			
			if (isdpAid != null) {
				codeLength += isdpAid.encode(os, false);
				// write tag: APPLICATION_CLASS, PRIMITIVE, 15
				os.write(0x4f);
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

			BerLength length = new BerLength();
			if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 15)) {
				isdpAid = new OctetTo16();
				codeLength += isdpAid.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(Iccid.identifier)) {
				iccid = new Iccid();
				codeLength += iccid.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 21)) {
				profileClass = new ProfileClass();
				codeLength += profileClass.decode(is, false);
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
			if ( isdpAid!= null) {
				return "CHOICE{isdpAid: " + isdpAid + "}";
			}

			if ( iccid!= null) {
				return "CHOICE{iccid: " + iccid + "}";
			}

			if ( profileClass!= null) {
				return "CHOICE{profileClass: " + profileClass + "}";
			}

			return "unknown";
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 45);
	protected BerIdentifier id;

	public byte[] code = null;
	public SearchCriteria searchCriteria = null;

	public BerOctetString tagList = null;

	public ProfileInfoListRequest() {
		id = identifier;
	}

	public ProfileInfoListRequest(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ProfileInfoListRequest(SearchCriteria searchCriteria, BerOctetString tagList) {
		id = identifier;
		this.searchCriteria = searchCriteria;
		this.tagList = tagList;
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

			if (tagList != null) {
				codeLength += tagList.encode(os, false);
				// write tag: APPLICATION_CLASS, PRIMITIVE, 28
				os.write(0x5c);
				codeLength += 1;
			}
			
			if (searchCriteria != null) {
				sublength = searchCriteria.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
				os.write(0xa0);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			subCodeLength += length.decode(is);
			searchCriteria = new SearchCriteria();
			subCodeLength += searchCriteria.decode(is, null);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 28)) {
			tagList = new BerOctetString();
			subCodeLength += tagList.decode(is, false);
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
		if (searchCriteria != null) {
			sb.append("searchCriteria: ").append(searchCriteria);
			firstSelectedElement = false;
		}
		
		if (tagList != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("tagList: ").append(tagList);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}

