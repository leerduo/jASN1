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

public class TestChoice3 extends TestChoice2 {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11);

	protected BerIdentifier id;

	public byte[] code = null;

	public TestChoice3() {
		id = identifier;
	}

	public TestChoice3(byte[] code) {
		super(code);
		id = identifier;
	}

	public TestChoice3(ChildInformation choiceElement1, ChildInformation3 choiceElement2) {
		super(choiceElement1, choiceElement2);
		id = identifier;
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
			codeLength = super.encode(os, true);
			codeLength += BerLength.encodeLength(os, codeLength);
		}

		if (explicit) {
			codeLength += id.encode(os);
		}

		return codeLength;
	}

	public int decode(InputStream is, boolean explicit) throws IOException {

		int codeLength = 0;

		if (explicit) {
			codeLength += id.decodeAndCheck(is);
		}

		BerLength length = new BerLength();
		codeLength += length.decode(is);

		codeLength += super.decode(is, null);

		return codeLength;
	}

}
