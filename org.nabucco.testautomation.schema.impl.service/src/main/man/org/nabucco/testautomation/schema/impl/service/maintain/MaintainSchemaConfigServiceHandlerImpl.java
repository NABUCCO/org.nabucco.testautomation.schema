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
package org.nabucco.testautomation.schema.impl.service.maintain;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.framework.base.impl.service.maintain.PersistenceExceptionMapper;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.impl.service.SchemaCache;
import org.nabucco.testautomation.schema.impl.service.maintain.support.SchemaMaintainSupport;
import org.nabucco.testautomation.schema.impl.service.maintain.visitor.SchemaElementModificationVisitor;

/**
 * MaintainSchemaConfigServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class MaintainSchemaConfigServiceHandlerImpl extends MaintainSchemaConfigServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String PREFIX = "SCMA-";

    private SchemaMaintainSupport support;

    @Override
    public SchemaConfigMsg maintainSchemaConfig(SchemaConfigMsg msg) throws MaintainException {

        SchemaConfig schemaConfig = msg.getSchemaConfig();

        try {
            // initialize MaintainSupport
            this.support = new SchemaMaintainSupport(super.getPersistenceManager());

            if (schemaConfig.getDatatypeState() == DatatypeState.PERSISTENT) {
                DatatypeVisitor visitor = new SchemaElementModificationVisitor(schemaConfig);
                schemaConfig.accept(visitor);
            }

            switch (schemaConfig.getDatatypeState()) {

            case CONSTRUCTED:
                throw new MaintainException("SchemaConfig is not initialized.");
            case INITIALIZED:
                schemaConfig = this.create(schemaConfig);
                break;
            case MODIFIED:
                schemaConfig = this.update(schemaConfig);
                break;
            case DELETED:
                this.delete(schemaConfig);
                getLogger()
                        .info("SchemaConfig '" + schemaConfig.getName() + "' [" + schemaConfig.getId() + "] deleted");
                schemaConfig = null;
                break;
            case TRANSIENT:
                break;
            case PERSISTENT:
                break;
            default:
                throw new MaintainException("Datatype state '"
                        + schemaConfig.getDatatypeState() + "' is not valid for SchemaConfig.");
            }

            this.getPersistenceManager().flush();
            this.support = null;
        } catch (Exception ex) {
            throw new MaintainException("Error maintaining SchemaConfig", PersistenceExceptionMapper.resolve(ex,
                    SchemaConfig.class.getName(), schemaConfig.getId()));

        }

        if (schemaConfig != null) {
            load(schemaConfig);
            SchemaCache.getInstance().cacheSchemaConfig(schemaConfig);
            getLogger().info(
                    "SchemaConfig '"
                            + schemaConfig.getName() + "' [" + schemaConfig.getId() + "] successfully maintained");
        }

        msg.setSchemaConfig(schemaConfig);
        return msg;
    }

    private void load(SchemaConfig schemaConfig) {

        for (SchemaElement schemaElement : schemaConfig.getSchemaElementList()) {
            load(schemaElement);
        }
    }

    private void load(SchemaElement schemaElement) {

        for (SchemaElement child : schemaElement.getSchemaElementList()) {
            load(child);
        }

        SchemaCache.getInstance().cacheSchemaElement(schemaElement);
    }

    private SchemaConfig create(SchemaConfig entity) throws MaintainException {

        SchemaCache.getInstance().clear();
        List<SchemaElement> schemaElementList = entity.getSchemaElementList();

        for (int i = 0; i < schemaElementList.size(); i++) {
            SchemaElement updatedSchemaElement = create(schemaElementList.get(i));
            schemaElementList.set(i, updatedSchemaElement);
        }

        entity = this.support.maintain(entity);
        entity.setIdentificationKey(PREFIX + entity.getId());
        entity.setDatatypeState(DatatypeState.MODIFIED);
        entity = this.support.maintain(entity);
        return entity;
    }

    private SchemaElement create(SchemaElement entity) throws MaintainException {

        List<SchemaElement> schemaElementList = entity.getSchemaElementList();

        for (int i = 0; i < schemaElementList.size(); i++) {
            SchemaElement updatedSchemaElement = create(schemaElementList.get(i));
            schemaElementList.set(i, updatedSchemaElement);
        }

        List<Attribute> attributeList = entity.getAttributeList();

        for (int i = 0; i < attributeList.size(); i++) {
            Attribute attribute = create(attributeList.get(i));
            attributeList.set(i, attribute);
        }

        entity = this.support.maintain(entity);
        return entity;
    }

    private Attribute create(Attribute entity) throws MaintainException {

        entity = this.support.maintain(entity);
        return entity;
    }

    private SchemaConfig update(SchemaConfig entity) throws MaintainException {

        if (entity.getId() == null) {
            throw new IllegalArgumentException("SchemaConfig is not persistent.");
        }

        SchemaCache.getInstance().clear();
        List<SchemaElement> schemaElementList = entity.getSchemaElementList();
        List<SchemaElement> removedElements = NabuccoCollectionAccessor.getInstance().getUnassignedList(
                schemaElementList);

        // Create or update children
        for (int i = 0; i < schemaElementList.size(); i++) {
            SchemaElement updatedSchemaElement = update(schemaElementList.get(i));
            schemaElementList.set(i, updatedSchemaElement);
        }
        NabuccoCollectionAccessor.getInstance().clearAssignments(schemaElementList);

        // Delete removed SchemaElements
        for (SchemaElement schemaElement : removedElements) {
            delete(schemaElement);
        }

        // Update SchemaConfig
        entity = this.support.maintain(entity);
        return entity;
    }

    private SchemaElement update(SchemaElement entity) throws MaintainException {

        // Create or update children
        List<SchemaElement> schemaElementList = entity.getSchemaElementList();
        List<SchemaElement> removedElements = NabuccoCollectionAccessor.getInstance().getUnassignedList(
                schemaElementList);

        for (int i = 0; i < schemaElementList.size(); i++) {
            SchemaElement updatedSchemaElement = update(schemaElementList.get(i));
            schemaElementList.set(i, updatedSchemaElement);
        }
        NabuccoCollectionAccessor.getInstance().clearAssignments(schemaElementList);

        // Delete removed SchemaElements
        for (SchemaElement schemaElement : removedElements) {
            delete(schemaElement);
        }

        List<Attribute> attributeList = entity.getAttributeList();
        List<Attribute> removedAttributes = NabuccoCollectionAccessor.getInstance().getUnassignedList(attributeList);

        // Create or update Attributes
        for (int i = 0; i < attributeList.size(); i++) {
            Attribute attribute = update(attributeList.get(i));
            attributeList.set(i, attribute);
        }
        NabuccoCollectionAccessor.getInstance().clearAssignments(attributeList);

        // Delete removed Attributes
        for (Attribute attribute : removedAttributes) {
            delete(attribute);
        }

        entity = this.support.maintain(entity);
        return entity;
    }

    private Attribute update(Attribute entity) throws MaintainException {

        entity = this.support.maintain(entity);
        return entity;
    }

    private void delete(SchemaConfig entity) throws MaintainException {

        if (entity.getId() == null) {
            throw new IllegalArgumentException("SchemaConfig is not persistent.");
        }

        if (isInUse(entity)) {
            throw new MaintainException("Cannot delete SchemaConfig '"
                    + entity.getName().getValue() + "'. Already in use");
        }

        SchemaCache.getInstance().clear();

        // Delete children
        for (SchemaElement child : entity.getSchemaElementList()) {
            delete(child);
        }

        // Delete SchemaConfig
        entity = this.support.maintain(entity);
    }

    private void delete(SchemaElement entity) throws MaintainException {

        if (entity.getId() == null) {
            throw new IllegalArgumentException("SchemaElement is not persistent.");
        }

        if (isInUse(entity)) {
            throw new MaintainException("Cannot delete SchemaElement '"
                    + entity.getName().getValue() + "'. Already in use");
        }

        // Delete children
        for (SchemaElement child : entity.getSchemaElementList()) {
            delete(child);
        }

        // Delete Attributes
        for (Attribute attribute : entity.getAttributeList()) {
            delete(attribute);
        }

        entity.setDatatypeState(DatatypeState.DELETED);
        entity = this.support.maintain(entity);
    }

    private void delete(Attribute entity) throws MaintainException {

        if (entity.getId() == null) {
            throw new IllegalArgumentException("Attribute is not persistent.");
        }

        entity.setDatatypeState(DatatypeState.DELETED);
        entity = this.support.maintain(entity);
    }

    private boolean isInUse(SchemaConfig config) throws MaintainException {

        try {
            NabuccoQuery<Long> query = this.getPersistenceManager().createNativeQuery(
                    "SELECT id FROM conf_test_configuration WHERE schema_config_ref_id = :refId");
            query.setParameter("refId", config.getId());

            List<Long> result = query.getResultList();
            return !result.isEmpty();
        } catch (PersistenceException e) {
            throw new MaintainException(e);
        }
    }

    private boolean isInUse(SchemaElement element) throws MaintainException {

        try {
            NabuccoQuery<Long> query = this.getPersistenceManager().createNativeQuery(
                    "SELECT id FROM conf_test_config_element WHERE schema_element_ref_id = :refId");
            query.setParameter("refId", element.getId());

            List<Long> result = query.getResultList();
            return !result.isEmpty();
        } catch (PersistenceException e) {
            throw new MaintainException(e);
        }
    }

}
