package src;

import src.service.MoviesManagement;
import src.service.SuperUserManagement;
import src.service.UsersManagement;
import src.ui.Menus;

public class Main {
    public static void main(String[] args) {
        UsersManagement userManager = new UsersManagement();
        MoviesManagement moviesManager = new MoviesManagement();
        SuperUserManagement adminManager = new SuperUserManagement();

        Menus menuSystem = new Menus(adminManager, userManager, moviesManager);
        menuSystem.mainMenu();
    }
}