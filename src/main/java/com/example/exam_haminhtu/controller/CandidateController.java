package com.example.exam_haminhtu.controller;

import com.example.exam_haminhtu.dto.CandidateDto;
import com.example.exam_haminhtu.dto.MapperDto;
import com.example.exam_haminhtu.entity.CandidateEntity;
import com.example.exam_haminhtu.service.CandidateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/candidates")

public class CandidateController {
    @Autowired
    private CandidateService candidateService;

    @Autowired
    MapperDto mapperDto;

    @RequestMapping("/list")
    public String list(ModelMap modelMap){
        modelMap.addAttribute("candidates",candidateService.findAll());
        return "candidates/list";
    }
    @GetMapping("/add")
    private String add(ModelMap modelMap){
        CandidateDto candidateDto = new CandidateDto();
        modelMap.addAttribute("candidateDto",candidateDto);
        return "candidates/addOrEdit";
    }

    @PostMapping("/addOrEdit")
    private String saveOrUpdate(ModelMap modelMap , @Valid CandidateDto candidateDto , BindingResult result){
        CandidateDto a = candidateDto ;
        if (result.hasErrors()){
            modelMap.addAttribute("message","please input all required fields");
            modelMap.addAttribute("candidateDto",candidateDto);
            return "candidates/addOrEdit";

        }
        if (candidateDto.getId() != null && candidateDto.getId() > 0){
            modelMap.addAttribute("message","updated");
        }else {
            modelMap.addAttribute("message","inserted");
        }

        CandidateEntity candidateEntity = mapperDto.convertToEntity(candidateDto);

        candidateService.save(candidateEntity);
        modelMap.addAttribute("candidateDto",candidateDto);
        return "candidates/addOrEdit";

    }
    @GetMapping("/edit/{id}")
    public String edit(@PathVariable(name = "id") Integer id , ModelMap modelMap) {

        Optional<CandidateEntity> optionalCandidate =  candidateService.findById(id);


        CandidateDto candidateDto = mapperDto.convertToDto(optionalCandidate);


        if (optionalCandidate.isPresent()){
            modelMap.addAttribute("candidateDto",optionalCandidate.get());
        }else {
            return list(modelMap);
        }
        System.out.println("edit");

        return "candidates/addOrEdit";

    }
    @ModelAttribute(name = "candidates")
    public List<CandidateEntity> getListCandidates(){
        return (List<CandidateEntity>) candidateService.findAll();
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable(name = "id") Integer id , ModelMap modelMap) {
        candidateService.deleteById(id);
        return list(modelMap);
    }

}
