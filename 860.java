class Solution {
    public boolean lemonadeChange(int[] bills) {
        int fiveBill = 0, tenBill = 0;
        for (int i : bills) {
            if (i == 5) {
                fiveBill++;
            } else if (i == 10) {
                if (fiveBill > 0) {
                    fiveBill--;
                    tenBill++;
                } else {
                    return false;
                }
            } else if (i == 20) {
                if (tenBill > 0 && fiveBill > 0) {
                    tenBill--;
                    fiveBill--;
                } else if (fiveBill > 2) {
                    fiveBill -= 3;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
