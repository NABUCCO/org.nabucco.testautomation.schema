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
package org.nabucco.testautomation.schema.impl.service.produce;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.ScriptContainerType;
import org.nabucco.testautomation.schema.facade.message.SchemaElementMsg;
import org.nabucco.testautomation.schema.impl.service.produce.ProduceSchemaElementServiceHandler;


/**
 * ProduceSchemaElementServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ProduceSchemaElementServiceHandlerImpl extends ProduceSchemaElementServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	public SchemaElementMsg produceSchemaElement(EmptyServiceMessage msg)
			throws ProduceException {
		
		SchemaElementMsg rs = new SchemaElementMsg();
		SchemaElement schemaElement = new SchemaElement();
		schemaElement.setDatatypeState(DatatypeState.INITIALIZED);
		
		// set Default-Values
		schemaElement.setDefaultDependency(Boolean.TRUE);
		schemaElement.setHasDependencies(Boolean.FALSE);
		schemaElement.setManualExecutionAllowed(Boolean.FALSE);
		schemaElement.setPropertyContainer(Boolean.FALSE);
		schemaElement.setSkipable(Boolean.FALSE);
		schemaElement.setJiraExport(Boolean.FALSE);
		schemaElement.setScriptsAllowed(ScriptContainerType.NONE);
		schemaElement.setName("Enter name ...");
		
		rs.setSchemaElement(schemaElement);
		return rs;		
	}

}
