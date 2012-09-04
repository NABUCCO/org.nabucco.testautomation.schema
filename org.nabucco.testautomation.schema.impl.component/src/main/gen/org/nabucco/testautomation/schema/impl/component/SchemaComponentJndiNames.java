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
package org.nabucco.testautomation.schema.impl.component;

/**
 * SchemaComponentJndiNames<p/>Component for TestAutomation schemas<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public interface SchemaComponentJndiNames {

    final String COMPONENT_RELATION_SERVICE_LOCAL = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.component.ComponentRelationService/local";

    final String COMPONENT_RELATION_SERVICE_REMOTE = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.component.ComponentRelationService/remote";

    final String QUERY_FILTER_SERVICE_LOCAL = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.component.QueryFilterService/local";

    final String QUERY_FILTER_SERVICE_REMOTE = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.component.QueryFilterService/remote";

    final String MAINTAIN_SCHEMA_LOCAL = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchema/local";

    final String MAINTAIN_SCHEMA_REMOTE = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchema/remote";

    final String PRODUCE_SCHEMA_LOCAL = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.service.produce.ProduceSchema/local";

    final String PRODUCE_SCHEMA_REMOTE = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.service.produce.ProduceSchema/remote";

    final String SEARCH_SCHEMA_LOCAL = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.service.search.SearchSchema/local";

    final String SEARCH_SCHEMA_REMOTE = "nabucco/org.nabucco.testautomation.schema/org.nabucco.testautomation.schema.facade.service.search.SearchSchema/remote";
}
