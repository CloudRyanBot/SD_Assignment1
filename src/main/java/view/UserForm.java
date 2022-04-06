package view;

import controller.ControllerDestination;
import controller.ControllerUser;
import controller.ControllerVacation;
import model.VacPackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class UserForm {
    private JPanel panel;
    private JTable vacPackages;
    private JButton viewButton;
    private JTextField destination;
    private JTextField price;
    private JTextField period;

    public UserForm(ControllerUser controllerUser, ControllerVacation controllerVacation, ControllerDestination controllerDestination) {
        JFrame frame = new JFrame("User Page");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        viewButton.addActionListener(l->{
            List<VacPackage> vacPackages = controllerVacation.getAll();
            if (!destination.getText().equals(""))
            {
                vacPackages = vacPackages.stream().filter(i -> i.getDestination().getName().contains(destination.getText())).toList();
            }
            if (!price.getText().equals(""))
            {
                try {
                    int price = Integer.parseInt(this.price.getText());
                    vacPackages = vacPackages.stream().filter(i -> i.getPrice().equals(price)).toList();
                }catch(Exception e)
                {
                    int price = 1000000;
                }
            }
            if (!period.getText().equals(""))
            {
                vacPackages = vacPackages.stream().filter(i -> i.getDate_start().toString().equals(period.getText()) || i.getDate_end().toString().equals(period.getText())).toList();
            }
            this.vacPackages.setModel(defaultTableModelVacPackage(vacPackages));
        });
    }

    private DefaultTableModel defaultTableModelVacPackage(List<VacPackage> vacationPackages) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        String[] columnNames = {"Vacation ID", "Destination", "Vacation Name", "Extra Details", "Price", "Start Period", "End Period", "Total Slots"};
        defaultTableModel.setColumnIdentifiers(columnNames);
        for(VacPackage vacationPackage: vacationPackages) {
            Object[] aux = new Object[8];
            aux[0] = vacationPackage.getId();
            aux[1] = vacationPackage.getDestination().getName();
            aux[2] = vacationPackage.getName();
            aux[3] = vacationPackage.getExtra_details();
            aux[4] = vacationPackage.getPrice();
            aux[5] = vacationPackage.getDate_start();
            aux[6] = vacationPackage.getDate_end();
            aux[7] = vacationPackage.getSlots_total();
            defaultTableModel.addRow(aux);
        }
        return defaultTableModel;
    }
}
