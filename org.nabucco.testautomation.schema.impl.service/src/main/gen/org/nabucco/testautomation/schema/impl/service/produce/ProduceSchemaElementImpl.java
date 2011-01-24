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
import org.nabucco.testautomation.schema.facade.message.SchemaElementMsg;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceSchemaElement;

/**
 * ProduceSchemaElementImpl<p/>SchemaElement produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class ProduceSchemaElementImpl extends ServiceSupport implements ProduceSchemaElement {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceSchemaElement";

    private ProduceSchemaElementServiceHandler produceSchemaElementServiceHandler;

    /** Constructs a new ProduceSchemaElementImpl instance. */
    public ProduceSchemaElementImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.produceSchemaElementServiceHandler = injector
                .inject(ProduceSchemaElementServiceHandler.getId());
        if ((this.produceSchemaElementServiceHandler != null)) {
            this.produceSchemaElementServiceHandler.setEntityManager(null);
            this.produceSchemaElementServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<SchemaElementMsg> produceSchemaElement(
            ServiceRequest<EmptyServiceMessage> rq) throws ProduceException {
        if ((this.produceSchemaElementServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for produceSchemaElement().");
            throw new InjectionException(
                    "No service implementation configured for produceSchemaElement().");
        }
        ServiceResponse<SchemaElementMsg> rs;
        this.produceSchemaElementServiceHandler.init();
        rs = this.produceSchemaElementServiceHandler.invoke(rq);
        this.produceSchemaElementServiceHandler.finish();
        return rs;
    }
}
