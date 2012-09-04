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
import org.nabucco.testautomation.schema.facade.component.SchemaComponent;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchema;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchema;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchema;

/**
 * SchemaComponentLocalProxy<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class SchemaComponentLocalProxy implements SchemaComponent {

    private static final long serialVersionUID = 1L;

    private final SchemaComponentLocal delegate;

    /**
     * Constructs a new SchemaComponentLocalProxy instance.
     *
     * @param delegate the SchemaComponentLocal.
     */
    public SchemaComponentLocalProxy(SchemaComponentLocal delegate) {
        super();
        if ((delegate == null)) {
            throw new IllegalArgumentException("Cannot create local proxy for component [null].");
        }
        this.delegate = delegate;
    }

    @Override
    public String getId() {
        return this.delegate.getId();
    }

    @Override
    public String getName() {
        return this.delegate.getName();
    }

    @Override
    public String getJndiName() {
        return this.delegate.getJndiName();
    }

    @Override
    public ComponentRelationService getComponentRelationService() throws ServiceException {
        return this.delegate.getComponentRelationServiceLocal();
    }

    @Override
    public QueryFilterService getQueryFilterService() throws ServiceException {
        return this.delegate.getQueryFilterServiceLocal();
    }

    @Override
    public String toString() {
        return this.delegate.toString();
    }

    @Override
    public MaintainSchema getMaintainSchema() throws ServiceException {
        return this.delegate.getMaintainSchemaLocal();
    }

    @Override
    public ProduceSchema getProduceSchema() throws ServiceException {
        return this.delegate.getProduceSchemaLocal();
    }

    @Override
    public SearchSchema getSearchSchema() throws ServiceException {
        return this.delegate.getSearchSchemaLocal();
    }
}
