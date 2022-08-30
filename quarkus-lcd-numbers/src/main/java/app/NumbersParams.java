package app;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.ws.rs.BadRequestException;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.QueryParam;

public class NumbersParams {
    @QueryParam("numbers")
    @NotBlank
    public String numbers;

    @QueryParam("width")
    @Min(1)
    @Max(100)
    @DefaultValue("1")
    public int width;

    @QueryParam("height")
    @Min(1)
    @Max(100)
    @DefaultValue("1")
    public int height;

    public void validate() throws BadRequestException {
        if (!numbers.matches("^[0-9]*$")) {
            throw new BadRequestException("Numbers must be numerical");
        }
    }
}
