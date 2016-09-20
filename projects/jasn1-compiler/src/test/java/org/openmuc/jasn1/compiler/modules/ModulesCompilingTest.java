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
package org.openmuc.jasn1.compiler.modules;

import org.junit.Test;
import org.openmuc.jasn1.compiler.Compiler;

public class ModulesCompilingTest {

    @Test
    public void compiling() throws Exception {

        String[] args = new String[] { "-o", "src/test/java-gen/org/openmuc/jasn1/compiler/modules/generated", "-p",
                "org.openmuc.jasn1.compiler.modules.generated", "src/test/resources/modules1.asn",
                "src/test/resources/modules2.asn" };
        Compiler.main(args);

    }

}
