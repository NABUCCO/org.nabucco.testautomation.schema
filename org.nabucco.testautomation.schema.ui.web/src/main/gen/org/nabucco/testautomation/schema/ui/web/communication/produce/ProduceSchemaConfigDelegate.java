/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.security.Subject;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaConfig;

/**
 * ProduceSchemaConfigDelegate<p/>SchemaConfig produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class ProduceSchemaConfigDelegate extends ServiceDelegateSupport {

    private ProduceSchemaConfig service;

    /**
     * Constructs a new ProduceSchemaConfigDelegate instance.
     *
     * @param service the ProduceSchemaConfig.
     */
    public ProduceSchemaConfigDelegate(ProduceSchemaConfig service) {
        super();
        this.service = service;
    }

    /**
     * ProduceSchemaConfig.
     *
     * @param rq the EmptyServiceMessage.
     * @return the SchemaConfigMsg.
     * @throws ProduceException
     */
    public SchemaConfigMsg produceSchemaConfig(EmptyServiceMessage rq) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigMsg> rs;
        if ((service != null)) {
            rs = service.produceSchemaConfig(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceSchemaConfig.produceSchemaConfig");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceSchemaConfig.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the SchemaConfigMsg.
     * @throws ProduceException
     */
    public SchemaConfigMsg produceSchemaConfig(EmptyServiceMessage rq, Subject subject)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigMsg> rs;
        if ((service != null)) {
            rs = service.produceSchemaConfig(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceSchemaConfig.produceSchemaConfig");
        }
        return rs.getResponseMessage();
    }
}
