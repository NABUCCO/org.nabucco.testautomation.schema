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
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;

/**
 * SchemaConfigListMsg<p/>Message containing a list of SchemaConfigs<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SchemaConfigListMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "schemaConfigList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m0,n;" };

    private List<SchemaConfig> schemaConfigList;

    /** Constructs a new SchemaConfigListMsg instance. */
    public SchemaConfigListMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new ListProperty<SchemaConfig>(PROPERTY_NAMES[0], SchemaConfig.class,
                PROPERTY_CONSTRAINTS[0], this.schemaConfigList));
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
        final SchemaConfigListMsg other = ((SchemaConfigListMsg) obj);
        if ((this.schemaConfigList == null)) {
            if ((other.schemaConfigList != null))
                return false;
        } else if ((!this.schemaConfigList.equals(other.schemaConfigList)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.schemaConfigList == null) ? 0 : this.schemaConfigList
                .hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<SchemaConfigListMsg>\n");
        appendable.append(super.toString());
        appendable
                .append((("<schemaConfigList>" + this.schemaConfigList) + "</schemaConfigList>\n"));
        appendable.append("</SchemaConfigListMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getSchemaConfigList.
     *
     * @return the List<SchemaConfig>.
     */
    public List<SchemaConfig> getSchemaConfigList() {
        if ((this.schemaConfigList == null)) {
            this.schemaConfigList = new ArrayList<SchemaConfig>();
        }
        return this.schemaConfigList;
    }
}
