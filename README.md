# Anna's Awesome Airfield
## An Object Oriented Jets Application
<img src = "https://www.pinclipart.com/picdir/big/529-5296807_clipart-airplane-tower-airport-clipart-transparent-png-download.png" alt="aircraft taking off from airport" />

### Description

This application creates an airfield that has a fleet of jets with different capabilities. The fleet of jet information is kept in a text file in the project folder and is read in upon the start of the application. The application has an interactive menu that allows the user to navigate through the following options:
<ol>
    <li>List the fleet</li>
    <li>Fly the aircrafts - includes submenu to select which aircraft to fly.</li>
    <li>View the fastest jet</li>
    <li>View the jet with the longest range</li>
    <li>Load all the Cargo Jets</li>
    <li>Dogfight! (All the fighter jets fight)</li>
    <li>Add a jet to the Fleet - includes submenu to specify which type of jet they're adding. After the jet is created the user then either picks an available pilot or has one randomly assigned to their new jet.</li>
    <li>Remove a jet from the Fleet</li>
    <li>Quit</li>
</ol>


---

### Topics and Technologies Used
<ul>
    <li>Input Streams - Initial jet data was read from a local file into an ArrayList to be used by the application.</li>
    <li>Exceptions - Try and Catch blocks were used when user input was being assigned to variables.</li>
    <li> Object Oriented Programming
        <ul>
            <li>Iterfaces - Two interfaces were used to provide different functionality to the two classes of jets. The CargoCarrier interface allowed classes that implemented it to define what it meant to loadCargo() with an object of that class. There was also the CombatReady interface that allowed implementing classes to define what it was to fight() with that class object.</li>
            <li>Inheritance - The Jet class itself was abstract. This superclass allowed us to use ListArrays to hold Jet objects that would include any of the extending subclasses of jets. The Jet class included an abstract method fly(), so each of the extending classes had to define what it meant to fly an object of the subclass. I used a 'generic' JetImplementation class to create objects as I read in the intial data from the file to the ArrayList of Jets. Then I replaced the objects with objects of a classes that implemented an interface using a constructor method that used a 'generic' JetImplementation object as a parameter.</li>
            <li>UML Diagram - Initial diagram provided within the instructions was used to plan out the minimum viable product. During writing of the code, any updates to the methods within the clases were updated on the paper diagram that I was using for my own code. For the push projects of adding Pilots, the planning of class interactions was all done on the paper UML Diagram before any coding began.</li>
        </ul>
    </li>
</ul>

---

### How to Run
Run the application from the JetsApplication.java file.

---

### Lessons Learned

I learned with having users specify the name of the aircraft they wanted to delete that I needed to normalize the input before searching the list. I did this through using the .trim() and .equalsIgnoreCase() methods within the digestion of the information. 

For the removal of the jet from the fleet, in order to use the .removeIf() function, I learned how to use Predicate. This let me set a condition that would remove all the instances of the model being named what the user specified at input.

When it came to efficiently searching the fleet for the fastest and longest range jet, I learned how to use the Comparator.comparing() method within Collections.max(). This returned the object that was the maximum for the object field I specified within the comparing() method.