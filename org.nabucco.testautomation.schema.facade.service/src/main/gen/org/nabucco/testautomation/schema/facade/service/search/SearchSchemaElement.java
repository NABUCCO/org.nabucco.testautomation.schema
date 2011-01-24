/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.service.search;

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.schema.facade.message.SchemaElementListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementSearchMsg;

/**
 * SearchSchemaElement<p/>SchemaElement search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public interface SearchSchemaElement extends Service {

    /**
     * Missing description at method searchSchemaElement.
     *
     * @param rq the ServiceRequest<SchemaElementSearchMsg>.
     * @return the ServiceResponse<SchemaElementListMsg>.
     * @throws SearchException
     */
    ServiceResponse<SchemaElementListMsg> searchSchemaElement(
            ServiceRequest<SchemaElementSearchMsg> rq) throws SearchException;
}
