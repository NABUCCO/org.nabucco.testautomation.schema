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
     * @param rq the SchemaConfigSearchMsg.
     * @return the SchemaConfigListMsg.
     * @throws ClientException
     */
    public SchemaConfigListMsg searchSchemaConfig(SchemaConfigSearchMsg rq) throws ClientException {
        ServiceRequest<SchemaConfigSearchMsg> request = new ServiceRequest<SchemaConfigSearchMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigListMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.searchSchemaConfig(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(SearchSchemaConfigDelegate.class, "Service: ",
                                "SearchSchemaConfig.searchSchemaConfig", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: SearchSchemaConfig.searchSchemaConfig");
    }
}
