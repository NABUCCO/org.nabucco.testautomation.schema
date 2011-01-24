/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.communication.produce;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
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
     * @throws ClientException
     */
    public AttributeMsg produceAttribute(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<AttributeMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceAttribute(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceAttributeDelegate.class, "Service: ",
                                "ProduceAttribute.produceAttribute", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceAttribute.produceAttribute");
    }
}
