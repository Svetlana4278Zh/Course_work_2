package project;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class YearlyTask extends Task{
    public YearlyTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return (this.getDateTime().getMonth() == date.getMonth()) && (this.getDateTime().getDayOfMonth() == date.getDayOfMonth());
    }

    @Override
    public LocalDateTime nextDataTime() {
        LocalDateTime next = this.getDateTime();
        LocalDateTime now = LocalDateTime.now();
        while (now.isAfter(next)){
            next = next.plusYears(1);
        }
        return next;
    }

    @Override
    public String toString() {
        return "YearlyTask: " + super.toString();
    }
}