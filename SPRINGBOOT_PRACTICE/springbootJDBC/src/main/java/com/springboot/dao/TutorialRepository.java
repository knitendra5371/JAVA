package com.springboot.dao;

import com.springboot.model.Tutorial;

import java.util.List;

public interface TutorialRepository {
    void save(Tutorial book);

    void update(Tutorial book);

    Tutorial findById(Long id);

    int deleteById(Long id);

    List<Tutorial> findAll();

    List<Tutorial> findByPublished(boolean published);

    List<Tutorial> findByTitleContaining(String title);

    int deleteAll();
}
