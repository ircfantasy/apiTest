package automatron;

import static automatron.testData.UserBuilder.owner;
import static automatron.utils.Utils.userToJson;
import automatron.utils.Config;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.Properties;
import lombok.Getter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;

@Getter
@TestInstance(Lifecycle.PER_CLASS) //todo research
public abstract class BaseTest {

    public static String token;

    Properties properties;

    @BeforeAll
    public static void getToken() {
        token = RestAssured.given()
//            .baseUri(properties.getProperty("baseUrl"))
            .baseUri(Config.authUrl)
            .contentType(ContentType.JSON)
            .body(userToJson(owner()))
            .post()
            .jsonPath()
            .getString("access_token");
    }

}
