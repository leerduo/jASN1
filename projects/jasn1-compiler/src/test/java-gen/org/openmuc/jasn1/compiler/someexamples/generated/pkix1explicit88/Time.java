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

public class Time {

	public byte[] code = null;
	public BerUtcTime utcTime = null;

	public BerGeneralizedTime generalTime = null;

	public Time() {
	}

	public Time(byte[] code) {
		this.code = code;
	}

	public Time(BerUtcTime utcTime, BerGeneralizedTime generalTime) {
		this.utcTime = utcTime;
		this.generalTime = generalTime;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (generalTime != null) {
			codeLength += generalTime.encode(os, true);
			return codeLength;

		}
		
		if (utcTime != null) {
			codeLength += utcTime.encode(os, true);
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
		if (berIdentifier.equals(BerUtcTime.identifier)) {
			utcTime = new BerUtcTime();
			codeLength += utcTime.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerGeneralizedTime.identifier)) {
			generalTime = new BerGeneralizedTime();
			codeLength += generalTime.decode(is, false);
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
		if ( utcTime!= null) {
			return "CHOICE{utcTime: " + utcTime + "}";
		}

		if ( generalTime!= null) {
			return "CHOICE{generalTime: " + generalTime + "}";
		}

		return "unknown";
	}

}

