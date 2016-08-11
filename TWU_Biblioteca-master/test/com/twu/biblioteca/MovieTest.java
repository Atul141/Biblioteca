package com.twu.biblioteca;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

// Test For Movie Class
public class MovieTest {

	@Test
	public void shouldBeAbleToCreateMovie() {
		Movie movie = new Movie(1, "2012", "Roland", 2012, 6);
		assertEquals(movie.getClass(), Movie.class);
	}

	@Test
	public void shouldBeAbleToVerifyIfMovieDetailsAreDisplayed() {
		Movie movie = new Movie(1, "2012", "Roland", 2012, 6);
		assertEquals("1    2012           Roland         2012   6\n", movie.getDetails());

	}
}
