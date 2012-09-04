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
package org.nabucco.testautomation.schema.ui.rcp.browser.config;

import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.ui.rcp.list.config.model.SchemaConfigListViewModel;

/**
 * SchemaConfigListViewBrowserElementHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaConfigListViewBrowserElementHandlerImpl implements SchemaConfigListViewBrowserElementHandler {

    @Override
    public void createChildren(SchemaConfigListViewModel viewModel, SchemaConfigListViewBrowserElement element) {
        SchemaConfig[] elements = viewModel.getElements();

        for (SchemaConfig schemaConfig : elements) {
            element.addBrowserElement(new SchemaConfigEditViewBrowserElement(schemaConfig));
        }
    }

    @Override
    public void removeChild(BrowserElement toBeRemoved, SchemaConfigListViewBrowserElement element) {
        // No remove on database from browserList
        // SchemaConfigEditViewBrowserElement browserElement = (SchemaConfigEditViewBrowserElement)
        // toBeRemoved;
        // SchemaConfigEditViewModel viewModel = browserElement.getViewModel();
        // SchemaConfig schemaConfig = viewModel.getSchemaConfig();
        // schemaConfig.setDatatypeState(DatatypeState.DELETED);
        // SchemaConfigEditBusinessModel businessModel = new SchemaConfigEditBusinessModel();
        // businessModel.save(schemaConfig);
    }

}
