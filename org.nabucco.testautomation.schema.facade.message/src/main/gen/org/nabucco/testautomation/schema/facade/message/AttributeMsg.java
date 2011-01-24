/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;

/**
 * AttributeMsg<p/>Message for transportation of an Attribute<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class AttributeMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "attribute" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private Attribute attribute;

    /** Constructs a new AttributeMsg instance. */
    public AttributeMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<Attribute>(PROPERTY_NAMES[0], Attribute.class,
                PROPERTY_CONSTRAINTS[0], this.attribute));
        return properties;
    }

    @Override
    public boolean equals(Object obj) {
        if ((this == obj)) {
            return true;
        }
        if ((obj == null)) {
            return false;
        }
        if ((this.getClass() != obj.getClass())) {
            return false;
        }
        if ((!super.equals(obj))) {
            return false;
        }
        final AttributeMsg other = ((AttributeMsg) obj);
        if ((this.attribute == null)) {
            if ((other.attribute != null))
                return false;
        } else if ((!this.attribute.equals(other.attribute)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.attribute == null) ? 0 : this.attribute.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<AttributeMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<attribute>" + this.attribute) + "</attribute>\n"));
        appendable.append("</AttributeMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getAttribute.
     *
     * @return the Attribute.
     */
    public Attribute getAttribute() {
        return this.attribute;
    }

    /**
     * Missing description at method setAttribute.
     *
     * @param attribute the Attribute.
     */
    public void setAttribute(Attribute attribute) {
        this.attribute = attribute;
    }
}
