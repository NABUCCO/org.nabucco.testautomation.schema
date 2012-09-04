/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.schema.ui.rcp.search.config.model;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Key;
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
public class SchemaConfigSearchViewModel extends NabuccoComponentSearchViewModel<SchemaConfig> implements
        NabuccoComponentSearchParameter {

    public static final String ID = "org.nabucco.testautomation.schema.ui.search.config.SchemaConfigSearchViewModel";

    private SchemaConfig schemaConfig;

    public static final String PROPERTY_SCHEMACONFIG_NAME = "schemaConfigName";

    public static final String PROPERTY_SCHEMACONFIG_IDENTIFICATIONKEY = "schemaConfigIdentificationKey";

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
        if (((!oldVal.equals(newName)) && schemaConfig.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            schemaConfig.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the SchemaConfigName.
     *
     * @return the String.
     */
    public String getSchemaConfigName() {
        if ((((schemaConfig == null) || (schemaConfig.getName() == null)) || (schemaConfig.getName().getValue() == null))) {
            return "";
        }
        return schemaConfig.getName().getValue();
    }

    /**
     * Setter for the SchemaConfigIdentificationKey.
     *
     * @param newIdentificationKey the String.
     */
    public void setSchemaConfigIdentificationKey(String newIdentificationKey) {
        if (((schemaConfig != null) && (schemaConfig.getIdentificationKey() == null))) {
            Key identificationKey = new Key();
            schemaConfig.setIdentificationKey(identificationKey);
        }
        String oldVal = schemaConfig.getIdentificationKey().getValue();
        schemaConfig.getIdentificationKey().setValue(newIdentificationKey);
        this.updateProperty(PROPERTY_SCHEMACONFIG_IDENTIFICATIONKEY, oldVal, newIdentificationKey);
        if (((!oldVal.equals(newIdentificationKey)) && schemaConfig.getDatatypeState().equals(DatatypeState.PERSISTENT))) {
            schemaConfig.setDatatypeState(DatatypeState.MODIFIED);
        }
    }

    /**
     * Getter for the SchemaConfigIdentificationKey.
     *
     * @return the String.
     */
    public String getSchemaConfigIdentificationKey() {
        if ((((schemaConfig == null) || (schemaConfig.getIdentificationKey() == null)) || (schemaConfig
                .getIdentificationKey().getValue() == null))) {
            return "";
        }
        return schemaConfig.getIdentificationKey().getValue();
    }

    @Override
    public String getId() {
        return SchemaConfigSearchViewModel.ID;
    }
}
