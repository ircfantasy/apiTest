package automatron.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
public enum Status {
    ACTIVE("ACTIVE");
//    ACTIVE("ACTIVE"),
//    ACTIVE("ACTIVE");

    @Getter
    private final String status;
}
