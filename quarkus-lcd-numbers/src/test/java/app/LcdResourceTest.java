package app;

import io.quarkus.test.junit.QuarkusTest;
import org.junit.jupiter.api.Test;

import static io.restassured.RestAssured.given;

@QuarkusTest
public class LcdResourceTest {

    @Test
    public void test200Endpoint() {
        given()
                .param("numbers", "1234567890")
                .param("width", 1)
                .param("height", 1)
                .when().get("/number-to-lcd")
                .then()
                .statusCode(200);
    }

}