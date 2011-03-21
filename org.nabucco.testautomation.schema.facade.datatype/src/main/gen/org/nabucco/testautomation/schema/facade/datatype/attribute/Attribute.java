/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.datatype.attribute;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.schema.facade.datatype.attribute.AttributeType;

/**
 * Attribute<p/>A datatype defining an attribute<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class Attribute extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;m1,1;", "l0,255;m0,1;",
            "l0,n;m1,1;", "m1,1;" };

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    public static final String MANDATORY = "mandatory";

    public static final String TYPE = "type";

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

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(NabuccoDatatype.class)
                .getPropertyMap());
        propertyMap.put(NAME, PropertyDescriptorSupport.createBasetype(NAME, Name.class, 2,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(DESCRIPTION, PropertyDescriptorSupport.createBasetype(DESCRIPTION,
                Description.class, 3, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(MANDATORY, PropertyDescriptorSupport.createBasetype(MANDATORY, Flag.class,
                4, PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(TYPE, PropertyDescriptorSupport.createEnumeration(TYPE,
                AttributeType.class, 5, PROPERTY_CONSTRAINTS[3], false));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties
                .add(super.createProperty(Attribute.getPropertyDescriptor(NAME), this.name, null));
        properties.add(super.createProperty(Attribute.getPropertyDescriptor(DESCRIPTION),
                this.description, null));
        properties.add(super.createProperty(Attribute.getPropertyDescriptor(MANDATORY),
                this.mandatory, null));
        properties
                .add(super.createProperty(Attribute.getPropertyDescriptor(TYPE), this.type, null));
        return properties;
    }

    @Override
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DESCRIPTION) && (property.getType() == Description.class))) {
            this.setDescription(((Description) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MANDATORY) && (property.getType() == Flag.class))) {
            this.setMandatory(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(TYPE) && (property.getType() == AttributeType.class))) {
            this.setType(((AttributeType) property.getInstance()));
            return true;
        }
        return false;
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
            if ((name == null)) {
                return;
            }
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
            if ((description == null)) {
                return;
            }
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
            if ((mandatory == null)) {
                return;
            }
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

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(Attribute.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(Attribute.class).getAllProperties();
    }
}
