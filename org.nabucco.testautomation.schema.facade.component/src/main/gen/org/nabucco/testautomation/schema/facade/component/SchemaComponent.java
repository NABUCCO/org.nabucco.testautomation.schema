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
package org.nabucco.testautomation.schema.facade.component;

import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchema;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchema;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchema;

/**
 * SchemaComponent<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public interface SchemaComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.testautomation.schema";

    final String COMPONENT_PREFIX = "scma";

    final String JNDI_NAME = ((((JNDI_PREFIX + "/") + COMPONENT_NAME) + "/") + "org.nabucco.testautomation.schema.facade.component.SchemaComponent");

    /**
     * Getter for the MaintainSchema.
     *
     * @return the MaintainSchema.
     * @throws ServiceException
     */
    MaintainSchema getMaintainSchema() throws ServiceException;

    /**
     * Getter for the ProduceSchema.
     *
     * @return the ProduceSchema.
     * @throws ServiceException
     */
    ProduceSchema getProduceSchema() throws ServiceException;

    /**
     * Getter for the SearchSchema.
     *
     * @return the SearchSchema.
     * @throws ServiceException
     */
    SearchSchema getSearchSchema() throws ServiceException;
}
