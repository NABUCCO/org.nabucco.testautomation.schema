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
import org.nabucco.testautomation.schema.facade.message.SchemaElementMsg;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaElement;

/**
 * ProduceSchemaElementDelegate<p/>SchemaElement produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class ProduceSchemaElementDelegate extends ServiceDelegateSupport {

    private ProduceSchemaElement service;

    /**
     * Constructs a new ProduceSchemaElementDelegate instance.
     *
     * @param service the ProduceSchemaElement.
     */
    public ProduceSchemaElementDelegate(ProduceSchemaElement service) {
        super();
        this.service = service;
    }

    /**
     * ProduceSchemaElement.
     *
     * @param rq the EmptyServiceMessage.
     * @return the SchemaElementMsg.
     * @throws ProduceException
     */
    public SchemaElementMsg produceSchemaElement(EmptyServiceMessage rq) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<SchemaElementMsg> rs;
        if ((service != null)) {
            rs = service.produceSchemaElement(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceSchemaElement.produceSchemaElement");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceSchemaElement.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the SchemaElementMsg.
     * @throws ProduceException
     */
    public SchemaElementMsg produceSchemaElement(EmptyServiceMessage rq, Subject subject)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<SchemaElementMsg> rs;
        if ((service != null)) {
            rs = service.produceSchemaElement(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceSchemaElement.produceSchemaElement");
        }
        return rs.getResponseMessage();
    }
}
