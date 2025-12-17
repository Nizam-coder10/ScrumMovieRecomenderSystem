import java.util.*;

public class MovieRecommenderSystem {
    public static final String USER_NAME_ADMIN = "ADMIN";
    public static final String PASSWORD_ADMIN = "Admin-010101";

    public static void main(String[] args) {





    }

    public static String registerUser( HashMap<String, String> user, String username, String password) {
        if (!password.matches("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[\\W_]).{8,}$")) {
            return "The Password isn't correct! Need it: 1 Mayus, 1 Minus, 1 Symbol and 1 number";
        }

        user.put(username, password);
        return "User " + username + " Created!";
    }

    public static String loginUser(HashMap<String, String> user, String userName, String password) {
        if (!user.containsKey(userName)) {
            return "This Username doesn't Exist";

        } else if (!user.get(userName).equals(password)) {
            return "Password is in correct";
        }

        return userName;
    }

    public static String removeUser(HashMap<String,String> listUsers,String userName){
        if (listUsers.containsKey(userName)){
            listUsers.remove(userName);
            return "User deleted: " + userName;

        } else return "User " + userName + " doesn't Exists.";
    }

    public static String findUserByName(HashMap<String,String> listUsers,String userName){
        if (listUsers.containsKey(userName)){
            String password = listUsers.get(userName);
            return "Here is the user : " + userName + " Password "+ password;

        } else return "User " + userName + " doesn't exist.";
    }

    public static void showAllUsers(HashMap<String,String> listUsers){
        if (!listUsers.isEmpty()) {
            System.out.println("This are the Users:");
            for (Map.Entry<String, String> each : listUsers.entrySet()){
                System.out.println(each.getKey() + " -> " + each.getValue());
            }

        } else System.out.println("There are no Users in the System");
    }

    public static String addMovie(TreeSet<String> listMovies, String nameMovie) {
        if (listMovies.add(nameMovie)) {
            return "The Movie '" + nameMovie + "' has been Added.";

        } else return "The Movie '" + nameMovie + "' already Exists.";
    }

    public static String showMovieByName(TreeSet<String> listMovies, String nameMovie) {
        if (listMovies.contains(nameMovie)) {
            return "The Movie '" + nameMovie + "' is Exists.";

        } else return "The Movie '" + nameMovie + "' doesn't Exists.";
    }

    public static void showAllMovies(TreeSet<String> listMovies){
        if (!listMovies.isEmpty()) {
            System.out.println("This are the Movies:");
            for (String each : listMovies){
                System.out.println(each);
            }

        } else System.out.println("There are no Movies in the System");
    }
}