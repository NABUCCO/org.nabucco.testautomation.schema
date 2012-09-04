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
package org.nabucco.testautomation.schema.ui.rcp.communication.search;

import org.nabucco.framework.base.facade.datatype.NabuccoSystem;
import org.nabucco.framework.base.facade.datatype.context.ServiceSubContext;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementSearchMsg;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchema;

/**
 * SearchSchemaDelegate<p/>SchemaElement search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SearchSchemaDelegate extends ServiceDelegateSupport {

    private SearchSchema service;

    /**
     * Constructs a new SearchSchemaDelegate instance.
     *
     * @param service the SearchSchema.
     */
    public SearchSchemaDelegate(SearchSchema service) {
        super();
        this.service = service;
    }

    /**
     * SearchSchemaElement.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SchemaElementSearchMsg.
     * @return the SchemaElementListMsg.
     * @throws ClientException
     */
    public SchemaElementListMsg searchSchemaElement(SchemaElementSearchMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<SchemaElementSearchMsg> request = new ServiceRequest<SchemaElementSearchMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SchemaElementListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchSchemaElement(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchSchema.class, "searchSchemaElement", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchSchema.searchSchemaElement");
    }

    /**
     * SearchSchemaConfig.
     *
     * @param subContexts the ServiceSubContext....
     * @param message the SchemaConfigSearchMsg.
     * @return the SchemaConfigListMsg.
     * @throws ClientException
     */
    public SchemaConfigListMsg searchSchemaConfig(SchemaConfigSearchMsg message, ServiceSubContext... subContexts)
            throws ClientException {
        ServiceRequest<SchemaConfigSearchMsg> request = new ServiceRequest<SchemaConfigSearchMsg>(
                super.createServiceContext(subContexts));
        request.setRequestMessage(message);
        ServiceResponse<SchemaConfigListMsg> response = null;
        Exception exception = null;
        if ((service != null)) {
            super.handleRequest(request);
            long start = NabuccoSystem.getCurrentTimeMillis();
            try {
                response = service.searchSchemaConfig(request);
            } catch (Exception e) {
                exception = e;
            } finally {
                long end = NabuccoSystem.getCurrentTimeMillis();
                long duration = (end - start);
                super.monitorResult(SearchSchema.class, "searchSchemaConfig", duration, exception);
            }
            if ((response != null)) {
                super.handleResponse(response);
                return response.getResponseMessage();
            }
        }
        throw new ClientException("Cannot execute service operation: SearchSchema.searchSchemaConfig");
    }
}
