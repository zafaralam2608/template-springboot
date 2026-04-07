package com.project.template.service;

import com.project.template.mapper.SampleMapper;
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
    public SampleService(final JpaRepository<Sample, Long> repository,
            final SampleMapper mapper) {
        super(repository);
        this.mapper = mapper;
    }

    private final SampleMapper mapper;

    @Override
    protected SampleResource convertModelToResource(final Sample model) {
        return mapper.toResource(model);
    }

    @Override
    protected Sample convertResourceToModel(final SampleResource resource) {
        return mapper.toModel(resource);
    }

}
