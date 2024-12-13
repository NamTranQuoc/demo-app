package zamo.app;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.eclipse.microprofile.config.inject.ConfigProperty;

@Path("/hello")
public class ExampleResource {
    @ConfigProperty(name = "hello.name")
    String name;

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Helloo " + name + " from Quarkus REST";
    }
}
