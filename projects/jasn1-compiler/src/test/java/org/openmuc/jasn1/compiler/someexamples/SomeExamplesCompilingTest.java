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

import com.simless.mnohub.compiler.simalliance.generated.pedefinitions.*;
import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.junit.Ignore;
import org.junit.Test;
import org.openmuc.jasn1.ber.BerByteArrayOutputStream;
import org.openmuc.jasn1.ber.types.BerNull;
import org.openmuc.jasn1.ber.types.BerObjectIdentifier;
import org.openmuc.jasn1.ber.types.BerOctetString;
import org.openmuc.jasn1.ber.types.string.BerUTF8String;
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
    public void compiling2() throws Exception {

        String[] args = new String[]{"-o", "src/test/java-gen/com/simless/mnohub/compiler/simalliance/generated",
                "-p", "com.simless.mnohub.compiler.simalliance.generated", "-il",
                "src/test/resources/PEDefinitions V2.0.asn"};
        Compiler.main(args);
        // taken from Anex C
        ProfileElement profileElement = new ProfileElement();
        ServicesList servicesList = new ServicesList();
        ProfileHeader.SubSeqOf_eUICC_Mandatory_GFSTEList GFSTEList = new ProfileHeader.SubSeqOf_eUICC_Mandatory_GFSTEList();
        GFSTEList.seqOf = Arrays.asList(
                new BerObjectIdentifier(new int[]{2, 23, 143, 1, 2, 1}),
                new BerObjectIdentifier(new int[]{2, 23, 143, 1, 2, 4}));

        servicesList.usim = new BerNull();
        servicesList.milenage = new BerNull();
        servicesList.javacard = new BerNull();
        profileElement.header = new ProfileHeader(new UInt8(2), new UInt8(0),
                new BerUTF8String("SIMalliance Profile Package"),
                new BerOctetString(Hex.decodeHex("89019990001234567893".toCharArray())),
                new BerOctetString(new byte[]{1, 2, 3}),
                servicesList, GFSTEList, null);
        profileElement.genericFileManagement = new PE_GenericFileManagement(
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
        profileElement.encode(berByteArrayOutputStream, false);
        byte[] code = berByteArrayOutputStream.getArray();
        System.out.println(Hex.encodeHexString(code));
        ProfileElement rereadProfileElement = new ProfileElement();
        rereadProfileElement.decode(new ByteArrayInputStream(code), null);
        BerByteArrayOutputStream berByteArrayOutputStream2 = new BerByteArrayOutputStream(2048, true);
        rereadProfileElement.encode(berByteArrayOutputStream2, false);
        byte[] code2 = berByteArrayOutputStream2.getArray();
        assertEquals(Hex.encodeHexString(code), Hex.encodeHexString(code2));
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
