package com.romco.oreillypersistence.dao;

import com.romco.oreillypersistence.entity.Officer;
import com.romco.oreillypersistence.entity.Rank;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OfficerRepository extends JpaRepository<Officer, Integer> {
    List<Officer> findByLast(String last);
    List<Officer> findAllByRankAndLastLike(Rank rank, String likeLast);
    List<Officer> findByRank(Rank rank);
}
