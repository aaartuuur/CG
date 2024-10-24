package ru.vsu.cs.shkoda;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions;
import ru.vsu.cs.shkoda.math.Vector2f;

public class testMath {
    @Test
    //норм название для тестов
    public void test1(){
        Vector2f v= new Vector2f(3, 4);
        final Vector2f result = v.multiply(4);
        final Vector2f expectedResult = new Vector2f(12, 16);
        Assertions.assertTrue(result.equals(expectedResult));
    }
}
