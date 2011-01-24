/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.datatype.attribute;

import org.nabucco.framework.base.facade.datatype.Enumeration;

/**
 * AttributeType<p/>A datatype defining an attribute<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public enum AttributeType implements Enumeration {
    CODE("C"),
    STRING("S"), ;

    private String id;

    /**
     * Constructs a new AttributeType instance.
     *
     * @param id the String.
     */
    AttributeType(String id) {
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
