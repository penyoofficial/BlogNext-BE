package com.penyo.penyoboot.utils;

import cn.hutool.core.date.DateUtil;
import com.penyo.penyoboot.model.form.ArticlesForm;
import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * @description:日期工具
 * @author: 顾壮壮
 * @date: 2023/7/26 11:12
 */
@Slf4j
public class CalendarUtil {

    /**
     * 得到真实起始日期
     *
     * @param from 起始日期
     * @return {@link Date}
     */
    public static Date getDateFrom(String from){
        String[] split = from.split("-");
        Date dateTo=null;
        switch (split.length){
            case 1:
                dateTo = new GregorianCalendar(Integer.parseInt(split[0]), Calendar.JANUARY, 1).getTime();
                dateTo = DateUtil.parse(DateUtil.formatDateTime(dateTo));
                log.info("起始时间："+dateTo);
                break;

            case 2:
                dateTo=new GregorianCalendar(Integer.parseInt(split[0]), Integer.parseInt(split[1])-1, 1).getTime();
                dateTo = DateUtil.parse(DateUtil.formatDateTime(dateTo));
                log.info("起始时间："+dateTo);
                break;

            case 3:
                dateTo=DateUtil.parseDate(from);
                dateTo = DateUtil.parse(DateUtil.formatDateTime(dateTo));
                log.info("起始时间："+dateTo);
                break;

        }
        return dateTo;
    }

    public static Date getDateTo(String to){
        String[] split = to.split("-");
        Date dateTo=null;
        switch (split.length){
            case 1:
                dateTo = new GregorianCalendar(Integer.parseInt(split[0]), Calendar.DECEMBER, 31).getTime();
                dateTo = DateUtil.endOfDay(dateTo);
                log.info("结束时间："+dateTo);
                break;

            case 2:
                dateTo=new GregorianCalendar(Integer.parseInt(split[0]),
                        Integer.parseInt(split[1])-1,
                        1).getTime();
                dateTo=DateUtil.endOfMonth(dateTo);
                dateTo = DateUtil.endOfDay(dateTo);
                log.info("结束时间："+dateTo);
                break;

            case 3:
                dateTo=DateUtil.parseDate(to);
                dateTo =DateUtil.endOfDay(dateTo);
                log.info("起始时间："+dateTo);
                break;

        }
        return dateTo;
    }
}
