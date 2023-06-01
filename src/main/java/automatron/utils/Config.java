package automatron.utils;

import lombok.Getter;

@Getter
public class Config { //todo rework to application.properties

    public static final String baseUrl = "http://localhost:8080/api";

    public static String authUrl = baseUrl + "/accounting/login";

}
