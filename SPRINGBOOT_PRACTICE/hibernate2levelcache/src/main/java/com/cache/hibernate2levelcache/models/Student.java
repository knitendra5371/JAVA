package com.cache.hibernate2levelcache.models;

import lombok.*;
import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;


import javax.persistence.*;

@Entity
@Table(name = "student")
@Cacheable
@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Student {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    private String name;
    private String city;

}
