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
package org.nabucco.testautomation.schema.impl.service.export;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.component.NabuccoInstance;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.exporting.ExportContainer;
import org.nabucco.framework.base.facade.datatype.serialization.SerializationException;
import org.nabucco.framework.base.facade.datatype.serialization.SerializationResult;
import org.nabucco.framework.base.facade.datatype.serialization.xml.XmlSerializer;
import org.nabucco.framework.base.facade.exception.exporting.ExportException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.exporting.ExportRs;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;

/**
 * ExportServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ExportServiceHandlerImpl extends ExportServiceHandler {

	private static final long serialVersionUID = 1L;
	
	@Override
	protected ExportRs export(EmptyServiceMessage msg)
			throws ExportException {

		ExportRs response = new ExportRs();
		response.setContainer(new ExportContainer());
		XmlSerializer xmlSerializer = new XmlSerializer();
		List<Datatype> entityList = new ArrayList<Datatype>();
		
		long start = System.currentTimeMillis();
		getLogger().info("Loading SchemaConfigs ...");
		
		Query query = this.getEntityManager().createQuery("FROM SchemaConfig c");
		
		@SuppressWarnings("unchecked")
		List<SchemaConfig> schemaList = query.getResultList();
		
		for (SchemaConfig schemaConfig : schemaList) {
			load(schemaConfig);
		}
		
		// Detach Entities
		this.getEntityManager().clear();
		
		// Set all SchemaConfigs to current Owner
		for (SchemaConfig schemaConfig : schemaList) {
			schemaConfig.setOwner(NabuccoInstance.getInstance().getOwner());
		}
		getLogger().info(schemaList.size() + " SchemaConfigs loaded. Duration: " + (System.currentTimeMillis() - start) + " ms");
		
		entityList.addAll(schemaList);
		
		try {
			start = System.currentTimeMillis();
			getLogger().info("Start serializing Schema ...");
			SerializationResult serializationResult = xmlSerializer.serialize(schemaList, XmlSerializer.DEFAULT_INDENT, true);
			response.getContainer().setResult(serializationResult.getContent());
			response.getContainer().setResourceData(serializationResult.getResourceContainer().toByteArray());
			getLogger().info("Serializing of Schema finished. Duration: " + (System.currentTimeMillis() - start) + " ms");
		} catch (SerializationException e) {
			throw new ExportException("Error during serialization");
		}
		
        return response;
	}
	
	private void load(SchemaConfig schemaConfig) {
		
		schemaConfig.setDatatypeState(DatatypeState.PERSISTENT);
		List<SchemaElement> schemaElements = schemaConfig.getSchemaElementList();
		
		for (SchemaElement schemaElement : schemaElements) {
			load(schemaElement);
		}
	}
	
	private void load(SchemaElement schemaElement) {
		
		schemaElement.setDatatypeState(DatatypeState.PERSISTENT);
		List<SchemaElement> schemaElements = schemaElement.getSchemaElementList();
		
		for (SchemaElement element : schemaElements) {
			load(element);
		}
		
		for (Attribute attribute : schemaElement.getAttributeList()) {
			attribute.setDatatypeState(DatatypeState.PERSISTENT);
		}
	}

}
