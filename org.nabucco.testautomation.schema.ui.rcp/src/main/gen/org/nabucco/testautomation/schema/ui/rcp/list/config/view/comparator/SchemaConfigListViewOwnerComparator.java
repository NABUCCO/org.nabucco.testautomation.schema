/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.list.config.view.comparator;

import org.nabucco.framework.plugin.base.component.list.view.NabuccoColumComparator;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;

/**
 * SchemaConfigListViewOwnerComparator
 *
 * @author Undefined
 */
public class SchemaConfigListViewOwnerComparator extends NabuccoColumComparator<SchemaConfig> {

    /** Constructs a new SchemaConfigListViewOwnerComparator instance. */
    public SchemaConfigListViewOwnerComparator() {
        super();
    }

    @Override
    public int compareConcrete(SchemaConfig object1, SchemaConfig object2) {
        return this.compareBasetype(object1.getOwner(), object2.getOwner());
    }
}
