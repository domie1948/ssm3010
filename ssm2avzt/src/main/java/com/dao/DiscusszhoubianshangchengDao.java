package com.dao;

import com.entity.DiscusszhoubianshangchengEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.vo.DiscusszhoubianshangchengVO;
import com.entity.view.DiscusszhoubianshangchengView;


/**
 * 周边商城评论表
 * 
 * @author 
 * @email 
 * @date 2021-04-17 14:10:18
 */
public interface DiscusszhoubianshangchengDao extends BaseMapper<DiscusszhoubianshangchengEntity> {
	
	List<DiscusszhoubianshangchengVO> selectListVO(@Param("ew") Wrapper<DiscusszhoubianshangchengEntity> wrapper);
	
	DiscusszhoubianshangchengVO selectVO(@Param("ew") Wrapper<DiscusszhoubianshangchengEntity> wrapper);
	
	List<DiscusszhoubianshangchengView> selectListView(@Param("ew") Wrapper<DiscusszhoubianshangchengEntity> wrapper);

	List<DiscusszhoubianshangchengView> selectListView(Pagination page,@Param("ew") Wrapper<DiscusszhoubianshangchengEntity> wrapper);
	
	DiscusszhoubianshangchengView selectView(@Param("ew") Wrapper<DiscusszhoubianshangchengEntity> wrapper);
	
}
