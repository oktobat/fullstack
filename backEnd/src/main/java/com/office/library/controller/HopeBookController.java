package com.office.library.controller;

import com.office.library.service.HopeBookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class HopeBookController {
    @Autowired
    private HopeBookService hopeBookService;

    @GetMapping("/getHopeBooks")
    public List<Map<String, String>> getHopeBooks() {
        List<Map<String, String>> list = hopeBookService.selectHopeBooks();
        return list;
    }

    @GetMapping("/deleteHopeBook")
    public String deleteHopeBook(@RequestParam("hbNo") int hb_no) {
        hopeBookService.hopeBookDelete(hb_no);
        String message = "삭제됨";
        return message;
    }

}
