package com.recipe.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;


@Entity
@Getter
@Setter
@ToString(exclude = {"buy", "fundingkit"})
public class BuyDetail {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "buyDetailSeq")
    private Long buyDeId;

    @ManyToOne
    @JoinColumn(name = "buy")
    private Buy buy;

    @OneToOne
    @JoinColumn(name = "fundingkit")
    private FundingKit fundingkit;

    private int quantity;
    @CreationTimestamp
    @Temporal(TemporalType.TIMESTAMP)
    private Date buyDate;

    private String process;

    private int alert;

    @PrePersist
    public void prePersist(){
        this.alert = 0;
        this.process = "결제대기중";
    }

}
