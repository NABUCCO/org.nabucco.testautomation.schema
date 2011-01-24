/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.communication.search;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @param rq the SchemaElementSearchMsg.
     * @return the SchemaElementListMsg.
     * @throws ClientException
     */
    public SchemaElementListMsg searchSchemaElement(SchemaElementSearchMsg rq)
            throws ClientException {
        ServiceRequest<SchemaElementSearchMsg> request = new ServiceRequest<SchemaElementSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<SchemaElementListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchSchemaElement(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchSchemaElementDelegate.class, "Service: ",
                                "SearchSchemaElement.searchSchemaElement", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchSchemaElement.searchSchemaElement");
    }
}
