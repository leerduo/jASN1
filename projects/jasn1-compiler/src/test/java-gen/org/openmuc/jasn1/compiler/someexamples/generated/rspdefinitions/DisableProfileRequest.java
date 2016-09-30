/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
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

public class DisableProfileRequest {

	public static class Ets {

		public byte[] code = null;
		public OctetTo16 isdpAid = null;

		public Iccid iccid = null;

		public Ets() {
		}

		public Ets(byte[] code) {
			this.code = code;
		}

		public Ets(OctetTo16 isdpAid, Iccid iccid) {
			this.isdpAid = isdpAid;
			this.iccid = iccid;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;

			}
			int codeLength = 0;
			if (iccid != null) {
				codeLength += iccid.encode(os, true);
				return codeLength;

			}
			
			if (isdpAid != null) {
				codeLength += isdpAid.encode(os, false);
				// write tag: APPLICATION_CLASS, PRIMITIVE, 15
				os.write(0x4f);
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
			if (berIdentifier.equals(BerIdentifier.APPLICATION_CLASS, BerIdentifier.PRIMITIVE, 15)) {
				isdpAid = new OctetTo16();
				codeLength += isdpAid.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(Iccid.identifier)) {
				iccid = new Iccid();
				codeLength += iccid.decode(is, false);
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
			if ( isdpAid!= null) {
				return "CHOICE{isdpAid: " + isdpAid + "}";
			}

			if ( iccid!= null) {
				return "CHOICE{iccid: " + iccid + "}";
			}

			return "unknown";
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 50);
	protected BerIdentifier id;

	public byte[] code = null;
	public Ets ets = null;

	public BerBoolean refreshFlag = null;

	public DisableProfileRequest() {
		id = identifier;
	}

	public DisableProfileRequest(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public DisableProfileRequest(Ets ets, BerBoolean refreshFlag) {
		id = identifier;
		this.ets = ets;
		this.refreshFlag = refreshFlag;
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
			int sublength;

			codeLength += refreshFlag.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			
			sublength = ets.encode(os, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(os, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 0
			os.write(0xa0);
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

		int totalLength = length.val;
		codeLength += totalLength;

		if (totalLength == -1) {
			subCodeLength += berIdentifier.decode(is);

			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
				subCodeLength += length.decode(is);
				ets = new Ets();
				int choiceDecodeLength = ets.decode(is, null);
				if (choiceDecodeLength != 0) {
					subCodeLength += choiceDecodeLength;
					subCodeLength += berIdentifier.decode(is);
				}
				else {
					ets = null;
				}

			}
			if (berIdentifier.tagNumber == 0 && berIdentifier.identifierClass == 0 && berIdentifier.primitive == 0) {
				int nextByte = is.read();
				if (nextByte != 0) {
					if (nextByte == -1) {
						throw new EOFException("Unexpected end of input stream.");
					}
					throw new IOException("Decoded sequence has wrong end of contents octets");
				}
				codeLength += subCodeLength + 1;
				return codeLength;
			}
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				refreshFlag = new BerBoolean();
				subCodeLength += refreshFlag.decode(is, false);
				subCodeLength += berIdentifier.decode(is);
			}
			int nextByte = is.read();
			if (berIdentifier.tagNumber != 0 || berIdentifier.identifierClass != 0 || berIdentifier.primitive != 0
			|| nextByte != 0) {
				if (nextByte == -1) {
					throw new EOFException("Unexpected end of input stream.");
				}
				throw new IOException("Decoded sequence has wrong end of contents octets");
			}
			codeLength += subCodeLength + 1;
			return codeLength;
		}

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			subCodeLength += length.decode(is);
			ets = new Ets();
			subCodeLength += ets.decode(is, null);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match required sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			refreshFlag = new BerBoolean();
			subCodeLength += refreshFlag.decode(is, false);
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
		sb.append("ets: ").append(ets);
		
		sb.append(", ");
		sb.append("refreshFlag: ").append(refreshFlag);
		
		sb.append("}");
		return sb.toString();
	}

}

