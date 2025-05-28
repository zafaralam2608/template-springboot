package com.project.template.service;

import java.util.List;
import java.util.Optional;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import com.project.template.exception.EntityNotFoundException;
import com.project.template.model.Base;
import com.project.template.resource.BaseResource;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class BaseService<M extends Base, R extends BaseResource> {

    /** The dependency for ModelMapper. */
    @Autowired
    private ModelMapper mapper;

    /** The repository dependency. */
    private final JpaRepository<M, Long> repository;

    /**
     * Gets a resource by ID.
     *
     * @param id the ID of the requested resource
     * @return the resource
     */
    public R get(final Long id) {
        Optional<M> model = repository.findById(id);
        if (model.isEmpty()) {
            throw new EntityNotFoundException(id);
        }
        return convertModelToResource(model.get());
    }

    /**
     * Gets all the resources.
     *
     * @return the resources
     */
    public List<R> getAll() {
        return convertModelsToResources(repository.findAll());
    }

    /**
     * Update model details by ID.
     *
     * @param resource the resource body for a model
     * @return the resource
     */
    public R create(final R resource) {
        M model = convertResourceToModel(resource);
        return convertModelToResource(repository.save(model));
    }

    /**
     * Update model details by ID.
     *
     * @param id       the ID of the requested model
     * @param resource the resource body for a model
     * @return the resource
     */
    public R update(final Long id, final R resource) {
        if (!repository.existsById(id)) {
            throw new EntityNotFoundException(id);
        }
        resource.setId(id);
        M model = convertResourceToModel(resource);
        return convertModelToResource(repository.save(model));
    }

    /**
     * Delete models by IDs.
     *
     * @param ids the IDs of the requested model
     */
    public void delete(final List<Long> ids) {
        repository.deleteAllById(ids);
    }

    /**
     * Convert a model to a resource.
     *
     * @param model the model
     * @return the resource
     */
    protected abstract R convertModelToResource(M model);

    /**
     * Convert a list of models to a list of resources.
     *
     * @param models the list of models
     * @return the list of resources
     */
    protected List<R> convertModelsToResources(final List<M> models) {
        return models.stream().map(this::convertModelToResource)
                .toList();
    }

    /**
     * Convert a resource to a model.
     *
     * @param resource the resource
     * @return the model
     */
    protected abstract M convertResourceToModel(R resource);
}
