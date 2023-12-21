/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysys;

import java.util.ArrayList;
import java.util.Date;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Objects;

/**
 *
 * @author ppu
 */
public class Library {

    ArrayList<Book> books;
    ArrayList<Student> students;

    public Library() {
        this.books = new ArrayList<>();
        this.students = new ArrayList<>();

    }

    public void addBook(Book book) {
        books.add(book);
        System.out.println(" Book Added successfully");
    }

    public void addstudent(Student student) {
        students.add(student);
        System.out.println(" Student Added successfully");
    }

    public void searchByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle().equals(title)) {
                System.out.println("Book found: " + book.getInfo());
                return;
            }
        }
        System.out.println("Book not found with title: " + title);
    }

    public Book searchByNumber(Integer number) {
        for (Book book : books) {
            if (Objects.equals(book.getNO(), number)) {
                System.out.println("Book found:" + book.getInfo());
                return book;
            }
        }
        System.out.println("Book not found with number: " + number);
        return null;
    }

    public void searchByAuthor(String authorName) {
        for (Book book : books) {
            if (book.getAuthor().getName().equals(authorName)) {
                System.out.println("Book found: " + book.getInfo());
                return;
            }
        }
        System.out.println("Book not found by author: " + authorName);
    }

    public Student searchStudentByNumber(Integer number) {
        for (Student student : students) {
            if (Objects.equals(student.getID(), number)) {
                System.out.println("Student found: " + student.getInfo());
                return student;
            }
        }
        System.out.println("Student not found with number: " + number);
        return null;
    }

    public void checkBookavailable() {

        for (Book book : books) {
            if (book.inLoan()) {
                System.out.println("Book in loan: " + book.getInfo());
            } else {
                System.out.println(" No Book in loan: ");
            }
        }
    }

    public void showBook() {
        if (books.isEmpty()) {
            System.out.println("No books in the library.");
        } else {
            System.out.println("Books in the library:");
            for (Book book : books) {
                System.out.println("Book Title: " + book.getTitle() + ", Number: " + book.getNO() + " ,InLoan : " + book.inLoan());
            }
        }
    }

    public void loanBook(int studentNumber, int bookNumber) {

        Student student = searchStudentByNumber(studentNumber);
        Book book = searchByNumber(bookNumber);
        if (book != null) {
            if (student != null) {
                if (books.contains(book)) {
                    if (!book.inLoan()) {
                        if (student.loanedBooks.size() < 3) {
                            book.setOnLone(true);
                            book.setLoneDate(LocalDateTime.now());
                            book.setDueDate(calculateDueDate(book.getLoneDate()));
                            student.addLoanedBook(book);
                            System.out.println("Book loaned successfully ");
                        } else {
                            System.out.println("Student has reached the maximum number of loans.");
                        }
                    } else {
                        System.out.println("Book is already on loan.");
                    }
                } else {
                    System.out.println(" book not found in the library.");
                }
            }
        }
    }

    public void returnBook(int studentNumber, int bookNumber) {
        Student student = searchStudentByNumber(studentNumber);
        Book book = searchByNumber(bookNumber);

        if (book != null) {
            if (books.contains(book)) {
                if (book.inLoan() && student.loanedBooks.contains(book)) {
                    checkLoan(book);
                    book.setOnLone(false);
                    student.removeLoanedBook(book);
                }
            } else {
                System.out.println("Book not found in the library.");
            }
        }
    }

    private LocalDateTime calculateDueDate(LocalDateTime loanDateTime) {

        return loanDateTime.plusDays(5);
    }

    public void checkLoan(Book book) {
        Date currentDate = new Date();
        if (book.inLoan()) {
            LocalDateTime dueDate = book.getDueDate();
            if (dueDate != null) {
                LocalDateTime currentDateTime = LocalDateTime.ofInstant(currentDate.toInstant(), ZoneId.systemDefault());
                if (currentDateTime.isAfter(dueDate)) {
                    System.out.println("Book returned late! Overdue loan detected: " + book.getTitle());
                } else {
                    System.out.println("Book returned successfully: " + book.getTitle());
                }
            } else {
                System.out.println(" Due date not set for the book.");
            }
        } else {
            System.out.println(" Book is not on loan.");
        }
    }
}
