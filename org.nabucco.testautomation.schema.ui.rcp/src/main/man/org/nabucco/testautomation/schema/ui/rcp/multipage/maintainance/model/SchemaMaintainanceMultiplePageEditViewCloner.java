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

import org.nabucco.framework.base.facade.datatype.Datatype;
import org.nabucco.framework.plugin.base.Activator;
import org.nabucco.framework.plugin.base.component.multipage.masterdetail.master.contextmenu.CloneDatatypeMenuItemCloner;

/**
 * SchemaMaintainanceMultiplePageEditViewCloner
 * 
 * @author Michael Krausse, PRODYNA AG
 */
public class SchemaMaintainanceMultiplePageEditViewCloner implements CloneDatatypeMenuItemCloner {

    @Override
    public Datatype clone(Datatype clone) {
        Activator.getDefault().logDebug(
                "Clone was called and not implemented. return clone not cloned");
        return clone;
    }

}
