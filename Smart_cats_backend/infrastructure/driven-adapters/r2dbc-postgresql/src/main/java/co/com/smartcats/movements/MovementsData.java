package co.com.smartcats.movements;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

import java.time.LocalDateTime;

@Table("movimientos")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder(toBuilder = true)
public class MovementsData {

    @Id
    private int id;

    private String componente;

    @Column("gato_id")
    private int gatoId;

    @Column("create_at")
    private LocalDateTime createdAt;
}
