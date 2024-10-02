package kg.alatoo.smart_library.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Table(name = "readers")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ReaderEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String fullName;

    private String passportNumber;

    private String email;

    private String phoneNumber;

    private LocalDateTime registrationDate;

    private LocalDateTime modifiedAt;

    @PrePersist
    private void init(){
        this.registrationDate = LocalDateTime.now();
    }


}