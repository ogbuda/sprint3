import manager.Manager;
import tasks.Epic;
import tasks.Status;
import tasks.Subtask;
import tasks.Task;

public class Main {
    public static void main(String[] args) {

        Manager manager = new Manager();
        Task justTask = new Task("do homework", "do math", Status.NEW);
        manager.addTask(justTask);
        Task updatedJustTask = new Task("do homework", "do math", Status.DONE);
        manager.updateTask(updatedJustTask);
        Epic docEpic = new Epic("take care about health", "", Status.NEW);
        Epic workEpic = new Epic("find clients", "", Status.NEW);

        System.out.println(manager.getEpics().toString() + '\n');
        manager.addEpic(docEpic);
        System.out.println(manager.getEpics().toString() + '\n');
        manager.addEpic(workEpic);
        System.out.println(manager.getEpics().toString() + '\n');
        Subtask docTask1 = new Subtask("go to doctor", "get a surgeon consultation", Status.NEW, docEpic);
        manager.addSubtask(docTask1);
        System.out.println(manager.getEpics().toString() + '\n');
        System.out.println(manager.getSubtasks().toString() + '\n');
        Subtask docTask2 = new Subtask("go to doctor", "get a dermatologist consultation", Status.NEW, docEpic);
        Subtask workTask1 = new Subtask("find clients", "use profi.ru", Status.NEW, workEpic);
        manager.addTask(docTask2);
        System.out.println(manager.getTasks().toString() + '\n');
        manager.addTask(workTask1);
        System.out.println(manager.getTasks().toString() + '\n');
        Subtask updatedDocTask1 = new Subtask("go to doctor", "get a surgeon consultation", Status.NEW, docEpic);
        manager.updateSubtask(updatedDocTask1);
        System.out.println(manager.getTasks().toString() + '\n');
        manager.removeTaskById(0);
        System.out.println(manager.getTasks().toString() + '\n');
        Subtask updatedDocTask2 = new Subtask("go to doctor", "get a dermatologist consultation", Status.IN_PROGRESS, docEpic);
        manager.updateSubtask(updatedDocTask2);
        Subtask updatedUpdatedDocTask2 = new Subtask("go to doctor", "get a dermatologist consultation", Status.DONE, docEpic);
        System.out.println(manager.getTasks().toString() + '\n');
        manager.removeTaskById(2);
        System.out.println(manager.getSubtasksOfEpic(docEpic).toString() + '\n');
        System.out.println(manager.getTaskById(3).toString() + '\n');
        manager.removeAllTasks();
        System.out.println(manager.getTasks());
    }

}