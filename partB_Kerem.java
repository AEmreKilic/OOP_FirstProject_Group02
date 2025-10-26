import java.util.*;

public class partB_Kerem {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (true) { // ana menü sürekli dönsün
            System.out.println("\n=== MAIN MENU ===");
            System.out.println("[A] Primary School");
            System.out.println("[B] Secondary School");
            System.out.println("[C] High School");
            System.out.println("[D] University");
            System.out.println("[E] Terminate");
            System.out.print("Your choice: ");
            String c = in.nextLine().toUpperCase();

            if (c.equals("E")) { // E -> çıkış
                System.out.println("Bye!");
                break;
            } 
            else if (c.equals("B")) { // B -> bizim görev
                optionB(in);
            } 
        }
    }

    // ===== OPTION B =====
    static void optionB(Scanner in) {
        while (true) {
            System.out.println("\n=== SECONDARY SCHOOL ===");
            System.out.println("[1] Prime Numbers");
            System.out.println("[2] Step-by-step Evaluation");
            System.out.println("[3] Return to Main Menu");
            System.out.print("Your choice: ");
            String c = in.nextLine();

            if (c.equals("1")) primes(in);
            else if (c.equals("2")) evaluate(in);
            else if (c.equals("3")) break;
            else System.out.println("Invalid. Try again.");
        }
    }

    // ===== PRIME NUMBERS =====
    static void primes(Scanner in) {
        System.out.print("Enter n (>=12): ");
        int n = in.nextInt();
        in.nextLine();

        // Sieve of Eratosthenes
        long t1 = System.nanoTime();
        ArrayList<Integer> e = sieveEratosthenes(n);
        long t2 = System.nanoTime();

        // Sieve of Sundaram
        long t3 = System.nanoTime();
        ArrayList<Integer> s = sieveSundaram(n);
        long t4 = System.nanoTime();

        // Sieve of Atkin
        long t5 = System.nanoTime();
        ArrayList<Integer> a = sieveAtkin(n);
        long t6 = System.nanoTime();

        printResult("Sieve of Eratosthenes", e, t2 - t1);
        printResult("Sieve of Sundaram", s, t4 - t3);
        printResult("Sieve of Atkin", a, t6 - t5);
    }

    static void printResult(String name, ArrayList<Integer> primes, long time) {
        System.out.println("\n[" + name + "]");
        if (primes.size() == 0) { 
            System.out.println("No primes."); 
            return; 
        }
        // First 3 and Last 2
        System.out.print("First 3: ");
        for (int i = 0; i < 3 && i < primes.size(); i++) 
            System.out.print(primes.get(i) + " ");
        System.out.print("\nLast 2: ");
        if (primes.size() >= 2)
            System.out.println(primes.get(primes.size()-2) + " " + primes.get(primes.size()-1));
        else System.out.println(primes.get(0));
        System.out.printf("Time: %.3f ms\n", time / 1_000_000.0);
    }

    // ========== Sieve of Eratosthenes ==========
    static ArrayList<Integer> sieveEratosthenes(int n) {
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

    // ========== Sieve of Sundaram ==========
    static ArrayList<Integer> sieveSundaram(int n) {
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

    // ========== Sieve of Atkin ==========
    static ArrayList<Integer> sieveAtkin(int n) {
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

    // ===== STEP-BY-STEP EVALUATION (simplest) =====
    static void evaluate(Scanner in) {
        System.out.println("Valid: digits and +, -, x, :, (, )  Example: -3+(5:(1+1))x(-2-4)");
        while (true) {
            System.out.print("Enter expression (empty to exit): ");
            String s = in.nextLine();
            if (s.trim().isEmpty()) return;

            // normalize
            s = s.replace('×','x').replace('*','x').replace('/',':').replace(" ", "");

            // print each single-step reduction until stable
            String cur = s;
            while (true) {
                String next = reduceOnce(cur);
                System.out.println("= " + next);
                if (next.equals(cur)) break;
                cur = next;
            }
        }
    }

    // one reduction step: first innermost ( ... ), then x/:, then +/-
    static String reduceOnce(String s) {
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

    // reduce a single op in a no-parenthesis string
    static String reduceOnceNoParen(String s) {
        if (isInt(s)) return s;

        int idx = firstOfTwo(s, 'x', ':');           // priority: x and :
        if (idx == -1) idx = firstPlusMinus(s);      // then + and -
        if (idx == -1) return s;

        int L = leftNumStart(s, idx - 1);
        int R = rightNumEnd(s, idx + 1);
        if (L > idx - 1 || R < idx + 1) return s;

        long A = Long.parseLong(s.substring(L, idx));
        long B = Long.parseLong(s.substring(idx + 1, R + 1));
        char op = s.charAt(idx);

        long V;
        if (op == 'x') V = A * B;
        else if (op == ':') V = A / B;       // integer division (5:2 -> 2)
        else if (op == '+') V = A + B;
        else V = A - B;

        return s.substring(0, L) + V + s.substring(R + 1);
    }

    // helpers kept very small and simple

    static boolean isInt(String s) {
        if (s.length() == 0) return false;
        int i = 0;
        if (s.charAt(0) == '-') { if (s.length() == 1) return false; i = 1; }
        for (; i < s.length(); i++) if (!Character.isDigit(s.charAt(i))) return false;
        return true;
    }

    static int firstOfTwo(String s, char a, char b) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == a || c == b) return i;
        }
        return -1;
    }

    static int firstPlusMinus(String s) {
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '+' || c == '-') {
                if (i == 0) continue;                      // unary at start
                char p = s.charAt(i - 1);
                if (p == '(' || p == '+' || p == '-' || p == 'x' || p == ':') continue; // unary after op or '('
                return i;
            }
        }
        return -1;
    }

    static int leftNumStart(String s, int i) {
        int j = i;
        while (j >= 0 && Character.isDigit(s.charAt(j))) j--;
        // include unary '-'
        if (j >= 0 && s.charAt(j) == '-') {
            if (j == 0) j--;
            else {
                char prev = s.charAt(j - 1);
                if (prev == '(' || prev == '+' || prev == '-' || prev == 'x' || prev == ':') j--;
            }
        }
        return j + 1;
    }

    static int rightNumEnd(String s, int i) {
        int j = i;
        // allow unary '-' on right
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
}
    

