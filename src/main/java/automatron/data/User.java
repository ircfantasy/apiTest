package automatron.data;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import automatron.enums.Role;
import automatron.enums.Status;

@Data
@Builder
@AllArgsConstructor
public class User {
    private String login;
    private String password;
    private Role role;
    private Status status;

}
