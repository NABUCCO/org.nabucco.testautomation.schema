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
package org.nabucco.testautomation.schema.impl.service.produce.clone;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Key;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Version;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.testautomation.facade.datatype.base.ExportDatatype;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;


/**
 * SchemaConfigCloneVisitor
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SchemaConfigCloneVisitor extends DatatypeVisitor {

	@Override
	public void visit(Datatype datatype) throws VisitorException {
		
		if (datatype instanceof SchemaConfig) {
            this.visit((SchemaConfig) datatype);
        } else if (datatype instanceof SchemaElement) {
            this.visit((SchemaElement) datatype);
        }  else if (datatype instanceof Attribute) {
            this.visit((Attribute) datatype);
        } else {
        	super.visit(datatype);
        }
    }
	
    protected void visit(SchemaConfig datatype) throws VisitorException {
        resetDatatype(datatype);
        super.visit(datatype);
    }
    
    protected void visit(SchemaElement datatype) throws VisitorException {
        resetDatatype(datatype);
        super.visit(datatype);
    }
    
    protected void visit(Attribute datatype) throws VisitorException {
        resetDatatype(datatype);
        super.visit(datatype);
    }
    
    private void resetDatatype(NabuccoDatatype datatype) {
        datatype.setDatatypeState(DatatypeState.INITIALIZED);
        datatype.setVersion((Version) null);
        datatype.setId((Identifier) null);
        
        if (datatype instanceof ExportDatatype) {
        	ExportDatatype exportDatatype = (ExportDatatype) datatype;
			exportDatatype.setIdentificationKey(new Key());
			exportDatatype.setOwner(NabuccoInstance.getInstance().getOwner());
        }
    }

}
