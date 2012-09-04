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

import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.facade.service.queryfilter.QueryFilterService;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchema;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchema;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchema;

/**
 * SchemaComponentLocal<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public interface SchemaComponentLocal extends SchemaComponent {

    /**
     * Getter for the ComponentRelationServiceLocal.
     *
     * @return the ComponentRelationService.
     * @throws ServiceException
     */
    ComponentRelationService getComponentRelationServiceLocal() throws ServiceException;

    /**
     * Getter for the QueryFilterServiceLocal.
     *
     * @return the QueryFilterService.
     * @throws ServiceException
     */
    QueryFilterService getQueryFilterServiceLocal() throws ServiceException;

    /**
     * Getter for the MaintainSchemaLocal.
     *
     * @return the MaintainSchema.
     * @throws ServiceException
     */
    MaintainSchema getMaintainSchemaLocal() throws ServiceException;

    /**
     * Getter for the ProduceSchemaLocal.
     *
     * @return the ProduceSchema.
     * @throws ServiceException
     */
    ProduceSchema getProduceSchemaLocal() throws ServiceException;

    /**
     * Getter for the SearchSchemaLocal.
     *
     * @return the SearchSchema.
     * @throws ServiceException
     */
    SearchSchema getSearchSchemaLocal() throws ServiceException;
}
