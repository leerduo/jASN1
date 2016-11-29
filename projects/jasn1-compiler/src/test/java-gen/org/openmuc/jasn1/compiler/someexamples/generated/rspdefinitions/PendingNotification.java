/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.someexamples.generated.rspdefinitions;

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
import org.openmuc.jasn1.compiler.someexamples.generated.pkix1explicit88.*;

public class PendingNotification {

	public byte[] code = null;
	public ProfileInstallationResult profileInstallationResult = null;

	public OtherSignedNotification otherSignedNotification = null;

	public PendingNotification() {
	}

	public PendingNotification(byte[] code) {
		this.code = code;
	}

	public PendingNotification(ProfileInstallationResult profileInstallationResult, OtherSignedNotification otherSignedNotification) {
		this.profileInstallationResult = profileInstallationResult;
		this.otherSignedNotification = otherSignedNotification;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (otherSignedNotification != null) {
			codeLength += otherSignedNotification.encode(os, true);
			return codeLength;

		}
		
		if (profileInstallationResult != null) {
			codeLength += profileInstallationResult.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 55
			os.write(0x37);
			os.write(0xbf);
			codeLength += 2;
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 55)) {
			profileInstallationResult = new ProfileInstallationResult();
			codeLength += profileInstallationResult.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(OtherSignedNotification.identifier)) {
			otherSignedNotification = new OtherSignedNotification();
			codeLength += otherSignedNotification.decode(is, false);
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
		if ( profileInstallationResult!= null) {
			return "CHOICE{profileInstallationResult: " + profileInstallationResult + "}";
		}

		if ( otherSignedNotification!= null) {
			return "CHOICE{otherSignedNotification: " + otherSignedNotification + "}";
		}

		return "unknown";
	}

}
