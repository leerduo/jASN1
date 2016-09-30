/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88;

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
import org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions.*;

public class PDSParameter {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 17);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerPrintableString printableString = null;

	public BerTeletexString teletexString = null;

	public PDSParameter() {
		id = identifier;
	}

	public PDSParameter(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PDSParameter(BerPrintableString printableString, BerTeletexString teletexString) {
		id = identifier;
		this.printableString = printableString;
		this.teletexString = teletexString;
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
			if (teletexString != null) {
				codeLength += teletexString.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 1
				os.write(0x81);
				codeLength += 1;
			}
			
			if (printableString != null) {
				codeLength += printableString.encode(os, false);
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
		while (subCodeLength < totalLength) {
			subCodeLength += berIdentifier.decode(is);
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
				printableString = new BerPrintableString();
				subCodeLength += printableString.decode(is, false);
			}
			else if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				teletexString = new BerTeletexString();
				subCodeLength += teletexString.decode(is, false);
			}
		}
		if (subCodeLength != totalLength) {
			throw new IOException("Length of set does not match length tag, length tag: " + totalLength + ", actual set length: " + subCodeLength);

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
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		boolean firstSelectedElement = true;
		if (printableString != null) {
			sb.append("printableString: ").append(printableString);
			firstSelectedElement = false;
		}
		
		if (teletexString != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("teletexString: ").append(teletexString);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}

