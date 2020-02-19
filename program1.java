package midterm;

import java.util.*;

public class test {



	public static void main(String[] args) {

		//asking user input from the user

		Scanner sc= new Scanner(System.in);

		String bookName[]= new String[100];

		double bookCopy[] = new double[100];

		int i = -1;

		while(true){

			System.out.println("Enter the Book Name: ");

			String name = sc.next();

			System.out.println("Enter the number of copies : ");

			double copy = sc.nextDouble();

			if(copy==0)

				break;

			else {

				i++;

				bookName[i] = name;

				bookCopy[i] = copy;

			}

		}

		int choice;

		do{

			//starting the loop

			choice = showMenu();

			switch(choice){

			case 0: System.out.println("Exiting the system...Good Bye");

					System.exit(0);

					break;

			case 1:	//System.out.println("Available books:\n");

					//printBooks(bookName, bookCopy);

					System.out.println("Enter the title of the book you would like to borrow");

					borrowBook(bookName, bookCopy);

					break;

			case 2: System.out.println("Enter the title of the book you would like to return");

					System.out.println("");

					String returningBook = sc.next();

					int index = searchBook(bookName, returningBook);

					System.out.println("The book:\n"+ bookName[index] + "is returned");

					System.out.println("\nAvailable copies for this books:\n" + (bookCopy[index] + 1));

					break;

			default: System.out.println("Wrong choice...! Try again");

			}//end of switch

			int size = i + 1;//number of books

			//finding how many books with copies less than 5

			int a= noOfCopies(bookCopy, size);

			System.out.println("NOTE:\n We have " + a +" books with copies less than 5");

			

			//titles with no available copies

			int n=0;

				if(bookCopy[i]==0){

					System.out.println("We don't have any copies of these books left:\n");

					System.out.println("Book Name :" + bookName[i]);

				

			}

			

		}

		while(choice!=0);//end of the loop

		

		}

	

	//method to find number of books with copies less than 5

	public static int noOfCopies(double bookCopy[], int size){

		int n=0;

		for(int i=0; i<size; i++){

			if(bookCopy[i]<5)

				n++;

		}

		return n;

	}

	

	//method to borrow books

	public static void borrowBook(String bookName[], double bookCopy[]){

		Scanner sc= new Scanner(System.in);

		System.out.println("");

		String wantedBook = sc.next();

		int index = searchBook(bookName,wantedBook);

		if(index == -1){

			System.out.println("This book does not exist");

		}else{

			System.out.println("You are borrowing the book:\n" + bookName[index]);

			System.out.println("Copies left for this book:\n" + (bookCopy[index]- 1));

		}

	}

	//printing arrays method

		public static void printBooks(String bookName[], double bookCopy[]){

			for(int i = 0; i< bookName.length; i++){

				System.out.println(" Book Name : " + bookName + "\nNumber of Copies : " + bookCopy[i]);

			}

		}

	//method to search the bookname, if it exists show the message and if not then display no book

	public static int searchBook(String bookName[], String searchedName){

		for(int i = 0; i<bookName.length; i++){

			if(searchedName.equalsIgnoreCase(bookName[i])){

				return i;

			}

		}

		return -1;

	}

	//method to show menu

	public static int showMenu(){

		Scanner sc = new Scanner(System.in);

		System.out.println("\n1. Borrow a book");

		System.out.println("2. Return a book");

		System.out.println("3. Press 0 to stop");

		int choice = sc.nextInt();

		return choice;

	}

	

	

}
