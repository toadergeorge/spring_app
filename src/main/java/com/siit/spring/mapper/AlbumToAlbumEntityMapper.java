package com.siit.spring.mapper;

import com.siit.spring.domain.entity.AlbumEntity;
import com.siit.spring.domain.model.Album;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class AlbumToAlbumEntityMapper implements Converter<Album, AlbumEntity> {

    private final SingerToSingerEntityMapper singerToSingerEntityMapper;

    @Override
    public AlbumEntity convert(Album source) {
        return AlbumEntity.builder()
                .id(source.getId())
                .releaseDate(source.getReleaseDate())
                .singer(singerToSingerEntityMapper.convert(source.getSinger()))
                .title(source.getTitle())
                .build();
    }
}
