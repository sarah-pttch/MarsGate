package com.example.marsgate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/marsgate")
public class MarsGateController {

    @Autowired
    ApplicationRepository ar;

    @Autowired
    MarsGateService service;

    @GetMapping
    public String openStartPage() {
        return "Startpage";
    }

    @GetMapping("/applicationCV")
    public String openApplicationCV() {
        return "ApplicationCV";
    }

    @GetMapping("/checkApplications")
    public String openCheckApplications() {
        return "CheckApplications";
    }

    @PostMapping("/applicationPersonalDetails")
    public String saveCv(@ModelAttribute Application application, Model model) {
        Application newApplication = service.createApplication(application);
        model.addAttribute("Id", newApplication.getId());
        return "ApplicationPersonalDetails";
    }

    @PostMapping("/applicationEssay")
    public String savePersonalDetails(@ModelAttribute Application application, Model model) {
        Application updatedApplication = service.addPersonalDetails(application);
        model.addAttribute("Id", updatedApplication.getId());
        return "ApplicationEssay";
    }

    @PostMapping("/applicationConfirmation")
    public String saveEssay(@ModelAttribute Application application, Model model) {
        Application summary = service.addEssay(application);
        model.addAttribute("firstname", summary.getFirstname());
        model.addAttribute("lastname", summary.getLastname());
        model.addAttribute("experience", summary.getExperience());
        model.addAttribute("university", summary.getUniversity());
        model.addAttribute("telephone", summary.getTelephone());
        model.addAttribute("email", summary.getEmail());
        model.addAttribute("birthdate", summary.getBirthdate());
        model.addAttribute("essay", summary.getEssay());
        return "ApplicationConfirmation";
    }

    @GetMapping("/existingApplications")
    @ResponseBody
    public String findExistingApplications(@RequestParam String firstname, @RequestParam String lastname) {
//        List<Application> results = service.findApplications(firstname, lastname);
        return service.findApplications(firstname, lastname);
    }

    @GetMapping("/cancel")
    public String cancelApplication(@RequestParam int Id) {
        service.deleteApplication(Id);
        return "redirect:/marsgate";
    }

}

