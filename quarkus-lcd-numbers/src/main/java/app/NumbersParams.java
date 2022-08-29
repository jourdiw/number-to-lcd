package app;

import javax.validation.constraints.NotBlank;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class NumbersParams {
    @QueryParam("numbers")
    @NotBlank
    // TODO: Add validator regex for /d
    public String numbers;

    @QueryParam("width")
    @DefaultValue("1")
    public int width;

    @QueryParam("height")
    @DefaultValue("1")
    public int height;
}
