package automatron.enums;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public enum Role {
    ADMIN("ADMIN"),
    MEMBER("MEMBER"),
    OWNER("OWNER");


    public final String role;
}
