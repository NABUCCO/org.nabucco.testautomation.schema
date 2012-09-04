/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.schema.ui.rcp.browser.config;

import java.util.List;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.framework.plugin.base.model.browser.BrowserListElement;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.ui.rcp.list.config.model.SchemaConfigListViewModel;

/**
 * SchemaConfigListViewBrowserElement
 *
 * @author Undefined
 */
public class SchemaConfigListViewBrowserElement extends BrowserListElement<SchemaConfigListViewModel> implements
        NabuccoInjectionReciever {

    private SchemaConfigListViewBrowserElementHandler listViewBrowserElementHandler;

    /**
     * Constructs a new SchemaConfigListViewBrowserElement instance.
     *
     * @param datatypeList the List<SchemaConfig>.
     */
    public SchemaConfigListViewBrowserElement(final List<SchemaConfig> datatypeList) {
        this(datatypeList.toArray(new SchemaConfig[datatypeList.size()]));
    }

    /**
     * Constructs a new SchemaConfigListViewBrowserElement instance.
     *
     * @param datatypeArray the SchemaConfig[].
     */
    public SchemaConfigListViewBrowserElement(final SchemaConfig[] datatypeArray) {
        super();
        NabuccoInjector instance = NabuccoInjector.getInstance(SchemaConfigListViewBrowserElement.class);
        listViewBrowserElementHandler = instance.inject(SchemaConfigListViewBrowserElementHandler.class);
        viewModel = new SchemaConfigListViewModel();
        viewModel.setElements(datatypeArray);
    }

    @Override
    protected void createChildren() {
        this.clearChildren();
        listViewBrowserElementHandler.createChildren(viewModel, this);
    }

    @Override
    public void removeBrowserElement(final BrowserElement element) {
        super.removeBrowserElement(element);
        listViewBrowserElementHandler.removeChild(element, this);
    }
}
