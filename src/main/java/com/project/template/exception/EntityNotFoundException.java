package com.project.template.exception;

import java.io.Serial;

/**
 * Exception thrown when an entity is not found.
 */
public class EntityNotFoundException extends RuntimeException {

  /**
   * Serial version UID.
   */
  @Serial
  private static final long serialVersionUID = 1L;

  /**
   * Constructor.
   *
   * @param id the ID of the requested entity
   */
  public EntityNotFoundException(final Long id) {
    super("Couldn't find entity with id: " + id);
  }

}
