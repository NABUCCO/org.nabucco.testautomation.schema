/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.datatype;

import java.util.List;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Flag;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoList;
import org.nabucco.framework.base.facade.datatype.property.BasetypeProperty;
import org.nabucco.framework.base.facade.datatype.property.EnumProperty;
import org.nabucco.framework.base.facade.datatype.property.ListProperty;
import org.nabucco.framework.base.facade.datatype.property.NabuccoProperty;
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

    private static final String[] PROPERTY_NAMES = { "level", "scriptsAllowed", "name", "prefix",
            "description", "propertyContainer", "skipable", "hasDependencies", "defaultDependency",
            "manualExecutionAllowed", "jiraExport", "schemaElementList", "attributeList" };

    private static final String[] PROPERTY_CONSTRAINTS = { "m1,1;", "m1,1;", "l0,n;m1,1;",
            "l0,6;m1,1;", "l0,n;m0,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;", "l0,n;m1,1;",
            "l0,n;m1,1;", "l0,n;m1,1;", "m0,n;", "m0,n;" };

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

    private List<SchemaElement> schemaElementList;

    private List<Attribute> attributeList;

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
        if ((this.schemaElementList instanceof NabuccoList<?>)) {
            clone.schemaElementList = ((NabuccoList<SchemaElement>) this.schemaElementList)
                    .cloneCollection();
        }
        if ((this.attributeList instanceof NabuccoList<?>)) {
            clone.attributeList = ((NabuccoList<Attribute>) this.attributeList).cloneCollection();
        }
    }

    /**
     * Getter for the SchemaElementListJPA.
     *
     * @return the List<SchemaElement>.
     */
    List<SchemaElement> getSchemaElementListJPA() {
        if ((this.schemaElementList == null)) {
            this.schemaElementList = new NabuccoList<SchemaElement>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<SchemaElement>) this.schemaElementList).getDelegate();
    }

    /**
     * Setter for the SchemaElementListJPA.
     *
     * @param schemaElementList the List<SchemaElement>.
     */
    void setSchemaElementListJPA(List<SchemaElement> schemaElementList) {
        if ((this.schemaElementList == null)) {
            this.schemaElementList = new NabuccoList<SchemaElement>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<SchemaElement>) this.schemaElementList).setDelegate(schemaElementList);
    }

    /**
     * Getter for the AttributeListJPA.
     *
     * @return the List<Attribute>.
     */
    List<Attribute> getAttributeListJPA() {
        if ((this.attributeList == null)) {
            this.attributeList = new NabuccoList<Attribute>(NabuccoCollectionState.LAZY);
        }
        return ((NabuccoList<Attribute>) this.attributeList).getDelegate();
    }

    /**
     * Setter for the AttributeListJPA.
     *
     * @param attributeList the List<Attribute>.
     */
    void setAttributeListJPA(List<Attribute> attributeList) {
        if ((this.attributeList == null)) {
            this.attributeList = new NabuccoList<Attribute>(NabuccoCollectionState.LAZY);
        }
        ((NabuccoList<Attribute>) this.attributeList).setDelegate(attributeList);
    }

    @Override
    public void init() {
        this.initDefaults();
    }

    @Override
    public List<NabuccoProperty<?>> getProperties() {
        List<NabuccoProperty<?>> properties = super.getProperties();
        properties.add(new EnumProperty<HierarchyLevelType>(PROPERTY_NAMES[0],
                HierarchyLevelType.class, PROPERTY_CONSTRAINTS[0], this.level));
        properties.add(new EnumProperty<ScriptContainerType>(PROPERTY_NAMES[1],
                ScriptContainerType.class, PROPERTY_CONSTRAINTS[1], this.scriptsAllowed));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[2], Name.class,
                PROPERTY_CONSTRAINTS[2], this.name));
        properties.add(new BasetypeProperty<Name>(PROPERTY_NAMES[3], Name.class,
                PROPERTY_CONSTRAINTS[3], this.prefix));
        properties.add(new BasetypeProperty<Description>(PROPERTY_NAMES[4], Description.class,
                PROPERTY_CONSTRAINTS[4], this.description));
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[5], Flag.class,
                PROPERTY_CONSTRAINTS[5], this.propertyContainer));
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[6], Flag.class,
                PROPERTY_CONSTRAINTS[6], this.skipable));
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[7], Flag.class,
                PROPERTY_CONSTRAINTS[7], this.hasDependencies));
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[8], Flag.class,
                PROPERTY_CONSTRAINTS[8], this.defaultDependency));
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[9], Flag.class,
                PROPERTY_CONSTRAINTS[9], this.manualExecutionAllowed));
        properties.add(new BasetypeProperty<Flag>(PROPERTY_NAMES[10], Flag.class,
                PROPERTY_CONSTRAINTS[10], this.jiraExport));
        properties.add(new ListProperty<SchemaElement>(PROPERTY_NAMES[11], SchemaElement.class,
                PROPERTY_CONSTRAINTS[11], this.schemaElementList));
        properties.add(new ListProperty<Attribute>(PROPERTY_NAMES[12], Attribute.class,
                PROPERTY_CONSTRAINTS[12], this.attributeList));
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
        return result;
    }

    @Override
    public String toString() {
        StringBuilder appendable = new StringBuilder();
        appendable.append("<SchemaElement>\n");
        appendable.append(super.toString());
        appendable.append((("<level>" + this.level) + "</level>\n"));
        appendable.append((("<scriptsAllowed>" + this.scriptsAllowed) + "</scriptsAllowed>\n"));
        appendable.append((("<name>" + this.name) + "</name>\n"));
        appendable.append((("<prefix>" + this.prefix) + "</prefix>\n"));
        appendable.append((("<description>" + this.description) + "</description>\n"));
        appendable
                .append((("<propertyContainer>" + this.propertyContainer) + "</propertyContainer>\n"));
        appendable.append((("<skipable>" + this.skipable) + "</skipable>\n"));
        appendable.append((("<hasDependencies>" + this.hasDependencies) + "</hasDependencies>\n"));
        appendable
                .append((("<defaultDependency>" + this.defaultDependency) + "</defaultDependency>\n"));
        appendable
                .append((("<manualExecutionAllowed>" + this.manualExecutionAllowed) + "</manualExecutionAllowed>\n"));
        appendable.append((("<jiraExport>" + this.jiraExport) + "</jiraExport>\n"));
        appendable.append("</SchemaElement>\n");
        return appendable.toString();
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
            this.jiraExport = new Flag();
        }
        this.jiraExport.setValue(jiraExport);
    }

    /**
     * Missing description at method getSchemaElementList.
     *
     * @return the List<SchemaElement>.
     */
    public List<SchemaElement> getSchemaElementList() {
        if ((this.schemaElementList == null)) {
            this.schemaElementList = new NabuccoList<SchemaElement>(
                    NabuccoCollectionState.INITIALIZED);
        }
        return this.schemaElementList;
    }

    /**
     * Missing description at method getAttributeList.
     *
     * @return the List<Attribute>.
     */
    public List<Attribute> getAttributeList() {
        if ((this.attributeList == null)) {
            this.attributeList = new NabuccoList<Attribute>(NabuccoCollectionState.INITIALIZED);
        }
        return this.attributeList;
    }
}
