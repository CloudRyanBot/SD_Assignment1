package model;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "vacpackage")
public class VacPackage {

    @Id
    @Column(name = "vacpackid")
    private int id;

    @Column(name =  "name")
    private String name;

    @Column(name =  "extra_details")
    private String extra_details;

    @Column(name = "price")
    private Integer price;

    @Column(name = "start_date")
    private LocalDate date_start;

    @Column(name = "end_date")
    private LocalDate date_end;

    @Column(name = "slots_available")
    private Integer slots_available;

    @Column(name = "total_slots")
    private Integer slots_total;


    @ManyToOne
    @JoinColumn(name = "destination")
    Destination destination;


    public VacPackage() {
    }

    public VacPackage(Destination destination, String name, String extra_details, Integer price, LocalDate date_start, LocalDate date_end, Integer slots_total) {
        this.destination = destination;
        this.name = name;
        this.extra_details = extra_details;
        this.price = price;
        this.date_start = date_start;
        this.date_end = date_end;
        this.slots_total = slots_total;
    }

    public VacPackage(int id, Destination destination, String name, String extra_details, Integer price, LocalDate date_start, LocalDate date_end, Integer slots_total) {
        this.id = id;
        this.destination = destination;
        this.name = name;
        this.extra_details = extra_details;
        this.price = price;
        this.date_start = date_start;
        this.date_end = date_end;
        this.slots_total = slots_total;
    }

    public String getExtra_details() {
        return extra_details;
    }

    public LocalDate getDate_start() {
        return date_start;
    }

    public LocalDate getDate_end() {
        return date_end;
    }

    public void setExtra_details(String extra_details) {
        this.extra_details = extra_details;
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

    public void setName(String name) {
        this.name = name;
    }


    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setDate_start(LocalDate date_start) {
        this.date_start = date_start;
    }

    public void setDate_end(LocalDate date_end) {
        this.date_end = date_end;
    }

    public Integer getSlots_available() {
        return slots_available;
    }

    public void setSlots_available(Integer slots_available) {
        this.slots_available = slots_available;
    }


    public Integer getSlots_total() {
        return slots_total;
    }

    public void setSlots_total(Integer slots_total) {
        this.slots_total = slots_total;
    }


    public Destination getDestination() {
        return destination;
    }



}
