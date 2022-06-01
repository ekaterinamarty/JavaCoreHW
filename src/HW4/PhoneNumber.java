package HW4;

public class PhoneNumber {
    private String number;

    public PhoneNumber(String number) {
        this.number = number;
    }

    @Override
    public int hashCode() {
        return (number == null) ? 0 : number.hashCode();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        var other = (PhoneNumber) obj;
        if (number == null) {
            return other.number == null;
        }
        return number.equals(other.number);
    }

    @Override
    public String toString() {
        return "PhoneNumber [number=" + number + "]";
    }

    public String getNumber() {
        return number;
    }
}
