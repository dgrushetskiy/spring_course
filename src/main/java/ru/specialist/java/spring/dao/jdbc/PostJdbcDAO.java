package ru.specialist.java.spring.dao.jdbc;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;
import ru.specialist.java.spring.dao.AbstractDAO;
import ru.specialist.java.spring.dto.PostDto;

import java.util.List;

@Repository
public class PostJdbcDAO implements AbstractDAO<PostDto> {

    private final RowMapper<PostDto> rowMapper = (rs, rowNum) -> {
        PostDto post = new PostDto();
        post.setPostId(rs.getLong(1));
        post.setTitle(rs.getString(2));
        post.setContent(rs.getString(3));
        post.setCreatedAt(rs.getTimestamp(4).toLocalDateTime());
        if (rs.getTimestamp(5) != null)
            post.setUpdatedAt(rs.getTimestamp(5).toLocalDateTime());
        return post;
    };

    private JdbcOperations jdbcOperations;

    @Autowired
    public PostJdbcDAO(JdbcOperations jdbcOperations) {
        this.jdbcOperations = jdbcOperations;
    }

    @Override
    public void create(PostDto dto) {
        final String query = "insert into " +
                "\tmicroblog.posts (title, content, created_at, updated_at) \n" +
                "\tvalues (?, ?, ?, ?);";

        jdbcOperations.update(query, dto.getTitle(),
                dto.getContent(),
                dto.getCreatedAt(),
                dto.getUpdatedAt()
        );
    }

    @Override
    public List<PostDto> getAll() {
        final String query = "select \n" +
                "id,\n" +
                "\ttitle,\n" +
                "\tcontent,\n" +
                "\tcreated_at,\n" +
                "\tupdated_at\n" +
                "from \n" +
                "\tmicroblog.posts;";

        return jdbcOperations.query(query, rowMapper);
    }

    @Override
    public PostDto getById(long id) {
        final String query = "select \n" +
                "\tid,\n" +
                "\ttitle,\n" +
                "\tcontent,\n" +
                "\tcreated_at,\n" +
                "\tupdated_at\n" +
                "from \n" +
                "\tmicroblog.posts\n" +
                "where\n" +
                "\tid = ?";

        return jdbcOperations.queryForObject(query,
                new Object[]{id},
                rowMapper
        );
    }

    @Override
    public void update(long id, PostDto dto) {
        final String query = "update microblog.posts set\n" +
                "\ttitle = ?,\n" +
                "\tcontent = ?,\n" +
                "\tcreated_at = ?,\n" +
                "\tupdated_at = ?\n" +
                "where\n" +
                "\tpost_id = ?";

        jdbcOperations.update(query, dto.getTitle(),
                dto.getContent(),
                dto.getCreatedAt(),
                dto.getUpdatedAt(),
                id
        );
    }

    @Override
    public void delete(long id) {
        final String query = "delete from microblog.posts where id = ?";

        jdbcOperations.update(query, id);
    }
}
