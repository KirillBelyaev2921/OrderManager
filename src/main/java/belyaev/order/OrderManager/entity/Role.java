package belyaev.order.OrderManager.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.Set;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user_role")
public class Role implements GrantedAuthority {
    @Id
    private Long roleId;
    @Column(name = "username")
    private String roleName;

    @Transient
    @ManyToMany(mappedBy = "roles")
    private Set<User> users;

    public Role(Long roleId, String roleName) {
        this.roleId = roleId;
        this.roleName = roleName;
    }

    @Override
    public String getAuthority() {
        return getRoleName();
    }
}
