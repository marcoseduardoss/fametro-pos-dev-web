package br.edu.unifametro.myproj.v1.xpto.mapper;

import java.util.List;

import br.edu.unifametro.myproj.v1.xpto.dto.XptoDto;
import br.edu.unifametro.myproj.v1.xpto.model.Xpto;

public class XptoDtoMapper {

    public static XptoDto toDto(Xpto xpto) {
        XptoDto dto = new XptoDto();
        dto.setId(xpto.getId());
        dto.setValor1(xpto.getValor1());
        dto.setValor2(xpto.getValor2());
        dto.setValor3(xpto.getValor3());
        return dto;
    }
    
    public static Xpto fromDto(XptoDto dto) {
        Xpto xpto = new Xpto();
        xpto.setId(dto.getId());
        xpto.setValor1(dto.getValor1());
        xpto.setValor2(dto.getValor2());
        xpto.setValor3(dto.getValor3());
        return xpto;
    }

    public static List<XptoDto> toDtoList(List<Xpto> xptos) {
        return xptos.stream()
                .map(XptoDtoMapper::toDto)
                .toList();
    }

    public static List<Xpto> fromDtoList(List<XptoDto> dtos) {
        return dtos.stream()
                .map(XptoDtoMapper::fromDto)
                .toList();
    }
}
