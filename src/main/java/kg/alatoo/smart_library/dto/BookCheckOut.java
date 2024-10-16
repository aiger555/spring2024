package kg.alatoo.smart_library.dto;

import jakarta.validation.constraints.NotNull;
import lombok.*;
import lombok.experimental.Accessors;
import lombok.experimental.FieldDefaults;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain = true)
@FieldDefaults(level = AccessLevel.PRIVATE)
public class BookCheckOut {

    @NotNull(message = "readerId is required")
    Long readerId;

    @NotNull(message = "bookId is required")
    Long bookId;

    @NotNull(message = "periodDays is required")
    Integer periodDays;

}