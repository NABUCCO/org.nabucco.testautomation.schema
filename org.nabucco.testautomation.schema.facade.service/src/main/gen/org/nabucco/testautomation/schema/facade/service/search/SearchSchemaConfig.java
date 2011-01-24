/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.service.search;

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;

/**
 * SearchSchemaConfig<p/>SchemaConfig search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public interface SearchSchemaConfig extends Service {

    /**
     * Missing description at method searchSchemaConfig.
     *
     * @param rq the ServiceRequest<SchemaConfigSearchMsg>.
     * @return the ServiceResponse<SchemaConfigListMsg>.
     * @throws SearchException
     */
    ServiceResponse<SchemaConfigListMsg> searchSchemaConfig(ServiceRequest<SchemaConfigSearchMsg> rq)
            throws SearchException;
}
