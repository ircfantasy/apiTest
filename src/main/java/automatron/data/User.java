package automatron.data;

import automatron.enums.Role;
import automatron.enums.Status;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private Role role;
    private Status status;

}
