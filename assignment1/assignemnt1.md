# Assignment 1
Frank Ge

INFO 5100

09/18/2020

---
## Course Management System
### Classes:
#### Student
Data: 
- String name
- String studentID
- String email
- String major
- String graduationYear
- Course[] coursesTaking

Behavior: 
- login(String credentials)
- doAssignment(Assignment assignment)
- submitAssignment(Assignment assignment, Course course)
- addCourse(Course course)
- takeExam(Exam exam, Course course)
- watchLecture(CourseSession courseSession)
- contactInstructor(Instructor instructor, String message)
- getAllCourses()
- logout()

#### Instructor
Data: 
- String name
- String instructorID
- String email
- String department
- Course[] coursesTeaching

Behavior:
- login(String credential)
- viewAssignment(Assignment assignment)
- gradeExam(Exam exam)
- startLecture(CourseSession courseSession)
- contactStudent(Student student, String message)
- logout()

#### Course
Data:
- String name
- String courseID
- Instructor instructor
- String description
- int duration
- String startTime
- String endTime

Behavior:
- createCourseSession(String sessionDate)
- createExam(Problem[] examProblems)

#### CourseSession
Data:
- String sessionDate
- String courseSessionID
- String sessionTitle
- String sessionSummary
- String zoomLink

Behavior:
- createAssignment(Assignment assignment)

#### Exam
Data:
- Problem[] problems
- String[] studentAnswers
- String[] instructorNotes
- int duration
- int timeLimit
- int examScore

#### Assignment
Data:
- String prompt
- String solution

#### Problem
Data: 
- String question
- int points

### PseudoCode:

```java
Student frank;
Instructor siva;
Course info5100;
Problems examProblems; 

frank.login(frankLoginCredential)
frankCourseList = frank.getAllCourses()
if info5100 not in frankCourseList:
    frank.addCourse(info5100);
String frankMessage = "Hi Siva, what time do we have class?";
frank.contactInstructor(siva, frankMessage);

siva.login(sivaLoginCredential);
String sivaMessage = "Starting now!";
siva.contactStudent(frank, sivaMessage);

String sessionDate = "09/11/2020";
CourseSession newCourseSession = info5100.createCourseSession(sessionDate);
siva.startLecture(newCourseSession);
frank.watchLecture(newCourseSession);
Assignment assignment = newCourseSession.createAssignment();
assignment = frank.doAssignment(assignment);
frank.submitAssignment(assignment);
siva.viewAssignment(assignment);

Exam info5100Exam = info5100.createExam(examProblems);
info5100Exam = frank.takeExam(info5100Exam);
siva.gradeExam(info5100Exam);

frank.logout();
siva.logout();
```

--- 
## Pet Adoption
### Classes:
#### Pet 
Data:
- String petType
- String name
- String age
- String color
- String[] immunization

Behavior:

#### Customer
Data:
- String name
- String customerId
- String loginCredential
- String email
- String address
- String phoneNumber
- Pet[] interestList

Behavor: 
- login(String credential)
- getInterestList()
- addToInterestList(Pet pet)
- createAdoptionApplication(Pet pet)
- adoptPet(Pet pet)
- logout()

#### AnimalShelter
Data:
- String name
- String shelterId
- String loginCredential
- String email
- String address
- String phoneNumber
- Pet[] fosterPets

Behavior:
- login(String credential)
- addPetToShelter(Pet pet)
- reviewAdoptionApplication(Application application)
- logout()


#### Application
Data:
- String applicationDate
- AnimalShelter shelter
- Customer customer
- Pet pet
- String reviewNotes
- boolean approved

### PseudoCode
```java
Pet toothless;
Pet garfield;
Customer frank;
AnimalShelter shelter;

frank.login(loginCredential);
frank.addToInterestList(toothless);
Pet[] = frank.getInterestList;
Application frankApplication = frank.cerateAdoptionApplication(toothless);

shelter.login(loginCredential);
shelter.addPetToShelter(garfield);
boolean result = shelter.reviewAdoptionApplication(frankApplication);
if result is true 
    frank.adoptPet(toothless);
frank.logout()
shelter.logout()
```

---
## Airline Ticket
### classes
#### Customer
Data:
- String name
- String userId
- String name
- String customerId
- String loginCredential
- String email
- String address
- String phoneNumber
- String creditCardInfo
- Flight[] cart

Behavior:
- login(String credential)
- getCartItems()
- addToCart(Flight flight)
- createOrder(Flight flight)
- placeOrder(BookingOrder order)

#### Flight
Data:
- String flightNumber
- Airline airline
- int duration
- String departureAirport
- String arrivalAirport
- String departureDatetime
- String arrivalDatetime

#### Airline
Data: 
- String airlineName
- String airlineId
- String airlineWebsite

Behavior:
- createFlight(String departureDatetime, String arrivalDatetime, String departureAirport, String arrivalAirport)

#### BookingOrder
Data:
- Flight flight
- int price
- String orderId
- boolean availability

### Pseudocode
```java
Customer frank;
Airline alaska;

frank.login(loginCredential);
Flight[] frankCart= frank.getCartItems()
Flight weekendTrip = alaska.createFlight(departureDatetime, arrivalDatetime, departureAirport, arrival Airport)

if frankCart is empty:
    frank.addToCart(weekendTrip)
Order tripOrder = frank.createOrder(weekendTrip)
if tripOrder is available
    String confirmation = frank.placeOrder(tripOrder)
```

---
## Course Registration
### 
#### Student
Data: 
- String name
- String studentID
- String email
- String major
- String graduationYear
- int totalHours
- Course[] coursesRegistered
- Course[] coursesInPlan

Behavior:
- login(String credential)
- getPlannedCourses()
- getRegisteredCourses()
- addCourseInPlan(Course course)
- registerCourseList()
- logout()

#### Course
Data:
- String name
- String courseID
- Instructor instructor
- String description
- int duration
- String startTime
- String endTime
- Student[] currentlyEnrolled

#### Instructor
Data: 
- String name
- String instructorID
- String email
- String department
- Course[] coursesTeaching

Behavior:
- login(String credential)
- getCoursesTeaching()
- addCoursesTeaching(Course course)

### PseudoCode:
```java
Student frank
Instructor siva;
Course info5100;

frank.login(frankLoginCredential)
frankPlannedCourseList = frank.getAllPlannedCourses()
frankRegisteredCourseList = frank.getRegisteredCourses()
if info5100 not in frankPlannedCourseList
    if info5100 not in frankRegisteredCourseList
        frank.addCourseInPlan(info5100)
        frank.registerCourseList()
frank.logout()

siva.login(sivaLoginCredential)
sivaCoursesTeaching = siva.getCoursesTeaching()
if info5100 not in sivaCoursesTeaching
    siva.addCoursesTeaching(info5100)
siva.logout()
```
--- 
## Food Delivery
### Classes: 
#### Customer
Data:
- String name
- String customerId
- String loginCredential
- String email
- String address
- String phoneNumber
- Dish[] shoppingCart

Behavior:
- login(String credential)
- getShoppingCart()
- addDish(Dish dish)
- createOrder(Dish[] shoppingCart)
- contactCarrier(Carrier carrier)
- checkOrder(Order order)

#### Restaurant
Data:
- String name
- String restaurantAddress
- String restaurantID
- Dish[] menu

Behavior:
- takeOrder(Customer customer, Order order)
- connectCarrier(Carrier carrier)
- addToMenu(Dish dish)
- getMenu()

#### Carrier
Data: 
- String name
- String carrierId
- String phoneNumber
- Order[] currentOrders

Behavior:
- login(String credential)
- deliverOrder(Order order)
- contactCustomer(Customer customer)
- completeDelivery(Order order)

#### Dish
Data:
- String name
- String dishId
- String description
- int price

#### Order
Data:
- String orderId
- Dish[] orderedDish
- String orderedTime
- Customer customer
- Carrier carrier

```java
Dish pasta;
Dish bread;
Dish grilledCheese;
Customer frank;
Carrier newCarrier;
Restaurant newRestaurant;

newRestaurant.addToMenu(pasta);
newRestaurant.addToMenu(bread);
newRestaurant.addToMenu(grilledCheese);
Dish[] menu = newRestaurant.getMenu();

frank.login();
if there is nothing in shoppingCart
    frank.addDish(pasta);
    frank.addDish(bread);
Dish[] shoppingCart = frank.getShoppingCart();
Order frankOrder = frank.createOrder(shoppingCart);
newRestaurant.takeOrder(frank, frankOrder);
newRestaurant.connectCarrier(newCarrier);
newCarrier.deliverOrder(frankOrder);

if newCarrier arrived or delivery delayed
    newCarrier.contactCustomer(customer)

String deliveryTime = frank.checkOrder(frankOrder)
if current time past deliveryTime
    frank.contactCarrier(carrier)
newCarrier.completeDelivery(frankOrder)
frank.logout()
```

