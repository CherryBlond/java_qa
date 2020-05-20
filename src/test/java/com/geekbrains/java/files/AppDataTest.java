package com.geekbrains.java.files;

import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class AppDataTest {
    @Test
    public void dataTest() {
        AppData data = new AppData();
        data.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
        Assert.assertEquals("Value 2", data.getHeader()[1]);

        data.setData(new int[][]{{100, 200, 123}, {300, 400, 500}});
        Assert.assertEquals(123, data.getData()[0][2]);
    }

    @Test
    public void readDataTest() {
        AppData data = new AppData();
        Assert.assertTrue(data.read("src/test/resources/test-read.csv"));
        Assert.assertEquals("Class number", data.getHeader()[0]);
        Assert.assertEquals("Students count", data.getHeader()[1]);
        Assert.assertEquals("Minimum age", data.getHeader()[2]);

        Assert.assertEquals(1, data.getData()[0][0]);
        Assert.assertEquals(23, data.getData()[0][1]);
        Assert.assertEquals(8, data.getData()[0][2]);

        Assert.assertEquals(2, data.getData()[1][0]);
        Assert.assertEquals(20, data.getData()[1][1]);
        Assert.assertEquals(9, data.getData()[1][2]);

        Assert.assertEquals(5, data.getData()[2][0]);
        Assert.assertEquals(18, data.getData()[2][1]);
        Assert.assertEquals(12, data.getData()[2][2]);
    }

    @Test
    public void saveDataTest() throws Exception {
        String filePath = "src/test/resources/test-write.csv";
        AppData data = new AppData();
        data.setHeader(new String[]{"Value 1", "Value 2", "Value 3"});
        data.setData(new int[][]{{100, 200, 123}, {300, 400, 500}});

        Assert.assertTrue(data.save(filePath));
        List<String> allLines = Files.readAllLines(Paths.get(filePath));
        Assert.assertEquals("Value 1;Value 2;Value 3", allLines.get(0));
        Assert.assertEquals("100;200;123", allLines.get(1));
        Assert.assertEquals("300;400;500", allLines.get(2));

        data.setData(new int[][]{{300, 400, 500}, {600, 700, 800}});
        Assert.assertTrue(data.save(filePath));
        allLines = Files.readAllLines(Paths.get(filePath));
        Assert.assertEquals("Value 1;Value 2;Value 3", allLines.get(0));
        Assert.assertEquals("300;400;500", allLines.get(1));
        Assert.assertEquals("600;700;800", allLines.get(2));
    }
}
