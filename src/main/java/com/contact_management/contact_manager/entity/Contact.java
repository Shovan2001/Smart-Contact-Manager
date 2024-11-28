package com.contact_management.contact_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Contact 
{
    @Id
    private int contact_id;
    private String name;
    private String email;
    private String phoneNo;
    private String address;
    private String profilePic;
    private boolean favourite=false;

    @OneToOne(mappedBy = "contact")
    private Socials links;

    @ManyToOne
    private Users user;
}
