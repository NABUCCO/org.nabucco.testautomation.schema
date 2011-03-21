/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.web.communication.produce;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
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
     * @param session the NabuccoSession.
     * @param rq the EmptyServiceMessage.
     * @return the SchemaConfigMsg.
     * @throws ProduceException
     */
    public SchemaConfigMsg produceSchemaConfig(EmptyServiceMessage rq, NabuccoSession session)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(session));
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
     * ProduceSchemaConfigClone.
     *
     * @param session the NabuccoSession.
     * @param rq the SchemaConfigMsg.
     * @return the SchemaConfigMsg.
     * @throws ProduceException
     */
    public SchemaConfigMsg produceSchemaConfigClone(SchemaConfigMsg rq, NabuccoSession session)
            throws ProduceException {
        ServiceRequest<SchemaConfigMsg> request = new ServiceRequest<SchemaConfigMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigMsg> rs;
        if ((service != null)) {
            rs = service.produceSchemaConfigClone(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceSchemaConfig.produceSchemaConfigClone");
        }
        return rs.getResponseMessage();
    }
}
