import static automatron.testData.UserBuilder.member;
import static automatron.utils.Utils.userToJson;
import static automatron.testData.UserBuilder.admin;
import automatron.testData.UserData;

public class Main {

    public static void main(String[] args) {

        UserData data = new UserData(member());


        System.out.println(userToJson(admin()));
    }
}