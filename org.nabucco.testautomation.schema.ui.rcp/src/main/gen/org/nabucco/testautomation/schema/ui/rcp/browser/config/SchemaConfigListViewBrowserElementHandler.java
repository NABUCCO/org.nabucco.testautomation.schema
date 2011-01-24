/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.browser.config;

import org.nabucco.framework.plugin.base.command.CommandHandler;
import org.nabucco.framework.plugin.base.model.browser.BrowserElement;
import org.nabucco.testautomation.schema.ui.rcp.list.config.model.SchemaConfigListViewModel;

/**
 * SchemaConfigListViewBrowserElementHandler
 *
 * @author Undefined
 */
public interface SchemaConfigListViewBrowserElementHandler extends CommandHandler {

    /**
     * CreateChildren.
     *
     * @param element the SchemaConfigListViewBrowserElement.
     * @param viewModel the SchemaConfigListViewModel.
     */
    void createChildren(final SchemaConfigListViewModel viewModel,
            final SchemaConfigListViewBrowserElement element);

    /**
     * RemoveChild.
     *
     * @param element the SchemaConfigListViewBrowserElement.
     * @param toBeRemoved the BrowserElement.
     */
    void removeChild(final BrowserElement toBeRemoved,
            final SchemaConfigListViewBrowserElement element);
}
