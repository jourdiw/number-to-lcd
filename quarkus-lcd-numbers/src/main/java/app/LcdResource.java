package app;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;

@Path("/number-to-lcd")
public class LcdResource {

    @Inject
    LcdService lcdService;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> transformNumbersToLcd(@QueryParam("numbers") String numbers) {
        return lcdService.transformNumbersToLcd(numbers);
    }
}