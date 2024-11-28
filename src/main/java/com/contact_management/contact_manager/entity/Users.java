package com.contact_management.contact_manager.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users 
{
    @Id
    @Column(name = "user_id",nullable = false)
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int userId;
    @Column(name = "user_name",nullable = false)
    private String name;
    @Column(name = "email",nullable = false)
    private String email;
    @Column(name = "password",nullable = false)
    private String password;
    private String about;
    private String ProfilePic;
    private String phoneNo;


    private boolean enabled=false;
    @Column(name = "email_verified")
    private boolean emailverified=false;
    @Column(name = "phoneNo_verified")
    private boolean phoneNoverified=false;

    @Enumerated(value = EnumType.STRING)
    private Providers providers=Providers.GOOGLE;
    private String providerUserId;

    @OneToMany(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.LAZY,orphanRemoval = true)
    List<Contact>contacts=new ArrayList<>();

    @OneToOne(mappedBy = "user",cascade = CascadeType.ALL,fetch = FetchType.EAGER,orphanRemoval = true)
    private Socials links;

}
