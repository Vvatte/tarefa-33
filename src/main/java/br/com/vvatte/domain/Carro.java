package main.java.br.com.vvatte.domain;

import javax.persistence.*;

@Entity(name = "TB_CARRO")
public class Carro {

    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator="car_seq")
    @SequenceGenerator(name="car_seq", sequenceName="sq_carro", initialValue = 1, allocationSize = 1)
    private Long id;

    @Column(name = "CODIGO", length = 10, nullable = false, unique = true)
    private String codigo;

    @Column(name = "NOME", length = 50, nullable = false)
    private String nome;

    @Column(name = "COR", length = 50, nullable = false)
    private String cor;

    @Column(name = "VALOR", length = 20, nullable = false)
    private Double valor;

    @ManyToOne
    @JoinColumn(name = "id_marca_fk",
            foreignKey = @ForeignKey(name = "fk_marca_carro"),
            referencedColumnName = "id", nullable = false)
    private Marca marca;

    @OneToOne
    @JoinColumn(name = "id_acessorio_fk",
            foreignKey = @ForeignKey(name = "fk_acessorio_carro"),
            referencedColumnName = "id", nullable = false)
    private Acessorio acessorio;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
    }

    public Acessorio getAcessorio() {
        return acessorio;
    }

    public void setAcessorio(Acessorio acessorio) {
        this.acessorio = acessorio;
    }

}
