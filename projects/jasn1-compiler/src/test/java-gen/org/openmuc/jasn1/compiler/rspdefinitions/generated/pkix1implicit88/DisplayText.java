/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1implicit88;

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
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1explicit88.*;

public class DisplayText {

	public byte[] code = null;
	public BerIA5String ia5String = null;

	public BerVisibleString visibleString = null;

	public BerBMPString bmpString = null;

	public BerUTF8String utf8String = null;

	public DisplayText() {
	}

	public DisplayText(byte[] code) {
		this.code = code;
	}

	public DisplayText(BerIA5String ia5String, BerVisibleString visibleString, BerBMPString bmpString, BerUTF8String utf8String) {
		this.ia5String = ia5String;
		this.visibleString = visibleString;
		this.bmpString = bmpString;
		this.utf8String = utf8String;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (utf8String != null) {
			codeLength += utf8String.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 3
			os.write(0x83);
			codeLength += 1;
			return codeLength;

		}
		
		if (bmpString != null) {
			codeLength += bmpString.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			os.write(0x82);
			codeLength += 1;
			return codeLength;

		}
		
		if (visibleString != null) {
			codeLength += visibleString.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			return codeLength;

		}
		
		if (ia5String != null) {
			codeLength += ia5String.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 0
			os.write(0x80);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			ia5String = new BerIA5String();
			codeLength += ia5String.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			visibleString = new BerVisibleString();
			codeLength += visibleString.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			bmpString = new BerBMPString();
			codeLength += bmpString.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			utf8String = new BerUTF8String();
			codeLength += utf8String.decode(is, false);
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
		if ( ia5String!= null) {
			return "CHOICE{ia5String: " + ia5String + "}";
		}

		if ( visibleString!= null) {
			return "CHOICE{visibleString: " + visibleString + "}";
		}

		if ( bmpString!= null) {
			return "CHOICE{bmpString: " + bmpString + "}";
		}

		if ( utf8String!= null) {
			return "CHOICE{utf8String: " + utf8String + "}";
		}

		return "unknown";
	}

}

