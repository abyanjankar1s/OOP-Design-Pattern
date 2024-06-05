// Implement the Strategy design pattern.

// The Strategy is a behavioral design pattern that enables selecting 
//an algorithm's runtime behavior. It defines a family of algorithms, 
//encapsulates each one, and makes them interchangeable.

// You are given a Person class with attributes for last name, age, and 
//marital status. Complete the implementation of the following filtering 
//strategies (PersonFilters) to filter Person objects based on different criteria.

// AdultFilter: Filters people who are 18 years or older.
// SeniorFilter: Filters people who are 65 years or older.
// MarriedFilter: Filters people who are married.
// Additionally, complete the implementation of the PeopleCounter 
//class, which uses these strategies to count Person objects based on the specified filter.

class Person {
    private String lastName;
    private int age;
    private boolean isMarried;

    public Person(String lastName, int age, boolean isMarried) {
        this.lastName = lastName;
        this.age = age;
        this.isMarried = isMarried;
    }

    public String getLastName(){
        return lastName;
    }
    public int getAge(){
        return age;
    }
    public boolean isMarried(){
        return isMarried;
    }
}

interface PersonFilter {
    boolean apply(Person person);
}

class AdultFilter implements PersonFilter {
    @Override
    public boolean apply(Person person){
        return person.getAge() >= 18;
    }
}

class SeniorFilter implements PersonFilter {
    @Override
    public boolean apply(Person person){
        return person.getAge() >= 65; 
    }
}

class MarriedFilter implements PersonFilter {
    @Override
    public boolean apply(Person person){
        return person.isMarried();
    }
}

class PeopleCounter {
    private PersonFilter filter;

    public void setFilter(PersonFilter filter) {
        this.filter = filter;
    }
    public int count(List<Person> people) {
        int count = 0;
        for (Person person : people){
            if (filter.apply(person)){
                count++;
            }
        }
        return count;
    }
}


// List<Person> people = Arrays.asList(
//   new Person("Doe", 20, false),
//   new Person("Smith", 30, true),
//   new Person("Old", 70, true)
// );

// PeopleCounter counter = new PeopleCounter();

// counter.setFilter(new AdultFilter());
// counter.count(people); // Adult count: 3

// counter.setFilter(new SeniorFilter());
// counter.count(people); // Senior count: 1

// counter.setFilter(new MarriedFilter());
// counter.count(people); // Married count: 2
