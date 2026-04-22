package com.project.template.service;

import com.project.template.mapper.SampleMapper;
import com.project.template.model.Sample;
import com.project.template.resource.SampleResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

/**
 * Service for Sample operations.
 */
@Service
public final class SampleService extends BaseService<Sample, SampleResource> {

  /**
   * The mapper for converting between model and resource.
   */
  private final SampleMapper mapper;

  /**
   * Constructs a new SampleService.
   *
   * @param repository the user repository
   * @param sampleMapper the sample mapper
   */
  @Autowired
  public SampleService(final JpaRepository<Sample, Long> repository,
      final SampleMapper sampleMapper) {
    super(repository);
    this.mapper = sampleMapper;
  }

  @Override
  protected SampleResource convertModelToResource(final Sample model) {
    return mapper.toResource(model);
  }

  @Override
  protected Sample convertResourceToModel(final SampleResource resource) {
    return mapper.toModel(resource);
  }

}
