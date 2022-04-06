package view;

import controller.ControllerDestination;
import controller.ControllerUser;
import controller.ControllerVacation;
import model.Destination;
import model.VacPackage;

import javax.swing.*;
import java.time.LocalDate;

public class AddEditVacationForm {
    private JTextField name;
    private JTextField price;
    private JTextField startDate;
    private JTextField extraDetails;
    private JTextField numberOfPeople;
    private JTextField endDate;
    private JButton addVacationButton;
    private JPanel panel;

    public AddEditVacationForm(String destination, ControllerUser controllerUser, ControllerVacation controllerVacation, ControllerDestination controllerDestination) {
        JFrame frame = new JFrame("Agency Page");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        addVacationButton.addActionListener(l -> {
            try {
                Destination destination1 = controllerDestination.getDestByName(destination);
                String name = this.name.getText();
                Integer price = Integer.parseInt(this.price.getText());
                LocalDate startDate = LocalDate.parse(this.startDate.getText());
                LocalDate endDate = LocalDate.parse(this.endDate.getText());
                String extraDetails = this.extraDetails.getText();
                Integer numberOfPeople = Integer.parseInt(this.numberOfPeople.getText());
                VacPackage vacPackage = new VacPackage(destination1, name, extraDetails, price, startDate, endDate, numberOfPeople);
                controllerVacation.create(vacPackage);
                JOptionPane.showMessageDialog(new JFrame(), "You good fam", "Yes", JOptionPane.INFORMATION_MESSAGE);
                frame.setVisible(false);
            }catch (Exception e)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);            }
        });
    }

    public AddEditVacationForm(String destination, String vacPackage ,ControllerUser controllerUser, ControllerVacation controllerVacation, ControllerDestination controllerDestination) {
        JFrame frame = new JFrame("Agency Page");
        addVacationButton.setText("Edit Vacation");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        VacPackage vacPackage1 = controllerVacation.getVacPackageByName(vacPackage);
        name.setText(vacPackage1.getName());
        price.setText(vacPackage1.getPrice().toString());
        startDate.setText(vacPackage1.getDate_start().toString());
        endDate.setText(vacPackage1.getDate_end().toString());
        extraDetails.setText(vacPackage1.getExtra_details());
        numberOfPeople.setText(vacPackage1.getSlots_total().toString());
        addVacationButton.addActionListener(l -> {
            String name = this.name.getText();
            try {
                Integer price = Integer.parseInt(this.price.getText());
                LocalDate startDate = LocalDate.parse(this.startDate.getText());
                LocalDate endDate = LocalDate.parse(this.endDate.getText());

            String extraDetails = this.extraDetails.getText();
            Integer numberOfPeople = Integer.parseInt(this.numberOfPeople.getText());
            vacPackage1.setName(name);
            vacPackage1.setPrice(price);
            vacPackage1.setDate_start(startDate);
            vacPackage1.setDate_end(endDate);
            vacPackage1.setExtra_details(extraDetails);
            vacPackage1.setSlots_total(numberOfPeople);
            controllerVacation.save(vacPackage1);
            JOptionPane.showMessageDialog(new JFrame(), "You good fam", "Yes", JOptionPane.INFORMATION_MESSAGE);
            frame.setVisible(false);
            }catch(Exception ex)
            {
                JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
            }
        });
    }
}
