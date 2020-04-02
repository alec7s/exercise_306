package com.ae.exercise_306;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashSet;
import java.util.Set;

@Controller
public class HomeController {

    @Autowired
    AlbumRepository albumRepository;

    @RequestMapping("/")
    public String index(Model model){
        //create album
        Album album = new Album();

        album.setName("The Slow Rush");
        album.setYear(2020);

        //create song
        Song song = new Song();
        song.setTitle("One More Year");

        //add the song to empty list
        Set<Song> songs = new HashSet<Song>();
        songs.add(song);

        song = new Song();
        song.setTitle("One More Hour");
        songs.add(song);

        //add list of songs to album
        album.setSongs(songs);

        //save the album to the database
        albumRepository.save(album);

        //send albums to template
        model.addAttribute("albums", albumRepository.findAll());
        return "index";
    }

}
