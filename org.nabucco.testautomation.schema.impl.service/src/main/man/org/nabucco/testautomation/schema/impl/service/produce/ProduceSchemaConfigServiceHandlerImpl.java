/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.schema.impl.service.produce;

import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;

/**
 * ProduceSchemaConfigServiceHandlerImpl
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class ProduceSchemaConfigServiceHandlerImpl extends ProduceSchemaConfigServiceHandler {

    private static final long serialVersionUID = 1L;

    @Override
    public SchemaConfigMsg produceSchemaConfig(EmptyServiceMessage msg) throws ProduceException {

        SchemaConfigMsg rs = new SchemaConfigMsg();
        SchemaConfig schemaConfig = new SchemaConfig();
        schemaConfig.setDatatypeState(DatatypeState.INITIALIZED);
        schemaConfig.setName("Enter name ...");
        rs.setSchemaConfig(schemaConfig);
        return rs;
    }

}
