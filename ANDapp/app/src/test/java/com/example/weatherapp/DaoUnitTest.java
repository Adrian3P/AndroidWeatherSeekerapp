package com.example.weatherapp;

import androidx.arch.core.executor.testing.InstantTaskExecutorRule;

import com.example.weatherapp.connection.Dao;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.TestRule;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class DaoUnitTest {
    /*private Dao dao;

    @Rule
    public TestRule rule = new InstantTaskExecutorRule();

    @Before
    public void setUp() {
        dao = Dao.getInstance();
    }
    @Test
    public void checkIfNull() {
        assertEquals(1, dao.getSize());
    }
    @Test
    public void additem() {
        dao.addFavCity("London");
        assertEquals(2, dao.getSize());
    }
    @Test
    public void removeItem() {
        dao.deleteFavCity("Horsens");
        assertEquals(1, dao.getSize());
    }
    @Test
    public void checkIfCityAdded() {
        dao.addFavCity("Paris");
        assertTrue(dao.checkCity("Paris"));
    }
    @Test
    public void setUnit() {
        dao.setUnit("F");
        assertEquals("F", dao.getUnit().getValue());
    }

     */
}