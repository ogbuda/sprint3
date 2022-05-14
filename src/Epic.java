import java.util.ArrayList;
import java.util.Objects;

public class Epic extends Task {

    private ArrayList<Subtask> subtasks = new ArrayList<>();

    public Epic(String name, String desc, Status status) {
        super(name, desc, status);
    }

    public ArrayList<Subtask> getSubtasks() {
        return subtasks;
    }

    public void setSubtasks(ArrayList<Subtask> subtasks) {
        this.subtasks = subtasks;
    }

    public void addSubtask(Subtask subtask) {
        if (subtasks.contains(subtask)) {
            subtasks.remove(subtask);
            subtasks.add(subtask);
            return;
        }
        subtasks.add(subtask);
    }

    public void removeSubtask(Subtask subtask) {
        subtasks.remove(subtask);
    }


    @Override
    public String toString() {
        return this.getClass().getSimpleName() + "{" + "name=" + '\'' + getName() + '\'' + ", desc=" + '\'' + super.getDesc() + '\'' + ", id=" + getId() + ", status=" + getStatus() + ", subtasks=" + subtasks + "}";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() == obj.getClass()) {
            Epic otherEpic = (Epic) obj;
            return super.equals(obj) && subtasks.equals(otherEpic.getSubtasks());
        }
        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName(), getDesc(), getSubtasks());
    }
}
