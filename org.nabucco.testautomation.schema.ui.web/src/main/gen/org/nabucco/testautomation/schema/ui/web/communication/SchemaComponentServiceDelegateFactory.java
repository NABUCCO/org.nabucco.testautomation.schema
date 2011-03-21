/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.web.communication;

import org.nabucco.framework.base.facade.component.connection.Connection;
import org.nabucco.framework.base.facade.component.connection.ConnectionException;
import org.nabucco.framework.base.facade.component.connection.ConnectionFactory;
import org.nabucco.framework.base.facade.component.connection.ConnectionSpecification;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.testautomation.schema.facade.component.SchemaComponent;
import org.nabucco.testautomation.schema.facade.component.SchemaComponentLocator;
import org.nabucco.testautomation.schema.ui.web.communication.export.ExportSchemaDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.importing.ImportSchemaDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.maintain.MaintainSchemaConfigDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.produce.ProduceAttributeDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.produce.ProduceSchemaConfigDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.produce.ProduceSchemaElementDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.search.SearchSchemaConfigDelegate;
import org.nabucco.testautomation.schema.ui.web.communication.search.SearchSchemaElementDelegate;

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

    private ExportSchemaDelegate exportSchemaDelegate;

    private ImportSchemaDelegate importSchemaDelegate;

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
            throw new ClientException("Cannot locate service: MaintainSchemaConfig", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
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
            throw new ClientException("Cannot locate service: ProduceSchemaConfig", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
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
            throw new ClientException("Cannot locate service: ProduceSchemaElement", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
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
            throw new ClientException("Cannot locate service: ProduceAttribute", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
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
            throw new ClientException("Cannot locate service: SearchSchemaConfig", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
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
            throw new ClientException("Cannot locate service: SearchSchemaElement", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ExportSchema.
     *
     * @return the ExportSchemaDelegate.
     * @throws ClientException
     */
    public ExportSchemaDelegate getExportSchema() throws ClientException {
        try {
            if ((this.exportSchemaDelegate == null)) {
                this.exportSchemaDelegate = new ExportSchemaDelegate(this.getComponent()
                        .getExportSchema());
            }
            return this.exportSchemaDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ExportSchema", e);
        } catch (ServiceException e) {
            throw new ClientException("Cannot locate service: ServiceDelegateTemplate", e);
        }
    }

    /**
     * Getter for the ImportSchema.
     *
     * @return the ImportSchemaDelegate.
     * @throws ClientException
     */
    public ImportSchemaDelegate getImportSchema() throws ClientException {
        try {
            if ((this.importSchemaDelegate == null)) {
                this.importSchemaDelegate = new ImportSchemaDelegate(this.getComponent()
                        .getImportSchema());
            }
            return this.importSchemaDelegate;
        } catch (ConnectionException e) {
            throw new ClientException("Cannot locate service: ImportSchema", e);
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
