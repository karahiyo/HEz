public class Ants {
    public int solve(int L, int[] x) {
        int max = 0;
        for(int i=0,N=x.length; i<N; i++) {
            if(max < L-x[i])
                max = L-x[i];
            else if(max < x[i])
                max = x[i];
        }
        System.out.println("max=" + max);   
        return max;
    }

    public static void main(String[] args) {
        {
            boolean bool = new Ants().solve(10, new int[] {2,6,7}) == 8;
            System.out.println(bool ? "OK" : "NG");
        }
        {
            boolean bool = new Ants().solve(10, new int[] {5,10}) == 10;
            System.out.println(bool ? "OK" : "NG");
        }
        { 
            boolean bool = new Ants().solve(10, new int[] {1,2,3,4,5,6,7,8,9,10}) == 10;
            System.out.println(bool ? "OK" : "NG");
        }
        {
            boolean bool = new Ants().solve(10, new int[] {1,2,3,4,5}) == 9;
            System.out.println(bool ? "OK" : "NG");
        }
    }
}
