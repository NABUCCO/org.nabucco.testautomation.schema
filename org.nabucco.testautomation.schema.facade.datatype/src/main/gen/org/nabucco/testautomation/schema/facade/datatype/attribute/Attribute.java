/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.datatype.attribute;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.testautomation.schema.facade.datatype.attribute.AttributeType;

/**
 * Attribute<p/>A datatype defining an attribute<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class Attribute extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_NAMES = { "name", "description", "mandatory", "type" };

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,n;m1,1;", "l0,n;m0,1;",
            "l0,n;m1,1;", "m1,1;" };

    private Name name;

    private Description description;

    private Flag mandatory;

    private AttributeType type;

    /** Constructs a new Attribute instance. */
    public Attribute() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the Attribute.
     */
    protected void cloneObject(Attribute clone) {
        super.cloneObject(clone);
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getDescription() != null)) {
            clone.setDescription(this.getDescription().cloneObject());
        }
        if ((this.getMandatory() != null)) {
            clone.setMandatory(this.getMandatory().cloneObject());
        }
        clone.setType(this.getType());
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[0], Name.class,
                PROPERTY_CONSTRAINTS[0], this.name));
        properties.add(new BasetypeProperty<Description>(PROPERTY_NAMES[1], Description.class,
                PROPERTY_CONSTRAINTS[1], this.description));
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[2], Flag.class,
                PROPERTY_CONSTRAINTS[2], this.mandatory));
        properties.add(new EnumProperty<AttributeType>(PROPERTY_NAMES[3], AttributeType.class,
                PROPERTY_CONSTRAINTS[3], this.type));
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
        final Attribute other = ((Attribute) obj);
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.description == null)) {
            if ((other.description != null))
                return false;
        } else if ((!this.description.equals(other.description)))
            return false;
        if ((this.mandatory == null)) {
            if ((other.mandatory != null))
                return false;
        } else if ((!this.mandatory.equals(other.mandatory)))
            return false;
        if ((this.type == null)) {
            if ((other.type != null))
                return false;
        } else if ((!this.type.equals(other.type)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((PRIME * result) + ((this.mandatory == null) ? 0 : this.mandatory.hashCode()));
        result = ((PRIME * result) + ((this.type == null) ? 0 : this.type.hashCode()));
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<Attribute>\n");
        appendable.append(super.toString());
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<description>" + this.description) + "</description>\n"));
        appendable.append((("<mandatory>" + this.mandatory) + "</mandatory>\n"));
        appendable.append((("<type>" + this.type) + "</type>\n"));
        appendable.append("</Attribute>\n");
        return appendable.toString();
    }

    @Override
    public Attribute cloneObject() {
        Attribute clone = new Attribute();
        this.cloneObject(clone);
        return clone;
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
     * Missing description at method setName.
     *
     * @param name the String.
     */
    public void setName(String name) {
        if ((this.name == null)) {
            this.name = new Name();
        }
        this.name.setValue(name);
    }

    /**
     * Missing description at method getDescription.
     *
     * @return the Description.
     */
    public Description getDescription() {
        return this.description;
    }

    /**
     * Missing description at method setDescription.
     *
     * @param description the Description.
     */
    public void setDescription(Description description) {
        this.description = description;
    }

    /**
     * Missing description at method setDescription.
     *
     * @param description the String.
     */
    public void setDescription(String description) {
        if ((this.description == null)) {
            this.description = new Description();
        }
        this.description.setValue(description);
    }

    /**
     * Missing description at method getMandatory.
     *
     * @return the Flag.
     */
    public Flag getMandatory() {
        return this.mandatory;
    }

    /**
     * Missing description at method setMandatory.
     *
     * @param mandatory the Flag.
     */
    public void setMandatory(Flag mandatory) {
        this.mandatory = mandatory;
    }

    /**
     * Missing description at method setMandatory.
     *
     * @param mandatory the Boolean.
     */
    public void setMandatory(Boolean mandatory) {
        if ((this.mandatory == null)) {
            this.mandatory = new Flag();
        }
        this.mandatory.setValue(mandatory);
    }

    /**
     * Missing description at method getType.
     *
     * @return the AttributeType.
     */
    public AttributeType getType() {
        return this.type;
    }

    /**
     * Missing description at method setType.
     *
     * @param type the AttributeType.
     */
    public void setType(AttributeType type) {
        this.type = type;
    }

    /**
     * Missing description at method setType.
     *
     * @param type the String.
     */
    public void setType(String type) {
        if ((type == null)) {
            this.type = null;
        } else {
            this.type = AttributeType.valueOf(type);
        }
    }
}
