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
package org.nabucco.testautomation.schema.impl.service.importing;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.NabuccoDatatype;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.datatype.importing.ImportContext;
import org.nabucco.framework.base.facade.datatype.importing.ImportContextEntry;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLogger;
import org.nabucco.framework.base.facade.datatype.logger.NabuccoLoggingFactory;
import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.testautomation.facade.service.importing.BasicImporter;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;

/**
 * SchemaImporter
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SchemaImporter extends BasicImporter {

	private final NabuccoLogger logger = NabuccoLoggingFactory.getInstance()
			.getLogger(SchemaImporter.class);
	
	/**
	 * @param em
	 * @param importContext
	 */
	public SchemaImporter(EntityManager em, ImportContext importContext) {
		super(em, importContext);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected List<ImportContextEntry> importAll(List<Datatype> datatypes)
			throws ImportException {
		
		List<ImportContextEntry> importedElements = new ArrayList<ImportContextEntry>();

		for (Datatype current : datatypes) {
			
			if (current instanceof SchemaConfig) {
				importedElements.add(super.maintain((NabuccoDatatype) current));
				logger.info("SchemaConfig '", ((SchemaConfig) current).getIdentificationKey().getValue(), "' imported");
			} else if (current instanceof SchemaElement
					|| current instanceof Attribute) {
				importedElements.add(super.maintain((NabuccoDatatype) current));
			}
		}
		return importedElements;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	protected void deleteAll(Owner owner) throws ImportException {
		
		// Find all SchemaConfigs for the importing owner
		Query query = this.getEntityManager().createQuery("FROM SchemaConfig c WHERE c.owner = :owner");
		query.setParameter("owner", owner);
		
		@SuppressWarnings("unchecked")
		List<SchemaConfig> schemaList = query.getResultList();
		
		for (SchemaConfig schema : schemaList) {
			delete(schema);
		}
	}
	
	private void delete(SchemaConfig schema) throws ImportException {
		
		// Delete SchemaElements
		for (SchemaElement schemaElement : schema.getSchemaElementList()) {
			delete(schemaElement);
		}
		
		try {
			// Delete SchemaConfig
			super.delete(schema);
			logger.info("SchemaConfig '", schema.getIdentificationKey().getValue(), "' deleted");
		} catch (PersistenceException ex) {
			throw new ImportException(ex);
		}
	}
	
	private void delete(SchemaElement schemaElement) throws ImportException {
		
		// Delete children
		for (SchemaElement child : schemaElement.getSchemaElementList()) {
			delete(child);
		}
		
		try {
			// Delete all contained Attributes
			for (Attribute attribute : schemaElement.getAttributeList()) {
				super.delete(attribute);
			}
			
			// Delete SchemaElement
			super.delete(schemaElement);
		} catch (PersistenceException ex) {
			throw new ImportException(ex);
		}
	}

}
