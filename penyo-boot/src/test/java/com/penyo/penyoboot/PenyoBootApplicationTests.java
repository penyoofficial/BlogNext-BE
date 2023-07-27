package com.penyo.penyoboot;

import cn.hutool.core.date.DateUnit;
import cn.hutool.core.date.DateUtil;
import com.penyo.penyoboot.model.form.ArticlesForm;
import com.penyo.penyoboot.utils.CalendarUtil;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

@SpringBootTest
@Slf4j
class PenyoBootApplicationTests {

    @Test
    void testRegex() {
        ArticlesForm articlesForm=new ArticlesForm("11","2018-1","2019-12-9","语录","雏鹰未来",5);
        String[] split = articlesForm.getFrom().split("-");
        switch (split.length){
            case 1:
                System.out.println(1); break;
            case 2:
                System.out.println(2);break;
            case 3:
                System.out.println(3);break;
        }
        boolean matches = articlesForm.getFrom().matches("^\\d{4}(-\\d{2}(-\\d{2}))$");
    }
    @Test
    void testDate() {
        Date datefrom = CalendarUtil.getDateFrom("2019-2-8");
        log.info(datefrom.toString());
        Date dateto = CalendarUtil.getDateTo("2016-2");
        log.info(dateto.toString());
    }

}
