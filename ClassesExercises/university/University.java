package ClassesExercises.university;

import java.util.ArrayList;
import java.util.List;

public class University {
    private int capacity;
    private List<Student> students;

    public University(int capacity) {
        this.capacity = capacity;
        this.students = new ArrayList<>();
    }

    public int getCapacity() {
        return capacity;
    }

    public List<Student> getStudents() {
        return students;
    }

    public int getStudentCount() {

        return students.size();
    }

    public String registerStudent(Student student) {

        String result = null;

        if (students.size() >= capacity) {
            result =  "No seats in the ClassesExercises.university";
        }

        for (Student s : students) {
            if (s.getFirstName().equals(student.getFirstName()) && s.getLastName().equals(student.getLastName())) {
                result = "Student is already in the ClassesExercises.university";
                break;
            }
        }

        if (result == null){
            students.add(student);
            return String.format("Added student %s %s", student.getFirstName(), student.getLastName());
        }
        return result;
    }


    public String dismissStudent(Student student) {

        Student foundStudent = getStudent(student.getFirstName(), student.getLastName());

        if (foundStudent == null) {
            return "Student not found";
        }

        students.remove(student);
        return String.format("Removed student %s %s", foundStudent.getFirstName(), foundStudent.getLastName());
    }

    public Student getStudent(String firstName, String lastName) {

        for (Student currentStudent : students) {
            if (currentStudent.getFirstName().equals(firstName) && currentStudent.getLastName().equals(lastName)) {
                return currentStudent;
            }
        }
        return null;
    }

    public String getStatistics() {

        StringBuilder builder = new StringBuilder();

        for (Student student : students) {

            builder.append(String.format("==Student: First Name = %s, Last Name = %s, Best Subject = %s%n",
                    student.getFirstName(), student.getLastName(), student.getBestSubject()));
        }
        return builder.toString().trim();
    }
}
