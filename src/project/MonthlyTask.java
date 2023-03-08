package project;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class MonthlyTask extends Task{
    public MonthlyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return this.getDateTime().getDayOfMonth() == date.getDayOfMonth();
    }

    @Override
    public LocalDateTime nextDataTime() {
        LocalDateTime next = this.getDateTime();
        LocalDateTime now = LocalDateTime.now();
        while (now.isAfter(next)){
            next = next.plusMonths(1);
        }
        return next;
    }

    @Override
    public String toString() {
        return "MonthlyTask:" + super.toString();
    }
}
