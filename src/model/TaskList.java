package model;

import java.io.Serializable;
import java.util.ArrayList;

/**
 * A class that represents the list  of the class Task
 */
public class TaskList implements Serializable {
  private ArrayList<Task> taskList;


  /**
   * zero argument constructor that initializes the Arraylist that is holding Task classes
   */
  public TaskList() {
    this.taskList = new ArrayList<>();
  }
  /**
   * Returning how many objects of type Task are stored in the Arraylist
   *
   * @return   number of elements in the Arraylist as an integer
   */

  public int size() {
    return  taskList.size();
  }

  /**
   * adding a new instance of the class Task to the containing Arraylist
   * @param task the task as an object of type Task
   */

  public void addTask(Task task) {
    taskList.add(task);
  }

  /**
   * removing an instance of the class task from the containing Arraylist
   * @param task the task as an object of type Task
   */

  public void removeTask(Task task) {
    taskList.remove(task);
  }

  /**
   * returing an object of type task based on the index number
   * @param index the index number of the tasks as an integer
   * @return the task as an object of type Task
   */
  
  public Task getTask(int index) {
    return taskList.get(index);
  }

  /**
   * will loop trough the containing Arraylist and return the task with matching ID
   * @param id the ID of the task in a form of a string
   * @return will return task as an instance of class Task
   */

  public Task getTask(String id) {
    for (Task task: taskList) {
      if (task.getId().equals(id)) {
        return task;
      }
    }
    return null;
  }


  /**
   * will return all the tasks that are stored in the containing element
   * @return an ArrayList containing all the instances of class Task
   */
  public ArrayList<Task> getTaskList() {
    return taskList;
  }



}