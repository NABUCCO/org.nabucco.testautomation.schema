/*
 * Copyright 2012 PRODYNA AG
 * 
 * Licensed under the Eclipse Public License (EPL), Version 1.0 (the "License"); you may not use
 * this file except in compliance with the License. You may obtain a copy of the License at
 * 
 * http://www.opensource.org/licenses/eclipse-1.0.php or
 * http://www.nabucco.org/License.html
 * 
 * Unless required by applicable law or agreed to in writing, software distributed under the
 * License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language governing permissions
 * and limitations under the License.
 */
package org.nabucco.testautomation.schema.impl.service.produce;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManager;
import org.nabucco.framework.base.impl.service.maintain.PersistenceManagerFactory;
import org.nabucco.testautomation.schema.facade.message.AttributeMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.facade.message.SchemaElementMsg;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchema;

/**
 * ProduceSchemaImpl<p/>SchemaElement produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class ProduceSchemaImpl extends ServiceSupport implements ProduceSchema {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceSchema";

    private static Map<String, String[]> ASPECTS;

    private ProduceSchemaElementServiceHandler produceSchemaElementServiceHandler;

    private ProduceAttributeServiceHandler produceAttributeServiceHandler;

    private ProduceSchemaConfigServiceHandler produceSchemaConfigServiceHandler;

    private ProduceSchemaConfigCloneServiceHandler produceSchemaConfigCloneServiceHandler;

    private EntityManager entityManager;

    /** Constructs a new ProduceSchemaImpl instance. */
    public ProduceSchemaImpl() {
        super();
    }

    @Override
    public void postConstruct() {
        super.postConstruct();
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        PersistenceManager persistenceManager = PersistenceManagerFactory.getInstance().createPersistenceManager(
                this.entityManager, super.getLogger());
        this.produceSchemaElementServiceHandler = injector.inject(ProduceSchemaElementServiceHandler.getId());
        if ((this.produceSchemaElementServiceHandler != null)) {
            this.produceSchemaElementServiceHandler.setPersistenceManager(persistenceManager);
            this.produceSchemaElementServiceHandler.setLogger(super.getLogger());
        }
        this.produceAttributeServiceHandler = injector.inject(ProduceAttributeServiceHandler.getId());
        if ((this.produceAttributeServiceHandler != null)) {
            this.produceAttributeServiceHandler.setPersistenceManager(persistenceManager);
            this.produceAttributeServiceHandler.setLogger(super.getLogger());
        }
        this.produceSchemaConfigServiceHandler = injector.inject(ProduceSchemaConfigServiceHandler.getId());
        if ((this.produceSchemaConfigServiceHandler != null)) {
            this.produceSchemaConfigServiceHandler.setPersistenceManager(persistenceManager);
            this.produceSchemaConfigServiceHandler.setLogger(super.getLogger());
        }
        this.produceSchemaConfigCloneServiceHandler = injector.inject(ProduceSchemaConfigCloneServiceHandler.getId());
        if ((this.produceSchemaConfigCloneServiceHandler != null)) {
            this.produceSchemaConfigCloneServiceHandler.setPersistenceManager(persistenceManager);
            this.produceSchemaConfigCloneServiceHandler.setLogger(super.getLogger());
        }
    }

    @Override
    public void preDestroy() {
        super.preDestroy();
    }

    @Override
    public String[] getAspects(String operationName) {
        if ((ASPECTS == null)) {
            ASPECTS = new HashMap<String, String[]>();
            ASPECTS.put("produceSchemaElement", NO_ASPECTS);
            ASPECTS.put("produceAttribute", NO_ASPECTS);
            ASPECTS.put("produceSchemaConfig", NO_ASPECTS);
            ASPECTS.put("produceSchemaConfigClone", NO_ASPECTS);
        }
        String[] aspects = ASPECTS.get(operationName);
        if ((aspects == null)) {
            return ServiceSupport.NO_ASPECTS;
        }
        return Arrays.copyOf(aspects, aspects.length);
    }

    @Override
    public ServiceResponse<SchemaElementMsg> produceSchemaElement(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceSchemaElementServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceSchemaElement().");
            throw new InjectionException("No service implementation configured for produceSchemaElement().");
        }
        ServiceResponse<SchemaElementMsg> rs;
        this.produceSchemaElementServiceHandler.init();
        rs = this.produceSchemaElementServiceHandler.invoke(rq);
        this.produceSchemaElementServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<AttributeMsg> produceAttribute(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceAttributeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceAttribute().");
            throw new InjectionException("No service implementation configured for produceAttribute().");
        }
        ServiceResponse<AttributeMsg> rs;
        this.produceAttributeServiceHandler.init();
        rs = this.produceAttributeServiceHandler.invoke(rq);
        this.produceAttributeServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SchemaConfigMsg> produceSchemaConfig(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceSchemaConfigServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceSchemaConfig().");
            throw new InjectionException("No service implementation configured for produceSchemaConfig().");
        }
        ServiceResponse<SchemaConfigMsg> rs;
        this.produceSchemaConfigServiceHandler.init();
        rs = this.produceSchemaConfigServiceHandler.invoke(rq);
        this.produceSchemaConfigServiceHandler.finish();
        return rs;
    }

    @Override
    public ServiceResponse<SchemaConfigMsg> produceSchemaConfigClone(ServiceRequest<SchemaConfigMsg> rq)
            throws ProduceException {
        if ((this.produceSchemaConfigCloneServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceSchemaConfigClone().");
            throw new InjectionException("No service implementation configured for produceSchemaConfigClone().");
        }
        ServiceResponse<SchemaConfigMsg> rs;
        this.produceSchemaConfigCloneServiceHandler.init();
        rs = this.produceSchemaConfigCloneServiceHandler.invoke(rq);
        this.produceSchemaConfigCloneServiceHandler.finish();
        return rs;
    }
}
