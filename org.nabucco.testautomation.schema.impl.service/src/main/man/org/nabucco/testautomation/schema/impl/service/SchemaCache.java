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
package org.nabucco.testautomation.schema.impl.service;

import java.util.HashMap;
import java.util.Map;

import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;


/**
 * SchemaCache
 * 
 * @author Steffen Schmidt, PRODYNA AG
 */
public class SchemaCache {

	private static SchemaCache instance;
	
	private final Map<Long, SchemaConfig> schemaConfigCache = new HashMap<Long, SchemaConfig>();
	
	private final Map<Long, SchemaElement> schemaElementCache = new HashMap<Long, SchemaElement>();
	
	private SchemaCache() {}
	
	public static synchronized SchemaCache getInstance() {
		
		if (instance == null) {
			instance = new SchemaCache();
		}
		return instance;
	}
	
	public synchronized SchemaElement getCachedSchemaElement(Long id) {
		
		if (id == null) {
			return null;
		}
		return this.schemaElementCache.get(id);
	}
	
	public synchronized boolean isSchemaElementCached(Long id) {
		
		if (id == null) {
			return false;
		}
		return this.schemaElementCache.containsKey(id);
	}
	
	public synchronized void cacheSchemaElement(SchemaElement schemaElement) {
		
		if (schemaElement == null || schemaElement.getId() == null) {
			return;
		}
		this.schemaElementCache.put(schemaElement.getId(), schemaElement);
	}
	
	public synchronized SchemaConfig getCachedSchemaConfig(Long id) {
		
		if (id == null) {
			return null;
		}
		return this.schemaConfigCache.get(id);
	}
	
	public synchronized boolean isSchemaConfigCached(Long id) {
		
		if (id == null) {
			return false;
		}
		return this.schemaConfigCache.containsKey(id);
	}
	
	public synchronized void cacheSchemaConfig(SchemaConfig schemaConfig) {
		
		if (schemaConfig == null || schemaConfig.getId() == null) {
			return;
		}
		this.schemaConfigCache.put(schemaConfig.getId(), schemaConfig);
	}
	
	public synchronized void clear() {
		this.schemaConfigCache.clear();
		this.schemaElementCache.clear();
	}
}
