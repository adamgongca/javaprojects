package com.sandbox.scheduler.model;

import java.time.LocalDateTime;
import java.util.UUID;

/**
 * Created by pchurchward on 2017-07-20.
 */
public class Task implements Comparable<Task> {

    public int urgency = -1;
    public String category;
    public LocalDateTime timestamp = LocalDateTime.now();
    public UUID uuid = UUID.randomUUID();

    public Task(int urgency, String category) {
        this.urgency = urgency;
        this.category = category;
    }

    public Task(int urgency, Category category) {
        this.urgency = urgency;
        this.category = category.name();
	}

	public String toString() {

       return "[TASK] UUID: " + uuid.toString() + " URGENCY: " + urgency + " CATEGORY: " + category +" TIMESTAMP: " + timestamp;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Task task = (Task) o;

        if (urgency != task.urgency) return false;
        if (!category.equals(task.category)) return false;
        if (timestamp != null ? !timestamp.equals(task.timestamp) : task.timestamp != null) return false;
        return uuid != null ? uuid.equals(task.uuid) : task.uuid == null;
    }

    @Override
    public int hashCode() {
        int result = urgency;
        result = 31 * result + (category != null ? category.hashCode() : 0);
        result = 31 * result + (timestamp != null ? timestamp.hashCode() : 0);
        result = 31 * result + (uuid != null ? uuid.hashCode() : 0);
        return result;
    }

	@Override
	public int compareTo(Task o) {
		if (o == null) 
			throw new NullPointerException();
		if (urgency < o.urgency) return -1 ;
		else if (urgency > o.urgency) return 1 ;
		else {
			int v1 = Category.valueOf(category).getValue();
			int v2 = Category.valueOf(o.category).getValue();
			if (v1 < v2) return -1 ;
			else if (v1 > v2) return 1 ;
			else {
				return timestamp.compareTo(o.timestamp);
			}
		}
	}
    
}
