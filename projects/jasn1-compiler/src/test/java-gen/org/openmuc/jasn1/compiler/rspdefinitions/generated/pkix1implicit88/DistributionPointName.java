/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
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

import org.openmuc.jasn1.compiler.rspdefinitions.generated.teletexdomaindefinedattributes.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.rspdefinitions.*;
import org.openmuc.jasn1.compiler.rspdefinitions.generated.pkix1explicit88.*;

public class DistributionPointName {

	public byte[] code = null;
	public GeneralNames fullName = null;

	public RelativeDistinguishedName nameRelativeToCRLIssuer = null;

	public DistributionPointName() {
	}

	public DistributionPointName(byte[] code) {
		this.code = code;
	}

	public DistributionPointName(GeneralNames fullName, RelativeDistinguishedName nameRelativeToCRLIssuer) {
		this.fullName = fullName;
		this.nameRelativeToCRLIssuer = nameRelativeToCRLIssuer;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (nameRelativeToCRLIssuer != null) {
			codeLength += nameRelativeToCRLIssuer.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
			os.write(0xa1);
			codeLength += 1;
			return codeLength;

		}
		
		if (fullName != null) {
			codeLength += fullName.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			os.write(0xa0);
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			fullName = new GeneralNames();
			codeLength += fullName.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			nameRelativeToCRLIssuer = new RelativeDistinguishedName();
			codeLength += nameRelativeToCRLIssuer.decode(is, false);
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
		if ( fullName!= null) {
			return "CHOICE{fullName: " + fullName + "}";
		}

		if ( nameRelativeToCRLIssuer!= null) {
			return "CHOICE{nameRelativeToCRLIssuer: " + nameRelativeToCRLIssuer + "}";
		}

		return "unknown";
	}

}

