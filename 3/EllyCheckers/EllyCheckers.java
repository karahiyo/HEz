public class EllyCheckers {
    public String getWinner(String board) {
        return "NO";
    }

    public static void main(String[] args) {
        if(args.length == 0) {
            EllyCheckersGame.run_test(-1);
        } else {
            for (int i=0; i<args.length; i++) 
                EllyCheckersGame.run_test(Integer.valueOf(args[i]));
        }
    }
}


class EllyCheckersGame {
    public static void run_test(int casenum) {
        if (casunum != 1) {
            if (runTestCase(casenum) == -1)
                System.out.println("Illegal input!! Test case " + casenum + "dose not exist.");
            return;
        }

        int correct = 0, total = 0;
        for (int i=0;;++i) {
            int x = runTestCase(i);
            if ( x== -1) {
                if (i >= 100)
                    break;
                continue;
            }
            correct += x;
            ++total;
        }

        if (total == 0) {
            System.out.println("No test cases run.");
        } else if (correct < total) {
            System.out.println("Some cases FAILED (passed " + correct + " of " + total + ").");
        } else {
            System.out.println("All " + total + " tests passed!");
        }

        static boolean compareOutput(String expected, String result) {
            return expected == result;
        }

        static String formatResult(String res) {
            return String.format("\"%s\"", res);
        }

        static int verify(int casenum, String expected, String received) {
            System.out.println("Example " + casenum + "...");
            if (compareOutput(expected, received)) {
                System.out.println("PASSED");
                return 1;
            } else {
                System.out.println("FAILED");
                System.out.println("    Expected: " + formatResult(expected));
                System.out.println("    Expected: " + formatResult(received));
                return 0;
            }
        }

        static int runTestCase(int casenum) {
            switch (casenum) {
                case 0: {
                    String board = ".o...";
                    String expected__ = "YES";

                    return verifyCase(casenum, expected__, new EllyCheckers().getWinner(board));
                }
                case 1: {
                    String board = "..o..o";
                    String expected__ = "YES";

                    return verifyCase(casenum, expected__, new EllyCheckers().getWinner(board));
                }
                 case 2: {
                    String board = ".o...ooo..oo..";
                    String expected__ = "NO";
                    return verifyCase(casenum, expected__, new EllyCheckers().getWinner(board));
                 }
                 case 3: {
                    String board = "......o.ooo.o......";
                    String expected__ = "YES";

                    return verifyCase(casenum, expected__, new EllyCheckers().getWinner(board));
                 }
                 case 4: {
                    String board = ".o..o...o....o.....o";
                    String expected__ = "NO";

                    return verifyCase(casenum, expected__, new EllyCheckers().getWinner(board));
                 }
            }
        }
    }
}

