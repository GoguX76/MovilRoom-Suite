import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "users")
@Getter
@Setter             
@NoArgsConstructor   
@AllArgsConstructor  
@Builder
@EntityListeners(AuditingEntityListener.class)  

public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    @Email(message = "El formato de correo es inválido")
    @NotBlank(message = "El correo no puede estar vacío")
    private String email;

    @Column(nullable = false)
    @NotBlank(message = "La contraseña no puede estar vacía")
    private String password;

    @Column(name = "full_name", nullable = false)
    @NotBlank(message = "El nombre no puede estar vacío")
    private String fullName;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Role role;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt;
}
