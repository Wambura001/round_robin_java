# round_robin_java

## Project Objective
The objective of this project is to implement a simulation of the Round Robin (RR) scheduling algorithm in Java, accounting for varying arrival times. The program calculates key performance metrics such as turnaround time, waiting time, and average values for these metrics, while also generating a Gantt chart to visually represent process execution.
________________________________________
## Introduction
Round Robin is a preemptive CPU scheduling algorithm widely used in multitasking operating systems. Processes are executed in a cyclic order, with a fixed time quantum allocated to each process. The algorithm ensures fairness and avoids starvation by scheduling processes in a circular queue.
This project enhances the standard RR implementation by considering the arrival times of processes, simulating a real-world scenario where processes may not arrive at the same time.
________________________________________
## Features
### 1.	Dynamic Process Arrival:
 Supports processes arriving at different times.
### 2.	Time Quantum Enforcement:
 Preemptively switches processes once their allocated quantum expires.
### 3.	Idle Time Representation:
 Simulates CPU idle periods when no processes are ready.
### 4.	Performance Metrics Calculation:
o	Turnaround Time
o	Waiting Time
o	Average Turnaround and Waiting Times
### 5.	Gantt Chart: 
Displays the order of execution with idle time when applicable.
________________________________________
## Implementation
The project was implemented in Java, adhering to object-oriented programming principles. A Process class was defined to represent individual processes, and the simulation logic was implemented using a Queue.
Key Components
### 1.	Process Class:
o	Attributes: id, burst Time, remaining Time, arrival Time, completion Time, waiting Time, turnaround Time.
o	Constructor to initialize process details.
### 2.	Execution Logic:
o	A ready queue (LinkedList) maintains the order of execution.
o	CPU processes tasks in cycles, checking for arrivals at each time unit.
o	Processes re-enter the queue if they are not yet completed.
### 3.	Performance Metrics:
o	Turnaround Time: completion Time – arrival Time
o	Waiting Time: turn around Time – burst Time
o	Average values calculated across all processes.
### 4.	Gantt Chart:
o	Tracks process execution and idle CPU time, printing the order of execution.
________________________________________
## Input and Output
### Inputs
•	Number of processes.
•	Time quantum.
•	For each process:
o	Burst time.
o	Arrival time.
### Outputs
•	Gantt Chart:
 Execution sequence, including idle CPU time.
•	Metrics:
o	Completion Time
o	Turnaround Time
o	Waiting Time
o	Average Turnaround Time
o	Average Waiting Time
________________________________________

## Methodology
### 1.	Initialization:
o	User inputs process details and time quantum.
o	Processes are stored in a list and sorted by arrival time.
### 2.	Scheduling:
o	Simulate process execution using a ready queue.
o	At each time unit:
	Check for new arrivals and add them to the queue.
	Execute the process at the front of the queue.
	If incomplete, re-add the process to the queue.
	If no processes are ready, increment idle time.
### 3.	Metrics Calculation:
o	Compute completion, turnaround, and waiting times for each process.
### 4.	Output Generation:
o	Display the Gantt chart and performance metrics.
________________________________________
## Challenges
•	Handling Arrival Times:
o	Dynamically managing process arrivals required careful sorting and checking for new arrivals at each time unit.
•	Idle Time Management:
o	Ensuring that idle CPU time is correctly represented in the Gantt chart.
•	Reordering Processes:
o	Efficiently adding and re-adding processes to the queue based on execution status.
________________________________________
## Results and Discussion
o	The implementation successfully simulates the Round Robin scheduling algorithm for processes with varying arrival times. The Gantt chart provides a clear visualization of the execution order, and the calculated metrics allow for performance analysis.
o	The program ensures fairness by allocating equal time slices and handling all processes without starvation. The average turnaround and waiting times demonstrate the algorithm's efficiency in time-sharing scenarios.
________________________________________
## Conclusion
This project demonstrates a robust implementation of the Round Robin scheduling algorithm with arrival times. The program can be further extended to include additional features such as:
•	Context switching overhead.
•	Priority scheduling integration.
•	Real-time visualization with a graphical interface.
________________________________________
## References
1.	Silberschatz, A., Galvin, P. B., & Gagne, G. (2018). Operating System Concepts. Wiley.
2.	Stallings, W. (2018). Operating Systems: Internals and Design Principles. Pearson.
	
## Example Output
Enter the number of processes: 4
Enter the time quantum: 2
Enter burst time for Process P1: 2
Enter arrival time for Process P1: 1
Enter burst time for Process P2: 3
Enter arrival time for Process P2: 2
Enter burst time for Process P3: 4
Enter arrival time for Process P3: 3
Enter burst time for Process P4: 5
Enter arrival time for Process P4: 4

Gantt Chart: | Idle | P1 | P2 | P3 | P2 | P4 | P3 | P4 | P4 |

Process	Arrival Time	Burst Time	Completion Time	Turnaround Time	Waiting Time
P1	1		2		3		2		0
P2	2		3		8		6		3
P3	3		4		12		9		5
P4	4		5		15		11		6

Average Turnaround Time: 7.00
Average Waiting Time: 3.50


