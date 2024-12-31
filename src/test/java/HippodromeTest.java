import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.verify;

public class HippodromeTest {
    @Test
    void throwExceptionIfListIsNull() {
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
    }
    @Test
    void showMessageIfListIsNull() {
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Hippodrome(null));
        assertEquals("Horses cannot be null.", exception.getMessage());
    }
    @Test
    void throwExceptionIfListIsEmpty() {
        List<Horse> emptyList = new ArrayList<>();
        assertThrows(IllegalArgumentException.class, () -> new Hippodrome(emptyList));
    }
    @Test
    void showMessageIfListIsEmpty() {
        List<Horse> emptyList = new ArrayList<>();
        IllegalArgumentException exception =
                assertThrows(IllegalArgumentException.class, () -> new Hippodrome(emptyList));
        assertEquals("Horses cannot be empty.", exception.getMessage());
    }
    @Test
    void getHorses() {
        List<Horse> horses = Arrays.asList(
                new Horse("Darko", 3.4),
                new Horse("Thunder", 6.8),
                new Horse("Mustang", 10.3)
        );
        Hippodrome hippodrome = new Hippodrome(horses);

        List<Horse> returnedHorses = hippodrome.getHorses();

        assertEquals(horses, returnedHorses);
    }
    @Test
    public void move(){
        List<Horse> horses = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            Horse horse = Mockito.mock(Horse.class);
            horses.add(horse);
        }

        Hippodrome hippodrome = new Hippodrome(horses);
        hippodrome.move();

        for (Horse horse : horses){
            verify(horse).move();
        }
    }
    @Test
    public void getWinner(){
        Horse darko = new Horse("Darko", 3.4, 1.2);
        Horse thunder = new Horse("Thunder", 6.8, 2.0);
        Horse mustang = new Horse("Mustang", 10.3, 5.0);

        List<Horse> horseList = List.of(darko, thunder, mustang);
        Hippodrome hippodrome = new Hippodrome(horseList);

        Horse winner = hippodrome.getWinner();

        assertEquals(mustang, winner);

    }
}
