package project;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class DailyTask extends Task{
    public DailyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return true;
    }

    @Override
    public LocalDateTime nextDataTime() {
        LocalDateTime next = this.getDateTime();
        LocalDateTime now = LocalDateTime.now();
        while (now.isAfter(next)){
            next = next.plusDays(1);
        }
        return next;
    }

    @Override
    public String toString() {
        return "DailyTask: " + super.toString();
    }
}
