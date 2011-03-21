/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.web.communication.maintain;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
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
     * @param session the NabuccoSession.
     * @param rq the SchemaConfigMsg.
     * @return the SchemaConfigMsg.
     * @throws MaintainException
     */
    public SchemaConfigMsg maintainSchemaConfig(SchemaConfigMsg rq, NabuccoSession session)
            throws MaintainException {
        ServiceRequest<SchemaConfigMsg> request = new ServiceRequest<SchemaConfigMsg>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<SchemaConfigMsg> rs;
        if ((service != null)) {
            rs = service.maintainSchemaConfig(request);
        } else {
            throw new MaintainException(
                    "Cannot execute service operation: MaintainSchemaConfig.maintainSchemaConfig");
        }
        return rs.getResponseMessage();
    }
}
