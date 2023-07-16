# Airline Management System

This is an Airline Management System developed in Java using JFrame. The system consists of two sections: user and admin. The admin section allows administrators to manage routes by adding planes and pilots. In the user section, users can view the flight timetable and book flights by specifying the number of tickets in different classes (first class, business class, and economy class).

## Features

- Admin Section:
  - Add routes: Administrators can add routes by assigning planes and pilots to them.
  - Add planes: Administrators can add information about planes, such as the plane name, capacity, and class configuration.
  - Add pilots: Administrators can add details about pilots, including their name, license number, and experience.

- User Section:
  - View timetable: Users can view the flight timetable, which displays the available routes, departure and arrival times, and flight duration.
  - Book flights: Users can book flights by selecting a route and filling out a form with their personal details and the number of tickets they require in each class (first class, business class, economy class).
  - PDF generation: Upon submitting the booking form, a PDF is generated using the iTextPDF library. The PDF includes user details and the total price to be paid for the booked tickets.

## Technologies Used

- Java: The core programming language used for the project.
- JFrame: A Java GUI framework used to build the user interface.
- iTextPDF: A Java library used for generating PDF documents.

## Getting Started

To run the Airline Management System on your local machine, follow these steps:

1. Clone the repository:

   ```shell
   git clone https://github.com/AbdulMohiz-01/airline-management-system.git
   ```

2. Open the project in your preferred Java development environment (e.g., Eclipse, IntelliJ IDEA).

3. Build the project and resolve any dependencies.

4. Run the application.

## Usage

1. Upon launching the application, you will see a login screen where you can choose either the user or admin section.

2. If you select the admin section, you will be prompted to enter your admin credentials.

3. Once logged in as an admin, you can add routes, planes, and pilots as needed.

4. If you select the user section, you will be able to view the flight timetable and book flights.

5. To book a flight, select a route from the timetable and fill out the booking form with the required details.

6. After submitting the form, a PDF will be generated, displaying the user's details and the total price to be paid.

## Contributing

Contributions to the Airline Management System are welcome! If you have any ideas, improvements, or bug fixes, please follow these steps:

1. Fork the repository.

2. Create a new branch for your feature or bug fix.

3. Make the necessary changes and commit them.

4. Push your changes to your forked repository.

5. Submit a pull request describing the changes you made.

## License

The Airline Management System is licensed under the [MIT License](https://opensource.org/licenses/MIT). Feel free to use, modify, and distribute the code as per the terms of the license.

## Acknowledgements

- [iTextPDF](https://itextpdf.com/) - The library used for generating PDF documents.
- [JFrame](https://docs.oracle.com/javase/tutorial/uiswing/) - The Java GUI framework used for building the user interface.

Happy flying! ✈️
