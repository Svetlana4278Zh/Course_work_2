import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

public class WeeklyTask extends Task{
    public WeeklyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return this.getDateTime().getDayOfWeek() == date.getDayOfWeek();
    }

    @Override
    public LocalDateTime nextDataTime() {
        LocalDateTime next = this.getDateTime();
        LocalDateTime now = LocalDateTime.now();
        while (now.isAfter(next)){
            next = next.plusWeeks(1);
        }
        return next;
    }

    @Override
    public String toString() {
        return "WeeklyTask: " + super.toString();
    }
}
