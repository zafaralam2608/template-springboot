package com.project.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.template.model.Sample;
import com.project.template.resource.SampleResource;
import com.project.template.service.SampleService;

@RestController
@RequestMapping("/sample")
public class SampleController extends BaseController<Sample, SampleResource> {

    /**
     * @param service dependency for user
     */
    @Autowired
    public SampleController(final SampleService service) {
        super(service);
    }

}
