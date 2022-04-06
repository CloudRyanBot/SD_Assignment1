import controller.ControllerDestination;
import controller.ControllerUser;
import controller.ControllerVacation;
import view.LoginForm;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Main {
    public static void main(String[] args) {

        EntityManagerFactory em = Persistence.createEntityManagerFactory("Assignment1");
        ControllerUser controllerUser = new ControllerUser(em);
        ControllerVacation controllerVacation = new ControllerVacation(em);
        ControllerDestination controllerDestination = new ControllerDestination(em);
        LoginForm loginForm = new LoginForm(controllerUser, controllerVacation, controllerDestination);

    }
}
