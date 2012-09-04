/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.schema.ui.rcp.edit.schemaconfig.model;

import java.io.Serializable;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.plugin.base.logging.Loggable;
import org.nabucco.framework.plugin.base.model.ViewModel;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;


/**
 * SchemaConfigEditViewModel<p/>Edit view for datatype SchemaConfig<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-12
 */
public class SchemaConfigEditViewModel extends ViewModel implements Loggable {

    private SchemaConfig schemaConfig;

    public static final String PROPERTY_SCHEMACONFIG_NAME = "schemaConfigName";

    public static final String PROPERTY_SCHEMACONFIG_DESCRIPTION = "schemaConfigDescription";

    /** Constructs a new SchemaConfigEditViewModel instance. */
    public SchemaConfigEditViewModel() {
        super();
    }

    /**
     * Getter for the ID.
     *
     * @return the String.
     */
    public String getID() {
        return "org.nabucco.testautomation.schema.ui.rcp.edit.schemaconfig.model.SchemaConfigEditViewModel";
    }

    /**
     * Getter for the Values.
     *
     * @return the Map<String, Serializable>.
     */
    public Map<String, Serializable> getValues() {
        Map<String, Serializable> result = super.getValues();
        result.put(PROPERTY_SCHEMACONFIG_DESCRIPTION, this.getSchemaConfigDescription());
        result.put(PROPERTY_SCHEMACONFIG_NAME, this.getSchemaConfigName());
        return result;
    }

    /**
     * Setter for the SchemaConfig.
     *
     * @param newValue the SchemaConfig.
     */
    public void setSchemaConfig(SchemaConfig newValue) {
        SchemaConfig oldValue = this.schemaConfig;
        this.schemaConfig = newValue;
        this.updateProperty(PROPERTY_SCHEMACONFIG_DESCRIPTION,
                ((oldValue != null) ? oldValue.getDescription() : ""),
                ((newValue != null) ? newValue.getDescription() : ""));
        this.updateProperty(PROPERTY_SCHEMACONFIG_NAME, ((oldValue != null) ? oldValue.getName()
                : ""), ((newValue != null) ? newValue.getName() : ""));
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
        if (((schemaConfig != null) || (schemaConfig.getName() == null))) {
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
        if (((schemaConfig != null) || (schemaConfig.getDescription() == null))) {
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
}
