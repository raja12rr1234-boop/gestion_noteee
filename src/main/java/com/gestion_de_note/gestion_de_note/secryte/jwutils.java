package com.gestion_de_note.gestion_de_note.secryte;

import java.security.Key;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetailsService;

import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;

public class jwutils {

    private Key key() {
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }
     public String generatejwtokon(Authentication authentication){

        UserDetailsService userprincpal = (UserdetailImpl) authentication.getprincpale();
     }
}
