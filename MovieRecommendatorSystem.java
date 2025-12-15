import java.util.*;

public class MovieRecommendatorSystem {
    private static HashMap<String, String> users = new HashMap<>();
    private static ArrayList<Movie> movies = new ArrayList<>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Películas iniciales Ejemplo
        movies.add(new Movie("Inception", "Christopher Nolan", 2010));
        movies.add(new Movie("Interstellar", "Christopher Nolan", 2014));
        movies.add(new Movie("The Matrix", "Wachowski Sisters", 1999));

        while (true) {
            System.out.println("\n-------------- MENU --------------");
            System.out.println("1. Login / Register");
            System.out.println("2. Buscar pelis / Ver lista");
            System.out.println("3. Eliminar usuario / Crear peli / Ver usuarios");
            System.out.println("0. Salir");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    loginOrRegister(sc);
                    break;
                case 2:
                    movieMenu(sc);
                    break;
                case 3:
                    adminMenu(sc);
                    break;
                case 0:
                    System.out.println("Saliendo...");
                    return;
                default:
                    System.out.println("Opción inválida.");
            }
        }
    }

    //LOGIN / REGISTER
    private static void loginOrRegister(Scanner sc) {
        System.out.println("1. Login\n2. Register");
        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {
            System.out.println("Usuario:");
            String user = sc.nextLine();
            System.out.println("Password:");
            String pass = sc.nextLine();

            if (users.containsKey(user) && users.get(user).equals(pass)) {
                System.out.println("Login correcto!");
            } else {
                System.out.println("Credenciales inválidas.");
            }
        } else if (option == 2) {
            System.out.println("Nuevo usuario:");
            String user = sc.nextLine();
            System.out.println("Password:");
            String pass = sc.nextLine();
            users.put(user, pass);
            System.out.println("Usuario registrado!");
        }
    }
    //MOVIE MENU
    private static void movieMenu(Scanner sc) {
        System.out.println("1. Buscar por nombre\n2. Ver todas las pelis");
        int option = sc.nextInt();
        sc.nextLine();

        if (option == 1) {
            System.out.println("Escribe palabra clave:");
            String keyword = sc.nextLine();
            for (Movie m : movies) {
                if (m.title.toLowerCase().contains(keyword.toLowerCase())) {
                    System.out.println("Encontrada: " + m);
                }
            }
        } else if (option == 2) {
            System.out.println("Lista de pelis:");
            for (Movie m : movies) {
                System.out.println(m);
            }
        }
    }
    // ADMIN MENU
    private static void adminMenu(Scanner sc) {
        System.out.println("1. Eliminar usuario\n2. Crear película\n3. Ver usuarios");
        int option = sc.nextInt();
        sc.nextLine();

        switch (option) {
            case 1:
                System.out.println("Usuario a eliminar:");
                String user = sc.nextLine();
                if (users.remove(user) != null) {
                    System.out.println("Usuario eliminado.");
                } else {
                    System.out.println("Usuario no encontrado.");
                }
                break;
            case 2:
                System.out.println("Título:");
                String title = sc.nextLine();
                System.out.println("Director:");
                String director = sc.nextLine();
                System.out.println("Año:");
                int year = sc.nextInt();
                sc.nextLine();
                movies.add(new Movie(title, director, year));
                System.out.println("Película añadida!");
                break;
            case 3:
                System.out.println("Usuarios registrados:");
                for (String u : users.keySet()) {
                    System.out.println(u);
                }
                break;
        }
    }
}
