package com.grapghql.entities;

import ch.qos.logback.core.joran.action.AppenderRefAction;
import jakarta.persistence.*;
import jakarta.websocket.server.ServerEndpoint;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "orders")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int orderId;
    private String orderDetail;
    private String address;
    private int price;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
