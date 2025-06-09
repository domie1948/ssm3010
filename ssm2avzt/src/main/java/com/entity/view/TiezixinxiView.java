package com.entity.view;

import com.entity.TiezixinxiEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import org.apache.commons.beanutils.BeanUtils;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
 

/**
 * 帖子信息
 * 后端返回视图实体辅助类   
 * （通常后端关联的表或者自定义的字段需要返回使用）
 * @author 
 * @email 
 * @date 2021-04-17 14:10:17
 */
@TableName("tiezixinxi")
public class TiezixinxiView  extends TiezixinxiEntity implements Serializable {
	private static final long serialVersionUID = 1L;

	public TiezixinxiView(){
	}
 
 	public TiezixinxiView(TiezixinxiEntity tiezixinxiEntity){
 	try {
			BeanUtils.copyProperties(this, tiezixinxiEntity);
		} catch (IllegalAccessException | InvocationTargetException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
 		
	}
}
