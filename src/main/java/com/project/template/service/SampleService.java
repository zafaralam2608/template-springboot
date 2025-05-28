package com.project.template.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

import com.project.template.model.Sample;
import com.project.template.resource.SampleResource;

@Service
public final class SampleService extends BaseService<Sample, SampleResource> {

    /**
     * @param repository the user repository
     */
    @Autowired
    public SampleService(final JpaRepository<Sample, Long> repository) {
        super(repository);
    }

    @Override
    protected SampleResource convertModelToResource(final Sample model) {
        return getMapper().map(model, SampleResource.class);
    }

    @Override
    protected Sample convertResourceToModel(final SampleResource resource) {
        return getMapper().map(resource, Sample.class);
    }

}
