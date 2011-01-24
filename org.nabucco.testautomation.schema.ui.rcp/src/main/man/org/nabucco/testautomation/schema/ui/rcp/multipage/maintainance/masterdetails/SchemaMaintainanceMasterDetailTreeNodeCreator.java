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

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNode;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorForAllDatatypes;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.MasterDetailTreeNodeCreatorImpl;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;


/**
 * SchemaMaintainanceMasterDetailTreeNodeCreator
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintainanceMasterDetailTreeNodeCreator extends
MasterDetailTreeNodeCreatorImpl<Datatype> {

	/**
	 * {@inheritDoc}
	 */
	@Override
	public MasterDetailTreeNode createNodeTyped(
			final Datatype dataType,
			final MasterDetailTreeNode parent,
			final MasterDetailTreeNodeCreatorForAllDatatypes builder) {
		MasterDetailTreeNode result = new MasterDetailTreeNode(dataType, parent);
		if (dataType instanceof SchemaConfig) {
			SchemaConfig schemaConfig = (SchemaConfig) dataType;
			for (SchemaElement schemaElement : schemaConfig.getSchemaElementList()) {
				MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
				.getInstance().create(schemaElement, result);
				result.getChildren().add(child);
			}
		} else if (dataType instanceof SchemaElement) {
			SchemaElement schemaElementParent = (SchemaElement) dataType;
			for (Attribute attribute : schemaElementParent.getAttributeList()) {
				MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
				.getInstance().create(attribute, result);
				result.getChildren().add(child);
			}
			for (SchemaElement schemaElement : schemaElementParent.getSchemaElementList()) {
				MasterDetailTreeNode child = MasterDetailTreeNodeCreatorForAllDatatypes
				.getInstance().create(schemaElement, result);
				result.getChildren().add(child);
			}
		} 
		return result;
	}





}
