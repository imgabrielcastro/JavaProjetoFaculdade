package projeto.backend.enums;

import lombok.Getter;

@Getter
public enum PrioridadeEnum {

    BAIXA(0, "Baixa prioridade"),
    MEDIA(1, "Prioridade média"),
    ALTA(2, "Alta prioridade");

    private final int codigo;
    private final String rotulo;

    PrioridadeEnum(int codigo, String rotulo) {
        this.codigo = codigo;
        this.rotulo = rotulo;
    }

    public static PrioridadeEnum fromCodigo(Integer codigo) {
        if (codigo == null) return null;

        for (PrioridadeEnum valor : values()) {
            if (valor.codigo == codigo) {
                return valor;
            }
        }

        throw new IllegalArgumentException("Código de prioridade desconhecido: " + codigo);
    }
}
