/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
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

public class GeneralName {

	public byte[] code = null;
	public AnotherName otherName = null;

	public BerIA5String rfc822Name = null;

	public BerIA5String dNSName = null;

	public ORAddress x400Address = null;

	public Name directoryName = null;

	public EDIPartyName ediPartyName = null;

	public BerIA5String uniformResourceIdentifier = null;

	public BerOctetString iPAddress = null;

	public BerObjectIdentifier registeredID = null;

	public GeneralName() {
	}

	public GeneralName(byte[] code) {
		this.code = code;
	}

	public GeneralName(AnotherName otherName, BerIA5String rfc822Name, BerIA5String dNSName, ORAddress x400Address, Name directoryName, EDIPartyName ediPartyName, BerIA5String uniformResourceIdentifier, BerOctetString iPAddress, BerObjectIdentifier registeredID) {
		this.otherName = otherName;
		this.rfc822Name = rfc822Name;
		this.dNSName = dNSName;
		this.x400Address = x400Address;
		this.directoryName = directoryName;
		this.ediPartyName = ediPartyName;
		this.uniformResourceIdentifier = uniformResourceIdentifier;
		this.iPAddress = iPAddress;
		this.registeredID = registeredID;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		int sublength;

		if (registeredID != null) {
			codeLength += registeredID.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 8
			os.write(0x88);
			codeLength += 1;
			return codeLength;

		}
		
		if (iPAddress != null) {
			codeLength += iPAddress.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 7
			os.write(0x87);
			codeLength += 1;
			return codeLength;

		}
		
		if (uniformResourceIdentifier != null) {
			codeLength += uniformResourceIdentifier.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 6
			os.write(0x86);
			codeLength += 1;
			return codeLength;

		}
		
		if (ediPartyName != null) {
			codeLength += ediPartyName.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			os.write(0xa5);
			codeLength += 1;
			return codeLength;

		}
		
		if (directoryName != null) {
			sublength = directoryName.encode(os, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(os, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
			os.write(0xa4);
			codeLength += 1;
			return codeLength;

		}
		
		if (x400Address != null) {
			codeLength += x400Address.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			os.write(0xa3);
			codeLength += 1;
			return codeLength;

		}
		
		if (dNSName != null) {
			codeLength += dNSName.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 2
			os.write(0x82);
			codeLength += 1;
			return codeLength;

		}
		
		if (rfc822Name != null) {
			codeLength += rfc822Name.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			return codeLength;

		}
		
		if (otherName != null) {
			codeLength += otherName.encode(os, false);
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
			otherName = new AnotherName();
			codeLength += otherName.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			rfc822Name = new BerIA5String();
			codeLength += rfc822Name.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			dNSName = new BerIA5String();
			codeLength += dNSName.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			x400Address = new ORAddress();
			codeLength += x400Address.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
			codeLength += length.decode(is);
			directoryName = new Name();
			codeLength += directoryName.decode(is, null);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			ediPartyName = new EDIPartyName();
			codeLength += ediPartyName.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 6)) {
			uniformResourceIdentifier = new BerIA5String();
			codeLength += uniformResourceIdentifier.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 7)) {
			iPAddress = new BerOctetString();
			codeLength += iPAddress.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 8)) {
			registeredID = new BerObjectIdentifier();
			codeLength += registeredID.decode(is, false);
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
		if ( otherName!= null) {
			return "CHOICE{otherName: " + otherName + "}";
		}

		if ( rfc822Name!= null) {
			return "CHOICE{rfc822Name: " + rfc822Name + "}";
		}

		if ( dNSName!= null) {
			return "CHOICE{dNSName: " + dNSName + "}";
		}

		if ( x400Address!= null) {
			return "CHOICE{x400Address: " + x400Address + "}";
		}

		if ( directoryName!= null) {
			return "CHOICE{directoryName: " + directoryName + "}";
		}

		if ( ediPartyName!= null) {
			return "CHOICE{ediPartyName: " + ediPartyName + "}";
		}

		if ( uniformResourceIdentifier!= null) {
			return "CHOICE{uniformResourceIdentifier: " + uniformResourceIdentifier + "}";
		}

		if ( iPAddress!= null) {
			return "CHOICE{iPAddress: " + iPAddress + "}";
		}

		if ( registeredID!= null) {
			return "CHOICE{registeredID: " + registeredID + "}";
		}

		return "unknown";
	}

}

