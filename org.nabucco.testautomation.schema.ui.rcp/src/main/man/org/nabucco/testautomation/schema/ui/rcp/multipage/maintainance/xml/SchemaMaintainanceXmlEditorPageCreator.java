/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.xml;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.xml.DatatypeXMLEditorTextPartCreator;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorTextPart;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorTextPartCreatorImpl;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;


/**
 * WorkflowConditionXmlEditorPageCreator
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintainanceXmlEditorPageCreator extends XMLEditorTextPartCreatorImpl<Datatype> {

    /**
     * {@inheritDoc}
     */
    @Override
    protected XMLEditorTextPart createXMLNodeWithTypedDatatype(Datatype datatype,
            XMLEditorTextPart parent, DatatypeXMLEditorTextPartCreator builder) {
        XMLEditorTextPart result = null;

        if (datatype instanceof SchemaConfig) {
            SchemaConfig sc = (SchemaConfig) datatype;
            result = new XMLEditorTextPart(0, XmlFactory.createStartTag(sc),
                    XmlFactory.createEndTag(sc), XmlFactory.createContent(sc), null, datatype);

            for (SchemaElement element : sc.getSchemaElementList()) {
                result.getChildren().add(builder.create(element, result));
            }
        } else if (datatype instanceof SchemaElement) {
            SchemaElement se = (SchemaElement) datatype;
            result = new XMLEditorTextPart(0, XmlFactory.createStartTag(se),
                    XmlFactory.createEndTag(se), XmlFactory.createContent(se), parent, datatype);

            for (SchemaElement element : se.getSchemaElementList()) {
                result.getChildren().add(builder.create(element, result));
            }
        }
        return result;
    }

}
