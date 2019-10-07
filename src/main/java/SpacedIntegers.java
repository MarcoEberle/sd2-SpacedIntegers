import java.util.*;

/**
 * This class represents a HashSet with a minimum distance between two numbers.
 */
public class SpacedIntegers {
    /**
     * Minimum distance between two numbers.
     */
    private final int minDistance;

    /**
     * Spaced HashSet.
     */
    private Set<Integer> spacedSet;

    /**
     * Constructor for a new HashSet with a minimum distance between the numbers.
     *
     * @param minDistance
     */
    public SpacedIntegers(int minDistance) {
        if (minDistance < 0) {
            throw new IllegalArgumentException();
        }
        this.minDistance = minDistance;
        spacedSet = new HashSet<>();
    }

    /**
     * Method that adds a single number to the HashSet.
     * Example: If [8,11] is already in our Set and minDistance = 2, and we want to add 10 to it, add() returns false,
     * because between 10 and 11 is only a distance of 1.
     * We run from number we want to add minus minDistance +1 to number we want + minDistance.
     * If there is any number in this range the number wont get added.
     *
     * @param element - Element to be added in the HashSet.
     * @return - Returns true if added, false if not.
     */
    public boolean add(Integer element) {
        final int startCheck = element - getMinDistance() + 1;
        final int endCheck = element + getMinDistance();
        boolean isPossible = true;

        for (int indexCheck = startCheck; indexCheck < endCheck; indexCheck++) {
            if (getSpacedSet().contains(indexCheck)) {
                isPossible = false;
            }
        }

        if (isPossible) {
            getSpacedSet().add(element);
        }
        return isPossible;
    }

    /**
     * Method that tries to add all numbers from the other collections to this collection.
     *
     * @param collection - Other collection with integer numbers saved in it.
     * @return - Returns true if a minimum of 1 number from the other collection was added to this HashSet.
     */
    public boolean addAll(Collection<Integer> collection) {
        Objects.requireNonNull(collection);

        final int oldSize = getSpacedSet().size();
        Iterator<Integer> iterator = collection.iterator();

        while (iterator.hasNext()) {
            add(iterator.next());
        }
        return oldSize < getSpacedSet().size();
    }

    /**
     * Method that calculates the smallest distance between all numbers in the HashSet.
     * The minimum distance is minDistance but it could be bigger.
     * Example: [10,14,20] has 4 as smallest distance.
     * At first we sort the HashSet and after that we calculate the first distance.
     * Next step is to walk through the HashSet and search for a smaller distance than our first smallestDistance.
     *
     * @return - Returns the smallest distance found in the HashSet.
     */
    public int getSmallestDistance() {
        if (getSpacedSet().size() <= 1) {
            return 0;
        }

        List<Integer> sortedSet = new ArrayList<>(getSpacedSet());
        Collections.sort(sortedSet);
        int smallestDistance = sortedSet.get(1) - sortedSet.get(0);
        int tempDistance = 0;

        for (int indexSet = 0; indexSet <= sortedSet.size() - 2; indexSet++) {
            tempDistance = sortedSet.get(indexSet + 1) - sortedSet.get(indexSet);
            if (tempDistance < smallestDistance) {
                smallestDistance = tempDistance;
            }
        }
        return smallestDistance;
    }

    /**
     * Getter for the minimum distance between two numbers.
     *
     * @return - Returns minDistance.
     */
    public int getMinDistance() {
        return minDistance;
    }

    /**
     * Getter for the spaced HashSet.
     *
     * @return - Returns spacedSet.
     */
    public Set<Integer> getSpacedSet() {
        return spacedSet;
    }

    /**
     * This method returns a String with the sorted numbers of the SpacedIntegers HashSet.
     *
     * @return - Returns all numbers in the HashSet.
     */
    @Override
    public String toString() {
        List<Integer> sortedSet = new ArrayList<>(getSpacedSet());
        Collections.sort(sortedSet);
        return sortedSet.toString();
    }
}
