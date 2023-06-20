// References : https://www.youtube.com/watch?v=ybTQoPz02yg

class Solution {
    public String predictPartyVictory(String senate) {

        // Initialise two queues for each party
        Queue<Integer> radiantQueue = new LinkedList<>();
        Queue<Integer> direQueue = new LinkedList<>();
        int lengthOfSenate = senate.length();

        // Add the indices of the members in the string in the queue
        for (int i = 0; i < senate.length(); i++) {
            char currentMember = senate.charAt(i);
            boolean isAdded = Character.compare(currentMember, 'R') == 0 ? radiantQueue.add(i) : direQueue.add(i);
        }

        while (!radiantQueue.isEmpty() && !direQueue.isEmpty()) {
            Integer radiantMemberIndex = radiantQueue.poll();
            Integer direMemberIndex = direQueue.poll();

            boolean isAddedAtEnd = radiantMemberIndex < direMemberIndex ? radiantQueue.add(radiantMemberIndex + lengthOfSenate) : direQueue.add(direMemberIndex + lengthOfSenate);
        }

        return radiantQueue.size() > direQueue.size() ? "Radiant" : "Dire";

    }
}