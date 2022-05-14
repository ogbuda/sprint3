package tasks;

import java.util.Objects;

public class Task {
    private String name;
    private String desc;
    private int id;
    private Status status;

    public Task(String name, String desc, Status status) {
        this.name = name;
        this.desc = desc;
        this.status = status;
    }

    @Override
    public String toString(){
        return getClass().getSimpleName() + "{" + "name=" + '\'' + name + '\'' + ", desc=" + '\'' + desc + '\'' + ", id=" + id + ", status=" + status + "}";
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, desc);
    }

    @Override
    public boolean equals(Object obj){
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() == obj.getClass()) {
            Task otherTask = (Task) obj;
            return name.equals(otherTask.name) && desc.equals(otherTask.desc);
        }
        return false;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

}