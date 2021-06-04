package com.briup.jz.service.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.briup.jz.bean.Carousel;
import com.briup.jz.bean.CarouselExample;
import com.briup.jz.dao.CarouselMapper;
import com.briup.jz.service.ICarouselService;
import com.briup.jz.utils.CustomerException;

@Service
public class CarouselServiceImpl implements ICarouselService{

	@Autowired
	public CarouselMapper carouselMapper;
	
	@Override
	public void saveOrUpdate(Carousel carousel) throws CustomerException {
		if(carousel.getId() == null) {
			// 初始化
			carousel.setStatus("正常");
			carouselMapper.insert(carousel);
		} else {
			carousel.setStatus("正常");
			carouselMapper.updateByPrimaryKey(carousel);
		}
		
	}

	@Override
	public List<Carousel> query(String name) {
		CarouselExample example = new CarouselExample();
		if(name!=null){
			example.createCriteria().andNameLike("%"+name+"%");
		}
		List<Carousel> list = carouselMapper.selectByExample(example);
		return list;
	}

	@Override
	public void deleteById(long id) throws CustomerException {
		Carousel carousel = carouselMapper.selectByPrimaryKey(id);
		if(carousel == null) {
			throw new CustomerException("要删除的分类信息不存在");
		}
		carouselMapper.deleteByPrimaryKey(id);
		
	}

}
