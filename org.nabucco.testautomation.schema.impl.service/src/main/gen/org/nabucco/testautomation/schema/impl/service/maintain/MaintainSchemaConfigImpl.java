/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.impl.service.maintain;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.service.MaintainException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;
import org.nabucco.testautomation.schema.facade.service.maintain.MaintainSchemaConfig;

/**
 * MaintainSchemaConfigImpl<p/>SchemaConfig maintenance service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-09
 */
public class MaintainSchemaConfigImpl extends ServiceSupport implements MaintainSchemaConfig {

    private static final long serialVersionUID = 1L;

    private static final String ID = "MaintainSchemaConfig";

    private EntityManager em;

    private MaintainSchemaConfigServiceHandler maintainSchemaConfigServiceHandler;

    /** Constructs a new MaintainSchemaConfigImpl instance. */
    public MaintainSchemaConfigImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.maintainSchemaConfigServiceHandler = injector
                .inject(MaintainSchemaConfigServiceHandler.getId());
        if ((this.maintainSchemaConfigServiceHandler != null)) {
            this.maintainSchemaConfigServiceHandler.setEntityManager(this.em);
            this.maintainSchemaConfigServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<SchemaConfigMsg> maintainSchemaConfig(ServiceRequest<SchemaConfigMsg> rq)
            throws MaintainException {
        if ((this.maintainSchemaConfigServiceHandler == null)) {
            super.getLogger().error(
                    "No service implementation configured for maintainSchemaConfig().");
            throw new InjectionException(
                    "No service implementation configured for maintainSchemaConfig().");
        }
        ServiceResponse<SchemaConfigMsg> rs;
        this.maintainSchemaConfigServiceHandler.init();
        rs = this.maintainSchemaConfigServiceHandler.invoke(rq);
        this.maintainSchemaConfigServiceHandler.finish();
        return rs;
    }
}
