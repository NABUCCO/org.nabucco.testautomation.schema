/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.message;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Identifier;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.message.ServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceMessageSupport;
import org.nabucco.testautomation.facade.datatype.base.HierarchyLevelType;

/**
 * SchemaElementSearchMsg<p/>Message for searching SchemaElements<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaElementSearchMsg extends ServiceMessageSupport implements ServiceMessage {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "id", "name", "level" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m1,1;", "m0,1;" };

    private Identifier id;

    private Name name;

    private HierarchyLevelType level;

    /** Constructs a new SchemaElementSearchMsg instance. */
    public SchemaElementSearchMsg() {
        super();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Identifier>(PROPERTY_NAMES[0], Identifier.class,
                PROPERTY_CONSTRAINTS[0], this.id));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[1], Name.class,
                PROPERTY_CONSTRAINTS[1], this.name));
        properties.add(new EnumProperty<HierarchyLevelType>(PROPERTY_NAMES[2],
                HierarchyLevelType.class, PROPERTY_CONSTRAINTS[2], this.level));
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
        final SchemaElementSearchMsg other = ((SchemaElementSearchMsg) obj);
        if ((this.id == null)) {
            if ((other.id != null))
                return false;
        } else if ((!this.id.equals(other.id)))
            return false;
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.level == null)) {
            if ((other.level != null))
                return false;
        } else if ((!this.level.equals(other.level)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.id == null) ? 0 : this.id.hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.level == null) ? 0 : this.level.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<SchemaElementSearchMsg>\n");
        appendable.append(super.toString());
        appendable.append((("<id>" + this.id) + "</id>\n"));
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<level>" + this.level) + "</level>\n"));
        appendable.append("</SchemaElementSearchMsg>\n");
        return appendable.toString();
    }

    @Override
    public ServiceMessage cloneObject() {
        return this;
    }

    /**
     * Missing description at method getId.
     *
     * @return the Identifier.
     */
    public Identifier getId() {
        return this.id;
    }

    /**
     * Missing description at method setId.
     *
     * @param id the Identifier.
     */
    public void setId(Identifier id) {
        this.id = id;
    }

    /**
     * Missing description at method getName.
     *
     * @return the Name.
     */
    public Name getName() {
        return this.name;
    }

    /**
     * Missing description at method setName.
     *
     * @param name the Name.
     */
    public void setName(Name name) {
        this.name = name;
    }

    /**
     * Missing description at method getLevel.
     *
     * @return the HierarchyLevelType.
     */
    public HierarchyLevelType getLevel() {
        return this.level;
    }

    /**
     * Missing description at method setLevel.
     *
     * @param level the HierarchyLevelType.
     */
    public void setLevel(HierarchyLevelType level) {
        this.level = level;
    }
}
