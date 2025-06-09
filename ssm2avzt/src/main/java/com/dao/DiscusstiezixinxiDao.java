package com.dao;

import com.entity.DiscusstiezixinxiEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusstiezixinxiVO;
import com.entity.view.DiscusstiezixinxiView;


/**
 * 帖子信息评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-17 14:10:18
 */
public interface DiscusstiezixinxiDao extends BaseMapper<DiscusstiezixinxiEntity> {
	
	List<DiscusstiezixinxiVO> selectListVO(@Param("ew") Wrapper<DiscusstiezixinxiEntity> wrapper);
	
	DiscusstiezixinxiVO selectVO(@Param("ew") Wrapper<DiscusstiezixinxiEntity> wrapper);
	
	List<DiscusstiezixinxiView> selectListView(@Param("ew") Wrapper<DiscusstiezixinxiEntity> wrapper);

	List<DiscusstiezixinxiView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusstiezixinxiEntity> wrapper);
	
	DiscusstiezixinxiView selectView(@Param("ew") Wrapper<DiscusstiezixinxiEntity> wrapper);
	
}
