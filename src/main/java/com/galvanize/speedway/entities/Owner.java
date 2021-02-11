package com.galvanize.speedway.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

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
    private List<Car> cars;

    private Integer wins;

    private Integer losses;

    @Override
    public String toString() {
        return "Owner{" +
                "ownerId=" + ownerId +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", age=" + age +
                ", nickName='" + nickName + '\'' +
                ", wins=" + wins +
                ", losses=" + losses +
                '}';
    }
}
