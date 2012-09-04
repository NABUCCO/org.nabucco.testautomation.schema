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
package org.nabucco.testautomation.schema.impl.service.search;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementSearchMsg;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchema;

/**
 * SearchSchemaImpl<p/>SchemaElement search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SearchSchemaImpl extends ServiceSupport implements SearchSchema {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchSchema";

    private static Map<String, String[]> ASPECTS;

    private SearchSchemaElementServiceHandler searchSchemaElementServiceHandler;

    private SearchSchemaConfigServiceHandler searchSchemaConfigServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new SearchSchemaImpl instance. */
    public SearchSchemaImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.searchSchemaElementServiceHandler = injector.inject(SearchSchemaElementServiceHandler.getId());
        if ((this.searchSchemaElementServiceHandler != null)) {
            this.searchSchemaElementServiceHandler.setPersistenceManager(persistenceManager);
            this.searchSchemaElementServiceHandler.setLogger(super.getLogger());
        }
        this.searchSchemaConfigServiceHandler = injector.inject(SearchSchemaConfigServiceHandler.getId());
        if ((this.searchSchemaConfigServiceHandler != null)) {
            this.searchSchemaConfigServiceHandler.setPersistenceManager(persistenceManager);
            this.searchSchemaConfigServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("searchSchemaElement", NO_ASPECTS);
            ASPECTS.put("searchSchemaConfig", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<SchemaElementListMsg> searchSchemaElement(ServiceRequest<SchemaElementSearchMsg> rq)
            throws SearchException {
        if ((this.searchSchemaElementServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchSchemaElement().");
            throw new InjectionException("No service implementation configured for searchSchemaElement().");
        }
        ServiceResponse<SchemaElementListMsg> rs;
        this.searchSchemaElementServiceHandler.init();
        rs = this.searchSchemaElementServiceHandler.invoke(rq);
        this.searchSchemaElementServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SchemaConfigListMsg> searchSchemaConfig(ServiceRequest<SchemaConfigSearchMsg> rq)
            throws SearchException {
        if ((this.searchSchemaConfigServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for searchSchemaConfig().");
            throw new InjectionException("No service implementation configured for searchSchemaConfig().");
        }
        ServiceResponse<SchemaConfigListMsg> rs;
        this.searchSchemaConfigServiceHandler.init();
        rs = this.searchSchemaConfigServiceHandler.invoke(rq);
        this.searchSchemaConfigServiceHandler.finish();
        return rs;
    }
}
