package com.example.marsgate.controller;

import Logs.Log;
import com.example.marsgate.entity.Application;
import com.example.marsgate.requestdtos.CvRequestDTO;
import com.example.marsgate.requestdtos.EssayRequestDTO;
import com.example.marsgate.requestdtos.PersonalDetailsRequestDTO;
import com.example.marsgate.service.exceptions.EssayTooLongException;
import com.example.marsgate.service.exceptions.TelTooLongException;
import com.example.marsgate.service.exceptions.UniTooLongException;
import com.example.marsgate.service.ServiceInterface;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Controller
@RequestMapping("/marsgate")
public class MarsGateController {

    @Autowired
    ServiceInterface service;

    @GetMapping
    public String openStartPage() {
        return "Startpage";
    }

    @GetMapping("/applicationPersonalDetails")
    public String openApplicationPD() {
        return "ApplicationPersonalDetails";
    }

    @GetMapping("/checkApplications")
    public String openCheckApplications() {
        return "CheckApplications";
    }

    @PostMapping("/applicationCV")
    public String savePersonalDetails(@Valid PersonalDetailsRequestDTO personalDetailsRequestDTO, Model model) throws TelTooLongException {
        Log.info("Starting creation of application");
        Optional<Application> newApplication = service.createApplication(personalDetailsRequestDTO);
        if (newApplication.isPresent()) {
            model.addAttribute("Id", newApplication.get().getId());
            return "ApplicationCV";
        } else {
            return null;
        }
    }

    @PostMapping("/applicationEssay")
    public String saveCv(@Valid CvRequestDTO cvRequestDTO, Model model) throws UniTooLongException {
        Optional<Application> updatedApplication = service.addCV(cvRequestDTO);
        if(updatedApplication.isPresent()) {
            model.addAttribute("Id", updatedApplication.get().getId());
            return "ApplicationEssay";
        } else {
            return null;
        }
    }

    @PostMapping("/applicationConfirmation")
    public String saveEssay(@Valid EssayRequestDTO essayRequestDTO, Model model) throws EssayTooLongException {
        Optional<Application> summary = service.addEssay(essayRequestDTO);
        if(summary.isPresent()) {
            model.addAttribute("firstname", summary.get().getFirstname());
            model.addAttribute("lastname", summary.get().getLastname());
            model.addAttribute("experience", summary.get().getExperience());
            model.addAttribute("university", summary.get().getUniversity());
            model.addAttribute("telephone", summary.get().getTelephone());
            model.addAttribute("email", summary.get().getEmail());
            model.addAttribute("birthdate", summary.get().getBirthdate());
            model.addAttribute("essay", summary.get().getEssay());
            return "ApplicationConfirmation";
        } else {
            return null;
        }
    }

    @GetMapping("/existingApplications")
    public String findExistingApplications(@RequestParam String email, Model model) {
        String results = service.findApplications(email);
        if(results.equals("[]")) {
            return "NoApplicationsFound";
        }
        model.addAttribute("results", results);
        return "ExistingApplications";
    }

    @GetMapping("/proceedWithApplication")
    public String openApplication(@RequestParam int Id, Model model) {
        model.addAttribute("Id", Id);
        return service.openApplication(Id);
    }

    @GetMapping("/cancel")
    public String cancelApplication(@RequestParam int Id) {
        Log.info("Deleting application");
        service.deleteApplication(Id);
        Log.info("Application successfully deleted");
        return "redirect:/marsgate";
    }

}

