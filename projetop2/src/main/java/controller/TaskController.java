package controller;

import model.Task;
import service.TaskService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class TaskController {

    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("tasks", taskService.findAll());
        model.addAttribute("newTask", new Task());
        return "index";
    }

    @PostMapping("/add")
    public String addTask(@ModelAttribute Task newTask) {
        taskService.save(newTask);
        return "redirect:/";
    }

    @PostMapping("/delete/{id}")
    public String deleteTask(@PathVariable Long id) {
        taskService.deleteById(id);
        return "redirect:/";
    }

    @PostMapping("/complete/{id}")
    public String completeTask(@PathVariable Long id) {
        taskService.findById(id).ifPresent(task -> {
            task.setCompleted(!task.isCompleted()); // Alterna o status
            taskService.save(task);
        });
        return "redirect:/";
    }
}
