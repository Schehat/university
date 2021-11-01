package records;
import java.sql.SQLException;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) throws SQLException {
        testInsert();
    }
    
    public static void testInsert() throws SQLException {
        boolean ok = false;
        try {
            Person person = new Person();
            person.setName("Deti");
            person.setSex('F');
            person.insert();
            
            Person p = PersonFactory.findByPersonId(person.getPersonId());
            System.out.println(p.getName());
            
            ArrayList<Person> ps = PersonFactory.findByPersonAll();
            for (Person p_s : ps) {
                System.out.println(p_s.getName());
            }
            
            Movie movie = new Movie();
            movie.setTitle("Slow");
            movie.setYear(2012);
            movie.setType('S');
            movie.insert();
            
            Movie m = MovieFactory.findByMovieId(movie.getMovieId());
            System.out.println(m.getTitle());
            
            ArrayList<Movie> ms = MovieFactory.findByMovieAll();
            for (Movie m_s : ms) {
                System.out.println(m_s.getTitle());
            }
            
            MovieCharacter chr = new MovieCharacter();
            chr.setMovieId(movie.getMovieId());
            chr.setPersonId(person.getPersonId());
            chr.setCharacter("Hauptrolle");
            chr.setAlias(null);
            chr.setPosition(1);
            chr.insert();
            
            MovieCharacter mc = MovieCharacterFactory.findByMovieCharacterId(chr.getMovCharId());
            System.out.println(mc.getCharacter());
            
            ArrayList<MovieCharacter> mcs = MovieCharacterFactory.findByMovieCharacterAll();
            for (MovieCharacter mc_s : mcs) {
                System.out.println(mc_s.getCharacter());
            }
            
            Genre genre = new Genre();
            genre.setGenre("Romantic");
            genre.insert();

            Genre g = GenreFactory.findByGenreId(genre.getGenreId());
            System.out.println(g.getGenre());
            
            ArrayList<Genre> gs = GenreFactory.findByGenreAll();
            for (Genre g_s : gs) {
                System.out.println(g_s.getGenre());
            }
            
            MovieGenre movieGenre = new MovieGenre();
            movieGenre.setGenreId(genre.getGenreId());
            movieGenre.setMovieId(movie.getMovieId());
            movieGenre.insert();
            
            MovieGenre mg = MovieGenreFactory.findByMovieIdAndGenreId(movie.getMovieId(), genre.getGenreId());
            System.out.println(mg.getGenreId());
            
            ArrayList<MovieGenre> mgs = MovieGenreFactory.findByMovieGenreAll();
            for (MovieGenre mg_s : mgs) {
                System.out.println(mg_s.getGenreId());
            }
            
            
            person = new Person();
            person.setName("Schehat");
            person.setSex('M');
            person.insert();
            
            p = PersonFactory.findByPersonId(person.getPersonId());
            System.out.println(p.getName());
            
            ps = PersonFactory.findByPersonAll();
            for (Person p_s : ps) {
                System.out.println(p_s.getName());
            }
            
            movie = new Movie();
            movie.setTitle("Fast");
            movie.setYear(2019);
            movie.setType('C');
            movie.insert();
            
            m = MovieFactory.findByMovieId(movie.getMovieId());
            System.out.println(m.getTitle());
            
            ms = MovieFactory.findByMovieAll();
            for (Movie m_s : ms) {
                System.out.println(m_s.getTitle());
            }
            
            chr = new MovieCharacter();
            chr.setMovieId(movie.getMovieId());
            chr.setPersonId(person.getPersonId());
            chr.setCharacter("Hauptrolle");
            chr.setAlias(null);
            chr.setPosition(1);
            chr.insert();
            
            mc = MovieCharacterFactory.findByMovieCharacterId(chr.getMovCharId());
            System.out.println(mc.getCharacter());
            
            mcs = MovieCharacterFactory.findByMovieCharacterAll();
            for (MovieCharacter mc_s : mcs) {
                System.out.println(mc_s.getCharacter());
            }
            
            genre = new Genre();
            genre.setGenre("Drama");
            genre.insert();

            g = GenreFactory.findByGenreId(genre.getGenreId());
            System.out.println(g.getGenre());
            
            gs = GenreFactory.findByGenreAll();
            for (Genre g_s : gs) {
                System.out.println(g_s.getGenre());
            }
            
            movieGenre = new MovieGenre();
            movieGenre.setGenreId(genre.getGenreId());
            movieGenre.setMovieId(movie.getMovieId());
            movieGenre.insert();
            
            mg = MovieGenreFactory.findByMovieIdAndGenreId(movie.getMovieId(), genre.getGenreId());
            System.out.println(mg.getGenreId());
            
            mgs = MovieGenreFactory.findByMovieGenreAll();
            for (MovieGenre mg_s : mgs) {
                System.out.println(mg_s.getGenreId());
            }
            
            person = new Person();
            person.setName("Furkan");
            person.setSex('M');
            person.insert();
            
            p = PersonFactory.findByPersonId(person.getPersonId());
            System.out.println(p.getName());
            
            ps = PersonFactory.findByPersonAll();
            for (Person p_s : ps) {
                System.out.println(p_s.getName());
            }
            
            movie = new Movie();
            movie.setTitle("Speed");
            movie.setYear(2017);
            movie.setType('C');
            movie.insert();
            
            m = MovieFactory.findByMovieId(movie.getMovieId());
            System.out.println(m.getTitle());
            
            ms = MovieFactory.findByMovieAll();
            for (Movie m_s : ms) {
                System.out.println(m_s.getTitle());
            }
            
            chr = new MovieCharacter();
            chr.setMovieId(movie.getMovieId());
            chr.setPersonId(person.getPersonId());
            chr.setCharacter("Hauptrolle");
            chr.setAlias(null);
            chr.setPosition(1);
            chr.insert();
            
            mc = MovieCharacterFactory.findByMovieCharacterId(chr.getMovCharId());
            System.out.println(mc.getCharacter());
            
            mcs = MovieCharacterFactory.findByMovieCharacterAll();
            for (MovieCharacter mc_s : mcs) {
                System.out.println(mc_s.getCharacter());
            }
            
            genre = new Genre();
            genre.setGenre("Action");
            genre.insert();

            g = GenreFactory.findByGenreId(genre.getGenreId());
            System.out.println(g.getGenre());
            
            gs = GenreFactory.findByGenreAll();
            for (Genre g_s : gs) {
                System.out.println(g_s.getGenre());
            }
            
            movieGenre = new MovieGenre();
            movieGenre.setGenreId(genre.getGenreId());
            movieGenre.setMovieId(movie.getMovieId());
            movieGenre.insert();
            
            mg = MovieGenreFactory.findByMovieIdAndGenreId(movie.getMovieId(), genre.getGenreId());
            System.out.println(mg.getGenreId());
            
            mgs = MovieGenreFactory.findByMovieGenreAll();
            for (MovieGenre mg_s : mgs) {
                System.out.println(mg_s.getGenreId());
            }
            
            person = new Person();
            person.setName("Aland");
            person.setSex('F');
            person.insert();
            
            p = PersonFactory.findByPersonId(person.getPersonId());
            System.out.println(p.getName());
            
            ps = PersonFactory.findByPersonAll();
            for (Person p_s : ps) {
                System.out.println(p_s.getName());
            }
            
            movie = new Movie();
            movie.setTitle("Survivor");
            movie.setYear(2021);
            movie.setType('C');
            movie.insert();
            
            m = MovieFactory.findByMovieId(movie.getMovieId());
            System.out.println(m.getTitle());
            
            ms = MovieFactory.findByMovieAll();
            for (Movie m_s : ms) {
                System.out.println(m_s.getTitle());
            }
            
            chr = new MovieCharacter();
            chr.setMovieId(movie.getMovieId());
            chr.setPersonId(person.getPersonId());
            chr.setCharacter("Hauptrolle");
            chr.setAlias(null);
            chr.setPosition(1);
            chr.insert();
            
            mc = MovieCharacterFactory.findByMovieCharacterId(chr.getMovCharId());
            System.out.println(mc.getCharacter());
            
            mcs = MovieCharacterFactory.findByMovieCharacterAll();
            for (MovieCharacter mc_s : mcs) {
                System.out.println(mc_s.getCharacter());
            }
            
            genre = new Genre();
            genre.setGenre("Comedy");
            genre.insert();

            g = GenreFactory.findByGenreId(genre.getGenreId());
            System.out.println(g.getGenre());
            
            gs = GenreFactory.findByGenreAll();
            for (Genre g_s : gs) {
                System.out.println(g_s.getGenre());
            }
            
            movieGenre = new MovieGenre();
            movieGenre.setGenreId(genre.getGenreId());
            movieGenre.setMovieId(movie.getMovieId());
            movieGenre.insert();
            
            mg = MovieGenreFactory.findByMovieIdAndGenreId(movie.getMovieId(), genre.getGenreId());
            System.out.println(mg.getGenreId());
            
            mgs = MovieGenreFactory.findByMovieGenreAll();
            for (MovieGenre mg_s : mgs) {
                System.out.println(mg_s.getGenreId());
            }
            
            ConnectionManager.getConnection().commit();
        } finally {
            if (!ok)
                ConnectionManager.getConnection().rollback();
            }
        }
}
