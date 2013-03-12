/*
 *  Copyright 2013 President and fellows of Harvard University.
 *                 (Author: Akio Sone)
 * 
 *  Licensed under the Apache License, Version 2.0 (the "License");
 *  you may not use this file except in compliance with the License.
 *  You may obtain a copy of the License at
 * 
 *       http://www.apache.org/licenses/LICENSE-2.0
 * 
 *  Unless required by applicable law or agreed to in writing, software
 *  distributed under the License is distributed on an "AS IS" BASIS,
 *  WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 *  See the License for the specific language governing permissions and
 *  limitations under the License.
 *  under the License.
 */
package edu.harvard.iq.safe.misc.xmlunittest;

import org.custommonkey.xmlunit.XMLAssert;
import org.custommonkey.xmlunit.XMLUnit;
import org.junit.BeforeClass;
import org.junit.Test;


/**
 *
 * @author Akio Sone
 */
public class XmlUnitTest {
    
    
    @BeforeClass
    public static void setupXmlUnit() {
        XMLUnit.setIgnoreWhitespace(false);
    }

    
    @Test
    public void compareIdenticalXmlStrings() throws Exception {
        String xml1 = "<root><node>Test</node></root>";
        String xml2 = "<root><node>Test</node></root>";

        XMLAssert.assertXMLEqual(xml1, xml2);
    }

    @Test
    public void compareSimilarXmlStringsWithoutTolerance() throws Exception {
        String xml1 = "<root><node>Test</node></root>";
        String xml2 = "<root>\n  <node>Test</node>\n</root>";

        XMLAssert.assertXMLNotEqual(xml1, xml2);
    }

    @Test
    public void compareSimilarXmlStringsIgnoringWhitespace() throws Exception {
        String xml1 = "<root><node>Test</node></root>";
        String xml2 = "<root>\n  <node> Test </node>\n</root>";
        XMLUnit.setIgnoreWhitespace(true);
        XMLAssert.assertXMLEqual(xml1, xml2);
    }

    @Test
    public void compareDifferentXmlStringsIgnoringWhitespace() throws Exception {
        String xml1 = "<root><node>Test</node></root>";
        String xml2 = "<root><node>Te st</node></root>";
        XMLUnit.setIgnoreWhitespace(true);
        XMLAssert.assertXMLNotEqual(xml1, xml2);
    }
}
