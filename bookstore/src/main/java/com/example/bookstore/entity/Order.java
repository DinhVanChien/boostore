package com.example.bookstore.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="ORDERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="item_id")
    private Integer itemId;

    @Column(name="item_name")
    private String itemName;

    @Column(name="item_price")
    private Integer itemPrice;

    @Column(name="purchase_date")
    private String purchaseDate;
}
