package model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "destination")
public class Destination {
    @Id
    @Column(name = "destination_id")
    private int id;

    @Column(name = "name")
    private String name;

    @OneToMany(mappedBy = "destination", cascade = CascadeType.ALL)
    private List<VacPackage> vacPackages;




    public Destination() {
    }

    public Destination(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getName() {
        return name;
    }

    public List<VacPackage> getVacPackages() {
        return vacPackages;
    }


    public void setName(String name) {
        this.name = name;
    }



}
