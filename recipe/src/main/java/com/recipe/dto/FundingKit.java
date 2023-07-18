package com.recipe.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter@Setter
@ToString
@Entity
public class FundingKit {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long fundKitId;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "funding")
    private Funding funding;
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "mealkit")
    private Mealkit mealkit;

    private int selling;

    @PrePersist
    public void prePersist(){
        this.selling = 0;
    }
}
