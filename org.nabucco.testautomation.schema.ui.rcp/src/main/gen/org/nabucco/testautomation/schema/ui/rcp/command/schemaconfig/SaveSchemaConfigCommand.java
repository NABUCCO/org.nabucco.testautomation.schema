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
package org.nabucco.testautomation.schema.ui.rcp.command.schemaconfig;

import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.plugin.base.command.NabuccoCommand;

/**
 * SaveSchemaConfigCommand<p/>This command should save a SchemaConfig<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-14
 */
public class SaveSchemaConfigCommand implements NabuccoCommand {

    private SaveSchemaConfigHandler saveSchemaConfigHandler = NabuccoInjector
            .getInstance(SaveSchemaConfigCommand.class).inject(SaveSchemaConfigHandler.class);

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
