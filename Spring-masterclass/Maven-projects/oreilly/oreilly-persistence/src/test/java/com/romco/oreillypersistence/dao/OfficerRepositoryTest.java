package com.romco.oreillypersistence.dao;

import com.romco.oreillypersistence.entity.Officer;
import com.romco.oreillypersistence.entity.Rank;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.*;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@ExtendWith(SpringExtension.class)
class OfficerRepositoryTest {
    
    @Autowired
    private OfficerRepository repository;
    
    @Autowired
    private JdbcTemplate template;
    
    private RowMapper<Integer> idMapper = (rs, num) -> rs.getInt("id");
    
    @Test
    public void testSave() {
        Officer officer = new Officer(Rank.LIEUTENANT, "Nyota", "Uhuru");
        officer = repository.save(officer);
        assertNotNull(officer.getId());
    }
    
    @Test
    public void findOneThatExists() {
        template.query("select id from officer", idMapper)
                .forEach(id -> {
                    Optional<Officer> officer = repository.findById(id);
                    assertTrue(officer.isPresent());
                    assertEquals(id, officer.get().getId());
                });
    }
    
    @Test
    public void findOneThatDoesNotExist() {
        Optional<Officer> officer = repository.findById(999);
        assertFalse(officer.isPresent());
    }
    
    @Test
    public void findAll() {
        List<String> dbNames = repository.findAll().stream()
                                         .map(Officer::getLast)
                                         .collect(Collectors.toList());
        assertThat(dbNames, containsInAnyOrder("Kirk", "Picard", "Sisko", "Janeway", "Archer"));
    }
    
    @Test
    public void count() {
        assertEquals(5, repository.count());
    }
    
    @Test
    public void delete() {
        template.query("select id from officer", idMapper)
                .forEach(id -> {
                    Optional<Officer> officer = repository.findById(id);
                    assertTrue(officer.isPresent());
                    repository.delete(officer.get());
                });
        assertEquals(0, repository.count());
    }
    
    @Test
    public void existsById() {
        template.query("select id from officer", idMapper)
                .forEach(id -> assertTrue(repository.existsById(id)));
    }
    
    @Test
    public void doesNotExist() {
        List<Integer> ids = template.query("select id from officer", idMapper);
        assertThat(ids, not(contains(999)));
        assertFalse(repository.existsById(999));
    }
    
    @Test
    public void findByRank() {
        repository.findByRank(Rank.CAPTAIN).forEach(captain ->
                                                            assertEquals(Rank.CAPTAIN, captain.getRank()));
        
    }
    
    @Test
    public void findByLast() {
        List<Officer> kirks = repository.findByLast("Kirk");
        assertEquals(1, kirks.size());
        assertEquals("Kirk", kirks.get(0).getLast());
    }
}