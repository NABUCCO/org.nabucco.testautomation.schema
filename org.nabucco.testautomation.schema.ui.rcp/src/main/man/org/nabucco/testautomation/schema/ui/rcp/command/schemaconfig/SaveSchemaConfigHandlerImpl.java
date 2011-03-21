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
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.command.NabuccoAbstractSaveCommandHandlerImpl;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig.SaveSchemaConfigHandler;
import org.nabucco.testautomation.schema.ui.rcp.edit.schemaconfig.model.SchemaConfigEditBusinessModel;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.SchemaMaintainanceMultiplePageEditViewModel;

/**
 * SaveSchemaConfigHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SaveSchemaConfigHandlerImpl
        extends
        NabuccoAbstractSaveCommandHandlerImpl<SchemaConfigEditBusinessModel, SchemaMaintainanceMultiplePageEditViewModel>
        implements SaveSchemaConfigHandler {

    /**
     * {@inheritDoc}
     */
    @Override
    public void saveSchemaConfig() {
        run();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String getBusinessModelId() {
        return SchemaConfigEditBusinessModel.ID;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    protected void saveModel(SchemaMaintainanceMultiplePageEditViewModel viewModel,
            SchemaConfigEditBusinessModel businessModel) throws ClientException {
        SchemaConfig response = businessModel.save(viewModel.getSchemaConfig());
        viewModel.setSchemaConfig(response);
    }

}
