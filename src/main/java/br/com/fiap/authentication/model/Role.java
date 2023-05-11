package br.com.fiap.authentication.model;

import br.com.fiap.sistema.model.Sistema;
import jakarta.persistence.*;
import jakarta.persistence.criteria.CriteriaBuilder;

/**
 * É uma permissão de um sistema em específico
 */
@Entity
@Table(name = "TB_ROLE", uniqueConstraints =
        {
                @UniqueConstraint(name = "UK_NM_ROLE",columnNames = "NM_ROLE"),
                @UniqueConstraint(name = "UK_ID_ROLE",columnNames = "ID_ROLE")})
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SQ_ROLE")
    @SequenceGenerator(name = "SQ_ROLE", sequenceName = "SQ_ROLE")
    @Column(name = "ID_ROLE")
    private Long id;
    @Column(name = "NM_ROLE")
    private String nome;
    @Column(name = "DESCRICAO")
    private String descricao;
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.DETACH)
    @JoinColumn(name = "ID_SISTEMA", referencedColumnName = "ID_SISTEMA",
    foreignKey = @ForeignKey(name = "FK_ROLE_SISTEMA",value = ConstraintMode.CONSTRAINT))
    @Column(name = "SISTEMA")
    private Sistema sistema;



    public Role() {
    }

    public Role(Long id, String nome, String descricao, Sistema sistema) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.sistema = sistema;
    }

    public Long getId() {
        return id;
    }

    public Role setId(Long id) {
        this.id = id;
        return this;
    }

    public String getNome() {
        return nome;
    }

    public Role setNome(String nome) {
        this.nome = nome;
        return this;
    }

    public String getDescricao() {
        return descricao;
    }

    public Role setDescricao(String descricao) {
        this.descricao = descricao;
        return this;
    }

    public Sistema getSistema() {
        return sistema;
    }

    public Role setSistema(Sistema sistema) {
        this.sistema = sistema;
        return this;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", descricao='" + descricao + '\'' +
                ", sistema=" + sistema +
                '}';
    }
}
