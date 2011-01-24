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
import org.nabucco.testautomation.schema.facade.message.SchemaElementListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementSearchMsg;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaElement;

/**
 * SearchSchemaElementImpl<p/>SchemaElement search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SearchSchemaElementImpl extends ServiceSupport implements SearchSchemaElement {

    private static final long serialVersionUID = 1L;

    private static final String ID = "SearchSchemaElement";

    private EntityManager em;

    private SearchSchemaElementServiceHandler searchSchemaElementServiceHandler;

    /** Constructs a new SearchSchemaElementImpl instance. */
    public SearchSchemaElementImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.searchSchemaElementServiceHandler = injector.inject(SearchSchemaElementServiceHandler
                .getId());
        if ((this.searchSchemaElementServiceHandler != null)) {
            this.searchSchemaElementServiceHandler.setEntityManager(this.em);
            this.searchSchemaElementServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<SchemaElementListMsg> searchSchemaElement(
            ServiceRequest<SchemaElementSearchMsg> rq) throws SearchException {
        if ((this.searchSchemaElementServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for searchSchemaElement().");
            throw new InjectionException(
                    "No service implementation configured for searchSchemaElement().");
        }
        ServiceResponse<SchemaElementListMsg> rs;
        this.searchSchemaElementServiceHandler.init();
        rs = this.searchSchemaElementServiceHandler.invoke(rq);
        this.searchSchemaElementServiceHandler.finish();
        return rs;
    }
}
