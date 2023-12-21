/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package librarysys;
import java.util.Scanner;
import java.util.InputMismatchException;

/**
 *
 * @author ppu
 */
public class LibrarySys {

    public static void main(String[] args) {

        Library L1 = new Library();
        Scanner input = new Scanner(System.in);

        while (true) {
            try {
                System.out.println("Library Management System Menu:");
                System.out.println("1. Add Book");
                System.out.println("2. Add Student");
                System.out.println("3. Search by Title");
                System.out.println("4. Search by Number");
                System.out.println("5. Search by Author");
                System.out.println("6. Check Books Loan");
                System.out.println("7. Show All Books");
                System.out.println("8. Loan Book");
                System.out.println("9. Return Book");
                System.out.println("10. Exit");
                System.out.print("Enter your choice: ");

                int choice = input.nextInt();

                switch (choice) {
                    case 1:
                        System.out.println("Enter Book title: ");
                        String title = input.next();
                        System.out.println("Enter Author details  ID , Name , address , BirthDate day ,BirthDate month ,BirthDate year :  ");
                        Author author = new Author(input.nextInt(), input.next(), input.next(), new MyDate(input.nextInt(), input.nextInt(), input.nextInt()));
                        System.out.println("Enter Book NO: ");
                        int NO = input.nextInt();
                        System.out.println("Enter Book genre: ");
                        String genre = input.next();
                        System.out.println("Enter Book version : ");
                        int version = input.nextInt();
                        System.out.println("Enter Book Date (day , month , year) : ");
                        MyDate date = new MyDate(input.nextInt(), input.nextInt(), input.nextInt());
                        Book book = new Book(title, author, NO, genre, version, date);
                        L1.addBook(book);
                        break;

                    case 2:
                        System.out.println("Enter Studen details  ID , Name , address , BirthDate (day ,month, year ) , majer ");
                        Student student = new Student(input.nextInt(), input.next(), input.next(), new MyDate(input.nextInt(), input.nextInt(), input.nextInt()), input.next());
                        L1.addstudent(student);
                        break;
                    case 3:
                        System.out.println("Enter Book title: ");
                        String Btitle = input.next();
                        L1.searchByTitle(Btitle);
                        break;
                    case 4:
                        System.out.println("Enter Book NO: ");
                        int BNO = input.nextInt();
                        L1.searchByNumber(BNO);
                        break;
                    case 5:
                        System.out.println("Enter Author Name");
                        String Aname = input.next();
                        ;
                        L1.searchByAuthor(Aname);
                        break;
                    case 6:
                        L1.checkBookavailable();
                        break;
                    case 7:
                        L1.showBook();
                        break;
                    case 8:

                        System.out.println("Enter Book NO: ");
                        int BnO = input.nextInt();
                        System.out.println("Enter Studen ID : ");
                        int ID = input.nextInt();
                        L1.loanBook(ID, BnO);
                        break;

                    case 9:

                        System.out.println("Enter Book NO: ");
                        int Bno = input.nextInt();
                        System.out.println("Enter Studen  ID : ");
                        int SID = input.nextInt();
                        L1.returnBook(SID, Bno);
                        break;

                    case 10:
                        System.out.println("Exiting the Library Management System. Goodbye!");
                        System.exit(0);
                    default:
                        System.out.println("Invalid choice. Please enter a valid option.");
                }
            } catch (InputMismatchException e) {
                System.out.println("Invalid input. Please enter a valid number.");
                input.nextLine(); 
            } catch (Exception e) {
                e.printStackTrace(); 
            }
        }
    }
}

