/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.pkix1implicit88;

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

import org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions.*;
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88.*;

public class GeneralSubtree {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public GeneralName base = null;

	public BaseDistance minimum = null;

	public BaseDistance maximum = null;

	public GeneralSubtree() {
		id = identifier;
	}

	public GeneralSubtree(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public GeneralSubtree(GeneralName base, BaseDistance minimum, BaseDistance maximum) {
		id = identifier;
		this.base = base;
		this.minimum = minimum;
		this.maximum = maximum;
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
			if (maximum != null) {
				codeLength += maximum.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
			}
			
			if (minimum != null) {
				codeLength += minimum.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 0
				os.write(0x80);
				codeLength += 1;
			}
			
			codeLength += base.encode(os, true);
			
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
		base = new GeneralName();
		subCodeLength += base.decode(is, berIdentifier);
		if (subCodeLength == totalLength) {
			return codeLength;
		}
		subCodeLength += berIdentifier.decode(is);
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			minimum = new BaseDistance();
			subCodeLength += minimum.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			maximum = new BaseDistance();
			subCodeLength += maximum.decode(is, false);
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
		sb.append("base: ").append(base);
		
		if (minimum != null) {
			sb.append(", ");
			sb.append("minimum: ").append(minimum);
		}
		
		if (maximum != null) {
			sb.append(", ");
			sb.append("maximum: ").append(maximum);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

