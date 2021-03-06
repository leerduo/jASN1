/*
 * Copyright 2011-15 Fraunhofer ISE
 *
 * This file is part of jASN1.
 * For more information visit http://www.openmuc.org
 *
 * jASN1 is free software: you can redistribute it and/or modify
 * it under the terms of the GNU Lesser General Public License as published by
 * the Free Software Foundation, either version 2.1 of the License, or
 * (at your option) any later version.
 *
 * jASN1 is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public License
 * along with jASN1.  If not, see <http://www.gnu.org/licenses/>.
 *
 */
package org.openmuc.jasn1.ber.types;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigInteger;

import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.BerIdentifier;
import org.openmuc.jasn1.ber.BerLength;

public class BerInteger {

    public final static BerIdentifier identifier = new BerIdentifier(BerIdentifier.UNIVERSAL_CLASS,
            BerIdentifier.PRIMITIVE, BerIdentifier.INTEGER_TAG);
    public BerIdentifier id;

    public byte[] code = null;

    public long value;

    public BigInteger fullValue;

    public BerInteger() {
        id = identifier;
    }

    public BerInteger(byte[] code) {
        id = identifier;
        this.code = code;
    }

    public BerInteger(long val) {
        id = identifier;
        this.fullValue = BigInteger.valueOf(val);
        this.value = val;
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

            codeLength = 1;

            byte[] encoded = fullValue.toByteArray();
            codeLength =encoded.length;
            os.write(encoded);

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

        if (length.val < 1) {
            throw new IOException("Decoded length of BerInteger is not correct");
        }

        byte[] byteCode = new byte[length.val];
        Util.readFully(is, byteCode);

        codeLength += length.val;

        fullValue = new BigInteger(byteCode);
        value = fullValue.longValue();

        return codeLength;
    }

    public void encodeAndSave(int encodingSizeGuess) throws IOException {
        BerByteArrayOutputStream os = new BerByteArrayOutputStream(encodingSizeGuess);
        encode(os, false);
        code = os.getArray();
    }

    @Override
    public String toString() {
        return "" + value;
    }
}
