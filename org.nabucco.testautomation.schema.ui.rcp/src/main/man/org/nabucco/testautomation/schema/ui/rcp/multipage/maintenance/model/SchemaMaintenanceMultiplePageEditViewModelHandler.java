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
package org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.model;

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.command.CommandHandler;
import org.nabucco.framework.plugin.base.component.multipage.model.MasterDetailAble;
import org.nabucco.framework.plugin.base.component.multipage.model.XmlAble;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;


/**
 * WorkflowConditionMultiplePageEditViewModelHandler
 * 
 * @author Markus Jorroch, PRODYNA AG
 */
public interface SchemaMaintenanceMultiplePageEditViewModelHandler extends
		CommandHandler, MasterDetailAble<Datatype>,
		XmlAble<Datatype> {

	/**
	 * @param className
	 * @return
	 */
	public Datatype create(Class<?> className);

	/**
	 * Create datatype during initializing the model.
	 * 
	 * @return root of all workflow conditions
	 */
	public SchemaConfig createDefaultDatatype();

	/**
     * Return whether possible children are available.
     */
	boolean hasPossibleChildren(Datatype datatype);

}
