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
        model.addAttribute("organization", new Organization());
        return "organization/organizationCreate";
    }

    @PostMapping("/new")
    public String createPost(Model model, @ModelAttribute("organization") Organization organization) {
        Organization result = serviceImpl.create(organization);
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
        model.addAttribute("formAction", "/organization/id/" + result.getId());
        model.addAttribute("organization", result);
        return "organization/organizationEdit";
    }

    @PatchMapping("/id/{id}")
    public String update(Model model, @PathVariable("id") Long id, @ModelAttribute("organization") Organization organization) {
        organization.setId(id);
        Organization result = serviceImpl.updateObject(organization);
        model.addAttribute("organization", result);
        return "organization/organizationEdit";
    }

    @DeleteMapping("/id/{id}")
    public String delete(@PathVariable("id") Long id) {
        serviceImpl.deleteById(id);
        return "redirect:/organization";
    }

}
