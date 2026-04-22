package com.project.template.resource;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

/**
 * Base resource class.
 */
@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_EMPTY)
public abstract class BaseResource {

  /** The unique id. */
  private Long id;
}
