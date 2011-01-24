/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.service.maintain;

import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;

/**
 * MaintainSchemaConfig<p/>SchemaConfig maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public interface MaintainSchemaConfig extends Service {

    /**
     * Missing description at method maintainSchemaConfig.
     *
     * @param rq the ServiceRequest<SchemaConfigMsg>.
     * @return the ServiceResponse<SchemaConfigMsg>.
     * @throws MaintainException
     */
    ServiceResponse<SchemaConfigMsg> maintainSchemaConfig(ServiceRequest<SchemaConfigMsg> rq)
            throws MaintainException;
}
