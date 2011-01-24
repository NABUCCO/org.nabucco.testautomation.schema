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
package org.nabucco.testautomation.schema.ui.rcp.images;

/**
 * Global Registry of all component images.
 * <p>
 * Used to register / create component images with
 * {@link org.nabucco.framework.plugin.base.layout.ImageProvider}.
 * 
 * @author Marco Sussek, PRODYNA AG
 */
public enum SchemaImageRegistry {

	ICON_SCHEMA("icons/schema/schema.png", "/icons/schema.png"),

	ICON_ELEMENT("icons/schema/element.png", "/icons/element.png"),

	ICON_ATTRIBUTE("icons/schema/attribute.png", "/icons/attribute.png");

	/**
	 * The unique symbolic name of the image used to identify the image in the
	 * <code>ImageProvider</code>.
	 */
	private String id;

	/**
	 * The physical path of the image within the component JAR.
	 */
	private String resourcePath;

	private SchemaImageRegistry(String id, String resourcePath) {
		this.id = id;
		this.resourcePath = resourcePath;
	}

	/**
	 * Gets the unique symbolic name of the image used to identify the image in
	 * the <code>ImageProvider</code>.
	 * 
	 * @return the id
	 */
	public String getId() {
		return id;
	}

	/**
	 * Gets the physical path of the image within the component JAR.
	 * 
	 * @return the resourcePath
	 */
	public String getResourcePath() {
		return resourcePath;
	}
}
