package br.edu.unifametro.myproj.v1.xpto.mapper;

import java.util.List;

import br.edu.unifametro.myproj.v1.xpto.dto.XptoDto;
import br.edu.unifametro.myproj.v1.xpto.model.Xpto;

public class XptoDtoMapper {

    public static XptoDto toDto(Xpto in) {
        XptoDto out = new XptoDto();
        out.setId(in.getId());
        out.setValor1(in.getValor1());
        out.setValor2(in.getValor2());
        out.setValor3(in.getValor3());
        return out;
    }
    
    public static Xpto fromDto(XptoDto in) { 
        Xpto out = new Xpto();
        out.setId(in.getId());
        out.setValor1(in.getValor1());
        out.setValor2(in.getValor2());
        out.setValor3(in.getValor3());
        return out;
    }

    public static List<XptoDto> toDtoList(List<Xpto> list) {
        return list.stream()
                .map(XptoDtoMapper::toDto)
                .toList();
    }

    public static List<Xpto> fromDtoList(List<XptoDto> list) {
        return list.stream()
                .map(XptoDtoMapper::fromDto)
                .toList();
    }
}
