package com.contact_management.contact_manager.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToOne;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Socials 
{
    @Id
    private int social_id;
    private String facebook;
    private String instagram;

    @OneToOne
    private Contact contact;

    @OneToOne
    private Users user;
}
