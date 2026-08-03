package com.gestion_de_note.gestion_de_note.secryte;

import org.springframework.security.core.GrantedAuthority;

import com.fasterxml.jackson.annotation.JsonIgnore;

public class Userdetailimpli implements Userdetails{
    


     private static final long serialVersionUID = 1L


      private  long id ;
      private String ueraname ;
      private String email;

      @JsonIgnore 

       private String password ;

       Private Collection<? extends GrantedAuthority> authorities;
 
 
       public Userdetailimpli( long id , String username, String email , String passsword, Collevtion<? extends GrantedAuthrity> autthorities){


            this.id = id ;
            this.useraname = username ;
            this.email = email ;
            this.passwoerd = password ;
            thisa.uthorties = authorties ;
 }

}
