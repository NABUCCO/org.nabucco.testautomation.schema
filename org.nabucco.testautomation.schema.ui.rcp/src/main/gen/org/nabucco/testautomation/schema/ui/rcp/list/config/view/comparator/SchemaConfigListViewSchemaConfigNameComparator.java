/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.list.config.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;

/**
 * SchemaConfigListViewSchemaConfigNameComparator
 *
 * @author Undefined
 */
public class SchemaConfigListViewSchemaConfigNameComparator extends
        NabuccoColumComparator<SchemaConfig> {

    /** Constructs a new SchemaConfigListViewSchemaConfigNameComparator instance. */
    public SchemaConfigListViewSchemaConfigNameComparator() {
        super();
    }

    @Override
    public int compareConcrete(SchemaConfig object1, SchemaConfig object2) {
        return this.compareBasetype(object1.getName(), object2.getName());
    }
}
