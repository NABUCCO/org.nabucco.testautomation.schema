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
package org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.masterdetails;

import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.eclipse.ui.forms.DetailsPart;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlock;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailBlockLayouter;
import org.nabucco.framework.plugin.base.layout.Layoutable;
import org.nabucco.framework.plugin.base.view.NabuccoMessageManager;
import org.nabucco.testautomation.property.ui.rcp.multipage.detail.PropertyDetailPageView;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.SchemaMaintenanceMultiplePageEditView;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.model.SchemaMaintenanceMultiplePageEditViewModel;

/**
 * SchemaMaintenanceMasterDetailBlock
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintenanceMasterDetailBlock extends
        MasterDetailBlock<SchemaMaintenanceMultiplePageEditViewModel> implements
        Layoutable<SchemaMaintenanceMultiplePageEditViewModel> {

    public static String ID = "org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.masterdetails.SchemaMaintenanceMasterDetailBlock";

    public SchemaMaintenanceMasterDetailBlock(SchemaMaintenanceMultiplePageEditViewModel model,
            NabuccoMessageManager messageManager,
            SchemaMaintenanceMultiplePageEditView workflowConditionMultiplePageEditView) {
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
    	readOnlyProperties.add("owner");
        readOnlyProperties.add("level");
        readOnlyProperties.add("identificationKey");
        
        detailsPart.registerPage(SchemaElement.class, new PropertyDetailPageView<SchemaMaintenanceMultiplePageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "SchemaElement", invisibleProperties, readOnlyProperties));
        
        detailsPart.registerPage(SchemaConfig.class, new PropertyDetailPageView<SchemaMaintenanceMultiplePageEditViewModel>(this,
                getManagedForm(), getManagedFormViewPart(), nabuccoMessageManager, ID, ID
                        + "SchemaConfig", invisibleProperties, readOnlyProperties));
        
        detailsPart.registerPage(Attribute.class, new PropertyDetailPageView<SchemaMaintenanceMultiplePageEditViewModel>(this, getManagedForm(),
                getManagedFormViewPart(), nabuccoMessageManager, ID, ID + "Attribute",
                invisibleProperties, new HashSet<String>()));
        typeToInvisiblePropertiesMap.put(Attribute.class, invisibleProperties);
    }

    @Override
    protected MasterDetailBlockLayouter<SchemaMaintenanceMultiplePageEditViewModel> getLayouter() {
        return new SchemaMaintenanceMasterDetailBlockLayouter();
    }

}
