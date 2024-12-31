import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class HorseTest {

@Test
    public void testNullName() {
        Throwable exception = assertThrows(IllegalArgumentException.class, () -> new Horse(null, 3.5));
   assertEquals("Name cannot be null.",exception.getMessage());
    }
    @ParameterizedTest
    @ValueSource(strings = {""," ","\t","\n"})
    public void testBlankName(String name){
        Throwable exception =assertThrows(IllegalArgumentException.class,()-> new Horse(name,3.5));
        assertEquals("Name cannot be blank.",exception.getMessage());
    }

    @Test
    public void testNegativeSpeed(){
        Throwable exception=assertThrows(IllegalArgumentException.class,()->new Horse("Darko",-3.5));
        assertEquals("Speed cannot be negative.", exception.getMessage());

    }
    @Test
    public void testNegativeDistance(){
        Throwable exception=assertThrows(IllegalArgumentException.class,()->new Horse("Darko",3.5,-1.5));
assertEquals("Distance cannot be negative.", exception.getMessage());
    }
    @Test
    public void getName(){
        Horse horse=new Horse("Darko",3.5);
        assertEquals("Darko",horse.getName());
    }
    @Test
    public void getSpeed(){
        Horse horse=new Horse("Darko",3.5);
        assertEquals(3.5,horse.getSpeed());
    }
    @Test
    public void getDistanceThreeParams() {
        Horse horse = new Horse("Darko", 3.5, 5.0);
        assertEquals(5.0, horse.getDistance());
    }
    @Test
    public void getDistanceTwoParams() {
        Horse horse = new Horse("Darko", 3.5);
        assertEquals(0, horse.getDistance());
    }
    @Test
    public void  getRandomDouble(){
        try(MockedStatic<Horse> obj = Mockito.mockStatic(Horse.class)){
            obj.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(1.2);

            Horse.getRandomDouble(0.2, 0.9);
            obj.verify(() -> Horse.getRandomDouble(0.2, 0.9));
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    @Test
    public void move(){
        try(MockedStatic<Horse> obj = Mockito.mockStatic(Horse.class)){
            obj.when(() -> Horse.getRandomDouble(0.2, 0.9)).thenReturn(0.5);

            Horse horse = new Horse("Darko", 3.4);
            double startDistance = horse.getDistance();
            horse.move();

            double check = startDistance + horse.getSpeed() * Horse.getRandomDouble(0.2, 0.9);
            assertEquals(check, horse.getDistance());
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    }

