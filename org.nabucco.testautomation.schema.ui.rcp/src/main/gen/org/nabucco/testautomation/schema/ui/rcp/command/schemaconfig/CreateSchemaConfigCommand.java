/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * CreateSchemaConfigCommand<p/>This command is for creating a SchemaConfig<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-14
 */
public class CreateSchemaConfigCommand implements NabuccoCommand {

    private CreateSchemaConfigCommandHandler createSchemaConfigCommandHandler = NabuccoInjector
            .getInstance(CreateSchemaConfigCommand.class).inject(
                    CreateSchemaConfigCommandHandler.class);

    public static final String ID = "org.nabucco.testautomation.schema.ui.command.config.CreateSchemaConfigCommand";

    /** Constructs a new CreateSchemaConfigCommand instance. */
    public CreateSchemaConfigCommand() {
        super();
    }

    @Override
    public void run() {
        createSchemaConfigCommandHandler.createSchemaConfigCommand();
    }

    @Override
    public String getId() {
        return CreateSchemaConfigCommand.ID;
    }
}
