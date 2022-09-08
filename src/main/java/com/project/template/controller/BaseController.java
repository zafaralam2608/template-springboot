package com.project.template.controller;

import java.util.List;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.project.template.model.Base;
import com.project.template.resource.BaseResource;
import com.project.template.service.BaseService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public abstract class BaseController
    <M extends Base, R extends BaseResource> {

    /** The service dependency. */
    private final BaseService<M, R> service;

    /**
     * Gets all the resources.
     *
     * @return the list of resources
     */
    @GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
    public List<R> fetchAll() {
        return service.getAll();
    }

    /**
     * Gets a resource by ID.
     *
     * @param id the ID of the requested resource
     * @return the resources
     */
    @GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public R fetchById(@PathVariable final Long id) {
        return service.get(id);
    }

    /**
     * Update resources details by ID.
     *
     * @param resource the request body for a resource
     * @return the resources
     */
    @PostMapping(produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public R create(@RequestBody final R resource) {
        return service.create(resource);
    }

    /**
     * Update resources details by ID.
     *
     * @param id       the ID of the requested resource
     * @param resource the request body for a resource
     * @return the resources
     */
    @PostMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public R updateById(@PathVariable final Long id,
            @RequestBody final R resource) {
        return service.update(id, resource);
    }

    /**
     * Delete resources by IDs.
     *
     * @param ids the IDs of the requested resources
     */
    @DeleteMapping
    public void deleteByIds(@RequestBody final List<Long> ids) {
        service.delete(ids);
    }
}
