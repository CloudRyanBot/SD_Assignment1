package controller;


import model.*;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.swing.*;
import java.util.List;
import java.util.OptionalInt;

public class ControllerUser {

    EntityManagerFactory em;


    public ControllerUser(EntityManagerFactory em) {
        this.em = em;
    }

    public User findByName(String name) {
        return null;
    }

    public User getUserByName(String name) {
        List<User> users = em.createEntityManager().createQuery("SELECT u FROM User u WHERE u.user = '" + name + "'").getResultList();
        if (users.size() == 0)
            return null;
        return users.get(0);
    }

    public List <User> getAll()
    {
        List<User> user = em.createEntityManager().createQuery("SELECT u FROM User u").getResultList();
        return user;
    }

    public User getUsersById(int id) {
        return em.createEntityManager().find(User.class, id);
    }

    public void create(User user)
    {
        try {
            OptionalInt maxId = getAll().stream().map(User::getId).mapToInt(i -> i).max();
            if (maxId.isPresent()) {
                user.setId(maxId.getAsInt() + 1);
            } else {
                user.setId(0);
            }
            EntityManager ent = em.createEntityManager();
            ent.getTransaction().begin();
            ent.persist(user);
            ent.flush();
            ent.getTransaction().commit();
            ent.close();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void save(User user)
    {

        try {
            EntityManager ent = em.createEntityManager();
            ent.getTransaction().begin();
            ent.merge(user);
            ent.flush();
            ent.getTransaction().commit();
            ent.close();
        }catch (Exception e)
        {
            JOptionPane.showMessageDialog(new JFrame(), "Something went wrong", "No", JOptionPane.ERROR_MESSAGE);
        }
    }

}
