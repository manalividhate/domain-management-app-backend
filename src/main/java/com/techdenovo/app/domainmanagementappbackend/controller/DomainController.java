package com.techdenovo.app.domainmanagementappbackend.controller;
import com.techdenovo.app.domainmanagementappbackend.model.Customer;
import com.techdenovo.app.domainmanagementappbackend.model.Domain;
import com.techdenovo.app.domainmanagementappbackend.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin()
@RestController
@RequestMapping("/api/domain")
public class DomainController {
    @Autowired
    DomainService domainService;
    @PostMapping("/add")
    public Domain addDomain(@RequestBody Domain domain) {
        if (domain != null)
            domainService.saveDomain(domain);
        return domain;
    }
    @GetMapping("/{id}")
    public Domain showUpdateForm(@PathVariable("id") long domainId, Model model) {
        Domain domain = domainService.getDomain(domainId);
//        model.addAttribute("domain", domain);
        return domain;
    }
    @PostMapping("/update/{id}")
    public Domain updateDomain(@PathVariable("id") long domainId, @RequestBody Domain domain) {
        domain.setDomainId(domainId);
        if (domain != null)
            domainService.updateDomain(domain);
        return domain;
    }

    @GetMapping("/delete/{id}")
    public String deleteDomain(@PathVariable("id") long domainId, Model model) {
        Domain domain=domainService.getDomain(domainId);
        if(domain!=null)
            domainService.deleteDomain(domainId);
        return "delete customer";
    }
    @GetMapping("/list")
    public List<Domain> showDomainsList(Model model) {
        List<Domain> domains =domainService.getDomains();
        return domains;
    }
}
