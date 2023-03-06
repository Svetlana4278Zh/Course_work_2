import java.time.LocalDate;
import java.time.LocalDateTime;

public class OneTimeTask extends Task{
    public OneTimeTask(String title, String description, Type type, LocalDateTime dateTime) {
        super(title, description, type, dateTime);
    }

    @Override
    public boolean appearsIn(LocalDate date) {
        return this.getDateTime().getYear() == date.getYear() && this.getDateTime().getMonth() == date.getMonth() && this.getDateTime().getDayOfMonth() == date.getDayOfMonth();
    }

    @Override
    public LocalDateTime nextDataTime() {
        LocalDateTime next = this.getDateTime();
        LocalDateTime now = LocalDateTime.now();
        if (now.isAfter(next)){
            System.out.println("The task is not repeated");
            return null;
        } else{
            return next;
        }
    }

    @Override
    public String toString() {
        return "OneTimeTask: " + super.toString();
    }
}
