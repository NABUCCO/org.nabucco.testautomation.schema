/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.search.config.model;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchViewModel;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;

/**
 * SchemaConfigSearchViewModel<p/>Search view for datatype SchemaConfig<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SchemaConfigSearchViewModel extends NabuccoComponentSearchViewModel<SchemaConfig>
        implements NabuccoComponentSearchParameter {

    public static final String ID = "org.nabucco.testautomation.schema.ui.search.config.SchemaConfigSearchViewModel";

    private SchemaConfig schemaConfig;

    public static final String PROPERTY_SCHEMACONFIG_NAME = "schemaConfigName";

    public static final String PROPERTY_SCHEMACONFIG_DESCRIPTION = "schemaConfigDescription";

    public static String TITLE = (ID + "Title");

    /**
     * Constructs a new SchemaConfigSearchViewModel instance.
     *
     * @param viewId the String.
     */
    public SchemaConfigSearchViewModel(String viewId) {
        super();
        correspondingListView = viewId;
        this.schemaConfig = new SchemaConfig();
    }

    @Override
    public String getSearchModelId() {
        return searchModelId;
    }

    @Override
    public NabuccoComponentSearchParameter getSearchParameter() {
        return this;
    }

    /**
     * Getter for the SchemaConfig.
     *
     * @return the SchemaConfig.
     */
    public SchemaConfig getSchemaConfig() {
        return this.schemaConfig;
    }

    /**
     * Setter for the SchemaConfigName.
     *
     * @param newName the String.
     */
    public void setSchemaConfigName(String newName) {
        if (((schemaConfig != null) && (schemaConfig.getName() == null))) {
            Name name = new Name();
            schemaConfig.setName(name);
        }
        String oldVal = schemaConfig.getName().getValue();
        schemaConfig.getName().setValue(newName);
        this.updateProperty(PROPERTY_SCHEMACONFIG_NAME, oldVal, newName);
        if (((!oldVal.equals(newName)) && schemaConfig.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
            schemaConfig.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the SchemaConfigName.
     *
     * @return the String.
     */
    public String getSchemaConfigName() {
        if ((((schemaConfig == null) || (schemaConfig.getName() == null)) || (schemaConfig
                .getName().getValue() == null))) {
            return "";
        }
        return schemaConfig.getName().getValue();
    }

    /**
     * Setter for the SchemaConfigDescription.
     *
     * @param newDescription the String.
     */
    public void setSchemaConfigDescription(String newDescription) {
        if (((schemaConfig != null) && (schemaConfig.getDescription() == null))) {
            Description description = new Description();
            schemaConfig.setDescription(description);
        }
        String oldVal = schemaConfig.getDescription().getValue();
        schemaConfig.getDescription().setValue(newDescription);
        this.updateProperty(PROPERTY_SCHEMACONFIG_DESCRIPTION, oldVal, newDescription);
        if (((!oldVal.equals(newDescription)) && schemaConfig.getDatatypeState().equals(
                DatatypeState.PERSISTENT))) {
            schemaConfig.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the SchemaConfigDescription.
     *
     * @return the String.
     */
    public String getSchemaConfigDescription() {
        if ((((schemaConfig == null) || (schemaConfig.getDescription() == null)) || (schemaConfig
                .getDescription().getValue() == null))) {
            return "";
        }
        return schemaConfig.getDescription().getValue();
    }

    @Override
    public String getId() {
        return SchemaConfigSearchViewModel.ID;
    }
}
