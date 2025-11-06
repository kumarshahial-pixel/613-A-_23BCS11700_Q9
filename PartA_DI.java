class DatabaseService {
    public void connect() {
        System.out.println("Database connected successfully!");
    }
}

class UserService {
    private DatabaseService dbService;
    public UserService(DatabaseService dbService) {
        this.dbService = dbService;
    }
    public void registerUser(String name) {
        dbService.connect();
        System.out.println("User registered: " + name);
    }
}

public class PartA_DI {
    public static void main(String[] args) {
        DatabaseService db = new DatabaseService();
        UserService userService = new UserService(db);
        userService.registerUser("Sumit");
    }
}
