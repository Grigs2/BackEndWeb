package br.fatec.BackEndWeb.entities;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;

@Entity
@Table(name = "perfil", schema = "public")
@Data
public class Perfil implements java.io.Serializable {

    @Serial
    private static final long serialVersionUID = 12313L;


    @Id
    @SequenceGenerator(name="SEQ", sequenceName="public.seq_perfil", allocationSize=1)
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="SEQ")
    private Long id;

    @Column(name = "nome", nullable = false, length = 100)
    private String nome;

    @Column(name = "email", nullable = false, length = 255)
    public String email;

    @Column(name ="senha", nullable = false, length = 255)
    public String senha;

    @Column(name = "tipo", nullable = false, length = 50)
    public String tipo;

    @Column(name = "telefone", nullable = true, length = 50)
    public String telefone;

    public Perfil() {}

    public Perfil(String nome, String email, String senha, String tipo, String telefone) {
        setNome(nome);
        setSenha(senha);
        setEmail(email);
        setSenha(senha);
        setTipo(tipo.toUpperCase());
        setTelefone(telefone);
    }
    public Perfil(Long id, String nome, String email, String senha, String tipo, String telefone) {
        setId(id);
        setNome(nome);
        setSenha(senha);
        setEmail(email);
        setSenha(senha);
        setTipo(tipo.toUpperCase());
        setTelefone(telefone);
    }
}
