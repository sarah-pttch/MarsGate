package com.example.marsgate;

import Logs.Log;
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
    public String savePersonalDetails(@ModelAttribute Application application, Model model) throws TelTooLongException {
        Log.info("Starting creation of application");
        Optional<Application> newApplication = service.createApplication(application);
        if (newApplication.isPresent()) {
            model.addAttribute("Id", newApplication.get().getId());
            return "ApplicationCV";
        } else {
            return null;
        }
    }

    @PostMapping("/applicationEssay")
    public String saveCv(@ModelAttribute Application application, Model model) throws UniTooLongException {
        Optional<Application> updatedApplication = service.addCV(application);
        model.addAttribute("Id", updatedApplication.get().getId());
        return "ApplicationEssay";
    }

    @PostMapping("/applicationConfirmation")
    public String saveEssay(@ModelAttribute Application application, Model model) throws EssayTooLongException {
        Optional<Application> summary = service.addEssay(application);
        model.addAttribute("firstname", summary.get().getFirstname());
        model.addAttribute("lastname", summary.get().getLastname());
        model.addAttribute("experience", summary.get().getExperience());
        model.addAttribute("university", summary.get().getUniversity());
        model.addAttribute("telephone", summary.get().getTelephone());
        model.addAttribute("email", summary.get().getEmail());
        model.addAttribute("birthdate", summary.get().getBirthdate());
        model.addAttribute("essay", summary.get().getEssay());
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

