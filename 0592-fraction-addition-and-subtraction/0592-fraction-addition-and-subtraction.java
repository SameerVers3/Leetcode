class Solution {
    public String fractionAddition(String exp) {
        if (exp.charAt(0) != '-') {
            exp = "+" + exp;
        }

        String [] arr = exp.split("");
        Queue<String> q = new LinkedList<>();

        int i = 0;

        while (i < exp.length()) {
            int j = i + 1;
            while (j < exp.length() && exp.charAt(j) != '+' && exp.charAt(j) != '-') {
                j++;
            }
            q.add(exp.substring(i, j));
            i = j;
        }

        String result = "+0/1";
        
        while (!q.isEmpty()) {
            String fraction = q.remove();
            result = solve(result, fraction);
        }

        if (result.charAt(0) == '+') {
            return result.substring(1);
        }

        return result;
    }

    public String solve(String exp1, String exp2) {
        // a/b +-  c/d;

        System.out.println(exp1 + " " + exp2);

        String [] arr = exp1.split("/");

        int a =  Integer.valueOf(arr[0].substring(1));
        int b = Integer.valueOf(arr[1]);

        String [] arr2 = exp2.split("/");

        int c =  Integer.valueOf(arr2[0].substring(1));
        int d = Integer.valueOf(arr2[1]);


        if (exp1.charAt(0) == '-') {
            a *= -1;
        }

        if (exp2.charAt(0) == '-') {
            c *= -1;
        }

        int unum = (a*d) + (c*b);
        int dnum = (b*d);

        if (unum == 0 ) {
            dnum = dnum / dnum;
            if (unum < 0) {
                return unum + "/" + dnum;
            }

            return "+" + unum + "/" + dnum;
        }

        int gcdNum = gcd(Math.abs(unum), Math.abs(dnum));

        unum = unum / gcdNum;
        dnum = dnum / gcdNum;

        if (unum < 0) {
            return unum + "/" + dnum;
        }

        return "+" + unum + "/" + dnum;
    }

    public int gcd(int a, int b)
    {
        int result = Math.min(a, b);
        while (result > 0) {
            if (a % result == 0 && b % result == 0) {
                break;
            }
            result--;
        }
        return result;
    }
}