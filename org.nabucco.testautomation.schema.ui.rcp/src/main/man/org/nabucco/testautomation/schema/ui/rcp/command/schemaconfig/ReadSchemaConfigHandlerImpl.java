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

import java.util.List;

import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.command.AbstractOpenEditViewHandler;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.ui.rcp.browser.config.SchemaConfigEditViewBrowserElement;
import org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig.ReadSchemaConfigHandler;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.SchemaMaintainanceMultiplePageEditView;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.SchemaMaintainanceMultiplePageEditViewModel;


public class ReadSchemaConfigHandlerImpl
        extends
        AbstractOpenEditViewHandler<SchemaMaintainanceMultiplePageEditViewModel, SchemaMaintainanceMultiplePageEditView>
        implements ReadSchemaConfigHandler {

    @Override
    public void readSchemaConfig() {
        run();
    }

    public void run() {
        super.openView(getEditViewId());
    }

    @Override
    protected void updateModel(SchemaMaintainanceMultiplePageEditViewModel model) {
        SchemaConfig selection = getSelection();
        if (selection != null) {
            model.setSchemaConfig(selection);
        }
    }

    private SchemaConfig getSelection() {
        SchemaConfig result = null;

        // get browser view
        List<BrowserElement> selected = Activator.getDefault().getModel().getBrowserModel()
                .getSelected();
        BrowserElement firstElement = selected.get(0);
        result = ((SchemaConfigEditViewBrowserElement) firstElement).getViewModel()
                .getSchemaConfig();
        return result;
    }

    @Override
    protected String getEditViewId() {
        return SchemaMaintainanceMultiplePageEditView.ID;
    }

}
