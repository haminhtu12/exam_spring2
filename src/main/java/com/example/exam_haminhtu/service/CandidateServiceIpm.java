package com.example.exam_haminhtu.service;

import com.example.exam_haminhtu.entity.CandidateEntity;
import com.example.exam_haminhtu.repo.CandidateRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CandidateServiceIpm implements CandidateService{
    @Autowired
    CandidateRepo candidateRepo;

    @Override
    public CandidateEntity save(CandidateEntity s) {
        return candidateRepo.save(s);
    }

    @Override
    public Optional<CandidateEntity> findById(Integer id) {
        return candidateRepo.findById(id);
    }

    @Override
    public Iterable<CandidateEntity> findAll() {
        return candidateRepo.findAll();
    }

    @Override
    public void deleteById(Integer id) {
        candidateRepo.deleteById(id);
    }

    @Override
    public void deleteAll() {
        candidateRepo.deleteAll();
    }

}
