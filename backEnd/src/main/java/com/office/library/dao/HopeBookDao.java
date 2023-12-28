package com.office.library.dao;

import com.office.library.dto.HopeBookDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface HopeBookDao {
    public List<HopeBookDto> selectHopeBooks();
    public void deleteHopeBook(Integer hb_no);
    public void updateHopeBook(HopeBookDto hopeBookDto);
}