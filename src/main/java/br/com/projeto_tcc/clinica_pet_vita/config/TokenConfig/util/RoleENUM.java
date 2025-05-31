package br.com.projeto_tcc.clinica_pet_vita.config.TokenConfig.util;

public enum RoleENUM {

    ROLE_ADMIN("admin"),
    ROLE_USER("user"),
    ROLE_FUNCIONARIO("funcionario"),
    ROLE_GERENTE("gerente");

    private final String role;

    RoleENUM(String role) {
        this.role = role;
    }
}
