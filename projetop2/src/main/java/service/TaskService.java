package service;

import model.Task;
import repository.TaskRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TaskService {

    private final TaskRepository taskRepository;

    public TaskService(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    // Retorna todas as tarefas
    public List<Task> findAll() {
        return taskRepository.findAll();
    }

    // Salva uma nova tarefa
    public Task save(Task task) {
        return taskRepository.save(task);
    }

    // Busca uma tarefa por ID
    public Optional<Task> findById(Long id) {
        return taskRepository.findById(id);
    }

    // Deleta uma tarefa por ID
    public void deleteById(Long id) {
        taskRepository.deleteById(id);
    }

    // Atualiza uma tarefa existente
    public Task updateTask(Long id, Task updatedTask) {
        return taskRepository.findById(id).map(task -> {
            task.setDescription(updatedTask.getDescription());
            task.setCompleted(updatedTask.isCompleted());
            return taskRepository.save(task);
        }).orElse(null);
    }
}