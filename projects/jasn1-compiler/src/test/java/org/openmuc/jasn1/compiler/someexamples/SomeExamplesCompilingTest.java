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

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.example.compiler.sequenceOfOptionals.generated.pedefinitions.ServicesList;
import org.example.compiler.simalliance.generated.pedefinitions.*;
import org.junit.Ignore;
import org.junit.Test;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.types.BerNull;
import org.openmuc.jasn1.ber.types.BerOctetString;
import org.openmuc.jasn1.compiler.Compiler;

import java.io.ByteArrayInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static junit.framework.TestCase.assertEquals;

public class SomeExamplesCompilingTest {

    @Test
    @Ignore
    public void compiling() throws Exception {

        String[] args = new String[]{"-o", "src/test/java-gen/org/openmuc/jasn1/compiler/someexamples/generated",
                "-p", "org.openmuc.jasn1.compiler.someexamples.generated", "-il",
                "src/test/resources/someExamples.asn"};
        Compiler.main(args);

    }

    @Test
    public void compilingSequenceOfOptionals() throws Exception {

        String[] args = new String[]{"-o", "src/test/java-gen/org/example/compiler/sequenceOfOptionals/generated",
                "-p", "org.example.compiler.sequenceOfOptionals.generated", "-il",
                "src/test/resources/sequenceOfOptionals.asn"};
        Compiler.main(args);

        ServicesList servicesList = new ServicesList();

        servicesList.usim = new BerNull();
        servicesList.milenage = new BerNull();
        servicesList.javacard = new BerNull();

        BerByteArrayOutputStream berByteArrayOutputStream = new BerByteArrayOutputStream(2048, true);
        servicesList.encode(berByteArrayOutputStream, true);
        byte[] code = berByteArrayOutputStream.getArray();
        ServicesList reread = new ServicesList();
        reread.decode(new ByteArrayInputStream(code), true);
        BerByteArrayOutputStream berByteArrayOutputStream2 = new BerByteArrayOutputStream(2048, true);
        reread.encode(berByteArrayOutputStream2, true);
        byte[] code2 = berByteArrayOutputStream2.getArray();
        assertEquals(Hex.encodeHexString(code), Hex.encodeHexString(code2));

        String expected = "A0 06 81 00 84 00 8B 00 ".replaceAll("\\s", "");
        assertEquals(expected, Hex.encodeHexString(code).toUpperCase());
    }

//    @Test
//    public void compilingProfileElementHeader() throws Exception {
//
//        String[] args = new String[]{"-o", "src/test/java-gen/org/example/compiler/simalliance/generated",
//                "-p", "org.example.compiler.simalliance.generated", "-il",
//                "src/test/resources/PEDefinitions V2.0.asn"};
//        Compiler.main(args);
//        // taken from Annex C
//        ProfileElement headerProfileElement = new ProfileElement();
//
//        org.example.compiler.simalliance.generated.pedefinitions.ServicesList servicesList = new org.example.compiler.simalliance.generated.pedefinitions.ServicesList();
//        ProfileHeader.SubSeqOf_eUICC_Mandatory_GFSTEList GFSTEList = new ProfileHeader.SubSeqOf_eUICC_Mandatory_GFSTEList();
//        GFSTEList.seqOf = Arrays.asList(
//                new BerObjectIdentifier(new int[]{2, 23, 143, 1, 2, 1}),
//                new BerObjectIdentifier(new int[]{2, 23, 143, 1, 2, 4}));
//
//        servicesList.usim = new BerNull();
//        servicesList.milenage = new BerNull();
//        servicesList.javacard = new BerNull();
//        headerProfileElement.header = new ProfileHeader(new UInt8(2), new UInt8(0),
//                new BerUTF8String("SIMalliance Sample Profile"),
//                new BerOctetString(Hex.decodeHex("89019990001234567893".toCharArray())),
//                null,
//                servicesList, GFSTEList, null);
//
//        BerByteArrayOutputStream berByteArrayOutputStream = new BerByteArrayOutputStream(2048, true);
//        headerProfileElement.encode(berByteArrayOutputStream, false);
//        byte[] code = berByteArrayOutputStream.getArray();
//        ProfileElement rereadProfileElement = new ProfileElement();
//        rereadProfileElement.decode(new ByteArrayInputStream(code), null);
//        BerByteArrayOutputStream berByteArrayOutputStream2 = new BerByteArrayOutputStream(2048, true);
//        rereadProfileElement.encode(berByteArrayOutputStream2, false);
//        byte[] code2 = berByteArrayOutputStream2.getArray();
//        assertEquals(Hex.encodeHexString(code), Hex.encodeHexString(code2));
//
//        String expected = "A0 48 80 01 02 81 01 00 82 1A 53494D616C6C69616E63652053616D706C652050726F66696C65 83 0A 89019990001234567893 A5 06 81 00 84 00 8B 00 A6 10 06 06 67810F010201 06 06 67810F010204".replaceAll("\\s", "");
//        assertEquals(expected, Hex.encodeHexString(code).toUpperCase());
//    }

    @Test
    public void compilingProfileElementFileManagement() throws Exception {

        String[] args = new String[]{"-o", "src/test/java-gen/org/example/compiler/simalliance/generated",
                "-p", "org.example.compiler.simalliance.generated", "-il",
                "src/test/resources/PEDefinitions V2.0.asn"};
        Compiler.main(args);
        ProfileElement genericFileManagementProfileElement = new ProfileElement();
        genericFileManagementProfileElement.genericFileManagement = new PE_GenericFileManagement(
                new PEHeader(new BerNull(), new UInt15(1)),
                new PE_GenericFileManagement.SubSeqOf_fileManagementCMD(
                        Arrays.asList(
                                createDf((short) 0x3f00, "7821", (byte) 0x0e, "01020A"),
                                createEf((short) 0x2f05, "4121", (byte) 0x0F, (short) 3, (short) 0x28),
                                createEf((short) 0x2fe2, "4121", (byte) 0x0B, (short) 0x0A, null, "98109909002143658739", null),
                                createEf((short) 0x2f00, "42210026", (byte) 0x0A, (short) 0x98, (short) 0xF0, "61184F10A0000000871002FF33FF01890000010050045553494D", null),
                                createEf((short) 0x2f06, "42210025", (byte) 0x0A, (short) 0x01EF, null, Arrays.asList(
                                        new FileRecordContent(null, "8001019000800102A406830101950108800158A40683010A950108"),
                                        new FileRecordContent(10, "800101A40683010195010880015AA40683010A950108"),
                                        new FileRecordContent(15, "80015BA40683010A950108"),
                                        new FileRecordContent(26, "800101900080015A9700"),
                                        new FileRecordContent(27, "800103A406830101950108800158A40683010A950108"),
                                        new FileRecordContent(15, "800111A40683010195010880014AA40683010A950108"),
                                        new FileRecordContent(15, "800103A406830101950108800158A40683010A950108840132A406830101950108"),
                                        new FileRecordContent(4, "800101A406830101950108800102A406830181950108800158A40683010A950108"),
                                        new FileRecordContent(4, "800101900080011AA406830101950108800140A40683010A950108"),
                                        new FileRecordContent(10, "800101900080015AA40683010A950108"),
                                        new FileRecordContent(21, "8001019000800118A40683010A9501088001429700"),
                                        new FileRecordContent(14, "800101A40683010195010880015A9700"),
                                        new FileRecordContent(21, "800113A406830101950108800148A40683010A950108"),
                                        new FileRecordContent(13, "80015EA40683010A950108"),
                                        new FileRecordContent(26, "8001019000800102A010A406830101950108A406830102950108800158A40683010A950108"))),
                                createEf((short) 0x2f08, "4121", (byte) 0x0A, (short) 5)
                        )


                ));
        BerByteArrayOutputStream berByteArrayOutputStream = new BerByteArrayOutputStream(2048, true);
        genericFileManagementProfileElement.encode(berByteArrayOutputStream, false);
        byte[] code = berByteArrayOutputStream.getArray();
        System.out.println(Hex.encodeHexString(code));
        ProfileElement rereadProfileElement = new ProfileElement();
        rereadProfileElement.decode(new ByteArrayInputStream(code), null);
        BerByteArrayOutputStream berByteArrayOutputStream2 = new BerByteArrayOutputStream(2048, true);
        rereadProfileElement.encode(berByteArrayOutputStream2, false);
        byte[] code2 = berByteArrayOutputStream2.getArray();
        assertEquals(Hex.encodeHexString(code), Hex.encodeHexString(code2));

        String expected = "A1 820237 A0 05 80 00 81 01 01 A1 82022C 30 820228 62 10 82 02 7821 83 02 3F00 8B 01 0E C6 03 01020A 62 11 82 02 4121 83 02 2F05 8B 01 0F 80 01 03 88 01 28 62 0E 82 02 4121 83 02 2FE2 8B 01 0B 80 01 0A 81 0A 98109909002143658739 62 14 82 04 4221002683 02 2F00 8B 01 0A 80 02 0098 88 01 F0 81 1A 61184F10A0000000871002FF33FF01890000010050045553494D 62 11 82 04 42210025 83 02 2F06 8B 01 0A 80 02 01EF 81 1B 8001019000800102A406830101950108800158A40683010A950108 02 01 0A 81 16 800101A40683010195010880015AA40683010A950108 02 01 0F 81 0B 80015BA40683010A950108 02 01 1A 81 0A 800101900080015A9700 02 01 1B 81 16 800103A406830101950108800158A40683010A950108 02 01 0F 81 16 800111A40683010195010880014AA40683010A950108 02 01 0F 81 21 800103A406830101950108800158A40683010A950108840132A406830101950108 02 01 04 81 21 800101A406830101950108800102A406830181950108800158A40683010A950108 02 01 04 81 1B 800101900080011AA406830101950108800140A40683010A950108 02 01 0A 81 10 800101900080015AA40683010A950108 02 01 15 81 15 8001019000800118A40683010A9501088001429700 02 01 0E 81 10 800101A40683010195010880015A9700 02 01 15 81 16 800113A406830101950108800148A40683010A950108 02 01 0D 81 0B 80015EA40683010A950108 02 01 1A81 25 8001019000800102A010A406830101950108A406830102950108800158A40683010A950108 62 0E 82 02 4121 83 02 2F08 8B 01 0A 80 01 05".replaceAll("\\s", "");
        assertEquals(expected, Hex.encodeHexString(code).toUpperCase());
    }

    private static class FileRecordContent {

        public Integer fillFileOffset;

        public String fillFileContent;

        public FileRecordContent(Integer fillFileOffset, String fillFileContent) {
            this.fillFileOffset = fillFileOffset;
            this.fillFileContent = fillFileContent;
        }
    }

    /**
     * Converts a unsigned short to a byte array.
     *
     * @param num The number.
     * @return byte array of length 2.
     */
    public static byte[] unsignedShortToByteArray(int num) {
        byte hiByte = (byte) ((num & 0xFF00) >> 8);
        byte loByte = (byte) (num - (hiByte << 8));
        return new byte[]{hiByte, loByte};
    }

    private static FileManagement createEf(short fileId, String fileDescriptor, byte arrReference, Short efFileSize) {
        return createEf(fileId, fileDescriptor, arrReference, efFileSize, null, null, null, null);
    }

    private static FileManagement createEf(short fileId, String fileDescriptor, byte arrReference, Short efFileSize,
                                           Short shortEfId) {
        return createEf(fileId, fileDescriptor, arrReference, efFileSize, shortEfId, null, null, null);
    }

    private static FileManagement createEf(short fileId, String fileDescriptor, byte arrReference, Short efFileSize,
                                           Short shortEfId, String fillFileContent, Integer fillFileOffset) {
        return createEf(fileId, fileDescriptor, arrReference, efFileSize, shortEfId, null, fillFileContent, fillFileOffset);
    }

    private static FileManagement createEf(short fileId, String fileDescriptor, byte arrReference, Short efFileSize,
                                           Short shortEfId, String linkPath, String fillFileContent, Integer fillFileOffset) {
        try {
            return new FileManagement(Arrays.asList(new FileManagement.SubChoice(null,
                    createFcp(fileId, fileDescriptor, arrReference, efFileSize, null, shortEfId, linkPath),
                    fillFileOffset != null ? new UInt16(fillFileOffset) : null,
                    fillFileContent != null ? new BerOctetString(Hex.decodeHex(fillFileContent.toCharArray())) : null)));
        } catch (DecoderException e) {
            throw new RuntimeException("Could not decode file content.", e);
        }
    }

    private static FileManagement createEf(short fileId, String fileDescriptor, byte arrReference, Short efFileSize,
                                           Short shortEfId, List<FileRecordContent> fillFileRecordContents) {
        FileManagement fileManagement = createEf(fileId, fileDescriptor, arrReference, efFileSize, shortEfId);
        fileManagement.seqOf = new ArrayList<>(fileManagement.seqOf);
        if (fillFileRecordContents != null) {
            fillFileRecordContents.stream().forEach(rfc -> {
                try {
                    fileManagement.seqOf.add(new FileManagement.SubChoice(null, null,
                            rfc.fillFileOffset != null ? new UInt16(rfc.fillFileOffset) : null,
                            new BerOctetString(Hex.decodeHex(rfc.fillFileContent.toCharArray()))));
                } catch (DecoderException e) {
                    throw new RuntimeException("Could not decode file record content.", e);
                }
            });
        }
        return fileManagement;
    }

    private static FileManagement createDf(short fileId, String fileDescriptor, byte arrReference, String pinStatusTemplateDo) {
        return new FileManagement(Arrays.asList(new FileManagement.SubChoice(null,
                createFcp(fileId, fileDescriptor, arrReference, null, pinStatusTemplateDo, null, null),
                null,
                null)));
    }

    private static Fcp createFcp(short fileId, String fileDescriptor, byte arrReference, Short efFileSize, String pinStatusTemplateDo,
                                 Short shortEfId, String linkPath) {
        try {
            return new Fcp(new BerOctetString(Hex.decodeHex(fileDescriptor.toCharArray())),
                    new BerOctetString(unsignedShortToByteArray(fileId)),
                    null, null, new BerOctetString(new byte[]{arrReference}),
                    efFileSize != null ? new BerOctetString(unsignedShortToByteArray(efFileSize)) : null,
                    pinStatusTemplateDo != null ? new BerOctetString(Hex.decodeHex(pinStatusTemplateDo.toCharArray())) : null,
                    shortEfId != null ? new BerOctetString(unsignedShortToByteArray(shortEfId)) : null,
                    null,
                    linkPath != null ? new BerOctetString(Hex.decodeHex(linkPath.toCharArray())) : null
            );
        } catch (DecoderException e) {
            throw new RuntimeException("Could not decode passed FCP.", e);
        }
    }
}
