package projeto.backend.enums;

public enum StatusEnum {
    ABERTO(0, "Aberto"),
    ANDAMENTO(1, "Em andamento"),
    ENCERRADO(2, "Encerrado");

    private final int codigo;
    private final String descricao;

    StatusEnum(int codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public int getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }
}
