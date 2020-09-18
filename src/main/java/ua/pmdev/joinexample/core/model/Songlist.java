package ua.pmdev.joinexample.core.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class Songlist {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "songListId", updatable = false, nullable = false, unique = true)
    private Long songListId;

    @Column(length = 45)
    private String OwnerId;

    @Column(length = 45, nullable = false)
    private String name;

    @Column(nullable = false)
    private boolean isPrivate;

    @ManyToMany( cascade = {
            CascadeType.PERSIST,
            CascadeType.MERGE
    })
    @JoinTable(
            name = "songlist_song"
            , joinColumns = {
            @JoinColumn(name = "songListId")
    }
            , inverseJoinColumns = {
            @JoinColumn(name = "songId")
    })
    private List<Song> songList;
}
