package greedy.practice;

import java.util.ArrayList;
import java.util.Collections;

public class JobSequence {

    static class Job {
        int deadline;
        int profit;
        int id; // 0(A),1(B),2(C),3(D)

        public Job(int i, int d, int p) {
            id = i;
            deadline = d;
            profit = p;
        }
    }

    public static void main(String[] args) {
        int[][] jobsInfo = {{4, 20}, {1, 10}, {1, 40}, {1, 30}};

        ArrayList<Job> jobs = new ArrayList<>();

        for (int i = 0; i < jobsInfo.length; i++) {
            jobs.add(new Job(i, jobsInfo[i][0], jobsInfo[i][1]));
        }

        // objects sort
        Collections.sort(jobs, (obj1, obj2) -> obj2.profit - obj1.profit); // descending order of profit

        ArrayList<Integer> seq = new ArrayList<>();
        int time = 0;
        for (int i = 0; i < jobs.size(); i++) {
            Job curr = jobs.get(i);
            if (curr.deadline > time) {
                seq.add(curr.id);
                time++;
            }
        }

        // print seq
        System.out.println("max jobs = " + seq.size());
        for (int i : seq) {
            System.out.print(i + " ");
        }
        System.out.println();
    }
}

/*
int maxDeadline = 0;
for (Job job : jobs) {
    maxDeadline = Math.max(maxDeadline, job.deadline);
}

boolean[] slot = new boolean[maxDeadline + 1];
int[] result = new int[maxDeadline + 1];

int count = 0;
int totalProfit = 0;

for (Job curr : jobs) {
    for (int j = curr.deadline; j > 0; j--) {
        if (!slot[j]) {
            slot[j] = true;
            result[j] = curr.id;
            count++;
            totalProfit += curr.profit;
            break;
        }
    }
}

*/