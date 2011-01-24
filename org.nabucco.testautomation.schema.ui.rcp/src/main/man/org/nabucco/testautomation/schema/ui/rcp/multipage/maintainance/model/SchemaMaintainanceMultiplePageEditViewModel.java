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
package org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model;

import java.io.Serializable;
import java.util.Map;

import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.widgets.Menu;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjectionReciever;
import org.nabucco.framework.base.facade.component.injector.NabuccoInjector;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.model.MultiPageEditViewModel;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorTextPart;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.component.picker.dialog.LabelForDialog;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;


/**
 * SchemaMaintainanceMultiplePageEditViewModel
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintainanceMultiplePageEditViewModel extends MultiPageEditViewModel implements
        NabuccoInjectionReciever {

    private MasterDetailTreeNode treeStructure;

    private XMLEditorTextPart xmlStructure;

    private SchemaMaintainanceMultiplePageEditViewModelHandler handler = NabuccoInjector
            .getInstance(SchemaMaintainanceMultiplePageEditViewModel.class).inject(
                    SchemaMaintainanceMultiplePageEditViewModelHandler.class);

    private SchemaConfig schemaConfig;

    /**
     * @param workflowCondition
     */
    public SchemaMaintainanceMultiplePageEditViewModel() {
        setSchemaConfig(handler.createDefaultDatatype());
    }

    // <MASTER DETAIL METHODS>
    /**
     * {@inheritDoc}
     */
    @Override
    public MasterDetailTreeNode add(MasterDetailTreeNode parent, Datatype newChild) {
        MasterDetailTreeNode result = handler.addChild(parent, newChild);
        updateProperty(getPropertyDatatype(), "", "*");
        return result;
    }

    @Override
    public MasterDetailTreeNode getTreeStructure() {
        return treeStructure;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public MasterDetailTreeNode createNewAndAdd(final MasterDetailTreeNode parent,
            final Datatype newChild) {
        // observers will be already informed in the node is added (which is
        // relevant for view)
        // Datatype newChild = handler.create(className);
        MasterDetailTreeNode result = add(parent, newChild);
        return result;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void remove(ISelection child) {
        handler.remove(child);
        updateProperty(getPropertyDatatype(), "", "*");
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public SchemaConfig getRoot() {
        return (SchemaConfig) treeStructure.getDatatype();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Map<String, Datatype[]> getPossibleChildren(Datatype datatype) {
        return handler.getPossibleChildren(datatype);
    }

    // </MASTER DETAIL METHODS>

    // <XML METHODS>
    /**
     * {@inheritDoc}
     */
    @Override
    public boolean parseXML(String content) {
        return xmlStructure.parseXML(content);
    }

    @Override
    public String getXMLText() {
        return xmlStructure.getXML();
    }

    @Override
    public XMLEditorTextPart getXmlStructure() {
        return xmlStructure;
    }

    // </XML METHODS>

    /**
     * Setter.
     * 
     * @param testScript
     *            value
     */
    public void setSchemaConfig(final SchemaConfig schemaConfig) {
        this.schemaConfig = schemaConfig;
        treeStructure = handler.createMasterDetailRepresentation(this.schemaConfig);
        xmlStructure = handler.createXmlRepresentation(this.schemaConfig);

        updateProperty(getPropertyDatatype(), "", "*");
    }

    /**
     * Getter.
     * 
     * @return value
     */
    public SchemaConfig getSchemaConfig() {
        return this.schemaConfig;
    }

    public Map<String, Serializable> getValues() {
        Map<String, Serializable> result = super.getValues();
        result.put("name", schemaConfig.getName());
        return result;
    }

    @Override
    public ElementPickerParameter getElementPickerParameter(Datatype parentDatatype) {
        return handler.getElementPickerParameter(parentDatatype);
    }

    @Override
    public LabelForDialog getLabelForDialog() {
        return handler.getLabelForDialog();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Menu getContextMenu(final ISelection selection, final TreeViewer parent) {
        return handler.getContextMenu(selection, parent);
    }

}
