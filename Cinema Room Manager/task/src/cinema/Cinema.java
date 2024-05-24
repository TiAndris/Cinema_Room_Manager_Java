package cinema;

import java.util.Scanner;

public class Cinema {

    public static void main(String[] args) {
        // Write your code here
        Scanner scanner = new Scanner(System.in);
        // start coding here
        System.out.println("Enter the number of rows:");
        int rows = scanner.nextInt();
//        System.out.println(rows);
        System.out.println("Enter the number of seats in each row:");
        int seats = scanner.nextInt();
//        System.out.println(seats);
        String[][] cinemaPlaces = new String[rows][seats];
        for (int i = 0; i <rows; i++){
            for (int j = 0; j < seats; j++){
                cinemaPlaces[i][j] = " S";
            }
        }

        int selectedValue = -1;
        while (selectedValue !=0){
            System.out.println();
            System.out.println("1. Show the seats");
            System.out.println("2. Buy a ticket");
            System.out.println("3. Statistics");
            System.out.println("0. Exit");
            selectedValue = scanner.nextInt();
            switch (selectedValue) {
                case 1 -> showSits(cinemaPlaces);
                case 2 -> buyTicket(cinemaPlaces, rows, seats);
                case 3 -> statistics(cinemaPlaces, rows, seats);
            }
        }

        /*System.out.println();
        System.out.println("Cinema: ");
        for (int i = 1; i<seats+1; i++){
            System.out.print(" "+i);
        }
        System.out.println();
        for (int i = 1; i<rows+1; i++){
            System.out.print(i + " ");
            for (int j = 1; j<seats+1; j++){
                System.out.print("S ");
            }
            System.out.println();
        }
        System.out.println();

        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
//        System.out.println(row);

        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
//        System.out.println(seat);


        System.out.println();
        int income = rows*seats*10;
        int price = 10;
        if (income > 600){
//            income -= ((rows+1)/2)*seats*2;
            if (row>=((rows+1)/2)){
                price = 8;
            }
        }
//        System.out.println("Total income:");
//        System.out.println("$"+ income);
        System.out.println("Ticket price: $"+price);
        System.out.println();

        System.out.println("Cinema: ");
        for (int i = 1; i<seats+1; i++){
            System.out.print(" "+i);
        }
        System.out.println();
        for (int i = 1; i<rows+1; i++){
            System.out.print(i + " ");
            for (int j = 1; j<seats+1; j++){
                if (i==row && j==seat){
                    System.out.print("B ");
                } else {
                    System.out.print("S ");
                }
            }
            System.out.println();
        }*/
    }
    private static void showSits(String[][] cinemaPlaces){
        System.out.println("Cinema: ");
        System.out.print("");
        for (int i = 1; i <= cinemaPlaces[0].length; i++){
            System.out.print(i + " ");
        }
        System.out.println();
        for (int i = 0; i < cinemaPlaces.length; i++){
            System.out.print(i+1);
            for (int j = 0; j < cinemaPlaces[i].length; j++){
                System.out.print(""+ cinemaPlaces[i][j]);
            }
            System.out.println();
        }
    }

    private static void buyTicket(String[][] cinemaPlaces, int rows, int seats){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter a row number:");
        int row = scanner.nextInt();
        if (row > rows || row <= 0){
            System.out.println("Wrong input!");
            buyTicket(cinemaPlaces, rows, seats);
        }
//        System.out.println(row);

        System.out.println("Enter a seat number in that row:");
        int seat = scanner.nextInt();
        if (seat > seats || seat <= 0){
            System.out.println("Wrong input!");
            buyTicket(cinemaPlaces, rows, seats);
        }
//        System.out.println(seat);
        if(cinemaPlaces[row-1][seat-1].equals(" B")){
            System.out.println("That ticket has already been purchased!");
            buyTicket(cinemaPlaces, rows, seats);
        } else {
            cinemaPlaces[row-1][seat-1] = " B";
            checkPrice(cinemaPlaces, row);
        }

    }

    private static void checkPrice(String[][] cinemaPlaces, int row){
        int income = cinemaPlaces.length * cinemaPlaces[0].length*10;
        int price = 10;
        if (income > 600){
//            price -= ((rows+1)/2)*seats*2;
            if (row>=((cinemaPlaces.length+1)/2)){
                price = 8;
            }
        }
        System.out.println("Ticket price: $" + price);
    }

    private static void statistics(String[][] cinemaPlaces, int rows, int seats){
        int totalSeats = rows*seats;
        int totalIncome = totalSeats <= 60 ? totalSeats * 10 : (rows/2) * seats * 10 + (rows - rows/2) * seats * 8;
        int purchasedTickets = 0;
        int currentIncome = 0;

        for (int i = 0; i < rows; i++){
            for (int j = 0; j < seats; j++){
                if (cinemaPlaces[i][j].equals(" B")){
                    purchasedTickets++;
                    if (totalSeats <= 60){
                        currentIncome += 10;
                    } else {
                        currentIncome += i >= rows / 2 ? 10 : 8;
                    }
                }
            }
        }

        double percentage = (double)purchasedTickets/totalSeats*100;

        System.out.println("Number of purchased tickets: " + purchasedTickets);
        System.out.printf("Percentage: %.2f%%\n", percentage);
        System.out.println("Current income: $" + currentIncome);
        System.out.println("Total income: $" + totalIncome);
    }
}

//public class Cinema {
//    public static void main(String[] args) {
//        Scanner scanner = new Scanner(System.in);
//
//        System.out.println("Enter the number of rows:");
//        int rows = scanner.nextInt();
//
//        System.out.println("Enter the number of seats in each row:");
//        int seats = scanner.nextInt();
//
//        String[][] cinemaPlaces = new String[rows][seats];
//
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < seats; j++) {
//                cinemaPlaces[i][j] = " S";
//            }
//        }
//
//        int option;
//        int totalSeats = rows * seats;
//        int totalIncome = totalSeats <= 60 ? totalSeats * 10 : (rows / 2) * seats * 10 + (rows - rows / 2) * seats * 8;
//        int purchasedTickets = 0;
//        int currentIncome = 0;
//
//        do {
//            System.out.println();
//            System.out.println("1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
//            option = scanner.nextInt();
//
//            switch (option) {
//                case 1:
//                    System.out.println("\nCinema:");
//                    System.out.print(" ");
//                    for (int i = 1; i <= seats; i++) {
//                        System.out.print(" " + i);
//                    }
//                    System.out.println();
//
//                    for (int i = 0; i < rows; i++) {
//                        System.out.print((i + 1));
//                        for (int j = 0; j < seats; j++) {
//                            System.out.print(cinemaPlaces[i][j]);
//                        }
//                        System.out.println();
//                    }
//                    break;
//
//                case 2:
//                    int ticketPrice = 0;
//                    boolean validSeat = false;
//                    do {
//                        System.out.println("\nEnter a row number:");
//                        int rowNumber = scanner.nextInt();
//                        System.out.println("Enter a seat number in that row:");
//                        int seatNumber = scanner.nextInt();
//
//                        if (rowNumber < 1 || rowNumber > rows || seatNumber < 1 || seatNumber > seats) {
//                            System.out.println("Wrong input!");
//                            continue;
//                        }
//
//                        if (cinemaPlaces[rowNumber - 1][seatNumber - 1].equals(" B")) {
//                            System.out.println("That ticket has already been purchased!");
//                            continue;
//                        }
//
//                        validSeat = true;
//                        cinemaPlaces[rowNumber - 1][seatNumber - 1] = " B";
//                        purchasedTickets++;
//
//                        if (totalSeats <= 60) {
//                            ticketPrice = 10;
//                        } else {
//                            ticketPrice = rowNumber <= rows / 2 ? 10 : 8;
//                        }
//                        currentIncome += ticketPrice;
//                        System.out.println("Ticket price: $" + ticketPrice);
//
//                    } while (!validSeat);
//                    break;
//
//                case 3:
//                    double percentage = (double) purchasedTickets / totalSeats * 100;
//                    System.out.println("\nNumber of purchased tickets: " + purchasedTickets);
//                    System.out.printf("Percentage: %.2f%%\n", percentage);
//                    System.out.println("Current income: $" + currentIncome);
//                    System.out.println("Total income: $" + totalIncome);
//                    break;
//
//                case 0:
//                    break;
//
//                default:
//                    System.out.println("Wrong input!");
//                    break;
//            }
//
//        } while (option != 0);
//
//        scanner.close();
//    }
//}