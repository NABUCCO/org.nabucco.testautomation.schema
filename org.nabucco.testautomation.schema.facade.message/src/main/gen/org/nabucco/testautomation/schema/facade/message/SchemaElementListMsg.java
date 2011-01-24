/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.message;

import java.util.ArrayList;
import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;

/**
 * SchemaElementListMsg<p/>Message containing a list of SchemaElements<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SchemaElementListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "schemaElementList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<SchemaElement> schemaElementList;

    /** Constructs a new SchemaElementListMsg instance. */
    public SchemaElementListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<SchemaElement>(PROPERTY_NAMES[0], SchemaElement.class,
                PROPERTY_CONSTRAINTS[0], this.schemaElementList));
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
        final SchemaElementListMsg other = ((SchemaElementListMsg) obj);
        if ((this.schemaElementList == null)) {
            if ((other.schemaElementList != null))
                return false;
        } else if ((!this.schemaElementList.equals(other.schemaElementList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.schemaElementList == null) ? 0 : this.schemaElementList
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<SchemaElementListMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<schemaElementList>" + this.schemaElementList) + "</schemaElementList>\n"));
        appendable.append("</SchemaElementListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getSchemaElementList.
     *
     * @return the List<SchemaElement>.
     */
    public List<SchemaElement> getSchemaElementList() {
        if ((this.schemaElementList == null)) {
            this.schemaElementList = new ArrayList<SchemaElement>();
        }
        return this.schemaElementList;
    }
}
