/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * ReadSchemaConfigCommand<p/>This command is for reading a SchemaConfig<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-14
 */
public class ReadSchemaConfigCommand implements NabuccoCommand {

    private ReadSchemaConfigHandler readSchemaConfigHandler = NabuccoInjector.getInstance(
            ReadSchemaConfigCommand.class).inject(ReadSchemaConfigHandler.class);

    public static final String ID = "org.nabucco.testautomation.schema.ui.command.config.ReadSchemaConfigCommand";

    /** Constructs a new ReadSchemaConfigCommand instance. */
    public ReadSchemaConfigCommand() {
        super();
    }

    @Override
    public void run() {
        readSchemaConfigHandler.readSchemaConfig();
    }

    @Override
    public String getId() {
        return ReadSchemaConfigCommand.ID;
    }
}
