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
import org.nabucco.testautomation.schema.facade.message.AttributeMsg;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceAttribute;

/**
 * ProduceAttributeDelegate<p/>Attribute produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class ProduceAttributeDelegate extends ServiceDelegateSupport {

    private ProduceAttribute service;

    /**
     * Constructs a new ProduceAttributeDelegate instance.
     *
     * @param service the ProduceAttribute.
     */
    public ProduceAttributeDelegate(ProduceAttribute service) {
        super();
        this.service = service;
    }

    /**
     * ProduceAttribute.
     *
     * @param rq the EmptyServiceMessage.
     * @return the AttributeMsg.
     * @throws ProduceException
     */
    public AttributeMsg produceAttribute(EmptyServiceMessage rq) throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<AttributeMsg> rs;
        if ((service != null)) {
            rs = service.produceAttribute(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceAttribute.produceAttribute");
        }
        return rs.getResponseMessage();
    }

    /**
     * ProduceAttribute.
     *
     * @param subject the Subject.
     * @param rq the EmptyServiceMessage.
     * @return the AttributeMsg.
     * @throws ProduceException
     */
    public AttributeMsg produceAttribute(EmptyServiceMessage rq, Subject subject)
            throws ProduceException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext(subject));
        request.setRequestMessage(rq);
        ServiceResponse<AttributeMsg> rs;
        if ((service != null)) {
            rs = service.produceAttribute(request);
        } else {
            throw new ProduceException(
                    "Cannot execute service operation: ProduceAttribute.produceAttribute");
        }
        return rs.getResponseMessage();
    }
}
