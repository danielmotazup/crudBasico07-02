package br.com.zup.edu.personmanager.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.time.LocalDate;

@Entity
public class Pessoa {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String cpf;
    private String apelido;
    private LocalDate dataNascimento;

    public Pessoa(String nome, String cpf, String apelido, LocalDate dataNascimento) {
        this.nome = nome;
        this.cpf = cpf;
        this.apelido = apelido;
        this.dataNascimento = dataNascimento;
    }

    /**
     * @deprecated
     */
    @Deprecated
    public Pessoa() {
    }

    public Long getId() {
        return id;
    }

    public boolean comparaData(){
        LocalDate dataAtual = LocalDate.now();

        if (dataAtual.getYear() - dataNascimento.getYear() >= 18){

        }
            return true;

    }
}
