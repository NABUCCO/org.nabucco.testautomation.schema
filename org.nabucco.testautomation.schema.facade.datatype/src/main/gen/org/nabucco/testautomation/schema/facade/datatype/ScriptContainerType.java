/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.datatype;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * ScriptContainerType<p/>Enumeration to indicate a script container<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-08
 */
public enum ScriptContainerType implements Enumeration {
    NONE("N"),
    ONE("O"),
    MANY("M"), ;

    private String id;

    /**
     * Constructs a new ScriptContainerType instance.
     *
     * @param id the String.
     */
    ScriptContainerType(String id) {
        this.id = id;
    }

    @Override
    public String getId() {
        return this.id;
    }

    @Override
    public int getOrdinal() {
        return this.ordinal();
    }

    @Override
    public Enumeration cloneObject() {
        return this;
    }
}
