/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * DeleteSchemaConfigCommand<p/>This command should delete a SchemaConfig<p/>
 *
 * @author Marco Sussek, PRODYNA AG, 2010-11-17
 */
public class DeleteSchemaConfigCommand implements NabuccoCommand {

    private DeleteSchemaConfigHandler deleteSchemaConfigHandler = NabuccoInjector.getInstance(
            DeleteSchemaConfigCommand.class).inject(DeleteSchemaConfigHandler.class);

    public static final String ID = "org.nabucco.testautomation.schema.ui.command.config.DeleteSchemaConfigCommand";

    /** Constructs a new DeleteSchemaConfigCommand instance. */
    public DeleteSchemaConfigCommand() {
        super();
    }

    @Override
    public void run() {
        deleteSchemaConfigHandler.deleteSchemaConfig();
    }

    @Override
    public String getId() {
        return DeleteSchemaConfigCommand.ID;
    }
}
