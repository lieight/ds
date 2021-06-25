package xyz.ligh.ds.jpa_mysql.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import xyz.ligh.ds.jpa_mysql.model.Tutorial;

import java.util.List;

public interface TutorialRepository extends JpaRepository<Tutorial, Long> {
    List<Tutorial> findByPublished(boolean published);
    List<Tutorial> findByTitleContaining(String title);
}
