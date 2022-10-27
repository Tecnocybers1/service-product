package analisissistemas2.serviceproduct.entity;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "TBL_CATEGORIES")
@Data @AllArgsConstructor @NoArgsConstructor @Builder

public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;


}
