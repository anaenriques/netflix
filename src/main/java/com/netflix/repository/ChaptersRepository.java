package com.netflix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.model.Categories;
import com.netflix.model.Chapters;

@Repository
@Qualifier("ChaptersRepository")
public interface ChaptersRepository  extends JpaRepository<Chapters, Integer>{

}
