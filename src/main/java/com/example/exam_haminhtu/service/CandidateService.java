package com.example.exam_haminhtu.service;

import com.example.exam_haminhtu.entity.CandidateEntity;

import java.util.Optional;

public interface CandidateService {
    CandidateEntity save(CandidateEntity s);

    Optional<CandidateEntity> findById(Integer id);

    Iterable<CandidateEntity> findAll();

    void deleteById(Integer id);

    void deleteAll();

}
