import java.math.BigDecimal;
import java.time.LocalDateTime;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "rooms")
@Getter
@Setter             
@NoArgsConstructor   
@AllArgsConstructor  
@Builder
@EntityListeners(AuditingEntityListener.class)  

public class Rooms {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    @NotBlank(message = "La sala debe de tener un nombre")
    private String name;

    @Column(nullable = false)
    @NotBlank(message = "Tiene que ingresar un descripción")
    private String description;

    @Column(nullable = false)
    private int capacity;

    @Column(name = "price_per_hour", nullable = false)
    private BigDecimal pricePerHour;

    @Column(name = "image_url", nullable = true)
    private String imageUrl;

    @Enumerated(EnumType.STRING)
    @Column(name = "room_status", nullable = false)
    private RoomStatus roomStatus;

    @CreatedDate
    @Column(name = "created_at", nullable = false, updatable = false)
    private LocalDateTime createdAt

}
