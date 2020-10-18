import java.util.Scanner;

class Kick {

    static int countSubstr(String str, int n, char x, char y) {
        int totalCount = 0;
        int countx = 0;
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) == x)
                countx++;
            if (str.charAt(i) == y)
                totalCount += countx;
        }
        return totalCount;
    }

    // Driver code
    public static void main(String args[]) {
        Scanner s = new Scanner(System.in);
        int l = Integer.parseInt(s.nextLine());
        int[] list = new int[l];
        for (int i = 0; i < l; i++) {

            String st = s.nextLine();
            st = st.replace("KICK", "k");
            st = st.replace("START", "s");
            list[i] = (Kick.countSubstr(st, st.length(), 'k', 's'));

        }
        for (int i = 0; i < l; i++) {
            System.out.println("Case #" + (i + 1) + ": " + list[i]);
        }
        s.close();
    }
}