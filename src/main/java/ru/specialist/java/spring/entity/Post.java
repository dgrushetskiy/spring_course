package ru.specialist.java.spring.entity;

import ru.specialist.java.spring.entity.audit.DateAudit;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "posts", schema = "microblog")
public class Post extends DateAudit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true)
    private Long id;
    @Column(name = "title", length = 150)
    private String title;

    private String content;

    @ManyToMany
    @JoinTable(
            name = "post_tag", schema = "microblog",
            joinColumns = @JoinColumn(name = "post_id", foreignKey = @ForeignKey(name = "fk_post_tag_posts")),
            inverseJoinColumns = @JoinColumn(name = "tag_id", foreignKey = @ForeignKey(name = "fk_post_tag_tags"))
    )
    private List<Tag> tags;

    @ManyToOne
    @JoinColumn(name = "user_id", foreignKey = @ForeignKey(name = "fk_posts_users"))
    private User user;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "comment", fetch = FetchType.LAZY)
    private List<Comment> comments;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }



    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Comment> getComments() {
        return comments;
    }

    public void setComments(List<Comment> comments) {
        this.comments = comments;
    }
}
