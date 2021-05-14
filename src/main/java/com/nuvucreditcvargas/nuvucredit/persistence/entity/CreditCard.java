package com.nuvucreditcvargas.nuvucredit.persistence.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "credit_cards")
public class CreditCard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "number_card", nullable = false)
    private Long numberCard;

    @Column(name = "expiration_date", nullable = false)
    private Date expirationDate;

    @Column(nullable = false)
    private Integer cvv;

    @Column(name = "id_person")
    private Long idPerson;

    private Boolean active;

    @Column(name = "id_franchise", nullable = false)
    private Integer idFranchise;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumberCard() {
        return numberCard;
    }

    public void setNumberCard(Long numberCard) {
        this.numberCard = numberCard;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Integer getCvv() {
        return cvv;
    }

    public void setCvv(Integer cvv) {
        this.cvv = cvv;
    }

    public Long getIdPerson() {
        return idPerson;
    }

    public void setIdPerson(Long idPerson) {
        this.idPerson = idPerson;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }

    public Integer getIdFranchise() {
        return idFranchise;
    }

    public void setIdFranchise(Integer idFranchise) {
        this.idFranchise = idFranchise;
    }

    @Override
    public String toString() {
        return "CreditCards{" +
                "id=" + id +
                ", numberCard=" + numberCard +
                ", expirationDate=" + expirationDate +
                ", cvv=" + cvv +
                ", idPerson=" + idPerson +
                ", active=" + active +
                ", idFranchise=" + idFranchise +
                '}';
    }
}
