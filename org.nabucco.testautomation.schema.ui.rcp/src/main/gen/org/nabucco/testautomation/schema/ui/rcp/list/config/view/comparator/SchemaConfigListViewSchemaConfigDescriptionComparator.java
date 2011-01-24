/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.list.config.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;

/**
 * SchemaConfigListViewSchemaConfigDescriptionComparator
 *
 * @author Undefined
 */
public class SchemaConfigListViewSchemaConfigDescriptionComparator extends
        NabuccoColumComparator<SchemaConfig> {

    /** Constructs a new SchemaConfigListViewSchemaConfigDescriptionComparator instance. */
    public SchemaConfigListViewSchemaConfigDescriptionComparator() {
        super();
    }

    @Override
    public int compareConcrete(SchemaConfig object1, SchemaConfig object2) {
        return this.compareBasetype(object1.getDescription(), object2.getDescription());
    }
}
