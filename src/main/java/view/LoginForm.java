package view;

import controller.ControllerDestination;
import controller.ControllerUser;
import controller.ControllerVacation;
import model.User;

import javax.swing.*;

public class LoginForm {
    private JTextField textField1;
    private JPasswordField passwordField1;
    private JButton loginButton;
    private JPanel panel;
    private JButton registerButton;



    public LoginForm(ControllerUser controllerUser, ControllerVacation controllerVacation, ControllerDestination controllerDestination){

        JFrame frame = new JFrame("Login Page");
        frame.setContentPane(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
        this.loginButton.addActionListener(l-> {
            String username = textField1.getText();
            String password = String.valueOf(passwordField1.getPassword());

            User user = controllerUser.getUserByName(username);
            if(user == null)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Username or password correctn't", "No", JOptionPane.ERROR_MESSAGE);
            }
            else if(!user.getPass().equals(password))
            {
                JOptionPane.showMessageDialog(new JFrame(), "Username or password correctn't", "No", JOptionPane.ERROR_MESSAGE);
            }
            else
            {
                //user
                if(user.getType()==0)
                {
                    UserForm userForm = new UserForm(controllerUser, controllerVacation, controllerDestination);
                    //hidden something someting login
                }
                else
                {
                    AgencyForm agencyForm = new AgencyForm(controllerUser, controllerVacation, controllerDestination);
                    //hidden something someting login daca vreu
                }
            }
        });

        this.registerButton.addActionListener(l->{
            RegisterForm registerForm = new RegisterForm(controllerUser, controllerVacation, controllerDestination);
        });
    }

    public JTextField getTextField1() {
        return textField1;
    }

    public JPasswordField getPasswordField1() {
        return passwordField1;
    }

    public JButton getloginButton() {
        return loginButton;
    }

    public JPanel getPanel() {
        return panel;
    }

    public JButton getRegisterButton() {
        return registerButton;
    }

}
