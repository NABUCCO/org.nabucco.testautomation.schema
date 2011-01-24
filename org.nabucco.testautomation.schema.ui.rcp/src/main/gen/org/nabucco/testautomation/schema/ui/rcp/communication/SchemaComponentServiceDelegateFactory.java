/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.communication;

import org.nabucco.framework.base.facade.component.connection.Connection;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.connection.ConnectionFactory;
import org.nabucco.framework.base.facade.component.connection.ConnectionSpecification;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.testautomation.schema.facade.component.SchemaComponent;
import org.nabucco.testautomation.schema.facade.component.SchemaComponentLocator;
import org.nabucco.testautomation.schema.ui.rcp.communication.maintain.MaintainSchemaConfigDelegate;
import org.nabucco.testautomation.schema.ui.rcp.communication.produce.ProduceAttributeDelegate;
import org.nabucco.testautomation.schema.ui.rcp.communication.produce.ProduceSchemaConfigDelegate;
import org.nabucco.testautomation.schema.ui.rcp.communication.produce.ProduceSchemaElementDelegate;
import org.nabucco.testautomation.schema.ui.rcp.communication.search.SearchSchemaConfigDelegate;
import org.nabucco.testautomation.schema.ui.rcp.communication.search.SearchSchemaElementDelegate;

/**
 * ServiceDelegateFactoryTemplate<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaComponentServiceDelegateFactory {

    private static SchemaComponentServiceDelegateFactory instance = new SchemaComponentServiceDelegateFactory();

    private SchemaComponent component;

    private MaintainSchemaConfigDelegate maintainSchemaConfigDelegate;

    private ProduceSchemaConfigDelegate produceSchemaConfigDelegate;

    private ProduceSchemaElementDelegate produceSchemaElementDelegate;

    private ProduceAttributeDelegate produceAttributeDelegate;

    private SearchSchemaConfigDelegate searchSchemaConfigDelegate;

    private SearchSchemaElementDelegate searchSchemaElementDelegate;

    /** Constructs a new SchemaComponentServiceDelegateFactory instance. */
    private SchemaComponentServiceDelegateFactory() {
        super();
    }

    /**
     * Getter for the Component.
     *
     * @return the SchemaComponent.
     * @throws ConnectionException
     */
    private SchemaComponent getComponent() throws ConnectionException {
        if ((this.component == null)) {
            this.initComponent();
        }
        return this.component;
    }

    /**
     * InitComponent.
     *
     * @throws ConnectionException
     */
    private void initComponent() throws ConnectionException {
        ConnectionSpecification specification = ConnectionSpecification.getCurrentSpecification();
        Connection connection = ConnectionFactory.getInstance().createConnection(specification);
        this.component = SchemaComponentLocator.getInstance().getComponent(connection);
    }

    /**
     * Getter for the MaintainSchemaConfig.
     *
     * @return the MaintainSchemaConfigDelegate.
     * @throws ClientException
     */
    public MaintainSchemaConfigDelegate getMaintainSchemaConfig() throws ClientException {
        try {
            if ((this.maintainSchemaConfigDelegate == null)) {
                this.maintainSchemaConfigDelegate = new MaintainSchemaConfigDelegate(this
                        .getComponent().getMaintainSchemaConfig());
            }
            return this.maintainSchemaConfigDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: SchemaComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: MaintainSchemaConfig", e);
        }
    }

    /**
     * Getter for the ProduceSchemaConfig.
     *
     * @return the ProduceSchemaConfigDelegate.
     * @throws ClientException
     */
    public ProduceSchemaConfigDelegate getProduceSchemaConfig() throws ClientException {
        try {
            if ((this.produceSchemaConfigDelegate == null)) {
                this.produceSchemaConfigDelegate = new ProduceSchemaConfigDelegate(this
                        .getComponent().getProduceSchemaConfig());
            }
            return this.produceSchemaConfigDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: SchemaComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceSchemaConfig", e);
        }
    }

    /**
     * Getter for the ProduceSchemaElement.
     *
     * @return the ProduceSchemaElementDelegate.
     * @throws ClientException
     */
    public ProduceSchemaElementDelegate getProduceSchemaElement() throws ClientException {
        try {
            if ((this.produceSchemaElementDelegate == null)) {
                this.produceSchemaElementDelegate = new ProduceSchemaElementDelegate(this
                        .getComponent().getProduceSchemaElement());
            }
            return this.produceSchemaElementDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: SchemaComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceSchemaElement", e);
        }
    }

    /**
     * Getter for the ProduceAttribute.
     *
     * @return the ProduceAttributeDelegate.
     * @throws ClientException
     */
    public ProduceAttributeDelegate getProduceAttribute() throws ClientException {
        try {
            if ((this.produceAttributeDelegate == null)) {
                this.produceAttributeDelegate = new ProduceAttributeDelegate(this.getComponent()
                        .getProduceAttribute());
            }
            return this.produceAttributeDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: SchemaComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ProduceAttribute", e);
        }
    }

    /**
     * Getter for the SearchSchemaConfig.
     *
     * @return the SearchSchemaConfigDelegate.
     * @throws ClientException
     */
    public SearchSchemaConfigDelegate getSearchSchemaConfig() throws ClientException {
        try {
            if ((this.searchSchemaConfigDelegate == null)) {
                this.searchSchemaConfigDelegate = new SearchSchemaConfigDelegate(this
                        .getComponent().getSearchSchemaConfig());
            }
            return this.searchSchemaConfigDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: SchemaComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchSchemaConfig", e);
        }
    }

    /**
     * Getter for the SearchSchemaElement.
     *
     * @return the SearchSchemaElementDelegate.
     * @throws ClientException
     */
    public SearchSchemaElementDelegate getSearchSchemaElement() throws ClientException {
        try {
            if ((this.searchSchemaElementDelegate == null)) {
                this.searchSchemaElementDelegate = new SearchSchemaElementDelegate(this
                        .getComponent().getSearchSchemaElement());
            }
            return this.searchSchemaElementDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot connect to component: SchemaComponent", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: SearchSchemaElement", e);
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
