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


public class PEUSIM {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public PEHeader usimHeader = null;

	public BerObjectIdentifier templateID = null;

	public File adfUsim = null;

	public File efImsi = null;

	public File efArr = null;

	public File efKeys = null;

	public File efKeysPS = null;

	public File efHpplmn = null;

	public File efUst = null;

	public File efFdn = null;

	public File efSms = null;

	public File efSmsp = null;

	public File efSmss = null;

	public File efSpn = null;

	public File efEst = null;

	public File efStartHfn = null;

	public File efThreshold = null;

	public File efPsloci = null;

	public File efAcc = null;

	public File efFplmn = null;

	public File efLoci = null;

	public File efAd = null;

	public File efEcc = null;

	public File efNetpar = null;

	public File efEpsloci = null;

	public File efEpsnsc = null;

	public PEUSIM() {
		id = identifier;
	}

	public PEUSIM(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PEUSIM(PEHeader usimHeader, BerObjectIdentifier templateID, File adfUsim, File efImsi, File efArr, File efKeys, File efKeysPS, File efHpplmn, File efUst, File efFdn, File efSms, File efSmsp, File efSmss, File efSpn, File efEst, File efStartHfn, File efThreshold, File efPsloci, File efAcc, File efFplmn, File efLoci, File efAd, File efEcc, File efNetpar, File efEpsloci, File efEpsnsc) {
		id = identifier;
		this.usimHeader = usimHeader;
		this.templateID = templateID;
		this.adfUsim = adfUsim;
		this.efImsi = efImsi;
		this.efArr = efArr;
		this.efKeys = efKeys;
		this.efKeysPS = efKeysPS;
		this.efHpplmn = efHpplmn;
		this.efUst = efUst;
		this.efFdn = efFdn;
		this.efSms = efSms;
		this.efSmsp = efSmsp;
		this.efSmss = efSmss;
		this.efSpn = efSpn;
		this.efEst = efEst;
		this.efStartHfn = efStartHfn;
		this.efThreshold = efThreshold;
		this.efPsloci = efPsloci;
		this.efAcc = efAcc;
		this.efFplmn = efFplmn;
		this.efLoci = efLoci;
		this.efAd = efAd;
		this.efEcc = efEcc;
		this.efNetpar = efNetpar;
		this.efEpsloci = efEpsloci;
		this.efEpsnsc = efEpsnsc;
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
			if (efEpsnsc != null) {
				codeLength += efEpsnsc.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 25
				os.write(0xb9);
				codeLength += 1;
			}
			
			if (efEpsloci != null) {
				codeLength += efEpsloci.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 24
				os.write(0xb8);
				codeLength += 1;
			}
			
			if (efNetpar != null) {
				codeLength += efNetpar.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 23
				os.write(0xb7);
				codeLength += 1;
			}
			
			codeLength += efEcc.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 22
			os.write(0xb6);
			codeLength += 1;
			
			if (efAd != null) {
				codeLength += efAd.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 21
				os.write(0xb5);
				codeLength += 1;
			}
			
			if (efLoci != null) {
				codeLength += efLoci.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 20
				os.write(0xb4);
				codeLength += 1;
			}
			
			if (efFplmn != null) {
				codeLength += efFplmn.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 19
				os.write(0xb3);
				codeLength += 1;
			}
			
			codeLength += efAcc.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 18
			os.write(0xb2);
			codeLength += 1;
			
			if (efPsloci != null) {
				codeLength += efPsloci.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 17
				os.write(0xb1);
				codeLength += 1;
			}
			
			if (efThreshold != null) {
				codeLength += efThreshold.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 16
				os.write(0xb0);
				codeLength += 1;
			}
			
			if (efStartHfn != null) {
				codeLength += efStartHfn.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 15
				os.write(0xaf);
				codeLength += 1;
			}
			
			codeLength += efEst.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 14
			os.write(0xae);
			codeLength += 1;
			
			codeLength += efSpn.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 13
			os.write(0xad);
			codeLength += 1;
			
			if (efSmss != null) {
				codeLength += efSmss.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 12
				os.write(0xac);
				codeLength += 1;
			}
			
			if (efSmsp != null) {
				codeLength += efSmsp.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 11
				os.write(0xab);
				codeLength += 1;
			}
			
			if (efSms != null) {
				codeLength += efSms.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 10
				os.write(0xaa);
				codeLength += 1;
			}
			
			if (efFdn != null) {
				codeLength += efFdn.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 9
				os.write(0xa9);
				codeLength += 1;
			}
			
			codeLength += efUst.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 8
			os.write(0xa8);
			codeLength += 1;
			
			if (efHpplmn != null) {
				codeLength += efHpplmn.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 7
				os.write(0xa7);
				codeLength += 1;
			}
			
			if (efKeysPS != null) {
				codeLength += efKeysPS.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
				os.write(0xa6);
				codeLength += 1;
			}
			
			if (efKeys != null) {
				codeLength += efKeys.encode(os, false);
				// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
				os.write(0xa5);
				codeLength += 1;
			}
			
			codeLength += efArr.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
			os.write(0xa4);
			codeLength += 1;
			
			codeLength += efImsi.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			os.write(0xa3);
			codeLength += 1;
			
			codeLength += adfUsim.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
			os.write(0xa2);
			codeLength += 1;
			
			codeLength += templateID.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			
			codeLength += usimHeader.encode(os, false);
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
				usimHeader = new PEHeader();
				subCodeLength += usimHeader.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
				templateID = new BerObjectIdentifier();
				subCodeLength += templateID.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
				adfUsim = new File();
				subCodeLength += adfUsim.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
				efImsi = new File();
				subCodeLength += efImsi.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
				efArr = new File();
				subCodeLength += efArr.decode(is, false);
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
				efKeys = new File();
				subCodeLength += efKeys.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
				efKeysPS = new File();
				subCodeLength += efKeysPS.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
				efHpplmn = new File();
				subCodeLength += efHpplmn.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
				efUst = new File();
				subCodeLength += efUst.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)) {
				efFdn = new File();
				subCodeLength += efFdn.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
				efSms = new File();
				subCodeLength += efSms.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11)) {
				efSmsp = new File();
				subCodeLength += efSmsp.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 12)) {
				efSmss = new File();
				subCodeLength += efSmss.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 13)) {
				efSpn = new File();
				subCodeLength += efSpn.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 14)) {
				efEst = new File();
				subCodeLength += efEst.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 15)) {
				efStartHfn = new File();
				subCodeLength += efStartHfn.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 16)) {
				efThreshold = new File();
				subCodeLength += efThreshold.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 17)) {
				efPsloci = new File();
				subCodeLength += efPsloci.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 18)) {
				efAcc = new File();
				subCodeLength += efAcc.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 19)) {
				efFplmn = new File();
				subCodeLength += efFplmn.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 20)) {
				efLoci = new File();
				subCodeLength += efLoci.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 21)) {
				efAd = new File();
				subCodeLength += efAd.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 22)) {
				efEcc = new File();
				subCodeLength += efEcc.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 23)) {
				efNetpar = new File();
				subCodeLength += efNetpar.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 24)) {
				efEpsloci = new File();
				subCodeLength += efEpsloci.decode(is, false);
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
			if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 25)) {
				efEpsnsc = new File();
				subCodeLength += efEpsnsc.decode(is, false);
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
			usimHeader = new PEHeader();
			subCodeLength += usimHeader.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.PRIMITIVE, 1)) {
			templateID = new BerObjectIdentifier();
			subCodeLength += templateID.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 2)) {
			adfUsim = new File();
			subCodeLength += adfUsim.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			efImsi = new File();
			subCodeLength += efImsi.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
			efArr = new File();
			subCodeLength += efArr.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			efKeys = new File();
			subCodeLength += efKeys.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
			efKeysPS = new File();
			subCodeLength += efKeysPS.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
			efHpplmn = new File();
			subCodeLength += efHpplmn.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
			efUst = new File();
			subCodeLength += efUst.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)) {
			efFdn = new File();
			subCodeLength += efFdn.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			efSms = new File();
			subCodeLength += efSms.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11)) {
			efSmsp = new File();
			subCodeLength += efSmsp.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 12)) {
			efSmss = new File();
			subCodeLength += efSmss.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 13)) {
			efSpn = new File();
			subCodeLength += efSpn.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 14)) {
			efEst = new File();
			subCodeLength += efEst.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 15)) {
			efStartHfn = new File();
			subCodeLength += efStartHfn.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 16)) {
			efThreshold = new File();
			subCodeLength += efThreshold.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 17)) {
			efPsloci = new File();
			subCodeLength += efPsloci.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 18)) {
			efAcc = new File();
			subCodeLength += efAcc.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 19)) {
			efFplmn = new File();
			subCodeLength += efFplmn.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 20)) {
			efLoci = new File();
			subCodeLength += efLoci.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 21)) {
			efAd = new File();
			subCodeLength += efAd.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 22)) {
			efEcc = new File();
			subCodeLength += efEcc.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 23)) {
			efNetpar = new File();
			subCodeLength += efNetpar.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 24)) {
			efEpsloci = new File();
			subCodeLength += efEpsloci.decode(is, false);
			if (subCodeLength == totalLength) {
				return codeLength;
			}
			subCodeLength += berIdentifier.decode(is);
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 25)) {
			efEpsnsc = new File();
			subCodeLength += efEpsnsc.decode(is, false);
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
		sb.append("usimHeader: ").append(usimHeader);
		
		sb.append(", ");
		sb.append("templateID: ").append(templateID);
		
		sb.append(", ");
		sb.append("adfUsim: ").append(adfUsim);
		
		sb.append(", ");
		sb.append("efImsi: ").append(efImsi);
		
		sb.append(", ");
		sb.append("efArr: ").append(efArr);
		
		if (efKeys != null) {
			sb.append(", ");
			sb.append("efKeys: ").append(efKeys);
		}
		
		if (efKeysPS != null) {
			sb.append(", ");
			sb.append("efKeysPS: ").append(efKeysPS);
		}
		
		if (efHpplmn != null) {
			sb.append(", ");
			sb.append("efHpplmn: ").append(efHpplmn);
		}
		
		sb.append(", ");
		sb.append("efUst: ").append(efUst);
		
		if (efFdn != null) {
			sb.append(", ");
			sb.append("efFdn: ").append(efFdn);
		}
		
		if (efSms != null) {
			sb.append(", ");
			sb.append("efSms: ").append(efSms);
		}
		
		if (efSmsp != null) {
			sb.append(", ");
			sb.append("efSmsp: ").append(efSmsp);
		}
		
		if (efSmss != null) {
			sb.append(", ");
			sb.append("efSmss: ").append(efSmss);
		}
		
		sb.append(", ");
		sb.append("efSpn: ").append(efSpn);
		
		sb.append(", ");
		sb.append("efEst: ").append(efEst);
		
		if (efStartHfn != null) {
			sb.append(", ");
			sb.append("efStartHfn: ").append(efStartHfn);
		}
		
		if (efThreshold != null) {
			sb.append(", ");
			sb.append("efThreshold: ").append(efThreshold);
		}
		
		if (efPsloci != null) {
			sb.append(", ");
			sb.append("efPsloci: ").append(efPsloci);
		}
		
		sb.append(", ");
		sb.append("efAcc: ").append(efAcc);
		
		if (efFplmn != null) {
			sb.append(", ");
			sb.append("efFplmn: ").append(efFplmn);
		}
		
		if (efLoci != null) {
			sb.append(", ");
			sb.append("efLoci: ").append(efLoci);
		}
		
		if (efAd != null) {
			sb.append(", ");
			sb.append("efAd: ").append(efAd);
		}
		
		sb.append(", ");
		sb.append("efEcc: ").append(efEcc);
		
		if (efNetpar != null) {
			sb.append(", ");
			sb.append("efNetpar: ").append(efNetpar);
		}
		
		if (efEpsloci != null) {
			sb.append(", ");
			sb.append("efEpsloci: ").append(efEpsloci);
		}
		
		if (efEpsnsc != null) {
			sb.append(", ");
			sb.append("efEpsnsc: ").append(efEpsnsc);
		}
		
		sb.append("}");
		return sb.toString();
	}

}

