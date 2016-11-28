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

public class RemoteProfileProvisioningResponse {

	public byte[] code = null;
	public InitiateAuthenticationResponse initiateAuthenticationResponse = null;

	public AuthenticateClientResponseEs9 authenticateClientResponseEs9 = null;

	public GetBoundProfilePackageResponse getBoundProfilePackageResponse = null;

	public CancelSessionResponseEs9 cancelSessionResponseEs9 = null;

	public AuthenticateClientResponseEs11 authenticateClientResponseEs11 = null;

	public RemoteProfileProvisioningResponse() {
	}

	public RemoteProfileProvisioningResponse(byte[] code) {
		this.code = code;
	}

	public RemoteProfileProvisioningResponse(InitiateAuthenticationResponse initiateAuthenticationResponse, AuthenticateClientResponseEs9 authenticateClientResponseEs9, GetBoundProfilePackageResponse getBoundProfilePackageResponse, CancelSessionResponseEs9 cancelSessionResponseEs9, AuthenticateClientResponseEs11 authenticateClientResponseEs11) {
		this.initiateAuthenticationResponse = initiateAuthenticationResponse;
		this.authenticateClientResponseEs9 = authenticateClientResponseEs9;
		this.getBoundProfilePackageResponse = getBoundProfilePackageResponse;
		this.cancelSessionResponseEs9 = cancelSessionResponseEs9;
		this.authenticateClientResponseEs11 = authenticateClientResponseEs11;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (authenticateClientResponseEs11 != null) {
			codeLength += authenticateClientResponseEs11.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 64
			os.write(0x40);
			os.write(0xbf);
			codeLength += 2;
			return codeLength;

		}
		
		if (cancelSessionResponseEs9 != null) {
			codeLength += cancelSessionResponseEs9.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 65
			os.write(0x41);
			os.write(0xbf);
			codeLength += 2;
			return codeLength;

		}
		
		if (getBoundProfilePackageResponse != null) {
			codeLength += getBoundProfilePackageResponse.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 58
			os.write(0x3a);
			os.write(0xbf);
			codeLength += 2;
			return codeLength;

		}
		
		if (authenticateClientResponseEs9 != null) {
			codeLength += authenticateClientResponseEs9.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 59
			os.write(0x3b);
			os.write(0xbf);
			codeLength += 2;
			return codeLength;

		}
		
		if (initiateAuthenticationResponse != null) {
			codeLength += initiateAuthenticationResponse.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 57
			os.write(0x39);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 57)) {
			initiateAuthenticationResponse = new InitiateAuthenticationResponse();
			codeLength += initiateAuthenticationResponse.decode(is, berIdentifier);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 59)) {
			authenticateClientResponseEs9 = new AuthenticateClientResponseEs9();
			codeLength += authenticateClientResponseEs9.decode(is, berIdentifier);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 58)) {
			getBoundProfilePackageResponse = new GetBoundProfilePackageResponse();
			codeLength += getBoundProfilePackageResponse.decode(is, berIdentifier);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 65)) {
			cancelSessionResponseEs9 = new CancelSessionResponseEs9();
			codeLength += cancelSessionResponseEs9.decode(is, berIdentifier);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 64)) {
			authenticateClientResponseEs11 = new AuthenticateClientResponseEs11();
			codeLength += authenticateClientResponseEs11.decode(is, berIdentifier);
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
		if ( initiateAuthenticationResponse!= null) {
			return "CHOICE{initiateAuthenticationResponse: " + initiateAuthenticationResponse + "}";
		}

		if ( authenticateClientResponseEs9!= null) {
			return "CHOICE{authenticateClientResponseEs9: " + authenticateClientResponseEs9 + "}";
		}

		if ( getBoundProfilePackageResponse!= null) {
			return "CHOICE{getBoundProfilePackageResponse: " + getBoundProfilePackageResponse + "}";
		}

		if ( cancelSessionResponseEs9!= null) {
			return "CHOICE{cancelSessionResponseEs9: " + cancelSessionResponseEs9 + "}";
		}

		if ( authenticateClientResponseEs11!= null) {
			return "CHOICE{authenticateClientResponseEs11: " + authenticateClientResponseEs11 + "}";
		}

		return "unknown";
	}

}

