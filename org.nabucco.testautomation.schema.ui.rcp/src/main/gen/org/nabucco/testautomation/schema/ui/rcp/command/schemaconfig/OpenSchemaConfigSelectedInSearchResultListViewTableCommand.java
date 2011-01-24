/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenSchemaConfigSelectedInSearchResultListViewTableCommand<p/>This command is for creating a SchemaConfig<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-14
 */
public class OpenSchemaConfigSelectedInSearchResultListViewTableCommand implements NabuccoCommand {

    private OpenSchemaConfigSelectedInSearchResultListViewTableHandler openSchemaConfigSelectedInSearchResultListViewTableHandler = NabuccoInjector
            .getInstance(OpenSchemaConfigSelectedInSearchResultListViewTableCommand.class).inject(
                    OpenSchemaConfigSelectedInSearchResultListViewTableHandler.class);

    public static final String ID = "org.nabucco.testautomation.schema.ui.command.config.CreateSchemaConfigCommand";

    /** Constructs a new OpenSchemaConfigSelectedInSearchResultListViewTableCommand instance. */
    public OpenSchemaConfigSelectedInSearchResultListViewTableCommand() {
        super();
    }

    @Override
    public void run() {
        openSchemaConfigSelectedInSearchResultListViewTableHandler
                .openSchemaConfigSelectedInSearchResultListViewTable();
    }

    @Override
    public String getId() {
        return OpenSchemaConfigSelectedInSearchResultListViewTableCommand.ID;
    }
}
