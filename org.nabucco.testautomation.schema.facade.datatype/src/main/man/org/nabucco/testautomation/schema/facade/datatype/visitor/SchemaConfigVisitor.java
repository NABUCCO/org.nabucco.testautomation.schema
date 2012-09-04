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
package org.nabucco.testautomation.schema.facade.datatype.visitor;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;

/**
 * SchemaConfigVisitor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SchemaConfigVisitor extends DatatypeVisitor {

    @Override
    public void visit(Datatype datatype) throws VisitorException {

        if (datatype instanceof SchemaConfig) {
            this.visit((SchemaConfig) datatype);
        } else if (datatype instanceof SchemaElement) {
            this.visit((SchemaElement) datatype);
        } else if (datatype instanceof Attribute) {
            this.visit((Attribute) datatype);
        }
        super.visit(datatype);
    }

    /**
     * Visit {@link SchemaConfig} instances.
     * 
     * @param element
     *            the element to visit
     */
    protected void visit(SchemaConfig element) throws VisitorException {
    }

    /**
     * Visit {@link SchemaElement} instances.
     * 
     * @param element
     *            the element to visit
     */
    protected void visit(SchemaElement element) throws VisitorException {
    }

    /**
     * Visit {@link Attribute} instances.
     * 
     * @param element
     *            the element to visit
     */
    protected void visit(Attribute element) throws VisitorException {
    }

}
