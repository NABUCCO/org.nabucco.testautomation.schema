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

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.StructuredSelection;
import org.eclipse.jface.viewers.TreeSelection;
import org.eclipse.jface.viewers.TreeViewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.widgets.Menu;
import org.eclipse.swt.widgets.MenuItem;
import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.base.facade.datatype.DatatypeState;
import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableColumnInfo;
import org.nabucco.framework.plugin.base.component.list.view.NabuccoTableSorter;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailHelper;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorForAllDatatypes;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.addDialog.AddDialogLabelProvider;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.contextmenu.NewDatatypeMenuItem;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.contextmenu.RemoveDatatypeMenuItem;
import org.nabucco.framework.plugin.base.component.multipage.xml.DatatypeXMLEditorTextPartCreator;
import org.nabucco.framework.plugin.base.component.multipage.xml.XMLEditorTextPart;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerContentProvider;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerDefaultContentProvider;
import org.nabucco.framework.plugin.base.component.picker.dialog.ElementPickerParameter;
import org.nabucco.framework.plugin.base.component.picker.dialog.LabelForDialog;
import org.nabucco.framework.plugin.base.layout.ImageProvider;
import org.nabucco.framework.plugin.base.logging.NabuccoLogMessage;
import org.nabucco.testautomation.facade.datatype.base.HierarchyLevelType;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;
import org.nabucco.testautomation.schema.facade.message.AttributeMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementMsg;
import org.nabucco.testautomation.schema.ui.rcp.communication.SchemaComponentServiceDelegateFactory;
import org.nabucco.testautomation.schema.ui.rcp.communication.produce.ProduceAttributeDelegate;
import org.nabucco.testautomation.schema.ui.rcp.communication.produce.ProduceSchemaConfigDelegate;
import org.nabucco.testautomation.schema.ui.rcp.communication.produce.ProduceSchemaElementDelegate;
import org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.masterdetails.SchemaMaintainanceMasterDetailLabelProvider;

/**
 * SchemaMaintainanceMultiplePageEditViewModelHandlerImpl
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintainanceMultiplePageEditViewModelHandlerImpl implements SchemaMaintainanceMultiplePageEditViewModelHandler {

	private static final String ADD_ICON = "icons/add.png";

	private static final String DELETE_ICON = "icons/delete.png";

	private static final String NEW_ELEMENT = ".New";

	private static final String ID = "org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.SchemaMaintainanceMultiplePageEditViewModelHandlerImpl";

	private static final String SCHEMA_ELEMENT = ".SchemaElement";

	private static final String ATTRIBUTE = ".Attribute";

	private static final String REMOVE = ".Remove";

	private Map<String, Datatype[]> possibleChildren;

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Menu getContextMenu(final ISelection selection, final TreeViewer treeViewer) {
		Menu result = new Menu(treeViewer.getTree());
		TreeSelection treeSelection = (TreeSelection) selection;
		Object firstElement = treeSelection.getFirstElement();
		if (firstElement instanceof MasterDetailTreeNode) {
			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) firstElement;
			Datatype datatype = treeNode.getDatatype();

			if(!MasterDetailHelper.isDatatypeEditable(datatype)){
				return null;
			}
			
			Menu newElementMenu = createMenu(result, ID + NEW_ELEMENT, ADD_ICON);

			if (datatype instanceof SchemaConfig) {
				// create menu entries for each schema element
				Datatype schemaConfig = create(SchemaElement.class);
				Image image = ImageProvider.createImage(SchemaMaintainanceMasterDetailLabelProvider.getInstance().getImage(schemaConfig));
				new NewDatatypeMenuItem(newElementMenu, treeNode, this, schemaConfig, treeViewer, ID + SCHEMA_ELEMENT, null, image);
			} else if (datatype instanceof SchemaElement) {
				// create menu entries for each schema element
				Datatype schemaElement = create(SchemaElement.class);
				Image image = ImageProvider.createImage(SchemaMaintainanceMasterDetailLabelProvider.getInstance().getImage(schemaElement));
				new NewDatatypeMenuItem(newElementMenu, treeNode, this, schemaElement, treeViewer, ID + SCHEMA_ELEMENT, null, image);
				
				Datatype attribute = create(Attribute.class);
				image = ImageProvider.createImage(SchemaMaintainanceMasterDetailLabelProvider.getInstance().getImage(attribute));
				new NewDatatypeMenuItem(newElementMenu, treeNode, this, attribute, treeViewer, ID + ATTRIBUTE, null, image);

				// Separator
				new MenuItem(result, SWT.SEPARATOR);

				// Remove
				image = ImageProvider.createImage(DELETE_ICON);
				new RemoveDatatypeMenuItem(result, treeNode, this, treeViewer, ID + REMOVE, null, image);
			} else if (datatype instanceof Attribute) {
				newElementMenu.getParentItem().setEnabled(false);
				
				// Separator
				new MenuItem(result, SWT.SEPARATOR);

				// Remove
				Image image = ImageProvider.createImage(DELETE_ICON);
				new RemoveDatatypeMenuItem(result, treeNode, this, treeViewer, ID + REMOVE, null, image);
			}
		}
		return result;
	}

	/**
	 * Create Menu
	 * 
	 * @param parentMenu
	 * @param label
	 * @return
	 */
	private Menu createMenu(final Menu parentMenu, final String label, String imagePath) {
		MenuItem newElementMenuIten = new MenuItem(parentMenu, SWT.CASCADE);
		newElementMenuIten.setText(I18N.i18n(label));
		Image image = ImageProvider.createImage(imagePath);
		newElementMenuIten.setImage(image);
		Menu newElementMenu = new Menu(parentMenu);
		newElementMenuIten.setMenu(newElementMenu);
		return newElementMenu;
	}

	/**
	 * Return whether possible children are available.
	 */
	@Override
	public boolean hasPossibleChildren(Datatype datatype) {
		return datatype instanceof SchemaElement || datatype instanceof SchemaConfig;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map<String, Datatype[]> getPossibleChildren(Datatype datatype) {
		possibleChildren = new HashMap<String, Datatype[]>();
		if (datatype instanceof SchemaConfig) {
			possibleChildren.put(" ", new Datatype[] { create(SchemaElement.class) });
		} else if (datatype instanceof SchemaElement) {
			possibleChildren.put(" ", new Datatype[] { create(SchemaElement.class), create(Attribute.class) });
		}
		return possibleChildren;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MasterDetailTreeNode addChild(final MasterDetailTreeNode parent, final Datatype newChild) {
		MasterDetailTreeNode result = null;
		Datatype parentDatatype = parent.getDatatype();

		// Only to composites children should be added
		if (newChild instanceof SchemaElement) {
			SchemaElement newSchemaElement = (SchemaElement) newChild;
			if (parentDatatype instanceof SchemaElement) {
				SchemaElement parentSchemaElement = (SchemaElement) parentDatatype;
				// Set HierarchyLevel
				newSchemaElement.setLevel(HierarchyLevelType.values()[parentSchemaElement.getLevel().getOrdinal() + 1]);
				result = addChildToTree(parent, newSchemaElement);
				parentSchemaElement.getSchemaElementList().add(newSchemaElement);
			} else if (parentDatatype instanceof SchemaConfig) {
				SchemaConfig parentSchemaElement = (SchemaConfig) parentDatatype;
				// Set HierarchyLevel
				newSchemaElement.setLevel(HierarchyLevelType.ONE);
				result = addChildToTree(parent, newSchemaElement);
				parentSchemaElement.getSchemaElementList().add(newSchemaElement);
			}
		} else if (newChild instanceof Attribute) {
			Attribute attribute = (Attribute) newChild;
			SchemaElement parentSchemaElement = (SchemaElement) parentDatatype;
			result = addChildToTree(parent, attribute);
			parentSchemaElement.getAttributeList().add(attribute);
		}
		if (result == null) {
			Activator.getDefault().logError(new NabuccoLogMessage(SchemaMaintainanceMultiplePageEditViewModelHandlerImpl.class, "FAILED to add new child!"));
		}
		return result;
	}

	private MasterDetailTreeNode addChildToTree(final MasterDetailTreeNode parent, final Datatype newChild) {
		MasterDetailTreeNode result = MasterDetailTreeNodeCreatorForAllDatatypes.getInstance().create(newChild, parent);
		
		if(newChild instanceof Attribute){
			List<MasterDetailTreeNode> children = parent.getChildren();
			int indexToInsert = 0;
			for (MasterDetailTreeNode masterDetailTreeNode : children) {
				if(masterDetailTreeNode.getDatatype() instanceof SchemaElement){
					indexToInsert = children.indexOf(masterDetailTreeNode);
					break;
				}
			}
			parent.getChildren().add(indexToInsert, result);
		} else {
			parent.getChildren().add(result);
		}
		
		Datatype parentDatatype = parent.getDatatype();
		if (parentDatatype.getDatatypeState() == DatatypeState.PERSISTENT) {
			parentDatatype.setDatatypeState(DatatypeState.MODIFIED);
		}
		return result;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public void remove(ISelection child) {
		StructuredSelection ssel = (StructuredSelection) child;
		MasterDetailTreeNode nodeToRemove = (MasterDetailTreeNode) ssel.getFirstElement();
		MasterDetailTreeNode parentNode = nodeToRemove.getParent();
		if (parentNode == null) {
			return;
		}
		Datatype datatypeToRemove = nodeToRemove.getDatatype();
		Datatype parentDatatype = parentNode.getDatatype();
		if (parentDatatype instanceof SchemaConfig) {
			SchemaConfig parentSchemaConfig = (SchemaConfig) parentDatatype;
			parentSchemaConfig.getSchemaElementList().remove(datatypeToRemove);
		} else if (parentDatatype instanceof SchemaElement) {
			SchemaElement parentSchemaElement = (SchemaElement) parentDatatype;
			if (datatypeToRemove instanceof SchemaElement) {
				parentSchemaElement.getSchemaElementList().remove(datatypeToRemove);
			} else {
				parentSchemaElement.getAttributeList().remove(datatypeToRemove);
			}
		}
		if (datatypeToRemove.getDatatypeState() == DatatypeState.PERSISTENT) {
			datatypeToRemove.setDatatypeState(DatatypeState.DELETED);
		}
		if (parentDatatype.getDatatypeState() == DatatypeState.PERSISTENT) {
			parentDatatype.setDatatypeState(DatatypeState.MODIFIED);
		}
		parentNode.getChildren().remove(nodeToRemove);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MasterDetailTreeNode createMasterDetailRepresentation(Datatype datatype) {
		return MasterDetailTreeNodeCreatorForAllDatatypes.getInstance().create(datatype, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public XMLEditorTextPart createXmlRepresentation(Datatype datatype) {
		return DatatypeXMLEditorTextPartCreator.getInstance().create(datatype, null);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public Datatype create(Class<?> className) {
		try {
			Datatype result = null;
			SchemaComponentServiceDelegateFactory schemaComponentServiceDelegateFactory = SchemaComponentServiceDelegateFactory.getInstance();
			if (className.equals(SchemaConfig.class)) {
				try {
					ProduceSchemaConfigDelegate produceSchemaConfigDelegate = schemaComponentServiceDelegateFactory.getProduceSchemaConfig();
					SchemaConfigMsg response = produceSchemaConfigDelegate.produceSchemaConfig(new EmptyServiceMessage());
					result = response.getSchemaConfig();
				} catch (ClientException e) {
					Activator.getDefault().logError(e);
				}

			} else if (className.equals(SchemaElement.class)) {
				try {
					ProduceSchemaElementDelegate produceSchemaElementDelegate = schemaComponentServiceDelegateFactory.getProduceSchemaElement();
					SchemaElementMsg response = produceSchemaElementDelegate.produceSchemaElement(new EmptyServiceMessage());
					result = response.getSchemaElement();
				} catch (ClientException e) {
					Activator.getDefault().logError(e);
				}
			} else if (className.equals(Attribute.class)) {
				try {
					ProduceAttributeDelegate produceAttributeDelegate = schemaComponentServiceDelegateFactory.getProduceAttribute();
					AttributeMsg response = produceAttributeDelegate.produceAttribute(new EmptyServiceMessage());

					result = response.getAttribute();
				} catch (ClientException e) {
					Activator.getDefault().logError(e);
				}
			} else {
				result = (Datatype) className.newInstance();
			}
			return result;
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SchemaConfig createDefaultDatatype() {
		return (SchemaConfig) create(SchemaConfig.class);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public AddDialogLabelProvider getAddDialogLabelProvider() {
		return new SchemaMaintainanceMultiplePageAddDialogLabelProvider();
	}

	@Override
	public ElementPickerParameter getElementPickerParameter(Datatype parentDatatype) {
		return getElementPickerParameter(new ElementPickerDefaultContentProvider(getPossibleChildren(parentDatatype)));
	}

	public ElementPickerParameter getElementPickerParameter(ElementPickerContentProvider contentProvider) {
		ILabelProvider inputFieldLabelProvider = null;
		NabuccoTableColumnInfo[] tableColumnInfo = createColumnInfo();
		NabuccoTableSorter tableSorter = null;
		ElementPickerParameter result = new ElementPickerParameter(tableSorter, inputFieldLabelProvider, contentProvider, tableColumnInfo);

		return result;
	}

	private NabuccoTableColumnInfo[] createColumnInfo() {
		NabuccoTableColumnInfo[] result = new NabuccoTableColumnInfo[] { new NabuccoTableColumnInfo(
				"org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.title",
				"org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.tooltip", 200,
				new SchemaMaintainanceMasterDetailAddDialogLabelProvider()) };
		return result;
	}

	@Override
	public LabelForDialog getLabelForDialog() {
		LabelForDialog result = new LabelForDialog("org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.title",
				"org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.message",
				"org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.shellTitle",
				"org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.messageTable",
				"org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.messageCombo",
				"org.nabucco.testautomation.schema.ui.rcp.multipage.maintainance.model.pathLabel");
		return result;
	}

}
