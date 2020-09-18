package ua.pmdev.joinexample.core.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ua.pmdev.joinexample.core.model.Songlist;

@Repository
public interface SongListRepository extends JpaRepository<Songlist, Long> {
}
