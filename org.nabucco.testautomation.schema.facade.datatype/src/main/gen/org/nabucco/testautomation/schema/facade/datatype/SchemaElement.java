/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.datatype;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
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
import org.nabucco.testautomation.facade.datatype.base.HierarchyLevelType;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.ScriptContainerType;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;

/**
 * SchemaElement<p/>A SchemaElement defining one instance of TestConfigElement<p/>
 *
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-08
 */
public class SchemaElement extends NabuccoDatatype implements Datatype {

    private static final long serialVersionUID = 1L;

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "l0,255;m1,1;",
            "l0,6;m1,1;", "l0,255;m0,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;",
            "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "m0,n;", "m0,n;" };

    public static final String LEVEL = "level";

    public static final String SCRIPTSALLOWED = "scriptsAllowed";

    public static final String NAME = "name";

    public static final String PREFIX = "prefix";

    public static final String DESCRIPTION = "description";

    public static final String PROPERTYCONTAINER = "propertyContainer";

    public static final String SKIPABLE = "skipable";

    public static final String HASDEPENDENCIES = "hasDependencies";

    public static final String DEFAULTDEPENDENCY = "defaultDependency";

    public static final String MANUALEXECUTIONALLOWED = "manualExecutionAllowed";

    public static final String JIRAEXPORT = "jiraExport";

    public static final String CLONECONTEXT = "cloneContext";

    public static final String SCHEMAELEMENTLIST = "schemaElementList";

    public static final String ATTRIBUTELIST = "attributeList";

    private HierarchyLevelType level;

    private ScriptContainerType scriptsAllowed;

    private Name name;

    private Name prefix;

    private Description description;

    private Flag propertyContainer;

    private Flag skipable;

    private Flag hasDependencies;

    private Flag defaultDependency;

    private Flag manualExecutionAllowed;

    private Flag jiraExport;

    private Flag cloneContext;

    private NabuccoList<SchemaElement> schemaElementList;

    private NabuccoList<Attribute> attributeList;

    /** Constructs a new SchemaElement instance. */
    public SchemaElement() {
        super();
        this.initDefaults();
    }

    /** InitDefaults. */
    private void initDefaults() {
    }

    /**
     * CloneObject.
     *
     * @param clone the SchemaElement.
     */
    protected void cloneObject(SchemaElement clone) {
        super.cloneObject(clone);
        clone.setLevel(this.getLevel());
        clone.setScriptsAllowed(this.getScriptsAllowed());
        if ((this.getName() != null)) {
            clone.setName(this.getName().cloneObject());
        }
        if ((this.getPrefix() != null)) {
            clone.setPrefix(this.getPrefix().cloneObject());
        }
        if ((this.getDescription() != null)) {
            clone.setDescription(this.getDescription().cloneObject());
        }
        if ((this.getPropertyContainer() != null)) {
            clone.setPropertyContainer(this.getPropertyContainer().cloneObject());
        }
        if ((this.getSkipable() != null)) {
            clone.setSkipable(this.getSkipable().cloneObject());
        }
        if ((this.getHasDependencies() != null)) {
            clone.setHasDependencies(this.getHasDependencies().cloneObject());
        }
        if ((this.getDefaultDependency() != null)) {
            clone.setDefaultDependency(this.getDefaultDependency().cloneObject());
        }
        if ((this.getManualExecutionAllowed() != null)) {
            clone.setManualExecutionAllowed(this.getManualExecutionAllowed().cloneObject());
        }
        if ((this.getJiraExport() != null)) {
            clone.setJiraExport(this.getJiraExport().cloneObject());
        }
        if ((this.getCloneContext() != null)) {
            clone.setCloneContext(this.getCloneContext().cloneObject());
        }
        if ((this.schemaElementList != null)) {
            clone.schemaElementList = this.schemaElementList.cloneCollection();
        }
        if ((this.attributeList != null)) {
            clone.attributeList = this.attributeList.cloneCollection();
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
     * Getter for the AttributeListJPA.
     *
     * @return the List<Attribute>.
     */
    List<Attribute> getAttributeListJPA() {
        if ((this.attributeList == null)) {
            this.attributeList = new NabuccoListImpl<Attribute>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoListImpl<Attribute>) this.attributeList).getDelegate();
    }

    /**
     * Setter for the AttributeListJPA.
     *
     * @param attributeList the List<Attribute>.
     */
    void setAttributeListJPA(List<Attribute> attributeList) {
        if ((this.attributeList == null)) {
            this.attributeList = new NabuccoListImpl<Attribute>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoListImpl<Attribute>) this.attributeList).setDelegate(attributeList);
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
        propertyMap.put(LEVEL, PropertyDescriptorSupport.createEnumeration(LEVEL,
                HierarchyLevelType.class, 2, PROPERTY_CONSTRAINTS[0], false));
        propertyMap.put(SCRIPTSALLOWED, PropertyDescriptorSupport.createEnumeration(SCRIPTSALLOWED,
                ScriptContainerType.class, 3, PROPERTY_CONSTRAINTS[1], false));
        propertyMap.put(NAME, PropertyDescriptorSupport.createBasetype(NAME, Name.class, 4,
                PROPERTY_CONSTRAINTS[2], false));
        propertyMap.put(PREFIX, PropertyDescriptorSupport.createBasetype(PREFIX, Name.class, 5,
                PROPERTY_CONSTRAINTS[3], false));
        propertyMap.put(DESCRIPTION, PropertyDescriptorSupport.createBasetype(DESCRIPTION,
                Description.class, 6, PROPERTY_CONSTRAINTS[4], false));
        propertyMap.put(PROPERTYCONTAINER, PropertyDescriptorSupport.createBasetype(
                PROPERTYCONTAINER, Flag.class, 7, PROPERTY_CONSTRAINTS[5], false));
        propertyMap.put(SKIPABLE, PropertyDescriptorSupport.createBasetype(SKIPABLE, Flag.class, 8,
                PROPERTY_CONSTRAINTS[6], false));
        propertyMap.put(HASDEPENDENCIES, PropertyDescriptorSupport.createBasetype(HASDEPENDENCIES,
                Flag.class, 9, PROPERTY_CONSTRAINTS[7], false));
        propertyMap.put(DEFAULTDEPENDENCY, PropertyDescriptorSupport.createBasetype(
                DEFAULTDEPENDENCY, Flag.class, 10, PROPERTY_CONSTRAINTS[8], false));
        propertyMap.put(MANUALEXECUTIONALLOWED, PropertyDescriptorSupport.createBasetype(
                MANUALEXECUTIONALLOWED, Flag.class, 11, PROPERTY_CONSTRAINTS[9], false));
        propertyMap.put(JIRAEXPORT, PropertyDescriptorSupport.createBasetype(JIRAEXPORT,
                Flag.class, 12, PROPERTY_CONSTRAINTS[10], false));
        propertyMap.put(CLONECONTEXT, PropertyDescriptorSupport.createBasetype(CLONECONTEXT,
                Flag.class, 13, PROPERTY_CONSTRAINTS[11], false));
        propertyMap.put(SCHEMAELEMENTLIST, PropertyDescriptorSupport.createCollection(
                SCHEMAELEMENTLIST, SchemaElement.class, 14, PROPERTY_CONSTRAINTS[12], false,
                PropertyAssociationType.COMPOSITION));
        propertyMap.put(ATTRIBUTELIST, PropertyDescriptorSupport.createCollection(ATTRIBUTELIST,
                Attribute.class, 15, PROPERTY_CONSTRAINTS[13], false,
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
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(LEVEL), this.level,
                null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(SCRIPTSALLOWED),
                this.scriptsAllowed, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(NAME), this.name,
                null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(PREFIX),
                this.prefix, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(DESCRIPTION),
                this.description, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(PROPERTYCONTAINER),
                this.propertyContainer, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(SKIPABLE),
                this.skipable, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(HASDEPENDENCIES),
                this.hasDependencies, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(DEFAULTDEPENDENCY),
                this.defaultDependency, null));
        properties.add(super.createProperty(
                SchemaElement.getPropertyDescriptor(MANUALEXECUTIONALLOWED),
                this.manualExecutionAllowed, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(JIRAEXPORT),
                this.jiraExport, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(CLONECONTEXT),
                this.cloneContext, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(SCHEMAELEMENTLIST),
                this.schemaElementList, null));
        properties.add(super.createProperty(SchemaElement.getPropertyDescriptor(ATTRIBUTELIST),
                this.attributeList, null));
        return properties;
    }

    @Override
    @SuppressWarnings("unchecked")
    public boolean setProperty(NabuccoProperty property) {
        if (super.setProperty(property)) {
            return true;
        }
        if ((property.getName().equals(LEVEL) && (property.getType() == HierarchyLevelType.class))) {
            this.setLevel(((HierarchyLevelType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SCRIPTSALLOWED) && (property.getType() == ScriptContainerType.class))) {
            this.setScriptsAllowed(((ScriptContainerType) property.getInstance()));
            return true;
        } else if ((property.getName().equals(NAME) && (property.getType() == Name.class))) {
            this.setName(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PREFIX) && (property.getType() == Name.class))) {
            this.setPrefix(((Name) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DESCRIPTION) && (property.getType() == Description.class))) {
            this.setDescription(((Description) property.getInstance()));
            return true;
        } else if ((property.getName().equals(PROPERTYCONTAINER) && (property.getType() == Flag.class))) {
            this.setPropertyContainer(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SKIPABLE) && (property.getType() == Flag.class))) {
            this.setSkipable(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(HASDEPENDENCIES) && (property.getType() == Flag.class))) {
            this.setHasDependencies(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(DEFAULTDEPENDENCY) && (property.getType() == Flag.class))) {
            this.setDefaultDependency(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(MANUALEXECUTIONALLOWED) && (property.getType() == Flag.class))) {
            this.setManualExecutionAllowed(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(JIRAEXPORT) && (property.getType() == Flag.class))) {
            this.setJiraExport(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(CLONECONTEXT) && (property.getType() == Flag.class))) {
            this.setCloneContext(((Flag) property.getInstance()));
            return true;
        } else if ((property.getName().equals(SCHEMAELEMENTLIST) && (property.getType() == SchemaElement.class))) {
            this.schemaElementList = ((NabuccoList<SchemaElement>) property.getInstance());
            return true;
        } else if ((property.getName().equals(ATTRIBUTELIST) && (property.getType() == Attribute.class))) {
            this.attributeList = ((NabuccoList<Attribute>) property.getInstance());
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
        final SchemaElement other = ((SchemaElement) obj);
        if ((this.level == null)) {
            if ((other.level != null))
                return false;
        } else if ((!this.level.equals(other.level)))
            return false;
        if ((this.scriptsAllowed == null)) {
            if ((other.scriptsAllowed != null))
                return false;
        } else if ((!this.scriptsAllowed.equals(other.scriptsAllowed)))
            return false;
        if ((this.name == null)) {
            if ((other.name != null))
                return false;
        } else if ((!this.name.equals(other.name)))
            return false;
        if ((this.prefix == null)) {
            if ((other.prefix != null))
                return false;
        } else if ((!this.prefix.equals(other.prefix)))
            return false;
        if ((this.description == null)) {
            if ((other.description != null))
                return false;
        } else if ((!this.description.equals(other.description)))
            return false;
        if ((this.propertyContainer == null)) {
            if ((other.propertyContainer != null))
                return false;
        } else if ((!this.propertyContainer.equals(other.propertyContainer)))
            return false;
        if ((this.skipable == null)) {
            if ((other.skipable != null))
                return false;
        } else if ((!this.skipable.equals(other.skipable)))
            return false;
        if ((this.hasDependencies == null)) {
            if ((other.hasDependencies != null))
                return false;
        } else if ((!this.hasDependencies.equals(other.hasDependencies)))
            return false;
        if ((this.defaultDependency == null)) {
            if ((other.defaultDependency != null))
                return false;
        } else if ((!this.defaultDependency.equals(other.defaultDependency)))
            return false;
        if ((this.manualExecutionAllowed == null)) {
            if ((other.manualExecutionAllowed != null))
                return false;
        } else if ((!this.manualExecutionAllowed.equals(other.manualExecutionAllowed)))
            return false;
        if ((this.jiraExport == null)) {
            if ((other.jiraExport != null))
                return false;
        } else if ((!this.jiraExport.equals(other.jiraExport)))
            return false;
        if ((this.cloneContext == null)) {
            if ((other.cloneContext != null))
                return false;
        } else if ((!this.cloneContext.equals(other.cloneContext)))
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        final int PRIME = 31;
        int result = super.hashCode();
        result = ((PRIME * result) + ((this.level == null) ? 0 : this.level.hashCode()));
        result = ((PRIME * result) + ((this.scriptsAllowed == null) ? 0 : this.scriptsAllowed
                .hashCode()));
        result = ((PRIME * result) + ((this.name == null) ? 0 : this.name.hashCode()));
        result = ((PRIME * result) + ((this.prefix == null) ? 0 : this.prefix.hashCode()));
        result = ((PRIME * result) + ((this.description == null) ? 0 : this.description.hashCode()));
        result = ((PRIME * result) + ((this.propertyContainer == null) ? 0 : this.propertyContainer
                .hashCode()));
        result = ((PRIME * result) + ((this.skipable == null) ? 0 : this.skipable.hashCode()));
        result = ((PRIME * result) + ((this.hasDependencies == null) ? 0 : this.hasDependencies
                .hashCode()));
        result = ((PRIME * result) + ((this.defaultDependency == null) ? 0 : this.defaultDependency
                .hashCode()));
        result = ((PRIME * result) + ((this.manualExecutionAllowed == null) ? 0
                : this.manualExecutionAllowed.hashCode()));
        result = ((PRIME * result) + ((this.jiraExport == null) ? 0 : this.jiraExport.hashCode()));
        result = ((PRIME * result) + ((this.cloneContext == null) ? 0 : this.cloneContext
                .hashCode()));
        return result;
    }

    @Override
    public SchemaElement cloneObject() {
        SchemaElement clone = new SchemaElement();
        this.cloneObject(clone);
        return clone;
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

    /**
     * Missing description at method setLevel.
     *
     * @param level the String.
     */
    public void setLevel(String level) {
        if ((level == null)) {
            this.level = null;
        } else {
            this.level = HierarchyLevelType.valueOf(level);
        }
    }

    /**
     * Missing description at method getScriptsAllowed.
     *
     * @return the ScriptContainerType.
     */
    public ScriptContainerType getScriptsAllowed() {
        return this.scriptsAllowed;
    }

    /**
     * Missing description at method setScriptsAllowed.
     *
     * @param scriptsAllowed the ScriptContainerType.
     */
    public void setScriptsAllowed(ScriptContainerType scriptsAllowed) {
        this.scriptsAllowed = scriptsAllowed;
    }

    /**
     * Missing description at method setScriptsAllowed.
     *
     * @param scriptsAllowed the String.
     */
    public void setScriptsAllowed(String scriptsAllowed) {
        if ((scriptsAllowed == null)) {
            this.scriptsAllowed = null;
        } else {
            this.scriptsAllowed = ScriptContainerType.valueOf(scriptsAllowed);
        }
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
     * Missing description at method getPrefix.
     *
     * @return the Name.
     */
    public Name getPrefix() {
        return this.prefix;
    }

    /**
     * Missing description at method setPrefix.
     *
     * @param prefix the Name.
     */
    public void setPrefix(Name prefix) {
        this.prefix = prefix;
    }

    /**
     * Missing description at method setPrefix.
     *
     * @param prefix the String.
     */
    public void setPrefix(String prefix) {
        if ((this.prefix == null)) {
            if ((prefix == null)) {
                return;
            }
            this.prefix = new Name();
        }
        this.prefix.setValue(prefix);
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
     * Missing description at method getPropertyContainer.
     *
     * @return the Flag.
     */
    public Flag getPropertyContainer() {
        return this.propertyContainer;
    }

    /**
     * Missing description at method setPropertyContainer.
     *
     * @param propertyContainer the Flag.
     */
    public void setPropertyContainer(Flag propertyContainer) {
        this.propertyContainer = propertyContainer;
    }

    /**
     * Missing description at method setPropertyContainer.
     *
     * @param propertyContainer the Boolean.
     */
    public void setPropertyContainer(Boolean propertyContainer) {
        if ((this.propertyContainer == null)) {
            if ((propertyContainer == null)) {
                return;
            }
            this.propertyContainer = new Flag();
        }
        this.propertyContainer.setValue(propertyContainer);
    }

    /**
     * Missing description at method getSkipable.
     *
     * @return the Flag.
     */
    public Flag getSkipable() {
        return this.skipable;
    }

    /**
     * Missing description at method setSkipable.
     *
     * @param skipable the Flag.
     */
    public void setSkipable(Flag skipable) {
        this.skipable = skipable;
    }

    /**
     * Missing description at method setSkipable.
     *
     * @param skipable the Boolean.
     */
    public void setSkipable(Boolean skipable) {
        if ((this.skipable == null)) {
            if ((skipable == null)) {
                return;
            }
            this.skipable = new Flag();
        }
        this.skipable.setValue(skipable);
    }

    /**
     * Missing description at method getHasDependencies.
     *
     * @return the Flag.
     */
    public Flag getHasDependencies() {
        return this.hasDependencies;
    }

    /**
     * Missing description at method setHasDependencies.
     *
     * @param hasDependencies the Flag.
     */
    public void setHasDependencies(Flag hasDependencies) {
        this.hasDependencies = hasDependencies;
    }

    /**
     * Missing description at method setHasDependencies.
     *
     * @param hasDependencies the Boolean.
     */
    public void setHasDependencies(Boolean hasDependencies) {
        if ((this.hasDependencies == null)) {
            if ((hasDependencies == null)) {
                return;
            }
            this.hasDependencies = new Flag();
        }
        this.hasDependencies.setValue(hasDependencies);
    }

    /**
     * Missing description at method getDefaultDependency.
     *
     * @return the Flag.
     */
    public Flag getDefaultDependency() {
        return this.defaultDependency;
    }

    /**
     * Missing description at method setDefaultDependency.
     *
     * @param defaultDependency the Flag.
     */
    public void setDefaultDependency(Flag defaultDependency) {
        this.defaultDependency = defaultDependency;
    }

    /**
     * Missing description at method setDefaultDependency.
     *
     * @param defaultDependency the Boolean.
     */
    public void setDefaultDependency(Boolean defaultDependency) {
        if ((this.defaultDependency == null)) {
            if ((defaultDependency == null)) {
                return;
            }
            this.defaultDependency = new Flag();
        }
        this.defaultDependency.setValue(defaultDependency);
    }

    /**
     * Missing description at method getManualExecutionAllowed.
     *
     * @return the Flag.
     */
    public Flag getManualExecutionAllowed() {
        return this.manualExecutionAllowed;
    }

    /**
     * Missing description at method setManualExecutionAllowed.
     *
     * @param manualExecutionAllowed the Flag.
     */
    public void setManualExecutionAllowed(Flag manualExecutionAllowed) {
        this.manualExecutionAllowed = manualExecutionAllowed;
    }

    /**
     * Missing description at method setManualExecutionAllowed.
     *
     * @param manualExecutionAllowed the Boolean.
     */
    public void setManualExecutionAllowed(Boolean manualExecutionAllowed) {
        if ((this.manualExecutionAllowed == null)) {
            if ((manualExecutionAllowed == null)) {
                return;
            }
            this.manualExecutionAllowed = new Flag();
        }
        this.manualExecutionAllowed.setValue(manualExecutionAllowed);
    }

    /**
     * Missing description at method getJiraExport.
     *
     * @return the Flag.
     */
    public Flag getJiraExport() {
        return this.jiraExport;
    }

    /**
     * Missing description at method setJiraExport.
     *
     * @param jiraExport the Flag.
     */
    public void setJiraExport(Flag jiraExport) {
        this.jiraExport = jiraExport;
    }

    /**
     * Missing description at method setJiraExport.
     *
     * @param jiraExport the Boolean.
     */
    public void setJiraExport(Boolean jiraExport) {
        if ((this.jiraExport == null)) {
            if ((jiraExport == null)) {
                return;
            }
            this.jiraExport = new Flag();
        }
        this.jiraExport.setValue(jiraExport);
    }

    /**
     * Missing description at method getCloneContext.
     *
     * @return the Flag.
     */
    public Flag getCloneContext() {
        return this.cloneContext;
    }

    /**
     * Missing description at method setCloneContext.
     *
     * @param cloneContext the Flag.
     */
    public void setCloneContext(Flag cloneContext) {
        this.cloneContext = cloneContext;
    }

    /**
     * Missing description at method setCloneContext.
     *
     * @param cloneContext the Boolean.
     */
    public void setCloneContext(Boolean cloneContext) {
        if ((this.cloneContext == null)) {
            if ((cloneContext == null)) {
                return;
            }
            this.cloneContext = new Flag();
        }
        this.cloneContext.setValue(cloneContext);
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
     * Missing description at method getAttributeList.
     *
     * @return the NabuccoList<Attribute>.
     */
    public NabuccoList<Attribute> getAttributeList() {
        if ((this.attributeList == null)) {
            this.attributeList = new NabuccoListImpl<Attribute>(NabuccoCollectionState.INITIALIZED);
        }
        return this.attributeList;
    }

    /**
     * Getter for the PropertyDescriptor.
     *
     * @param propertyName the String.
     * @return the NabuccoPropertyDescriptor.
     */
    public static NabuccoPropertyDescriptor getPropertyDescriptor(String propertyName) {
        return PropertyCache.getInstance().retrieve(SchemaElement.class).getProperty(propertyName);
    }

    /**
     * Getter for the PropertyDescriptorList.
     *
     * @return the List<NabuccoPropertyDescriptor>.
     */
    public static List<NabuccoPropertyDescriptor> getPropertyDescriptorList() {
        return PropertyCache.getInstance().retrieve(SchemaElement.class).getAllProperties();
    }
}
