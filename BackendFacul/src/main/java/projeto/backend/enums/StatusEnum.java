package projeto.backend.enums;

import lombok.Getter;

@Getter
public enum StatusEnum {

    ABERTO(0, "Em aberto"),
    EM_ANDAMENTO(1, "Em andamento"),
    FINALIZADO(2, "Concluído");

    private final int codigo;
    private final String rotulo;

    StatusEnum(int codigo, String rotulo) {
        this.codigo = codigo;
        this.rotulo = rotulo;
    }

    public static StatusEnum fromCodigo(Integer codigo) {
        if (codigo == null) return null;

        for (StatusEnum valor : values()) {
            if (valor.codigo == codigo) {
                return valor;
            }
        }

        throw new IllegalArgumentException("Código de status inválido: " + codigo);
    }
}
