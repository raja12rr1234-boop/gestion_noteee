package com.gestion_de_note.gestion_de_note.module;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ModuleService {

    private final ModuleRponsitory moduleRponsitory;

    public ModuleService(ModuleRponsitory moduleRponsitory) {

        this.moduleRponsitory = moduleRponsitory;
    }

    public List<Module> getAllModule() {
        return moduleRponsitory.findAll();
    }

    public Module PostModule(Module module) {

        return moduleRponsitory.save(module);
    }

    public Module updateModule(Module updatemodule) {

        return moduleRponsitory.save(updatemodule);
    }

    public void deltemoduebyid(Integer id_module) {

        moduleRponsitory.deleteById(id_module);
    }
}
