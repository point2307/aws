package com.recipe.dto;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter
@Setter
@ToString(exclude = {"member, material"})
public class MyMaterial {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long myMaterId;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member member;
    @OneToOne
    @JoinColumn(name = "material")
    private Material material;


}
