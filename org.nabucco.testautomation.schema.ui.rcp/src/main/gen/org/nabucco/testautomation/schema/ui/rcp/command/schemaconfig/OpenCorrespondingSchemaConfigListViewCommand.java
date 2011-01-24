/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * OpenCorrespondingSchemaConfigListViewCommand<p/>open list view for SchemaConfig<p/>
 *
 * @author Stefan Huettenrauch, PRODYNA AG, 2010-06-10
 */
public class OpenCorrespondingSchemaConfigListViewCommand implements NabuccoCommand {

    private OpenCorrespondingSchemaConfigListViewHandler openCorrespondingSchemaConfigListViewHandler = NabuccoInjector
            .getInstance(OpenCorrespondingSchemaConfigListViewCommand.class).inject(
                    OpenCorrespondingSchemaConfigListViewHandler.class);

    public static final String ID = "org.nabucco.testautomation.schema.ui.command.config.OpenCorrespondingSchemaConfigListViewCommand";

    /** Constructs a new OpenCorrespondingSchemaConfigListViewCommand instance. */
    public OpenCorrespondingSchemaConfigListViewCommand() {
        super();
    }

    @Override
    public void run() {
        openCorrespondingSchemaConfigListViewHandler.openCorrespondingSchemaConfigListView();
    }

    @Override
    public String getId() {
        return OpenCorrespondingSchemaConfigListViewCommand.ID;
    }
}
