package com.team7.model;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Getter
@Setter
@Entity
@Table(name="test")
public class Test {

    @Id
    private Long id;
    private Long value;

}
