package controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import lombok.extern.slf4j.Slf4j;
import repository.TaskRepository;
import structures.Task;

@Controller
@Slf4j
public class TaskController {

    @Autowired
    private final TaskRepository sarcinaRepository;

    public TaskController(TaskRepository sarcinaRepository) {
        this.sarcinaRepository = sarcinaRepository;
    }

    @RequestMapping(path = "/adauga-sarcina", method = RequestMethod.POST)
    public String contactFormSubmission(@ModelAttribute final Task sarcina) {

        Task sarcinaSalvata = sarcinaRepository.save(sarcina);
        
        System.out.println("Sarcina salvată: " + sarcinaSalvata);

        return "redirect:/index.html";
    }
}
