/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.component;

import org.nabucco.framework.base.facade.component.locator.ComponentLocator;
import org.nabucco.framework.base.facade.component.locator.ComponentLocatorSupport;

/**
 * Locator for SchemaComponent.
 *
 * @author NABUCCO Generator, PRODYNA AG
 */
public class SchemaComponentLocator extends ComponentLocatorSupport<SchemaComponent> implements
        ComponentLocator<SchemaComponent> {

    private static final String JNDI_NAME = ((((ComponentLocator.COMPONENTS + "/") + SchemaComponent.COMPONENT_NAME) + "/") + "org.nabucco.testautomation.schema.facade.component.SchemaComponent");

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

    /**
     * Getter for the Instance.
     *
     * @return the SchemaComponentLocator.
     */
    public static SchemaComponentLocator getInstance() {
        if ((instance == null)) {
            instance = new SchemaComponentLocator(JNDI_NAME, SchemaComponent.class);
        }
        return instance;
    }
}
