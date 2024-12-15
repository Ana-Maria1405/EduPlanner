package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import repository.TaskRepository;
import structures.Task;

import java.util.List;

@RestController
public class DataRetrieval {

	@Autowired
    private TaskRepository sarcinaRepository;

    public void UserController(TaskRepository repository) {
        this.sarcinaRepository = repository;
    }

    @GetMapping("/api/sarcini")
    public List<Task> getAllSarcini() {
        return sarcinaRepository.findAll(); // Returnează toate sarcinile din baza de date
    }
}
