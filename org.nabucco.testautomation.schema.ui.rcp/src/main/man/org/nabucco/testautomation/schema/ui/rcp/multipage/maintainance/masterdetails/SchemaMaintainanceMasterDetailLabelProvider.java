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

import java.io.Serializable;
import java.util.AbstractMap;
import java.util.AbstractMap.SimpleEntry;
import java.util.HashMap;
import java.util.Map;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.layout.I18NLabelProviderContributor;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;
import org.nabucco.testautomation.schema.ui.rcp.images.SchemaImageRegistry;


/**
 * WorkflowConditionMasterDetailLabelProvider
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintainanceMasterDetailLabelProvider implements
I18NLabelProviderContributor {

	private static SchemaMaintainanceMasterDetailLabelProvider instance = new SchemaMaintainanceMasterDetailLabelProvider();
	
	private SchemaMaintainanceMasterDetailLabelProvider(){
	}
	
	public static SchemaMaintainanceMasterDetailLabelProvider getInstance(){
		return instance;
	}
	
	/**
	 * {@inheritDoc}
	 */
	@Override
	public Map.Entry<String, Map<String, ? extends Serializable>> getText(
			final Object element) {
		Map.Entry<String, Map<String, ? extends Serializable>> result = null;
		if (element instanceof MasterDetailTreeNode) {
			MasterDetailTreeNode treeNode = (MasterDetailTreeNode) element;
			result = getText(treeNode.getDatatype());
		}
		return result;
	}

	/**
	 * String representing a special datatype.
	 * 
	 * @param datatype
	 * @return
	 */
	private Map.Entry<String, Map<String, ? extends Serializable>> getText(
			final Datatype datatype) {
		Map.Entry<String, Map<String, ? extends Serializable>> result = new AbstractMap.SimpleEntry<String, Map<String, ? extends Serializable>>(
				datatype.toString(), null);

		if (datatype instanceof SchemaElement) {
			SchemaElement schemaElement = (SchemaElement) datatype;
			result = createEntry("schemaElement", "name", schemaElement
					.getName().getValue());
		} else if (datatype instanceof SchemaConfig) {
			SchemaConfig schemaConfig = (SchemaConfig) datatype;
			result = createEntry("schemaConfig", "name", schemaConfig.getName()
					.getValue());
		} else if (datatype instanceof Attribute) {
			Attribute attribute = (Attribute) datatype;
			result = createEntry("schemaConfig", "name", attribute.getName()
					.getValue());
		}
		return result;
	}

	private SimpleEntry<String, Map<String, ? extends Serializable>> createEntry(
			final String i18n, String key, String value) {
		return new AbstractMap.SimpleEntry<String, Map<String, ? extends Serializable>>(
				i18n, createMap(key, value));
	}

	/**
	 * @param string
	 * @param name
	 * @return
	 */
	private Map<String, ? extends Serializable> createMap(final String key,
			final String value) {
		Map<String, String> result = new HashMap<String, String>();
		result.put(key, value);
		return result;
	}

	@Override
	public String getImage(Object element) {
		if (element instanceof MasterDetailTreeNode) {
			Datatype datatype = ((MasterDetailTreeNode) element).getDatatype();
			return getImage(datatype);
		} else if(element instanceof Datatype){
			return getImage((Datatype) element);
		}
		return SchemaImageRegistry.ICON_SCHEMA.getId();
	}

	private String getImage(Datatype datatype) {
		if (datatype instanceof SchemaConfig) {
			return SchemaImageRegistry.ICON_SCHEMA.getId();
		} else if (datatype instanceof SchemaElement) {
			return SchemaImageRegistry.ICON_ELEMENT.getId();
		} else if (datatype instanceof Attribute) {
			return SchemaImageRegistry.ICON_ATTRIBUTE.getId();
		}
		return SchemaImageRegistry.ICON_SCHEMA.getId();
	}

}
