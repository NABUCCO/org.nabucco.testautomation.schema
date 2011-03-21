/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.web.communication.search;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaConfig;

/**
 * SearchSchemaConfigDelegate<p/>SchemaConfig search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SearchSchemaConfigDelegate extends ServiceDelegateSupport {

    private SearchSchemaConfig service;

    /**
     * Constructs a new SearchSchemaConfigDelegate instance.
     *
     * @param service the SearchSchemaConfig.
     */
    public SearchSchemaConfigDelegate(SearchSchemaConfig service) {
        super();
        this.service = service;
    }

    /**
     * SearchSchemaConfig.
     *
     * @param session the NabuccoSession.
     * @param rq the SchemaConfigSearchMsg.
     * @return the SchemaConfigListMsg.
     * @throws SearchException
     */
    public SchemaConfigListMsg searchSchemaConfig(SchemaConfigSearchMsg rq, NabuccoSession session)
            throws SearchException {
        ServiceRequest<SchemaConfigSearchMsg> request = new ServiceRequest<SchemaConfigSearchMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigListMsg> rs;
        if ((service != null)) {
            rs = service.searchSchemaConfig(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchSchemaConfig.searchSchemaConfig");
        }
        return rs.getResponseMessage();
    }
}
