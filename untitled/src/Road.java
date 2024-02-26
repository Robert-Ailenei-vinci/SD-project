import java.util.Objects;

public class Road {
    private final City start_city;
    private final City end_city;

    public Road(City start_city, City end_city) {
        this.start_city = start_city;
        this.end_city = end_city;
    }

    public City getStart_city() {
        return start_city;
    }

    public City getEnd_city() {
        return end_city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road roads = (Road) o;
        return start_city == roads.start_city && end_city == roads.end_city;
    }

    @Override
    public int hashCode() {
        return Objects.hash(start_city, end_city);
    }

    @Override
    public String toString() {
        return "Roads{" +
                "start_city=" + start_city +
                ", end_city=" + end_city +
                '}';
    }
}
