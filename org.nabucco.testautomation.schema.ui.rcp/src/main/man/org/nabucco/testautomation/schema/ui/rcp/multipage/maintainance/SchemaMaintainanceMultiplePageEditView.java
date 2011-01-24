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

import java.io.Serializable;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
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