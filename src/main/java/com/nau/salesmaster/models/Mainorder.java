package com.nau.salesmaster.models;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by User on 08.05.2015.
 */
@Table(name = "mainorder", schema = "public")
@Entity
public class MainOrder {
    private int id;
    private Timestamp date;
    private Customer customerByCustomerId;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "mainorder_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "mainorder_seq", sequenceName = "mainorder_id_seq")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "date")
    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MainOrder mainOrder = (MainOrder) o;

        if (id != mainOrder.id) return false;
        if (date != null ? !date.equals(mainOrder.date) : mainOrder.date != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (date != null ? date.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "customerid", referencedColumnName = "id", nullable = false)
    public Customer getCustomerByCustomerId() {
        return customerByCustomerId;
    }

    public void setCustomerByCustomerId(Customer customerByCustomerid) {
        this.customerByCustomerId = customerByCustomerid;
    }
}
