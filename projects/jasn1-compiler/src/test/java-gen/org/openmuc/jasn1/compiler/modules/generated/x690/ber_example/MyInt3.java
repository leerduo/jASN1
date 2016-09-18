/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
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

public class MyInt3 extends MyInt2 {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4);

	public MyInt3() {
		id = identifier;
	}

	public MyInt3(byte[] code) {
		super(code);
		id = identifier;
	}

	public MyInt3(long value) {
		super(value);
		id = identifier;
	}

}