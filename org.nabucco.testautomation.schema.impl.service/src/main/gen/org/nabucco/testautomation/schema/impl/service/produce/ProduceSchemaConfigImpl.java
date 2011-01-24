/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.impl.service.produce;

import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.EmptyServiceMessage;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaConfig;

/**
 * ProduceSchemaConfigImpl<p/>SchemaConfig produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class ProduceSchemaConfigImpl extends ServiceSupport implements ProduceSchemaConfig {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceSchemaConfig";

    private ProduceSchemaConfigServiceHandler produceSchemaConfigServiceHandler;

    /** Constructs a new ProduceSchemaConfigImpl instance. */
    public ProduceSchemaConfigImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.produceSchemaConfigServiceHandler = injector.inject(ProduceSchemaConfigServiceHandler
                .getId());
        if ((this.produceSchemaConfigServiceHandler != null)) {
            this.produceSchemaConfigServiceHandler.setEntityManager(null);
            this.produceSchemaConfigServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<SchemaConfigMsg> produceSchemaConfig(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceSchemaConfigServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceSchemaConfig().");
            throw new InjectionException(
                    "No service implementation configured for produceSchemaConfig().");
        }
        ServiceResponse<SchemaConfigMsg> rs;
        this.produceSchemaConfigServiceHandler.init();
        rs = this.produceSchemaConfigServiceHandler.invoke(rq);
        this.produceSchemaConfigServiceHandler.finish();
        return rs;
    }
}
