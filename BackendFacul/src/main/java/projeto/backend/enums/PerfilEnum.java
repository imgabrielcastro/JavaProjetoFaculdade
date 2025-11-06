package projeto.backend.enums;

import lombok.Getter;

@Getter
public enum PerfilEnum {
    ADMIN(0, "Admin"),
    CLIENTE(1, "Cliente"),
    TECNICO(2, "Tecnico");

    private final Integer codigo;
    private final String descricao;

    PerfilEnum(Integer codigo, String descricao) {
        this.codigo = codigo;
        this.descricao = descricao;
    }

    public static PerfilEnum toEnum(Integer cod) {
        if (cod == null) {
            return null;
        }
        for (PerfilEnum perfil : PerfilEnum.values()) {
            if (cod.equals(perfil.getCodigo())) {
                return perfil;
            }
        }
        throw new IllegalArgumentException("Perfil inválido: " + cod);
    }
}
