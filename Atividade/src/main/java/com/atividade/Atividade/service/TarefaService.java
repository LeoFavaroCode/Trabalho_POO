package com.atividade.Atividade.service;

import com.atividade.Atividade.model.Tarefa;
import com.atividade.Atividade.model.Status;
import com.atividade.Atividade.view.TarefaView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TarefaService {

    @Autowired
    private TarefaView tarefaView;

    public Tarefa save(Tarefa tarefa) {
        tarefa.setStatus(Status.A_Fazer);
        return tarefaView.save(tarefa);
    }

    public List<Tarefa> findAll() {
        return tarefaView.findAll();
    }

    public Tarefa moveToNextStatus(Long id) {
        Optional<Tarefa> tarefaOpt = tarefaView.findById(id);
        if (tarefaOpt.isPresent()) {
            Tarefa tarefa = tarefaOpt.get();
            if (tarefa.getStatus() == Status.A_Fazer) {
                tarefa.setStatus(Status.Em_Progresso);
            } else if (tarefa.getStatus() == Status.Em_Progresso) {
                tarefa.setStatus(Status.Concluido);
            }
            return tarefaView.save(tarefa);
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }

    public Tarefa updateTask(Long id, Tarefa tarefaAtualizada) {
        Optional<Tarefa> tarefaOpt = tarefaView.findById(id);
        if (tarefaOpt.isPresent()) {
            Tarefa tarefaExistente = tarefaOpt.get();
            tarefaExistente.setTitle(tarefaAtualizada.getTitle());
            tarefaExistente.setDescription(tarefaAtualizada.getDescription());
            tarefaExistente.setPriority(tarefaAtualizada.getPriority());
            tarefaExistente.setDueDate(tarefaAtualizada.getDueDate());
            return tarefaView.save(tarefaExistente);
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }

    public void deleteTask(Long id) {
        if (tarefaView.existsById(id)) {
            tarefaView.deleteById(id);
        } else {
            throw new RuntimeException("Tarefa não encontrada.");
        }
    }
}
