class Solution {
    public int timeRequiredToBuy(int[] tickets, int k) {
        int ticketRequired = tickets[k];
        int time = 0;
        for (int i = 0; i < tickets.length; i++) {
            if (tickets[i] >= ticketRequired) {
                if (i <= k)
                    time += ticketRequired;
                else
                    time += ticketRequired - 1;
            } else {
                time += tickets[i];
            }
        }
        return time;
    }
}
