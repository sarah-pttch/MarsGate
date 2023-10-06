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
    MarsGateService service;

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

    @PostMapping("/applicationEssay")
    public String saveCv(@ModelAttribute Application application, Model model) {
        System.out.println(application.getBirthdate());
        Application updatedApplication = service.addCV(application);
        model.addAttribute("Id", updatedApplication.getId());
        return "ApplicationEssay";
    }

    @PostMapping("/applicationCV")
    public String savePersonalDetails(@ModelAttribute Application application, Model model) throws TelTooLongException{
        Application newApplication = service.createApplication(application);
        model.addAttribute("Id", newApplication.getId());
        return "ApplicationCV";
    }

    @PostMapping("/applicationConfirmation")
    public String saveEssay(@ModelAttribute Application application, Model model) throws EssayTooLongException {
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
    public String findExistingApplications(@RequestParam String email) {
        List<Application> results = service.findApplications(email);
//        return service.findApplications(firstname, lastname);
        return results.toString();
    }

    @GetMapping("/cancel")
    public String cancelApplication(@RequestParam int Id) {
        service.deleteApplication(Id);
        return "redirect:/marsgate";
    }

}

