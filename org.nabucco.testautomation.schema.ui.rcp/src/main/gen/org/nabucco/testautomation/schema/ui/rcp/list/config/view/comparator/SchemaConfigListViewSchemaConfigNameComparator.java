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
package org.nabucco.testautomation.schema.ui.rcp.list.config.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;

/**
 * SchemaConfigListViewSchemaConfigNameComparator
 *
 * @author Undefined
 */
public class SchemaConfigListViewSchemaConfigNameComparator extends NabuccoColumComparator<SchemaConfig> {

    /** Constructs a new SchemaConfigListViewSchemaConfigNameComparator instance. */
    public SchemaConfigListViewSchemaConfigNameComparator() {
        super();
    }

    @Override
    public int compareConcrete(SchemaConfig object1, SchemaConfig object2) {
        return this.compareBasetype(object1.getName(), object2.getName());
    }
}
