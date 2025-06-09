package com.service;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.DiscusstiezixinxiEntity;
import java.util.List;
import java.util.Map;
import com.entity.vo.DiscusstiezixinxiVO;
import org.apache.ibatis.annotations.Param;
import com.entity.view.DiscusstiezixinxiView;


/**
 * 帖子信息评论表
 *
 * @author 
 * @email 
 * @date 2021-04-17 14:10:18
 */
public interface DiscusstiezixinxiService extends IService<DiscusstiezixinxiEntity> {

    PageUtils queryPage(Map<String, Object> params);
    
   	List<DiscusstiezixinxiVO> selectListVO(Wrapper<DiscusstiezixinxiEntity> wrapper);
   	
   	DiscusstiezixinxiVO selectVO(@Param("ew") Wrapper<DiscusstiezixinxiEntity> wrapper);
   	
   	List<DiscusstiezixinxiView> selectListView(Wrapper<DiscusstiezixinxiEntity> wrapper);
   	
   	DiscusstiezixinxiView selectView(@Param("ew") Wrapper<DiscusstiezixinxiEntity> wrapper);
   	
   	PageUtils queryPage(Map<String, Object> params,Wrapper<DiscusstiezixinxiEntity> wrapper);
   	
}

