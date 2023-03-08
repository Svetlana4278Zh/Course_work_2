package project;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Objects;


public abstract class Task {
    private String title;
    private String description;
    private Type type;
    private LocalDateTime dateTime;
    public static int idGenerator = 0;
    private int id;

    public Task(String title, String description, Type type, LocalDateTime dateTime) {
        this.title = Validate.validateString(title);
        this.description = Validate.validateString(description);
        this.type = type;
        this.dateTime = dateTime;
        this.id = idGenerator++;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = Validate.validateString(title);
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = Validate.validateString(description);
    }

    public Type getType() {
        return type;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public int getId() {
        return id;
    }

    @Override
    public String toString() {
        return "{id=" + id +
                " (" + type + ")" +
                " - " + title +
                " - " + description +
                ", dateTime=" + dateTime +
                "}";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return id == task.id && Objects.equals(title, task.title) && Objects.equals(description, task.description) && type == task.type && Objects.equals(dateTime, task.dateTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, description, type, dateTime, id);
    }
    public abstract boolean appearsIn(LocalDate date);
    public abstract LocalDateTime nextDataTime();

}
