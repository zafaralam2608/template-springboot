package com.project.template.repository;

import com.project.template.model.Sample;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Repository for Sample entity.
 */
@Repository
public interface SampleRepository extends JpaRepository<Sample, Long> {

}
