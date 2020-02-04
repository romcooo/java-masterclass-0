package com.romco.oreillypersistence.dao;

import com.romco.oreillypersistence.entity.Officer;
import com.romco.oreillypersistence.entity.Rank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.simple.SimpleJdbcCall;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Repository
public class JdbcOfficerDaoImpl implements OfficerDao {
    private JdbcTemplate jdbcTemplate;
    private SimpleJdbcInsert insertOfficer;
    
    private RowMapper<Officer> defaultOfficerMapper =
            (rs, rowNum) -> new Officer(rs.getInt("id"),
                                        Rank.valueOf(rs.getString("rank")),
                                        rs.getString("first_name"),
                                        rs.getString("last_name"));
    
    public JdbcOfficerDaoImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        insertOfficer = new SimpleJdbcInsert(jdbcTemplate)
                .withTableName("officer")
                .usingGeneratedKeyColumns("id");
    }
    
    @Override
    public Officer save(Officer officer) {
        Map<String,Object> parameters = new HashMap<>();
        parameters.put("rank", officer.getRank());
        parameters.put("first_name", officer.getFirst());
        parameters.put("last_name", officer.getLast());
        Integer newId = (Integer) insertOfficer.executeAndReturnKey(parameters);
        officer.setId(newId);
        return officer;
    }
    
    @Override
    public Optional<Officer> findById(Integer id) {
        if (!existsById(id)) return Optional.empty();
        return Optional.ofNullable(jdbcTemplate.queryForObject(
                "SELECT * FROM officer WHERE id=?",
                defaultOfficerMapper,
                id));
    }
    
    @Override
    public List<Officer> findAll() {
        return jdbcTemplate.query("SELECT * FROM officer", defaultOfficerMapper);
    }
    
    @Override
    public long count() {
        Long result = jdbcTemplate.queryForObject("Select count(*) from officer", Long.class);
        return result == null ? 0L : result;
    }
    
    @Override
    public void delete(Officer officer) {
        jdbcTemplate.update("DELETE FROM officer WHERE id=?", officer.getId());
    }
    
    @Override
    public boolean existsById(Integer id) {
        Boolean result = jdbcTemplate.queryForObject(
                "SELECT EXISTS(SELECT 1 FROM officer where id=?)", Boolean.class, id);
        return result == null ? false : result;
    }

}
