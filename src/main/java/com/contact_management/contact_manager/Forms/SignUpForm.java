package com.contact_management.contact_manager.Forms;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SignUpForm 
{
    @NotBlank(message = "Name can't be blank")
    private String name;
    @NotBlank(message = "Email can't be blank")
    @Email
    private String email;
    @NotBlank(message = "Password can't be blank")
    @Size(min = 8,message = "Must be atleast 8 characters")
    private String password;
    @NotBlank(message = "Phone No can't be blank")
    @Size(min = 10,max =10, message = "Must be 10 characters")
    private String phoneNo;
    @NotBlank(message = "About can't be blank")
    private String about;
    


}
