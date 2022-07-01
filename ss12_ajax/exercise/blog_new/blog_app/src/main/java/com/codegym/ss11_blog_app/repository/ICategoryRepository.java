package com.codegym.ss11_blog_app.repository;

import com.codegym.ss11_blog_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from category", nativeQuery = true)
    List<Category> findAllCategory();

    @Query(value = "select * from blog", nativeQuery = true)
    Page<Category> findAllCategory(Pageable pageable);

    @Query(value = " select  * from category where id = :id", nativeQuery = true)
    Category findById(@Param("id") int id);

}
