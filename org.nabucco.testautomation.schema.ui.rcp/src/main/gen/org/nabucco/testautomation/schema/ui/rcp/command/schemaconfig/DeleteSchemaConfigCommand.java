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
