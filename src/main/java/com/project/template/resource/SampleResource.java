package com.project.template.resource;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SampleResource extends BaseResource {

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
