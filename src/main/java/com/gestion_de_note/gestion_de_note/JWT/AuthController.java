package com.gestion_de_note.gestion_de_note.JWT;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/auth")
public class AuthController {
    

     private  final Jwt jwt ;

      public AuthController(Jwt jwt){


        this.jwt = jwt ;
      }


      @PostMapping("/test-token")
       public String generateTsetToken(@RequestParam String email){
           
        return  jwt.generatetokens(email);

       }


}
