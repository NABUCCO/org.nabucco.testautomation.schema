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
package org.nabucco.testautomation.schema.ui.rcp.search.config.view;

import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.layout.RowLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Section;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.layout.NabuccoLayouter;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.schema.ui.rcp.search.config.model.SchemaConfigSearchViewModel;

/**
 * Layouter for SchemaConfig Search View.
 * 
 * @author Stefan Huettenrauch, PRODYNA AG
 */
public class SchemaConfigSearchViewLayouter implements NabuccoLayouter<SchemaConfigSearchViewModel> {

    private final static String SCHEMA_CONFIG_TEXT = SchemaConfigSearchView.ID + ".section";

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager, SchemaConfigSearchViewModel model,
            Layoutable<SchemaConfigSearchViewModel> view) {
        return layout(parent, messageManager, model);
    }

    @Override
    public Composite layout(Composite parent, NabuccoMessageManager messageManager, SchemaConfigSearchViewModel model) {

        NabuccoFormToolkit ntk = new NabuccoFormToolkit(parent);
        SchemaConfigSearchViewWidgetFactory widgetFactory = new SchemaConfigSearchViewWidgetFactory(ntk, model);

        // build a section to host the other controls
        Section section = ntk.createSection(parent, SCHEMA_CONFIG_TEXT, new RowLayout());
        Composite child = ntk.createComposite(section, new GridLayout(2, false));
        section.setClient(child);

        // add description and name label and input fields (pair-wise)

        layoutName(widgetFactory, child);
        layoutKey(widgetFactory, child);

        return null;
    }

    /**
     * Layouts the name label and text field.
     * 
     * @param widgetFactory
     *            the widget factory.
     * @param parent
     *            the parent composite
     */
    private void layoutName(SchemaConfigSearchViewWidgetFactory widgetFactory, Composite parent) {
        Label label = widgetFactory.createLabelSchemaConfigName(parent);
        this.layout(label);

        Text text = widgetFactory.createInputFieldSchemaConfigName(parent);
        this.layout(text);
    }

    /**
     * Layouts the description label and text field.
     * 
     * @param widgetFactory
     *            the widget factory
     * @param parent
     *            the parent composite
     */
    private void layoutKey(SchemaConfigSearchViewWidgetFactory widgetFactory, Composite parent) {
        Label label = widgetFactory.createLabelSchemaConfigKey(parent);
        this.layout(label);

        Text text = widgetFactory.createInputFieldSchemaConfigKey(parent);
        this.layout(text);
    }

    /**
     * Layout the text field.
     * 
     * @param text
     *            the text field
     */
    private void layout(Text text) {
        GridData data = new GridData();
        data.widthHint = 180;
        text.setLayoutData(data);
    }

    /**
     * Layout the label.
     * 
     * @param label
     *            the label
     */
    private void layout(Label label) {
        GridData data = new GridData();
        data.widthHint = 100;
        label.setLayoutData(data);
    }

}
