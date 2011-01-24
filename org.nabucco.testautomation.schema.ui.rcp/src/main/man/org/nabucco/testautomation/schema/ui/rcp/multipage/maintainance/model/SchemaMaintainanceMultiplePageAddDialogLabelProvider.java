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

import org.nabucco.framework.base.facade.datatype.utils.I18N;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.addDialog.AddDialogLabelProvider;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.attribute.Attribute;


/**
 * SchemaMaintainanceMultiplePageAddDialogLabelProvider
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public class SchemaMaintainanceMultiplePageAddDialogLabelProvider extends
AddDialogLabelProvider {


	/**
	 * {@inheritDoc}
	 */
	@Override
	public String getText(final Object obj) {
		String result = null;
		if(obj instanceof SchemaElement){
			String name = ((SchemaElement) obj).getName().getValue();
			result = name;
		} else if(obj instanceof Attribute){
			String name = ((Attribute) obj).getName().getValue();
			result = name;
		}
		if (result == null) {
			return super.getText(obj);
		}
		return I18N.i18n(result);
	}

}
