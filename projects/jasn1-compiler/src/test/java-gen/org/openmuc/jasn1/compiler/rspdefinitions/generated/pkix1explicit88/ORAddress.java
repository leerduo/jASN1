/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
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

import org.openmuc.jasn1.compiler.rspdefinitions.generated.rspdefinitions.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1implicit88.*;

public class ORAddress {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public BuiltInStandardAttributes builtInStandardAttributes = null;

	public BuiltInDomainDefinedAttributes builtInDomainDefinedAttributes = null;

	public ExtensionAttributes extensionAttributes = null;

	public ORAddress() {
		id = identifier;
	}

	public ORAddress(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ORAddress(BuiltInStandardAttributes builtInStandardAttributes, BuiltInDomainDefinedAttributes builtInDomainDefinedAttributes, ExtensionAttributes extensionAttributes) {
		id = identifier;
		this.builtInStandardAttributes = builtInStandardAttributes;
		this.builtInDomainDefinedAttributes = builtInDomainDefinedAttributes;
		this.extensionAttributes = extensionAttributes;
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
			if (extensionAttributes != null) {
				codeLength += extensionAttributes.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
				os.write(0xa2);
				codeLength += 1;
			}
			
			if (builtInDomainDefinedAttributes != null) {
				codeLength += builtInDomainDefinedAttributes.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
				os.write(0xa1);
				codeLength += 1;
			}
			
			codeLength += builtInStandardAttributes.encode(os, false);
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

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			builtInStandardAttributes = new BuiltInStandardAttributes();
			subCodeLength += builtInStandardAttributes.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			builtInDomainDefinedAttributes = new BuiltInDomainDefinedAttributes();
			subCodeLength += builtInDomainDefinedAttributes.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			extensionAttributes = new ExtensionAttributes();
			subCodeLength += extensionAttributes.decode(is, false);
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
		sb.append("builtInStandardAttributes: ").append(builtInStandardAttributes);
		
		if (builtInDomainDefinedAttributes != null) {
			sb.append(", ");
			sb.append("builtInDomainDefinedAttributes: ").append(builtInDomainDefinedAttributes);
		}
		
		if (extensionAttributes != null) {
			sb.append(", ");
			sb.append("extensionAttributes: ").append(extensionAttributes);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

