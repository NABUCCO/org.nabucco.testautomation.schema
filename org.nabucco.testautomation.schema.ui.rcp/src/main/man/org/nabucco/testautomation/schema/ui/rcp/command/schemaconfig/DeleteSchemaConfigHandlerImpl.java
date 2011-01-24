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

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.close.AbstractDeleteDatatypeHandler;
import org.nabucco.framework.plugin.base.model.BusinessModel;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig.DeleteSchemaConfigHandler;
import org.nabucco.testautomation.schema.ui.rcp.edit.schemaconfig.model.SchemaConfigEditBusinessModel;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.SchemaMaintainanceMultiplePageEditView;


/**
 * DeleteSchemaConfigHandlerImpl
 * 
 * @author Marco Sussek, PRODYNA AG
 */
public class DeleteSchemaConfigHandlerImpl extends
		AbstractDeleteDatatypeHandler<SchemaMaintainanceMultiplePageEditView>
		implements DeleteSchemaConfigHandler {

	@Override
	public String getId() {
		return SchemaMaintainanceMultiplePageEditView.ID;
	}

	@Override
	public void deleteSchemaConfig() {
		super.run();
	}
	
    @Override
    protected boolean preClose(SchemaMaintainanceMultiplePageEditView view) {

        SchemaConfig schemaConfig = view.getModel().getSchemaConfig();

        schemaConfig.setDatatypeState(DatatypeState.DELETED);

        BusinessModel businessModel = Activator.getDefault().getModel()
                .getBusinessModel(SchemaConfigEditBusinessModel.ID);

        try {
            if (businessModel instanceof SchemaConfigEditBusinessModel) {
                ((SchemaConfigEditBusinessModel) businessModel).delete(schemaConfig);
            }
        } catch (ClientException e) {
            Activator.getDefault().logError(e);
            return true;
        }

        return super.preClose(view);
    }

}
