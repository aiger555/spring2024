package kg.alatoo.smart_library.dto;


import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class BookUpdateDto {

    String name;

    Integer releasedYear;

    String author;

    String genre;

}