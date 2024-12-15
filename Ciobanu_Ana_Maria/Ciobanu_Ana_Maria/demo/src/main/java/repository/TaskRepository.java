package repository;
import org.springframework.data.jpa.repository.JpaRepository;

import structures.Task;

public interface TaskRepository extends JpaRepository<Task, Integer> {
}