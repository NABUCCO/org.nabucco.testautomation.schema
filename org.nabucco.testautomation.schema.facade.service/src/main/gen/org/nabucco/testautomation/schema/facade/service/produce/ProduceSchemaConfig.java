/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;

/**
 * ProduceSchemaConfig<p/>SchemaConfig produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public interface ProduceSchemaConfig extends Service {

    /**
     * Missing description at method produceSchemaConfig.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<SchemaConfigMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SchemaConfigMsg> produceSchemaConfig(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Missing description at method produceSchemaConfigClone.
     *
     * @param rq the ServiceRequest<SchemaConfigMsg>.
     * @return the ServiceResponse<SchemaConfigMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SchemaConfigMsg> produceSchemaConfigClone(ServiceRequest<SchemaConfigMsg> rq)
            throws ProduceException;
}
