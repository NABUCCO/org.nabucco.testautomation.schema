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
package org.nabucco.testautomation.schema.ui.rcp.multipage.maintenance.xml;

import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;

public class XmlFactory {

	public static String createStartTag(SchemaConfig schemaConfig) {
		String startTag = "<SchemaConfig name=\"" + schemaConfig.getName().getValue() + "\">";
		return startTag;
	}
	
	public static String createEndTag(SchemaConfig schemaConfig) {
		String endTag = "</SchemaConfig>";
		return endTag;
	}
	
	public static String createContent(SchemaConfig schemaConfig) {
		return null;
	}
	
	public static String createStartTag(SchemaElement schemaElement) {
		String startTag = "<SchemaElement name=\"" + schemaElement.getName().getValue() + "\">";
		return startTag;
	}
	
	public static String createEndTag(SchemaElement schemaElement) {
		String endTag = "</" + schemaElement.getName().getValue() + ">";
		return endTag;
	}
	
	public static String createContent(SchemaElement schemaElement) {
		return null;
	}
	
}
