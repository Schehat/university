package de.hsh.dbs2.imdb.logic;

import java.util.ArrayList;
import java.util.List;

import de.hsh.dbs2.imdb.logic.dto.*;
import records.ConnectionManager;
import records.Genre;
import records.Movie;
import records.MovieCharacter;
import records.MovieGenre;
import records.Person;

public class MovieManager {

	/**
	 * Ermittelt alle Filme, deren Filmtitel den Suchstring enthaelt.
	 * Wenn der String leer ist, sollen alle Filme zurueckgegeben werden.
	 * Der Suchstring soll ohne Ruecksicht auf Gross/Kleinschreibung verarbeitet werden.
	 * @param search Suchstring. 
	 * @return Liste aller passenden Filme als MovieDTO
	 * @throws Exception
	 */
	public List<MovieDTO> getMovieList(String search) throws Exception {
		System.out.println("getMovieList");
		
		return new ArrayList<>();
	}

	/**
	 * Speichert die uebergebene Version des Films neu in der Datenbank oder aktualisiert den
	 * existierenden Film.
	 * Dazu werden die Daten des Films selbst (Titel, Jahr, Typ) beruecksichtigt,
	 * aber auch alle Genres, die dem Film zugeordnet sind und die Liste der Charaktere
	 * auf den neuen Stand gebracht.
	 * @param movie Film-Objekt mit Genres und Charakteren.
	 * @throws Exception
	 */
	public void insertUpdateMovie(MovieDTO movieDTO) throws Exception {
		// TODO
	}

	/**
	 * Loescht einen Film aus der Datenbank. Es werden auch alle abhaengigen Objekte geloescht,
	 * d.h. alle Charaktere und alle Genre-Zuordnungen.
	 * @param movie
	 * @throws Exception
	 */
	public void deleteMovie(long movieId) throws Exception {
		// TODO Auto-generated method stub
	}

	/**
	 * Liefert die Daten eines einzelnen Movies zurück
	 * @param movieId
	 * @return
	 * @throws Exception
	 */
	public MovieDTO getMovie(long movieId) throws Exception {
	    System.out.println("getMovie");
	    boolean ok = false;
        MovieDTO mDTO = new MovieDTO();
	    try {
    		Movie movie = records.MovieFactory.findByMovieId(movieId);
    		
    		mDTO.setId(movie.getMovieId());
    		mDTO.setTitle(movie.getTitle());
    		mDTO.setType(String.valueOf(movie.getType()));
    		mDTO.setYear(movie.getYear());
    		
    		ArrayList<MovieGenre> mgs = records.MovieGenreFactory.findByMovieGenreAll();
    		for (MovieGenre mg : mgs) {
    		    if (mg.getMovieId().equals(movie.getMovieId())) {
    		        Genre genre = records.GenreFactory.findByGenreId(mg.getGenreId());
    		        mDTO.addGenre(genre.getGenre());
    		    }
    		}
    		
    		ArrayList<MovieCharacter> mcs = records.MovieCharacterFactory.findByMovieCharacterAll();
    		for (MovieCharacter mc : mcs) {
    		    if (mc.getMovieId().equals(movie.getMovieId())) {
    		        CharacterDTO cDTO = new CharacterDTO();
    		        cDTO.setCharacter(mc.getCharacter());
    		        cDTO.setAlias(mc.getAlias());
    		        
    		        Person person = records.PersonFactory.findByPersonId(mc.getPersonId());
    		        
    		        cDTO.setPlayer(person.getName());
    		        mDTO.addCharacter(cDTO); 
    		    }
    		}
	    } finally {
	        if (!ok)
                ConnectionManager.getConnection().rollback();
            }
		return mDTO;
	}

}
