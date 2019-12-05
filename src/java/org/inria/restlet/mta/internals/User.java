package org.inria.restlet.mta.internals;

import java.util.ArrayList;

/**
 *
 * User
 *
 * @author ctedeschi
 * @author msimonin
 *
 */
public class User
{

    /** Internal id of the user.*/
    private int id_;

    /** Name of the user.*/
    private String name_;

    /** Age of the user.*/
    private int age_;

    /** To be added: collection of tweets of the user. */
	
	private ArrayList<Tweet> tweets;

    public User(String name, int age)
    {
        name_ = name;
        age_ = age;
		this.tweets = new ArrayList<Tweet>();
    }
	
	public ArrayList<Tweet> getTweets(){
		return this.tweets;
	}

    public String getName()
    {
        return name_;
    }

    public void setName(String name)
    {
        name_ = name;
    }

    public int getAge()
    {
        return age_;
    }

    public void setAge(int age)
    {
        age_ = age;
    }

    public int getId()
    {
        return id_;
    }

    public void setId(int id)
    {
        id_ = id;
    }

}
