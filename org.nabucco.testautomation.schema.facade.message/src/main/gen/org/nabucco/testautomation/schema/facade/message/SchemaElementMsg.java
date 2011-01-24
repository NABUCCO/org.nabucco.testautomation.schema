/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;

/**
 * SchemaElementMsg<p/>Message for persisting a SchemaElement<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaElementMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "schemaElement" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private SchemaElement schemaElement;

    /** Constructs a new SchemaElementMsg instance. */
    public SchemaElementMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<SchemaElement>(PROPERTY_NAMES[0], SchemaElement.class,
                PROPERTY_CONSTRAINTS[0], this.schemaElement));
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
        final SchemaElementMsg other = ((SchemaElementMsg) obj);
        if ((this.schemaElement == null)) {
            if ((other.schemaElement != null))
                return false;
        } else if ((!this.schemaElement.equals(other.schemaElement)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.schemaElement == null) ? 0 : this.schemaElement
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<SchemaElementMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<schemaElement>" + this.schemaElement) + "</schemaElement>\n"));
        appendable.append("</SchemaElementMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getSchemaElement.
     *
     * @return the SchemaElement.
     */
    public SchemaElement getSchemaElement() {
        return this.schemaElement;
    }

    /**
     * Missing description at method setSchemaElement.
     *
     * @param schemaElement the SchemaElement.
     */
    public void setSchemaElement(SchemaElement schemaElement) {
        this.schemaElement = schemaElement;
    }
}
