package br.com.alura.linguagens.api;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.springframework.http.ResponseEntity.ok;
import static org.springframework.http.ResponseEntity.status;

@CrossOrigin
@RestController
public class LinguagemController{
    @Autowired
    private LinguagemReposity repositorio;

    @GetMapping("/linguagens")
    public List<Linguagem> ObterLinguagens(){
        List<Linguagem> linguagens = repositorio.findAll();
        Collections.sort(linguagens);
        return linguagens;
    }

    @PostMapping("/adicionar-linguagens")
    public ResponseEntity <String> cadastrarLinguagem(@RequestBody Linguagem linguagem){
        Linguagem linguagemSalva = repositorio.save(linguagem);
        return status(HttpStatus.CREATED).body("Registro incluído com sucesso");
        //return linguagemSalva;
    }
    @DeleteMapping("/linguagens/id{id}")
    public ResponseEntity<String> DeletarLinguagem(@PathVariable("id") String id){
        Optional<Linguagem> linguagemDeletada = repositorio.findById(id);
        if(!linguagemDeletada.isPresent())
            return status(HttpStatus.NOT_FOUND).body("Registro não encontrado");
        repositorio.delete(linguagemDeletada.get());
        return status(HttpStatus.OK).body("Registro excluído com sucesso. ");
    }

    @PutMapping("/linguagens/id{id}")
    public ResponseEntity<Linguagem> atualizarLinguagem(@PathVariable String id, @RequestBody Linguagem linguagem){
        Linguagem linguagemAtualizada =  repositorio.findById(id).get();
        BeanUtils.copyProperties(linguagem, linguagemAtualizada, "id");
        repositorio.save(linguagemAtualizada);
        return ResponseEntity.ok(linguagemAtualizada);
    }
}
