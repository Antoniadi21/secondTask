package com.example.secondlab.Repositories;

import com.example.secondlab.Mappers.UserMapper;
import com.example.secondlab.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;


    public UserRepository(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public User getByLogin(String login) {
        return (User) jdbcTemplate.query("SELECT user_id, login, password, email " +
                "FROM \"user\" WHERE login = ?",new UserMapper(), login)
                .stream().findAny().orElse(null);
    }

    public User getByEmail(String email) {
        return (User) jdbcTemplate.query("SELECT user_id, login, password, email " +
                        "FROM \"user\" WHERE email = ?",new UserMapper(), email)
                .stream().findAny().orElse(null);
    }

    public void insertUserIntoTable(User user) {
        jdbcTemplate.update("INSERT INTO \"user\" (login, password, email) " +
                "VALUES(?, ?, ?)", user.getLogin(), user.getPassword(), user.getEmail());
    }
}
