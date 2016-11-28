/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
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

import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1implicit88.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1explicit88.*;

public class ProfileInstallationResult {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 55);
	protected BerIdentifier id;

	public byte[] code = null;
	public ProfileInstallationResultData profileInstallationResultData = null;

	public EuiccSignPIR euiccSignPIR = null;

	public ProfileInstallationResult() {
		id = identifier;
	}

	public ProfileInstallationResult(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ProfileInstallationResult(ProfileInstallationResultData profileInstallationResultData, EuiccSignPIR euiccSignPIR) {
		id = identifier;
		this.profileInstallationResultData = profileInstallationResultData;
		this.euiccSignPIR = euiccSignPIR;
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
			codeLength += euiccSignPIR.encode(os, true);
			
			codeLength += profileInstallationResultData.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 39
			os.write(0x27);
			os.write(0xbf);
			codeLength += 2;
			
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 39)) {
			profileInstallationResultData = new ProfileInstallationResultData();
			subCodeLength += profileInstallationResultData.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(EuiccSignPIR.identifier)) {
			euiccSignPIR = new EuiccSignPIR();
			subCodeLength += euiccSignPIR.decode(is, false);
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
		sb.append("profileInstallationResultData: ").append(profileInstallationResultData);
		
		sb.append(", ");
		sb.append("euiccSignPIR: ").append(euiccSignPIR);
		
		sb.append("}");
		return sb.toString();
	}

}

