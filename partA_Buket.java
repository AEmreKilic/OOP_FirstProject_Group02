import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class partA_Buket {
    static Scanner scanner;

    public partA_Buket() {
    }

    public static void main(String[] var0) {
        clearScreen();
        printWelcome();

        while(true) {
            char var1 = showMainMenu();
            switch (var1) {
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
        String input = scanner.next();
        if (input.isEmpty()) return ' '; 
        return input.toUpperCase().charAt(0);
    }

    static void primarySchoolMenu() {
        while(true) {
            clearScreen();
            System.out.println("PRIMARY SCHOOL SUBMENU");
            System.out.println("[1] Age and Zodiac Sign Detection");
            System.out.println("[2] Reverse the Words");
            System.out.println("[3] Return to Main Menu");
            System.out.print("Enter your choice: ");
            
            try {
                int var0 = scanner.nextInt();
                scanner.nextLine();
                switch (var0) {
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
            } catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).\n");
                scanner.nextLine();
            }
        }
    }

    static void ageAndZodiac() {
        while(true) {
            int dayOB = 0, monthOB = 0, yearOB = 0;
            int dayToday = 0, monthToday = 0, yearToday = 0;
            boolean validDates = false;

            while(!validDates) {
                try {
                   
                    System.out.print("Enter your date of birth (day month year): ");
                    String dobInput = scanner.nextLine().trim();
                    String[] dobParts = dobInput.split("\\s+");
                    
                    if (dobParts.length != 3) {
                        System.out.println("Invalid format. Please enter day, month, and year separated by spaces.\n");
                        System.out.println("\n[Press Enter to re-enter dates]");
                        scanner.nextLine();
                        clearScreen();
                        continue;
                    }
                    
                    dayOB = Integer.parseInt(dobParts[0]);
                    monthOB = Integer.parseInt(dobParts[1]);
                    yearOB = Integer.parseInt(dobParts[2]);

                    if (!isValidDate(dayOB, monthOB, yearOB)) {
                        System.out.println("Invalid date of birth. (1900-2025 range.)\n");
                        System.out.println("\n[Press Enter to re-enter dates]");
                        scanner.nextLine();
                        clearScreen();
                        continue;
                    }

                
                    System.out.print("Enter today's date (day month year): ");
                    String todayInput = scanner.nextLine().trim();
                    String[] todayParts = todayInput.split("\\s+");
                    
                    if (todayParts.length != 3) {
                        System.out.println("Invalid format. Please enter day, month, and year separated by spaces.\n");
                        System.out.println("\n[Press Enter to re-enter dates]");
                        scanner.nextLine();
                        clearScreen();
                        continue;
                    }

                    dayToday = Integer.parseInt(todayParts[0]);
                    monthToday = Integer.parseInt(todayParts[1]);
                    yearToday = Integer.parseInt(todayParts[2]);
                    

                    if (!isValidDate(dayToday, monthToday, yearToday)) {
                        System.out.println("Invalid today's date. Please check your input.\n");
                    } else if (yearOB > yearToday || (yearOB == yearToday && monthOB > monthToday) || (yearOB == yearToday && monthOB == monthToday && dayOB > dayToday)) {
                        System.out.println("Date of birth cannot be later than today's date.\n");
                    } else {
                        validDates = true;
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input! Day, month, and year must be numbers.\n");
                } catch (Exception e) {
                    System.out.println("An unexpected error occurred during date input. Please try again.\n");
                }
                
                if (!validDates) {
                     System.out.println("\n[Press Enter to re-enter dates]");
                     scanner.nextLine();
                     clearScreen();
                }
            }


            int dayDiff = dayToday - dayOB;
            int monthDiff = monthToday - monthOB;
            int yearDiff = yearToday - yearOB;
            int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
            
            if (dayDiff < 0) {
                monthDiff--;
                int prevMonthIndex = (monthToday - 2 + 12) % 12;
                int yearForDays = (monthToday == 1) ? yearToday - 1 : yearToday;
                int daysOfPrevMonth = daysInMonth[prevMonthIndex];
                if (prevMonthIndex == 1 && (yearForDays % 4 == 0 && yearForDays % 100 != 0 || yearForDays % 400 == 0)) {
                    daysOfPrevMonth = 29;
                }
                dayDiff += daysOfPrevMonth;
            }

            if (monthDiff < 0) {
                yearDiff--;
                monthDiff += 12;
            }
            
            if (yearDiff < 0 || (yearDiff == 0 && monthDiff < 0) || (yearDiff == 0 && monthDiff == 0 && dayDiff < 0)) {
                 System.out.println("\nError: Today's date is before the date of birth. Calculation stopped.");
                 yearDiff = 0; monthDiff = 0; dayDiff = 0;
            }


            System.out.println("\nYour age: " + yearDiff + " years, " + monthDiff + " months, " + dayDiff + " days");
            String var10 = getZodiacSign(dayOB, monthOB);
            System.out.println("Your zodiac sign: " + var10);
            
            System.out.println("\n[1] Calculate again");
            System.out.println("[2] Return to submenu");
            System.out.print("Enter your choice: ");
            
            try {
                int var11 = scanner.nextInt();
                scanner.nextLine();
                if (var11 != 1) {
                    return;
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid choice. Returning to submenu.");
                scanner.nextLine();
                return;
            }

            clearScreen();
        }
    }

    static boolean isValidDate(int day, int month, int year) {
        if (year < 1900 || year > 2025) {
            return false;
        }

        if (month < 1 || month > 12) {
            return false;
        }

        int[] daysInMonth = new int[]{31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
            daysInMonth[1] = 29;
        }

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    static String getZodiacSign(int var0, int var1) {
        switch (var1) {
            case 1:
                return var0 < 20 ? "Capricorn" : "Aquarius";
            case 2:
                return var0 < 19 ? "Aquarius" : "Pisces";
            case 3:
                return var0 < 21 ? "Pisces" : "Aries";
            case 4:
                return var0 < 20 ? "Aries" : "Taurus";
            case 5:
                return var0 < 21 ? "Taurus" : "Gemini";
            case 6:
                return var0 < 21 ? "Gemini" : "Cancer";
            case 7:
                return var0 < 23 ? "Cancer" : "Leo";
            case 8:
                return var0 < 23 ? "Leo" : "Virgo";
            case 9:
                return var0 < 23 ? "Virgo" : "Libra";
            case 10:
                return var0 < 23 ? "Libra" : "Scorpio";
            case 11:
                return var0 < 22 ? "Scorpio" : "Sagittarius";
            case 12:
                return var0 < 22 ? "Sagittarius" : "Capricorn";
            default:
                return "Unknown";
        }
    }

    static void reverseWordsMenu() {
        while(true) {
            System.out.print("Enter a text (cannot be empty): ");
            String var0 = scanner.nextLine().trim();
            
            if (var0.isEmpty()) {
                System.out.println("Invalid input! Please enter at least one character.\n");
            } else {
                String var1 = reverseSentence(var0);
                System.out.println("\nOutput: " + var1);
                
                System.out.println("\n[1] Enter another text");
                System.out.println("[2] Return to submenu");
                System.out.print("Enter your choice: ");
                String var2 = scanner.nextLine().trim();
                if (!var2.equals("1")) {
                    return;
                }

                clearScreen();
            }
        }
    }
    
    static String reverseSentence(String sentence) {
        
        
        Pattern pattern = Pattern.compile("([a-zA-Z0-9]+)|(\\s+|[^a-zA-Z0-9\\s]+)");
        Matcher matcher = pattern.matcher(sentence);
        StringBuilder result = new StringBuilder();

        while (matcher.find()) {
            String token = matcher.group();
            
            if (token.matches("[a-zA-Z0-9]+")) {
                result.append(reverseWordRecursive(token));
            } else {
                
                result.append(token);
            }
        }

        return result.toString();
    }


    
    static String reverseWordRecursive(String word) {
        
        
        
        Pattern letterPattern = Pattern.compile("[a-zA-Z]");
        Matcher matcher = letterPattern.matcher(word);
        
        
        StringBuilder lettersOnly = new StringBuilder();
        while (matcher.find()) {
            lettersOnly.append(matcher.group());
        }
        lettersOnly.reverse();

        
        StringBuilder result = new StringBuilder(word);
        int reversedLetterIndex = 0;
        
        for (int i = 0; i < word.length(); i++) {
            char currentChar = word.charAt(i);
            
            if (Character.isLetter(currentChar)) {
                if (reversedLetterIndex < lettersOnly.length()) {
                    result.setCharAt(i, lettersOnly.charAt(reversedLetterIndex));
                    reversedLetterIndex++;
                }
            }
            
        }

        return result.toString();
    }


    static void clearScreen() {
        
        System.out.print("\u001b[H\u001b[2J");
        System.out.flush();
    }

    static void printWelcome() {
        System.out.println("WELCOME TO SCHOOL SYSTEM");
        System.out.println("Team Members: Emre, Kerem, Eylül, Buket");
    }

    static {
        
        scanner = new Scanner(System.in);
    }
}
