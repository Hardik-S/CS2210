class oneone {

    public static void main(String[] args) {
        String str = "abc";
        String str2 = "bac";

        boolean test1 = checkPerm(str, str2);
        if (test1 == true) System.out.println("test1 passed.");


        System.out.println(URLify("bob vagene "));
        System.out.println(checkPalindromePerm("taco cat"));
        System.out.println(oneAway("abc", "dbc"));

    }

    public static boolean oneAway(String first, String second) {
        if (Math.abs(first.length()-second.length())>1) return false;

        first+=" ";
        second+=" ";
        int count = 0;

        char[] F = first.toCharArray();
        char[] S = second.toCharArray();

        int chars[] = new int[128];

        for (char c:F) {
            chars[c]++;
        }

        for (int i = 0; i<first.length(); i++) {
            int c = (int) second.charAt(i);
            chars[c]--;
            if (chars[c]!=0) count++;  
        }
        


        return count<2;
    }

    public static boolean checkPalindromePerm(String first) {
        char[] F = first.toCharArray();
        int count = 0;
        int chars[] = new int[128];

        for (char c:F) {
            if (c == ' ');
            else {
                chars[c]++;
            }
        }

        for (char c:F) {
            if (chars[c]%2 != 0) count++;
        }

        return (count<2);
    }

    public static String URLify(String first) {
        StringBuilder res = new StringBuilder();
        char[] ch = first.toCharArray();

        for (char c : ch) {
            if (c == ' ') res.append("%20");
            else res.append(c);
        }

        return res.toString();
    }

    public static boolean checkPerm(String first, String second) {
        if (first.length()!=second.length()) return false;
        
        int[] chars = new int[128]; // assumption

        char[] F = first.toCharArray();

        for (char c : F) {
            chars[c]++;
        }

        for (int i = 0; i<second.length(); i++){
            int c = (int) second.charAt(i);
            chars[c]--;
            if (chars[c]<0) return false;
        }

        return true;
    }
}
