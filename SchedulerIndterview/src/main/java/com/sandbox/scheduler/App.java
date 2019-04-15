package com.sandbox.scheduler;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import com.sandbox.scheduler.model.Category;
import com.sandbox.scheduler.model.Task;

import net.adamdog.avltree.AVLDictionary;
import net.adamdog.avltree.AVLUtilities;

/**
 * Created by pchurchward on 2017-07-20.
 */
public class App {

	public static void main(String[] args) {
        Task task1 = new Task(0, Category.RED);
        Task task2 = new Task(0, Category.BLUE);
        Task task3 = new Task(3, Category.GREEN);
        Task task4 = new Task(4, Category.GREEN);
        Task task5 = new Task(5, Category.RED);
        Task task6 = new Task(0, Category.RED);

        List<Task> unsorted = Arrays.asList(task1, task2, task3, task4, task5, task6);

        unsorted.forEach(t -> Scheduler.scheduleTask(t));

        Scheduler.printSchedule();
    }

    public static class Scheduler {

    	private static AVLDictionary<Task, String> scheduledTasks = new AVLDictionary<Task, String>();
    	
    	private static TreeSet<Task>  scheduledTasksTree = new TreeSet<Task>();
    	
		public static Object scheduleTask(Task t) {
			scheduledTasks.set(t, null);
			scheduledTasksTree.add(t);
			return scheduledTasksTree;
		}

		public static void printSchedule() {
		    AVLUtilities<Task, String> avl = 
		            new AVLUtilities<Task, String>();
		    List<Task> ts = avl.makeArray(scheduledTasks, true);
			
		    ts.forEach(System.out::println);
		    
			System.out.println("====================================================================");
			
			scheduledTasksTree.forEach(System.out::println);
		}
	}
}
