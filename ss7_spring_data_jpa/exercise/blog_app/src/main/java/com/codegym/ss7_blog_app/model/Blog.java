package com.codegym.ss7_blog_app.model;

import javax.persistence.*;

@Entity(name = "blog")
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_blog")
    private Integer idBlog;
    @Column(name = "name_blog")
    private String nameBlog;
    private String content;
    @Column(name = "create_day")
    private String createday;
    @ManyToOne
    @JoinColumn(name = "id",referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(Integer idBlog, String nameBlog, String content, String createday, Category category) {
        this.idBlog = idBlog;
        this.nameBlog = nameBlog;
        this.content = content;
        this.createday = createday;
        this.category = category;
    }

    public Integer getIdBlog() {
        return idBlog;
    }

    public void setIdBlog(Integer idBlog) {
        this.idBlog = idBlog;
    }

    public String getNameBlog() {
        return nameBlog;
    }

    public void setNameBlog(String nameBlog) {
        this.nameBlog = nameBlog;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getCreateday() {
        return createday;
    }

    public void setCreateday(String createday) {
        this.createday = createday;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
