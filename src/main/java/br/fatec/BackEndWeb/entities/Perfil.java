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

    public Perfil() {}

    public Perfil(String nome, String email, String senha, String tipo) {
        setId(id);
        setNome(nome);
        setSenha(senha);
        setEmail(email);
        setSenha(senha);
        setTipo(tipo.toUpperCase());
    }
}
