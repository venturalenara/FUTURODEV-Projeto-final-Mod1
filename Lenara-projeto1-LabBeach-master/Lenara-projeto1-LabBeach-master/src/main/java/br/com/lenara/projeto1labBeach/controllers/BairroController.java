package br.com.lenara.projeto1labBeach.controllers;

import br.com.lenara.projeto1labBeach.models.Bairro;
import br.com.lenara.projeto1labBeach.services.BairroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

// import static org.springframework.data.jpa.domain.AbstractPersistable_.id;

@RestController
@RequestMapping(value = "api/bairros")
public class BairroController {

    @Autowired
    private BairroService bairroService;

    // métodos de listar todas os bairros cadastrados com seus respectivos campos
    @GetMapping // para listar tudo
    public ResponseEntity<List<Bairro>> findAll(){
        // verifica se a comunicação está ok e busca e lista todos os bairros
        return ResponseEntity.status(HttpStatus.OK).body(bairroService.findAll());
    }

    // métodos de buscar bairro por ID
    @GetMapping("/{id}")
    public ResponseEntity<Bairro> findById(@PathVariable Long id){
        return ResponseEntity.status(HttpStatus.OK).body(bairroService.findByID(id));
    }

    // método POST por campo
    @PostMapping(value = "/post1") // cadastrar via Query
    public Long save(@RequestParam("name") String name,
                     @RequestParam("description") String description,
                     @RequestParam("population") Integer population){
        return ResponseEntity.ok().body(bairroService.save(name, description, population)).getBody();
    }

    // método de cadastrar os bairros por objeto inteiro

    @PostMapping(value = "/post2") // cadastrar via JSON
    public ResponseEntity<Bairro> create(@RequestBody Bairro bairro){
        // verifica se o bairro foi criado, e invoca o método save, da classe service, responsável por salvar.
        return ResponseEntity.status(HttpStatus.CREATED).body(bairroService.saveAll(bairro));
    }

    // método deletar por ID
    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
    bairroService.deleteById(id);
    return ResponseEntity.status(HttpStatus.OK).build();
    }


}
