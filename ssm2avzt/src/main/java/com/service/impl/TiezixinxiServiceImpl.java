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


import com.dao.TiezixinxiDao;
import com.entity.TiezixinxiEntity;
import com.service.TiezixinxiService;
import com.entity.vo.TiezixinxiVO;
import com.entity.view.TiezixinxiView;

@Service("tiezixinxiService")
public class TiezixinxiServiceImpl extends ServiceImpl<TiezixinxiDao, TiezixinxiEntity> implements TiezixinxiService {
	

    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<TiezixinxiEntity> page = this.selectPage(
                new Query<TiezixinxiEntity>(params).getPage(),
                new EntityWrapper<TiezixinxiEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<TiezixinxiEntity> wrapper) {
		  Page<TiezixinxiView> page =new Query<TiezixinxiView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<TiezixinxiVO> selectListVO(Wrapper<TiezixinxiEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public TiezixinxiVO selectVO(Wrapper<TiezixinxiEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<TiezixinxiView> selectListView(Wrapper<TiezixinxiEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public TiezixinxiView selectView(Wrapper<TiezixinxiEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
