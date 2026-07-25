package com.gestion_de_note.gestion_de_note.module;

import java.util.List;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/module")
@CrossOrigin
public class Modulecontroller {

    private final ModuleService moduleService;

    public Modulecontroller(ModuleService moduleService) {

        this.moduleService = moduleService;
    }

    @GetMapping
    public List<Module> getAllModule() {
        return moduleService.getAllModule();
    }

    @PostMapping
    public Module PostModule( @RequestBody Module module) {

        return moduleService.PostModule(module);
    }

    @PutMapping("{id_module}")
    public Module updateModule(@PathVariable("id_module") Integer id_module, @RequestBody Module module) {

        return moduleService.updateModule(module);
    }

    @DeleteMapping("{id_module}")
    public void deltemoduebyid(@PathVariable("id_module") Integer id_module) {

        moduleService.deltemoduebyid(id_module);
    }
}
