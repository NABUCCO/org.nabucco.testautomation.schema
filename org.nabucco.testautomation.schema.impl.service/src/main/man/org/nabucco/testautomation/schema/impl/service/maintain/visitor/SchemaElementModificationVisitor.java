/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.schema.impl.service.maintain.visitor;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;


/**
 * SchemaElementModificationVisitor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public final class SchemaElementModificationVisitor extends DatatypeVisitor {

    private final SchemaConfig schemaConfig;

    /**
     * Creates a new {@link SchemaElementModificationVisitor} instance.
     * 
     * @param schemaConfig
     *            the schemaConfig
     */
    public SchemaElementModificationVisitor(SchemaConfig schemaConfig) {
        this.schemaConfig = schemaConfig;
    }

    @Override
    public void visit(Datatype datatype) throws VisitorException {

        if (datatype.getDatatypeState() == DatatypeState.INITIALIZED
                || datatype.getDatatypeState() == DatatypeState.MODIFIED
                || datatype.getDatatypeState() == DatatypeState.DELETED) {
        	schemaConfig.setDatatypeState(DatatypeState.MODIFIED);
        } else if (datatype instanceof SchemaElement) {
        	List<Attribute> attributes = ((SchemaElement) datatype).getAttributeList();
        	
        	for (Attribute attribute : attributes) {
        		switch (attribute.getDatatypeState()) {
        		case INITIALIZED:
        		case MODIFIED:
        			schemaConfig.setDatatypeState(DatatypeState.MODIFIED);
        			break;
        		}
			}
        	super.visit(datatype);
        } else {
            super.visit(datatype);
        }
    }
}
