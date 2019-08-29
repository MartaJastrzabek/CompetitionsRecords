public class Competitor implements Comparable<Competitor>{
    private String firstName;
    private String lastName;
    private int result;

    public Competitor(String firstName, String lastName, int result) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.result = result;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public int getResult() {
        return result;
    }

    @Override
    public String toString() {
        return firstName + " " + lastName + " wynik: " + result;
    }

    @Override
    public int compareTo(Competitor c) {
        if (c == null)
            return 1;

        if(this.result > c.result)
            return 1;
        else if(this.result == c.result)
            return this.lastName.compareTo(c.lastName);
        else
            return -1;
    }
}
