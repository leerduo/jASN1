/**
 * This class file was automatically generated by jASN1 v1.6.1-SNAPSHOT (http://www.openmuc.org)
 */

package org.openmuc.jasn1.compiler.automatictagging.generated.pedefinitions;

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


public class PEAKAParameter {

	public static class AlgoConfiguration {

		public byte[] code = null;
		public MappingParameter mappingParameter = null;

		public AlgoParameter algoParameter = null;

		public AlgoConfiguration() {
		}

		public AlgoConfiguration(byte[] code) {
			this.code = code;
		}

		public AlgoConfiguration(MappingParameter mappingParameter, AlgoParameter algoParameter) {
			this.mappingParameter = mappingParameter;
			this.algoParameter = algoParameter;
		}

		public int encode(BerByteArrayOutputStream os, boolean explicit) throws IOException {
			if (code != null) {
				for (int i = code.length - 1; i >= 0; i--) {
					os.write(code[i]);
				}
				return code.length;

			}
			int codeLength = 0;
			if (algoParameter != null) {
				codeLength += algoParameter.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
				os.write(0xa1);
				codeLength += 1;
				return codeLength;

			}
			
			if (mappingParameter != null) {
				codeLength += mappingParameter.encode(os, false);
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
				mappingParameter = new MappingParameter();
				codeLength += mappingParameter.decode(is, false);
				return codeLength;
			}

			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
				algoParameter = new AlgoParameter();
				codeLength += algoParameter.decode(is, false);
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
			if ( mappingParameter!= null) {
				return "CHOICE{mappingParameter: " + mappingParameter + "}";
			}

			if ( algoParameter!= null) {
				return "CHOICE{algoParameter: " + algoParameter + "}";
			}

			return "unknown";
		}

	}

	public static class SqnInit {

		public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
		protected BerIdentifier id;

		public byte[] code = null;
		public List<BerOctetString> seqOf = null;

		public SqnInit() {
			id = identifier;
			seqOf = new ArrayList<BerOctetString>();
		}

		public SqnInit(byte[] code) {
			id = identifier;
			this.code = code;
		}

		public SqnInit(List<BerOctetString> seqOf) {
			id = identifier;
			this.seqOf = seqOf;
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
				for (int i = (seqOf.size() - 1); i >= 0; i--) {
					codeLength += seqOf.get(i).encode(os, true);
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
			int totalLength = length.val;

			if (length.val == -1) {
				while (true) {
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

					BerOctetString element = new BerOctetString();
					subCodeLength += element.decode(is, false);
					seqOf.add(element);
				}
			}
			while (subCodeLength < totalLength) {
				BerOctetString element = new BerOctetString();
				subCodeLength += element.decode(is, true);
				seqOf.add(element);
			}
			if (subCodeLength != totalLength) {
				throw new IOException("Decoded SequenceOf or SetOf has wrong length. Expected " + totalLength + " but has " + subCodeLength);

			}
			codeLength += subCodeLength;

			return codeLength;
		}

		public void encodeAndSave(int encodingSizeGuess) throws IOException {
			BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
			encode(os, false);
			code = os.getArray();
		}

		public String toString() {
			StringBuilder sb = new StringBuilder("SEQUENCE OF{");

			if (seqOf == null) {
				sb.append("null");
			}
			else {
				Iterator<BerOctetString> it = seqOf.iterator();
				if (it.hasNext()) {
					sb.append(it.next());
					while (it.hasNext()) {
						sb.append(", ").append(it.next());
					}
				}
			}

			sb.append("}");

			return sb.toString();
		}

	}

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public PEHeader akaHeader = null;

	public AlgoConfiguration algoConfiguration = null;

	public BerOctetString sqnOptions = null;

	public BerOctetString sqnDelta = null;

	public BerOctetString sqnAgeLimit = null;

	public SqnInit sqnInit = null;

	public PEAKAParameter() {
		id = identifier;
	}

	public PEAKAParameter(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PEAKAParameter(PEHeader akaHeader, AlgoConfiguration algoConfiguration, BerOctetString sqnOptions, BerOctetString sqnDelta, BerOctetString sqnAgeLimit, SqnInit sqnInit) {
		id = identifier;
		this.akaHeader = akaHeader;
		this.algoConfiguration = algoConfiguration;
		this.sqnOptions = sqnOptions;
		this.sqnDelta = sqnDelta;
		this.sqnAgeLimit = sqnAgeLimit;
		this.sqnInit = sqnInit;
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

			if (sqnInit != null) {
				codeLength += sqnInit.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
				os.write(0xa5);
				codeLength += 1;
			}
			
			if (sqnAgeLimit != null) {
				codeLength += sqnAgeLimit.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 4
				os.write(0x84);
				codeLength += 1;
			}
			
			if (sqnDelta != null) {
				codeLength += sqnDelta.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 3
				os.write(0x83);
				codeLength += 1;
			}
			
			if (sqnOptions != null) {
				codeLength += sqnOptions.encode(os, false);
				// write tag: CONTEXT_CLASS, PRIMITIVE, 2
				os.write(0x82);
				codeLength += 1;
			}
			
			sublength = algoConfiguration.encode(os, true);
			codeLength += sublength;
			codeLength += BerLength.encodeLength(os, sublength);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 1
			os.write(0xa1);
			codeLength += 1;
			
			codeLength += akaHeader.encode(os, false);
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
				akaHeader = new PEHeader();
				subCodeLength += akaHeader.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
				subCodeLength += length.decode(is);
				algoConfiguration = new AlgoConfiguration();
				int choiceDecodeLength = algoConfiguration.decode(is, null);
				if (choiceDecodeLength != 0) {
					subCodeLength += choiceDecodeLength;
					subCodeLength += berIdentifier.decode(is);
				}
				else {
					algoConfiguration = null;
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
				sqnOptions = new BerOctetString();
				subCodeLength += sqnOptions.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
				sqnDelta = new BerOctetString();
				subCodeLength += sqnDelta.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
				sqnAgeLimit = new BerOctetString();
				subCodeLength += sqnAgeLimit.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
				sqnInit = new SqnInit();
				subCodeLength += sqnInit.decode(is, false);
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
			akaHeader = new PEHeader();
			subCodeLength += akaHeader.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 1)) {
			subCodeLength += length.decode(is);
			algoConfiguration = new AlgoConfiguration();
			subCodeLength += algoConfiguration.decode(is, null);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match required sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 2)) {
			sqnOptions = new BerOctetString();
			subCodeLength += sqnOptions.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 3)) {
			sqnDelta = new BerOctetString();
			subCodeLength += sqnDelta.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 4)) {
			sqnAgeLimit = new BerOctetString();
			subCodeLength += sqnAgeLimit.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			sqnInit = new SqnInit();
			subCodeLength += sqnInit.decode(is, false);
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
		sb.append("akaHeader: ").append(akaHeader);
		
		sb.append(", ");
		sb.append("algoConfiguration: ").append(algoConfiguration);
		
		if (sqnOptions != null) {
			sb.append(", ");
			sb.append("sqnOptions: ").append(sqnOptions);
		}
		
		if (sqnDelta != null) {
			sb.append(", ");
			sb.append("sqnDelta: ").append(sqnDelta);
		}
		
		if (sqnAgeLimit != null) {
			sb.append(", ");
			sb.append("sqnAgeLimit: ").append(sqnAgeLimit);
		}
		
		if (sqnInit != null) {
			sb.append(", ");
			sb.append("sqnInit: ").append(sqnInit);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

