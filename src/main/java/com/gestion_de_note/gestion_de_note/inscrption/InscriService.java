package com.gestion_de_note.gestion_de_note.inscrption;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class InscriService {
      
  
 private final InscriRponsitory inscriRponsitory ;

  public InscriService(InscriRponsitory inscriRponsitory){

     this.inscriRponsitory = inscriRponsitory ;
  }
  // 1. Get all inscriptions
    public List<Inscri> getAllInscriptions() {
        return inscriRponsitory.findAll();
    }



    // 3. Save / Create new inscription
    public Inscri createInscription( Inscri inscription) {
        return inscriRponsitory.save(inscription);
    }

    // 4. Delete inscription
    public void deleteInscription(Integer id_inscrption) {
        inscriRponsitory.deleteById(id_inscrption);
    }
}

