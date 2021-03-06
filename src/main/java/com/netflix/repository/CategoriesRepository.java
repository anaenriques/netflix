/*
 * Categories's Repository
 * @author: Ana Enrique
 * @version: v1.0
 */
package com.netflix.repository;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.netflix.model.Categories;

/**
 * The Interface CategoriesRepository.
 */
@Repository
@Qualifier("CategoriesRepository")
public interface CategoriesRepository  extends JpaRepository<Categories, Long>{

}
