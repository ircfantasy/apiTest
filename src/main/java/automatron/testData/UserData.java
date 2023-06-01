package automatron.testData;

import automatron.data.User;
import lombok.Data;

@Data
public class UserData {

    public User user;

    public UserData(User user) {
        this.user = user;
    }
}
