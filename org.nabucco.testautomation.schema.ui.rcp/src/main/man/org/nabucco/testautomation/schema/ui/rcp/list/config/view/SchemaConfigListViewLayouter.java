/*
 * Copyright 2012 PRODYNA AG
 *
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.nabucco.testautomation.schema.ui.rcp.list.config.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoAbstractListLayouter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultListContentProvider;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoDefaultTableSorter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableParameter;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableViewer;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.ui.rcp.list.config.model.SchemaConfigListViewModel;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.comparator.SchemaConfigListViewSchemaConfigDescriptionComparator;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.comparator.SchemaConfigListViewSchemaConfigNameComparator;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.label.SchemaConfigListViewSchemaConfigDescriptionLabelProvider;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.label.SchemaConfigListViewSchemaConfigKeyLabelProvider;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.label.SchemaConfigListViewSchemaConfigNameLabelProvider;

/**
 * @author Stefan H�ttenrauch, PRODYNA AG
 * 
 */
public class SchemaConfigListViewLayouter extends NabuccoAbstractListLayouter<SchemaConfigListViewModel> {

    private static final String DESCRIPTION_COLUMN_KEY = "org.nabucco.testautomation.schema.ui.rcp.list.config.view.description";

    private static final String NAME_COLUMN_KEY = "org.nabucco.testautomation.schema.ui.rcp.list.config.view.name";

    private static final String KEY_COLUMN_KEY = "org.nabucco.testautomation.schema.ui.rcp.list.config.view.key";

    /**
     * Layouts the table
     **/
    @Override
    public NabuccoTableViewer layout(final Composite parent, final NabuccoMessageManager messageManager,
            final SchemaConfigListViewModel model, final Layoutable<SchemaConfigListViewModel> view) {

        NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);

        SchemaConfigListViewWidgetFactory widgetFactory = new SchemaConfigListViewWidgetFactory(ntk);

        NabuccoTableParameter parameter = new NabuccoTableParameter(new NabuccoDefaultTableSorter<SchemaConfig>(
                createComparators()), new SchemaConfigListViewTableFilter(), new NabuccoDefaultListContentProvider(
                model), createTableColumnInfo(), getDoubleClickCommand(view.getManagedFormViewPart()));

        return widgetFactory.createTable(parent, parameter, model);
    }

    private List<Comparator<SchemaConfig>> createComparators() {
        List<Comparator<SchemaConfig>> comparators = new ArrayList<Comparator<SchemaConfig>>();
        comparators.add(new SchemaConfigListViewSchemaConfigNameComparator());
        comparators.add(new SchemaConfigListViewSchemaConfigDescriptionComparator());

        return comparators;
    }

    /**
     * Creates needed tables.
     * 
     * @return table columns
     */
    private NabuccoTableColumnInfo[] createTableColumnInfo() {
        NabuccoTableColumnInfo col1 = new NabuccoTableColumnInfo(KEY_COLUMN_KEY, KEY_COLUMN_KEY, 200, SWT.LEFT,
                SWT.CENTER, new SchemaConfigListViewSchemaConfigKeyLabelProvider());
        col1.setHidable(false);

        NabuccoTableColumnInfo col2 = new NabuccoTableColumnInfo(NAME_COLUMN_KEY, NAME_COLUMN_KEY, 400, SWT.LEFT,
                SWT.CENTER, new SchemaConfigListViewSchemaConfigNameLabelProvider());
        col2.setHidable(false);

        NabuccoTableColumnInfo col3 = new NabuccoTableColumnInfo(DESCRIPTION_COLUMN_KEY, DESCRIPTION_COLUMN_KEY, 400,
                SWT.LEFT, SWT.LEFT, new SchemaConfigListViewSchemaConfigDescriptionLabelProvider());

        return new NabuccoTableColumnInfo[] { col1, col2, col3, };
    }

}
