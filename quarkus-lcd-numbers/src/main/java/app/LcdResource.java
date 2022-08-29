package app;

import javax.inject.Inject;
import javax.validation.Valid;
import javax.ws.rs.BeanParam;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import io.smallrye.mutiny.Multi;

@Path("/number-to-lcd")
public class LcdResource {

    @Inject
    LcdService lcdService;

    @GET
    @Produces(MediaType.SERVER_SENT_EVENTS)
    public Multi<String> transformNumbersToLcd(@Valid @BeanParam NumbersParams params) {
        params.isValid();
        return lcdService.transformNumbersToLcd(params.numbers, params.width, params.height)
                .onItem().disjoint();
    }
}