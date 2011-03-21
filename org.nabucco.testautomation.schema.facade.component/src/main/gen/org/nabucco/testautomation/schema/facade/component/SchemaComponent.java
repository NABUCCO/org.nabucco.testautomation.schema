/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.facade.component;

import org.nabucco.framework.base.facade.component.Component;
import org.nabucco.framework.base.facade.exception.service.ServiceException;
import org.nabucco.testautomation.schema.facade.service.export.ExportSchema;
import org.nabucco.testautomation.schema.facade.service.importing.ImportSchema;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchemaConfig;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceAttribute;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaConfig;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaElement;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaConfig;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaElement;

/**
 * SchemaComponent<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public interface SchemaComponent extends Component {

    final String COMPONENT_NAME = "org.nabucco.testautomation.schema";

    /**
     * Getter for the MaintainSchemaConfig.
     *
     * @return the MaintainSchemaConfig.
     * @throws ServiceException
     */
    MaintainSchemaConfig getMaintainSchemaConfig() throws ServiceException;

    /**
     * Getter for the ProduceSchemaConfig.
     *
     * @return the ProduceSchemaConfig.
     * @throws ServiceException
     */
    ProduceSchemaConfig getProduceSchemaConfig() throws ServiceException;

    /**
     * Getter for the ProduceSchemaElement.
     *
     * @return the ProduceSchemaElement.
     * @throws ServiceException
     */
    ProduceSchemaElement getProduceSchemaElement() throws ServiceException;

    /**
     * Getter for the ProduceAttribute.
     *
     * @return the ProduceAttribute.
     * @throws ServiceException
     */
    ProduceAttribute getProduceAttribute() throws ServiceException;

    /**
     * Getter for the SearchSchemaConfig.
     *
     * @return the SearchSchemaConfig.
     * @throws ServiceException
     */
    SearchSchemaConfig getSearchSchemaConfig() throws ServiceException;

    /**
     * Getter for the SearchSchemaElement.
     *
     * @return the SearchSchemaElement.
     * @throws ServiceException
     */
    SearchSchemaElement getSearchSchemaElement() throws ServiceException;

    /**
     * Getter for the ExportSchema.
     *
     * @return the ExportSchema.
     * @throws ServiceException
     */
    ExportSchema getExportSchema() throws ServiceException;

    /**
     * Getter for the ImportSchema.
     *
     * @return the ImportSchema.
     * @throws ServiceException
     */
    ImportSchema getImportSchema() throws ServiceException;
}
