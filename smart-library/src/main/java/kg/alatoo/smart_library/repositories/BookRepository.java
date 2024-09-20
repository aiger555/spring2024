package kg.alatoo.smart_library.repositories;

import kg.alatoo.smart_library.entities.BookEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<BookEntity, Long> {



}
