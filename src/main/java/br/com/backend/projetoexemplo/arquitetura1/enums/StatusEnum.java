package br.com.backend.projetoexemplo.arquitetura1.enums;

public enum StatusEnum {
    ATIVO(0, "Ativo"),
    INATIVO(1, "Inativo");

    private Integer codigo;
    private String descricao;

    StatusEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public Integer getCodigo() {
        return codigo;
    }

    public String getDescricao() {
        return descricao;
    }

    public static StatusEnum toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (StatusEnum status: StatusEnum.values()) {
            if (cod.equals(status.getCodigo())) {
                return  status;
            }
        }
        throw new IllegalArgumentException("status invalido: " + cod);
    }
}
