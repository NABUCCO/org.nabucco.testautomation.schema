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
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.create.AbstractCreateViewHandler;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.SchemaMaintenanceMultiplePageEditView;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.model.SchemaMaintenanceMultiplePageEditViewModel;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.model.SchemaMaintenanceMultiplePageEditViewModelHandler;


/**
 * CreateSchemaConfigCommandHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class CreateSchemaConfigCommandHandlerImpl
        extends
        AbstractCreateViewHandler<SchemaMaintenanceMultiplePageEditViewModel, SchemaMaintenanceMultiplePageEditView>
        implements CreateSchemaConfigCommandHandler {

    SchemaMaintenanceMultiplePageEditViewModelHandler handler = NabuccoInjector.getInstance(
            SchemaMaintenanceMultiplePageEditViewModel.class).inject(
            SchemaMaintenanceMultiplePageEditViewModelHandler.class);

    @Override
    public void createSchemaConfigCommand() {
        super.run();
    }

    @Override
    protected String getEditViewId() {
        return SchemaMaintenanceMultiplePageEditView.ID;
    }

    @Override
    protected void updateModel(SchemaMaintenanceMultiplePageEditViewModel model) {
        model.setSchemaConfig(handler.createDefaultDatatype());
    }
    
}
