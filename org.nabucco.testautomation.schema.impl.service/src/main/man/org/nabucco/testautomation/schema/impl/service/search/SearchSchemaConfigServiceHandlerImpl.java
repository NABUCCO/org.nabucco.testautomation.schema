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
package org.nabucco.testautomation.schema.impl.service.search;

import java.util.ArrayList;
import java.util.List;

import org.nabucco.framework.base.facade.exception.persistence.PersistenceException;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.impl.service.maintain.NabuccoQuery;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;
import org.nabucco.testautomation.schema.impl.service.SchemaCache;

/**
 * SearchSchemaConfigServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SearchSchemaConfigServiceHandlerImpl extends SearchSchemaConfigServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    public SchemaConfigListMsg searchSchemaConfig(SchemaConfigSearchMsg msg) throws SearchException {

        // read SchemaConfig from cache
        SchemaConfigListMsg rs = new SchemaConfigListMsg();
        SchemaConfig cachedSchemaConfig = null;

        if (msg.getId() != null && msg.getId().getValue() != null) {
            cachedSchemaConfig = SchemaCache.getInstance().getCachedSchemaConfig(msg.getId().getValue());
        }

        if (cachedSchemaConfig != null) {
            rs.getSchemaConfigList().add(cachedSchemaConfig);
            return rs;
        }

        // SchemaConfig not cached -> Read SchemaConfig from DB
        StringBuilder queryString = new StringBuilder();
        queryString.append("FROM SchemaConfig s");

        List<String> filter = new ArrayList<String>();

        if (msg.getName() != null && msg.getName().getValue() != null) {
            filter.add("s.name LIKE '" + msg.getName().getValue() + "%'");
        }

        if (msg.getId() != null && msg.getId().getValue() != null) {
            filter.add("s.id = :id");
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
        queryString.append(" ORDER BY s.name");

        try {
            NabuccoQuery<SchemaConfig> query = super.getPersistenceManager().createQuery(queryString.toString());

            if (msg.getId() != null && msg.getId().getValue() != null) {
                query.setParameter("id", msg.getId().getValue());
            }

            List<SchemaConfig> resultList = query.getResultList();

            for (SchemaConfig schemaConfig : resultList) {
                load(schemaConfig);
                SchemaCache.getInstance().cacheSchemaConfig(schemaConfig);
                rs.getSchemaConfigList().add(schemaConfig);
            }
            return rs;
        } catch (PersistenceException e) {
            throw new SearchException("Error while searching for SchemaConfig", e);
        }
    }

    private void load(SchemaConfig schemaConfig) {

        List<SchemaElement> schemaElements = schemaConfig.getSchemaElementList();

        for (SchemaElement schemaElement : schemaElements) {
            load(schemaElement);
        }
    }

    private void load(SchemaElement schemaElement) {

        List<SchemaElement> schemaElements = schemaElement.getSchemaElementList();

        for (SchemaElement element : schemaElements) {
            load(element);
        }
    }

}
