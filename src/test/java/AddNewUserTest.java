import static automatron.testData.UserBuilder.createUserByRole;
import static automatron.testData.UserBuilder.randomMember;
import static automatron.utils.Utils.objectToJson;
import static automatron.utils.Utils.userToJson;
import automatron.BaseTest;
import automatron.data.User;
import automatron.enums.Role;
import automatron.enums.Status;
import automatron.utils.Config;
import automatron.utils.Utils;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EnumSource;

public class AddNewUserTest extends BaseTest {

    @Test
    void addNewMember() {
        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/users")
            .contentType(ContentType.JSON)
            .header("Authorization", token)
            .body(userToJson(randomMember()))
            .post()
            .then()
            .log().all();
    }

    @ParameterizedTest
    @EnumSource(Role.class)
    void addUserByRole(Role role) {
        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/users")
            .contentType(ContentType.JSON)
            .header("Authorization", token)
            .body(userToJson(createUserByRole(role)))
            .post()
            .then()
            .log().all();
    }

    @Test
    void createAndLogIn() {
        User member = randomMember();
        //adding new user
        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/users")
            .contentType(ContentType.JSON)
            .header("Authorization", token)
            .body(userToJson(member))
            .post()
            .then()
            .log().all();
        //login as user
        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/login")
            .contentType(ContentType.JSON)
            .body(userToJson(member))
            .post()
            .then().log().all();
    }

    @Test
    void createLoginAndLogout() {
        User member = Utils.createUserByRole(Role.MEMBER);
        //login as user
        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/login")
            .contentType(ContentType.JSON)
            .body(userToJson(member))
            .post()
            .then().log().all();
        //logout
        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/logout")
            .contentType(ContentType.JSON)
            .headers("Authorization", token,"mode", "CURRENT")
            .get()
            .then().log().all();
    }

    @Test
    void getUserByLogin() {
        User member = Utils.createUserByRole(Role.MEMBER);
        //getting info
        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/users/" + member.getLogin())
            .headers("Authorization", token)
            .contentType(ContentType.JSON)
            .get()
            .then()
            .log()
            .all();
    }

    @Test
    void deleteUser() {
        User member = Utils.createUserByRole(Role.MEMBER);
        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/users/" + member.getLogin())
            .contentType(ContentType.JSON)
            .headers("Authorization", token)
            .delete()
            .then()
            .log()
            .all();
    }

    @Test
    void getAllActiveUsers() {
        List<User> list = RestAssured.given()
            .baseUri(Config.baseUrl)
            .headers("Authorization", token)
            .contentType(ContentType.JSON)
            .body(objectToJson(Status.ACTIVE.getStatus()))
            .get("/accounting/users/")
            .then()
            .log()
            .all()
            .extract().body().jsonPath().getList("", User.class);
        System.out.println(list);
    }

}
