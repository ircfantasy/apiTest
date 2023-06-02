package automatron.utils;

import lombok.Getter;

@Getter
public class Config { //todo rework to application.properties

    public static final String baseUrl = "http://localhost:18080/api"; // jenkins runs on 8080

    public static String authUrl = baseUrl + "/accounting/login";

}
