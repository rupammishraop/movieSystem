package com.movieSystem.movieSystem.controller;

import com.movieSystem.movieSystem.Entity.Movie;
import com.movieSystem.movieSystem.Interfaces.MovieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

@Repository
public class MovieRepositoryImpl implements MovieRepository {

    @Autowired
    JdbcTemplate jdbcTemplate;

    @Override
    public void save(Movie movie) {
        String sql = "insert into movies(name, genre, language) values(?,?,?)";
        jdbcTemplate.update(sql, movie.getName(), movie.getGenre(), movie.getLanguage());

    }

    @Override
    public Movie getByName(String name) {
        String sql = "select * from movies where name = ?";
        List<Movie> movies = jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1, name);
            }
        }, new RowMapper<Movie>() {
            @Override
            public Movie mapRow(ResultSet rs, int rowNum) throws SQLException {
                 Movie movie = new Movie();
                 movie.setName(rs.getString(2));
                 movie.setGenre(rs.getString(3));
                 movie.setLanguage(rs.getString(4));
                 return movie;

            }
        });
        if (!movies.isEmpty()) {
            return movies.get(0);
        }
        return null;

    }

    @Override
    public void updateMovie(Movie movie) {
          String sql = "update movies set genre = ?, language = ? where name = ?";
          jdbcTemplate.update(sql, movie.getGenre(), movie.getLanguage(), movie.getName());
    }

    @Override
    public void deleteMovie(String name) {
        String sql = "delete from movies where name = ?";
        jdbcTemplate.update(sql, name);
    }
}
