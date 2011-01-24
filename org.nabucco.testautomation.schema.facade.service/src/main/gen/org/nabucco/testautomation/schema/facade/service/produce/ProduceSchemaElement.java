/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.schema.facade.message.SchemaElementMsg;

/**
 * ProduceSchemaElement<p/>SchemaElement produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public interface ProduceSchemaElement extends Service {

    /**
     * Missing description at method produceSchemaElement.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<SchemaElementMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SchemaElementMsg> produceSchemaElement(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;
}
