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
package org.nabucco.testautomation.schema.impl.service.search;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;
import org.nabucco.testautomation.schema.facade.message.SchemaElementListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementSearchMsg;
import org.nabucco.testautomation.schema.impl.service.SchemaCache;
import org.nabucco.testautomation.schema.impl.service.search.SearchSchemaElementServiceHandler;


/**
 * SearchSchemaElementServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SearchSchemaElementServiceHandlerImpl extends SearchSchemaElementServiceHandler {

	private static final long serialVersionUID = 1L;

	@Override
	public SchemaElementListMsg searchSchemaElement(SchemaElementSearchMsg msg)
			throws SearchException {
		
		// read SchemaElement from cache
		SchemaElementListMsg rs = new SchemaElementListMsg();
		SchemaElement cachedSchemaElement = null;
		
		if (msg.getId() != null && msg.getId().getValue() != null) {
			cachedSchemaElement = SchemaCache.getInstance()
					.getCachedSchemaElement(msg.getId().getValue());
		}
		
		if (cachedSchemaElement != null) {
			rs.getSchemaElementList().add(cachedSchemaElement);
			return rs;
		}
		
		// SchemaElement not cached -> Read SchemaElement from DB
		StringBuilder queryString = new StringBuilder();
		queryString.append("select s from SchemaElement s");

		List<String> filter = new ArrayList<String>();

		if (msg.getName() != null && msg.getName().getValue() != null) {
			filter.add("s.name = :name");
		}
		if (msg.getId() != null && msg.getId().getValue() != null) {
			filter.add("s.id = :id");
		}
		if (msg.getLevel() != null) {
			filter.add("s.level = :level");
		}

		// append filter criteria
		int filterSize = filter.size();

		if (filterSize > 0) {
			queryString.append(" WHERE ");
			int c = 1;
			for (String str : filter) {
				queryString.append(str);

				if (c++ < filterSize) {
					queryString.append(" AND ");
				}
			}
		}
		queryString.append(" order by s.name");

		Query query = super.getEntityManager().createQuery(
				queryString.toString());

		if (msg.getName() != null && msg.getName().getValue() != null) {
			query.setParameter("name", msg.getName().getValue());
		}
		if (msg.getId() != null && msg.getId().getValue() != null) {
			query.setParameter("id", msg.getId().getValue());
		}
		if (msg.getLevel() != null) {
			query.setParameter("level", msg.getLevel());
		}
		
		@SuppressWarnings("unchecked")
		List<SchemaElement> resultList = query.getResultList();

		for (SchemaElement schemaElement : resultList) {
			load(schemaElement);
			SchemaCache.getInstance().cacheSchemaElement(schemaElement);
			rs.getSchemaElementList().add(schemaElement);
		}
		return rs;
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
