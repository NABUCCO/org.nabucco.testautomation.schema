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
package org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.Serializable;
import java.util.Map;

import org.eclipse.jface.action.ToolBarManager;
import org.eclipse.swt.widgets.ToolBar;
import org.eclipse.swt.widgets.ToolItem;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailHelper;
import org.nabucco.framework.plugin.base.component.multipage.view.MultiPageEditView;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorPage;
import org.nabucco.framework.plugin.base.component.multipage.xml.example.XmlDefaultPage;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.masterdetails.SchemaMaintainanceMasterDetailBlock;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.SchemaMaintainanceMultiplePageEditViewModel;


/**
 * SchemaMaintainanceMultiplePageEditView
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintainanceMultiplePageEditView extends
        MultiPageEditView<SchemaMaintainanceMultiplePageEditViewModel> {

    public static final String ID = "org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.SchemaMaintainanceMultiplePageEditView";

    public static final String TITLE = ID + ".title";

    public static final String TAB_TITLE = ID + ".tabTitle";

    private SchemaMaintainanceMasterDetailBlock schemaMaintainanceMasterDetailBlock;

    public SchemaMaintainanceMultiplePageEditView() {
        model = new SchemaMaintainanceMultiplePageEditViewModel();
    }

    @Override
    protected String getManagedFormTitle() {
        return I18N.i18n(TITLE, getValues());
    }

    @Override
    public MasterDetailBlock<SchemaMaintainanceMultiplePageEditViewModel> getMasterDetailsBlock() {
        if (schemaMaintainanceMasterDetailBlock == null) {
            schemaMaintainanceMasterDetailBlock = new SchemaMaintainanceMasterDetailBlock(model,
                    getMessageManager(), this);
        }
        return schemaMaintainanceMasterDetailBlock;
    }
    
    @Override
	public void postOpen() {
		// Activate or deactivate Reload Button
		refreshReloadButtonState();
		super.model.addPropertyChangeListener("datatype",
				new PropertyChangeListener() {
					@Override
					public void propertyChange(PropertyChangeEvent evt) {
						refreshReloadButtonState();
					}
				});
	}

	private void refreshReloadButtonState() {
		// TODO Develop general concept in plugin.base
		final ToolBar toolBar = ((ToolBarManager) getToolBarManager())
				.getControl();
		ToolItem reloadItem = null;
		ToolItem importItem = null;
		ToolItem saveItem = null;
		ToolItem deleteItem = null;
		ToolItem executeItem = null;

		for (ToolItem item : toolBar.getItems()) {
			if (item.getToolTipText().equals("Reload")) {
				reloadItem = item;
			} else if(item.getToolTipText().equals("Import")) {
				importItem = item;
			} else if(item.getToolTipText().equals("Save")) {
				saveItem = item;
			} else if(item.getToolTipText().equals("Delete")) {
				deleteItem = item;
			} else if(item.getToolTipText().equals("Execute")) {
				executeItem = item;
			}
		}

		if (reloadItem != null) {
			if (super.getModel().getSchemaConfig().getDatatypeState() == DatatypeState.INITIALIZED
					|| !MasterDetailHelper.isDatatypeEditable(super.getModel().getSchemaConfig())) {
				reloadItem.setEnabled(false);
			} else {
				reloadItem.setEnabled(true);
			}
		}
		if (importItem != null) {
			if (MasterDetailHelper.isImportPossible(super.getModel().getSchemaConfig())) {
				importItem.setEnabled(true);
			} else {
				importItem.setEnabled(false);
			}
		}
		if (saveItem != null) {
			if (MasterDetailHelper.isDatatypeEditable(super.getModel().getSchemaConfig())) {
				saveItem.setEnabled(true);
			} else {
				saveItem.setEnabled(false);
			}
		}
		if (deleteItem != null) {
			if (MasterDetailHelper.isDatatypeEditable(super.getModel().getSchemaConfig())) {
				deleteItem.setEnabled(true);
			} else {
				deleteItem.setEnabled(false);
			}
		}
		if (executeItem != null) {
			if (MasterDetailHelper.isDatatypeEditable(super.getModel().getSchemaConfig())) {
				executeItem.setEnabled(true);
			} else {
				executeItem.setEnabled(false);
			}
		}
	}


    /**
     * {@inheritDoc}
     */
    @Override
    public XMLEditorPage getXMLPage() {
        return new XmlDefaultPage();
    }

    public Map<String, Serializable> getValues() {
        return model.getValues();
    }

    @Override
    public String getNewPartName() {
        return I18N.i18n(TAB_TITLE, getValues());
    }

}