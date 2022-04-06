package view;

import controller.ControllerDestination;
import controller.ControllerUser;
import controller.ControllerVacation;
import model.User;

import javax.swing.*;

public class RegisterForm {
    private JButton signUpButton;
    private JTextField user;
    private JPanel panel;
    private JTextField email;
    private JTextField password;

    public RegisterForm(ControllerUser controllerUser, ControllerVacation controllerVacation, ControllerDestination controllerDestination) {
        JFrame frame = new JFrame("Register Page");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        signUpButton.addActionListener(l->{
            String user = this.user.getText();
            String email = this.email.getText();
            String password = this.password.getText();

            User user1 = new User(user, password, email, 0);
            try
            {
                controllerUser.create(user1);
                JOptionPane.showMessageDialog(new JFrame(), "You good fam", "Yes", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
            } catch (Exception ex)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Username already taken", "No", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
