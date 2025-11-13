package Other;

public class ColorfulConsole {

    public static final String RESET = "\u001B[0m";
    public static final String RED = "\u001B[31m";
    public static final String GREEN = "\u001B[32m";
    public static final String YELLOW = "\u001B[33m";
    public static final String BLUE = "\u001B[34m";
    public static final String PURPLE = "\u001B[35m";
    public static final String CYAN = "\u001B[36m";
    public static final String WHITE = "\u001B[37m";

    public static void main(String[] args) {
        System.out.println(RED + "Этот текст красный!" + RESET);
        System.out.println(GREEN + "Этот текст зеленый!" + RESET);
        System.out.println(YELLOW + "Этот текст желтый!" + RESET);
        System.out.println(BLUE + "Этот текст синий!" + RESET);
        System.out.println(PURPLE + "Этот текст фиолетовый!" + RESET);
        System.out.println(CYAN + "Этот текст голубой!" + RESET);
        System.out.println(WHITE + "Этот текст белый!" + RESET);
    }
}