/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * SaveSchemaConfigCommand<p/>This command should save a SchemaConfig<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-14
 */
public class SaveSchemaConfigCommand implements NabuccoCommand {

    private SaveSchemaConfigHandler saveSchemaConfigHandler = NabuccoInjector.getInstance(
            SaveSchemaConfigCommand.class).inject(SaveSchemaConfigHandler.class);

    public static final String ID = "org.nabucco.testautomation.schema.ui.command.config.SaveSchemaConfigCommand";

    /** Constructs a new SaveSchemaConfigCommand instance. */
    public SaveSchemaConfigCommand() {
        super();
    }

    @Override
    public void run() {
        saveSchemaConfigHandler.saveSchemaConfig();
    }

    @Override
    public String getId() {
        return SaveSchemaConfigCommand.ID;
    }
}
