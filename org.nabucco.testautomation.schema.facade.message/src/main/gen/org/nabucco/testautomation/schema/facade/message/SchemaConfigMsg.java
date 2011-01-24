/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.property.DatatypeProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;

/**
 * SchemaConfigMsg<p/>Message for persisting a SchemaConfig<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaConfigMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "schemaConfig" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;" };

    private SchemaConfig schemaConfig;

    /** Constructs a new SchemaConfigMsg instance. */
    public SchemaConfigMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new DatatypeProperty<SchemaConfig>(PROPERTY_NAMES[0], SchemaConfig.class,
                PROPERTY_CONSTRAINTS[0], this.schemaConfig));
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
        final SchemaConfigMsg other = ((SchemaConfigMsg) obj);
        if ((this.schemaConfig == null)) {
            if ((other.schemaConfig != null))
                return false;
        } else if ((!this.schemaConfig.equals(other.schemaConfig)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.schemaConfig == null) ? 0 : this.schemaConfig
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<SchemaConfigMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<schemaConfig>" + this.schemaConfig) + "</schemaConfig>\n"));
        appendable.append("</SchemaConfigMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getSchemaConfig.
     *
     * @return the SchemaConfig.
     */
    public SchemaConfig getSchemaConfig() {
        return this.schemaConfig;
    }

    /**
     * Missing description at method setSchemaConfig.
     *
     * @param schemaConfig the SchemaConfig.
     */
    public void setSchemaConfig(SchemaConfig schemaConfig) {
        this.schemaConfig = schemaConfig;
    }
}
