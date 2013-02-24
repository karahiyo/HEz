

public class PairingPawns {
    public int savedPawnsCount(int[] start) {
        int size = start.length-1;
        for(int i=size; i>=1; i--) {
            start[i-1] = start[i-1] + start[i]/2;
        }
        return start[0];
    }
    public static void main(String[] args) {
        if(args.length == 0) {
            PairingPawnsHarness.run_test(-1);
        } else {
            for (int i=0; i<args.length; ++i)
                PairingPawnsHarness.run_test(Integer.valueOf(args[i]));
        }
    }
}


    

// BEGIN CUT HERE
class PairingPawnsHarness {
    public static void run_test(int casenum) {
        if (casenum != -1) {
            if (runTestCase(casenum) == -1)
                System.err.println("Illegal input! Test case " + casenum + " does not exist.");
            return;
        }

        int correct = 0, total = 0;
        for (int i = 0;; ++i) {
            int x = runTestCase(i);
            if (x == -1) {
                if (i >= 100)
                    break;
                continue;
            }
            correct += x;
            ++total;
        }

        if (total == 0) {
            System.err.println("No test cases run.");
        } else if (correct < total) {
            System.err.println("Some cases FAILED (passed " + correct + " of " + total + ").");
        } else {
            System.err.println("All " + total + " tests passed!");
        }
    }

    static boolean compareOutput(int expected, int result) {
        return expected == result;
    }

    static String formatResult(int res) {
        return String.format("%d", res);
    }

    static int verifyCase(int casenum, int expected, int received) {
        System.err.print("Example " + casenum + "... ");
        if (compareOutput(expected, received)) {
            System.err.println("PASSED");
            return 1;
        } else {
            System.err.println("FAILED");
            System.err.println("    Expected: " + formatResult(expected));
            System.err.println("    Received: " + formatResult(received));
            return 0;
        }
    }

    static int runTestCase(int casenum) {
        switch (casenum) {
        case 0: {
            int[] start = { 0, 2 };
            int expected__ = 1;

            return verifyCase(casenum, expected__, new PairingPawns().savedPawnsCount(start));
        }
        case 1: {
            int[] start = { 10, 3 };
            int expected__ = 11;

            return verifyCase(casenum, expected__, new PairingPawns().savedPawnsCount(start));
        }
        case 2: {
            int[] start = { 0, 0, 0, 8 };
            int expected__ = 1;

            return verifyCase(casenum, expected__, new PairingPawns().savedPawnsCount(start));
        }
        case 3: {
            int[] start = { 0, 1, 1, 2 };
            int expected__ = 1;

            return verifyCase(casenum, expected__, new PairingPawns().savedPawnsCount(start));
        }
        case 4: {
            int[] start = { 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 123456 };
            int expected__ = 0;

            return verifyCase(casenum, expected__, new PairingPawns().savedPawnsCount(start));
        }
        case 5: {
            int[] start = { 1000, 2000, 3000, 4000, 5000, 6000, 7000, 8000 };
            int expected__ = 3921;

            return verifyCase(casenum, expected__, new PairingPawns().savedPawnsCount(start));
        }

        // custom cases

        /*
         * case 6: {
         * int[] start = ;
         * int expected__ = ;
         *
         * return verifyCase(casenum, expected__, new
         * PairingPawns().savedPawnsCount(start));
         * }
         */
        /*
         * case 7: {
         * int[] start = ;
         * int expected__ = ;
         *
         * return verifyCase(casenum, expected__, new
         * PairingPawns().savedPawnCount(start));
         * }
         */
        /*
         * case 8: {
         * int[] start = ;
         * int expected__ = ;
         *
         * return verifyCase(casenum, expected__, new
         * PairingPawns().savedPawnCount(start));
         * }
         */
        default:
            return -1;
        }
    }
}

// END CUT HERE

        

