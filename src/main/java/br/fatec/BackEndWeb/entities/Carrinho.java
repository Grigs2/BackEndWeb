package br.fatec.BackEndWeb.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;

import java.io.Serial;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "carrinho", schema = "public")
@Data
public class Carrinho implements java.io.Serializable {
    @Serial
    private static final long serialVersionUID = 123133L;

    @Id
    @SequenceGenerator(name="SEQ", sequenceName = "public.seq_carrinho", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ")
    public Long id;

    @Column(name = "total", nullable = true)
    public double total;

    @OneToMany(mappedBy = "carrinho", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<ProdutosCarrinho> produtosCarrinhos = new ArrayList<>();

    @ManyToOne
    @JoinColumn(name = "comprador", referencedColumnName = "id", nullable = false)
    private Perfil perfil;

    public Carrinho(Perfil perfil, double total) {
        this.perfil = perfil;
        this.total = total;
    }
    public Carrinho() {}
}
