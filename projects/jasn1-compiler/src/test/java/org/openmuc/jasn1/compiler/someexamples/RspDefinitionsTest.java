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
package org.openmuc.jasn1.compiler.someexamples;

import org.junit.Assert;
import org.junit.Test;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.compiler.Compiler;
import org.openmuc.jasn1.compiler.automatictagging.generated.pedefinitions.ProfileElement;

import javax.xml.bind.DatatypeConverter;
import java.io.ByteArrayInputStream;

/**
 * Test for module from SGP.22 - RSP Technical Specification, V2.0.
 */
public class RspDefinitionsTest {

    @Test
    public void compiling() throws Exception {
        String[] args = new String[]{"-o", "src/test/java-gen/org/openmuc/jasn1/compiler/rspdefinitions/generated",
                "-p", "org.openmuc.jasn1.compiler.rspdefinitions.generated",
                "src/test/resources/RSPDefinitions V2.0.asn", "src/test/resources/PKIXImplicit88.asn", "src/test/resources/PKIXExplicit88.asn"};
        Compiler.main(args);
    }

    @Test
    public void decodeEncodeTest() throws Exception {

        String expected = "A1 820237 A0 05 80 00 81 01 01 A1 82022C 30 820228 62 10 82 02 7821 83 02 3F00 8B 01 0E C6 03 01020A 62 11 82 02 4121 83 02 2F05 8B 01 0F 80 01 03 88 01 28 62 0E 82 02 4121 83 02 2FE2 8B 01 0B 80 01 0A 81 0A 98109909002143658739 62 14 82 04 4221002683 02 2F00 8B 01 0A 80 02 0098 88 01 F0 81 1A 61184F10A0000000871002FF33FF01890000010050045553494D 62 11 82 04 42210025 83 02 2F06 8B 01 0A 80 02 01EF 81 1B 8001019000800102A406830101950108800158A40683010A950108 02 01 0A 81 16 800101A40683010195010880015AA40683010A950108 02 01 0F 81 0B 80015BA40683010A950108 02 01 1A 81 0A 800101900080015A9700 02 01 1B 81 16 800103A406830101950108800158A40683010A950108 02 01 0F 81 16 800111A40683010195010880014AA40683010A950108 02 01 0F 81 21 800103A406830101950108800158A40683010A950108840132A406830101950108 02 01 04 81 21 800101A406830101950108800102A406830181950108800158A40683010A950108 02 01 04 81 1B 800101900080011AA406830101950108800140A40683010A950108 02 01 0A 81 10 800101900080015AA40683010A950108 02 01 15 81 15 8001019000800118A40683010A9501088001429700 02 01 0E 81 10 800101A40683010195010880015A9700 02 01 15 81 16 800113A406830101950108800148A40683010A950108 02 01 0D 81 0B 80015EA40683010A950108 02 01 1A81 25 8001019000800102A010A406830101950108A406830102950108800158A40683010A950108 62 0E 82 02 4121 83 02 2F08 8B 01 0A 80 01 05"
                .replaceAll("\\s", "");

        byte[] code = DatatypeConverter.parseHexBinary(expected);

        ProfileElement rereadProfileElement = new ProfileElement();
        rereadProfileElement.decode(new ByteArrayInputStream(code), null);

        BerByteArrayOutputStream berByteArrayOutputStream2 = new BerByteArrayOutputStream(2048, true);
        rereadProfileElement.encode(berByteArrayOutputStream2, false);
        byte[] code2 = berByteArrayOutputStream2.getArray();
        Assert.assertArrayEquals(code, code2);

    }

}
