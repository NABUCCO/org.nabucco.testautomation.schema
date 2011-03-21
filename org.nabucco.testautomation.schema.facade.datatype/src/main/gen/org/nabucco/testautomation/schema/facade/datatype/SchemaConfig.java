/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoListImpl;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyContainer;
import org.nabucco.framework.base.facade.datatype.property.NabuccoPropertyDescriptor;
import org.nabucco.framework.base.facade.datatype.property.PropertyAssociationType;
import org.nabucco.framework.base.facade.datatype.property.PropertyCache;
import org.nabucco.framework.base.facade.datatype.property.PropertyDescriptorSupport;
import org.nabucco.testautomation.facade.datatype.base.ExportDatatype;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;

/**
 * SchemaConfig<p/>A configuration of a schema<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaConfig extends ExportDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "l0,255;m1,1;", "l0,255;m0,1;", "m0,n;" };

    public static final String NAME = "name";

    public static final String DESCRIPTION = "description";

    public static final String SCHEMAELEMENTLIST = "schemaElementList";

    private Name name;

    private Description description;

    private NabuccoList<SchemaElement> schemaElementList;

    /** Constructs a new SchemaConfig instance. */
    public SchemaConfig() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the SchemaConfig.
     */
    protected void cloneObject(SchemaConfig clone) {
        super.cloneObject(clone);
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getDescription() != null)) {
            clone.setDescription(this.getDescription().cloneObject());
        }
        if ((this.schemaElementList != null)) {
            clone.schemaElementList = this.schemaElementList.cloneCollection();
        }
    }

    /**
     * Getter for the SchemaElementListJPA.
     *
     * @return the List<SchemaElement>.
     */
    List<SchemaElement> getSchemaElementListJPA() {
        if ((this.schemaElementList == null)) {
            this.schemaElementList = new NabuccoListImpl<SchemaElement>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<SchemaElement>) this.schemaElementList).getDelegate();
    }

    /**
     * Setter for the SchemaElementListJPA.
     *
     * @param schemaElementList the List<SchemaElement>.
     */
    void setSchemaElementListJPA(List<SchemaElement> schemaElementList) {
        if ((this.schemaElementList == null)) {
            this.schemaElementList = new NabuccoListImpl<SchemaElement>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<SchemaElement>) this.schemaElementList).setDelegate(schemaElementList);
    }

    /**
     * CreatePropertyContainer.
     *
     * @return the NabuccoPropertyContainer.
     */
    protected static NabuccoPropertyContainer createPropertyContainer() {
        Map<String, NabuccoPropertyDescriptor> propertyMap = new HashMap<String, NabuccoPropertyDescriptor>();
        propertyMap.putAll(PropertyCache.getInstance().retrieve(ExportDatatype.class)
                .getPropertyMap());
        propertyMap.put(NAME, PropertyDescriptorSupport.createBasetype(NAME, Name.class, 4,
                PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(DESCRIPTION, PropertyDescriptorSupport.createBasetype(DESCRIPTION,
                Description.class, 5, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(SCHEMAELEMENTLIST, PropertyDescriptorSupport.createCollection(
                SCHEMAELEMENTLIST, SchemaElement.class, 6, PROPERTY_CONSTRAINTS[2], false,
                PropertyAssociationType.COMPOSITION));
        return new NabuccoPropertyContainer(propertyMap);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty> getProperties() {
        List<NabuccoProperty> properties = super.getProperties();
        properties.add(super.createProperty(SchemaConfig.getPropertyDescriptor(NAME), this.name,
                null));
        properties.add(super.createProperty(SchemaConfig.getPropertyDescriptor(DESCRIPTION),
                this.description, null));
        properties.add(super.createProperty(SchemaConfig.getPropertyDescriptor(SCHEMAELEMENTLIST),
                this.schemaElementList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
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
        } else if ((property.getName().equals(SCHEMAELEMENTLIST) && (property.getType() == SchemaElement.class))) {
            this.schemaElementList = ((NabuccoList<SchemaElement>) property.getInstance());
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
        final SchemaConfig other = ((SchemaConfig) obj);
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
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        return result;
    }

    @Override
    public SchemaConfig cloneObject() {
        SchemaConfig clone = new SchemaConfig();
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
     * Missing description at method getSchemaElementList.
     *
     * @return the NabuccoList<SchemaElement>.
     */
    public NabuccoList<SchemaElement> getSchemaElementList() {
        if ((this.schemaElementList == null)) {
            this.schemaElementList = new NabuccoListImpl<SchemaElement>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.schemaElementList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(SchemaConfig.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(SchemaConfig.class).getAllProperties();
    }
}
