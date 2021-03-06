package com.briup.jz.service;

import java.util.List;

import com.briup.jz.bean.Carousel;
import com.briup.jz.utils.CustomerException;

public interface ICarouselService {
	
	
    void saveOrUpdate(Carousel carousel) throws CustomerException;
	
	List<Carousel> query(String name,String introduce);
	
	void deleteById(long id) throws CustomerException;
}
