/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.impl.service.importing;

import javax.persistence.EntityManager;
import org.nabucco.framework.base.facade.exception.importing.ImportException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.facade.message.importing.ImportRq;
import org.nabucco.framework.base.facade.message.importing.ImportRs;
import org.nabucco.framework.base.facade.service.injection.InjectionException;
import org.nabucco.framework.base.facade.service.injection.InjectionProvider;
import org.nabucco.framework.base.impl.service.ServiceSupport;
import org.nabucco.testautomation.schema.facade.service.importing.ImportSchema;

/**
 * ImportSchemaImpl<p/>Service to import Schema<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2011-02-14
 */
public class ImportSchemaImpl extends ServiceSupport implements ImportSchema {

    private static final long serialVersionUID = 1L;

    private static final String ID = "ImportSchema";

    private EntityManager entityManager;

    private ImportSchemaServiceHandler importSchemaServiceHandler;

    /** Constructs a new ImportSchemaImpl instance. */
    public ImportSchemaImpl() {
        super();
    }

    /** PostConstruct. */
    public void postConstruct() {
        InjectionProvider injector = InjectionProvider.getInstance(ID);
        this.importSchemaServiceHandler = injector.inject(ImportSchemaServiceHandler.getId());
        if ((this.importSchemaServiceHandler != null)) {
            this.importSchemaServiceHandler.setEntityManager(this.entityManager);
            this.importSchemaServiceHandler.setLogger(super.getLogger());
        }
    }

    /** PreDestroy. */
    public void preDestroy() {
    }

    @Override
    public ServiceResponse<ImportRs> importSchema(ServiceRequest<ImportRq> rq)
            throws ImportException {
        if ((this.importSchemaServiceHandler == null)) {
            super.getLogger().error("No service implementation configured for importSchema().");
            throw new InjectionException("No service implementation configured for importSchema().");
        }
        ServiceResponse<ImportRs> rs;
        this.importSchemaServiceHandler.init();
        rs = this.importSchemaServiceHandler.invoke(rq);
        this.importSchemaServiceHandler.finish();
        return rs;
    }
}
