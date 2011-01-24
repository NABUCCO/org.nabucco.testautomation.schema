/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.impl.service.search;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaConfig;

/**
 * SearchSchemaConfigImpl<p/>SchemaConfig search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SearchSchemaConfigImpl extends ServiceSupport implements SearchSchemaConfig {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchSchemaConfig";

    private EntityManager em;

    private SearchSchemaConfigServiceHandler searchSchemaConfigServiceHandler;

    /** Constructs a new SearchSchemaConfigImpl instance. */
    public SearchSchemaConfigImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.searchSchemaConfigServiceHandler = injector.inject(SearchSchemaConfigServiceHandler
                .getId());
        if ((this.searchSchemaConfigServiceHandler != null)) {
            this.searchSchemaConfigServiceHandler.setEntityManager(this.em);
            this.searchSchemaConfigServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<SchemaConfigListMsg> searchSchemaConfig(
            ServiceRequest<SchemaConfigSearchMsg> rq) throws SearchException {
        if ((this.searchSchemaConfigServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for searchSchemaConfig().");
            throw new InjectionException(
                    "No service implementation configured for searchSchemaConfig().");
        }
        ServiceResponse<SchemaConfigListMsg> rs;
        this.searchSchemaConfigServiceHandler.init();
        rs = this.searchSchemaConfigServiceHandler.invoke(rq);
        this.searchSchemaConfigServiceHandler.finish();
        return rs;
    }
}
