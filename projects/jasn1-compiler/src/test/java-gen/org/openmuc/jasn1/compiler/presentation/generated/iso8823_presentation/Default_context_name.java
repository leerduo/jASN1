/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
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


public class Default_context_name {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public Abstract_syntax_name abstract_syntax_name = null;

	public Transfer_syntax_name transfer_syntax_name = null;

	public Default_context_name() {
		id = identifier;
	}

	public Default_context_name(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public Default_context_name(Abstract_syntax_name abstract_syntax_name, Transfer_syntax_name transfer_syntax_name) {
		id = identifier;
		this.abstract_syntax_name = abstract_syntax_name;
		this.transfer_syntax_name = transfer_syntax_name;
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
			codeLength += transfer_syntax_name.encode(os, false);
			// write tag {CONTEXT_CLASS, PRIMITIVE, 1}
			os.write(0x81);
			codeLength += 1;
			
			codeLength += abstract_syntax_name.encode(os, false);
			// write tag {CONTEXT_CLASS, PRIMITIVE, 0}
			os.write(0x80);
			codeLength += 1;
			
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
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 0)) {
			abstract_syntax_name = new Abstract_syntax_name();
			subCodeLength += abstract_syntax_name.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			transfer_syntax_name = new Transfer_syntax_name();
			subCodeLength += transfer_syntax_name.decode(is, false);
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
		sb.append("abstract_syntax_name: ").append(abstract_syntax_name);
		
		sb.append(", ");
		sb.append("transfer_syntax_name: ").append(transfer_syntax_name);
		
		sb.append("}");
		return sb.toString();
	}

}

