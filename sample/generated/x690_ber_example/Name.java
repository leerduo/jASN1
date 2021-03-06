/**
 * This class file was automatically generated by jASN1 v1.5.0-SNAPSHOT (http://www.openmuc.org)
 */

package generated.x690_ber_example;

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


public class Name {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.APPLICATION_CLASS, BerIdentifier.CONSTRUCTED, 1);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerVisibleString givenName = null;

	public BerVisibleString initial = null;

	public BerVisibleString familyName = null;

	public Name() {
		id = identifier;
	}

	public Name(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public Name(BerVisibleString givenName, BerVisibleString initial, BerVisibleString familyName) {
		id = identifier;
		this.givenName = givenName;
		this.initial = initial;
		this.familyName = familyName;
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
			codeLength += familyName.encode(os, true);
			
			codeLength += initial.encode(os, true);
			
			codeLength += givenName.encode(os, true);
			
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

		codeLength += length.val;

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerVisibleString.identifier)) {
			givenName = new BerVisibleString();
			subCodeLength += givenName.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerVisibleString.identifier)) {
			initial = new BerVisibleString();
			subCodeLength += initial.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerVisibleString.identifier)) {
			familyName = new BerVisibleString();
			subCodeLength += familyName.decode(is, false);
			if (subCodeLength == length.val) {
				return codeLength;
			}
		}
		throw new IOException("Unexpected end of sequence, length tag: " + length.val + ", actual sequence length: " + subCodeLength);

		
	}

	public void encodeAndSave(int encodingSizeGuess) throws IOException {
		BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
		encode(os, false);
		code = os.getArray();
	}

	public String toString() {
		StringBuilder sb = new StringBuilder("SEQUENCE{");
		sb.append("givenName: ").append(givenName);
		
		sb.append(", ");
		sb.append("initial: ").append(initial);
		
		sb.append(", ");
		sb.append("familyName: ").append(familyName);
		
		sb.append("}");
		return sb.toString();
	}

}

