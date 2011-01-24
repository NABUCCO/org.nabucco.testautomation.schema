/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.communication.maintain;

import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.communication.ServiceDelegateSupport;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchemaConfig;

/**
 * MaintainSchemaConfigDelegate<p/>SchemaConfig maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class MaintainSchemaConfigDelegate extends ServiceDelegateSupport {

    private MaintainSchemaConfig service;

    /**
     * Constructs a new MaintainSchemaConfigDelegate instance.
     *
     * @param service the MaintainSchemaConfig.
     */
    public MaintainSchemaConfigDelegate(MaintainSchemaConfig service) {
        super();
        this.service = service;
    }

    /**
     * MaintainSchemaConfig.
     *
     * @param rq the SchemaConfigMsg.
     * @return the SchemaConfigMsg.
     * @throws ClientException
     */
    public SchemaConfigMsg maintainSchemaConfig(SchemaConfigMsg rq) throws ClientException {
        ServiceRequest<SchemaConfigMsg> request = new ServiceRequest<SchemaConfigMsg>(
                super.createServiceContext());
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigMsg> rs;
        if ((service != null)) {
            long start = System.currentTimeMillis();
            try {
                rs = service.maintainSchemaConfig(request);
                return rs.getResponseMessage();
            } catch (Exception exception) {
                super.processException(exception);
            } finally {
                long end = System.currentTimeMillis();
                Activator.getDefault().logDebug(
                        new NabuccoLogMessage(MaintainSchemaConfigDelegate.class, "Service: ",
                                "MaintainSchemaConfig.maintainSchemaConfig", " Time: ", String
                                        .valueOf((end - start)), "ms."));
            }
        }
        throw new ClientException(
                "Cannot execute service operation: MaintainSchemaConfig.maintainSchemaConfig");
    }
}
