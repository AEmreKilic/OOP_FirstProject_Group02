import java.util.*;
import java.util.stream.Collectors;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Group02 
{

    // Colors
    private static final String RESET = "\u001B[0m";
    private static final String BOLD  = "\u001B[1m";
    private static final String RED   = "\u001B[38;5;196m";
    private static final String GREEN = "\u001B[38;5;46m";
    private static final String BLUE  = "\u001B[38;5;45m";
    private static final String YELLOW= "\u001B[38;5;226m";
    private static final String MAGENTA = "\u001B[38;5;201m";
    private static final String CYAN  = "\u001B[36m";
    private static final String BROWN = "\u001B[38;5;94m";

    private static final Scanner SC = new Scanner(System.in);
    private static final Scanner scanner = new Scanner(System.in);
    private static final Scanner in = new Scanner(System.in);
    private static final Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        clearScreen();
        showWelcomeArt();
        mainMenuLoop();
        System.out.println("\n" + GREEN + "Program terminated. Goodbye!" + RESET);
    }

    private static void showWelcomeArt() 
    {
        clearScreen();
        
        String monkey1 =
            """
     -*%@%@@%@%%%*+
  .%@#.............:+@%-.
-@=..:+%%###:*##%%@#-..-#%=
@#@@=              .=@#...+@#
                      -*%-..-@+
                        .*%-.:%*
                          -#*:.+%:
                            -%=.:%=
                             .*+..**
                              .#+..+#.
                               :%*..=%:
                                .*+..-%:
                                 .*+..-%:
                                  .*+..+#
                                   .#=..#*
                                    .%-.:%=
                                     -%-.-%-
                                      :%=.-%=
                                       :%-.:%=
                                        -%=..#+
                                         :%-..*#:
                                          :#*..=%=     :+=*##%@@######%@#*=.
                                            +%-..+%#%#*-::................:-*#%*=.       =**+:
                                             .#%:=-.............................:+%**%@#+:...==%%-
                                               :#*.......................................=%-.....##.
                                               .+*....................................#-.%=.%-.....@-
                                               .%-...........-:.......................*-@:........=%
                                                +*............-#*........................::.....*++%.
                                                =#:..............=%+....................:.....+#..@:
                                                .+#...............:%=..........:#.......@:...#+..#*
                                                  -%=.............--.%-.........:#......*+:.:+@##:
                                                   .+#*-...........:.+%*+:......=#.......*++#*=:
                                                      -#*%#:..*+.....+*:#=#%*:..*-......-@.
                                                       :*#+--+#=.....+*+.....-##%-.....:@:
                                                         .*=..-#.....:%:#:..#*..*=:....@=.
                                                         .=#...*%....:%..*+-.    =##:.:*%:
                                                          .#+...=#...:%.-%:..   ..#%....:%+.
                                                           .%+...%=..+*-@:...   ..:%#:...=@+.
                                                            :@-..=*..#*:...        ..+%-...-%+.
                                                            .=#..@@-.-%=....        ...-*%-..:%*
                                                           -.-%:.@%*%*..-#@%#=-..       ..:-@-*@.
                                                         -@+-=%.:@....-*%%%%%#=%+...    ...:%.*@.
                                                           ...%-.*%..                    ..#%+%#.
                                                              :%*:::=====+%:..
            """;
        
        String monkey2 =
            """
  %%#+=====*#%%=
@#+******+-:.:=*%#
          @%%#*-.-*%#
               #%*:.*%
                  %+:.*#
                   *#-.=##
                     #+.-*#
                      #*::*#
                       #*:.=#
                        ##-.-%=
                         *%=.:#*
                          +%=.:*#
                            #*.:*#
                             **::+#
                              #*-.=%#
                               ##=.:*%
                                 #*..=##                                     #%#####%*
                                  *%-.:*%                                 *#=:.......-%=
                                    ##:.-##     *####+-:. ...:---------=*##-..#--.....=%
                                      %+..:*#*-..............................*=.......:*%
                                       @%=:::.......................................=*%+
                                          *#-.................................*:...++.-%
                                          *#.......+=.........................+=..**-+%
                                         +*#-.......-+*=::..............+=.......+##%#%%
                                         %=:*:.........-##**###+:.......:+-... .:*#
                                        +#:.:*-...........##     +#%%+-...-+:. ..-#
                                        +#:...=*-........-+*#       %=...=*%%+...:+**
                                         %=.....:#*=::-+:..=%       +#=...:+*+%=:-.:+##
                                        *##:....-% *#%%-...+%         %=-:.:+# +*=:...+%*
                                      %*=::-..:-**    #-...+#          %#=:..:*% ##=...:*#
                                    ##:.......=##     #*..:*#            *#*=..+#  ##-...=#
                                 *#%-......-##*       =%-.-#*                %#:*=   %#*:..*#
                                %==.-**#%%*            %-.+%                 =%:*+      #%+:.*#==
                                #=.-#                 +#:.##               @#*+%*          #%#-.:+##
                                #*:.+**######         +%*--+*######                            #@@%*
                                 %%@@******#%           @%%*+====+%#
            """;
        
        String monkey3 =
            """
   *%%#****+*#%%%+
:##-:.:+*##*+-..:-=##=
#*+##**+++++*#**%#=..-*#-
                  +#%+..=#+
                     .*@=.-#+
                        =#+:-*=
                          +*=.+#-
                           :**::**
                             =#*:=#+
                               +#=-**
                                -*+-#*
                                  **:+#
                                   **:-#*
                                    +#-:*#
                                     -#+:+*=
                                      :*+:=#+
                                        *+:-#+
                                         *+::#*
                                          +#-.=@@@#########%@@%#*-             +#@@#+.
                                          .#@#:...................:+#%#*+*  +##::::...=##-
                                          +*:............................-++-..-*-=....:+*-
                                        +##=...................................++......:=*=
                                      .+*=*-......+=...........................-=....:*=*+
                                     :#+.:=:.......+-...........................::...%-:+*
                                    -#=...+-.......:*+*:.................:+-....-+:..%.:**.
                                   .*=....-=........*-.:+#+:..............+=....:==##-=++
                               -+#*=-*.....+=......:*-     .+#%+-........-*:. ..=**+:
                            =**+........:=*+**:...=+#-         ..:=*##%@%#=....:+--*-
                          +**-.......-=#*::=++:...+*=                  .+*:...:+=-+****
                       :#*+-..:-=++*#*: =*=.....=*=.                   :*+-:.:#*=+:...=+*+
                      *%-:*##*#*=:     +*-....+*=.                     :+=:..:#**=......:=#*.
                    =%+.-#-         +%#=..:+*+=.                        -+-...++:==*#+-....:*%+.
                 -#*--*#=:         -#-++#*--                             :*=..-#:    ==+*#####--+#%=
                 -#%#-             :#=:#-                                 .#+.:**            .-%@@@*
                                   .+*:#+.                                 .+*.=#=
                                    -%-:***###                               =#::+****##*
                                      @@@                                     +@%##*###%%*
            """;
            
        String monkey4 =
            """
        =**%%%%%@@**=:
     *@*............:-+@%+.
  :%*:.=#%++-.:***#%%%*-..-*%*
 %+.-#%:               .*%#-..+@*
%+*%-                     :=%%:.:##
-:                           .+%=.:%#.
                               .+%:..##:
                                 .*%...%*
                                   -#+..-%-
                                     =@:.:%+
                                      :#*..+#:
                                        =%:.+%:
                                         .%-.-#:
                                          .#+.-%=
                                           .**.-%:
                                            .=*.=%.
                                              *#.-%:
                                               **.-#:
                                               :%=.=%:
                                                .#+.+#
                                                 .#*-+%%%%#=+-
                                                  +#:........:-%@*.
                                                .#*................=%#+:
                                               :#=.....................-%%-
                                              :%=.........-%:.............:##:
                                              =%:........-@:.................-%*.
                                              *%.........=#.....................##:     :=+=++:.
                                              +*.........=@*.......................=%#.=@+.....:=@-
                                              +*.........=#.**.......................=-..*%%:....#+
                                              -#:........*=.+-=@:.....................:.@:........@:
                                              .:===:...+-#-..%..-*#-..................:#.........-@=
                                             -%+......=:**.+-@. ....*%=:...............#:......#=-#.
                                          .+@-........*%:..:@:      ...:%#:...=%@%-............*=..%.
                                      :@#==.......-##=..:+#=..       ....:%%*:.........%.......#+::@.
                                     .*=-:....=%%+:..:*%=..         ...-%*............:%*@##==#@...
                                    .**-%****-:.+@#+:..             .*@=:..........-@-.@.
                                   .*#:%:  .%:.=*.              ....#-:=........-%*:..+-
                                   =@.#+    .=#::#=:            ...+=...=%*#@@##.....:%.
                                  .#*@*.       -#*:=%+          ..:@:...%=    :#..:.%=.
                                  .%-@.          .*:-%.          .#*...+*.    :%:....-%.
                                  .%=@.           ..:=.    ..... .%-..+%-      =%......@:
                                   -#:                    -#=.  .*+..**:        :%=....:%-
                                                          -@-@+%%%:.#*.           =%=...:@-
                                                           .#@###%@+.               .=@=..%=
                                                                                       .%-..-===#%.
            """;
            
        String monkey5 =
            """
     *##*******##%#=
  =#*=---======-::-+*#+
=%#++#%*=.    -*#%*=::+#*
%%*-               +##-:=#*
                     -**-:+*+
                       +#*:=*+
                         +#=:+*=
                          .#*:-#=
                            +#::#=
                             =%:.#*
                              -%-.-@
                               :%-.-%
                                :%=.-@:
                                 :#:.-%-
                                  =#:.-%:
                                   +*..-#=
                                    +*-.=#=
                                     *#=.-**
                                      =*+.-*#
                                       =*+..+#+ .*##***+++++**#%**
                                        -**-.-**+-..............:-=+*%*-
                                          =*+*-.......................-++#+        #%%#:
                                            +*:..........................:+**###*+++=:==+**
                                            -#:.............................:-::.=*=+-...:++
                                            :#=.........-+-....................=**........-**
                                             =#:..........=*+:...................-........:+%
                                              =#-............+*:.................-:....-###-
                                               .**...........-++:.................#:..+=.=%
                                               .*=**:...:-:...:#=:.........=+:....:#.:%.:=#
                                                 *+.-#=-*=....-*:-#-........+=.....%*%=*#=
                                                  :%*+.-*.....#-.+*.:##-....--.....%-
                                                   :#:.:+-...*+:#-......-*#*-+-....+-
                                                   :++.:+=..=*:-#-...-*#=:  .*=....#-
                                                    -*=:+=.-*-=*:..%-+      .*=:=..-#+.
                                                     =#++-.+=-*:..#-         -=*:....-*=
                                                      =#*:=++*:.:*-            -+#-....=%=
                                                      .+*+::+#****+              :+*=...-*+
                                                     +%*###**+=+++*#               .=*+...=*+
                                                     =%*=--=+#++*##*                 :=**+-:=+*###%=
                                                      =#%*#+-+#%**-                     :+#*+=-..-#*
                                                          =**+***==#=                        +%#%#-
                                                               .:**%*.
            """;
            
        String monkey6 =
            """
    #%#******#%%#=
*#+*+-::-------==**#*-
@+=**@@##+****#%@#*=**#*
                   +%*-*#+
                     :*#:+%=
                       =#=:**
                        -**:=%-
                         -**:-*=
                          -**:-**
                            #*:-**
                            :*+:=*+
                             -**-=*+
                               #*:=*+
                                +#-+#+
                                 +*:=#+
                                  #+.=#-
                                  .**:=#:
                                    +*:=#:
                                     +#.:%+
                                      =@:.*#:         -+**#####**+=
                                       -@:.-%+   -*%%#+:.........:=*%#+-
                                        :**..=%@%+:...................:=#%+:     -*%*#%%%#=
                                          =**--=..........................:=#%@*=::**+...:+*=
                                            =*+:.......-:....................::+-.#:.::....*#:
                                            =*:.......=%=.........................-=.......+#+
                                            =*:.........-=+*=....................*+.....:+##*:
                                            -*+.............-**=...........:-.....+*....=+-**:
                                             =#=..............=+*:.........:#:.....*=..:+-:+#=
                                              =*+:.............:+*-.........#-.....-#:-=*##+-
                                               =#%*+-:......-...-*-**=:.....=+.....:%%+=-
                                                +#=.:=*#*#%%=...+*:**-+*+-:.:#-.....*#
                                                 -*#=:..+*.#-...+==%=...-+=*###.....+%
                                                   :*=.=:#-#*..:#:=*.-*%+.    +*.:..+%.
                                                  .*+:..:#:=@..=#:++.=+...     .-#:=.-%=
                                                  :#=...*#.=@..+*:#+.++.      ..-%:...=#=
                                                  -#=..+*:.=@:+*+:+=:=:.        .:#-...:+#:
                                                  =#=.=*:..:*#=:::::-+*+:...     ..=*:...=#+ 
                                                  +%=:#-.....=**%++#*-=-....       ...=*=..-#*:
                                                 :#+-=#-.....%%*+-+#-...            ...-+*--*###--
                                                  #*=.-#*====+*++=-.....               ..:+*******%#
                                                   *%*+**##%@#%#-                           =+*#*-
            """;
                                                      
        String welcome = 
            """     
                                                      
                                                      
                                                      
                                                      
                                                      
                                   
                                                      
                                                      
                                                      
                                                      
                                                      
                                                      
                                                      
                                                      
                                                      
                                                      
                                                      
                                                      
                                                      
          =%%%%%* -#%%%%%*   -#%%-*#%%%%%%%%%%%  .*#%%%%#*.           .=@@@@@=.        :*@@@@%-     .*#%%%%        -%%%%#*.*#%%%%%%%%%%#              
            @@@@    :@@@%     .@    @@@@     *@     @@@@            +@@@:     +@@   .%@@*     @@@-    .@@@@@.     .%@@@@     @@@%     #@              
            -@@@%    *@@@*    %-    @@@@   =  *     @@@@           @@@@         @  :@@@*      .@@@%   .#.@@@@     @.@@@@     @@@%   #  #              
             =@@@+   #@@@@   =+     @@@@  -%        @@@@          @@@@             @@@@-       @@@@=  .# +@@@*   @: @@@@     @@@%  =%                 
              @@@@- +*.@@@@ :@      @@@@@@@%        @@@@          @@@@             @@@@.       @@@@+  .#  *@@@- ++  @@@@     @@@@@@@%                 
               @@@@-@  :@@@#@       @@@@  :%        @@@@          @@@@             @@@@:       @@@@=  .#   @@@@**   @@@@     @@@%  =%                 
               :@@@@    *@@@=       @@@@   -   +    @@@@       @. :@@@@            -@@@+      .@@@@   .#    @@@@    @@@@     @@@%   +   %             
                =@@:     @@*        @@@@.     %@    @@@@      %@   .@@@%      :@-   .@@@=     @@@+    :#    .@@.    @@@@     @@@@     .@%             
                 %=      .@       #@@@@@@@@@@@@# .%@@@@@@@@@@@@@      -@@@@@@#:        =@@@%@@#:    :%@@@%   =:   #@@@@@@%.#@@@@@@@@@@@@=        
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
                     
            """;
        
        String[] monkeys = {monkey1, monkey2, monkey3, monkey4, monkey5, monkey6};
        int GAP = 12; // WELCOME, maymundan 12 sütun geride (arkan)
        for (int i = 0; i < 10; i++)
        {
            for (int j = 0; j < monkeys.length; j++)
            {
                clearScreen();

                int offsetMonkey  = i * 10 + j;          
                int offsetWelcome = 0;
                
                String frame = renderTogether(welcome, offsetWelcome, monkeys[j], offsetMonkey);
                System.out.println(frame);
                sleep(200);
            }
        }
        
        String members = 
            """
            Project Members:
                Arif Emre Kılıç
                Buket Culfa
                Kerem Üstüner
                Eylül Uzun
            """;
        
        System.out.println(members);
        
    }
    
    private static String renderTogether(String artA, int offA, String artB, int offB)
    {
        if (offA < 0) offA = 0;
        if (offB < 0) offB = 0;

        // Renk kodları burada tanımlı olsun (dışarıdaki sabitleri de kullanabilirsin)
        final String RESET  = "\u001B[0m";
        final String GREEN  = "\u001B[32m";      // welcome rengi
        final String BROWN  = "\u001B[38;5;94m"; // maymun rengi

        String[] A = artA.split("\n", -1);
        String[] B = artB.split("\n", -1);
        int rows = Math.max(A.length, B.length);

        StringBuilder out = new StringBuilder();

        for (int r = 0; r < rows; r++)
        {
            String aLine = (r < A.length) ? A[r] : "";
            String bLine = (r < B.length) ? B[r] : "";

            // her satırın gerçek genişliği
            int width = Math.max(offA + aLine.length(), offB + bLine.length());
            char[] canvas = new char[width];
            java.util.Arrays.fill(canvas, ' ');

            // WELCOME (artA) arkada, yeşil
            for (int i = 0; i < aLine.length(); i++)
            {
                char ch = aLine.charAt(i);
                if (ch != ' ')
                {
                    canvas[offA + i] = ch;
                }
            }

            // MAYMUN (artB) önde, kahverengi
            for (int i = 0; i < bLine.length(); i++)
            {
                char ch = bLine.charAt(i);
                if (ch != ' ')
                {
                    canvas[offB + i] = ch;
                }
            }

            // artık karakterleri string’e dönüştür
            String line = new String(canvas);

            // çizgiyi renklendir:
            // - maymunun olduğu bölge kahverengi
            // - welcome kalanları yeşil
            StringBuilder coloredLine = new StringBuilder();

            for (int i = 0; i < line.length(); i++)
            {
                char c = line.charAt(i);

                // maymunun kapsadığı alan -> BROWN
                if (i >= offB && i < offB + bLine.length() && bLine.charAt(Math.min(i - offB, bLine.length() - 1)) != ' ')
                {
                    coloredLine.append(BROWN).append(c).append(RESET);
                }
                // welcome’un kapsadığı alan -> GREEN
                else if (i >= offA && i < offA + aLine.length() && aLine.charAt(Math.min(i - offA, aLine.length() - 1)) != ' ')
                {
                    coloredLine.append(GREEN).append(c).append(RESET);
                }
                else
                {
                    coloredLine.append(' ');
                }
            }

            out.append(coloredLine);
            if (r < rows - 1) out.append('\n');
        }

        return out.toString();
    }

    
    
    // Main Menu Loop
    private static void mainMenuLoop() 
    {
        while (true) 
        {
            System.out.println(BLUE + BOLD + "=== MAIN MENU ===" + RESET);
            System.out.println("[A] Primary School");
            System.out.println("[B] Secondary School");
            System.out.println("[C] High School");
            System.out.println("[D] University");
            System.out.println("[E] Terminate");

            String choice = readNonEmpty("Your choice: ").trim().toUpperCase(Locale.ROOT);

            switch (choice) {
                case "A":
                    clearScreen();
                    primarySchoolMenu();
                    clearScreen();
                    break;
                case "B":
                    clearScreen();
                    secondarySchoolMenu();
                    clearScreen();
                    break;
                case "C":
                    clearScreen();
                    highSchoolMenu();
                    clearScreen();
                    break;
                case "D":
                    clearScreen();
                    universityMenu();
                    clearScreen();
                    break;
                case "E":
                    clearScreen();
                    return;
                default:
                    System.out.println(RED + "Invalid choice. Please try again." + RESET);
                    pauseEnter("Press ENTER to return to the main menu...");
                    clearScreen();
            }
        }
    }

    
    
    // SUBMENUS
    // Primary School
    private static void primarySchoolMenu() 
    {
        while(true) 
        {
            clearScreen();
            System.out.println(GREEN + BOLD + "=== PRIMARY SCHOOL ===" + RESET);
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
            } 
            catch (InputMismatchException e) {
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).\n");
                scanner.nextLine();
            }
        }
    }
    
    private static void ageAndZodiac() 
    {
        while(true) 
        {
            System.out.println(GREEN + BOLD + "=== PRIMARY SCHOOL === Age and Zodiac Sign Detection" + RESET);
            int dayOB = 0, monthOB = 0, yearOB = 0;
            int dayToday = 0, monthToday = 0, yearToday = 0;
            boolean validDates = false;

            while(!validDates) 
            {
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
    
    private static boolean isValidDate(int day, int month, int year) 
    {
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
    
    private static String getZodiacSign(int var0, int var1) 
    {
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

    private static void reverseWordsMenu() 
    {
        while(true) {
            System.out.println(GREEN + BOLD + "=== PRIMARY SCHOOL === Reverse the Words" + RESET);
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
    
    private static String reverseSentence(String sentence) 
    {
        
        
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
 
    private static String reverseWordRecursive(String word) 
    {
        
        
        
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


    
    
    
    
    
    
    
    
    
    // Secondary School
    private static void secondarySchoolMenu() 
    {
        while (true)
        {
            clearScreen();
            System.out.println(GREEN + BOLD + "=== SECONDARY SCHOOL ===" + RESET);
            System.out.println("[1] Prime Numbers");
            System.out.println("[2] Step-by-step Evaluation");
            System.out.println("[3] Return to Main Menu");
            System.out.print("Your choice: ");
            String c = in.nextLine();

            if (c.equals("1")) primes(in);
            else if (c.equals("2")) evaluate(in);
            else if (c.equals("3")) break;
            else {
                System.out.println("Invalid. Try again.");
                pauseEnter("Press ENTER...");
                clearScreen();
            }
        }
    }

    static void primes(Scanner in) 
    {
        int n;

        while (true) { 
            clearScreen();
            System.out.println(GREEN + BOLD + "=== SECONDARY SCHOOL === Prime Numbers ===" + RESET);
            System.out.print("Enter n (>=12): ");
            if (!in.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer >= 12.");
                in.nextLine(); 
                continue; 
            }

            n = in.nextInt();
            in.nextLine(); 
            if (n < 12) {
                System.out.println("Invalid input. Please enter an integer >= 12.");
                continue; 
            }
            break;
        }

        long t1 = System.nanoTime();
        ArrayList<Integer> e = sieveEratosthenes(n);
        long t2 = System.nanoTime();

        long t3 = System.nanoTime();
        ArrayList<Integer> s = sieveSundaram(n);
        long t4 = System.nanoTime();

        long t5 = System.nanoTime();
        ArrayList<Integer> a = sieveAtkin(n);
        long t6 = System.nanoTime();

        printResult("Sieve of Eratosthenes", e, t2 - t1);
        printResult("Sieve of Sundaram", s, t4 - t3);
        printResult("Sieve of Atkin", a, t6 - t5);
        pauseEnter("Press ENTER...");
    }    
    
    static void printResult(String name, ArrayList<Integer> primes, long time) 
    {
        System.out.println("\n[" + name + "]");
        if (primes.size() == 0) { 
            System.out.println("No primes."); 
            return; 
        }

        System.out.print("First 3: ");
        for (int i = 0; i < 3 && i < primes.size(); i++) 
            System.out.print(primes.get(i) + " ");
        System.out.print("\nLast 2: ");
        if (primes.size() >= 2)
            System.out.println(primes.get(primes.size()-2) + " " + primes.get(primes.size()-1));
        else System.out.println(primes.get(0));
        System.out.printf("Time: %.3f ms\n", time / 1_000_000.0);
    }
    
    static ArrayList<Integer> sieveEratosthenes(int n) 
    {
        boolean[] mark = new boolean[n+1];
        for (int i = 2; i*i <= n; i++) {
            if (!mark[i]) {
                for (int j = i*i; j <= n; j += i)
                    mark[j] = true;
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        for (int i = 2; i <= n; i++)
            if (!mark[i]) primes.add(i);
        return primes;
    }
    
    static ArrayList<Integer> sieveSundaram(int n) 
    {
        int m = (n - 2) / 2;
        boolean[] rem = new boolean[m+1];
        for (int i = 1; i <= m; i++) {
            for (int j = i; (i + j + 2*i*j) <= m; j++) {
                rem[i + j + 2*i*j] = true;
            }
        }
        ArrayList<Integer> primes = new ArrayList<>();
        if (n >= 2) primes.add(2);
        for (int k = 1; k <= m; k++) {
            if (!rem[k]) primes.add(2*k + 1);
        }
        return primes;
    }

    static ArrayList<Integer> sieveAtkin(int n) 
    {
        boolean[] prime = new boolean[n + 1];
        int limit = (int)Math.sqrt(n);
        for (int x = 1; x <= limit; x++) {
            for (int y = 1; y <= limit; y++) {
                int num = 4*x*x + y*y;
                if (num <= n && (num % 12 == 1 || num % 12 == 5))
                    prime[num] = !prime[num];
                num = 3*x*x + y*y;
                if (num <= n && num % 12 == 7)
                    prime[num] = !prime[num];
                num = 3*x*x - y*y;
                if (x > y && num <= n && num % 12 == 11)
                    prime[num] = !prime[num];
            }
        }
        for (int i = 5; i <= limit; i++)
            if (prime[i])
                for (int j = i*i; j <= n; j += i*i)
                    prime[j] = false;
        ArrayList<Integer> list = new ArrayList<>();
        if (n > 2) list.add(2);
        if (n > 3) list.add(3);
        for (int i = 5; i <= n; i++)
            if (prime[i]) list.add(i);
        return list;
    }

    static void evaluate(Scanner in) 
    {
        while (true) {
            clearScreen();
            System.out.println(GREEN + BOLD + "=== SECONDARY SCHOOL === Step-by-step Evaluation ===" + RESET);
            System.out.println("Valid: digits and +, -, x, :, (, )  Example: -3+(5:(1+1))x(-2-4)");
            System.out.print("Enter expression (empty to exit): ");
            String s = in.nextLine();
            if (s.trim().isEmpty()) 
                return;

            s = s.replace('×','x').replace('*','x').replace('/',':').replace(" ", "");

            evalRecursive(s);
            pauseEnter("Press ENTER...");
        }
    }
    
    static void evalRecursive(String cur) 
    {
        String next = reduceOnce(cur);
        if (next.equals(cur)) {
            return;
        }
        System.out.println("= " + next); 
        evalRecursive(next);             
    }

    static String reduceOnce(String s) 
    {
        int close = s.indexOf(')');
        if (close != -1) {
            int open = s.lastIndexOf('(', close);
            if (open != -1) {
                String inside = s.substring(open + 1, close);
                String r = reduceOnceNoParen(inside);
                return s.substring(0, open) + r + s.substring(close + 1);
            }
        }
        return reduceOnceNoParen(s);
    }
    
    static String reduceOnceNoParen(String s) 
    {
        if (isInt(s)) return s;

        int idx = firstOfTwo(s, 'x', ':');        
        if (idx == -1) idx = firstPlusMinus(s);      
        if (idx == -1) return s;

        int L = leftNumStart(s, idx - 1);
        int R = rightNumEnd(s, idx + 1);
        if (L > idx - 1 || R < idx + 1) return s;

        long A = Long.parseLong(s.substring(L, idx));
        long B = Long.parseLong(s.substring(idx + 1, R + 1));
        char op = s.charAt(idx);

        long V;
        if (op == 'x') V = A * B;
        else if (op == ':') V = A / B; 
        else if (op == '+') V = A + B;
        else V = A - B;
        return s.substring(0, L) + V + s.substring(R + 1);
    }
    
    static boolean isInt(String s)
    {
        if (s.length() == 0)
        {
            return false;
        }

        int i = 0;

        // eğer sayı negatifse '-' işaretini atla
        if (s.charAt(0) == '-')
        {
            if (s.length() == 1)
            {
                return false;
            }
            i = 1;
        }

        // kalan tüm karakterler rakam mı kontrol et
        for (; i < s.length(); i++)
        {
            if (!Character.isDigit(s.charAt(i)))
            {   
                return false;
            }
        }
        
        

        return true;
    }
    
    static int firstOfTwo(String s, char a, char b) 
    {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == a || c == b) return i;
        }
        return -1;
    }
    
    static int firstPlusMinus(String s) 
    {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i == 0) continue;               
                char p = s.charAt(i - 1);
                if (p == '(' || p == '+' || p == '-' || p == 'x' || p == ':') continue;
                return i;
            }
        }
        return -1;
    }
    
    static int leftNumStart(String s, int i) 
    {
        int j = i;
        while (j >= 0 && Character.isDigit(s.charAt(j))) j--;
        if (j >= 0 && s.charAt(j) == '-') {
            if (j == 0) j--;
            else {
                char prev = s.charAt(j - 1);
                if (prev == '(' || prev == '+' || prev == '-' || prev == 'x' || prev == ':') j--;
            }
        }
        return j + 1;
    }

    static int rightNumEnd(String s, int i) 
    {
        int j = i;
        if (j < s.length() && s.charAt(j) == '-') {
            if (j == 0) j++;
            else {
                char prev = s.charAt(j - 1);
                if (prev == '(' || prev == '+' || prev == '-' || prev == 'x' || prev == ':') j++;
            }
        }
        while (j < s.length() && Character.isDigit(s.charAt(j))) j++;
        return j - 1;
    }
    
    static void pause(Scanner in) 
    {}
    
    
    
    
    
    
    
    
    
    // High School
    private static void highSchoolMenu() 
    {
        while (true) {
            System.out.println(GREEN + BOLD + "=== HIGH SCHOOL ===" + RESET);
            System.out.println("[A] Statistical Information about an Array");
            System.out.println("[B] Distance between Two Arrays");
            System.out.println("[C] Return to Main Menu");
            System.out.print("Select an option: ");

            String choice = input.next().toUpperCase();
            input.nextLine(); // buffer temizleme

            switch (choice) {
                case "A":
                    clearScreen();
                    statisticalInformationMenu(input);
                    break;
                case "B":
                    clearScreen();
                    distanceBetweenArraysMenu(input);
                    break;
                case "C":
                    clearScreen();
                    System.out.println("Returning to Main Menu...");
                    return;
                default:
                    clearScreen();
                    System.out.println("Invalid selection! Try again.\n");
            }
        }
    }
    
    public static void statisticalInformationMenu(Scanner input) 
    {
        System.out.println(GREEN + BOLD + "=== HIGH SCHOOL === Statistical Information about an Array ===" + RESET);

        int n = getValidArraySize(input);
        double[] arr = new double[n];

        for (int i = 0; i < n; i++) {
            arr[i] = getValidDouble(input, i + 1);
        }

        Arrays.sort(arr);

        double median = calculateMedian(arr);
        double arithmetic = calculateArithmeticMean(arr);
        double geometric = calculateGeometricMean(arr);
        double harmonic = arr.length / harmonicSum(arr, 0);

        System.out.println("\n--- Results ---");
        System.out.printf("Median: %.4f%n", median);
        System.out.printf("Arithmetic Mean: %.4f%n", arithmetic);
        System.out.printf("Geometric Mean: %.4f%n", geometric);
        System.out.printf("Harmonic Mean: %.4f%n", harmonic);

        System.out.println("\nPress Enter to return...");
        input.nextLine();
        clearScreen();
    }

    // B: Distance between Arrays
    public static void distanceBetweenArraysMenu(Scanner input) 
    {
        System.out.println(GREEN + BOLD + "=== HIGH SCHOOL ===  Distance between Two Arrays ===" + RESET);
        

        int n = getValidArraySize(input);

        int[] arr1 = new int[n];
        int[] arr2 = new int[n];

        System.out.println("Enter elements of the FIRST array (0–9):");
        for (int i = 0; i < n; i++) {
            arr1[i] = getValidInteger(input, i + 1);
        }

        System.out.println("Enter elements of the SECOND array (0–9):");
        for (int i = 0; i < n; i++) {
            arr2[i] = getValidInteger(input, i + 1);
        }

        double manhattan = calculateManhattanDistance(arr1, arr2);
        double euclidean = calculateEuclideanDistance(arr1, arr2);
        double cosine = calculateCosineSimilarity(arr1, arr2);

        System.out.println("\n--- Results ---");
        System.out.printf("Manhattan Distance: %.4f%n", manhattan);
        System.out.printf("Euclidean Distance: %.4f%n", euclidean);
        System.out.printf("Cosine Similarity: %.4f%n", cosine);

        System.out.println("\nPress Enter to return...");
        input.nextLine();
        clearScreen();
    }

    // Helper Methods
    public static int getValidArraySize(Scanner input) 
    {
        while (true) {
            try {
                System.out.print("Enter array size: ");
                int n = Integer.parseInt(input.nextLine());
                if (n <= 0) {
                    clearScreen();
                    System.out.println("Array size must be greater than 0.\n");
                    continue;
                }
                return n;
            } catch (NumberFormatException e) {
                clearScreen();
                System.out.println("Invalid value! Please enter a valid integer for size.\n");
            }
        }
    }

    public static double getValidDouble(Scanner input, int index) 
    {
        while (true) {
            System.out.print("Enter element " + index + ": ");
            String userInput = input.nextLine();
            try {
                userInput = userInput.replace(",", ".");
                return Double.parseDouble(userInput);
            } catch (NumberFormatException e) {
                clearScreen();
                System.out.println("Invalid value! Please enter a valid number (use . or , for decimals).\n");
                System.out.println("Re-enter element " + index + ": ");
            }
        }
    }

    public static int getValidInteger(Scanner input, int index) 
    {
        while (true) {
            System.out.print("Element " + index + ": ");
            String userInput = input.nextLine();

            try {
                if (userInput.contains(".") || userInput.contains(",")) {
                    clearScreen();
                    System.out.println("Invalid value! Please enter an integer between 0 and 9.\n");
                    System.out.println("Re-enter element " + index + ": ");
                    continue;
                }

                int value = Integer.parseInt(userInput);
                if (value >= 0 && value <= 9) return value;
                else {
                    clearScreen();
                    System.out.println("Value must be between 0 and 9!\n");
                    System.out.println("Re-enter element " + index + ": ");
                }
            } catch (NumberFormatException e) {
                clearScreen();
                System.out.println("Invalid input! Please enter an integer between 0 and 9.\n");
                System.out.println("Re-enter element " + index + ": ");
            }
        }
    }

    // Mathematical Methods
    public static double calculateMedian(double[] arr) 
    {
        int n = arr.length;
        if (n % 2 == 1)
            return arr[n / 2];
        else
            return (arr[(n / 2) - 1] + arr[n / 2]) / 2.0;
    }

    public static double calculateArithmeticMean(double[] arr) 
    {
        double sum = 0;
        for (double x : arr) sum += x;
        return sum / arr.length;
    }

    public static double calculateGeometricMean(double[] arr) 
    {
        double product = 1;
        for (double x : arr) product *= x;
        return Math.pow(product, 1.0 / arr.length);
    }

    public static double harmonicSum(double[] arr, int i) 
    {
        if (i == arr.length - 1)
            return 1.0 / arr[i];
        return (1.0 / arr[i]) + harmonicSum(arr, i + 1);
    }

    // Distance Methods
    public static double calculateManhattanDistance(int[] a, int[] b) 
    {
        double sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += Math.abs(a[i] - b[i]);
        return sum;
    }

    public static double calculateEuclideanDistance(int[] a, int[] b) 
    {
        double sum = 0;
        for (int i = 0; i < a.length; i++)
            sum += Math.pow(a[i] - b[i], 2);
        return Math.sqrt(sum);
    }

    public static double calculateCosineSimilarity(int[] a, int[] b) 
    {
        double dot = 0, normA = 0, normB = 0;
        for (int i = 0; i < a.length; i++) {
            dot += a[i] * b[i];
            normA += a[i] * a[i];
            normB += b[i] * b[i];
        }
        return dot / (Math.sqrt(normA) * Math.sqrt(normB));
    }
    
    
    
    
    
    
    
    
    
    
    

    // UNIVERSITY 
    private static void universityMenu() 
    {
        while (true) 
        {
            System.out.println(GREEN + BOLD + "=== UNIVERSITY — CONNECT FOUR ===" + RESET);
            //Options
            System.out.println("[1] Start Single-Player vs Computer");
            System.out.println("[2] Start Two-Player (Local)");
            System.out.println("[B] Back to Main Menu");
            
            //User choices
            String c = readNonEmpty("Your choice: ").trim().toUpperCase(Locale.ROOT);
            if (c.equals("B"))//Quit 
            {
                clearScreen(); 
                return; 
            }
            boolean vsComputer;
            if (c.equals("1"))
            {
                vsComputer = true;
            }
            else if (c.equals("2"))
            {
                vsComputer = false;
            }
            else
            {
                System.out.println(RED + "Invalid choice." + RESET);
                pauseEnter("Press ENTER...");
                clearScreen();
                continue;
            }


            //Board size
            clearScreen();
            System.out.println(BOLD + "Select board size (Columns × Rows)" + RESET);
            System.out.println("[A] 5×4   [B] 6×5   [C] 7×6");

            String size = readNonEmpty("Your choice: ").trim().toUpperCase(Locale.ROOT);

            int cols, rows;
            if (size.equals("A"))
            {
                cols = 5;
                rows = 4;
            }
            else if (size.equals("B"))
            {
                cols = 6;
                rows = 5;
            }
            else if (size.equals("C"))
            {
                cols = 7;
                rows = 6;
            }
            else
            {
                System.out.println(RED + "Invalid size." + RESET);
                pauseEnter("Press ENTER...");
                clearScreen();
                continue;
            }

            clearScreen();
            playConnectFour(cols, rows, vsComputer);//Start Game
            clearScreen();
        }
    }

    // ---- Connect Four game core ----
    private static void playConnectFour(int cols, int rows, boolean vsComputer)
    {
        int[][] board = new int[rows][cols];//Values: 0 = empty location, 1 = player 1'movement, 2 = player2 or computer's movement
        int player = 1;
        Random rng = new Random();//for computer, when its choose a movement

        String p1Name = "Player 1";
        String p2Name = vsComputer ? "Computer" : "Player 2";//if-else

        while (true)
        {
            clearScreen();
            System.out.println(
                BOLD + BLUE + "CONNECT FOUR  —  " +
                cols + "×" + rows + (vsComputer ? "  (Single-Player)" : "  (Two-Players)") + RESET
            );
            printBoard(board);
            System.out.println(CYAN + "Enter column (1-" + cols + ") or 'Q' to forfeit." + RESET);

            int col;
            if (vsComputer && (player == 2))//computer movement
            {
                sleep(500);
                col = pickComputerMove(board, cols, rows, rng); //random computer movement
            }
            else//if one of the player quits(forfeit)
            {
                String in = readNonEmpty("[" + (player == 1 ? p1Name : p2Name) + "] column: ").trim();
                if (in.equalsIgnoreCase("Q"))
                {
                    System.out.println(
                        RED + (player == 1 ? p1Name : p2Name) + " forfeits. "
                        + GREEN + (player == 1 ? p2Name : p1Name) + " wins!" + RESET
                    );
                    pauseEnter("Press ENTER to continue...");
                    return;
                }
                //check, is input integer or not?
                try
                {
                    col = Integer.parseInt(in);//change string to integer
                }
                catch (Exception e)
                {
                    System.out.println(RED + "Invalid choise" + RESET);
                    pauseEnter("Press ENTER to try again...");
                    continue;
                }
            }

            if (col < 1 || col > cols)
            {
                System.out.println(RED + "Invalid choise" + RESET);
                pauseEnter("Press ENTER to try again...");
                continue;
            }
            if (!dropDisc(board, col - 1, player))
            {
                System.out.println(RED + "Invalid choise" + RESET);
                pauseEnter("Press ENTER to try again...");
                continue; // full column → reselect
            }

            // check game state
            clearScreen();
            printBoard(board);

            if (isWinner(board, player))
            {
                System.out.println(GREEN + BOLD + (player == 1 ? p1Name : p2Name) + " connects four! 🎉" + RESET);
                if (askReplay())
                {
                    board = new int[rows][cols];
                    player = 1;
                    continue;
                }
                return;
            }

            if (isBoardFull(board))
            {
                System.out.println(MAGENTA + BOLD + "It's a draw! Board is full." + RESET);
                if (askReplay())
                {
                    board = new int[rows][cols];
                    player = 1;
                    continue;
                }
                return;
            }

            // next turn
            player = (player == 1) ? 2 : 1;
        }
    }

    private static void printBoard(int[][] b)
    {
        int rows = b.length;
        int cols = b[0].length;

        // header
        System.out.print(BOLD);
        for (int c = 1; c <= cols; c++)
        {
            System.out.print("  " + c + " ");
        }
        System.out.println(RESET);

        // rows (top to bottom)
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c < cols; c++)
            {
                int cell = b[rows - 1 - r][c]; // print bottom row last
                String chip;
                if (cell == 1)
                {
                    chip = RED + "●" + RESET;
                }
                else if (cell == 2)
                {
                    chip = CYAN + "●" + RESET;
                }
                else
                {
                    chip = "·";
                }
                System.out.print(" [" + chip + "]");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static boolean dropDisc(int[][] b, int col, int player)
    {
        for (int r = 0; r < b.length; r++)
        {
            if (b[r][col] == 0)
            {
                b[r][col] = player;
                return true;
            }
        }
        return false; // column full
    }

    private static boolean isBoardFull(int[][] b)
    {
        for (int c = 0; c < b[0].length; c++)
        {
            if (b[b.length - 1][c] == 0)
            {
                return false;
            }
        }
        return true;
    }

    private static boolean isWinner(int[][] b, int p)
    {
        int rows = b.length;
        int cols = b[0].length;

        // horizontal
        for (int r = 0; r < rows; r++)
        {
            for (int c = 0; c <= cols - 4; c++)
            {
                if (b[r][c] == p && b[r][c + 1] == p && b[r][c + 2] == p && b[r][c + 3] == p)
                {
                    return true;
                }
            }
        }

        // vertical
        for (int c = 0; c < cols; c++)
        {
            for (int r = 0; r <= rows - 4; r++)
            {
                if (b[r][c] == p && b[r + 1][c] == p && b[r + 2][c] == p && b[r + 3][c] == p)
                {
                    return true;
                }
            }
        }

        // diag ↘
        for (int r = 0; r <= rows - 4; r++)
        {
            for (int c = 0; c <= cols - 4; c++)
            {
                if (b[r][c] == p && b[r + 1][c + 1] == p && b[r + 2][c + 2] == p && b[r + 3][c + 3] == p)
                {
                    return true;
                }
            }
        }

        // diag ↗
        for (int r = 3; r < rows; r++)
        {
            for (int c = 0; c <= cols - 4; c++)
            {
                if (b[r][c] == p && b[r - 1][c + 1] == p && b[r - 2][c + 2] == p && b[r - 3][c + 3] == p)
                {
                    return true;
                }
            }
        }

        return false;
    }

    private static int pickComputerMove(int[][] b, int cols, int rows, Random rng)
    {
        //random column
        List<Integer> legal = new ArrayList<>();
        for (int c = 0; c < cols; c++)
        {
            if (b[rows - 1][c] == 0)
            {
                legal.add(c);
            }
        }
        if (legal.isEmpty())
        {
            return 1;
        }
        int col = legal.get(rng.nextInt(legal.size()));
        System.out.println(CYAN + "Computer chooses column " + (col + 1) + "." + RESET);
        sleep(600);
        return col + 1;
    }

    private static boolean askReplay()
    {
        String s = readNonEmpty("Enter 'Y' for play again. Anything else for quit." ).trim().toUpperCase(Locale.ROOT);
        return s.startsWith("Y");
    }
    
    
    

    // ===== Operation runner =====
    private static void runOperation(Runnable op, String sectionName)
    {
        while (true)
        {
            clearScreen();
            System.out.println(BOLD + sectionName + " — Operation" + RESET + "\n");
            op.run();
            System.out.println();
            System.out.println("[R] Repeat this operation");
            System.out.println("[B] Back to " + sectionName + " menu");

            String ans = readNonEmpty("Your choice: ").trim().toUpperCase(Locale.ROOT);

            if (ans.equals("R"))
            {
                continue; // repeat; loop continues
            }
            else if (ans.equals("B"))
            {
                return; // back to submenu
            }
            else
            {
                System.out.println(RED + "Invalid choice." + RESET);
                pauseEnter("Press ENTER to continue...");
            }
        }
    }

    // ===== IO helpers =====
    private static String readNonEmpty(String prompt)
    {
        while (true)
        {
            System.out.print(prompt);
            String s = SC.nextLine();
            if (s != null && !s.trim().isEmpty())
            {
                return s;
            }
            System.out.println(RED + "Input cannot be empty." + RESET);
            pauseEnter("Press Enter for try again");
        }
    }

    private static void pauseEnter(String msg)
    {
        System.out.print(BLUE + msg + RESET);
        SC.nextLine();
    }

    private static void sleep(long ms)
    {
        try
        {
            Thread.sleep(ms);
        }
        catch (InterruptedException ignored)
        {
            Thread.currentThread().interrupt();
        }
    }

    private static void clearScreen()
    {
        System.out.print("\033[H\033[2J"); // move cursor home & clear
        System.out.flush();
    }

}