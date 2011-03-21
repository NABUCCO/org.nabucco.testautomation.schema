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
package org.nabucco.testautomation.schema.ui.rcp.search.config.model;

import java.util.List;

import org.nabucco.framework.base.facade.datatype.Description;
import org.nabucco.framework.base.facade.datatype.Name;
import org.nabucco.framework.base.facade.datatype.Owner;
import org.nabucco.framework.base.facade.exception.client.ClientException;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchModel;
import org.nabucco.framework.plugin.base.component.search.model.NabuccoComponentSearchParameter;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;
import org.nabucco.testautomation.schema.ui.rcp.browser.config.SchemaConfigListViewBrowserElement;
import org.nabucco.testautomation.schema.ui.rcp.communication.SchemaComponentServiceDelegateFactory;
import org.nabucco.testautomation.schema.ui.rcp.communication.search.SearchSchemaConfigDelegate;
import org.nabucco.testautomation.schema.ui.rcp.search.config.model.SchemaConfigSearchViewModel;


/**
 * Does the search for SchemaConfig.
 * 
 * @author Stefan Huettenrauch, PRODYNA AG
 * 
 */
public class SchemaConfigSearchBusinessModel implements
		NabuccoComponentSearchModel {

	public static final String ID = "org.nabucco.testautomation.schema.ui.rcp.search.config.model.SchemaConfigSearchBusinessModel";

	/**
	 * {@inheritDoc}
	 */
	@Override
	public SchemaConfigListViewBrowserElement search(
			NabuccoComponentSearchParameter parameter) {
		
		SchemaConfigListViewBrowserElement result = null;
		
		if (parameter instanceof SchemaConfigSearchViewModel) {
			SchemaConfigSearchViewModel testSchemaConfigViewModel = (SchemaConfigSearchViewModel) parameter;
			SchemaConfigSearchMsg rq = createSchemaConfigSearchMsg(testSchemaConfigViewModel);
			result = new SchemaConfigListViewBrowserElement(search(rq).toArray(
					new SchemaConfig[0]));
		}
		return result;
	}

	private List<SchemaConfig> search(final SchemaConfigSearchMsg rq) {
		
		List<SchemaConfig> result = null;
		try {
			SearchSchemaConfigDelegate searchDelegate = SchemaComponentServiceDelegateFactory
					.getInstance().getSearchSchemaConfig();
			SchemaConfigListMsg response = searchDelegate
					.searchSchemaConfig(rq);
			result = response.getSchemaConfigList();
		} catch (ClientException e) {
			Activator.getDefault().logError(e);
		}
		return result;
	}

	private SchemaConfigSearchMsg createSchemaConfigSearchMsg(
			SchemaConfigSearchViewModel searchViewModel) {
		
		SchemaConfigSearchMsg result = new SchemaConfigSearchMsg();
		String owner = searchViewModel.getOwner();

        if (owner != null && owner.length() > 0) {
        	result.setOwner(new Owner(owner));
        }
		result.setName(getName(searchViewModel));
		result.setDescription(getDescription(searchViewModel));

		return result;
	}

	private Description getDescription(
			final SchemaConfigSearchViewModel searchViewModel) {
		
		Description result = new Description();
		String description = searchViewModel.getSchemaConfigDescription();

		result.setValue((description == null || description.length() == 0) ? null
				: description);
		return result;
	}

	private Name getName(SchemaConfigSearchViewModel searchViewModel) {
		
		Name result = new Name();
		String name = searchViewModel.getSchemaConfigName();

		result.setValue((name == null || name.length() == 0) ? null : name);
		return result;
	}

}
