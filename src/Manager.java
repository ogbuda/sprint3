import java.util.ArrayList;
import java.util.HashMap;

public class Manager {
    private int idForNewTasks;
    public HashMap<Integer, Task> tasks = new HashMap<>();
    public HashMap<Integer, Epic> epics = new HashMap<>();
    public HashMap<Integer, Subtask> subtasks = new HashMap<>();

    public HashMap<Integer, Task> getTasks() {
        return tasks;
    }

    public void removeAllTasks() {
        tasks.clear();
    }

    public Task getTaskById(int id) {
        return tasks.get(id);
    }

    public void generateAndSetId(Task task){
        task.setId(idForNewTasks);
        idForNewTasks++;
    }

    public void addTask(Task task) {
        generateAndSetId(task);
        tasks.put(task.getId(), task);
    }

    public void addSubtask(Subtask subtask) {
        if (tasks.containsKey(subtask.getEpicId())) {
            generateAndSetId(subtask);
            Epic epic = (Epic) tasks.get(subtask.getEpicId());
            epic.addSubtask(subtask);
            epic.setStatus(calculateStatus(epic));
            tasks.put(subtask.getId(), subtask);
        }
    }

    public void addEpic(Epic epic) {
        generateAndSetId(epic);
        tasks.put(epic.getId(), epic);
    }

    public void updateTask(Task task) {
        if (tasks.containsKey(task.getId())) {
            tasks.replace(task.getId(), task);
        }
    }

    public void updateSubtask(Subtask subtask) {
        if (tasks.containsKey(subtask.getEpicId())) {
            Epic epic = (Epic) tasks.get(subtask.getEpicId());
            epic.addSubtask(subtask);
            epic.setStatus(calculateStatus(epic));
        }
    }

    public void updateEpic(Epic epic) {
        if (tasks.containsKey(epic.getId())) {
            tasks.replace(epic.getId(), epic);
        }
    }

    public void removeTaskById(int id) {
        tasks.remove(id);
    }

    public void removeEpicById(int epicId) {
        tasks.remove(epicId);
    }

    public void removeSubtaskById(int subtaskId) {
        if (tasks.containsKey(subtaskId)) {
            Subtask subtask = (Subtask) tasks.get(subtaskId);
            Epic epic = (Epic) tasks.get(subtask.getEpicId());
            epic.removeSubtask(subtask);
            epic.setStatus(calculateStatus(epic));
        }
    }

    public ArrayList<Subtask> getSubtasks(Epic epic) {
        return epic.getSubtasks();
    }

    public Status calculateStatus(Epic epic) {
        int newCounter = 0;
        int inProgressCounter = 0;
        int doneCounter = 0;
        for (Subtask subtask : epic.getSubtasks()) {
            if (subtask.getStatus().equals(Status.NEW)) {
                newCounter++;
            } else if (subtask.getStatus().equals(Status.IN_PROGRESS)) {
                inProgressCounter++;
            } else if (subtask.getStatus().equals(Status.DONE)) {
                doneCounter++;
            }
        }
        if (newCounter == epic.getSubtasks().size() || epic.getSubtasks().size() == 0) return Status.NEW;
        else if (doneCounter == epic.getSubtasks().size()) return Status.DONE;
        else if (inProgressCounter > 0 || doneCounter > 0) return Status.IN_PROGRESS;
        return epic.getStatus();
    }
}
