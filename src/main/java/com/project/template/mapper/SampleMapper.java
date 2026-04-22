package com.project.template.mapper;

import com.project.template.model.Sample;
import com.project.template.resource.SampleResource;
import org.mapstruct.Mapper;

/**
 * MapStruct mapper interface for Sample <-> SampleResource.
 */
@Mapper(componentModel = "spring")
public interface SampleMapper {

  /**
   * Converts a Sample model to a SampleResource.
   *
   * @param model the Sample model
   * @return the SampleResource
   */
  SampleResource toResource(Sample model);

  /**
   * Converts a SampleResource to a Sample model.
   *
   * @param resource the SampleResource
   * @return the Sample model
   */
  Sample toModel(SampleResource resource);

}
