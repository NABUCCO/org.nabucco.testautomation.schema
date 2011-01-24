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
package org.nabucco.testautomation.schema.ui.rcp.list.config.view;

import org.eclipse.jface.viewers.ILabelProvider;
import org.eclipse.jface.viewers.ILabelProviderListener;
import org.eclipse.swt.graphics.Image;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;


/**
 * SchemaConfigListViewSchemaConfigDescriptionLabelProvider
 *
 * @author Undefined
 */
public class SchemaConfigListViewSchemaConfigDescriptionLabelProvider implements ILabelProvider {
    /** Constructs a new SchemaConfigListViewSchemaConfigDescriptionLabelProvider instance. */
    public SchemaConfigListViewSchemaConfigDescriptionLabelProvider() {
        super();
    }

    @Override
    public Image getImage(Object arg0) {
        return null;
    }

    @Override
    public String getText(Object arg0) {
        String result = "";
        if ((arg0 instanceof SchemaConfig)) {
            SchemaConfig schemaConfig = ((SchemaConfig) arg0);
            result = ((schemaConfig.getDescription() != null) ? schemaConfig.getDescription()
                    .toString() : "");
        }
        return result;
    }

    @Override
    public void addListener(ILabelProviderListener arg0) {
    }

    @Override
    public void removeListener(ILabelProviderListener arg0) {
    }

    @Override
    public boolean isLabelProperty(Object arg0, String arg1) {
        return false;
    }

    @Override
    public void dispose() {
    }
}