package com.github.jcactusdev.example_crud_client.contrller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.github.jcactusdev.example_crud_client.entity.Organization;
import com.github.jcactusdev.example_crud_client.services.OrganizationServiceImpl;


@Controller
@RequestMapping("/organization")
public class OrganizationController {

    @Autowired
    OrganizationServiceImpl serviceImpl;

    @GetMapping("/new")
    public String createGet(Model model) {
        model.addAttribute("formAction", "/organization/new");
        model.addAttribute("organization", new Organization());
        return "organization/organizationEdit.html";
    }

    @PostMapping("/new")
    public String createPost(Model model, @ModelAttribute("organization") Organization organization) {
        Organization result = serviceImpl.create(organization);
        if (result == null) {
            return "redirect:/organization/new";
        }
        return "redirect:/organization/id/" + result.getId();
    }

    @GetMapping
    public String read(Model model) {
        List<Organization> result = serviceImpl.read();
        model.addAttribute("organizations", result);
        return "organization/organizationList";
    }

    @GetMapping("/id/{id}")
    public String read(Model model, @PathVariable("id") Long id) {
        Organization result = serviceImpl.read(id);
        if (result == null) {
            return "redirect:/organization";
        }
        model.addAttribute("formAction", "/organization/id/" + result.getId());
        model.addAttribute("organization", result);
        return "organization/organizationEdit.html";
    }

    @PostMapping("/id/{id}")
    public String update(Model model, @PathVariable("id") Long id, @ModelAttribute("organization") Organization organization) {
        organization.setId(id);
        Organization result = serviceImpl.updateObject(organization);
        if (result == null) {
            return "redirect:/organization";
        }
        model.addAttribute("organization", result);
        return "organization/organizationEdit.html";
    }


}
