package com.geekbrains.java.generics;

import org.junit.Assert;
import org.junit.Test;

public class FruitsTest
{
    @Test
    public void testBoxWeight()
    {
        FruitsBox<Apple> boxOfApples = new FruitsBox<>();
        boxOfApples.put(new Apple());
        boxOfApples.put(new Apple());
        Assert.assertEquals(2.0, boxOfApples.getWeight(), 0.0001);

        boxOfApples.put(new Apple());
        Assert.assertEquals(3.0, boxOfApples.getWeight(), 0.0001);

        FruitsBox<Orange> boxOfOranges = new FruitsBox<>();
        boxOfOranges.put(new Orange());
        boxOfOranges.put(new Orange());
        Assert.assertEquals(3.0, boxOfOranges.getWeight(), 0.0001);

        boxOfOranges.put(new Orange());
        Assert.assertEquals(4.5, boxOfOranges.getWeight(), 0.0001);
    }

    @Test
    public void testBoxCompare()
    {
        FruitsBox<Apple> boxOfApples = new FruitsBox<>();
        FruitsBox<Orange> boxOfOranges = new FruitsBox<>();

        boxOfApples.put(new Apple());
        boxOfApples.put(new Apple());
        boxOfApples.put(new Apple());

        boxOfOranges.put(new Orange());
        boxOfOranges.put(new Orange());

        Assert.assertTrue(boxOfApples.compare(boxOfOranges));

        boxOfApples.put(new Apple());
        Assert.assertFalse(boxOfApples.compare(boxOfOranges));
    }

    @Test
    public void testBoxPutAll()
    {
        FruitsBox<Apple> boxOfApples1 = new FruitsBox<>();
        boxOfApples1.put(new Apple());
        boxOfApples1.put(new Apple());

        FruitsBox<Apple> boxOfApples2 = new FruitsBox<>();
        boxOfApples2.put(new Apple());
        boxOfApples2.put(new Apple());
        boxOfApples2.put(new Apple());

        Assert.assertEquals(2.0, boxOfApples1.getWeight(), 0.0001);
        Assert.assertEquals(3.0, boxOfApples2.getWeight(), 0.0001);

        boxOfApples1.putAll(boxOfApples2);

        Assert.assertEquals(5.0, boxOfApples1.getWeight(), 0.0001);
        Assert.assertEquals(0.0, boxOfApples2.getWeight(), 0.0001);
    }
}
