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
public class Song {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false, unique = true)
    private Long songId;

    private String songName;

    @ManyToMany(mappedBy = "songList")
    private List<Songlist> songlistList;
}
