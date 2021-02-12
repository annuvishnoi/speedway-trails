package com.galvanize.speedway.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Table(name = "owner")
public class Owner {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long ownerId;

    private String firstName;

    private String lastName;

    private Integer age;

    private String  nickName;

    @OneToMany(mappedBy = "owner", fetch = FetchType.EAGER,
            cascade = CascadeType.ALL)
    @JsonIgnore
    @ToString.Exclude
    private List<Car> cars;

    private Integer wins;

    private Integer losses;

}
