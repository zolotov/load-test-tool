package com.farpost.ldt;

import java.io.PrintStream;
import java.util.List;

/**
 * Print detailed elapsed time log (in microseconds).
 */
public class ElapsedTimeLogResultFormatter implements ResultFormatter {

	private PrintStream out;

	public ElapsedTimeLogResultFormatter(PrintStream out) {
		this.out = out;
	}

	public void format(TestResult result) {
		List<ThreadTestHistory> threadsHistory = result.getThreadsHistory();
		int historyLength = result.getThreadSamplesCount();
		out.println("Execution elapsed time log (in microseconds):");
		out.println("---------------------------------------------");
		for (int i = 0; i < historyLength; i++) {
			for (ThreadTestHistory threadHistory : threadsHistory) {
				out.println(threadHistory.getSamples()[i]);
			}
		}
	}
}
