package com.atheesh.app.ws.entities;

import com.atheesh.app.ws.shared.enums.OfferType;
import com.atheesh.app.ws.shared.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name="offers")
public class OfferEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    private Date startDate;

    @NotNull
    private Date endDate;

    @NotNull
    private String name;

    @NotNull
    private String imageUrl;

    private String description;

    @NotNull
    private OfferType type;

    @NotNull
    private Integer amountOne;

    private Integer amountTwo;

    @NotNull
    private Date createdDate;

    @NotNull
    private Date UpdatedDate;

    @NotNull
    private Status status;

    public OfferEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OfferType getType() {
        return type;
    }

    public void setType(OfferType type) {
        this.type = type;
    }

    public Integer getAmountOne() {
        return amountOne;
    }

    public void setAmountOne(Integer amountOne) {
        this.amountOne = amountOne;
    }

    public Integer getAmountTwo() {
        return amountTwo;
    }

    public void setAmountTwo(Integer amountTwo) {
        this.amountTwo = amountTwo;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return UpdatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        UpdatedDate = updatedDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "OfferEntity{" +
                "id=" + id +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", name='" + name + '\'' +
                ", imageUrl='" + imageUrl + '\'' +
                ", description='" + description + '\'' +
                ", type=" + type +
                ", amountOne=" + amountOne +
                ", amountTwo=" + amountTwo +
                ", createdDate=" + createdDate +
                ", UpdatedDate=" + UpdatedDate +
                ", status=" + status +
                '}';
    }
}
