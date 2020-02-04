package com.romco.oreillypersistence.dao;

import com.romco.oreillypersistence.entity.Officer;
import org.hibernate.jpa.boot.internal.EntityManagerFactoryBuilderImpl;
import org.hibernate.jpa.boot.internal.PersistenceUnitInfoDescriptor;
import org.hibernate.jpa.boot.spi.EntityManagerFactoryBuilder;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceContext;
import java.util.List;
import java.util.Optional;

@SuppressWarnings("JpaQlInspection")
@Repository
public class JpaOfficerDaoImpl implements OfficerDao {
    
    @PersistenceContext
    private EntityManager entityManager;
    
//    public JpaOfficerDaoImpl(@PersistenceContext EntityManager entityManager) {
//    }
    
    @Override
    public Officer save(Officer officer) {
        entityManager.persist(officer);
        return officer;
    }
    
    @Override
    public Optional<Officer> findById(Integer id) {
        return Optional.ofNullable(entityManager.find(Officer.class, id));
    }
    
    @Override
    public List<Officer> findAll() {
        return entityManager.createQuery("select o from Officer o", Officer.class)
                            .getResultList();
    }
    
    @Override
    public long count() {
        return entityManager.createQuery("select count(o.id) from Officer o", Long.class)
                            .getSingleResult();
    }
    
    @Override
    public void delete(Officer officer) {
        entityManager.remove(officer);
    }
    
    @Override
    public boolean existsById(Integer id) {
        Long count = entityManager.createQuery(
                "select count(o.id) from Officer o where o.id=:id", Long.class)
                                  .setParameter("id", id)
                                  .getSingleResult();
        return count > 0;
    }
}
