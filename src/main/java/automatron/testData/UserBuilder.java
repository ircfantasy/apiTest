package automatron.testData;

import static automatron.utils.Utils.randomRoman;
import automatron.data.User;
import automatron.enums.Role;
import automatron.enums.Status;
import lombok.Data;
import lombok.Getter;

@Getter
@Data
public class UserBuilder {

    public static User admin() {
        return User.builder()
            .login("admin")
            .password("admin")
            .status(Status.ACTIVE)
            .role(Role.ADMIN)
            .build();
    }

    public static User owner() {
        return User.builder()
            .login("owner")
            .password("owner")
            .status(Status.ACTIVE)
            .role(Role.OWNER)
            .build();
    }

    public static User member() {
        return User.builder()
            .login("member")
            .password("member")
            .role(Role.MEMBER)
            .status(Status.ACTIVE)
            .build();
    }

    public static User randomMember() {
        return User.builder()
            .login(randomRoman(5).toLowerCase())
            .password(randomRoman(5).toLowerCase())
            .status(Status.ACTIVE)
            .role(Role.MEMBER)
            .build();
    }

    public static User createUserByRole(Role role) {
        return User.builder()
            .login(randomRoman(6))
            .password(randomRoman(6))
            .status(Status.ACTIVE)
            .role(role)
            .build();
    }

}
