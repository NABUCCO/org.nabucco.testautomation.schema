/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.search.config.view;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.beans.BeansObservables;
import org.eclipse.core.databinding.observable.value.IObservableValue;
import org.eclipse.jface.databinding.swt.SWTObservables;
import org.eclipse.swt.SWT;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Label;
import org.eclipse.swt.widgets.Text;
import org.nabucco.framework.plugin.base.layout.WidgetFactory;
import org.nabucco.framework.plugin.base.view.NabuccoFormToolkit;
import org.nabucco.testautomation.schema.ui.rcp.search.config.model.SchemaConfigSearchViewModel;

/**
 * SchemaConfigSearchViewWidgetFactory<p/>Search view for datatype SchemaConfig<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SchemaConfigSearchViewWidgetFactory extends WidgetFactory {

    private SchemaConfigSearchViewModel model;

    public static final String LABEL_SCHEMACONFIGNAME = "SchemaConfig.name";

    public static final String OBSERVE_VALUE_SCHEMACONFIGNAME = SchemaConfigSearchViewModel.PROPERTY_SCHEMACONFIG_NAME;

    public static final String LABEL_SCHEMACONFIGDESCRIPTION = "SchemaConfig.description";

    public static final String OBSERVE_VALUE_SCHEMACONFIGDESCRIPTION = SchemaConfigSearchViewModel.PROPERTY_SCHEMACONFIG_DESCRIPTION;

    /**
     * Constructs a new SchemaConfigSearchViewWidgetFactory instance.
     *
     * @param aModel the SchemaConfigSearchViewModel.
     * @param nabuccoFormToolKit the NabuccoFormToolkit.
     */
    public SchemaConfigSearchViewWidgetFactory(final NabuccoFormToolkit nabuccoFormToolKit,
            final SchemaConfigSearchViewModel aModel) {
        super(nabuccoFormToolKit);
        model = aModel;
    }

    /**
     * CreateLabelSchemaConfigName.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelSchemaConfigName(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_SCHEMACONFIGNAME);
    }

    /**
     * CreateInputFieldSchemaConfigName.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldSchemaConfigName(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model,
                OBSERVE_VALUE_SCHEMACONFIGNAME);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }

    /**
     * CreateLabelSchemaConfigDescription.
     *
     * @param parent the Composite.
     * @return the Label.
     */
    public Label createLabelSchemaConfigDescription(Composite parent) {
        return nabuccoFormToolKit.createRealLabel(parent, LABEL_SCHEMACONFIGDESCRIPTION);
    }

    /**
     * CreateInputFieldSchemaConfigDescription.
     *
     * @param parent the Composite.
     * @return the Text.
     */
    public Text createInputFieldSchemaConfigDescription(Composite parent) {
        Text result = nabuccoFormToolKit.createTextInput(parent);
        DataBindingContext bindingContext = new DataBindingContext();
        IObservableValue uiElement = SWTObservables.observeText(result, SWT.Modify);
        IObservableValue modelElement = BeansObservables.observeValue(model,
                OBSERVE_VALUE_SCHEMACONFIGDESCRIPTION);
        bindingContext.bindValue(uiElement, modelElement, null, null);
        return result;
    }
}
