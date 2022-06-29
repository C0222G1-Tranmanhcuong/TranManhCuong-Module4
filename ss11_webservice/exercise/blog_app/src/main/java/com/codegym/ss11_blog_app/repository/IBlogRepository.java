package com.codegym.ss11_blog_app.repository;


import com.codegym.ss11_blog_app.model.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

@Transactional
public interface IBlogRepository extends JpaRepository<Blog, Integer> {

    @Query(value = "select * from blog", nativeQuery = true)
    List<Blog> findAllBlog();

    @Query(value = "select * from blog", nativeQuery = true)
    Page<Blog> findAllBlog(Pageable pageable);


    @Modifying
    @Query(value = "insert into blog(name_blog,content,create_day) value(:name_blog,:content,:create_day) ", nativeQuery = true)
    void save(@Param("name_blog") String nameBlog, @Param("content") String content, @Param("create_day") String createDay);

    @Query(value = " select  * from blog where id_blog = :id", nativeQuery = true)
    Blog findById(@Param("id") int id);


    @Modifying
    @Query(value = "update blog set name_blog= :name_blog,content=:content, create_day =:create_day, id =:id where id_blog =:id", nativeQuery = true)
    void update(@Param("name_blog") String nameBlog, @Param("content") String content, @Param("create_day") String createDay, @Param("id") Integer idBlog, @Param("id") Integer id);

    @Modifying
    @Query(value = "delete from blog where id_blog =:id", nativeQuery = true)
    void remove(@Param("id") Integer idBlog);

    @Query(value = "select * from blog where name_blog Like :nameBlog", nativeQuery = true)
    Page<Blog> searchByName(@Param("nameBlog") String nameBlog, Pageable pageable);
}
