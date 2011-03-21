/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.web.communication.search;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.schema.facade.message.SchemaElementListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementSearchMsg;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaElement;

/**
 * SearchSchemaElementDelegate<p/>SchemaElement search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SearchSchemaElementDelegate extends ServiceDelegateSupport {

    private SearchSchemaElement service;

    /**
     * Constructs a new SearchSchemaElementDelegate instance.
     *
     * @param service the SearchSchemaElement.
     */
    public SearchSchemaElementDelegate(SearchSchemaElement service) {
        super();
        this.service = service;
    }

    /**
     * SearchSchemaElement.
     *
     * @param session the NabuccoSession.
     * @param rq the SchemaElementSearchMsg.
     * @return the SchemaElementListMsg.
     * @throws SearchException
     */
    public SchemaElementListMsg searchSchemaElement(SchemaElementSearchMsg rq,
            NabuccoSession session) throws SearchException {
        ServiceRequest<SchemaElementSearchMsg> request = new ServiceRequest<SchemaElementSearchMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<SchemaElementListMsg> rs;
        if ((service != null)) {
            rs = service.searchSchemaElement(request);
        } else {
            throw new SearchException(
                    "Cannot execute service operation: SearchSchemaElement.searchSchemaElement");
        }
        return rs.getResponseMessage();
    }
}
