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

import org.nabucco.framework.plugin.base.command.AbstractOpenCorrespondingEditViewHandlerImpl;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.SchemaConfigListView;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.SchemaMaintenanceMultiplePageEditView;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.model.SchemaMaintenanceMultiplePageEditViewModel;

/**
 * OpenSchemaConfigSelectedInSearchResultListViewTableHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class OpenSchemaConfigSelectedInSearchResultListViewTableHandlerImpl extends AbstractOpenCorrespondingEditViewHandlerImpl<SchemaMaintenanceMultiplePageEditViewModel, SchemaConfig>
	implements OpenSchemaConfigSelectedInSearchResultListViewTableHandler {

	@Override
	public void openSchemaConfigSelectedInSearchResultListViewTable() {
		run();
	}
	
	@Override
	protected String getEditorViewId() {
		return SchemaMaintenanceMultiplePageEditView.ID;
	}

	@Override
	protected String getListViewId() {
		return SchemaConfigListView.ID;
	}

	@Override
	protected void openCorrespondingEditView(SchemaMaintenanceMultiplePageEditViewModel model,
			SchemaConfig schemaConfig) {
		
		model.setSchemaConfig(schemaConfig);
	}
}
