package controller;

import model.Destination;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.util.List;
import java.util.OptionalInt;

public class ControllerDestination {

    EntityManagerFactory em;

    public ControllerDestination(EntityManagerFactory em)
    {
        this.em = em;
    }

    public Destination getDestByName(String name)
    {
        List<Destination> destinations = em.createEntityManager().createQuery("SELECT d FROM Destination d WHERE d.name = '" + name + "'").getResultList();
        if(destinations.size() == 0)
            return null;
        return destinations.get(0);
    }

    public List<Destination> getAll()
    {
        return (List<Destination>) em.createEntityManager().createQuery("SELECT d FROM Destination d").getResultList();
    }

    public void save(Destination destination)
    {
        try {
            EntityManager ent = em.createEntityManager();
            ent.getTransaction().begin();
            ent.persist(destination);
            ent.flush();
            ent.getTransaction().commit();
            ent.close();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void delete(Destination destination)
    {
        try {
            EntityManager ent = em.createEntityManager();
            ent.getTransaction().begin();
            Destination destination1 = ent.find(Destination.class, destination.getId());
            ent.remove(destination1);
            ent.flush();
            ent.getTransaction().commit();
            ent.close();
        }catch(Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
        }
    }


    public void create(Destination destination) {
        try {
            OptionalInt maxId = getAll().stream().map(Destination::getId).mapToInt(i -> i).max();
            if (maxId.isPresent()) {
                destination.setId(maxId.getAsInt() + 1);
            } else {
                destination.setId(0);
            }
            EntityManager ent = em.createEntityManager();
            ent.getTransaction().begin();
            ent.persist(destination);
            ent.flush();
            ent.getTransaction().commit();
            ent.close();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
        }
    }
}
