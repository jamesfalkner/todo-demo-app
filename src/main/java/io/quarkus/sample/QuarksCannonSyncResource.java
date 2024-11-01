package io.quarkus.sample;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import jakarta.inject.Inject;
import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.eclipse.microprofile.config.inject.ConfigProperty;
import org.jboss.logging.Logger;
import software.amazon.awssdk.services.sns.SnsClient;
import software.amazon.awssdk.services.sns.model.PublishResponse;

@Path("/sync/cannon")
@Produces(MediaType.TEXT_PLAIN)
public class QuarksCannonSyncResource {

    private static final Logger LOGGER = Logger.getLogger(QuarksCannonSyncResource.class);

    @Inject
    SnsClient sns;

    @POST
    @Path("/sync")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response publish(String notification) throws Exception {
        sns.createTopic(t -> t.name("quarkus-todo-topic").build());
        return Response.ok().build();
    }
}