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
import org.nabucco.testautomation.schema.facade.message.AttributeMsg;
import org.nabucco.testautomation.schema.facade.service.produce.ProduceAttribute;

/**
 * ProduceAttributeImpl<p/>Attribute produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public class ProduceAttributeImpl extends ServiceSupport implements ProduceAttribute {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ProduceAttribute";

    private ProduceAttributeServiceHandler produceAttributeServiceHandler;

    /** Constructs a new ProduceAttributeImpl instance. */
    public ProduceAttributeImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.produceAttributeServiceHandler = injector.inject(ProduceAttributeServiceHandler
                .getId());
        if ((this.produceAttributeServiceHandler != null)) {
            this.produceAttributeServiceHandler.setEntityManager(null);
            this.produceAttributeServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<AttributeMsg> produceAttribute(ServiceRequest<EmptyServiceMessage> rq)
            throws ProduceException {
        if ((this.produceAttributeServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for produceAttribute().");
            throw new InjectionException(
                    "No service implementation configured for produceAttribute().");
        }
        ServiceResponse<AttributeMsg> rs;
        this.produceAttributeServiceHandler.init();
        rs = this.produceAttributeServiceHandler.invoke(rq);
        this.produceAttributeServiceHandler.finish();
        return rs;
    }
}
