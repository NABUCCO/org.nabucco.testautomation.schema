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
     * @throws ClientException
     */
    public SchemaElementMsg produceSchemaElement(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<SchemaElementMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceSchemaElement(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceSchemaElementDelegate.class, "Service: ",
                                "ProduceSchemaElement.produceSchemaElement", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceSchemaElement.produceSchemaElement");
    }
}
