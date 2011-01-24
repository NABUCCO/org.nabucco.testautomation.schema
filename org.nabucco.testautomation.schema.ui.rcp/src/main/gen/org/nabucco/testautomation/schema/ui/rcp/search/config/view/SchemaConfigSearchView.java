/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.ui.rcp.search.config.view;

import org.eclipse.swt.widgets.Composite;
import org.nabucco.framework.plugin.base.view.AbstractNabuccoSearchView;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.framework.plugin.base.view.NabuccoSearchView;
import org.nabucco.testautomation.schema.ui.rcp.search.config.model.SchemaConfigSearchViewModel;

/**
 * SchemaConfigSearchView<p/>Search view for datatype SchemaConfig<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class SchemaConfigSearchView extends AbstractNabuccoSearchView<SchemaConfigSearchViewModel>
        implements NabuccoSearchView {

    private SchemaConfigSearchViewModel model;

    public static final String ID = "org.nabucco.testautomation.schema.ui.search.config.SchemaConfigSearchView";

    /** Constructs a new SchemaConfigSearchView instance. */
    public SchemaConfigSearchView() {
        super();
        model = new SchemaConfigSearchViewModel(this.getCorrespondingListView());
    }

    @Override
    public void createPartControl(final Composite parent,
            final NabuccoMessageManager aMessageManager) {
        this.getLayouter().layout(parent, aMessageManager, model);
    }

    @Override
    public SchemaConfigSearchViewModel getModel() {
        return model;
    }

    @Override
    public String getId() {
        return SchemaConfigSearchView.ID;
    }
}
