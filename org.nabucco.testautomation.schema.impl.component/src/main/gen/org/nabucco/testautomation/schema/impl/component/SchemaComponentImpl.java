/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.impl.component;

import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.framework.base.facade.service.componentrelation.ComponentRelationService;
import org.nabucco.framework.base.impl.component.ComponentSupport;
import org.nabucco.testautomation.schema.facade.component.SchemaComponent;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchemaConfig;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceAttribute;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaConfig;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaElement;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaConfig;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaElement;

/**
 * SchemaComponentImpl<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaComponentImpl extends ComponentSupport implements SchemaComponent {

    private static final long serialVersionUID = 1L;

    private ComponentRelationService componentRelationService;

    private MaintainSchemaConfig maintainSchemaConfig;

    private ProduceSchemaConfig produceSchemaConfig;

    private ProduceSchemaElement produceSchemaElement;

    private ProduceAttribute produceAttribute;

    private SearchSchemaConfig searchSchemaConfig;

    private SearchSchemaElement searchSchemaElement;

    /** Constructs a new SchemaComponentImpl instance. */
    public SchemaComponentImpl() {
        super();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.componentRelationService;
    }

    /**
     * Getter for the MaintainSchemaConfig.
     *
     * @return the MaintainSchemaConfig.
     */
    public MaintainSchemaConfig getMaintainSchemaConfig() {
        return this.maintainSchemaConfig;
    }

    /**
     * Getter for the ProduceSchemaConfig.
     *
     * @return the ProduceSchemaConfig.
     */
    public ProduceSchemaConfig getProduceSchemaConfig() {
        return this.produceSchemaConfig;
    }

    /**
     * Getter for the ProduceSchemaElement.
     *
     * @return the ProduceSchemaElement.
     */
    public ProduceSchemaElement getProduceSchemaElement() {
        return this.produceSchemaElement;
    }

    /**
     * Getter for the ProduceAttribute.
     *
     * @return the ProduceAttribute.
     */
    public ProduceAttribute getProduceAttribute() {
        return this.produceAttribute;
    }

    /**
     * Getter for the SearchSchemaConfig.
     *
     * @return the SearchSchemaConfig.
     */
    public SearchSchemaConfig getSearchSchemaConfig() {
        return this.searchSchemaConfig;
    }

    /**
     * Getter for the SearchSchemaElement.
     *
     * @return the SearchSchemaElement.
     */
    public SearchSchemaElement getSearchSchemaElement() {
        return this.searchSchemaElement;
    }
}
