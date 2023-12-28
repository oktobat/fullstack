package com.office.library.service;

import com.office.library.dao.HopeBookDao;
import com.office.library.dto.HopeBookDto;
import com.office.library.entity.TblHopeBook;
import com.office.library.entity.TblPhotoReview;
import com.office.library.repository.HopeBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class HopeBookService {
    @Autowired
    HopeBookDao hopeBookDao;

    @Autowired
    HopeBookRepository hopeBookRepository;
    public List<HopeBookDto> selectHopeBooks(){
        List<HopeBookDto> list = hopeBookDao.selectHopeBooks();
        return list;
    }

    public TblHopeBook hopeBookDetail(Integer hb_no){
        return hopeBookRepository.findById(hb_no).get();
    }

    public void hopeBookDelete(Integer hb_no){
        hopeBookDao.deleteHopeBook(hb_no);
    }


    public TblHopeBook write(TblHopeBook tblHopeBook){
        return hopeBookRepository.save(tblHopeBook);
    }

    public void modifyHopeBook(HopeBookDto hopeBookDto){
        hopeBookDao.updateHopeBook(hopeBookDto);
    }

}
