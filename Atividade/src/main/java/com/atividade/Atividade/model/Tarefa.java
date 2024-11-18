package com.atividade.Atividade.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Tarefa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String title;

    private String description;

    private LocalDate creationDate = LocalDate.now();

    @Enumerated(EnumType.STRING)
    private Status status = Status.A_Fazer;

    @Enumerated(EnumType.STRING)
    private Prioridade prioridade = Prioridade.Baixa;
    private LocalDate dueDate;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public String getDescription() { return description; }
    public void setDescription(String description) { this.description = description; }

    public LocalDate getCreationDate() { return creationDate; }

    public Status getStatus() { return status; }
    public void setStatus(Status status) { this.status = status; }

    public Prioridade getPriority() { return prioridade; }
    public void setPriority(Prioridade prioridade) { this.prioridade = prioridade; }

    public LocalDate getDueDate() { return dueDate; }
    public void setDueDate(LocalDate dueDate) { this.dueDate = dueDate; }
}
