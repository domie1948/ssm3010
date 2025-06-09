package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscusstiezixinxiDao;
import com.entity.DiscusstiezixinxiEntity;
import com.service.DiscusstiezixinxiService;
import com.entity.vo.DiscusstiezixinxiVO;
import com.entity.view.DiscusstiezixinxiView;

@Service("discusstiezixinxiService")
public class DiscusstiezixinxiServiceImpl extends ServiceImpl<DiscusstiezixinxiDao, DiscusstiezixinxiEntity> implements DiscusstiezixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscusstiezixinxiEntity> page = this.selectPage(
                new Query<DiscusstiezixinxiEntity>(params).getPage(),
                new EntityWrapper<DiscusstiezixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscusstiezixinxiEntity> wrapper) {
		  Page<DiscusstiezixinxiView> page =new Query<DiscusstiezixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscusstiezixinxiVO> selectListVO(Wrapper<DiscusstiezixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscusstiezixinxiVO selectVO(Wrapper<DiscusstiezixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscusstiezixinxiView> selectListView(Wrapper<DiscusstiezixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscusstiezixinxiView selectView(Wrapper<DiscusstiezixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
