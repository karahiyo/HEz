/*
// SRM 534 Div2 Medium (500)

問題

N個のマスからなる盤面がある。
マスは空または駒が置かれている。
駒の右が空いていれば駒を一つ右に移動できる。
駒の右とその右が駒でその右が空いていれば、駒を三つ移動できる。
最も右の駒は直ちに取り除かれる。
二人のプレーヤーで交互に移動操作をするとき、動かせなかったら負けとするとき
最初のプレーヤーが勝つかどうかを求める。

*/

public class EllyCheckers {
    public String getWinner(String board) {
        int sum = 0;
        for(int i=0,N=board.length(); i<N; i++) {
            if(board.charAt(i) == 'o') { 
                sum += N-i-1;
            }
        }
        return (sum%2==1?"YES":"NO");
    }
/*    public String getWinner(String board) {
        int sum = 0;
        for (int i=0,N=board.length(); i<N; i++) {
            if(board.charAt(i) == 'o') {
                int p = board.length() - 1 - i;
                sum += p/3 + p%3;
            }
        }
        return (sum%2==1?"YES":"NO");
    }
*/
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
        if (casenum != -1) {
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
    }

    static boolean compareOutput(String expected, String result) {
        return expected.equals(result);
    }

    static String formatResult(String res) {
        return String.format("\"%s\"", res);
    }

    static int verifyCase(int casenum, String expected, String received) {
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
                        String board = ".o...ooo..oo.."; //2+3+6+7+8+12 = 38
                        String expected__ = "NO";
                        return verifyCase(casenum, expected__, new EllyCheckers().getWinner(board));
            }
            case 3: {
                        String board = "......o.ooo.o......"; //7+9+10+11+12+14 = 63
                        String expected__ = "YES";

                        return verifyCase(casenum, expected__, new EllyCheckers().getWinner(board));
            }
            case 4: {
                        String board = ".o..o...o....o.....o"; //6+11+15+18=50
                        String expected__ = "NO";

                        return verifyCase(casenum, expected__, new EllyCheckers().getWinner(board));
            }
            default:
                    return -1;
        }
    }
}

