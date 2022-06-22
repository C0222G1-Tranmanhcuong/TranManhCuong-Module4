package com.codegym.ss7_blog_app.repository;

import com.codegym.ss7_blog_app.model.Blog;
import com.codegym.ss7_blog_app.model.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface ICategoryRepository extends JpaRepository<Category, Integer> {
    @Query(value = "select * from category", nativeQuery = true)
    List<Category> findAllCategory();

    @Query(value = " select  * from category where id_category = :id", nativeQuery = true)
    Category findById(@Param("id") int id);

}
