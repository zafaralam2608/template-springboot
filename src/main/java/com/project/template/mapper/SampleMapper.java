package com.project.template.mapper;

import org.mapstruct.Mapper;

import com.project.template.model.Sample;
import com.project.template.resource.SampleResource;

/**
 * MapStruct mapper interface for Sample <-> SampleResource.
 */
@Mapper(componentModel = "spring")
public interface SampleMapper {

    SampleResource toResource(Sample model);

    Sample toModel(SampleResource resource);

}
