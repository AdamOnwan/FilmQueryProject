package com.skilldistillery.filmquery.app;

import java.util.*;

import com.skilldistillery.filmquery.database.*;
import com.skilldistillery.filmquery.entities.*;

public class FilmQueryApp {
	private Film film = new Film();
	private List<Film> films = new ArrayList<Film>();

	DatabaseAccessor db = new DatabaseAccessorObject();

	public static void main(String[] args) {
		FilmQueryApp app = new FilmQueryApp();
//    app.test();
		app.launch();
	}

//  this is for testing setup of application, then be menu driven
//  private void test() {
//    Film film = db.findFilmById(1);
//    System.out.println(film);
//  }

	private void launch() {
		Scanner input = new Scanner(System.in);

		startUserInterface(input);

		input.close();
	}

	private void startUserInterface(Scanner input) {

		boolean keepGoing = true;

		while (keepGoing) {
			System.out.println(
					"Enter a number (1) Lookup film by its ID or (2) Lookup film by search (3) Exit the application");
			String choice = input.next();
			switch (choice) {
			case "1":
				System.out.println("select film ID");
				int filmId = input.nextInt();
				film = db.findFilmById(filmId);
				if (film == null) {
					System.out.println("film not found");
				} else {
					System.out.println(film);

				}
				break;
			case "2":
				System.out.println("type part of the title or description of the film");
				String filmSearch = input.next();
				films = db.findFilmBySearchWord(filmSearch);
				if (films.size() == 0) {
					System.out.println("film not found");
				} else {
					System.out.println(films);
				}
				break;
			case "3":
				System.out.println("create film");
				Film film = new Film();
				System.out.println("insert title");
				film.setTitle(input.next());
				System.out.println("insert description");
				film.setDescription(input.next());
				System.out.println("insert release year");
				film.setReleaseYear(input.nextInt());
				System.out.println("insert rating");
				film.setRating(input.next());
				film.setLanguageId(1);
				db.createFilm(film);
				break;
			case "4":
				System.out.println("delete film");
				break;
			case "5":
				System.out.println("Exiting application");
				keepGoing = false;
				break;
			default:
				System.out.println("Invalid entry");
				break;
			}
		}
	}
}
