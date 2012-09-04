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
package org.nabucco.testautomation.schema.facade.component;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for SchemaComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class SchemaComponentLocator extends ComponentLocatorSupport<SchemaComponent> implements
        ComponentLocator<SchemaComponent> {

    private static SchemaComponentLocator instance;

    /**
     * Constructs a new SchemaComponentLocator instance.
     *
     * @param component the Class<SchemaComponent>.
     * @param jndiName the String.
     */
    private SchemaComponentLocator(String jndiName, Class<SchemaComponent> component) {
        super(jndiName, component);
    }

    @Override
    public SchemaComponent getComponent() throws ConnectionException {
        SchemaComponent component = super.getComponent();
        if ((component instanceof SchemaComponentLocal)) {
            return new SchemaComponentLocalProxy(((SchemaComponentLocal) component));
        }
        return component;
    }

    /**
     * Getter for the Instance.
     *
     * @return the SchemaComponentLocator.
     */
    public static SchemaComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new SchemaComponentLocator(SchemaComponent.JNDI_NAME, SchemaComponent.class);
        }
        return instance;
    }
}
