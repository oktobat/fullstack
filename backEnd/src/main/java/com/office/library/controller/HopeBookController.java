package com.office.library.controller;

import com.office.library.dto.HopeBookDto;
import com.office.library.entity.TblHopeBook;
import com.office.library.entity.TblPhotoReview;
import com.office.library.service.HopeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@CrossOrigin(origins = "http://localhost:8800")
@RequestMapping("/api")
public class HopeBookController {
    @Autowired
    private HopeBookService hopeBookService;

    @GetMapping("/getHopeBooks")
    public List<HopeBookDto> getHopeBooks() {
        List<HopeBookDto> list = hopeBookService.selectHopeBooks();
        return list;
    }

    @GetMapping("/deleteHopeBook")
    public String deleteHopeBook(@RequestParam("hbNo") int hb_no) {
        hopeBookService.hopeBookDelete(hb_no);
        String message = "삭제됨";
        return message;
    }

    @PostMapping("/registerHopeBookConfirm")
    public String registerHopeBookConfirm(@RequestBody TblHopeBook tblHopeBook) {
        hopeBookService.write(tblHopeBook);
        String message = "성공";
        return message;
    }

    @PostMapping("/updateHopeBookConfirm")
    public String updateHopeBookConfirm(@RequestBody HopeBookDto hopeBookDto) {
        System.out.println(hopeBookDto);
        hopeBookService.modifyHopeBook(hopeBookDto);
        String message = "성공";
        return message;
    }


}
