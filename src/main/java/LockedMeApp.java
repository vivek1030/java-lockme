import com.lockme.utils.FileOperationV1;

public class LockedMeApp {
    public static void welcomeScreen() {
        System.out.println("Welcome to LockedMe");
    }

    public static void main(String[] args) {
        String dir = "D:\\java-proj\\java-lockme";
        FileOperationV1 fileOperation = new FileOperationV1(dir);
        welcomeScreen();
        fileOperation.showMainMenu();
    }
}
