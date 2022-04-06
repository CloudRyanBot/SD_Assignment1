package controller;

import model.VacPackage;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.util.List;
import java.util.OptionalInt;

public class ControllerVacation {

    EntityManagerFactory em;

    public ControllerVacation(EntityManagerFactory em) {
        this.em = em;
    }


    public List <VacPackage> getAll()
    {
        List<VacPackage> vacations = em.createEntityManager().createQuery("SELECT v FROM VacPackage v").getResultList();
        return vacations;
    }

    public VacPackage getVacPackageByName(String name) {
        List<VacPackage> vacPackages = em.createEntityManager().createQuery("SELECT v FROM VacPackage v WHERE v.name = '" + name + "'").getResultList();
        if (vacPackages.size() == 0)
            return null;
        return vacPackages.get(0);
    }

    public void delete(VacPackage vacPackage)
    {
        try {
            EntityManager ent = em.createEntityManager();
            ent.getTransaction().begin();
            VacPackage vacPackage1 = ent.find(VacPackage.class, vacPackage.getId());
            ent.remove(vacPackage1);
            ent.getTransaction().commit();
            ent.close();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void create(VacPackage vacPackage) {
        try {
            OptionalInt maxId = getAll().stream().map(VacPackage::getId).mapToInt(i -> i).max();
            if (maxId.isPresent()) {
                vacPackage.setId(maxId.getAsInt() + 1);
            } else {
                vacPackage.setId(0);
            }
            EntityManager ent = em.createEntityManager();
            ent.getTransaction().begin();
            ent.persist(vacPackage);
            ent.flush();
            ent.getTransaction().commit();
            ent.close();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void save(VacPackage vacPackage) {
        try {
            EntityManager ent = em.createEntityManager();
            ent.getTransaction().begin();
            ent.merge(vacPackage);
            ent.flush();
            ent.getTransaction().commit();
            ent.close();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
        }
    }
}
