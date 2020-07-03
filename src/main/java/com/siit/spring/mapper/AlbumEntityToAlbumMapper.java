package com.siit.spring.mapper;

import com.siit.spring.domain.entity.AlbumEntity;
import com.siit.spring.domain.entity.SingerEntity;
import com.siit.spring.domain.model.Album;

import com.siit.spring.domain.model.Singer;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

import lombok.AllArgsConstructor;

@Component
@AllArgsConstructor
public class AlbumEntityToAlbumMapper implements Converter<AlbumEntity, Album> {

    private final SingerOnlyEntityToSingerMapper singerOnlyEntityToSingerMapper;

    @Override
    public Album convert(AlbumEntity source) {
        return Album.builder()
                    .id(source.getId())
                    .title(source.getTitle())
                    .singer(mapSinger(source.getSinger()))
                    .releaseDate(source.getReleaseDate())
                    .build();
    }

    private Singer mapSinger(SingerEntity singer) {
        return singerOnlyEntityToSingerMapper.convert(singer);
    }
}
