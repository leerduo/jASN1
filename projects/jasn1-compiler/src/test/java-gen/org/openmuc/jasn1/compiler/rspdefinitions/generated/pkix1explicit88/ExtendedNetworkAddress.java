/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1explicit88;

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
import org.openmuc.jasn1.compiler.rspdefinitions.generated.rspdefinitions.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1implicit88.*;

public class ExtendedNetworkAddress {

	public byte[] code = null;
	public static class E1634Address {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public BerNumericString number = null;

		public BerNumericString subAddress = null;

		public E1634Address() {
			id = identifier;
		}

		public E1634Address(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public E1634Address(BerNumericString number, BerNumericString subAddress) {
			id = identifier;
			this.number = number;
			this.subAddress = subAddress;
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
				if (subAddress != null) {
					codeLength += subAddress.encode(os, false);
					// write tag: CONTEXT_CLASS, PRIMITIVE, 1
					os.write(0x81);
					codeLength += 1;
				}
				
				codeLength += number.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
				os.write(0x80);
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

			subCodeLength += berIdentifier.decode(is);
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				number = new BerNumericString();
				subCodeLength += number.decode(is, false);
				if (subCodeLength == totalLength) {
					return codeLength;
				}
				subCodeLength += berIdentifier.decode(is);
			}
			else {
				throw new IOException("Identifier does not match the mandatory sequence element identifer.");
			}
			
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				subAddress = new BerNumericString();
				subCodeLength += subAddress.decode(is, false);
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
			sb.append("number: ").append(number);
			
			if (subAddress != null) {
				sb.append(", ");
				sb.append("subAddress: ").append(subAddress);
			}
			
			sb.append("}");
			return sb.toString();
		}

	}

	public E1634Address e1634Address = null;

	public PresentationAddress psapAddress = null;

	public ExtendedNetworkAddress() {
	}

	public ExtendedNetworkAddress(byte[] code) {
		this.code = code;
	}

	public ExtendedNetworkAddress(E1634Address e1634Address, PresentationAddress psapAddress) {
		this.e1634Address = e1634Address;
		this.psapAddress = psapAddress;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (psapAddress != null) {
			codeLength += psapAddress.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			os.write(0xa0);
			codeLength += 1;
			return codeLength;

		}
		
		if (e1634Address != null) {
			codeLength += e1634Address.encode(os, true);
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
		if (berIdentifier.equals(E1634Address.identifier)) {
			e1634Address = new E1634Address();
			codeLength += e1634Address.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			psapAddress = new PresentationAddress();
			codeLength += psapAddress.decode(is, false);
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
		if ( e1634Address!= null) {
			return "CHOICE{e1634Address: " + e1634Address + "}";
		}

		if ( psapAddress!= null) {
			return "CHOICE{psapAddress: " + psapAddress + "}";
		}

		return "unknown";
	}

}

