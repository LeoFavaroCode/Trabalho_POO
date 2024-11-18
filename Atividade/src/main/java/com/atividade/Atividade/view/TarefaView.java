package com.atividade.Atividade.view;

import com.atividade.Atividade.model.Tarefa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TarefaView extends JpaRepository<Tarefa, Long> {
}
