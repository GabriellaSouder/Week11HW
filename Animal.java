import java.util.List;
import java.util.Random;

/**
 * A class representing shared characteristics of animals.
 * 
 * @author David J. Barnes and Michael Kölling
 * @version 2016.02.29 (2)
 */
public abstract class Animal
{
    // Whether the animal is alive or not.
    private boolean alive;
    // The animal's field.
    private Field field;
    // The animal's position in the field.
    private Location location;
    //The animal's age (12.45)
    private int age;
    
    /**
     * Create a new animal at location in field.
     * 
     * @param field The field currently occupied.
     * @param location The location within the field.
     */
    public Animal(Field field, Location location)
    {
        age = 0;
        alive = true;
        this.field = field;
        setLocation(location);
    }
    
    //Returns the age of the animals (12.45)
    public int getAge(){
        return age;
    }
    
    //Sets the age of the animals (12.45)
    public void setAge(int newAnimalAge){
        this.age = newAnimalAge;
    }
    
    //Gets the breeding age as a protected method (12.46)
    abstract protected int getBreedingAge();
    
    //Returns the animals breeding age (12.46)
    public boolean canBreed()
    {
        return getAge() >= getBreedingAge();
    }
    
    //Gets the max age for the animals as a protected method
    abstract protected int getMaxAge(); //(12.47)
    
    //Adds a year to the animals age if it is before the max age
    public void incrementAge() //(12.47)
    {
        age++;
        if(age > getMaxAge()) {
            setDead();
        }
    }
    
    //Gets the breeding probability of the animal (12.48)
    abstract protected double getBreedingProbability();
    
    //gets the max litter size of the animals (12.48)
    abstract protected int getMaxLitterSize();

    //Allows to use random
    protected static final Random rand = Randomizer.getRandom(); //(12.48)
    
    /**
     * Generate a number representing the number of births,
     * if it can breed.
     * @return The number of births (may be zero).
     */
    protected int breed(){
        int births = 0;
        if(canBreed() && rand.nextDouble() <= getBreedingProbability()) {
            births = rand.nextInt(getMaxLitterSize()) + 1;
        }
        return births;
    }
    
    /**
     * Make this animal act - that is: make it do
     * whatever it wants/needs to do.
     * @param newAnimals A list to receive newly born animals.
     */
    abstract public void act(List<Animal> newAnimals);

    /**
     * Check whether the animal is alive or not.
     * @return true if the animal is still alive.
     */
    protected boolean isAlive()
    {
        return alive;
    }

    /**
     * Indicate that the animal is no longer alive.
     * It is removed from the field.
     */
    protected void setDead()
    {
        alive = false;
        if(location != null) {
            field.clear(location);
            location = null;
            field = null;
        }
    }

    /**
     * Return the animal's location.
     * @return The animal's location.
     */
    protected Location getLocation()
    {
        return location;
    }
    
    /**
     * Place the animal at the new location in the given field.
     * @param newLocation The animal's new location.
     */
    protected void setLocation(Location newLocation)
    {
        if(location != null) {
            field.clear(location);
        }
        location = newLocation;
        field.place(this, newLocation);
    }
    
    /**
     * Return the animal's field.
     * @return The animal's field.
     */
    protected Field getField()
    {
        return field;
    }
}
