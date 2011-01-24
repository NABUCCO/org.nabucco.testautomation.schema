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
package org.nabucco.testautomation.schema;

import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.test.RuntimeTestSupport;
import org.nabucco.testautomation.schema.facade.component.SchemaComponent;
import org.nabucco.testautomation.schema.facade.component.SchemaComponentLocator;
import org.nabucco.testautomation.schema.facade.datatype.SchemaConfig;
import org.nabucco.testautomation.schema.facade.datatype.SchemaElement;
import org.nabucco.testautomation.schema.facade.datatype.ScriptContainerType;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigListMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigSearchMsg;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchemaConfig;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaConfig;
import org.nabucco.testautomation.schema.facade.service.search.SearchSchemaConfig;

import org.nabucco.testautomation.facade.datatype.base.HierarchyLevelType;


public class SchemaConfigTest extends RuntimeTestSupport {

	private MaintainSchemaConfig maintain;
	
	private SearchSchemaConfig search;
	
	private ProduceSchemaConfig produce;

	@Before
	public void setUp() throws Exception {
		SchemaComponent component = super.getComponent(SchemaComponentLocator
				.getInstance());
		maintain = component.getMaintainSchemaConfig();
		search = component.getSearchSchemaConfig();
		produce = component.getProduceSchemaConfig();
	}

	@Test
	public void testCreateSchemaConfig() throws Exception {

		SchemaConfig schemaConfig = getDefaultSchemaConfig();
		
		ServiceRequest<SchemaConfigMsg> rq = new ServiceRequest<SchemaConfigMsg>(getServiceContext());
		SchemaConfigMsg msg = new SchemaConfigMsg();
		msg.setSchemaConfig(schemaConfig);
		rq.setRequestMessage(msg);
		ServiceResponse<SchemaConfigMsg> rs = maintain.maintainSchemaConfig(rq);
		
		schemaConfig = rs.getResponseMessage().getSchemaConfig();
		assertNotNull(schemaConfig);
		assertNotNull(schemaConfig.getName());
		assertNotNull(schemaConfig.getDescription());
		assertNotNull(schemaConfig.getSchemaElementList().get(0));
		assertNotNull(schemaConfig.getSchemaElementList().get(0).getId());
		System.out.println(schemaConfig);
		System.out.println();

		for (SchemaElement e : schemaConfig.getSchemaElementList()) {
			System.out.println(e.getId() + ": " + e.getName().getValue());
			for (SchemaElement e2 : e.getSchemaElementList()) {
				System.out.println(e2.getId() + ": " + e2.getName().getValue());
				for (SchemaElement e3 : e2.getSchemaElementList()) {
					System.out.println(e3.getId() + ": " + e3.getName().getValue());
				}
			}
		}
	}
	
	@Test
	public void testSearchSchemaConfig() throws Exception {
		testCreateSchemaConfig();
		ServiceRequest<SchemaConfigSearchMsg> srq = new ServiceRequest<SchemaConfigSearchMsg>(getServiceContext());
		SchemaConfigSearchMsg rq = new SchemaConfigSearchMsg();
		srq.setRequestMessage(rq);
		//rq.setName(schemaConfig.getName());
		
		SchemaConfigListMsg rs = search.searchSchemaConfig(srq).getResponseMessage();
		
		for (SchemaConfig sc : rs.getSchemaConfigList()) {
			System.out.println(sc);
			System.out.println();

			for (SchemaElement e : sc.getSchemaElementList()) {
				System.out.println(e.getId() + ": " + e.getName().getValue());
				for (SchemaElement e2 : e.getSchemaElementList()) {
					System.out.println(e2.getId() + ": " + e2.getName().getValue());
					for (SchemaElement e3 : e2.getSchemaElementList()) {
						System.out.println(e3.getId() + ": " + e3.getName().getValue());
					}
				}
			}
		}
	}
	
	private SchemaConfig schemaConfig;
	
	private SchemaElement testSheetSchema;
	
	private SchemaElement testCaseSchema;
	
	private SchemaElement testStepSchema;
	
	protected SchemaConfig getDefaultSchemaConfig() throws ProduceException {
		
		if (schemaConfig == null) {
			ServiceRequest<EmptyServiceMessage> rq = new ServiceRequest<EmptyServiceMessage>(getServiceContext());
			rq.setRequestMessage(new EmptyServiceMessage());
			ServiceResponse<SchemaConfigMsg> produceResponse = produce.produceSchemaConfig(rq);
			schemaConfig = produceResponse.getResponseMessage().getSchemaConfig();
	        schemaConfig.setName("ProdynaConfig");
	        schemaConfig.setDescription("Default SchemaConfig for Prodyna");
	
	        SchemaElement testSheetSchema = getTestSheetSchema();
	        SchemaElement testCaseSchema = getTestCaseSchema();
	        testSheetSchema.getSchemaElementList().add(testCaseSchema);
	
	        SchemaElement testStepSchema = getTestStepSchema();
	        testCaseSchema.getSchemaElementList().add(testStepSchema);
	
	        schemaConfig.getSchemaElementList().add(testSheetSchema);
		}
        return schemaConfig;
    }
	
	protected SchemaElement getTestSheetSchema() {
		
		if (testSheetSchema == null) {
			testSheetSchema = new SchemaElement();
	        testSheetSchema.setName("TestSheet");
	        testSheetSchema.setLevel(HierarchyLevelType.ONE);
	        testSheetSchema.setHasDependencies(Boolean.FALSE);
	        testSheetSchema.setPropertyContainer(Boolean.TRUE);
	        testSheetSchema.setScriptsAllowed(ScriptContainerType.NONE);
	        testSheetSchema.setSkipable(Boolean.FALSE);
		}
		return testSheetSchema;
	}
	
	protected SchemaElement getTestCaseSchema() {
		
		if (testCaseSchema == null) {
			testCaseSchema = new SchemaElement();
	        testCaseSchema.setName("TestCase");
	        testCaseSchema.setLevel(HierarchyLevelType.TWO);
	        testCaseSchema.setHasDependencies(Boolean.FALSE);
	        testCaseSchema.setPropertyContainer(Boolean.TRUE);
	        testCaseSchema.setScriptsAllowed(ScriptContainerType.NONE);
	        testCaseSchema.setSkipable(Boolean.FALSE);
		}
		return testCaseSchema;
	}

	protected SchemaElement getTestStepSchema() {
		
		if (testStepSchema == null) {
			testStepSchema = new SchemaElement();
	        testStepSchema.setName("TestStep");
	        testStepSchema.setLevel(HierarchyLevelType.THREE);
	        testStepSchema.setHasDependencies(Boolean.TRUE);
	        testStepSchema.setPropertyContainer(Boolean.TRUE);
	        testStepSchema.setScriptsAllowed(ScriptContainerType.MANY);
	        testStepSchema.setSkipable(Boolean.TRUE);
		}
		return testStepSchema;
	}

}
