import java.time.LocalDate;
import java.util.*;
import java.lang.System;

public class Event{

    //private final int capacity = 200;
    //private HashMap<String, Attendee> seatDetails;


    Scanner reader=new Scanner(System.in);
    public final static int capacity=200;
    HashMap<String,Attendee> seatDetails=new HashMap<>(capacity,0.6f);

    private String eventID;
    private String eventName;
    private LocalDate eventDate;
    private String eventVenue;
    ArrayList<Attendee> eventAttendees=new ArrayList<>();

    public Event(){
        //seatDetails = new HashMap<>(capacity, 0.6f);
    }

    public void setEventID(String id){
        eventID=id;
    }
    public String getEventID(){
        return eventID;
    }

    public void setEventName(String name){
        eventName=name;
    }
    public String getEventName(){
        return eventName;
    }
    
    
    public void setEventVenue(String venue){
        eventVenue=venue;
    }
    public String getEventVenue(){
        return eventVenue;
    }
    
    public void setEventDate(LocalDate date){
        eventDate=date;
    }
    public LocalDate getEventDate(){
        return eventDate;
    }

    public void setAttendeeDetails(String seatNo, Attendee attendee) {
        seatDetails.put(seatNo, attendee);
    }

    // Getter to display attendee details based on seat number
    public Attendee getAttendeeDetails(String seatNo) {
        return seatDetails.get(seatNo);
    }
    
    public void organizeEvent(int choice){

        switch(choice){
            case 1:
                System.out.println("Enter the event ID : ");
                String id =reader.nextLine();
                setEventID(id);

                System.out.println("Enter the event's name : ");
                String eventName =reader.nextLine();
                setEventName(eventName);

                System.out.println("Enter the event date(YYYY-MM-DD) : ");
                LocalDate date =LocalDate.parse(reader.nextLine());
                setEventDate(date);

                System.out.println("Enter the event's venue : ");
                String venue =reader.nextLine();
                setEventVenue(venue);
                break;

            case 2:
                System.out.println("How many attendees: ");
                int num=reader.nextInt();
                reader.nextLine();
                
                for(int i=0;i<num;i++){
                    System.out.println("Enter the name of attendees: ");
                    String name = reader.nextLine();

                    System.out.println("Enter the gender of attendees: ");
                    char gender=reader.nextLine().charAt(0);
                    
                    System.out.println("Enter the age of attendees: ");
                    int age=reader.nextInt();
                    reader.nextLine();

                    System.out.println("Enter the email of attendees: ");
                    String email=reader.nextLine();

                    System.out.println("Enter the seat number of attendees: ");
                    String seatNo=reader.nextLine();

                    eventAttendees.add(new Attendee(name, gender, email, age,seatNo));
                }
                System.out.println("\n"+"All attendees are added.");
                break;

            case 3:
                System.out.println("Enter the name of the attendee to remove: ");
                String NameToRemove=reader.nextLine();

                for(Attendee attendee:eventAttendees){
                    if(NameToRemove.equals(attendee.getName())){
                        eventAttendees.remove(attendee);
                        break;
                    }
                }

                eventAttendees.removeIf(attendee->attendee.getName().equals(NameToRemove));
                System.out.println("\n"+NameToRemove+"is removed.");
                break;

            case 4:
                System.out.println("Enter the name of the attendee you want to update: ");
                
                String nameToUpdate = reader.nextLine();
                
                for(Attendee attendee : eventAttendees) {
                    if(nameToUpdate.equals(attendee.getName())){
                       System.out.println("Enter the new name, or enter null if you don' want to update : ");
                       String newName = reader.nextLine();
                       if(!newName.equals("null")){
                          attendee.setName(newName);
                       }
                       System.out.println("Enter the new age, or enter 0 if you don't want to update :");
                       int newAge = reader.nextInt();
                       reader.nextLine();
                       if(newAge != 0){
                          attendee.setAge(newAge);
                        }
                       System.out.println("Enter the new email, or enter null if you don't want to update :");
                       String newEmail = reader.nextLine();
                       if(!newEmail.equals("null")){
                           attendee.setEmail(newEmail);
                        }
                       System.out.println("Enter the new gender, or enter null if you don't want to update :");
                       String newGender = reader.nextLine();
                       if(!newGender.equals("null")){
                           attendee.setGender(newGender.charAt(0));
                        }

                        System.out.println("Enter the new seat number, or enter null if you don't want to update :");
                        String newSeatNo = reader.nextLine();
                        if(!newEmail.equals("null")){
                            attendee.setEmail(newSeatNo);
                        }

                       break;
                    }
                    else {
                        System.out.println("Invalid position. No update performed.");
                        }
                        break;
                }
               
                break;


            case 5:
                System.out.println("Enter the name of the attendee to find: ");
                String nameToFind=reader.nextLine();

                for(Attendee attendee:eventAttendees){
                    if(attendee.getName().equals(nameToFind)){
                        System.out.println(attendee);
                        System.out.println(nameToFind+" is found.");
                        break;
                    }
                    else {
                        System.out.println("\nIt didn't find.");
                        break;
                    }
                }
                break;

            case 6:
                System.out.println("Here is the list of attendees: "+"\n"+eventAttendees);
                break;
            case 10:
                break;
            case 7:

                HandleComplementaryPasses handleComplementaryPasses=new HandleComplementaryPasses();
                handleComplementaryPasses.handleComplementaryPasses();
            
                break;
            case 8:
                HandlePerformance handlePerformance=new HandlePerformance();
                handlePerformance.handlePerformances();
                break;
            case 9:
                System.out.println("Give the seat number: ");
                String seatNoToFind=reader.nextLine();

                for(Attendee attendee:eventAttendees){
                    if(attendee.getSeatNo().equals(seatNoToFind)){
                        System.out.println(attendee);
                        System.out.println(seatNoToFind+" is found.");
                        break;
                    }
                    else{
                        System.out.println("\nIt didn't find.");
                        break;
                    }
                }

                break;
            default:
                System.out.println("Invalid choice");
                
        }
    }
}