class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveBill = 0;
        int tenBill = 0;

        for (int i = 0 ; i < bills.length ; i++) {
            if (bills[i] == 5) {
                fiveBill++;
            }
            else if (bills[i] == 10) {
                if (fiveBill == 0) {
                    return false;
                }
                fiveBill--;
                tenBill++;
            }
            else {
                if (tenBill >= 1 && fiveBill >= 1) {
                    tenBill--;
                    fiveBill--;
                }
                else if (tenBill == 0 && fiveBill >= 3) {
                    fiveBill -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}