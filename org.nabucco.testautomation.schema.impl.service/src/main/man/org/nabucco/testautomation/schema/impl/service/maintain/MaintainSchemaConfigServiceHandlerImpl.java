/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/
package org.nabucco.testautomation.schema.impl.service.maintain;

import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.collection.NabuccoCollectionAccessor;
import org.nabucco.framework.base.facade.datatype.visitor.DatatypeVisitor;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceExceptionMapper;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.impl.service.maintain.PersistenceHelper;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.impl.service.SchemaCache;
import org.nabucco.testautomation.schema.impl.service.maintain.MaintainSchemaConfigServiceHandler;
import org.nabucco.testautomation.schema.impl.service.maintain.visitor.SchemaElementModificationVisitor;


/**
 * MaintainSchemaConfigServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class MaintainSchemaConfigServiceHandlerImpl extends	MaintainSchemaConfigServiceHandler {

	private static final long serialVersionUID = 1L;
	
	private static final String PREFIX = "SCMA-";
	
	private PersistenceHelper persistenceHelper;
	
	@Override
	public SchemaConfigMsg maintainSchemaConfig(SchemaConfigMsg msg)
			throws MaintainException {

		SchemaConfig schemaConfig = msg.getSchemaConfig();
		
		try {
			// initialize PersistenceHelper
			this.persistenceHelper = new PersistenceHelper(super.getEntityManager());

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
                schemaConfig = null;
                break;
            case TRANSIENT:
                break;
            case PERSISTENT:
                break;
            default:
                throw new MaintainException("Datatype state '"
                        + schemaConfig.getDatatypeState()
                        + "' is not valid for SchemaConfig.");
            }
        } catch (Exception ex) {
			throw new MaintainException("Error maintaining SchemaConfig",
					PersistenceExceptionMapper.resolve(ex,
							SchemaConfig.class.getName(),
							schemaConfig.getId()));

        }
        
        this.persistenceHelper.flush();
        this.persistenceHelper = null;
        
        if (schemaConfig != null) {
        	load(schemaConfig);
        	SchemaCache.getInstance().cacheSchemaConfig(schemaConfig);
        }
        
        msg.setSchemaConfig(schemaConfig);
		return msg;
	}
	
	private void load(SchemaConfig schemaConfig) {
		
		for (SchemaElement schemaElement : schemaConfig.getSchemaElementList()) {
			load(schemaElement);
		}
		schemaConfig.setDatatypeState(DatatypeState.PERSISTENT);
	}
	
	private void load(SchemaElement schemaElement) {
		
		for (SchemaElement child : schemaElement.getSchemaElementList()) {
			load(child);
		}
		
		for (Attribute attribute : schemaElement.getAttributeList()) {
			attribute.setDatatypeState(DatatypeState.PERSISTENT);
		}
		
		schemaElement.setDatatypeState(DatatypeState.PERSISTENT);
    	SchemaCache.getInstance().cacheSchemaElement(schemaElement);
	}

	private SchemaConfig create(SchemaConfig entity)
			throws PersistenceException {
		
		SchemaCache.getInstance().clear();
		List<SchemaElement> schemaElementList = entity.getSchemaElementList();
		
		for (int i = 0; i < schemaElementList.size(); i++) {
			SchemaElement updatedSchemaElement = create(schemaElementList.get(i));
			schemaElementList.set(i, updatedSchemaElement);
		}
		
		if (entity.getOwner() == null || entity.getOwner().getValue() == null
				|| entity.getOwner().getValue().equals("")) {
			entity.setOwner(NabuccoInstance.getInstance().getOwner());
		}
		
		entity = this.persistenceHelper.persist(entity);
		entity.setIdentificationKey(PREFIX + entity.getId());
        entity.setDatatypeState(DatatypeState.MODIFIED);
        entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private SchemaElement create(SchemaElement entity)
			throws PersistenceException {

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
		
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private Attribute create(Attribute entity) 
			throws PersistenceException {
		
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private SchemaConfig update(SchemaConfig entity)
			throws PersistenceException {
		
		if (entity.getId() == null) {
            throw new IllegalArgumentException("SchemaConfig is not persistent.");
        }
		
		SchemaCache.getInstance().clear();
		List<SchemaElement> schemaElementList = entity.getSchemaElementList();
		List<SchemaElement> removedElements = NabuccoCollectionAccessor.getInstance().getUnassignedList(schemaElementList);
		
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
		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private SchemaElement update(SchemaElement entity)
			throws PersistenceException {

		// Create or update children
		List<SchemaElement> schemaElementList = entity.getSchemaElementList();
		List<SchemaElement> removedElements = NabuccoCollectionAccessor.getInstance().getUnassignedList(schemaElementList);

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

		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private Attribute update(Attribute entity) throws PersistenceException {

		entity = this.persistenceHelper.persist(entity);
		return entity;
	}
	
	private void delete(SchemaConfig entity)
			throws PersistenceException {

		if (entity.getId() == null) {
			throw new IllegalArgumentException(
					"SchemaConfig is not persistent.");
		}
		
		if (isInUse(entity)) {
			throw new PersistenceException("Cannot delete SchemaConfig '"
					+ entity.getName().getValue() + "'. Already in use");
		}
		
		SchemaCache.getInstance().clear();
		
		// Delete children
		for (SchemaElement child : entity.getSchemaElementList()){
			delete(child);
		}
		
		// Delete SchemaConfig
		entity = this.persistenceHelper.persist(entity);
	}
	
	private void delete(SchemaElement entity)
			throws PersistenceException {

		if (entity.getId() == null) {
			throw new IllegalArgumentException(
					"SchemaElement is not persistent.");
		}
		
		if (isInUse(entity)) {
			throw new PersistenceException("Cannot delete SchemaElement '"
					+ entity.getName().getValue() + "'. Already in use");
		}
		
		// Delete children
		for (SchemaElement child : entity.getSchemaElementList()){
			delete(child);
		}
		
		// Delete Attributes
		for (Attribute attribute : entity.getAttributeList()) {
			delete(attribute);
		}
		
		entity.setDatatypeState(DatatypeState.DELETED);
		entity = this.persistenceHelper.persist(entity);
	}
	
	private void delete(Attribute entity) throws PersistenceException {

		if (entity.getId() == null) {
			throw new IllegalArgumentException(
					"Attribute is not persistent.");
		}
		
		entity.setDatatypeState(DatatypeState.DELETED);
		entity = this.persistenceHelper.persist(entity);
	}
	
	private boolean isInUse(SchemaConfig config) {
		
		Query query = this.getEntityManager().createNativeQuery("SELECT id FROM conf_test_configuration WHERE schema_config_ref_id = :refId");
		query.setParameter("refId", config.getId());
		
		@SuppressWarnings("rawtypes")
		List result = query.getResultList();
		return !result.isEmpty();		
	}
	
	private boolean isInUse(SchemaElement element) {
		
		Query query = this.getEntityManager().createNativeQuery("SELECT id FROM conf_test_config_element WHERE schema_element_ref_id = :refId");
		query.setParameter("refId", element.getId());
		
		@SuppressWarnings("rawtypes")
		List result = query.getResultList();
		return !result.isEmpty();
	}

}
