/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package login_register_design;

public class Event_User {
    private int id;
    private String type;
    private String name;
    private String venue;
    private String address;
    private String city;
    private int customerid;
    private String customerideas;
    
    public Event_User(int Id,String Type,String Name,String Venue,String Address,String City,int Customerid,String Customerideas){
        this.id = Id;
        this.type = Type;
        this.name = Name;
        this.venue = Venue;
        this.address = Address;
        this.city = City;
        this.customerid = Customerid;
        this.customerideas = Customerideas;
        
        
    }
    
    public int getId(){
        return id;
        
    }
    public String getType(){
        return type;
    }
    public String getName(){
        return name;
    }
    public String getVenue(){
        return venue;
    }
    public String getAddress(){
        return address;
    }
    public String getCity(){
        return city;
    }
    public int getCustomerid(){
        return customerid;
    }
    public String getCustomerideas(){
        return customerideas;
    }
        
}
    

