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
     * @throws ClientException
     */
    public SchemaConfigMsg produceSchemaConfig(EmptyServiceMessage rq) throws ClientException {
        ServiceRequest<EmptyServiceMessage> request = new ServiceRequest<EmptyServiceMessage>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceSchemaConfig(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceSchemaConfigDelegate.class, "Service: ",
                                "ProduceSchemaConfig.produceSchemaConfig", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceSchemaConfig.produceSchemaConfig");
    }

    /**
     * ProduceSchemaConfigClone.
     *
     * @param rq the SchemaConfigMsg.
     * @return the SchemaConfigMsg.
     * @throws ClientException
     */
    public SchemaConfigMsg produceSchemaConfigClone(SchemaConfigMsg rq) throws ClientException {
        ServiceRequest<SchemaConfigMsg> request = new ServiceRequest<SchemaConfigMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.produceSchemaConfigClone(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(ProduceSchemaConfigDelegate.class, "Service: ",
                                "ProduceSchemaConfig.produceSchemaConfigClone", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: ProduceSchemaConfig.produceSchemaConfigClone");
    }
}
