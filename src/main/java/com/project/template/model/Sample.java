package com.project.template.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Sample extends Base {

    /** The unique id. */
    @Id
    @SequenceGenerator(
            name = "SAMPLE_ID_GEN", allocationSize = 1)
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE, generator = "SAMPLE_ID_GEN")
    private Long id;

    /** The name of user. */
    private String username;

    /** The password of user. */
    private String password;

    /** The first name of user. */
    private String firstName;

    /** The last name of user. */
    private String lastName;

    /** The main id of user. */
    private String email;

}
