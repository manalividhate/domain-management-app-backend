package com.techdenovo.app.domainmanagementappbackend.model;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Domain {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long domainId;
    private String domainExtension;
    private long registrationPrice;
    private long renewalPrice;
    private long restorePrice;

}
