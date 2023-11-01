package com.example.marsgate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @PostMapping("/applicationEssay")
    public String saveCv(@ModelAttribute Application application, Model model) throws UniTooLongException {
        Application updatedApplication = service.addCV(application);
        System.out.println(application.getBirthdate());
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

//    @GetMapping("/existingApplications")
//    @ResponseBody
//    public String findExistingApplications(@RequestParam String email) {
//        String results = service.findApplications(email);
//        if(results.equals("[]")) {
//            return "There are no applications for your e-mail address.";
//        }
//        return results;
//    }

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
    public String testing(@RequestParam int Id, Model model) {
        model.addAttribute("Id", Id);
        return service.findApplications(Id);
    }

    @GetMapping("/cancel")
    public String cancelApplication(@RequestParam int Id) {
        service.deleteApplication(Id);
        return "redirect:/marsgate";
    }

}

