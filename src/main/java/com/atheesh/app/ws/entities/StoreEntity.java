package com.atheesh.app.ws.entities;

import com.atheesh.app.ws.shared.enums.Status;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity
@Table(name = "store")
public class StoreEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotNull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="item_id")
    private ItemEntity item;

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="shop_id")
    private ShopEntity shop;

    @NotNull
    private Integer amount;

    @NotNull
    private Integer minLimit;

    @NotNull
    private Status status;

    public StoreEntity() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemEntity getItem() {
        return item;
    }

    public void setItem(ItemEntity item) {
        this.item = item;
    }

    public ShopEntity getShop() {
        return shop;
    }

    public void setShop(ShopEntity shop) {
        this.shop = shop;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Integer getMinLimit() {
        return minLimit;
    }

    public void setMinLimit(Integer minLimit) {
        this.minLimit = minLimit;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "StoreEntity{" +
                "id=" + id +
                ", item=" + item.toString() +
                ", shop=" + shop.toString() +
                ", amount=" + amount +
                ", minLimit=" + minLimit +
                ", status=" + status +
                '}';
    }
}
