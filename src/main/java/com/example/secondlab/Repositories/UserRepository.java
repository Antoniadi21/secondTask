package com.example.secondlab.Repositories;

import com.example.secondlab.Mappers.UserMapper;
import com.example.secondlab.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public class UserRepository {
    private final JdbcTemplate jdbcTemplate;


    public UserRepository(@Autowired JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public Optional<User> getByLogin(String login) {
        return jdbcTemplate.query("SELECT user_id, login, password, email " +
                "FROM \"users\" WHERE login = ?",new UserMapper(), login)
                .stream().findAny();
    }

    public Optional<User> getByEmail(String email) {
        return jdbcTemplate.query("SELECT user_id, login, password, email " +
                        "FROM \"users\" WHERE email = ?",new UserMapper(), email)
                .stream().findAny();
    }

    public void insertUserIntoTable(User user) {
        jdbcTemplate.update("INSERT INTO \"users\" (login, password, email) " +
                "VALUES(?, ?, ?)", user.getLogin(), user.getPassword(), user.getEmail());
    }
}
