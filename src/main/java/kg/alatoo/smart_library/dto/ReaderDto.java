package kg.alatoo.smart_library.dto;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class ReaderDto {

    private Long id;

    private String fullName;

    private String passportNumber;

    private String email;

    private String phoneNumber;
}
