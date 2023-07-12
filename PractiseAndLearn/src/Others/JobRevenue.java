package Experiment;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class JobRevenue {

	class Job implements Comparable<Job> {
		String id;
		int startTime;
		int endTime;
		int revenue;

		Job(String id, int startTime, int endTime, int revenue) {
			this.id = id;
			this.startTime = startTime;
			this.endTime = endTime;
			this.revenue = revenue;
		}

		@Override
		public int compareTo(Job o) {
			return Integer.compare(this.startTime, o.startTime);
		}
	}

	Map<String, Integer> cache = new HashMap<>();

	int maxCost(Job[] jobs, int curPos) {
		if (null != cache.get(jobs[curPos].id)) {
			return cache.get(jobs[curPos].id);
		}
		if (jobs.length - 1 == curPos) {
			return jobs[curPos].revenue;
		}
		int max = 0;

		for (int i = curPos + 1; i < jobs.length; i++) {
			int currRes = maxCost(jobs, i);
			if (isExecutable(jobs[curPos], jobs[i])) {
				currRes += jobs[curPos].revenue;
			} else {
				if (jobs[curPos].revenue > currRes) {
					currRes = jobs[curPos].revenue;
				}
			}
			if (currRes > max) {
				max = currRes;
			}
		}
		System.out.println(max);
		cache.put(jobs[curPos].id, max);
		return max;
	}

	void maxCostDp(Job[] jobs) {
		int dp[] = new int[jobs.length];
		dp[0] = jobs[0].revenue;
		for (int i = 1; i < jobs.length; i++) {
			int curRes = jobs[i].revenue;
			Job nextExecutableJob = latestExecutableJob(jobs, jobs[i], i);
			if (null != nextExecutableJob) {
				curRes = nextExecutableJob.revenue + curRes;
			}
			dp[i] = dp[i - 1] > curRes ? dp[i - 1] : curRes;
		}
		for (int i = 0; i < jobs.length; i++) {
			System.out.println(dp[i]);
		}
	}

	Job latestExecutableJob(Job[] jobs, Job job, int startPtr) {
		for (int i = startPtr - 1; i >= 0; i--) {
			if (isExecutable(jobs[i], job))
				return jobs[i];
		}
		return null;
	}

	boolean isExecutable(Job j1, Job j2) {
		if (j1.startTime < j2.startTime) {
			if (j1.endTime > j2.endTime) {
				return false;
			}
			if (j2.startTime < j1.endTime) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		JobRevenue jobRevenue = new JobRevenue();
		Job[] jobs = new Job[4];
//		jobs[0] = jobRevenue.new Job("1", 1, 2, 50);
//		jobs[3] = jobRevenue.new Job("2", 2, 100, 200);
//		jobs[1] = jobRevenue.new Job("3", 3, 5, 20);
//		jobs[2] = jobRevenue.new Job("4", 6, 19, 100);

		jobs[0] = jobRevenue.new Job("1", 1, 5, 50);
		jobs[1] = jobRevenue.new Job("2", 2, 3, 40);
		jobs[2] = jobRevenue.new Job("3", 4, 6, 60);
		jobs[3] = jobRevenue.new Job("4", 8, 9, 90);

		Arrays.sort(jobs);
		jobRevenue.maxCostDp(jobs);
		// System.out.println(jobRevenue.maxCost(jobs, 0));
	}

}
