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
package org.nabucco.testautomation.schema.facade.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.Service;
import org.nabucco.testautomation.schema.facade.message.AttributeMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementMsg;

/**
 * ProduceSchema<p/>SchemaElement produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public interface ProduceSchema extends Service {

    /**
     * Missing description at method produceSchemaElement.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<SchemaElementMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SchemaElementMsg> produceSchemaElement(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Missing description at method produceAttribute.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<AttributeMsg>.
     * @throws ProduceException
     */
    ServiceResponse<AttributeMsg> produceAttribute(ServiceRequest<EmptyServiceMessage> rq) throws ProduceException;

    /**
     * Missing description at method produceSchemaConfig.
     *
     * @param rq the ServiceRequest<EmptyServiceMessage>.
     * @return the ServiceResponse<SchemaConfigMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SchemaConfigMsg> produceSchemaConfig(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException;

    /**
     * Missing description at method produceSchemaConfigClone.
     *
     * @param rq the ServiceRequest<SchemaConfigMsg>.
     * @return the ServiceResponse<SchemaConfigMsg>.
     * @throws ProduceException
     */
    ServiceResponse<SchemaConfigMsg> produceSchemaConfigClone(ServiceRequest<SchemaConfigMsg> rq)
            throws ProduceException;
}
