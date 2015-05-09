package com.nau.salesmaster.models;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * Created by User on 08.05.2015.
 */
@Table(name = "orderedproduct", schema = "public")
@Entity
public class OrderedProduct {
    private int id;
    private BigDecimal count;
    private BigDecimal price;
    private MainOrder mainOrderByOrderId;
    private Product productByProductId;

    @Id
    @Column(name = "id")
    @GeneratedValue(generator = "orderedproduct_seq", strategy = GenerationType.SEQUENCE)
    @SequenceGenerator(name = "orderedproduct_seq", sequenceName = "orderedproduct_id_seq")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "count")
    public BigDecimal getCount() {
        return count;
    }

    public void setCount(BigDecimal count) {
        this.count = count;
    }

    @Basic
    @Column(name = "price")
    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderedProduct that = (OrderedProduct) o;

        if (id != that.id) return false;
        if (count != null ? !count.equals(that.count) : that.count != null) return false;
        if (price != null ? !price.equals(that.price) : that.price != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id;
        result = 31 * result + (count != null ? count.hashCode() : 0);
        result = 31 * result + (price != null ? price.hashCode() : 0);
        return result;
    }

    @ManyToOne
    @JoinColumn(name = "orderid", referencedColumnName = "id", nullable = false)
    public MainOrder getMainOrderByOrderId() {
        return mainOrderByOrderId;
    }

    public void setMainOrderByOrderId(MainOrder mainOrderByOrderid) {
        this.mainOrderByOrderId = mainOrderByOrderid;
    }

    @ManyToOne
    @JoinColumn(name = "productid", referencedColumnName = "id", nullable = false)
    public Product getProductByProductId() {
        return productByProductId;
    }

    public void setProductByProductId(Product productByProductId) {
        this.productByProductId = productByProductId;
    }

}
