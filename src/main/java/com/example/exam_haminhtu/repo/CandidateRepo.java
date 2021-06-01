package com.example.exam_haminhtu.repo;

import com.example.exam_haminhtu.entity.CandidateEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CandidateRepo extends CrudRepository<CandidateEntity, Integer> {
}
