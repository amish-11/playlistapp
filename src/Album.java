import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Album {
    private String artist;
    private String name;
    private List<Song> songs;

    public Album() {
    }

    public Album(String artist, String name) {
        this.artist = artist;
        this.name = name;
        this.songs = new ArrayList<>(); //if not present then null point exception
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Song> getSongs() {
        return songs;
    }

    public void setSongs(List<Song> songs) {
        this.songs = songs;
    }

    //functionalities in the album

    boolean findSong(String title){
        for (Song song: songs){
            if(song.getTitle().equals(title)){  //if we use == instead of .equals it will compare addresses instead of values
           return true;
            }
        }
        return false;
    }

    // add song

    public String addSongToAlbum(String title,double duration){
        if(!findSong(title)){
            //add
            Song song = new Song(title,duration);
            this.songs.add(song);
        }
        return "Song already exists.";
    }

    // add to playlist from album

    public String addToPlaylistFromAlbum(String title, LinkedList<Song> playList){
            //add in playlist
            for (Song song: this.songs) {
                if (song.getTitle().equals(title)) {
                    playList.add(song);
                    return "Song has been added to your playlist.";
                }
            }
        return "Song doesn't exists in album.";
    }

    /**
     * polymorphism method overloading
     * @param songNo
     * @param playList
     * @return
     */
    public String addToPlaylistFromAlbum(int songNo,LinkedList<Song> playList){
        int index = songNo - 1;
        if(index>=0 && index<songs.size()){
            playList.add(songs.get(index));
            return "Song has been added successfully.";
        }
        return "Incorrect song number!!";
    }
}
