package com.techdenovo.app.domainmanagementappbackend.controller;
import com.techdenovo.app.domainmanagementappbackend.dto.DomainDto;
import com.techdenovo.app.domainmanagementappbackend.model.Customer;
import com.techdenovo.app.domainmanagementappbackend.model.Domain;
import com.techdenovo.app.domainmanagementappbackend.service.DomainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/domain")
public class DomainController {
    @Value("${api.key}")
    private String apiKey;
    @Autowired
    DomainService domainService;
    @Autowired
    RestTemplate restTemplate;
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

    @PostMapping("/availability")
    public DomainDto checkAvailability( @RequestBody DomainDto domainDto){
        System.out.println(apiKey);
        DomainDto domain= restTemplate.getForObject(
            "https://test.httpapi.com/api/domains/available.json?auth-userid=510633&?api_key="+apiKey +"?domain-name="+domainDto.getDomainName()+"?tlds="+domainDto.getTlds(),DomainDto.class);
        System.out.println(domain);
        return  domain;

    }

//    @PostMapping("/availability")
//    public Domain checkAvailability(@RequestBody Domain domain) {
//        if (domain != null){
//            domainService.checkAvailability();
//        System.out.println("available");
//    }
//        else{
//            System.out.println("not available");
//        }
//        return domain;
//    }
}
