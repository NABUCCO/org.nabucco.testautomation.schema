/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.web.communication.importing;

import org.nabucco.framework.base.facade.datatype.session.NabuccoSession;
import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateSupport;
import org.nabucco.testautomation.schema.facade.service.importing.ImportSchema;

/**
 * ImportSchemaDelegate<p/>Service to import Schema<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-14
 */
public class ImportSchemaDelegate extends ServiceDelegateSupport {

    private ImportSchema service;

    /**
     * Constructs a new ImportSchemaDelegate instance.
     *
     * @param service the ImportSchema.
     */
    public ImportSchemaDelegate(ImportSchema service) {
        super();
        this.service = service;
    }

    /**
     * ImportSchema.
     *
     * @param session the NabuccoSession.
     * @param rq the ImportRq.
     * @return the ImportRs.
     * @throws ImportException
     */
    public ImportRs importSchema(ImportRq rq, NabuccoSession session) throws ImportException {
        ServiceRequest<ImportRq> request = new ServiceRequest<ImportRq>(
                super.createServiceContext(session));
        request.setRequestMessage(rq);
        ServiceResponse<ImportRs> rs;
        if ((service != null)) {
            rs = service.importSchema(request);
        } else {
            throw new ImportException("Cannot execute service operation: ImportSchema.importSchema");
        }
        return rs.getResponseMessage();
    }
}
