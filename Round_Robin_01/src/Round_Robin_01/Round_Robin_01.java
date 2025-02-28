package Round_Robin_01;

	import java.util.*;

	class Process {
	    int id;
	    int burstTime;
	    int remainingTime;
	    int arrivalTime;
	    int completionTime;
	    int waitingTime;
	    int turnaroundTime;

	    Process(int id, int burstTime, int arrivalTime) {
	        this.id = id;
	        this.burstTime = burstTime;
	        this.remainingTime = burstTime;
	        this.arrivalTime = arrivalTime;
	    }
	}

	// RoundRobinScheduler 
	
	public class Round_Robin_01{
		public static void main(String[] args) {
		    try (Scanner sc = new Scanner(System.in)) {
		        System.out.print("Enter the number of processes: ");
		        int n = sc.nextInt();

		        System.out.print("Enter the time quantum: ");
		        int timeQuantum = sc.nextInt();

		        List<Process> processes = new ArrayList<>();
		        for (int i = 0; i < n; i++) {
		            System.out.print("Enter burst time for Process P" + (i + 1) + ": ");
		            int burstTime = sc.nextInt();
		            System.out.print("Enter arrival time for Process P" + (i + 1) + ": ");
		            int arrivalTime = sc.nextInt();
		            processes.add(new Process(i + 1, burstTime, arrivalTime));
		        }

		        executeRoundRobin(processes, timeQuantum);
		    } // The Scanner is automatically closed here	
		}

	        
	    

	    public static void executeRoundRobin(List<Process> processes, int timeQuantum) {
	        // Sort processes by arrival time
	        processes.sort(Comparator.comparingInt(p -> p.arrivalTime));

	        Queue<Process> readyQueue = new LinkedList<>();
	        int currentTime = 0;
	        int completed = 0;

	        System.out.print("\nGantt Chart: ");

	        while (completed < processes.size()) {
	            // Add processes to the ready queue if they have arrived
	            for (Process p : processes) {
	                if (p.arrivalTime <= currentTime && p.remainingTime > 0 && !readyQueue.contains(p)) {
	                    readyQueue.add(p);
	                }
	            }

	            if (!readyQueue.isEmpty()) {
	                // Execute the process at the front of the queue
	                Process current = readyQueue.poll();
	                System.out.print("| P" + current.id + " ");

	                if (current.remainingTime > timeQuantum) {
	                    currentTime += timeQuantum;
	                    current.remainingTime -= timeQuantum;
	                    readyQueue.add(current); // Re-add to the queue
	                } else {
	                    currentTime += current.remainingTime;
	                    current.remainingTime = 0;
	                    current.completionTime = currentTime;
	                    completed++;
	                }
	            } else {
	                // If no process is ready, idle the CPU
	                System.out.print("| Idle ");
	                currentTime++;
	            }
	        }
	        System.out.println("|");

	        // Calculate and display metrics
	        calculateMetrics(processes);
	        displayResults(processes);
	    }

	    public static void calculateMetrics(List<Process> processes) {
	        for (Process p : processes) {
	            p.turnaroundTime = p.completionTime - p.arrivalTime;
	            p.waitingTime = p.turnaroundTime - p.burstTime;
	        }
	    }

	    public static void displayResults(List<Process> processes) {
	        System.out.println("\nProcess\tArrival Time\tBurst Time\tCompletion Time\tTurnaround Time\tWaiting Time");
	        for (Process p : processes) {
	            System.out.println("P" + p.id + "\t" + p.arrivalTime + "\t\t" + p.burstTime + "\t\t" + p.completionTime + "\t\t" + p.turnaroundTime + "\t\t" + p.waitingTime);
	        }

	        // Calculate average waiting time and turnaround time
	        double totalWT = 0, totalTAT = 0;
	        for (Process p : processes) {
	            totalWT += p.waitingTime;
	            totalTAT += p.turnaroundTime;
	        }
	        System.out.printf("\nAverage Turnaround Time: %.2f\n", totalTAT / processes.size());
	        System.out.printf("Average Waiting Time: %.2f\n", totalWT / processes.size());
	    }
	}

	
	
