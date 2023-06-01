import static automatron.testData.UserBuilder.admin;
import static automatron.testData.UserBuilder.member;
import static automatron.testData.UserBuilder.owner;
import static automatron.utils.Utils.userToJson;
import automatron.BaseTest;
import automatron.utils.Config;
import automatron.utils.Negative;
import automatron.utils.Positive;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

public class LoginTest extends BaseTest {

    @Test
    void getOwnerTocken() {
        String body = RestAssured.given()
            .baseUri(Config.authUrl)
            .contentType(ContentType.JSON)
            .body(userToJson(owner()))
            .post()
            .jsonPath()
            .getString("access_token");
    }

    @Test
    @Positive
    void loginAsAdmin() {
        RestAssured.given()
            .baseUri(Config.authUrl)
            .body(userToJson(admin()))
            .contentType(ContentType.JSON)
            .post()
            .then()
            .log().all();
    }

    @Test
    @Positive
    void loginAsMember() {
        RestAssured.given()
            .baseUri(Config.authUrl)
            .body(userToJson(member()))
            .contentType(ContentType.JSON)
            .post()
            .then()
            .log().all();

    }

    @Test
    @Positive
    void loginAsOwner() {
        RestAssured.given()
            .baseUri(Config.authUrl)
            .body(userToJson(owner()))
            .contentType(ContentType.JSON)
            .post()
            .then()
            .log().all();
    }

    @Test
    @Negative
    void login500() {
        RestAssured.given()
            .baseUri(Config.authUrl)
            .contentType(ContentType.JSON)
            .body("")
            .post()
            .then()
            .statusCode(500)
            .log().all();
    }

    @Test
    @Negative
    void loginWithoutPass() {
        RestAssured.given()
            .baseUri(Config.authUrl)
            .contentType(ContentType.JSON)
            .body(String.format("{\"login\":\"%s\"}", owner().getLogin()))
            .post()
            .then()
            .statusCode(400)
            .log().all();
        //todo assert response
    }

//
//    @ParameterizedTest()
//    void loginAsUser(UserBuilder user) {
//
//    }


}
