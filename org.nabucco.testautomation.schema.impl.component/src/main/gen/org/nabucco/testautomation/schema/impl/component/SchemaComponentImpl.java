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
package org.nabucco.testautomation.schema.impl.component;

import org.nabucco.framework.base.facade.component.handler.PostConstructHandler;
import org.nabucco.framework.base.facade.component.handler.PreDestroyHandler;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.framework.base.impl.component.ComponentSupport;
import org.nabucco.testautomation.schema.facade.component.SchemaComponentLocal;
import org.nabucco.testautomation.schema.facade.component.SchemaComponentRemote;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchema;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchema;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchema;

/**
 * SchemaComponentImpl<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaComponentImpl extends ComponentSupport implements SchemaComponentLocal, SchemaComponentRemote {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SchemaComponent";

    /** Constructs a new SchemaComponentImpl instance. */
    public SchemaComponentImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PostConstructHandler handler = injector.inject(PostConstructHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No post construct handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PreDestroyHandler handler = injector.inject(PreDestroyHandler.getId());
        if ((handler == null)) {
            if (super.getLogger().isDebugEnabled()) {
                super.getLogger().debug("No pre destroy handler configured for \'", ID, "\'.");
            }
            return;
        }
        handler.setLocatable(this);
        handler.setLogger(super.getLogger());
        handler.invoke();
    }

    @Override
    public String getId() {
        return ID;
    }

    @Override
    public String getName() {
        return COMPONENT_NAME;
    }

    @Override
    public String getJndiName() {
        return JNDI_NAME;
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.COMPONENT_RELATION_SERVICE_REMOTE, ComponentRelationService.class);
    }

    @Override
    public ComponentRelationService getComponentRelationServiceLocal() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.COMPONENT_RELATION_SERVICE_LOCAL, ComponentRelationService.class);
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.QUERY_FILTER_SERVICE_REMOTE, QueryFilterService.class);
    }

    @Override
    public QueryFilterService getQueryFilterServiceLocal() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.QUERY_FILTER_SERVICE_LOCAL, QueryFilterService.class);
    }

    @Override
    public MaintainSchema getMaintainSchemaLocal() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.MAINTAIN_SCHEMA_LOCAL, MaintainSchema.class);
    }

    @Override
    public MaintainSchema getMaintainSchema() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.MAINTAIN_SCHEMA_REMOTE, MaintainSchema.class);
    }

    @Override
    public ProduceSchema getProduceSchemaLocal() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.PRODUCE_SCHEMA_LOCAL, ProduceSchema.class);
    }

    @Override
    public ProduceSchema getProduceSchema() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.PRODUCE_SCHEMA_REMOTE, ProduceSchema.class);
    }

    @Override
    public SearchSchema getSearchSchemaLocal() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.SEARCH_SCHEMA_LOCAL, SearchSchema.class);
    }

    @Override
    public SearchSchema getSearchSchema() throws ServiceException {
        return super.lookup(SchemaComponentJndiNames.SEARCH_SCHEMA_REMOTE, SearchSchema.class);
    }
}
