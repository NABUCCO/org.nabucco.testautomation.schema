/*
* Copyright 2010 PRODYNA AG
*
* Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
* http://www.opensource.org/licenses/eclipse-1.0.php or
* http://www.nabucco-source.org/nabucco-license.html
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
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.SchemaConfigListViewSchemaConfigDescriptionComparator;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.SchemaConfigListViewSchemaConfigDescriptionLabelProvider;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.SchemaConfigListViewSchemaConfigNameComparator;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.SchemaConfigListViewSchemaConfigNameLabelProvider;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.SchemaConfigListViewTableFilter;
import org.nabucco.testautomation.schema.ui.rcp.list.config.view.SchemaConfigListViewWidgetFactory;


/**
 * @author Stefan Hüttenrauch, PRODYNA AG
 * 
 */
public class SchemaConfigListViewLayouter extends NabuccoAbstractListLayouter<SchemaConfigListViewModel> {

	/**
	 * Layouts the table
	 **/
	@Override
	public NabuccoTableViewer layout(final Composite parent,
			final NabuccoMessageManager messageManager,
			final SchemaConfigListViewModel model, final Layoutable<SchemaConfigListViewModel> view) {

		NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);

		SchemaConfigListViewWidgetFactory widgetFactory = new SchemaConfigListViewWidgetFactory(
				ntk);

		NabuccoTableParameter parameter = new NabuccoTableParameter(
				new NabuccoDefaultTableSorter<SchemaConfig>(createComparators()),
				new SchemaConfigListViewTableFilter(),
				new NabuccoDefaultListContentProvider(model),
				createTableColumnInfo(), getDoubleClickCommand(view
						.getManagedFormViewPart()));

		return widgetFactory.createTable(parent, parameter, model);
	}

	private List<Comparator<SchemaConfig>> createComparators() {
		List<Comparator<SchemaConfig>> comparators = new ArrayList<Comparator<SchemaConfig>>();
		comparators.add(new SchemaConfigListViewSchemaConfigNameComparator());
		comparators
				.add(new SchemaConfigListViewSchemaConfigDescriptionComparator());

		return comparators;
	}

	/**
	 * Creates needed tables.
	 * 
	 * @return table columns
	 */
	private NabuccoTableColumnInfo[] createTableColumnInfo() {
		NabuccoTableColumnInfo[] result = {
				new NabuccoTableColumnInfo("name",
						"This is a SchemaConfig name.", 200, SWT.CENTER,
						SWT.CENTER,
						new SchemaConfigListViewSchemaConfigNameLabelProvider()),
				new NabuccoTableColumnInfo(
						"Description",
						"This is a SchemaConfig description",
						300,
						SWT.RIGHT,
						SWT.RIGHT,
						new SchemaConfigListViewSchemaConfigDescriptionLabelProvider()) };

		return result;
	}

}
