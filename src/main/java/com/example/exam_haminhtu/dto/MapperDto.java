package com.example.exam_haminhtu.dto;

import com.example.exam_haminhtu.entity.CandidateEntity;
import org.mapstruct.Mapper;
import org.mapstruct.NullValueCheckStrategy;

import java.util.Optional;

@Mapper(componentModel = "spring", nullValueCheckStrategy = NullValueCheckStrategy.ALWAYS)
public interface MapperDto {
    CandidateEntity convertToEntity(CandidateDto candidateDto);
    CandidateDto convertToDto(Optional<CandidateEntity> candidateEntity);
}
