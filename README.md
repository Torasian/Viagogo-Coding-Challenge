

# Viagogo Coding Challenge

## Starting the program

1. In your IDE (prefably eclipe), click on file and then click on import.
2. Click on import from git and choose clone url.
3. Click `Run As` > `Java Application` and choose the `Main` class.
4. The console should then appear.

## Assumptions

1. There is a maximum of 400 events in the world space.
2. There is a minimum of 5 events in the world space (so that we are able to show the 5 nearest events).
3. The first 5 events must have a ticket associated to it (so that we ensure that we have enough events to display).
4. Each event has a maximum of 5 tickets associated to it.
6. The user is within the world space.

## Input

Please note that this program asks for an x coordinate and then a y coordinate as its input. It retricts entries to between 10 and -10. For example, the program would ask:

What is your x coordinate (between 10 and -10)?
 10
What is your y coordinate? 
 5

## Additional questions
### How might you change your program if you needed to support multiple events at the same location?

In our World class, we assign location to each event, however, we remove this location so that no more than on evetn can have the same location. However, if we remove this retriction, multiple events will be able to be allocated to a location. 

It may also be useful to have a location ID to make it easier to identify which events share the same location.

### How would you change your program if you were working with a much larger world size?

So far we have only considered integer cooridnates. However, for a larger world size it may be beter to consider longditude and latitude instead as a more accurate representation of the world space.

It may also be useful to consider a different data structure to store the event data. If we wanted to focus on search speed, we may consider using a hash table. To find minimum and maximum values, using a sorted linked list or sorted array would reduce time in finding the nearest events. 
