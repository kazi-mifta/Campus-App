package com.campusapp.cuet;

import android.view.View;

import java.util.ArrayList;
//TODO 1: In Order To Add Or Remove Modify In This Funtion After Modifying The XML
/**
 * This Is Where The Objects or Items Of The List view Will Be Created by calling Methods from This Class
 */
public class  Item {

    private String department;
    //Add Here
    private String shortName;
    private String interests;
    private String fullName;
    private String universityId;
    private String contactInfo;


    //Unused
    private String date;
    private String time;
    //Bitton
    private View.OnClickListener requestBtnClickListener;

    public Item() {
    }

    //Add in The Funtions Parameter
    public Item(String department, String shortName, String interests, String date, String time,String fullName,String universityId,String contactInfo) {
        this.department = department;

        this.shortName = shortName;
        //Add Here
        this.interests = interests;
        this.fullName=fullName;
        this.universityId=universityId;
        this.contactInfo=contactInfo;


        this.date = date;
        this.time = time;
    }

    //For TitleView
    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }


    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    //Add Here to add things inside List

    public String getInterests() {
        return interests;
    }

    public void setInterests(String interests) {
        this.interests = interests;
    }


    //For ContentView
    public String getFullName(){return fullName;}

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getUniversityId(){return universityId;}

    public void setUniversityId(String universityId) {
        this.universityId = universityId;
    }


    public String getContactInfo(){return contactInfo;}

    public void setContactInfo(String contactInfo){
        this.contactInfo=contactInfo;
    }


    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public View.OnClickListener getRequestBtnClickListener() {
        return requestBtnClickListener;
    }

    public void setRequestBtnClickListener(View.OnClickListener requestBtnClickListener) {
        this.requestBtnClickListener = requestBtnClickListener;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Item item = (Item) o;

        if (interests != item.interests) return false;
        if (department != null ? !department.equals(item.department) : item.department != null) return false;

        if (shortName != null ? !shortName.equals(item.shortName) : item.shortName != null)
            return false;
        if (fullName != null ? !fullName.equals(item.fullName) : item.fullName != null) return false;

        if (universityId != null ? !universityId.equals(item.universityId) : item.universityId != null) return false;

        if (contactInfo != null ? !contactInfo.equals(item.contactInfo) : item.contactInfo != null) return false;

        //Add Here to add inside list
        if (date != null ? !date.equals(item.date) : item.date != null) return false;
        return !(time != null ? !time.equals(item.time) : item.time != null);

    }

    @Override
    public int hashCode() {
        int result = department != null ? department.hashCode() : 0;

        //Add Here to Add Inside List
        result = 31 * result + (shortName != null ? shortName.hashCode() : 0);
        result = 31 * result + (interests != null ? interests.hashCode() : 0);
        result = 31 * result + (fullName != null ? fullName.hashCode() : 0);
        result = 31 * result + (universityId != null ? universityId.hashCode() : 0);
        result = 31 * result + (contactInfo != null ? contactInfo.hashCode() : 0);


        result = 31 * result + (date != null ? date.hashCode() : 0);
        result = 31 * result + (time != null ? time.hashCode() : 0);
        return result;
    }

    /**
     * @return List of elements prepared for tests
     */
    public static ArrayList<Item> getTestingList() {
        ArrayList<Item> items = new ArrayList<>();
        items.add(new Item("CSE", "Deep Blue","Super Computer,Chess Grandmaster", "", "","Deep Blue","CSE-15040000","Mail: deepblue@gmail.com\nMobile: 01600000000\nFB: Deep Blue"));
        items.add(new Item("EEE", "Watson","Cognitive Thinking,Artificial Intelligence", "", "","IBM Watson","CSE-1504999","Mail: watson@gmail.com\nMobile: 01600000000\nFB: Watson"));
        items.add(new Item("ME", "Jarvis","Iron Man Helper, Digital Assistannt", "", "","Jarvis","CSE-1504888","Mail: jarvis@gmail.com\nMobile: 01600000000\nFB: Jarvis"));

        //Add more Here
        return items;

    }

}
