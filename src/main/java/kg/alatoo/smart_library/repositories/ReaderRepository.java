package kg.alatoo.smart_library.repositories;

import kg.alatoo.smart_library.entities.ReaderEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ReaderRepository extends JpaRepository<ReaderEntity, Long> {
    List<ReaderEntity> findAllByFullNameContainingIgnoreCase(String name);
}
