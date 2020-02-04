package com.romco.oreillypersistence.dao;

import com.romco.oreillypersistence.entity.Officer;
import com.romco.oreillypersistence.entity.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.xmlunit.util.Mapper;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.hamcrest.Matchers.not;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
class JpaOfficerDaoImplTest {
    
    @Autowired
    @Qualifier("jpaOfficerDaoImpl")
    private OfficerDao dao;
    
    @Autowired
    private JdbcTemplate template;
    
    private RowMapper<Integer> idMapper = (rs, num) -> rs.getInt("id");
    
    @Test
    public void testSave() {
        Officer officer = new Officer(Rank.LIEUTENANT, "Nyota", "Uhuru");
        officer = dao.save(officer);
        assertNotNull(officer.getId());
    }
    
    @Test
    public void findOneThatExists() {
        template.query("select id from officer", idMapper)
                .forEach(id -> {
                    Optional<Officer> officer = dao.findById(id);
                    assertTrue(officer.isPresent());
                    assertEquals(id, officer.get().getId());
                });
    }
    
    @Test
    public void findOneThatDoesNotExist() {
        Optional<Officer> officer = dao.findById(999);
        assertFalse(officer.isPresent());
    }
    
    @Test
    public void findAll() {
        List<String> dbNames = dao.findAll().stream()
                                  .map(Officer::getLast)
                                  .collect(Collectors.toList());
        assertThat(dbNames, containsInAnyOrder("Kirk", "Picard", "Sisko", "Janeway", "Archer"));
    }
    
    @Test
    public void count() {
        assertEquals(5, dao.count());
    }
    
    @Test
    public void delete() {
        template.query("select id from officer", idMapper)
                .forEach(id -> {
                    Optional<Officer> officer = dao.findById(id);
                    assertTrue(officer.isPresent());
                    dao.delete(officer.get());
                });
        assertEquals(0, dao.count());
    }
    
    @Test
    public void existsById() {
        template.query("select id from officer", idMapper)
                .forEach(id -> assertTrue(dao.existsById(id)));
    }
    
    @Test
    public void doesNotExist() {
        List<Integer> ids = template.query("select id from officer", idMapper);
        assertThat(ids, not(contains(999)));
        assertFalse(dao.existsById(999));
    }
}