/**
 * This class file was automatically generated by jASN1 v1.5.1-SNAPSHOT (http://www.openmuc.org)
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


public class PECSIM {

	public static final BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS, BerIdentifier.CONSTRUCTED, 16);
	protected BerIdentifier id;

	public byte[] code = null;
	public PEHeader csimHeader = null;

	public BerObjectIdentifier templateID = null;

	public File adfCsim = null;

	public File efArr = null;

	public File efCallCount = null;

	public File efImsiM = null;

	public File efImsiT = null;

	public File efTmsi = null;

	public File efAh = null;

	public File efAop = null;

	public File efAloc = null;

	public File efCdmahome = null;

	public File efZnregi = null;

	public File efSnregi = null;

	public File efDistregi = null;

	public File efAccolc = null;

	public File efTerm = null;

	public File efAcp = null;

	public File efPrl = null;

	public File efRuimid = null;

	public File efCsimSt = null;

	public File efSpc = null;

	public File efOtapaspc = null;

	public File efNamlock = null;

	public File efOta = null;

	public File efSp = null;

	public File efEsnMeidMe = null;

	public File efLi = null;

	public File efUsgind = null;

	public File efAd = null;

	public File efMaxPrl = null;

	public File efSpcs = null;

	public File efMecrp = null;

	public File efHomeTag = null;

	public File efGroupTag = null;

	public File efSpecificTag = null;

	public File efCallPrompt = null;

	public PECSIM() {
		id = identifier;
	}

	public PECSIM(byte[] code) {
		id = identifier;
		this.code = code;
	}

	public PECSIM(PEHeader csimHeader, BerObjectIdentifier templateID, File adfCsim, File efArr, File efCallCount, File efImsiM, File efImsiT, File efTmsi, File efAh, File efAop, File efAloc, File efCdmahome, File efZnregi, File efSnregi, File efDistregi, File efAccolc, File efTerm, File efAcp, File efPrl, File efRuimid, File efCsimSt, File efSpc, File efOtapaspc, File efNamlock, File efOta, File efSp, File efEsnMeidMe, File efLi, File efUsgind, File efAd, File efMaxPrl, File efSpcs, File efMecrp, File efHomeTag, File efGroupTag, File efSpecificTag, File efCallPrompt) {
		id = identifier;
		this.csimHeader = csimHeader;
		this.templateID = templateID;
		this.adfCsim = adfCsim;
		this.efArr = efArr;
		this.efCallCount = efCallCount;
		this.efImsiM = efImsiM;
		this.efImsiT = efImsiT;
		this.efTmsi = efTmsi;
		this.efAh = efAh;
		this.efAop = efAop;
		this.efAloc = efAloc;
		this.efCdmahome = efCdmahome;
		this.efZnregi = efZnregi;
		this.efSnregi = efSnregi;
		this.efDistregi = efDistregi;
		this.efAccolc = efAccolc;
		this.efTerm = efTerm;
		this.efAcp = efAcp;
		this.efPrl = efPrl;
		this.efRuimid = efRuimid;
		this.efCsimSt = efCsimSt;
		this.efSpc = efSpc;
		this.efOtapaspc = efOtapaspc;
		this.efNamlock = efNamlock;
		this.efOta = efOta;
		this.efSp = efSp;
		this.efEsnMeidMe = efEsnMeidMe;
		this.efLi = efLi;
		this.efUsgind = efUsgind;
		this.efAd = efAd;
		this.efMaxPrl = efMaxPrl;
		this.efSpcs = efSpcs;
		this.efMecrp = efMecrp;
		this.efHomeTag = efHomeTag;
		this.efGroupTag = efGroupTag;
		this.efSpecificTag = efSpecificTag;
		this.efCallPrompt = efCallPrompt;
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
			codeLength += efCallPrompt.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 36
			os.write(0x24);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += efSpecificTag.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 35
			os.write(0x23);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += efGroupTag.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 34
			os.write(0x22);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += efHomeTag.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 33
			os.write(0x21);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += efMecrp.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 32
			os.write(0x20);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += efSpcs.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 31
			os.write(0x1f);
			os.write(0xbf);
			codeLength += 2;
			
			codeLength += efMaxPrl.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 30
			os.write(0xbe);
			codeLength += 1;
			
			codeLength += efAd.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 29
			os.write(0xbd);
			codeLength += 1;
			
			codeLength += efUsgind.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 28
			os.write(0xbc);
			codeLength += 1;
			
			codeLength += efLi.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 27
			os.write(0xbb);
			codeLength += 1;
			
			codeLength += efEsnMeidMe.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 26
			os.write(0xba);
			codeLength += 1;
			
			codeLength += efSp.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 25
			os.write(0xb9);
			codeLength += 1;
			
			codeLength += efOta.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 24
			os.write(0xb8);
			codeLength += 1;
			
			codeLength += efNamlock.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 23
			os.write(0xb7);
			codeLength += 1;
			
			codeLength += efOtapaspc.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 22
			os.write(0xb6);
			codeLength += 1;
			
			codeLength += efSpc.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 21
			os.write(0xb5);
			codeLength += 1;
			
			codeLength += efCsimSt.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 20
			os.write(0xb4);
			codeLength += 1;
			
			codeLength += efRuimid.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 19
			os.write(0xb3);
			codeLength += 1;
			
			codeLength += efPrl.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 18
			os.write(0xb2);
			codeLength += 1;
			
			codeLength += efAcp.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 17
			os.write(0xb1);
			codeLength += 1;
			
			codeLength += efTerm.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 16
			os.write(0xb0);
			codeLength += 1;
			
			codeLength += efAccolc.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 15
			os.write(0xaf);
			codeLength += 1;
			
			codeLength += efDistregi.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 14
			os.write(0xae);
			codeLength += 1;
			
			codeLength += efSnregi.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 13
			os.write(0xad);
			codeLength += 1;
			
			codeLength += efZnregi.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 12
			os.write(0xac);
			codeLength += 1;
			
			codeLength += efCdmahome.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 11
			os.write(0xab);
			codeLength += 1;
			
			codeLength += efAloc.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 10
			os.write(0xaa);
			codeLength += 1;
			
			codeLength += efAop.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 9
			os.write(0xa9);
			codeLength += 1;
			
			codeLength += efAh.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 8
			os.write(0xa8);
			codeLength += 1;
			
			codeLength += efTmsi.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 7
			os.write(0xa7);
			codeLength += 1;
			
			codeLength += efImsiT.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 6
			os.write(0xa6);
			codeLength += 1;
			
			codeLength += efImsiM.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 5
			os.write(0xa5);
			codeLength += 1;
			
			codeLength += efCallCount.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 4
			os.write(0xa4);
			codeLength += 1;
			
			codeLength += efArr.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 3
			os.write(0xa3);
			codeLength += 1;
			
			codeLength += adfCsim.encode(os, false);
			// write tag: CONTEXT_CLASS, CONSTRUCTED, 2
			os.write(0xa2);
			codeLength += 1;
			
			codeLength += templateID.encode(os, false);
			// write tag: CONTEXT_CLASS, PRIMITIVE, 1
			os.write(0x81);
			codeLength += 1;
			
			codeLength += csimHeader.encode(os, false);
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

		subCodeLength += berIdentifier.decode(is);
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 0)) {
			csimHeader = new PEHeader();
			subCodeLength += csimHeader.decode(is, false);
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
			adfCsim = new File();
			subCodeLength += adfCsim.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 3)) {
			efArr = new File();
			subCodeLength += efArr.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 4)) {
			efCallCount = new File();
			subCodeLength += efCallCount.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 5)) {
			efImsiM = new File();
			subCodeLength += efImsiM.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 6)) {
			efImsiT = new File();
			subCodeLength += efImsiT.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 7)) {
			efTmsi = new File();
			subCodeLength += efTmsi.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 8)) {
			efAh = new File();
			subCodeLength += efAh.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 9)) {
			efAop = new File();
			subCodeLength += efAop.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 10)) {
			efAloc = new File();
			subCodeLength += efAloc.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 11)) {
			efCdmahome = new File();
			subCodeLength += efCdmahome.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 12)) {
			efZnregi = new File();
			subCodeLength += efZnregi.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 13)) {
			efSnregi = new File();
			subCodeLength += efSnregi.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 14)) {
			efDistregi = new File();
			subCodeLength += efDistregi.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 15)) {
			efAccolc = new File();
			subCodeLength += efAccolc.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 16)) {
			efTerm = new File();
			subCodeLength += efTerm.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 17)) {
			efAcp = new File();
			subCodeLength += efAcp.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 18)) {
			efPrl = new File();
			subCodeLength += efPrl.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 19)) {
			efRuimid = new File();
			subCodeLength += efRuimid.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 20)) {
			efCsimSt = new File();
			subCodeLength += efCsimSt.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 21)) {
			efSpc = new File();
			subCodeLength += efSpc.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 22)) {
			efOtapaspc = new File();
			subCodeLength += efOtapaspc.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 23)) {
			efNamlock = new File();
			subCodeLength += efNamlock.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 24)) {
			efOta = new File();
			subCodeLength += efOta.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 25)) {
			efSp = new File();
			subCodeLength += efSp.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 26)) {
			efEsnMeidMe = new File();
			subCodeLength += efEsnMeidMe.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 27)) {
			efLi = new File();
			subCodeLength += efLi.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 28)) {
			efUsgind = new File();
			subCodeLength += efUsgind.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 29)) {
			efAd = new File();
			subCodeLength += efAd.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 30)) {
			efMaxPrl = new File();
			subCodeLength += efMaxPrl.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 31)) {
			efSpcs = new File();
			subCodeLength += efSpcs.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 32)) {
			efMecrp = new File();
			subCodeLength += efMecrp.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 33)) {
			efHomeTag = new File();
			subCodeLength += efHomeTag.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 34)) {
			efGroupTag = new File();
			subCodeLength += efGroupTag.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 35)) {
			efSpecificTag = new File();
			subCodeLength += efSpecificTag.decode(is, false);
			subCodeLength += berIdentifier.decode(is);
		}
		else {
			throw new IOException("Identifier does not match the mandatory sequence element identifer.");
		}
		
		if (berIdentifier.equals(BerIdentifier.CONTEXT_CLASS, BerIdentifier.CONSTRUCTED, 36)) {
			efCallPrompt = new File();
			subCodeLength += efCallPrompt.decode(is, false);
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
		sb.append("csimHeader: ").append(csimHeader);
		
		sb.append(", ");
		sb.append("templateID: ").append(templateID);
		
		sb.append(", ");
		sb.append("adfCsim: ").append(adfCsim);
		
		sb.append(", ");
		sb.append("efArr: ").append(efArr);
		
		sb.append(", ");
		sb.append("efCallCount: ").append(efCallCount);
		
		sb.append(", ");
		sb.append("efImsiM: ").append(efImsiM);
		
		sb.append(", ");
		sb.append("efImsiT: ").append(efImsiT);
		
		sb.append(", ");
		sb.append("efTmsi: ").append(efTmsi);
		
		sb.append(", ");
		sb.append("efAh: ").append(efAh);
		
		sb.append(", ");
		sb.append("efAop: ").append(efAop);
		
		sb.append(", ");
		sb.append("efAloc: ").append(efAloc);
		
		sb.append(", ");
		sb.append("efCdmahome: ").append(efCdmahome);
		
		sb.append(", ");
		sb.append("efZnregi: ").append(efZnregi);
		
		sb.append(", ");
		sb.append("efSnregi: ").append(efSnregi);
		
		sb.append(", ");
		sb.append("efDistregi: ").append(efDistregi);
		
		sb.append(", ");
		sb.append("efAccolc: ").append(efAccolc);
		
		sb.append(", ");
		sb.append("efTerm: ").append(efTerm);
		
		sb.append(", ");
		sb.append("efAcp: ").append(efAcp);
		
		sb.append(", ");
		sb.append("efPrl: ").append(efPrl);
		
		sb.append(", ");
		sb.append("efRuimid: ").append(efRuimid);
		
		sb.append(", ");
		sb.append("efCsimSt: ").append(efCsimSt);
		
		sb.append(", ");
		sb.append("efSpc: ").append(efSpc);
		
		sb.append(", ");
		sb.append("efOtapaspc: ").append(efOtapaspc);
		
		sb.append(", ");
		sb.append("efNamlock: ").append(efNamlock);
		
		sb.append(", ");
		sb.append("efOta: ").append(efOta);
		
		sb.append(", ");
		sb.append("efSp: ").append(efSp);
		
		sb.append(", ");
		sb.append("efEsnMeidMe: ").append(efEsnMeidMe);
		
		sb.append(", ");
		sb.append("efLi: ").append(efLi);
		
		sb.append(", ");
		sb.append("efUsgind: ").append(efUsgind);
		
		sb.append(", ");
		sb.append("efAd: ").append(efAd);
		
		sb.append(", ");
		sb.append("efMaxPrl: ").append(efMaxPrl);
		
		sb.append(", ");
		sb.append("efSpcs: ").append(efSpcs);
		
		sb.append(", ");
		sb.append("efMecrp: ").append(efMecrp);
		
		sb.append(", ");
		sb.append("efHomeTag: ").append(efHomeTag);
		
		sb.append(", ");
		sb.append("efGroupTag: ").append(efGroupTag);
		
		sb.append(", ");
		sb.append("efSpecificTag: ").append(efSpecificTag);
		
		sb.append(", ");
		sb.append("efCallPrompt: ").append(efCallPrompt);
		
		sb.append("}");
		return sb.toString();
	}

}

