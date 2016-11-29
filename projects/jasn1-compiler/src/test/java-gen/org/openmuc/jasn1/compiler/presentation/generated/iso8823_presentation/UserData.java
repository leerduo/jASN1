/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.presentation.generated.iso8823_presentation;

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


public class UserData {

	public byte[] code = null;
	public SimplyEncodedData simplyEncodedData = null;

	public FullyEncodedData fullyEncodedData = null;

	public UserData() {
	}

	public UserData(byte[] code) {
		this.code = code;
	}

	public UserData(SimplyEncodedData simplyEncodedData, FullyEncodedData fullyEncodedData) {
		this.simplyEncodedData = simplyEncodedData;
		this.fullyEncodedData = fullyEncodedData;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (fullyEncodedData != null) {
			codeLength += fullyEncodedData.encode(os, false);
			// write tag: APPLICATION_CLASS, CONSTRUCTED, 1
			os.write(0x61);
			codeLength += 1;
			return codeLength;

		}
		
		if (simplyEncodedData != null) {
			codeLength += simplyEncodedData.encode(os, false);
			// write tag: APPLICATION_CLASS, PRIMITIVE, 0
			os.write(0x40);
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
		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			simplyEncodedData = new SimplyEncodedData();
			codeLength += simplyEncodedData.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			fullyEncodedData = new FullyEncodedData();
			codeLength += fullyEncodedData.decode(is, false);
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
		if ( simplyEncodedData!= null) {
			return "CHOICE{simplyEncodedData: " + simplyEncodedData + "}";
		}

		if ( fullyEncodedData!= null) {
			return "CHOICE{fullyEncodedData: " + fullyEncodedData + "}";
		}

		return "unknown";
	}

}

