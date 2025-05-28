package com.project.template.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.MappedSuperclass;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@MappedSuperclass
public abstract class Base {

    /** The time stamp of entity creation. */
    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private Date created;

    /** The time stamp of entity last update. */
    @UpdateTimestamp
    private Date updated;
}
