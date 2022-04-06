package view;

import controller.ControllerDestination;
import controller.ControllerUser;
import controller.ControllerVacation;
import model.Destination;
import model.VacPackage;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.util.List;

public class AgencyForm {
    private JPanel panel;
    private JButton addDestinationButton;
    private JButton editButton;
    private JButton viewButton;
    private JTextField vacationPackage;
    private JTextField destination;
    private JTable vacationPackages;
    private JButton addPackageButton;
    private JTable destinations;
    private JButton deletePackageButton;
    private JButton deleteDestinationButton;

    public AgencyForm(ControllerUser controllerUser, ControllerVacation controllerVacation, ControllerDestination controllerDestination) {
        JFrame frame = new JFrame("Agency Page");
        frame.setContentPane(panel);
        frame.pack();
        frame.setVisible(true);
        addPackageButton.addActionListener(l->
        {
            AddEditVacationForm addEditVacationForm = new AddEditVacationForm(destination.getText(), controllerUser, controllerVacation, controllerDestination);
        });
        addDestinationButton.addActionListener(l->
        {
            String destinationS = destination.getText();
            Destination destination = new Destination(destinationS);
            controllerDestination.create(destination);
            JOptionPane.showMessageDialog(new JFrame(), "You good fam", "Yes", JOptionPane.INFORMATION_MESSAGE);
        });
        deleteDestinationButton.addActionListener(l -> {
            String destinationS = destination.getText();
            Destination destination = controllerDestination.getDestByName(destinationS);
            controllerDestination.delete(destination);
            JOptionPane.showMessageDialog(new JFrame(), "You good fam. Deleted Destination", "Yes", JOptionPane.INFORMATION_MESSAGE);
        });
        deletePackageButton.addActionListener(l -> {
            String vacPackage = vacationPackage.getText();
            VacPackage vacPackage1 = controllerVacation.getVacPackageByName(vacPackage);
            controllerVacation.delete(vacPackage1);
            JOptionPane.showMessageDialog(new JFrame(), "You good fam. Deleted Package", "Yes", JOptionPane.INFORMATION_MESSAGE);
        });
        viewButton.addActionListener(l -> {
            destinations.setModel(defaultTableModelDestination(controllerDestination.getAll()));
            vacationPackages.setModel(defaultTableModelVacPackage(controllerVacation.getAll()));
        });
        editButton.addActionListener(l -> {
            AddEditVacationForm addEditVacationForm = new AddEditVacationForm(destination.getText(), vacationPackage.getText() ,controllerUser, controllerVacation, controllerDestination);
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

    private DefaultTableModel defaultTableModelDestination(List<Destination> destinations) {
        DefaultTableModel defaultTableModel = new DefaultTableModel();
        String[] columnNames = {"Destination ID", "Name"};
        defaultTableModel.setColumnIdentifiers(columnNames);
        for(Destination destination: destinations) {
            Object[] aux = new Object[2];
            aux[0] = destination.getId();
            aux[1] = destination.getName();
            defaultTableModel.addRow(aux);
        }
        return defaultTableModel;
    }
}
