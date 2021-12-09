package net.beotel.models;

import javax.persistence.*;

@Entity
@Table(name="PRICE")
public class Price {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="NAME")
    private String name;

    @ManyToOne (fetch=FetchType.EAGER,cascade=CascadeType.MERGE, targetEntity=Service.class)
    @JoinColumn(name = "SERVICE_ID")
    private Service service;

    @Column(name="AMOUNT")
    private Double amount;

    public Price () {

    }

    public Price (String name, Service service, Double amount) {
        super();
        this.name = name;
        this.service = service;
        this.amount = amount;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }
}
