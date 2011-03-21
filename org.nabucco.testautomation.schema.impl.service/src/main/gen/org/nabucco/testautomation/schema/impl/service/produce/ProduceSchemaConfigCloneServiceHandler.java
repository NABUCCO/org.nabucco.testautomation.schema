/*
 * NABUCCO Generator, Copyright (c) 2010, PRODYNA AG, Germany. All rights reserved.
 */
package org.nabucco.testautomation.schema.impl.service.produce;

import org.nabucco.framework.base.facade.exception.NabuccoException;
import org.nabucco.framework.base.facade.exception.service.ProduceException;
import org.nabucco.framework.base.facade.message.ServiceRequest;
import org.nabucco.framework.base.facade.message.ServiceResponse;
import org.nabucco.framework.base.impl.service.handler.ServiceHandler;
import org.nabucco.framework.base.impl.service.handler.ServiceHandlerSupport;
import org.nabucco.testautomation.schema.facade.message.SchemaConfigMsg;

/**
 * ProduceSchemaConfigCloneServiceHandler<p/>SchemaConfig produce service<p/>
 *
 * @version 1.0
 * @author Steffen Schmidt, PRODYNA AG, 2010-04-13
 */
public abstract class ProduceSchemaConfigCloneServiceHandler extends ServiceHandlerSupport
        implements ServiceHandler {

    private static final long serialVersionUID = 1L;

    private static final String ID = "org.nabucco.testautomation.schema.impl.service.produce.ProduceSchemaConfigCloneServiceHandler";

    /** Constructs a new ProduceSchemaConfigCloneServiceHandler instance. */
    public ProduceSchemaConfigCloneServiceHandler() {
        super();
    }

    /**
     * Invokes the service handler method.
     *
     * @param rq the ServiceRequest<SchemaConfigMsg>.
     * @return the ServiceResponse<SchemaConfigMsg>.
     * @throws ProduceException
     */
    protected ServiceResponse<SchemaConfigMsg> invoke(ServiceRequest<SchemaConfigMsg> rq)
            throws ProduceException {
        ServiceResponse<SchemaConfigMsg> rs;
        SchemaConfigMsg msg;
        try {
            this.validateRequest(rq);
            this.setContext(rq.getContext());
            msg = this.produceSchemaConfigClone(rq.getRequestMessage());
            if ((msg == null)) {
                super.getLogger().warning("No response message defined.");
            } else {
                super.cleanServiceMessage(msg);
            }
            rs = new ServiceResponse<SchemaConfigMsg>(rq.getContext());
            rs.setResponseMessage(msg);
            return rs;
        } catch (ProduceException e) {
            super.getLogger().error(e);
            throw e;
        } catch (NabuccoException e) {
            super.getLogger().error(e);
            ProduceException wrappedException = new ProduceException(e);
            throw wrappedException;
        } catch (Exception e) {
            super.getLogger().error(e);
            throw new ProduceException("Error during service invocation.", e);
        }
    }

    /**
     * Missing description at method produceSchemaConfigClone.
     *
     * @param msg the SchemaConfigMsg.
     * @return the SchemaConfigMsg.
     * @throws ProduceException
     */
    protected abstract SchemaConfigMsg produceSchemaConfigClone(SchemaConfigMsg msg)
            throws ProduceException;

    /**
     * Getter for the Id.
     *
     * @return the String.
     */
    protected static String getId() {
        return ID;
    }
}
