/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.list.config.view.label;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;

/**
 * SchemaConfigListViewSchemaConfigDescriptionLabelProvider
 *
 * @author Undefined
 */
public class SchemaConfigListViewSchemaConfigDescriptionLabelProvider implements ILabelProvider {

    /** Constructs a new SchemaConfigListViewSchemaConfigDescriptionLabelProvider instance. */
    public SchemaConfigListViewSchemaConfigDescriptionLabelProvider() {
        super();
    }

    @Override
    public Image getImage(Object arg0) {
        return null;
    }

    @Override
    public String getText(Object arg0) {
        String result = "";
        if ((arg0 instanceof SchemaConfig)) {
            SchemaConfig schemaConfig = ((SchemaConfig) arg0);
            result = ((schemaConfig.getDescription() != null) ? schemaConfig.getDescription()
                    .toString() : "");
        }
        return result;
    }

    @Override
    public void addListener(ILabelProviderListener arg0) {
    }

    @Override
    public void dispose() {
    }

    @Override
    public boolean isLabelProperty(Object arg0, String arg1) {
        return false;
    }

    @Override
    public void removeListener(ILabelProviderListener arg0) {
    }
}
