package br.com.projeto_tcc.clinica_pet_vita.model;

import br.com.projeto_tcc.clinica_pet_vita.model.enums.RulesUsuarios;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.List;

@Entity
@Table(name = "usuarios_clinica")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UsuarioModel implements UserDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false, name = "email_usuario")
    @NotNull(message = "O email não pode ser nulo!")
    private String email;

    @Column(name = "senha_usuario")
    @NotNull(message = "A senha não pode ser nula!")
    private String senha;

    @Column(name = "categoria_usuario")
    @NotNull(message = "A categoria do usuário não pode ser nula!")
    private RulesUsuarios role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(this.role.name()));
    }

    @Override
    public String getPassword() {
        return senha;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
