package project;

public class Validate {
    public static String validateString(String value){
        if (value == null || value.isBlank()) {return "Not filled in";}
        return value;
    }
}
