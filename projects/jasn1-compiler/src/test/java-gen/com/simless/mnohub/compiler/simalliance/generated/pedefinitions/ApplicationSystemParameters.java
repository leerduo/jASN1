/**
 * This class file was automatically generated by jASN1 v1.5.0 (http://www.openmuc.org)
 */

package com.simless.mnohub.compiler.simalliance.generated.pedefinitions;

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


public class ApplicationSystemParameters {

	public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public BerOctetString volatileMemoryQuotaC7 = null;

	public BerOctetString nonVolatileMemoryQuotaC8 = null;

	public BerOctetString globalServiceParameters = null;

	public BerOctetString implicitSelectionParameter = null;

	public BerOctetString volatileReservedMemory = null;

	public BerOctetString nonVolatileReservedMemory = null;

	public BerOctetString ts102226SIMFileAccessToolkitParameter = null;

	public TS102226AdditionalContactlessParameters ts102226AdditionalContactlessParameters = null;

	public BerOctetString contactlessProtocolParameters = null;

	public BerOctetString userInteractionContactlessParameters = null;

	public ApplicationSystemParameters() {
		id = identifier;
	}

	public ApplicationSystemParameters(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public ApplicationSystemParameters(BerOctetString volatileMemoryQuotaC7, BerOctetString nonVolatileMemoryQuotaC8, BerOctetString globalServiceParameters, BerOctetString implicitSelectionParameter, BerOctetString volatileReservedMemory, BerOctetString nonVolatileReservedMemory, BerOctetString ts102226SIMFileAccessToolkitParameter, TS102226AdditionalContactlessParameters ts102226AdditionalContactlessParameters, BerOctetString contactlessProtocolParameters, BerOctetString userInteractionContactlessParameters) {
		id = identifier;
		this.volatileMemoryQuotaC7 = volatileMemoryQuotaC7;
		this.nonVolatileMemoryQuotaC8 = nonVolatileMemoryQuotaC8;
		this.globalServiceParameters = globalServiceParameters;
		this.implicitSelectionParameter = implicitSelectionParameter;
		this.volatileReservedMemory = volatileReservedMemory;
		this.nonVolatileReservedMemory = nonVolatileReservedMemory;
		this.ts102226SIMFileAccessToolkitParameter = ts102226SIMFileAccessToolkitParameter;
		this.ts102226AdditionalContactlessParameters = ts102226AdditionalContactlessParameters;
		this.contactlessProtocolParameters = contactlessProtocolParameters;
		this.userInteractionContactlessParameters = userInteractionContactlessParameters;
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

			if (userInteractionContactlessParameters != null) {
				sublength = userInteractionContactlessParameters.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 26}
				os.write(0xfa);
				codeLength += 1;
			}
			
			if (contactlessProtocolParameters != null) {
				sublength = contactlessProtocolParameters.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 25}
				os.write(0xf9);
				codeLength += 1;
			}
			
			if (ts102226AdditionalContactlessParameters != null) {
				sublength = ts102226AdditionalContactlessParameters.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {CONTEXT_CLASS, CONSTRUCTED, 0}
				os.write(0xa0);
				codeLength += 1;
			}
			
			if (ts102226SIMFileAccessToolkitParameter != null) {
				sublength = ts102226SIMFileAccessToolkitParameter.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 10}
				os.write(0xea);
				codeLength += 1;
			}
			
			if (nonVolatileReservedMemory != null) {
				sublength = nonVolatileReservedMemory.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 24}
				os.write(0xf8);
				codeLength += 1;
			}
			
			if (volatileReservedMemory != null) {
				sublength = volatileReservedMemory.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 23}
				os.write(0xf7);
				codeLength += 1;
			}
			
			if (implicitSelectionParameter != null) {
				sublength = implicitSelectionParameter.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 15}
				os.write(0xef);
				codeLength += 1;
			}
			
			if (globalServiceParameters != null) {
				sublength = globalServiceParameters.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 11}
				os.write(0xeb);
				codeLength += 1;
			}
			
			if (nonVolatileMemoryQuotaC8 != null) {
				sublength = nonVolatileMemoryQuotaC8.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 8}
				os.write(0xe8);
				codeLength += 1;
			}
			
			if (volatileMemoryQuotaC7 != null) {
				sublength = volatileMemoryQuotaC7.encode(os, true);
				codeLength += sublength;
				codeLength += BerLength.encodeLength(os, sublength);
				// write tag {PRIVATE_CLASS, CONSTRUCTED, 7}
				os.write(0xe7);
				codeLength += 1;
			}
			
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

		if (length.val == -1) {
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
				subCodeLength += new BerLength().decode(is);
				volatileMemoryQuotaC7 = new BerOctetString();
				subCodeLength += volatileMemoryQuotaC7.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
				subCodeLength += new BerLength().decode(is);
				nonVolatileMemoryQuotaC8 = new BerOctetString();
				subCodeLength += nonVolatileMemoryQuotaC8.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 11)) {
				subCodeLength += new BerLength().decode(is);
				globalServiceParameters = new BerOctetString();
				subCodeLength += globalServiceParameters.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 15)) {
				subCodeLength += new BerLength().decode(is);
				implicitSelectionParameter = new BerOctetString();
				subCodeLength += implicitSelectionParameter.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 23)) {
				subCodeLength += new BerLength().decode(is);
				volatileReservedMemory = new BerOctetString();
				subCodeLength += volatileReservedMemory.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 24)) {
				subCodeLength += new BerLength().decode(is);
				nonVolatileReservedMemory = new BerOctetString();
				subCodeLength += nonVolatileReservedMemory.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
				subCodeLength += new BerLength().decode(is);
				ts102226SIMFileAccessToolkitParameter = new BerOctetString();
				subCodeLength += ts102226SIMFileAccessToolkitParameter.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
				subCodeLength += new BerLength().decode(is);
				ts102226AdditionalContactlessParameters = new TS102226AdditionalContactlessParameters();
				subCodeLength += ts102226AdditionalContactlessParameters.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 25)) {
				subCodeLength += new BerLength().decode(is);
				contactlessProtocolParameters = new BerOctetString();
				subCodeLength += contactlessProtocolParameters.decode(is, true);
				subCodeLength += berIdentifier.decode(is);
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
			if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 26)) {
				subCodeLength += new BerLength().decode(is);
				userInteractionContactlessParameters = new BerOctetString();
				subCodeLength += userInteractionContactlessParameters.decode(is, true);
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

		if (length.val == 0) {
			return codeLength;
		}
		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
			subCodeLength += new BerLength().decode(is);
			volatileMemoryQuotaC7 = new BerOctetString();
			subCodeLength += volatileMemoryQuotaC7.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
			subCodeLength += new BerLength().decode(is);
			nonVolatileMemoryQuotaC8 = new BerOctetString();
			subCodeLength += nonVolatileMemoryQuotaC8.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 11)) {
			subCodeLength += new BerLength().decode(is);
			globalServiceParameters = new BerOctetString();
			subCodeLength += globalServiceParameters.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 15)) {
			subCodeLength += new BerLength().decode(is);
			implicitSelectionParameter = new BerOctetString();
			subCodeLength += implicitSelectionParameter.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 23)) {
			subCodeLength += new BerLength().decode(is);
			volatileReservedMemory = new BerOctetString();
			subCodeLength += volatileReservedMemory.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 24)) {
			subCodeLength += new BerLength().decode(is);
			nonVolatileReservedMemory = new BerOctetString();
			subCodeLength += nonVolatileReservedMemory.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			subCodeLength += new BerLength().decode(is);
			ts102226SIMFileAccessToolkitParameter = new BerOctetString();
			subCodeLength += ts102226SIMFileAccessToolkitParameter.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			subCodeLength += new BerLength().decode(is);
			ts102226AdditionalContactlessParameters = new TS102226AdditionalContactlessParameters();
			subCodeLength += ts102226AdditionalContactlessParameters.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 25)) {
			subCodeLength += new BerLength().decode(is);
			contactlessProtocolParameters = new BerOctetString();
			subCodeLength += contactlessProtocolParameters.decode(is, true);
			if (subCodeLength == length.val) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.PRIVATE_CLASS, BerIdentifier.CONSTRUCTED, 26)) {
			subCodeLength += new BerLength().decode(is);
			userInteractionContactlessParameters = new BerOctetString();
			subCodeLength += userInteractionContactlessParameters.decode(is, true);
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
		boolean firstSelectedElement = true;
		if (volatileMemoryQuotaC7 != null) {
			sb.append("volatileMemoryQuotaC7: ").append(volatileMemoryQuotaC7);
			firstSelectedElement = false;
		}
		
		if (nonVolatileMemoryQuotaC8 != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("nonVolatileMemoryQuotaC8: ").append(nonVolatileMemoryQuotaC8);
			firstSelectedElement = false;
		}
		
		if (globalServiceParameters != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("globalServiceParameters: ").append(globalServiceParameters);
			firstSelectedElement = false;
		}
		
		if (implicitSelectionParameter != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("implicitSelectionParameter: ").append(implicitSelectionParameter);
			firstSelectedElement = false;
		}
		
		if (volatileReservedMemory != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("volatileReservedMemory: ").append(volatileReservedMemory);
			firstSelectedElement = false;
		}
		
		if (nonVolatileReservedMemory != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("nonVolatileReservedMemory: ").append(nonVolatileReservedMemory);
			firstSelectedElement = false;
		}
		
		if (ts102226SIMFileAccessToolkitParameter != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("ts102226SIMFileAccessToolkitParameter: ").append(ts102226SIMFileAccessToolkitParameter);
			firstSelectedElement = false;
		}
		
		if (ts102226AdditionalContactlessParameters != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("ts102226AdditionalContactlessParameters: ").append(ts102226AdditionalContactlessParameters);
			firstSelectedElement = false;
		}
		
		if (contactlessProtocolParameters != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("contactlessProtocolParameters: ").append(contactlessProtocolParameters);
			firstSelectedElement = false;
		}
		
		if (userInteractionContactlessParameters != null) {
			if (!firstSelectedElement) {
				sb.append(", ");
			}
			sb.append("userInteractionContactlessParameters: ").append(userInteractionContactlessParameters);
			firstSelectedElement = false;
		}
		
		sb.append("}");
		return sb.toString();
	}

}

