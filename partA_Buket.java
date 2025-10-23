import java.util.Scanner;

public class partA_Buket {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        clearScreen();
        printWelcome();

        while (true) {
            char mainChoice = showMainMenu();

            switch (mainChoice) {
                case 'A':
                    primarySchoolMenu();
                    break;
                case 'E':
                    System.out.println("Program terminating... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid selection! Please try again.\n");
            }
        }
    }
    static char showMainMenu() {
        System.out.println(" MAIN MENU ");
        System.out.println("[A] Primary School");
        System.out.println("[B] Secondary School ");
        System.out.println("[C] High School ");
        System.out.println("[D] University ");
        System.out.println("[E] Terminate");
        System.out.print("Enter your choice: ");
        return scanner.next().toUpperCase().charAt(0);
    }

    static void primarySchoolMenu() {
        while (true) {
            clearScreen();
            System.out.println("PRIMARY SCHOOL SUBMENU");
            System.out.println("[1] Age and Zodiac Sign Detection");
            System.out.println("[2] Reverse the Words (Recursive)");
            System.out.println("[3] Return to Main Menu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    clearScreen();
                    ageAndZodiac();
                    break;
                case 2:
                    clearScreen();
                    reverseWordsMenu();
                    break;
                case 3:
                    return;
                default:
                    System.out.println("Invalid selection! Please try again.\n");
            }
        }
    }

    static void ageAndZodiac() {
        while (true) {
            int day, month, year;
            int currentDay, currentMonth, currentYear;

            System.out.print("Enter your date of birth (day month year): ");
            day = scanner.nextInt();
            month = scanner.nextInt();
            year = scanner.nextInt();

            System.out.print("Enter today's date (day month year): ");
            currentDay = scanner.nextInt();
            currentMonth = scanner.nextInt();
            currentYear = scanner.nextInt();
            scanner.nextLine();

            int d = currentDay - day;
            int m = currentMonth - month;
            int y = currentYear - year;

            int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
            if (d < 0) {
                m--;
                d += daysInMonth[(month - 2 + 12) % 12];
            }
            if (m < 0) {
                y--;
                m += 12;
            }

            System.out.println("\nYour age: " + y + " years, " + m + " months, " + d + " days");
            String zodiac = getZodiacSign(day, month);
            System.out.println("Your zodiac sign: " + zodiac);

            System.out.println("\n[1] Calculate again");
            System.out.println("[2] Return to submenu");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();

            if (choice == 1) {
                clearScreen();
                continue;
            } else {
                break;
            }
        }
    }

    static boolean isValidDate(int day, int month, int year) {
        if (year < 1900 || year > 3000) return false;
        if (month < 1 || month > 12) return false;
        int[] daysInMonth = {31,28,31,30,31,30,31,31,30,31,30,31};
        if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0)) daysInMonth[1] = 29;
        return day >= 1 && day <= daysInMonth[month-1];
    }

    static String getZodiacSign(int day, int month) {
        switch (month) {
            case 1: return (day < 20) ? "Capricorn" : "Aquarius";
            case 2: return (day < 19) ? "Aquarius" : "Pisces";
            case 3: return (day < 21) ? "Pisces" : "Aries";
            case 4: return (day < 20) ? "Aries" : "Taurus";
            case 5: return (day < 21) ? "Taurus" : "Gemini";
            case 6: return (day < 21) ? "Gemini" : "Cancer";
            case 7: return (day < 23) ? "Cancer" : "Leo";
            case 8: return (day < 23) ? "Leo" : "Virgo";
            case 9: return (day < 23) ? "Virgo" : "Libra";
            case 10: return (day < 23) ? "Libra" : "Scorpio";
            case 11: return (day < 22) ? "Scorpio" : "Sagittarius";
            case 12: return (day < 22) ? "Sagittarius" : "Capricorn";
            default: return "Unknown";
        }
    }

    static void reverseWordsMenu() {
        while (true) {
            System.out.print("Enter a text (cannot be empty): ");
            String text = scanner.nextLine().trim();

            if (text.isEmpty()) {
                System.out.println("Invalid input! Please enter at least one character.\n");
                continue;
            }

            String result = reverseSentence(text);
            System.out.println("\nOutput: " + result);

            System.out.println("\n[1] Enter another text");
            System.out.println("[2] Return to submenu");
            System.out.print("Enter your choice: ");
            String choice = scanner.nextLine().trim();

            if (choice.equals("1")) {
                clearScreen();
                continue;
            } else {
                break;
            }
        }
    }

    static String reverseSentence(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String word : words) {
            sb.append(reverseWordRecursive(word)).append(" ");
        }
        return sb.toString().trim();
    }

    static String reverseWordRecursive(String word) {
        if (word.length() <= 1) return word;
        int start = 0, end = word.length() - 1;
        while (start < word.length() && !Character.isLetter(word.charAt(start))) start++;
        while (end >= 0 && !Character.isLetter(word.charAt(end))) end--;
        String prefix = word.substring(0, start);
        String core = (start <= end) ? word.substring(start, end+1) : "";
        String suffix = word.substring(end+1);
        if (core.length() <= 1) return prefix + core + suffix;
        String reversedCore = reverseWordRecursive(core.substring(1)) + core.charAt(0);
        return prefix + reversedCore + suffix;
    }

    static void clearScreen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static void printWelcome() {
        System.out.println("WELCOME TO SCHOOL SYSTEM");
        System.out.println("Team Members: Emre, Kerem, Eylül, Buket");
    }
}
