package com.nuvucreditcvargas.nuvucredit.persistence.entity;

import javax.persistence.*;

@Entity
@Table(name = "franchise")
public class Franchise {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "name_franchise", nullable = false)
    private String nameFranchise;

    @Column(name = "active", nullable = false)
    private Boolean active;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameFranchise() {
        return nameFranchise;
    }

    public void setNameFranchise(String nameFranchise) {
        this.nameFranchise = nameFranchise;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    @Override
    public String toString() {
        return "Franchise{" +
                "id=" + id +
                ", nameFranchise='" + nameFranchise + '\'' +
                ", active=" + active +
                '}';
    }
}
