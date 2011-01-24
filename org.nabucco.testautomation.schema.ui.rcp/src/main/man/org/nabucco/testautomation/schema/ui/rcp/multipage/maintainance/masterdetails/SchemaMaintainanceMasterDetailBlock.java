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
package org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.masterdetails;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.ui.forms.DetailsPart;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlockLayouter;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.SchemaMaintainanceMultiplePageEditView;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.SchemaMaintainanceMultiplePageEditViewModel;

import org.nabucco.testautomation.ui.rcp.multipage.detail.TestautomationDetailPageView;

/**
 * SchemaMaintainanceMasterDetailBlock
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintainanceMasterDetailBlock extends
        MasterDetailBlock<SchemaMaintainanceMultiplePageEditViewModel> implements
        Layoutable<SchemaMaintainanceMultiplePageEditViewModel> {

    public static String ID = "org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.masterdetails.SchemaMaintainanceMasterDetailBlock";

    public SchemaMaintainanceMasterDetailBlock(SchemaMaintainanceMultiplePageEditViewModel model,
            NabuccoMessageManager messageManager,
            SchemaMaintainanceMultiplePageEditView workflowConditionMultiplePageEditView) {
        super(messageManager, workflowConditionMultiplePageEditView, model);
        this.model = model;
    }

    @Override
    protected void registerPages(DetailsPart arg0) {
    	Map<Class<? extends Datatype>, Set<String>> typeToInvisiblePropertiesMap = this.getTypeToInvisiblePropertiesMap();
        Set<String> readOnlyProperties = new HashSet<String>();
        Set<String> invisibleProperties = new HashSet<String>();
        
    	invisibleProperties.add("id");
    	invisibleProperties.add("version");
        readOnlyProperties.add("level");
        
        detailsPart.registerPage(SchemaElement.class, new TestautomationDetailPageView<SchemaMaintainanceMultiplePageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "SchemaElement", invisibleProperties, readOnlyProperties));
        
        detailsPart.registerPage(SchemaConfig.class, new TestautomationDetailPageView<SchemaMaintainanceMultiplePageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "SchemaConfig", invisibleProperties, new HashSet<String>()));
        
        invisibleProperties.add("type");
        detailsPart.registerPage(Attribute.class, new TestautomationDetailPageView<SchemaMaintainanceMultiplePageEditViewModel>(this, getManagedForm(),
                getManagedFormViewPart(), nabuccoMessageManager, ID, ID + "Attribute",
                invisibleProperties, new HashSet<String>()));
        typeToInvisiblePropertiesMap.put(Attribute.class, invisibleProperties);
    }

    @Override
    protected MasterDetailBlockLayouter<SchemaMaintainanceMultiplePageEditViewModel> getLayouter() {
        return new SchemaMaintainanceMasterDetailBlockLayouter();
    }

}
