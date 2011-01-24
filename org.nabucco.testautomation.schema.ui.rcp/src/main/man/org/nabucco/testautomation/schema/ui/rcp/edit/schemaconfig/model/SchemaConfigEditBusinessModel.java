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
package org.nabucco.testautomation.schema.ui.rcp.edit.schemaconfig.model;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.logging.Loggable;
import org.nabucco.framework.plugin.base.model.BusinessModel;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.ui.rcp.communication.SchemaComponentServiceDelegateFactory;
import org.nabucco.testautomation.schema.ui.rcp.communication.maintain.MaintainSchemaConfigDelegate;


/**
 * SchemaConfigEditBusinessModel
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaConfigEditBusinessModel implements BusinessModel, Loggable {

	public static String ID = "org.nabucco.testautomation.schema.ui.rcp.edit.schemaconfig.model.SchemaConfigEditBusinessModel";

	/**
	 * Saves a SchemaConfig .
	 * 
	 * @param schemaConfig
	 *            the SchemaConfig
	 * @return the SchemaConfig
	 * @throws ClientException 
	 */
	public SchemaConfig save(final SchemaConfig schemaConfig) throws ClientException {
		SchemaComponentServiceDelegateFactory schemaComponentServiceDelegateFactory = SchemaComponentServiceDelegateFactory
		.getInstance();

		MaintainSchemaConfigDelegate maintainSchemaConfigDelegate = schemaComponentServiceDelegateFactory
		.getMaintainSchemaConfig();

		SchemaConfigMsg rq = createSchemaConfigMsg(schemaConfig);
		SchemaConfigMsg response = maintainSchemaConfigDelegate
		.maintainSchemaConfig(rq);

		if (response != null) {
			return response.getSchemaConfig();
		}
		return schemaConfig;
	}
	
    /**
     * Deletes a SchemaConfig.
     * 
     * @param schemaConfig
     *            the schema configuration to remove
     * @throws ClientException
     */
    public void delete(SchemaConfig schemaConfig) throws ClientException {
    	SchemaComponentServiceDelegateFactory configComponent = SchemaComponentServiceDelegateFactory
                .getInstance();

    	MaintainSchemaConfigDelegate maintainDelegate = configComponent
                .getMaintainSchemaConfig();

        SchemaConfigMsg request = this.createSchemaConfigMsg(schemaConfig);
        maintainDelegate.maintainSchemaConfig(request);

    }

	private SchemaConfigMsg createSchemaConfigMsg(
			final SchemaConfig schemaConfig) {

		SchemaConfigMsg message = new SchemaConfigMsg();
		message.setSchemaConfig(schemaConfig);

		return message;
	}

	@Override
	public String getID() {
		return SchemaConfigEditBusinessModel.ID;
	}

}
