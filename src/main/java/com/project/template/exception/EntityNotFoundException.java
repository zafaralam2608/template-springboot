package com.project.template.exception;

public class EntityNotFoundException extends RuntimeException {

    /**
     * serial ID.
     */
    private static final long serialVersionUID = 1L;

    /**
     * Constructor.
     *
     * @param id       the ID of the requested entity
     */
    public EntityNotFoundException(final Long id) {
        super("Couldnt find entity with id: " + id);
    }

}
