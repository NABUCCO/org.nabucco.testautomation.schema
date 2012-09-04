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
package org.nabucco.testautomation.schema.impl.service.produce;

import org.nabucco.framework.base.facade.datatype.visitor.VisitorException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.impl.service.produce.clone.SchemaConfigCloneVisitor;


/**
 * ProduceSchemaConfigCloneServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ProduceSchemaConfigCloneServiceHandlerImpl extends ProduceSchemaConfigCloneServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	protected SchemaConfigMsg produceSchemaConfigClone(SchemaConfigMsg msg)
			throws ProduceException {
		
    	SchemaConfig schema = msg.getSchemaConfig();
    	
    	if (schema == null) {
    		throw new ProduceException("No SchemaConfig to clone");
    	}
    	
    	// Clone
    	SchemaConfigCloneVisitor cloneVisitor = new SchemaConfigCloneVisitor();
    	SchemaConfig clone = schema.cloneObject();
        try {
			clone.accept(cloneVisitor);
		} catch (VisitorException ex) {
			throw new ProduceException(ex);
		}
		msg.setSchemaConfig(clone);
        return msg;
	}

}
