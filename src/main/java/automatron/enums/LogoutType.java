package automatron.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum LogoutType {
    ALL("ALL"),
    CURRENT("CURRENT");

    @Getter
    public final String type;
}
