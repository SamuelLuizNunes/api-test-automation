package transferencia;

public class Cliente {
    // Atributos da class
    private String nome;
    private String cpf;
    private String rg;

    // Construtores
    public Cliente(String nome, String cpf, String rg) {
        this.nome = nome;
        this.cpf = cpf;
        this.rg = rg;
    }

    // Métodos
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public String getRg() {
        return rg;
    }
}
