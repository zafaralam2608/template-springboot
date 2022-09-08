package com.project.template.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.project.template.model.Sample;

@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
