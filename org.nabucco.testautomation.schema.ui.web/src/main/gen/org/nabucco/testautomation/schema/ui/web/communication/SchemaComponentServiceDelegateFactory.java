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
package org.nabucco.testautomation.schema.ui.web.communication;

import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.ui.web.communication.ServiceDelegateFactorySupport;
import org.nabucco.testautomation.schema.facade.component.SchemaComponent;
import org.nabucco.testautomation.schema.facade.component.SchemaComponentLocator;
import org.nabucco.testautomation.schema.ui.web.communication.maintain.MaintainSchemaDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.produce.ProduceSchemaDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.search.SearchSchemaDelegate;

/**
 * ServiceDelegateFactoryTemplate<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaComponentServiceDelegateFactory extends ServiceDelegateFactorySupport<SchemaComponent> {

    private static SchemaComponentServiceDelegateFactory instance = new SchemaComponentServiceDelegateFactory();

    private MaintainSchemaDelegate maintainSchemaDelegate;

    private ProduceSchemaDelegate produceSchemaDelegate;

    private SearchSchemaDelegate searchSchemaDelegate;

    /** Constructs a new SchemaComponentServiceDelegateFactory instance. */
    private SchemaComponentServiceDelegateFactory() {
        super(SchemaComponentLocator.getInstance());
    }

    /**
     * Getter for the MaintainSchema.
     *
     * @return the MaintainSchemaDelegate.
     * @throws ClientException
     */
    public MaintainSchemaDelegate getMaintainSchema() throws ClientException {
        try {
            if ((this.maintainSchemaDelegate == null)) {
                this.maintainSchemaDelegate = new MaintainSchemaDelegate(this.getComponent().getMaintainSchema());
            }
            return this.maintainSchemaDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: MaintainSchema", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ProduceSchema.
     *
     * @return the ProduceSchemaDelegate.
     * @throws ClientException
     */
    public ProduceSchemaDelegate getProduceSchema() throws ClientException {
        try {
            if ((this.produceSchemaDelegate == null)) {
                this.produceSchemaDelegate = new ProduceSchemaDelegate(this.getComponent().getProduceSchema());
            }
            return this.produceSchemaDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ProduceSchema", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the SearchSchema.
     *
     * @return the SearchSchemaDelegate.
     * @throws ClientException
     */
    public SearchSchemaDelegate getSearchSchema() throws ClientException {
        try {
            if ((this.searchSchemaDelegate == null)) {
                this.searchSchemaDelegate = new SearchSchemaDelegate(this.getComponent().getSearchSchema());
            }
            return this.searchSchemaDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: SearchSchema", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the Instance.
     *
     * @return the SchemaComponentServiceDelegateFactory.
     */
    public static SchemaComponentServiceDelegateFactory getInstance() {
        return instance;
    }
}
