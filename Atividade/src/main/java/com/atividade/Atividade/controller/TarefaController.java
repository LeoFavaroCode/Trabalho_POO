package com.atividade.Atividade.controller;

import com.atividade.Atividade.model.Tarefa;
import com.atividade.Atividade.model.Status;
import com.atividade.Atividade.service.TarefaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tasks")
public class TarefaController {

    @Autowired
    private TarefaService tarefaService;

    @PostMapping
    public Tarefa createTask(@RequestBody Tarefa tarefa) {
        return tarefaService.save(tarefa);
    }

    @GetMapping
    public List<Tarefa> getAllTasks() {
        return tarefaService.findAll();
    }

    @PutMapping("/{id}/move")
    public Tarefa moveTaskToNextStatus(@PathVariable Long id) {
        return tarefaService.moveToNextStatus(id);
    }

    @PutMapping("/{id}")
    public Tarefa updateTask(@PathVariable Long id, @RequestBody Tarefa tarefaAtualizada) {
        return tarefaService.updateTask(id, tarefaAtualizada);
    }

    @DeleteMapping("/{id}")
    public void deleteTask(@PathVariable Long id) {
        tarefaService.deleteTask(id);
    }
}
