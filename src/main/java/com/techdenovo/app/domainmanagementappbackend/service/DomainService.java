package com.techdenovo.app.domainmanagementappbackend.service;
import com.techdenovo.app.domainmanagementappbackend.model.Customer;
import com.techdenovo.app.domainmanagementappbackend.model.Domain;
import com.techdenovo.app.domainmanagementappbackend.repository.DomainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class DomainService {
    @Autowired
    DomainRepository domainRepository;

    public Domain saveDomain(Domain domain){
        if(domain!=null){
            domainRepository.save(domain);
        }
        return domain;
    }
    public Domain getDomain(long domainId){
        Domain existingDomain = domainRepository.findById(domainId).orElse(null);
        return existingDomain;
    }
    public Domain updateDomain(Domain domain){
        Domain existingDomain= domainRepository.findById(domain.getDomainId()).orElse(null);
        if(existingDomain!= null){
            existingDomain.setDomainExtension(domain.getDomainExtension());
            existingDomain.setRegistrationPrice(domain.getRegistrationPrice());
            existingDomain.setRenewalPrice(domain.getRenewalPrice());
            existingDomain.setRestorePrice(domain.getRestorePrice());
            domainRepository.save(existingDomain);
        }
        return existingDomain;
    }
    public void deleteDomain(long domainId){
        Domain existingDomain= domainRepository.findById(domainId).orElse(null);
        if (existingDomain!=null){
            domainRepository.deleteById(existingDomain.getDomainId());
        }
    }
    public List<Domain> getDomains(){
        List<Domain> domains = domainRepository.findAll();
        return domains;
    }
    public String checkAvailability(){

        return null;
    }
}

