package ua.pmdev.joinexample.core;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import ua.pmdev.joinexample.core.model.Song;
import ua.pmdev.joinexample.core.model.Songlist;
import ua.pmdev.joinexample.core.repo.SongListRepository;

import java.util.Arrays;

@RestController
@RequiredArgsConstructor
public class TestRepository {

    private final SongListRepository songListRepository;

    @GetMapping("/test")
    public void TestInsertOfSong() {
        Song song = Song.builder()
                .songName("Song 1")
                .build();
        Song song1 = Song.builder()
                .songName("Song 2")
                .build();
        Songlist songlist = Songlist.builder()
                .isPrivate(true)
                .name("Test List with 2 Songs")
                .songList(Arrays.asList(song, song1))
                .build();
        songListRepository.saveAndFlush(songlist);
    }
}
