/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
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

public class X520name {

	public byte[] code = null;
	public BerTeletexString teletexString = null;

	public BerPrintableString printableString = null;

	public BerUniversalString universalString = null;

	public BerUTF8String utf8String = null;

	public BerBMPString bmpString = null;

	public X520name() {
	}

	public X520name(byte[] code) {
		this.code = code;
	}

	public X520name(BerTeletexString teletexString, BerPrintableString printableString, BerUniversalString universalString, BerUTF8String utf8String, BerBMPString bmpString) {
		this.teletexString = teletexString;
		this.printableString = printableString;
		this.universalString = universalString;
		this.utf8String = utf8String;
		this.bmpString = bmpString;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (bmpString != null) {
			codeLength += bmpString.encode(os, true);
			return codeLength;

		}
		
		if (utf8String != null) {
			codeLength += utf8String.encode(os, true);
			return codeLength;

		}
		
		if (universalString != null) {
			codeLength += universalString.encode(os, true);
			return codeLength;

		}
		
		if (printableString != null) {
			codeLength += printableString.encode(os, true);
			return codeLength;

		}
		
		if (teletexString != null) {
			codeLength += teletexString.encode(os, true);
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
		if (berIdentifier.equals(BerTeletexString.identifier)) {
			teletexString = new BerTeletexString();
			codeLength += teletexString.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerPrintableString.identifier)) {
			printableString = new BerPrintableString();
			codeLength += printableString.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerUniversalString.identifier)) {
			universalString = new BerUniversalString();
			codeLength += universalString.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerUTF8String.identifier)) {
			utf8String = new BerUTF8String();
			codeLength += utf8String.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerBMPString.identifier)) {
			bmpString = new BerBMPString();
			codeLength += bmpString.decode(is, false);
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
		if ( teletexString!= null) {
			return "CHOICE{teletexString: " + teletexString + "}";
		}

		if ( printableString!= null) {
			return "CHOICE{printableString: " + printableString + "}";
		}

		if ( universalString!= null) {
			return "CHOICE{universalString: " + universalString + "}";
		}

		if ( utf8String!= null) {
			return "CHOICE{utf8String: " + utf8String + "}";
		}

		if ( bmpString!= null) {
			return "CHOICE{bmpString: " + bmpString + "}";
		}

		return "unknown";
	}

}

