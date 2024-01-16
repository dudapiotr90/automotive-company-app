package pl.dudi.clientservice.infrastructure.database.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "complaint")
@NoArgsConstructor
@AllArgsConstructor
public class ComplaintEntity {
}
