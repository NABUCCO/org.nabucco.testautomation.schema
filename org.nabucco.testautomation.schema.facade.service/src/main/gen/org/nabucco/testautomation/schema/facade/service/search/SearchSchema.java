/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.schema.facade.service.search;

import org.nabucco.framework.base.facade.exception.service.SearchException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementSearchMsg;

/**
 * SearchSchema<p/>SchemaElement search service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public interface SearchSchema extends Service {

    /**
     * Missing description at method searchSchemaElement.
     *
     * @param rq the ServiceRequest<SchemaElementSearchMsg>.
     * @return the ServiceResponse<SchemaElementListMsg>.
     * @throws SearchException
     */
    ServiceResponse<SchemaElementListMsg> searchSchemaElement(ServiceRequest<SchemaElementSearchMsg> rq)
            throws SearchException;

    /**
     * Missing description at method searchSchemaConfig.
     *
     * @param rq the ServiceRequest<SchemaConfigSearchMsg>.
     * @return the ServiceResponse<SchemaConfigListMsg>.
     * @throws SearchException
     */
    ServiceResponse<SchemaConfigListMsg> searchSchemaConfig(ServiceRequest<SchemaConfigSearchMsg> rq)
            throws SearchException;
}
