/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.modules.generated.x690.ber_example;

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

import org.openmuc.jasn1.compiler.modules.generated.x690.ber_example_3.*;
import org.openmuc.jasn1.compiler.modules.generated.x690.ber_example_2.*;

public class TestChoice {

	public byte[] code = null;
	public ChildInformation choiceElement1 = null;

	public ChildInformation3 choiceElement2 = null;

	public TestChoice() {
	}

	public TestChoice(byte[] code) {
		this.code = code;
	}

	public TestChoice(ChildInformation choiceElement1, ChildInformation3 choiceElement2) {
		this.choiceElement1 = choiceElement1;
		this.choiceElement2 = choiceElement2;
	}

	public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
		if (code != null) {
			for (int i = code.length - 1; i >= 0; i--) {
				os.write(code[i]);
			}
			return code.length;

		}
		int codeLength = 0;
		if (choiceElement2 != null) {
			codeLength += choiceElement2.encode(os, true);
			return codeLength;

		}
		
		if (choiceElement1 != null) {
			codeLength += choiceElement1.encode(os, true);
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
		if (berIdentifier.equals(ChildInformation.identifier)) {
			choiceElement1 = new ChildInformation();
			codeLength += choiceElement1.decode(is, false);
			return codeLength;
		}

		if (berIdentifier.equals(ChildInformation3.identifier)) {
			choiceElement2 = new ChildInformation3();
			codeLength += choiceElement2.decode(is, false);
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
		if ( choiceElement1!= null) {
			return "CHOICE{choiceElement1: " + choiceElement1 + "}";
		}

		if ( choiceElement2!= null) {
			return "CHOICE{choiceElement2: " + choiceElement2 + "}";
		}

		return "unknown";
	}

}

