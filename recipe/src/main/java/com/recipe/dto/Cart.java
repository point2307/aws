package com.recipe.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = {"fundingkit","member"})
public class Cart {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long cartId;

    @ManyToOne
    @JoinColumn(name = "customer")
    private Member member;

    @OneToOne
    private FundingKit fundingKit;

    private int quantity;

    @Transient
    private int total;

    @PrePersist
    public void prePersist(){
        this.total=0;
    }
}
