package org.example.facebook_project.User.Entity;

import jakarta.persistence.*;
import lombok.*;
import org.example.facebook_project.Image.Entity.Image;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
@Table(name = "users")
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name", nullable = false)
    private String name;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Image image;

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Image getImage() {
        return image;
    }
}


