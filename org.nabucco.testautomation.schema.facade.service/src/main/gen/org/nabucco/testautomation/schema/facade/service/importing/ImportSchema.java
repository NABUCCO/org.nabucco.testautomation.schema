/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.service.importing;

import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.facade.service.Service;

/**
 * ImportSchema<p/>Service to import Schema<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-14
 */
public interface ImportSchema extends Service {

    /**
     * Missing description at method importSchema.
     *
     * @param rq the ServiceRequest<ImportRq>.
     * @return the ServiceResponse<ImportRs>.
     * @throws ImportException
     */
    ServiceResponse<ImportRs> importSchema(ServiceRequest<ImportRq> rq) throws ImportException;
}
