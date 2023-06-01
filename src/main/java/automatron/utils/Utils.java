package automatron.utils;

import static automatron.BaseTest.token;
import automatron.data.User;
import automatron.enums.Role;
import automatron.enums.Status;
import com.google.gson.Gson;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import org.apache.commons.lang3.RandomStringUtils;

public class Utils {

    private static final char[] ROMAN_CHARS = new char[]{'I', 'V', 'X', 'L', 'C'};

    public static String randomRoman(int length) {
        return RandomStringUtils.random(length, ROMAN_CHARS);
    }

    public static String userToJson(User user) {
        return new Gson().toJson(user);
    }

    public static String objectToJson(String string) {
        return new Gson().toJson(string);
    }

    public static User createUserByRole(Role role) {
        User user = User.builder()
            .login(randomRoman(6))
            .password(randomRoman(6))
            .status(Status.ACTIVE)
            .role(role)
            .build();

        RestAssured.given()
            .baseUri(Config.baseUrl + "/accounting/users")
            .contentType(ContentType.JSON)
            .header("Authorization", token)
            .body(userToJson(user))
            .post()
            .then()
            .log().all();
        return user;
    }

}
