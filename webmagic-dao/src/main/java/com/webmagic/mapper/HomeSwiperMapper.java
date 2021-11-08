package com.webmagic.mapper;

import com.webmagic.model.HomeSwiper;
import java.util.List;

public interface HomeSwiperMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(HomeSwiper record);

    HomeSwiper selectByPrimaryKey(Integer id);

    List<HomeSwiper> selectAll();

    int updateByPrimaryKey(HomeSwiper record);
}