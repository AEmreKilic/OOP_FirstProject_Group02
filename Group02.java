import java.util.*;

public class Group02 
{

    // ===== ANSI helpers =====
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

    public static void main(String[] args) {
        clearScreen();
        showWelcomeArt();
        mainMenuLoop();
        System.out.println("\n" + GREEN + "Program terminated. Goodbye!" + RESET);
    }

    // === Welcome Art: a-b-a-b-a-b-a monkey animation ===
    // === Welcome Art: a-b-a-b-a-b-a animation (JDK 8+ safe, no text blocks) ===
    private static void showWelcomeArt() {
        clearScreen();

        String[] aLines = new String[] {
            "                                             _╓╔φ▒D╟╢╢╬╬╬ΦK▒╦╓_",
            "                                         _╓#║╬╬╬╠╠╠╠╠╠╠╠╠╬╬╬╬╬╬▒╔_",
            "                                      _╓▒╬╬╬╬╠╠╠╠╠╠╠╠╠╠╠╠╠╠╠╠╠╠╬╬╬╬▒╦_",
            "                                    ,╗╣╬╬╬╠╠╠╠╠╠╩╩╩ÖÖÖÖÖÖ╩╩╠╠╠╠╠╠╬╬╬╬╣▒,",
            "                            _,,╓╔╔╔▒╣╬╬╬╬╠╠╠╠╠▒▒▒▒▒▒▒▒▒▒▒▒▒▒▒╠╠╠╠╠╠╬╬╬╬╣▒╦╔╔╓╓,_",
            "                         _╔▒╬╣▓▓▓▓╬╬╬╬╬╬╠╠╠╠╠▒▒▒▒▒ÜÜÜÜÜÜÜÜÜ▒▒▒▒╠╠╠╠╠╬╬╬╬╬╬╣▓▓▓╬╬▒╔_",
            "                        ;╠╣▓▓▓╬╬╣╬╬╬╬╬╬╠╠╠╠╠▒▒▒▒▒ÜÜÜÜÜÜÜÜÜÜ▒▒▒▒╠╠╠╠╠╠╬╬╬╬╬╣╬╬╬╬▓▓╬╬╔",
            "                       |╠╣▓▓╠╚Ü╠╬╬╬╬╬╬╬╬╠╠╠╠╠╠▒▒▒▒▒ÜÜÜÜÜÜÜ▒▒▒╠╠╠╠╠╠╠╬╬╬╬╬╬╬╣╬╚╚╚╫▓╬╬H",
            "                       ╠╠╫▓ÜÜ]ñ╣╬╬╬╬╬╬╬╬╢╬╬╠╠╠╠╠╠▒▒▒▒ÜÜ▒▒▒▒╠╠╠╠╠╬╬╬╬╬╠╬╬╬╣╬╣▓▒░]ñ╫▓╬╬_",
            "                      `╢╠╫▌U░░▒╣╬╬╬╬╬╩╚ÜÜ▒▒▒▒▒▒╚╩╠╠╠╠▒▒╠╠╠╠╩╩▒▒▒▒▒▒Ü▒╚╩╢╬╬╬╣▓▒░░░╟▓╠╬¬",
            "                       ╠╠╣▌░░░╠╬╬╬╬Ü]ÜñÜ▒Ä╠╠▒▒▒▒▒▒Ü╚╠╠╠╠╩Ü▒▒▒Ä▒╠╠▒▒▒ÜÜñÜ╙╟╬╣╣╬U░░╫╬╠╠",
            "                       '╢╠╣▒░▐╣╬╬╩░░░░ÜhÜÜ▒╠╠╠▒╠▒▒ÜÜÜÜÜÜÜ▒▒▒Ö╠╠╠╟▒ÜÜÜ]]░░░╚╬╬╣▒░ù▓╬╠\"",
            "                        ²╢╠╣▒╣╬╬╬░░»»░░░░▓▓╬▓█▒▒ÜÜÜÜÜ]]ûÜñÜ▒▒╠▓▓╬▓▓░░░»░░░»╠╬╬╣▒╣╬╠Ü",
            "                         ²╟╠╣╬╬╬Ü»»»»»»»╫██████ÜÜ░░░»»»»░░]ûÜ▓█████▓░»»»»»░[╫╬╣▓╬╬Ü",
            "                          `╢╬╬╬╬H»»»»»»⌐▓██████Ü░░»┐:┌┌:»»░]ñ▓██████░»»»»»»░╬╬╬╣╬`",
            "                           ║╬╬╬╬▒┐»::::»╚██▓██▓░░░»»»::»»»░░░╫██▓██▌::::::»╗╬╬╬╣╬_",
            "                           ╢╬╬╬╬╬▒░::⌐ⁿ:»╨▓█▓▀Ü░µ░ù░░░»░░û░░░░╬▓█▓Ñ:^┌»::,▒╢╬╬╬╬╬",
            "                           ║╬╬╬╬╬╠╠▒░:::┌»¡»»»»░ÜÜ╚▓▌▒Ü╣▓▒]ÜÜ»»»^::»:»:╓▒╠╬╬╬╬╬╣╬",
            "                           |▓╬╬╬╬╬╬╠╠╠╠╦╖░»»»»░░░░░╩ÑÜ░╠Ñ░░hH░»»»»;╔╦▒╠╠╠╬╬╬╬╬╬╣Ü",
            "                            ╠▓╬╬╬╬╬╬╬╬╠╠╠╠▒»░░░░░░░Ü░░]Ü░]░░░░░░░▒╠╠╠╠╬╬╬╬╬╬╬╣╣╬",
            "                            `║▓╣╣╬╬╬╬╬╬╬╬╬╠░░░▐▄▄▄▄▄▄▄▄▄▄▄▄▄▌▄░░░╠╬╬╬╬╬╬╬╬╬╬╣╣▀`",
            "                              ╙▓▓╬╣╬╬╬╬╬╬╬▒░░░░▀████████████▀│░Ü]╚╬╬╬╬╬╬╣╣╣╣▓╩",
            "                               `╚▓▓▓▓╣╬╣╬╬▒▒ÜÜÜ▒░╙▀▓▓▓▓▓▓▀Ö░░ÜÜ▒Ü▒╣╬╬╣╬╣▓▓▓Ñ`",
            "                                  ╙╩▓▓▓▓▓▓╬╠╠▒▒▒▒▒▒░░░µ╔╔▒▒▒▒▒▒╠╠╣▓▓▓▓▓▓▀╙¬",
            "                                      └╙╨╨▀╩╝╬╬╬╠╠▒▒▒▒▒▒▒╠╠╠╬╬╣╩╩▀╨╨╙\"",
            "                                               `╙╩╣╬╬╠╠╬╬╬╩╙`",
            "                                                    `\"\"`",
            ""
        };

        String[] bLines = new String[] {
            "                                               _╓╦╗#@@@╗╦╓__",
            "                                           _╓#╣╣╬╬╬╬╬╬╬╬╬╬╬╬╣╣▄╓_",
            "                                         ╔Φ╣╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╣╣╦_",
            "                                      _▄▓╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬╬▓▄_",
            "                               ,╓╦φφφΦ▓╬╬╬╬╬╬╬╬╬╠╠╠╠╠╠╠╠╠╠╠╠╬╬╬╬╬╬╬╬╬▓N@φφ╦╔,",
            "                            _φ╣▓▓█▓▓▓╬╬╬╬╬╣╬╬╬╬╟╟╠╠╩ÖÖÖÖ╠╠╠╠╟╬╬╬╬╣╬╬╬╣╣▓▓▓█▓▓╣▒_",
            "                           ╒╣╣█▓╬╬╫▓▓╣╬╬╬╩Ü▒╬ÜÜ▒╠╬╠▒▒▒▒▒▒╠╬╠ÜÜ╚╬▒Ü╚╬╣╬╣╣▓╬╠╬▓█▓╣╕",
            "                           ╣╣█Ñ╩▒▒▓▓▓╬╬╩Üh▒╬Ü░▒╠╬Ü╚╢╠▒▒╠╬▒╚╬╠Ü░û╟▒░ñ╩╣╣▓▓▓▒▒╚╬█╬╣_",
            "                          ²╬╣█ÜÜÜ╠▓▓╬╬Üh░╠╬░░▒╟╬ÜhÄ╣▓╬╬╣╬▒Üû╫╬▒░░╟▒░]╚╬╬╣▓ÑÜÜÜ▓╬╣⌐",
            "                           ╬╬▓Ühñ╫╬╩║ÜÜ░║Ñ░░▒╢╬ùû▒╣╣▓╬╣▓▓╬▒Ü░╫╬▒░░╟▒░]╚╠╩╣▌Ühû▓╬╣",
            "                           ╙╬╣▌░╠╬╠╠ÑÜ░░]░░h╩╬Üû▒╟╣╬╠╠╠╠╣▓╬▒Ü]╫╩Ü░░░░░]╚▒╠╣▒░╟▓╬▒",
            "                            ╚╬▓╣▓╬▒Üh░░░░░░░]ññ▒╠╣╬╠╚╚╚╚╠╣╬╠▒Üh░░░░░░░░]Ü╚╢▓╣▓╬╩",
            "                             ╙╬▓╬╠Ü░░░░░░░░░hÜ▒╠╣╬ÜÜ░░»░]╚╣╬╠▒Ü░░░░░░░░░]Ü╠╣▓╬╜",
            "                              ▐▓╬╠▒Ü░░░░░░░░ñ▒╠╬╬╩U░»»»»░]╚╣╬╠▒░░░░░░░░░▒▒╠╣▓▒",
            "                              ║▓▓╬╠╠╬▒▄╬hñÜ▒▒╠╬╬ÑÜ░░░»»░░ûÜ╩╣╬╠▒Ühh░║▄▒╟▒╠╣▓▓▌",
            "                              ║▓▓╣▓▓▓▓╣╣╣╣▓╬╠╬╬Ñ▒╩╩╫▌▒▒▓▌╩╠▒╠╣╬╠╬▓╣╣╣╣▓▓▓▓▓▓▓Ñ",
            "                              '▓▓▓▓▓▓▓▓▓▓▓▓▓▓╬╬Ü╚▒Ü╬▀ÑÖ▀ÑÜ▒╩ñ╢╬▓▓▓▓▓▓▓▓▓▓▓▓▓▓\"",
            "                               ║▓▓▓▓╬╬╬╣▓▓▓▓╬╬▒░hÜÜÜÜÜÜÜÜÜÜÜh╠╬╣▓▓▓▓▓╬╬╣▓▓▓▓Ñ",
            "                                ║▓▓╬╬╬╣╣▓▓█▓╬╬▒╫▓▓▓▓▓▓▓▓▓▓▓▓▌╠╬╣▓█▓▓╣╬╬╬╬▓▓▀",
            "                                 ╣▓╬╬╬╣▓▓██▓╣╬╠U╫██████████▀µ╠╣╣▓██▓▓╣╬╬╬╣▓_",
            "                                ▐▓╬╬╬╣╣▓▓███▓╣╬╠▒▒p╠▀▀▀▀╠Ü╦╠╠╣╣▓███▓▓╣╬╬╬╣▓▒",
            "                               _▓▓╬╬╬╣▓▓█████▓▓╬╬╬╬╠╠╠╠╠╠╠╬╬╣▓▓▓████▓▓╣╬╬╬▓▓_",
            "                               ║▓▓╬╬╣▓▓▓█\"    `╙╨╫╣╬╬╬╬╬╬╣╣╨\"``   '█▓▓▓╬╬╬╣▓▌",
            "                              _▓▓╬╬╣▓▓▓█▓          `\"╙╙\"`          ▓█▓▓▓╬╬╣▓▓⌐",
            "                              ║▓▓╣╣╣▓▓▓█Ñ                          ╚█▓▓▓▓╣╣▓▓▌"
        };

        String a = BOLD + BROWN + joinLines(aLines) + RESET;
        String b = BOLD + BROWN + joinLines(bLines) + RESET;

        // Sequence: a-b-a-b-a-b-a
        String[] seq = { a, b, a, b, a, b, a };
        for (String frame : seq) {
            clearScreen();
            System.out.println(frame);
            sleep(380); // hız
        }
        pauseEnter("Press ENTER to continue...");
        clearScreen();
    }

    // küçük yardımcı: satırları tek stringte birleştirir
    private static String joinLines(String[] lines) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < lines.length; i++) {
            sb.append(lines[i]);
            if (i < lines.length - 1) sb.append('\n');
        }
        return sb.toString();
    }



    // ===== Main Menu Loop =====
    private static void mainMenuLoop() {
        while (true) {
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

    // ===== Submenus =====
    private static void primarySchoolMenu() {
        while (true) {
            System.out.println(GREEN + BOLD + "=== PRIMARY SCHOOL ===" + RESET);
            System.out.println("[1] Example Operation: Age & Zodiac (placeholder)");
            System.out.println("[2] Example Operation: Reverse Words (placeholder)");
            System.out.println("[B] Back to Main Menu");

            String c = readNonEmpty("Your choice: ").trim().toUpperCase(Locale.ROOT);
            switch (c) {
                case "1":
                    clearScreen();
                    runOperation(() -> {
                        System.out.println("Running Age & Zodiac demo (placeholder)...");
                        sleep(700);
                        System.out.println("Demo completed.");
                    }, "PRIMARY SCHOOL");
                    clearScreen();
                    break;
                case "2":
                    clearScreen();
                    runOperation(() -> {
                        System.out.println("Running Reverse Words demo (placeholder)...");
                        sleep(700);
                        System.out.println("Demo completed.");
                    }, "PRIMARY SCHOOL");
                    clearScreen();
                    break;
                case "B":
                    clearScreen();
                    return;
                default:
                    System.out.println(RED + "Invalid choice." + RESET);
                    pauseEnter("Press ENTER to continue...");
                    clearScreen();
            }
        }
    }

    private static void secondarySchoolMenu() {
        while (true) {
            System.out.println(GREEN + BOLD + "=== SECONDARY SCHOOL ===" + RESET);
            System.out.println("[1] Example Operation: Prime Numbers (placeholder)");
            System.out.println("[2] Example Operation: Expression Evaluator (placeholder)");
            System.out.println("[B] Back to Main Menu");

            String c = readNonEmpty("Your choice: ").trim().toUpperCase(Locale.ROOT);
            switch (c) {
                case "1":
                    clearScreen();
                    runOperation(() -> {
                        System.out.println("Running Prime Numbers demo (placeholder)...");
                        sleep(700);
                        System.out.println("Demo completed.");
                    }, "SECONDARY SCHOOL");
                    clearScreen();
                    break;
                case "2":
                    clearScreen();
                    runOperation(() -> {
                        System.out.println("Running Expression Evaluator demo (placeholder)...");
                        sleep(700);
                        System.out.println("Demo completed.");
                    }, "SECONDARY SCHOOL");
                    clearScreen();
                    break;
                case "B":
                    clearScreen();
                    return;
                default:
                    System.out.println(RED + "Invalid choice." + RESET);
                    pauseEnter("Press ENTER to continue...");
                    clearScreen();
            }
        }
    }

    private static void highSchoolMenu() {
        while (true) {
            System.out.println(GREEN + BOLD + "=== HIGH SCHOOL ===" + RESET);
            System.out.println("[1] Example Operation: Array Statistics (placeholder)");
            System.out.println("[2] Example Operation: Distance Between Arrays (placeholder)");
            System.out.println("[B] Back to Main Menu");

            String c = readNonEmpty("Your choice: ").trim().toUpperCase(Locale.ROOT);
            switch (c) {
                case "1":
                    clearScreen();
                    runOperation(() -> {
                        System.out.println("Running Array Statistics demo (placeholder)...");
                        sleep(700);
                        System.out.println("Demo completed.");
                    }, "HIGH SCHOOL");
                    clearScreen();
                    break;
                case "2":
                    clearScreen();
                    runOperation(() -> {
                        System.out.println("Running Distance Between Arrays demo (placeholder)...");
                        sleep(700);
                        System.out.println("Demo completed.");
                    }, "HIGH SCHOOL");
                    clearScreen();
                    break;
                case "B":
                    clearScreen();
                    return;
                default:
                    System.out.println(RED + "Invalid choice." + RESET);
                    pauseEnter("Press ENTER to continue...");
                    clearScreen();
            }
        }
    }

    // ====== UNIVERSITY — CONNECT FOUR (Option D) ======
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
            System.out.println("[A] 5×4   [B] 6×5   [C] 7×6  (standard)");

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
                    continue;
                }
            }

            if (col < 1 || col > cols)
            {
                continue;
            }
            if (!dropDisc(board, col - 1, player))
            {
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
        String s = readNonEmpty("Play again? (Y/N): ").trim().toUpperCase(Locale.ROOT);
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